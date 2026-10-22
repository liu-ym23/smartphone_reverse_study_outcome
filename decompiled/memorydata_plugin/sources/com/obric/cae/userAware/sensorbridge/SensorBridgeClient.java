package com.obric.cae.userAware.sensorbridge;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import com.obric.cae.libs.utils.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import vendor.aware.sensorbridge.SensorBridgeBatch;
import vendor.aware.sensorbridge.SensorBridgeDelivery;
import vendor.aware.sensorbridge.SensorBridgeEvent;
import vendor.aware.sensorbridge.SensorBridgeRequest;
import vendor.aware.sensorbridge.SensorBridgeSensor;
import vendor.aware.sensorbridge.SensorBridgeSubscription;
import vendor.aware.sensorbridge.a;
import vendor.aware.sensorbridge.b;

/* JADX INFO: loaded from: classes3.dex */
public final class SensorBridgeClient {
    private static final int CLIENT_PROCESSOR_APSS = 1;
    private static final int DELIVERY_WAKEUP = 0;
    private static final byte[] EMPTY_BYTE_ARRAY = null;
    private static final int[] EMPTY_INT_ARRAY = null;
    private static final long RECONNECT_DELAY_MS = 1000;
    private static final String SERVICE_NAME = "vendor.aware.sensorbridge.ISensorBridgeService/default";
    private static final String TAG = "SensorBridgeClient";
    private final a mCallback;
    private int mClientId;
    private final Runnable mConnectTask;
    private final Context mContext;
    private final IBinder.DeathRecipient mDeathRecipient;
    private final Handler mHandler;
    private final Listener mListener;
    private final Object mLock;
    private final Map<String, SensorBridgeSensor> mSensors;
    private b mService;
    private IBinder mServiceBinder;
    private boolean mStarted;
    private final HandlerThread mThread;

    /* JADX INFO: renamed from: com.obric.cae.userAware.sensorbridge.SensorBridgeClient$1, reason: invalid class name */
    public class AnonymousClass1 extends a.AbstractBinderC0908a {
        final /* synthetic */ SensorBridgeClient this$0;

        public AnonymousClass1(SensorBridgeClient r1) {
            this.this$0 = r1;
            markVintfStability();
        }

        public /* synthetic */ void lambda$onSensorBridgeError$1$SensorBridgeClient$1(int r4, int r5, String r6) {
            SensorBridgeClient.access$100(this.this$0).onError(com.obric.cae.location.b.a("sensorbridge error clientId=", r4, " code=", r5, ": ").append(r6).toString(), null);
        }

        public /* synthetic */ void lambda$onSensorBridgeEvents$0$SensorBridgeClient$1(SensorBridgeEvent[] r1) {
            SensorBridgeClient.access$100(this.this$0).onEvents(r1);
        }

        @Override // vendor.aware.sensorbridge.a
        public void onSensorBridgeError(final int r3, final int r4, final String r5) {
            SensorBridgeClient.access$000(this.this$0).post(new $$Lambda$SensorBridgeClient$1$dydAp1ua5QEPo7DSjEGrFvfbjM(this, r3, r4, r5));
        }

        @Override // vendor.aware.sensorbridge.a
        public void onSensorBridgeEvents(final SensorBridgeEvent[] r3) {
            SensorBridgeClient.access$000(this.this$0).post(new $$Lambda$SensorBridgeClient$1$TIh76B5NzL8pCPNWZjj67sLAj7Q(this, r3));
        }
    }

    public interface Listener {
        void onConnected(int r1);

        void onDisconnected();

        void onError(String r1, Throwable r2);

        void onEvents(SensorBridgeEvent[] r1);
    }

    static {
        EMPTY_INT_ARRAY = new int[0];
        EMPTY_BYTE_ARRAY = new byte[0];
    }

    public SensorBridgeClient(Context r4, Listener r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Listener r7 = (Listener) ZeusTransformUtils.wrapperContextForParams(r5, Listener.class, "com.obric.memorydata.plugin");
        this.mLock = new Object();
        this.mConnectTask = new $$Lambda$SensorBridgeClient$dykcxNg0GhkWIRrLxGLRFaxADRw(this);
        this.mSensors = new HashMap();
        this.mDeathRecipient = new $$Lambda$SensorBridgeClient$Rj23ml2ZOcuLTKyfiX7jHuKdyU0(this);
        this.mCallback = new AnonymousClass1(this);
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r6, "context"), Context.class, "com.obric.memorydata.plugin")).getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        r6 = r0;
    L5:
        this.mContext = ZeusTransformUtils.wrapperContext(r6, "com.obric.memorydata.plugin");
        this.mListener = (Listener) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r7, "listener"), Listener.class, "com.obric.memorydata.plugin");
        HandlerThread r8 = new HandlerThread(TAG);
        this.mThread = r8;
        r8.start();
        this.mHandler = new Handler(r8.getLooper());
    }

    public static /* synthetic */ Handler access$000(SensorBridgeClient r0) {
        return r0.mHandler;
    }

    public static /* synthetic */ Listener access$100(SensorBridgeClient r0) {
        return r0.mListener;
    }

    private void clearServiceLocked() {
        IBinder r0 = this.mServiceBinder;
        if (r0 != null) goto L8;
    L5:
        this.mService = null;
        this.mServiceBinder = null;
        this.mClientId = 0;
        Handler r1 = this.mHandler;
        final Map<String, SensorBridgeSensor> r3 = this.mSensors;
        Objects.requireNonNull(r3);
        r1.post(new $$Lambda$tk9B7fBS_q3yx7fJTd0is28lCWg(r3));
        return;
    L8:
        r0.unlinkToDeath(this.mDeathRecipient, 0);     // Catch: Throwable -> L7
        goto L5
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [vendor.aware.sensorbridge.b] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4, types: [vendor.aware.sensorbridge.b] */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    private void connect() {
        Object r2 = this.mLock;
        monitor-enter(r2);
    L81:
        th = move-exception;
        throw th;
    L5:
        if (this.mStarted == true) goto L7;
    L79:
        monitor-exit(r2);     // Catch: Throwable -> L81
        return;
    L7:
        if (this.mService != null) goto L79;
        monitor-exit(r2);     // Catch: Throwable -> L81
        IBinder r3 = getSensorBridgeServiceBinder();
        if (r3 != null) goto L14;
        scheduleConnect();
        return;
    L14:
        ?? r4 = 0;
        r4 = 0;
        boolean r5 = true;
        r3.linkToDeath(this.mDeathRecipient, 0);     // Catch: Throwable -> L67
        r4 = b.a.a(r3);     // Catch: Throwable -> L65
        if (r4 != 0) goto L23;
        r3.unlinkToDeath(this.mDeathRecipient, 0);     // Catch: Throwable -> L63
        scheduleConnect();     // Catch: Throwable -> L21
        return;
    L21:
        th = th;
        boolean r1 = false;
        r5 = false;
        int r7 = 0;
        r4 = r4;
        r4 = 0;
    L69:
        if (r5 == true) goto L75;
        if (r1 == false) goto L73;
        if (r4 == 0) goto L73;
        r4.a(r7);     // Catch: Throwable -> L84
    L73:
        if (r4 == 0) goto L75;
        r3.unlinkToDeath(this.mDeathRecipient, 0);     // Catch: Throwable -> L85
    L75:
        this.mListener.onError("failed to connect sensorbridge", th);
        if (r5 == true) goto L120;
        scheduleConnect();
        return;
    L120:
        return;
    L23:
        r7 = r4.a(this.mContext.getPackageName(), this.mCallback);     // Catch: Throwable -> L63
        if (r7 > 0) goto L117;
        r3.unlinkToDeath(this.mDeathRecipient, 0);     // Catch: Throwable -> L30
        this.mListener.onError("sensorbridge returned invalid clientId=" + r7, null);     // Catch: Throwable -> L28
        scheduleConnect();     // Catch: Throwable -> L28
        return;
    L28:
        th = th;
        r1 = false;
        r5 = false;
        r4 = 0;
    L92:
    L30:
        th = th;
        r1 = false;
        r4 = 1;
        r5 = false;
        goto L92
    L117:
        Object r6 = this.mLock;     // Catch: Throwable -> L61
        monitor-enter(r6);     // Catch: Throwable -> L61
    L53:
        th = th;
        boolean r8 = true;
        boolean r9 = false;
    L115:
        monitor-exit(r6);     // Catch: Throwable -> L59
        throw th;     // Catch: Throwable -> L57
    L57:
        th = th;
        r1 = r8;
        r4 = r5;
        r5 = r9;
    L59:
        th = th;
        goto L115
    L35:
        if (this.mStarted == true) goto L45;
        r4.a(r7);     // Catch: Throwable -> L53
        r3.unlinkToDeath(this.mDeathRecipient, 0);     // Catch: Throwable -> L42
        monitor-exit(r6);     // Catch: Throwable -> L40
        return;
    L40:
        th = th;
        r5 = false;
    L43:
        r8 = false;
    L44:
        r9 = r8;
    L42:
        th = th;
        goto L43
    L45:
        this.mService = r4;     // Catch: Throwable -> L53
        this.mServiceBinder = r3;     // Catch: Throwable -> L53
        this.mClientId = r7;     // Catch: Throwable -> L53
        monitor-exit(r6);     // Catch: Throwable -> L51
        com.obric.cae.log.a.e(TAG, "connected clientId=" + r7);     // Catch: Throwable -> L49
        this.mListener.onConnected(r7);     // Catch: Throwable -> L49
        return;
    L49:
        th = th;
        r1 = true;
        r4 = 1;
    L51:
        th = th;
        r8 = true;
    L61:
        th = th;
        r1 = true;
        r4 = 1;
        r5 = false;
    L63:
        th = th;
        r1 = false;
        r7 = 0;
        r4 = r4;
        r4 = r5;
        r5 = false;
    L65:
        th = th;
        r4 = 1;
        r1 = false;
        r5 = false;
        r7 = 0;
    L67:
        th = th;
        r1 = false;
        r5 = false;
        r4 = 0;
        r7 = 0;
        goto L69
    }

    private void flushInternal(String r7) {
        Object r2 = this.mLock;
        monitor-enter(r2);
        b r3 = this.mService;     // Catch: Throwable -> L16
        int r4 = this.mClientId;     // Catch: Throwable -> L16
        monitor-exit(r2);     // Catch: Throwable -> L16
        if (r3 == null) goto L14;
        if (r4 <= 0) goto L14;
        com.obric.cae.log.a.e(TAG, "debug flush start clientId=" + r4 + " sensor=" + r7);     // Catch: Throwable -> L11
        r3.a(r4, resolveSensor(r3, r7));     // Catch: Throwable -> L11
        com.obric.cae.log.a.e(TAG, "debug flush done clientId=" + r4 + " sensor=" + r7);     // Catch: Throwable -> L11
        return;
    L11:
        e = move-exception;
        this.mListener.onError("failed to flush sensor=" + r7, e);
        return;
    L14:
        this.mListener.onError("sensorbridge is not connected", null);
        return;
    L16:
        th = move-exception;
        throw th;
    }

    private IBinder getSensorBridgeServiceBinder() {
        Object r2 = ServiceManager.class.getMethod("waitForDeclaredService", new Class[]{String.class}).invoke(null, new Object[]{SERVICE_NAME});     // Catch: Throwable -> L10
        if (ZeusTransformUtils.instanceOf(r2, IBinder.class) == true) goto L6;
        if (r2 == null) goto L13;
        com.obric.cae.log.a.g(TAG, "waitForDeclaredService returned non-binder: ".concat(r2.getClass().getName()));     // Catch: Throwable -> L10
    L13:
        return ServiceManager.getService(SERVICE_NAME);
    L6:
        return (IBinder) ZeusTransformUtils.preCheckCast(r2, IBinder.class, "com.obric.memorydata.plugin");
    L10:
        e = move-exception;
        com.obric.cae.log.a.g(TAG, "waitForDeclaredService failed, fallback getService: " + e.getMessage());
        goto L13
    }

    public static /* synthetic */ void lambda$dykcxNg0GhkWIRrLxGLRFaxADRw(SensorBridgeClient r0) {
        r0.connect();
    }

    private void notifyDisconnected() {
        Handler r0 = this.mHandler;
        final Listener r2 = this.mListener;
        Objects.requireNonNull(r2);
        r0.post(new $$Lambda$ARXo2O3z6ZttCsxnCsRaqtf1Ok(r2));
    }

    private SensorBridgeSensor resolveSensor(b r4, String r5) {
        b r6 = (b) ZeusTransformUtils.wrapperContextForParams(r4, b.class, "com.obric.memorydata.plugin");
        SensorBridgeSensor r0 = (SensorBridgeSensor) ZeusTransformUtils.preCheckCast(this.mSensors.get(r5), SensorBridgeSensor.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L9;
        r0 = r6.a(r5);
        if (r0 == null) goto L8;
        this.mSensors.put(r5, r0);
        goto L9
    L8:
        throw new IllegalStateException(h.a("resolveSensor returned null for ", r5));
    L9:
        return r0;
    }

    private void scheduleConnect() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mStarted == true) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L11
        this.mHandler.removeCallbacks(this.mConnectTask);
        this.mHandler.postDelayed(this.mConnectTask, 1000);
    }

    private void sendRequestInternal(String r7, int r8, byte[] r9, int r10, int r11) {
        Object r2 = this.mLock;
        monitor-enter(r2);
        b r3 = this.mService;     // Catch: Throwable -> L20
        int r4 = this.mClientId;     // Catch: Throwable -> L20
        monitor-exit(r2);     // Catch: Throwable -> L20
        if (r3 == null) goto L18;
        if (r4 <= 0) goto L18;
        SensorBridgeRequest r5 = new SensorBridgeRequest();     // Catch: Throwable -> L15
        r5.sensor = resolveSensor(r3, r7);     // Catch: Throwable -> L15
        r5.messageId = r8;     // Catch: Throwable -> L15
        if (r9 != null) goto L13;
        r9 = EMPTY_BYTE_ARRAY;     // Catch: Throwable -> L15
    L13:
        r5.payload = r9;     // Catch: Throwable -> L15
        r5.requestId = r10;     // Catch: Throwable -> L15
        r5.requestScope = r11;     // Catch: Throwable -> L15
        SensorBridgeDelivery r12 = new SensorBridgeDelivery();     // Catch: Throwable -> L15
        r5.delivery = r12;     // Catch: Throwable -> L15
        r12.clientProcessor = 1;     // Catch: Throwable -> L15
        r12.deliveryType = 0;     // Catch: Throwable -> L15
        r12.noWakeupMessageIds = EMPTY_INT_ARRAY;     // Catch: Throwable -> L15
        r5.batch = new SensorBridgeBatch();     // Catch: Throwable -> L15
        com.obric.cae.log.a.e(TAG, "debug sendRequest start clientId=" + r4 + " sensor=" + r7 + " messageId=" + r8 + " requestId=" + r10 + " scope=" + r11 + " payloadLen=" + r5.payload.length);     // Catch: Throwable -> L15
        r3.a(r4, r5);     // Catch: Throwable -> L15
        com.obric.cae.log.a.e(TAG, "debug sendRequest done clientId=" + r4 + " sensor=" + r7 + " messageId=" + r8 + " requestId=" + r10);     // Catch: Throwable -> L15
        return;
    L15:
        e = move-exception;
        this.mListener.onError("failed to send request sensor=" + r7 + " messageId=" + r8, e);
        return;
    L18:
        this.mListener.onError("sensorbridge is not connected", null);
        return;
    L20:
        th = move-exception;
        throw th;
    }

    private void subscribeInternal(String r8, int[] r9, int r10, int[] r11, byte[] r12) {
        Object r2 = this.mLock;
        monitor-enter(r2);
        b r3 = this.mService;     // Catch: Throwable -> L24
        int r4 = this.mClientId;     // Catch: Throwable -> L24
        monitor-exit(r2);     // Catch: Throwable -> L24
        if (r3 == null) goto L22;
        if (r4 <= 0) goto L22;
        SensorBridgeSensor r5 = resolveSensor(r3, r8);     // Catch: Throwable -> L19
        SensorBridgeSubscription r6 = new SensorBridgeSubscription();     // Catch: Throwable -> L19
        r6.sensor = r5;     // Catch: Throwable -> L19
        r6.eventMessageIds = r9;     // Catch: Throwable -> L19
        SensorBridgeDelivery r7 = new SensorBridgeDelivery();     // Catch: Throwable -> L19
        r6.delivery = r7;     // Catch: Throwable -> L19
        r7.clientProcessor = 1;     // Catch: Throwable -> L19
        r7.deliveryType = r10;     // Catch: Throwable -> L19
        if (r11 != null) goto L13;
        r11 = EMPTY_INT_ARRAY;     // Catch: Throwable -> L19
    L13:
        r7.noWakeupMessageIds = r11;     // Catch: Throwable -> L19
        r6.batch = new SensorBridgeBatch();     // Catch: Throwable -> L19
        if (r12 != null) goto L17;
        r12 = EMPTY_BYTE_ARRAY;     // Catch: Throwable -> L19
    L17:
        r6.payload = r12;     // Catch: Throwable -> L19
        com.obric.cae.log.a.e(TAG, "debug subscribe start clientId=" + r4 + " sensor=" + r8 + " eventIds=" + r9.length + " noWakeupIds=" + r6.delivery.noWakeupMessageIds.length + " payloadLen=" + r6.payload.length);     // Catch: Throwable -> L19
        r3.a(r4, r6);     // Catch: Throwable -> L19
        com.obric.cae.log.a.e(TAG, "debug subscribe done clientId=" + r4 + " sensor=" + r8);     // Catch: Throwable -> L19
        return;
    L19:
        e = move-exception;
        this.mListener.onError("failed to subscribe sensor=" + r8, e);
        return;
    L22:
        this.mListener.onError("sensorbridge is not connected", null);
        return;
    L24:
        th = move-exception;
        throw th;
    }

    private void unregisterAndClearLocked() {
        b r0 = this.mService;
        if (r0 == null) goto L10;
        int r1 = this.mClientId;
        if (r1 <= 0) goto L10;
        r0.a(r1);     // Catch: RemoteException -> L8
    L8:
        e = move-exception;
        com.obric.cae.log.a.g(TAG, "unregisterClient failed: " + e.getMessage());
    L10:
        clearServiceLocked();
    }

    public void flush(final String r3) {
        this.mHandler.post(new $$Lambda$SensorBridgeClient$EjV9FWgTQHwD3_5OZ4vw0W1TpBw(this, r3));
    }

    public /* synthetic */ void lambda$flush$4$SensorBridgeClient(String r1) {
        flushInternal(r1);
    }

    public /* synthetic */ void lambda$new$0$SensorBridgeClient() {
        com.obric.cae.log.a.g(TAG, "sensorbridge service died");
        Object r0 = this.mLock;
        monitor-enter(r0);
        clearServiceLocked();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        notifyDisconnected();
        scheduleConnect();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public /* synthetic */ void lambda$sendRequest$3$SensorBridgeClient(String r1, int r2, byte[] r3, int r4, int r5) {
        sendRequestInternal(r1, r2, r3, r4, r5);
    }

    public /* synthetic */ void lambda$stop$1$SensorBridgeClient() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        unregisterAndClearLocked();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        this.mThread.quitSafely();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public /* synthetic */ void lambda$subscribe$2$SensorBridgeClient(String r1, int[] r2, int r3, int[] r4, byte[] r5) {
        subscribeInternal(r1, r2, r3, r4, r5);
    }

    public void sendRequest(final String r10, final int r11, final byte[] r12, final int r13, final int r14) {
        this.mHandler.post(new $$Lambda$SensorBridgeClient$1GLepVkqEWlXrEcWQzsAPdNRUMg(this, r10, r11, r12, r13, r14));
    }

    public void start() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.mStarted == false) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L8:
        this.mStarted = true;     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        this.mHandler.post(this.mConnectTask);
    }

    public void stop() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mStarted = false;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler.post(new $$Lambda$SensorBridgeClient$ILNo_LILutZMUppahzgWUvVX6hw(this));
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void subscribe(String r7, int[] r8) {
        subscribe(r7, r8, 0, EMPTY_INT_ARRAY, EMPTY_BYTE_ARRAY);
    }

    public void subscribe(final String r10, final int[] r11, final int r12, final int[] r13, final byte[] r14) {
        this.mHandler.post(new $$Lambda$SensorBridgeClient$Q6EdM8Z3zn42mjgjsDpxqvz4EI(this, r10, r11, r12, r13, r14));
    }

    public void subscribe(String r7, int[] r8, int[] r9) {
        subscribe(r7, r8, 0, r9, EMPTY_BYTE_ARRAY);
    }

    public void subscribe(String r7, int[] r8, int[] r9, byte[] r10) {
        subscribe(r7, r8, 0, r9, r10);
    }
}
