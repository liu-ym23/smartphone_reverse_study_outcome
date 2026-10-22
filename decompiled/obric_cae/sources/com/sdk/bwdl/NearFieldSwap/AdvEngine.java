package com.sdk.bwdl.NearFieldSwap;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.AdvertiseCallback;
import android.bluetooth.le.AdvertisingSetCallback;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.sdk.bwdl.AdapterLayer.BleAdv.BleExternalAdv;
import com.sdk.bwdl.AdapterLayer.BleAdv.BleLegacylAdv;
import com.sdk.bwdl.BWDLReceiver;
import com.sdk.bwdl.ExternalAPI.BWDLAdvertisingData;
import com.sdk.bwdl.ExternalAPI.BWDLConfigs;
import com.sdk.bwdl.ExternalAPI.BWDLConstant;
import com.sdk.bwdl.NearFieldSwap.BwdlAdvStructure.BwdlAdvStructure;
import com.sdk.bwdl.NearFieldSwap.callback.BWDLAdvertisingSetCallback;
import com.sdk.bwdl.Utils.BWDLLog;
import com.sdk.bwdl.Utils.BWDLUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class AdvEngine {
    private static final int MAX_BWDL_LENGTH = 240;
    private static final int MESSAGE_ADV_DISABLE = 3;
    private static final int MESSAGE_ADV_ENABLE = 2;
    private static final int MESSAGE_ADV_ENGINE_BOOT = 1;
    private static final int MESSAGE_ADV_RESTART = 4;
    private static final int MESSAGE_ADV_SET_DATA_EVENT = 7;
    private static final int MESSAGE_ADV_SET_FAILED_EVENT = 6;
    private static final int MESSAGE_ADV_SET_RESPONSE_DATA_EVENT = 8;
    private static final int MESSAGE_ADV_SET_START_EVENT = 5;
    private static final int MESSAGE_ADV_SET_STOPPED_EVENT = 9;
    private static final int MESSAGE_ADV_START_EVENT = 10;
    private static final int MESSAGE_ADV_STOPPED_EVENT = 11;
    private String TAG;
    private boolean isRunning;
    private Object mAdvDataLock;
    private AdvEngineHandler mAdvHandler;
    AdvertiseCallback mAdvertisingCallback;
    AdvertisingSetCallback mAdvertisingSetCallback;
    private List<Map<BWDLAdvertisingSetCallback, BWDLAdvertisingData>> mBWDLAdvCallback;
    private List<BWDLAdvertisingData> mBWDLAdvertisingData;
    private BWDLReceiver mBWDLReceiver;
    private BleExternalAdv mBleAdvHelper;
    private BleLegacylAdv mBleLegacyAdvHelper;
    private BluetoothAdapter mBluetoothAdapter;
    private BWDLConstant.BROADCAST_TYPE mBroadcastType;
    private BwdlAdvStructure mBwdlAdvStructure;
    private Context mContext;
    private byte[] mData;
    private int mDeviceId;
    private boolean mIsLeExtendedAdvertisingSupported;
    private boolean mState;
    private SystemBroadcastListener mSystemBroadcastListener;

    /* JADX INFO: renamed from: com.sdk.bwdl.NearFieldSwap.AdvEngine$3, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$sdk$bwdl$ExternalAPI$BWDLConstant$ADV_INTERVAL_LEVEL = null;
        static final /* synthetic */ int[] $SwitchMap$com$sdk$bwdl$ExternalAPI$BWDLConstant$ADV_TX_POWER_LEVEL = null;

        static {
            int[] r8 = new int[BWDLConstant.ADV_INTERVAL_LEVEL.values().length];
            $SwitchMap$com$sdk$bwdl$ExternalAPI$BWDLConstant$ADV_INTERVAL_LEVEL = r8;
            r8[BWDLConstant.ADV_INTERVAL_LEVEL.ADV_INTERVAL_HIGH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L21:
            $SwitchMap$com$sdk$bwdl$ExternalAPI$BWDLConstant$ADV_INTERVAL_LEVEL[BWDLConstant.ADV_INTERVAL_LEVEL.ADV_INTERVAL_MEDIUM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L23:
            $SwitchMap$com$sdk$bwdl$ExternalAPI$BWDLConstant$ADV_INTERVAL_LEVEL[BWDLConstant.ADV_INTERVAL_LEVEL.ADV_INTERVAL_LOW.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L8:
            int[] r10 = new int[BWDLConstant.ADV_TX_POWER_LEVEL.values().length];
            $SwitchMap$com$sdk$bwdl$ExternalAPI$BWDLConstant$ADV_TX_POWER_LEVEL = r10;
            r10[BWDLConstant.ADV_TX_POWER_LEVEL.ADV_TX_POWER_HIGH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L29:
            $SwitchMap$com$sdk$bwdl$ExternalAPI$BWDLConstant$ADV_TX_POWER_LEVEL[BWDLConstant.ADV_TX_POWER_LEVEL.ADV_TX_POWER_MEDIUM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L19:
            $SwitchMap$com$sdk$bwdl$ExternalAPI$BWDLConstant$ADV_TX_POWER_LEVEL[BWDLConstant.ADV_TX_POWER_LEVEL.ADV_TX_POWER_LOW.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
            return;
        }
    }

    public class AdvEngineHandler extends Handler {
        final /* synthetic */ AdvEngine this$0;

        private AdvEngineHandler(AdvEngine r8) {
            this.this$0 = r8;
        }

        @Override // android.os.Handler
        public void handleMessage(Message r8) {
            BWDLLog.d(AdvEngine.access$200(this.this$0), "AdvEngineHandler handleMessage=" + r8.what);
            int r10 = r8.what;
            if (r10 != 2) goto L5;
        L24:
            AdvEngine.access$300(this.this$0);
            this.this$0.startInternal();
            return;
        L5:
            if (r10 != 3) goto L7;
            this.this$0.stopInternal();
            return;
        L7:
            if (r10 != 4) goto L9;
            this.this$0.stopInternal();
            goto L24
        L9:
            if (r10 != 5) goto L11;
            AdvEngine r11 = this.this$0;
            int r12 = r8.arg1;
        L21:
            AdvEngine.access$400(r11, r12);
            return;
        L11:
            if (r10 != 6) goto L13;
            AdvEngine.access$500(this.this$0, r8.arg1);
            return;
        L13:
            if (r10 != 9) goto L15;
            this.this$0.handleAdvSetStopped();
            return;
        L15:
            if (r10 != 10) goto L30;
            r12 = r8.arg1;
            r11 = this.this$0;
            goto L21
        }

        public /* synthetic */ AdvEngineHandler(AdvEngine r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public class SystemBroadcastListener implements BWDLReceiver.ISystemBroadcastListener {
        final /* synthetic */ AdvEngine this$0;

        private SystemBroadcastListener(AdvEngine r8) {
            this.this$0 = r8;
        }

        @Override // com.sdk.bwdl.BWDLReceiver.ISystemBroadcastListener
        public void onBtStateChanged(int r8) {
            if (r8 != 12) goto L6;
            AdvEngine.access$700(this.this$0);
            return;
        L6:
            if (r8 != 13) goto L8;
        L9:
            AdvEngine.access$802(this.this$0, false);
            return;
        L8:
            if (r8 == 10) goto L9;
        }

        @Override // com.sdk.bwdl.BWDLReceiver.ISystemBroadcastListener
        public void onScreenOff() {
        }

        @Override // com.sdk.bwdl.BWDLReceiver.ISystemBroadcastListener
        public void onScreenOn() {
        }

        @Override // com.sdk.bwdl.BWDLReceiver.ISystemBroadcastListener
        public void onWifiStateChanged(int r8) {
        }

        public /* synthetic */ SystemBroadcastListener(AdvEngine r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public AdvEngine(Context r8, BluetoothAdapter r10) {
        this.TAG = "AdvEngine";
        this.isRunning = false;
        this.mState = false;
        this.mData = new byte[240];
        this.mAdvertisingCallback = new AnonymousClass1(this);
        this.mAdvertisingSetCallback = new AnonymousClass2(this);
        this.mContext = r8;
        this.mBluetoothAdapter = r10;
        this.mBleAdvHelper = new BleExternalAdv(this.mContext, r10);
        this.mBWDLAdvCallback = new CopyOnWriteArrayList();
        this.mBWDLAdvertisingData = new CopyOnWriteArrayList();
        this.mBwdlAdvStructure = new BwdlAdvStructure(this.mDeviceId);
        this.mAdvDataLock = new Object();
        this.mAdvHandler = new AdvEngineHandler(this, null);
        BWDLLog.d(this.TAG, "AdvEngine");
    }

    public static /* synthetic */ String access$200(AdvEngine r8) {
        return r8.TAG;
    }

    public static /* synthetic */ void access$300(AdvEngine r8) {
        r8.updateBWDLAdvertisingData();
    }

    public static /* synthetic */ void access$400(AdvEngine r8, int r10) {
        r8.handleAdvSetStart(r10);
    }

    public static /* synthetic */ void access$500(AdvEngine r8, int r10) {
        r8.handleAdvSetStartFailed(r10);
    }

    public static /* synthetic */ AdvEngineHandler access$600(AdvEngine r8) {
        return r8.mAdvHandler;
    }

    public static /* synthetic */ void access$700(AdvEngine r8) {
        r8.init();
    }

    public static /* synthetic */ boolean access$802(AdvEngine r8, boolean r10) {
        r8.mState = r10;
        return r10;
    }

    private void addAdvSetCallback(BWDLAdvertisingSetCallback r8, BWDLAdvertisingData r10) {
        Object r11 = this.mAdvDataLock;
        monitor-enter(r11);
        HashMap r12 = new HashMap();     // Catch: Throwable -> L7
        r12.put(r8, r10);     // Catch: Throwable -> L7
        this.mBwdlAdvStructure.updateBwdlAdvServiceData(r10);     // Catch: Throwable -> L7
        this.mBWDLAdvCallback.add(r12);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private boolean containsAdvSetCallback(BWDLAdvertisingSetCallback r8) {
        Object r10 = this.mAdvDataLock;
        monitor-enter(r10);
        Iterator<Map<BWDLAdvertisingSetCallback, BWDLAdvertisingData>> r11 = this.mBWDLAdvCallback.iterator();     // Catch: Throwable -> L15
    L6:
        if (r11.hasNext() == false) goto L12;
        if (r11.next().containsKey(r8) == false) goto L6;
        monitor-exit(r10);     // Catch: Throwable -> L15
        return true;
    L12:
        monitor-exit(r10);     // Catch: Throwable -> L15
        return false;
    L15:
        th = move-exception;
        throw th;
    }

    private void fillBWDLCommonAdvStructure() {
        this.mBwdlAdvStructure.updateBwdlAdvData();
    }

    private void handleAdvSetStart(int r8) {
        if (this.mBWDLAdvCallback.isEmpty() == true) goto L15;
        Iterator<Map<BWDLAdvertisingSetCallback, BWDLAdvertisingData>> r10 = this.mBWDLAdvCallback.iterator();
    L6:
        if (r10.hasNext() == false) goto L24;
        Iterator<Map.Entry<BWDLAdvertisingSetCallback, BWDLAdvertisingData>> r11 = r10.next().entrySet().iterator();
    L9:
        if (r11.hasNext() == false) goto L6;
        r11.next().getKey().onAdvConnected(r8);     // Catch: Exception -> L13
    L13:
        e = move-exception;
        Log.e(this.TAG, "Error calling handleAdvSetStart", e);
        goto L9
    L24:
        return;
    L15:
        BWDLLog.e(this.TAG, "handleAdvSetStart BwdlScanCallback is empty ");
    }

    private void handleAdvSetStartFailed(int r8) {
        if (this.mBWDLAdvCallback.isEmpty() == true) goto L15;
        Iterator<Map<BWDLAdvertisingSetCallback, BWDLAdvertisingData>> r10 = this.mBWDLAdvCallback.iterator();
    L6:
        if (r10.hasNext() == false) goto L24;
        Iterator<Map.Entry<BWDLAdvertisingSetCallback, BWDLAdvertisingData>> r11 = r10.next().entrySet().iterator();
    L9:
        if (r11.hasNext() == false) goto L6;
        r11.next().getKey().onAdvConnectedFailed(r8);     // Catch: Exception -> L13
    L13:
        e = move-exception;
        Log.e(this.TAG, "Error calling handleAdvSetStartFailed", e);
        goto L9
    L24:
        return;
    L15:
        BWDLLog.e(this.TAG, "handleAdvSetStartFailed BwdlScanCallback is empty ");
    }

    private void init() {
        BluetoothAdapter r8 = BluetoothAdapter.getDefaultAdapter();
        if (r8.isEnabled() == false) goto L13;
        this.mBluetoothAdapter = r8;
        if (this.mBroadcastType != BWDLConstant.BROADCAST_TYPE.BROADCAST_EXTENDED) goto L7;
        this.mIsLeExtendedAdvertisingSupported = r8.isLeExtendedAdvertisingSupported();
    L8:
        BWDLLog.d(this.TAG, "isLeExtendedAdvertisingSupported:" + this.mIsLeExtendedAdvertisingSupported);
        if (this.mIsLeExtendedAdvertisingSupported == false) goto L11;
        this.mBleAdvHelper = new BleExternalAdv(this.mContext, r8);
    L12:
        this.mBWDLAdvCallback = new CopyOnWriteArrayList();
        this.mBWDLAdvertisingData = new CopyOnWriteArrayList();
        int r10 = BWDLUtil.convertStringToUniqueCode(BWDLUtil.getAndroidId(this.mContext));
        this.mDeviceId = r10;
        this.mBwdlAdvStructure = new BwdlAdvStructure(r10);
        this.mAdvDataLock = new Object();
        this.mAdvHandler = new AdvEngineHandler(this, null);
        this.mState = true;
    L14:
        BWDLLog.d(this.TAG, "AdvEngine enabled:" + this.mState + " deviceId:" + this.mDeviceId);
        return;
    L11:
        this.mBleLegacyAdvHelper = new BleLegacylAdv(this.mContext, r8);
        goto L12
    L7:
        this.mIsLeExtendedAdvertisingSupported = false;
        goto L8
    L13:
        this.mState = false;
        goto L14
    }

    private void registerBroadcastListener() {
        this.mSystemBroadcastListener = new SystemBroadcastListener(this, null);
        BWDLReceiver r8 = BWDLReceiver.getInstance(this.mContext);
        this.mBWDLReceiver = r8;
        r8.setSystemBroadcastListener(this.mSystemBroadcastListener);
    }

    private boolean removeAdvSetCallback(BWDLAdvertisingSetCallback r8) {
        Object r10 = this.mAdvDataLock;
        monitor-enter(r10);
        Iterator<Map<BWDLAdvertisingSetCallback, BWDLAdvertisingData>> r11 = this.mBWDLAdvCallback.iterator();     // Catch: Throwable -> L16
    L6:
        if (r11.hasNext() == false) goto L13;
        Map<BWDLAdvertisingSetCallback, BWDLAdvertisingData> r12 = r11.next();     // Catch: Throwable -> L16
        if (r12.containsKey(r8) == false) goto L6;
        this.mBWDLAdvCallback.remove(r12);     // Catch: Throwable -> L16
        this.mBwdlAdvStructure.removeBwdlAdvServiceData(r12.get(r8));     // Catch: Throwable -> L16
        monitor-exit(r10);     // Catch: Throwable -> L16
        return true;
    L13:
        monitor-exit(r10);     // Catch: Throwable -> L16
        return false;
    L16:
        th = move-exception;
        throw th;
    }

    private void updateAdvManufacturerData() {
        if (this.mIsLeExtendedAdvertisingSupported == false) goto L5;
        this.mBleAdvHelper.updateAdvertisingSetManufacturerData(this.mBwdlAdvStructure.getBytes());
        return;
    L5:
        this.mBleLegacyAdvHelper.updateAdvertisingManufacturerData(this.mBwdlAdvStructure.getBytes());
    }

    private void updateAdvServiceData() {
        if (this.mIsLeExtendedAdvertisingSupported == false) goto L5;
        this.mBleAdvHelper.updateAdvertisingSetServiceData(this.mBwdlAdvStructure.getBytes());
        return;
    L5:
        this.mBleLegacyAdvHelper.updateAdvertisingSetServiceData(this.mBwdlAdvStructure.getBytes());
    }

    private void updateBWDLAdvertisingData() {
        BWDLLog.d(this.TAG, "AdvEngine updateBWDLAdvertisingData=");
        fillBWDLCommonAdvStructure();
        updateAdvManufacturerData();
    }

    public void exit() {
        BWDLLog.d(this.TAG, "AdvEngine exit");
        this.mState = false;
        stopInternal();
        this.mBWDLAdvCallback.clear();
        this.mBWDLAdvertisingData.clear();
        this.mAdvHandler.removeCallbacksAndMessages(null);
        this.mAdvHandler = null;
    }

    public void handleAdvSetStopped() {
        if (this.mBWDLAdvCallback.isEmpty() == true) goto L15;
        Iterator<Map<BWDLAdvertisingSetCallback, BWDLAdvertisingData>> r8 = this.mBWDLAdvCallback.iterator();
    L6:
        if (r8.hasNext() == false) goto L24;
        Iterator<Map.Entry<BWDLAdvertisingSetCallback, BWDLAdvertisingData>> r10 = r8.next().entrySet().iterator();
    L9:
        if (r10.hasNext() == false) goto L6;
        r10.next().getKey().onAdvStopped();     // Catch: Exception -> L13
    L13:
        e = move-exception;
        Log.e(this.TAG, "Error calling handleAdvSetStopped", e);
        goto L9
    L24:
        return;
    L15:
        BWDLLog.e(this.TAG, "handleAdvSetStopped BwdlScanCallback is empty ");
    }

    public boolean isAdvStartRunning() {
        return this.isRunning;
    }

    public boolean isReady() {
        return this.mState;
    }

    public void setAdvSetParameters(BWDLConstant.ADV_INTERVAL_LEVEL r8) {
        int r10 = AnonymousClass3.$SwitchMap$com$sdk$bwdl$ExternalAPI$BWDLConstant$ADV_INTERVAL_LEVEL[r8.ordinal()];
        if (r10 == 1) goto L20;
        if (r10 == 2) goto L16;
        if (r10 == 3) goto L12;
        if (this.mIsLeExtendedAdvertisingSupported == true) goto L17;
    L18:
        this.mBleLegacyAdvHelper.setInterval(1);
        return;
    L17:
        this.mBleAdvHelper.setInterval(400);
        return;
    L12:
        if (this.mIsLeExtendedAdvertisingSupported == false) goto L14;
        BleExternalAdv r11 = this.mBleAdvHelper;
        int r12 = 160;
    L22:
        r11.setInterval(r12);
        return;
    L14:
        this.mBleLegacyAdvHelper.setInterval(0);
        return;
    L16:
        if (this.mIsLeExtendedAdvertisingSupported == false) goto L18;
    L20:
        if (this.mIsLeExtendedAdvertisingSupported == false) goto L23;
        r11 = this.mBleAdvHelper;
        r12 = 1600;
        goto L22
    L23:
        this.mBleLegacyAdvHelper.setInterval(2);
    }

    public void setOptionalAdvConfig(int r8) {
        if ((r8 & 1) == 0) goto L5;
        this.mBwdlAdvStructure.setBLEAdvNameDataOption(true);
    L7:
        if ((r8 & 2) == 0) goto L9;
        this.mBwdlAdvStructure.setBLEAdvPowerDataOption(true);
    L10:
        int r10 = r8 & 4;
        BwdlAdvStructure r11 = this.mBwdlAdvStructure;
        if (r10 == 0) goto L13;
        r11.setBLEAdvUUIDDataOption(true);
        return;
    L13:
        r11.setBLEAdvUUIDDataOption(false);
        return;
    L9:
        this.mBwdlAdvStructure.setBLEAdvPowerDataOption(false);
        goto L10
    L5:
        this.mBwdlAdvStructure.setBLEAdvNameDataOption(false);
        goto L7
    }

    public void start(BWDLAdvertisingSetCallback r8, BWDLAdvertisingData r10) {
        BWDLLog.d(this.TAG, "start Adv");
        if (this.mBWDLAdvCallback != null) goto L5;
        BWDLLog.e(this.TAG, "Register callback failed");
        AdvEngineHandler r11 = this.mAdvHandler;
        int r12 = 6;
    L12:
        r11.sendMessage(Message.obtain(r11, r12));
        return;
    L5:
        if (containsAdvSetCallback(r8) == false) goto L7;
        removeAdvSetCallback(r8);
    L7:
        addAdvSetCallback(r8, r10);
        if (this.isRunning == true) goto L10;
        this.isRunning = true;
        r11 = this.mAdvHandler;
        r12 = 2;
        goto L12
    L10:
        r11 = this.mAdvHandler;
        r12 = 4;
        goto L12
    }

    public void startInternal() {
        BWDLLog.d(this.TAG, "startInternal adv");
        if (this.mIsLeExtendedAdvertisingSupported == false) goto L5;
        this.mBleAdvHelper.startAdvertisingSet(this.mAdvertisingSetCallback);
        return;
    L5:
        this.mBleLegacyAdvHelper.startAdvertising(this.mAdvertisingCallback);
    }

    public void stop(BWDLAdvertisingSetCallback r8) {
        BWDLLog.d(this.TAG, "stop Adv");
        if (this.mBWDLAdvCallback == null) goto L7;
        removeAdvSetCallback(r8);
        if (this.mBWDLAdvCallback.isEmpty() == false) goto L9;
        this.isRunning = false;
        AdvEngineHandler r10 = this.mAdvHandler;
        r10.sendMessage(Message.obtain(r10, 3));
        return;
    L9:
        return;
    L7:
        BWDLLog.e(this.TAG, "stop failed");
    }

    public void stopInternal() {
        if (this.mIsLeExtendedAdvertisingSupported == false) goto L5;
        this.mBleAdvHelper.stopAdvertisingSet(this.mAdvertisingSetCallback);
    L6:
        BWDLLog.d(this.TAG, "stopInternal Adv");
        return;
    L5:
        this.mBleLegacyAdvHelper.stopAdvertising(this.mAdvertisingCallback);
        goto L6
    }

    public AdvEngine(Context r8, BWDLConfigs r10) {
        this.TAG = "AdvEngine";
        this.isRunning = false;
        this.mState = false;
        this.mData = new byte[240];
        this.mAdvertisingCallback = new AnonymousClass1(this);
        this.mAdvertisingSetCallback = new AnonymousClass2(this);
        this.mContext = r8;
        this.mBroadcastType = r10.getBroadcastType();
        registerBroadcastListener();
        init();
        BWDLLog.d(this.TAG, "AdvEngine");
    }

    public void setAdvSetParameters(BWDLConstant.ADV_TX_POWER_LEVEL r8) {
        int r10 = AnonymousClass3.$SwitchMap$com$sdk$bwdl$ExternalAPI$BWDLConstant$ADV_TX_POWER_LEVEL[r8.ordinal()];
        if (r10 == 1) goto L18;
        if (r10 == 2) goto L13;
        if (r10 == 3) goto L9;
        return;
    L9:
        if (this.mIsLeExtendedAdvertisingSupported == false) goto L11;
        BleExternalAdv r11 = this.mBleAdvHelper;
        int r12 = -15;
    L15:
        r11.setTxPowerLevel(r12);
        return;
    L11:
        this.mBleLegacyAdvHelper.setTxPowerLevel(1);
        return;
    L13:
        if (this.mIsLeExtendedAdvertisingSupported == false) goto L16;
        r11 = this.mBleAdvHelper;
        r12 = -7;
        goto L15
    L16:
        this.mBleLegacyAdvHelper.setTxPowerLevel(2);
        return;
    L18:
        if (this.mIsLeExtendedAdvertisingSupported == false) goto L20;
        this.mBleAdvHelper.setTxPowerLevel(1);
        return;
    L20:
        this.mBleLegacyAdvHelper.setTxPowerLevel(3);
    }
}
