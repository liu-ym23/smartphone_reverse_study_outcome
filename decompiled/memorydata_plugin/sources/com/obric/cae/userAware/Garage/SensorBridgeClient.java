package com.obric.cae.userAware.Garage;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
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
final class SensorBridgeClient {
    private static final int CLIENT_PROCESSOR_APSS = 1;
    private static final int DELIVERY_WAKEUP = 0;
    private static final byte[] EMPTY_BYTE_ARRAY = null;
    private static final int[] EMPTY_INT_ARRAY = null;
    private static final long RECONNECT_DELAY_MS = 1000;
    private static final int REQUEST_SCOPE_COMMAND = 4;
    private static final String SERVICE_NAME = "vendor.aware.sensorbridge.ISensorBridgeService/default";
    private static final String TAG = "GarageSensorBridge";
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
    private final Runnable mSubscribeTask;
    private int[] mSubscriptionEventIds;
    private String mSubscriptionSensorName;
    private final HandlerThread mThread;

    /* JADX INFO: renamed from: com.obric.cae.userAware.Garage.SensorBridgeClient$1, reason: invalid class name */
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
            SensorBridgeClient.access$000(this.this$0).post(new $$Lambda$SensorBridgeClient$1$pYZ6dEeaLYI8dSuHHJH3ytmFt78(this, r3, r4, r5));
        }

        @Override // vendor.aware.sensorbridge.a
        public void onSensorBridgeEvents(final SensorBridgeEvent[] r3) {
            SensorBridgeClient.access$000(this.this$0).post(new $$Lambda$SensorBridgeClient$1$LuWNEBTjgzZS7uW58Mu0I24LY(this, r3));
        }
    }

    public interface Listener {
        void onConnected();

        void onDisconnected();

        void onError(String r1, Throwable r2);

        void onEvents(SensorBridgeEvent[] r1);

        void onSubscribed();
    }

    static {
        EMPTY_INT_ARRAY = new int[0];
        EMPTY_BYTE_ARRAY = new byte[0];
    }

    public SensorBridgeClient(Context r4, Listener r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Listener r7 = (Listener) ZeusTransformUtils.wrapperContextForParams(r5, Listener.class, "com.obric.memorydata.plugin");
        this.mLock = new Object();
        this.mSensors = new HashMap();
        this.mSubscriptionEventIds = EMPTY_INT_ARRAY;
        this.mConnectTask = new $$Lambda$SensorBridgeClient$3t5ZtwHIXniYEvu8B797stF5L8(this);
        this.mSubscribeTask = new $$Lambda$SensorBridgeClient$22CkFmWnkbkjma3g1ND_RA4AL5w(this);
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r6), Context.class, "com.obric.memorydata.plugin")).getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        r6 = r0;
    L5:
        this.mContext = ZeusTransformUtils.wrapperContext(r6, "com.obric.memorydata.plugin");
        this.mListener = (Listener) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r7), Listener.class, "com.obric.memorydata.plugin");
        HandlerThread r8 = new HandlerThread(TAG);
        this.mThread = r8;
        r8.start();
        this.mHandler = new Handler(r8.getLooper());
        this.mDeathRecipient = new $$Lambda$SensorBridgeClient$nkmOZ5P3PjC5mXE7EWpDQ_Tus(this);
        this.mCallback = new AnonymousClass1(this);
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
        this.mSensors.clear();
        return;
    L8:
        r0.unlinkToDeath(this.mDeathRecipient, 0);     // Catch: Throwable -> L7
        goto L5
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v10, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    private void connect() {
        Object r1 = this.mLock;
        monitor-enter(r1);
    L73:
        th = move-exception;
        throw th;
    L5:
        if (this.mStarted == true) goto L7;
    L71:
        monitor-exit(r1);     // Catch: Throwable -> L73
        return;
    L7:
        if (this.mService != null) goto L71;
        monitor-exit(r1);     // Catch: Throwable -> L73
        IBinder r2 = getServiceBinder();
        if (r2 != null) goto L14;
        scheduleConnect();
        return;
    L14:
        b r3 = null;
        ?? th = 1;
        boolean r4 = true;
        r2.linkToDeath(this.mDeathRecipient, 0);     // Catch: Throwable -> L58
        r3 = b.a.a(r2);     // Catch: Throwable -> L56
        if (r3 == null) goto L55;
        int r5 = r3.a(this.mContext.getPackageName(), this.mCallback);     // Catch: Throwable -> L56
        if (r5 > 0) goto L102;
    L52:
        th = th;
        boolean r6 = true;
        boolean r7 = false;
        ?? r8 = 0;
    L61:
        if (r7 == true) goto L67;
        if (r8 == 0) goto L65;
        if (r3 == null) goto L65;
        r3.a(r5);     // Catch: Throwable -> L76
    L65:
        if (r6 == false) goto L67;
        r2.unlinkToDeath(this.mDeathRecipient, 0);     // Catch: Throwable -> L77
    L67:
        this.mListener.onError("failed to connect sensorbridge", th);
        if (r7 == true) goto L106;
        scheduleConnect();
        return;
    L106:
        return;
    L51:
        throw new IllegalStateException("sensorbridge returned invalid clientId=" + r5);     // Catch: Throwable -> L52
    L102:
        Object r0 = this.mLock;     // Catch: Throwable -> L48
        monitor-enter(r0);     // Catch: Throwable -> L48
    L40:
        th = move-exception;
        ?? r9 = th;
        boolean r10 = false;
        th = th;
        boolean r11 = r9 == true ? 1 : 0;
    L98:
        monitor-exit(r0);     // Catch: Throwable -> L46
        throw th;     // Catch: Throwable -> L44
    L44:
        th = th;
        r7 = r10;
        r6 = r11;
        r8 = r9;
    L46:
        th = th;
        goto L98
    L23:
        if (this.mStarted == true) goto L32;
        r3.a(r5);     // Catch: Throwable -> L40
        r2.unlinkToDeath(this.mDeathRecipient, 0);     // Catch: Throwable -> L30
        monitor-exit(r0);     // Catch: Throwable -> L28
        return;
    L28:
        th = move-exception;
        r11 = false;
        r9 = 0;
        r10 = false;
        th = th;
    L87:
    L30:
        th = move-exception;
        r9 = 0;
        r10 = false;
        r11 = true;
        th = th;
        goto L87
    L32:
        this.mService = r3;     // Catch: Throwable -> L40
        this.mServiceBinder = r2;     // Catch: Throwable -> L40
        this.mClientId = r5;     // Catch: Throwable -> L40
        monitor-exit(r0);     // Catch: Throwable -> L38
        this.mListener.onConnected();     // Catch: Throwable -> L36
        return;
    L36:
        th = th;
        boolean r12 = true;
    L60:
        r8 = r12 ? 1 : 0;
        r7 = r4;
        r6 = r12;
    L38:
        th = move-exception;
        r9 = 1;
        r10 = true;
        th = th;
        r11 = true;
    L48:
        th = th;
        r6 = true;
        r8 = 1;
        r7 = false;
        goto L61
    L55:
        throw new IllegalStateException("sensorbridge interface is null");     // Catch: Throwable -> L56
    L56:
        th = th;
        r6 = true;
        r7 = false;
        r5 = 0;
        r8 = 0;
    L58:
        th = th;
        r4 = false;
        r5 = 0;
        r12 = false;
        goto L60
    }

    private IBinder getServiceBinder() {
        Object r2 = ServiceManager.class.getMethod("waitForDeclaredService", new Class[]{String.class}).invoke(null, new Object[]{SERVICE_NAME});     // Catch: Throwable -> L7
        if (ZeusTransformUtils.instanceOf(r2, IBinder.class) == false) goto L16;
        return (IBinder) ZeusTransformUtils.preCheckCast(r2, IBinder.class, "com.obric.memorydata.plugin");
    L16:
        return ServiceManager.getService(SERVICE_NAME);
    L11:
        e = move-exception;
        com.obric.cae.log.a.a(TAG, "getService failed", e);
        return null;
    L7:
        e = move-exception;
        com.obric.cae.log.a.a(TAG, "waitForDeclaredService unavailable", e);
        goto L16
    }

    private void handleServiceDeath() {
        this.mHandler.removeCallbacks(this.mSubscribeTask);
        Object r0 = this.mLock;
        monitor-enter(r0);
        clearServiceLocked();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        this.mListener.onDisconnected();
        scheduleConnect();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ void lambda$22CkFmWnkbkjma3g1ND_RA4AL5w(SensorBridgeClient r0) {
        r0.subscribeInternal();
    }

    /* JADX INFO: renamed from: lambda$3t5ZtwHIXniYEvu8B797-stF5L8, reason: not valid java name */
    public static /* synthetic */ void m400lambda$3t5ZtwHIXniYEvu8B797stF5L8(SensorBridgeClient r0) {
        r0.connect();
    }

    /* JADX INFO: renamed from: lambda$4U2s5vU_3C_0gRjLYDjn52zN-pw, reason: not valid java name */
    public static /* synthetic */ void m401lambda$4U2s5vU_3C_0gRjLYDjn52zNpw(SensorBridgeClient r0) {
        r0.handleServiceDeath();
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

    private void scheduleSubscribe() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.mStarted == true) goto L7;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L7:
        if (this.mService == null) goto L12;
        monitor-exit(r0);     // Catch: Throwable -> L14
        this.mHandler.removeCallbacks(this.mSubscribeTask);
        this.mHandler.postDelayed(this.mSubscribeTask, 1000);
    }

    private void sendRequestInternal(String r5, int r6, byte[] r7, int r8) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        b r1 = this.mService;     // Catch: Throwable -> L20
        int r2 = this.mClientId;     // Catch: Throwable -> L20
        monitor-exit(r0);     // Catch: Throwable -> L20
        if (r1 == null) goto L18;
        if (r2 <= 0) goto L18;
        SensorBridgeRequest r3 = new SensorBridgeRequest();     // Catch: Throwable -> L15
        r3.sensor = resolveSensor(r1, r5);     // Catch: Throwable -> L15
        r3.messageId = r6;     // Catch: Throwable -> L15
        if (r7 != null) goto L13;
        r7 = EMPTY_BYTE_ARRAY;     // Catch: Throwable -> L15
    L13:
        r3.payload = r7;     // Catch: Throwable -> L15
        r3.requestId = r8;     // Catch: Throwable -> L15
        r3.requestScope = 4;     // Catch: Throwable -> L15
        SensorBridgeDelivery r9 = new SensorBridgeDelivery();     // Catch: Throwable -> L15
        r3.delivery = r9;     // Catch: Throwable -> L15
        r9.clientProcessor = 1;     // Catch: Throwable -> L15
        r9.deliveryType = 0;     // Catch: Throwable -> L15
        r9.noWakeupMessageIds = EMPTY_INT_ARRAY;     // Catch: Throwable -> L15
        r3.batch = new SensorBridgeBatch();     // Catch: Throwable -> L15
        r1.a(r2, r3);     // Catch: Throwable -> L15
        return;
    L15:
        e = move-exception;
        this.mListener.onError("failed request sensor=" + r5 + " messageId=" + r6, e);
        return;
    L18:
        this.mListener.onError("sensorbridge is not connected", null);
        return;
    L20:
        th = move-exception;
        throw th;
    }

    private void subscribeInternal() {
        String r0 = this.mSubscriptionSensorName;
        int[] r1 = this.mSubscriptionEventIds;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r1.length == 0) goto L30;
        Object r2 = this.mLock;
        monitor-enter(r2);
        b r3 = this.mService;     // Catch: Throwable -> L21
        int r4 = this.mClientId;     // Catch: Throwable -> L21
        monitor-exit(r2);     // Catch: Throwable -> L21
        if (r3 == null) goto L19;
        if (r4 <= 0) goto L19;
        SensorBridgeSubscription r5 = new SensorBridgeSubscription();     // Catch: Throwable -> L16
        r5.sensor = resolveSensor(r3, r0);     // Catch: Throwable -> L16
        r5.eventMessageIds = r1;     // Catch: Throwable -> L16
        SensorBridgeDelivery r6 = new SensorBridgeDelivery();     // Catch: Throwable -> L16
        r5.delivery = r6;     // Catch: Throwable -> L16
        r6.clientProcessor = 1;     // Catch: Throwable -> L16
        r6.deliveryType = 0;     // Catch: Throwable -> L16
        r6.noWakeupMessageIds = EMPTY_INT_ARRAY;     // Catch: Throwable -> L16
        r5.batch = new SensorBridgeBatch();     // Catch: Throwable -> L16
        r5.payload = EMPTY_BYTE_ARRAY;     // Catch: Throwable -> L16
        r3.a(r4, r5);     // Catch: Throwable -> L16
        this.mListener.onSubscribed();     // Catch: Throwable -> L16
        return;
    L16:
        e = move-exception;
        this.mListener.onError("failed to subscribe sensor=".concat(r0), e);
        scheduleSubscribe();
        return;
    L19:
        this.mListener.onError("sensorbridge is not connected", null);
        return;
    L21:
        th = move-exception;
        throw th;
    }

    private void unregisterAndClearLocked() {
        b r0 = this.mService;
        if (r0 == null) goto L10;
        int r1 = this.mClientId;
        if (r1 <= 0) goto L10;
        r0.a(r1);     // Catch: Throwable -> L8
    L8:
        e = move-exception;
        com.obric.cae.log.a.a(TAG, "unregisterClient failed", e);
    L10:
        clearServiceLocked();
    }

    public /* synthetic */ void lambda$new$0$SensorBridgeClient() {
        this.mHandler.post(new $$Lambda$SensorBridgeClient$4U2s5vU_3C_0gRjLYDjn52zNpw(this));
    }

    public /* synthetic */ void lambda$sendRequest$3$SensorBridgeClient(String r1, int r2, byte[] r3, int r4) {
        sendRequestInternal(r1, r2, r3, r4);
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

    public /* synthetic */ void lambda$subscribe$2$SensorBridgeClient(String r2, int[] r3) {
        this.mSubscriptionSensorName = r2;
        if (r3 != null) goto L5;
        int[] r4 = EMPTY_INT_ARRAY;
    L6:
        this.mSubscriptionEventIds = r4;
        this.mHandler.removeCallbacks(this.mSubscribeTask);
        this.mSubscribeTask.run();
        return;
    L5:
        r4 = (int[]) ZeusTransformUtils.preCheckCast(r3.clone(), int[].class, "com.obric.memorydata.plugin");
        goto L6
    }

    public void sendRequest(final String r9, final int r10, final byte[] r11, final int r12) {
        this.mHandler.post(new $$Lambda$SensorBridgeClient$VDZ5rQel5PWYEtQmDWLk7LzxiNc(this, r9, r10, r11, r12));
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
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.mStarted == true) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L8:
        this.mStarted = false;     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        this.mHandler.removeCallbacks(this.mConnectTask);
        this.mHandler.removeCallbacks(this.mSubscribeTask);
        this.mHandler.post(new $$Lambda$SensorBridgeClient$b7g5_o4X38qhH4NWa80Pg2Iwl2c(this));
    }

    public void subscribe(final String r3, final int[] r4) {
        this.mHandler.post(new $$Lambda$SensorBridgeClient$J6IOsSDnxKLQ1c26yysIyg1G6k(this, r3, r4));
    }
}
