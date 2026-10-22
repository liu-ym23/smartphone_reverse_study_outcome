package com.obric.cae.smartBluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.obric.cae.R;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartBluetooth.a2dpJitterML.A2dpJitterMlBqrCallbackController;
import com.obric.cae.smartBluetooth.a2dpJitterML.A2dpJitterMlPredictor;
import com.obric.cae.smartBluetooth.btaware.SmartBluetoothAwareManager;
import com.obric.cae.smartBluetooth.btaware.carkey.SmartBluetoothCarKeyManager;
import com.obric.cae.smartBluetooth.callback.SmartBluetoothEventCallback;
import com.obric.cae.smartBluetooth.dbam.DbamEventHandler;
import com.obric.cae.smartBluetooth.deviceIdentification.BluetoothDeviceInfoExt;
import com.obric.cae.smartBluetooth.lowlatency.LowLatencyHandler;
import com.obric.cae.smartBluetooth.scan.SmartBluetoothBleScanManager;
import com.obric.cae.utils.CaeUtil;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class SmartBluetoothManager {
    private static final int MSG_INIT = 1;
    private static final String TAG = "SmartBluetoothManager";
    private static SmartBluetoothBleScanManager mBleScanManager;
    private static volatile SmartBluetoothManager sInstance;
    private static SmartBluetoothCarKeyManager sSmartBluetoothCarKeyManager;
    private SmartBluetoothAnalyzer mAnalyzer;
    private SmartBleAlwaysOnBinderClient mBleAlwaysOnBinderClient;
    private final SmartBluetoothAwareManager mBluetoothAwareManager;
    private SmartBluetoothBinderClient mBluetoothBinderClient;
    private BluetoothDeviceInfoExt mBluetoothDeviceInfoExt;
    private final SmartBluetoothEventCallback mCallback;
    private CloudBinderClient mCloudBinderClient;
    private SmartBluetoothCloudSyncer mCloudSyncer;
    private final Context mContext;
    private SmartBluetoothDatabase mDatabase;
    private DbamEventHandler mDbamEventHandler;
    private SmartBluetoothEventHandler mEventHandler;
    private final ManagerHandler mHandler;
    private A2dpJitterMlBqrCallbackController mJitterBqrCallbackController;
    private A2dpJitterMlPredictor mJitterPredictor;
    private LowLatencyHandler mLowLatencyHandler;
    private SmartBluetoothPolicy mPolicy;
    private final HandlerThread mThread;

    public class ManagerHandler extends Handler {
        final /* synthetic */ SmartBluetoothManager this$0;

        public ManagerHandler(SmartBluetoothManager r8, Looper r10) {
            this.this$0 = r8;
            super(r10);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r8) {
            if (r8.what != 1) goto L7;
            SmartBluetoothManager.access$500(this.this$0);
            return;
        }
    }

    private SmartBluetoothManager(Context r8) {
        SmartBluetoothEventCallback r10 = new AnonymousClass1(this);
        this.mCallback = r10;
        this.mContext = r8.getApplicationContext();
        HandlerThread r11 = new HandlerThread("SmartBluetoothManager");
        this.mThread = r11;
        r11.start();
        this.mHandler = new ManagerHandler(this, r11.getLooper());
        mBleScanManager = SmartBluetoothBleScanManager.getInstance(r8);
        this.mBluetoothAwareManager = SmartBluetoothAwareManager.getInstance(r8);
        sSmartBluetoothCarKeyManager = SmartBluetoothCarKeyManager.getInstance(r8);
        SmartBluetoothEventReceiver.registerEventCallback(r10);
    }

    public static /* synthetic */ void a(SmartBluetoothManager r8, Runnable r10) {
        r8.lambda$initInternal$0(r10);
    }

    public static /* synthetic */ void access$000(SmartBluetoothManager r8) {
        r8.onBluetoothOn();
    }

    public static /* synthetic */ void access$100(SmartBluetoothManager r8) {
        r8.onBluetoothOff();
    }

    public static /* synthetic */ void access$200(SmartBluetoothManager r8, BluetoothDevice r10, int r11, int r12, int r13) {
        r8.onBondStateChange(r10, r11, r12, r13);
    }

    public static /* synthetic */ void access$300(SmartBluetoothManager r8) {
        r8.onBluetoothBleOn();
    }

    public static /* synthetic */ void access$400(SmartBluetoothManager r8, boolean r10) {
        r8.onScreenStateChange(r10);
    }

    public static /* synthetic */ void access$500(SmartBluetoothManager r8) {
        r8.initInternal();
    }

    public static SmartBluetoothManager getInstance(Context r8) {
        if (sInstance != null) goto L15;
        monitor-enter(SmartBluetoothManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new SmartBluetoothManager(r8);     // Catch: Throwable -> L11
    L9:
        monitor-exit(SmartBluetoothManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private void initInternal() {
        this.mBluetoothDeviceInfoExt = BluetoothDeviceInfoExt.getInstance(this.mContext);
        this.mBluetoothBinderClient = new SmartBluetoothBinderClient(this.mContext);
        this.mBleAlwaysOnBinderClient = new SmartBleAlwaysOnBinderClient(this.mContext);
        this.mCloudBinderClient = new CloudBinderClient(this.mContext);
        this.mEventHandler = new SmartBluetoothEventHandler(this.mContext);
        this.mAnalyzer = new SmartBluetoothAnalyzer(this.mContext);
        this.mPolicy = new SmartBluetoothPolicy(this.mContext);
        this.mDatabase = new SmartBluetoothDatabase(this.mContext);
        this.mCloudSyncer = new SmartBluetoothCloudSyncer(this.mContext);
        if (this.mContext.getResources().getBoolean(R.bool.cae_supported_bluetooth_3rd_antenna) == false) goto L6;
        this.mDbamEventHandler = new DbamEventHandler(this.mContext);
    L6:
        if (this.mContext.getResources().getBoolean(R.bool.cae_supported_low_latency) == false) goto L19;
        this.mLowLatencyHandler = new LowLatencyHandler(this.mContext);
    L19:
        this.mJitterPredictor = new A2dpJitterMlPredictor(this.mContext, A2dpJitterMlPredictor.DEFAULT_MODEL_NAME);     // Catch: IOException -> L10
    L12:
        A2dpJitterMlBqrCallbackController r8 = new A2dpJitterMlBqrCallbackController(this.mContext, new d(this));
        this.mJitterBqrCallbackController = r8;
        r8.setPredictor(this.mJitterPredictor);
        this.mJitterBqrCallbackController.start();
        BluetoothAdapter r10 = BluetoothAdapter.getDefaultAdapter();
        if (r10.isEnabled() == false) goto L16;
        this.mBluetoothBinderClient.doBind();
    L16:
        if (r10.isLeEnabled() == false) goto L21;
        this.mBleAlwaysOnBinderClient.doBind();
        return;
    L21:
        return;
    L10:
        e = move-exception;
        CaeLog.w(TAG, "init jitter ml failed: " + e.getMessage());
        this.mJitterPredictor = null;
        goto L12
    }

    private /* synthetic */ void lambda$initInternal$0(Runnable r8) {
        this.mHandler.post(r8);
    }

    private void onBluetoothBleOn() {
        CaeLog.w(TAG, "onBluetoothBleOn");
        SmartBluetoothBleScanManager r8 = mBleScanManager;
        if (r8 == null) goto L5;
        r8.onBluetoothBleOn();
    L5:
        SmartBluetoothAwareManager r10 = this.mBluetoothAwareManager;
        if (r10 == null) goto L9;
        r10.onBluetoothBleOn();
        return;
    }

    private void onBluetoothOff() {
        CaeLog.w(TAG, "onBluetoothOff");
        SmartBluetoothBleScanManager r8 = mBleScanManager;
        if (r8 == null) goto L5;
        r8.onBluetoothOff();
    L5:
        SmartBluetoothAwareManager r10 = this.mBluetoothAwareManager;
        if (r10 == null) goto L8;
        r10.onBluetoothOff();
    L8:
        BluetoothDeviceInfoExt r11 = this.mBluetoothDeviceInfoExt;
        if (r11 == null) goto L11;
        r11.cleanUp();
    L11:
        SmartBluetoothCarKeyManager r12 = sSmartBluetoothCarKeyManager;
        if (r12 == null) goto L15;
        r12.onBluetoothOff();
        return;
    }

    private void onBluetoothOn() {
        CaeLog.w(TAG, "onBluetoothOn");
        SmartBluetoothBleScanManager r8 = mBleScanManager;
        if (r8 == null) goto L5;
        r8.onBluetoothOn();
    L5:
        BluetoothDeviceInfoExt r10 = this.mBluetoothDeviceInfoExt;
        if (r10 == null) goto L8;
        r10.onBluetoothOn();
    L8:
        SmartBluetoothCarKeyManager r11 = sSmartBluetoothCarKeyManager;
        if (r11 == null) goto L12;
        r11.onBluetoothOn();
        return;
    }

    private void onBondStateChange(BluetoothDevice r8, int r10, int r11, int r12) {
        String r13 = TAG;
        StringBuilder r14 = new StringBuilder("onBondStateChange device ");
        if (r8 != null) goto L5;
        String r15 = null;
    L6:
        r14.append(CaeUtil.maskMacOrBssid(r15));
        r14.append(" state ");
        r14.append(r11);
        CaeLog.w(r13, r14.toString());
        if (r11 != 10) goto L12;
        BluetoothDeviceInfoExt r16 = this.mBluetoothDeviceInfoExt;
        if (r16 == null) goto L13;
        r16.removeDevice(r8);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r15 = r8.getAddress();
        goto L6
    }

    private void onScreenStateChange(boolean r8) {
        CaeLog.w(TAG, "onScreenStateChange screenOn " + r8);
        SmartBluetoothBleScanManager r10 = mBleScanManager;
        if (r10 == null) goto L6;
        r10.onScreenStateChange(r8);
        return;
    }

    public void cleanup() {
        CaeLog.d(TAG, "cleanup");
        A2dpJitterMlBqrCallbackController r8 = this.mJitterBqrCallbackController;
        if (r8 == null) goto L5;
        r8.stop();
        this.mJitterBqrCallbackController = null;
    L5:
        SmartBluetoothEventReceiver.unRegisterEventCallback(this.mCallback);
        SmartBluetoothBinderClient r10 = this.mBluetoothBinderClient;
        if (r10 == null) goto L8;
        r10.close();
        this.mBluetoothBinderClient = null;
    L8:
        SmartBleAlwaysOnBinderClient r11 = this.mBleAlwaysOnBinderClient;
        if (r11 == null) goto L11;
        r11.close();
        this.mBleAlwaysOnBinderClient = null;
    L11:
        CloudBinderClient r12 = this.mCloudBinderClient;
        if (r12 == null) goto L14;
        r12.close();
        this.mCloudBinderClient = null;
    L14:
        SmartBluetoothEventHandler r13 = this.mEventHandler;
        if (r13 == null) goto L17;
        r13.cleanup();
    L17:
        SmartBluetoothPolicy r14 = this.mPolicy;
        if (r14 == null) goto L20;
        r14.cleanup();
    L20:
        SmartBluetoothCloudSyncer r15 = this.mCloudSyncer;
        if (r15 == null) goto L23;
        r15.cleanup();
    L23:
        SmartBluetoothBleScanManager r16 = mBleScanManager;
        if (r16 == null) goto L26;
        r16.cleanup();
    L26:
        SmartBluetoothAwareManager r17 = this.mBluetoothAwareManager;
        if (r17 == null) goto L29;
        r17.cleanup();
    L29:
        BluetoothDeviceInfoExt r18 = this.mBluetoothDeviceInfoExt;
        if (r18 == null) goto L32;
        r18.cleanUp();
    L32:
        SmartBluetoothCarKeyManager r19 = sSmartBluetoothCarKeyManager;
        if (r19 == null) goto L36;
        r19.cleanup();
        return;
    }

    public SmartBluetoothAnalyzer getAnalyzer() {
        return this.mAnalyzer;
    }

    public SmartBleAlwaysOnBinderClient getBleAlwaysOnBinderClient() {
        return this.mBleAlwaysOnBinderClient;
    }

    public SmartBluetoothBinderClient getBluetoothBinderClient() {
        return this.mBluetoothBinderClient;
    }

    public BluetoothDeviceInfoExt getBluetoothDeviceInfoExt() {
        return this.mBluetoothDeviceInfoExt;
    }

    public CloudBinderClient getCloudBinderClient() {
        return this.mCloudBinderClient;
    }

    public SmartBluetoothCloudSyncer getCloudSyncer() {
        return this.mCloudSyncer;
    }

    public SmartBluetoothDatabase getDatabase() {
        return this.mDatabase;
    }

    public DbamEventHandler getDbamEventHandler() {
        return this.mDbamEventHandler;
    }

    public SmartBluetoothEventHandler getEventHandler() {
        return this.mEventHandler;
    }

    public A2dpJitterMlBqrCallbackController getJitterBqrCallbackController() {
        return this.mJitterBqrCallbackController;
    }

    public A2dpJitterMlPredictor getJitterPredictor() {
        return this.mJitterPredictor;
    }

    public LowLatencyHandler getLowLatencyHandler() {
        return this.mLowLatencyHandler;
    }

    public SmartBluetoothPolicy getPolicy() {
        return this.mPolicy;
    }

    public void init() {
        ManagerHandler r8 = this.mHandler;
        if (r8 == null) goto L5;
        r8.sendEmptyMessage(1);
    L5:
        SmartBluetoothBleScanManager r10 = mBleScanManager;
        if (r10 == null) goto L8;
        r10.init();
    L8:
        SmartBluetoothAwareManager r11 = this.mBluetoothAwareManager;
        if (r11 == null) goto L11;
        r11.init();
    L11:
        SmartBluetoothCarKeyManager r12 = sSmartBluetoothCarKeyManager;
        if (r12 == null) goto L15;
        r12.init();
        return;
    }
}
