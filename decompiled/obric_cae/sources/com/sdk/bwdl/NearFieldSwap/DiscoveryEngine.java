package com.sdk.bwdl.NearFieldSwap;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.keva.KevaImpl;
import com.sdk.bwdl.AdapterLayer.BleScanner.BleExternalScanner;
import com.sdk.bwdl.AdapterLayer.BleScanner.BleScanHelper;
import com.sdk.bwdl.BWDLReceiver;
import com.sdk.bwdl.ExternalAPI.BWDLAdvertisingData;
import com.sdk.bwdl.ExternalAPI.BWDLConstant;
import com.sdk.bwdl.ExternalAPI.BWDLDiscoveryData;
import com.sdk.bwdl.NearFieldSwap.BwdlAdvStructure.BWDLAdvDataParser;
import com.sdk.bwdl.NearFieldSwap.callback.BWDLBleBroadcastReceiver;
import com.sdk.bwdl.NearFieldSwap.callback.BWDLDiscoveryCallback;
import com.sdk.bwdl.NearFieldSwap.discovery.DiscoveryDataSubject;
import com.sdk.bwdl.Utils.BWDLLog;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class DiscoveryEngine {
    private static final int MESSAGE_REFRESH_DISCOVERY_DEVICES = 8;
    private static final int MESSAGE_RESTART_DISCOVERY = 6;
    private static final int MESSAGE_SCAN_BATCH_RESULTS_EVENT = 2;
    private static final int MESSAGE_SCAN_FAILED_EVENT = 3;
    private static final int MESSAGE_SCAN_RESULT_EVENT = 1;
    private static final int MESSAGE_START_DISCOVERY = 4;
    private static final int MESSAGE_STOP_DISCOVERY = 5;
    private static final int MESSAGE_UPDATE_DISCOVERY_DEVICE = 7;
    private final int DISCOVERY_TIMEOUT;
    private String TAG;
    private boolean isRunning;
    private List<BWDLDiscoveryData> mBWDLDiscoveryData;
    private BWDLDiscoverySbjectManager mBWDLDiscoverySbjectManager;
    private BWDLReceiver mBWDLReceiver;
    private BleScanHelper mBleScanHelper;
    private BluetoothAdapter mBluetoothAdapter;
    private List<BWDLDiscoveryCallback> mBwdlAllDiscoveryCallback;
    private List<BWDLDiscoveryCallback> mBwdlDiscoveryCallback;
    private Context mContext;
    private BroadcastReceiver mPairingReceiver;
    private ScanCallback mScanCallback;
    private Handler mScanHandler;
    private short mServiceUuid;
    private boolean mState;
    private SystemBroadcastListener mSystemBroadcastListener;

    /* JADX INFO: renamed from: com.sdk.bwdl.NearFieldSwap.DiscoveryEngine$1, reason: invalid class name */
    public class AnonymousClass1 extends Handler {
        final /* synthetic */ DiscoveryEngine this$0;

        public AnonymousClass1(DiscoveryEngine r8, Looper r10) {
            this.this$0 = r8;
            super(r10);
        }

        public static /* synthetic */ boolean a(AnonymousClass1 r8, BWDLDiscoveryData r10) {
            return r8.lambda$handleMessage$0(r10);
        }

        private /* synthetic */ boolean lambda$handleMessage$0(BWDLDiscoveryData r8) {
            return r8.isTimeout(10000);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r8) {
            switch(r8.what) {
                case 1: goto L30;
                case 2: goto L27;
                case 3: goto L20;
                case 4: goto L19;
                case 5: goto L18;
                case 6: goto L17;
                case 7: goto L13;
                case 8: goto L7;
                default: goto L4;
            };
        L4:
            String r10 = DiscoveryEngine.access$400(this.this$0);
            String r11 = "";
        L5:
            BWDLLog.e(r10, r11);
            return;
        L13:
            Iterator r12 = DiscoveryEngine.access$300(this.this$0).iterator();
        L15:
            if (r12.hasNext() == false) goto L44;
            ((BWDLDiscoveryCallback) r12.next()).onDiscoveryDevicesChanged(DiscoveryEngine.access$700(this.this$0));
            goto L15
        L44:
            return;
        L17:
            DiscoveryEngine.access$600(this.this$0);
            goto L19
        L18:
            DiscoveryEngine.access$600(this.this$0);
            return;
        L19:
            DiscoveryEngine.access$500(this.this$0);
            return;
        L20:
            boolean r13 = DiscoveryEngine.access$300(this.this$0).isEmpty();
            DiscoveryEngine r14 = this.this$0;
            if (r13 == true) goto L26;
            Iterator r15 = DiscoveryEngine.access$300(r14).iterator();
        L24:
            if (r15.hasNext() == false) goto L45;
            ((BWDLDiscoveryCallback) r15.next()).onDiscoveryConnected(((Integer) r8.obj).intValue());
            goto L24
        L45:
            return;
        L26:
            r10 = DiscoveryEngine.access$400(r14);
            r11 = "onScanFailed mBwdlDiscoveryCallback is empty ";
            goto L5
        L27:
            Object r16 = r8.obj;
            if (r16 == null) goto L40;
            DiscoveryEngine.access$200(this.this$0, (List) r16);
            return;
        L40:
            return;
        L30:
            Object r17 = r8.obj;
            if (r17 == null) goto L42;
            DiscoveryEngine.access$100(this.this$0, (ScanResult) r17);
            return;
        L42:
            return;
        L7:
            if (DiscoveryEngine.access$700(this.this$0).isEmpty() == true) goto L43;
            DiscoveryEngine.access$800(this.this$0).removeMessages(8);
            if (DiscoveryEngine.access$700(this.this$0).removeIf(new a(this)) == false) goto L12;
            BWDLLog.d(DiscoveryEngine.access$400(this.this$0), "MESSAGE_REFRESH_DISCOVERY_DEVICES");
            DiscoveryEngine.access$800(this.this$0).sendMessage(Message.obtain(DiscoveryEngine.access$800(this.this$0), 7));
        L12:
            DiscoveryEngine.access$800(this.this$0).sendMessageDelayed(Message.obtain(DiscoveryEngine.access$800(this.this$0), 8), 10000);
            return;
        }
    }

    /* JADX INFO: renamed from: com.sdk.bwdl.NearFieldSwap.DiscoveryEngine$4, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$sdk$bwdl$ExternalAPI$BWDLConstant$DISCOVERY_MODE_LEVEL = null;

        static {
            int[] r8 = new int[BWDLConstant.DISCOVERY_MODE_LEVEL.values().length];
            $SwitchMap$com$sdk$bwdl$ExternalAPI$BWDLConstant$DISCOVERY_MODE_LEVEL = r8;
            r8[BWDLConstant.DISCOVERY_MODE_LEVEL.DISCOVERY_MODE_LOW_LATENCY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$sdk$bwdl$ExternalAPI$BWDLConstant$DISCOVERY_MODE_LEVEL[BWDLConstant.DISCOVERY_MODE_LEVEL.DISCOVERY_MODE_LOW_POWER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public class BWDLDiscoverySbjectManager implements DiscoveryDataSubject {
        private Map<Short, Map<Integer, Set<BWDLDiscoveryCallback>>> mObserverMap;
        private Map<Integer, Set<BWDLDiscoveryCallback>> mObserverTypeMap;
        private Map<Short, Set<BWDLDiscoveryCallback>> mObserverUuidMap;
        final /* synthetic */ DiscoveryEngine this$0;

        public BWDLDiscoverySbjectManager(DiscoveryEngine r8) {
            this.this$0 = r8;
            this.mObserverUuidMap = new HashMap();
            this.mObserverTypeMap = new HashMap();
            this.mObserverMap = new HashMap();
        }

        public static /* synthetic */ Map a(Short r8) {
            return lambda$registerObserver$2(r8);
        }

        public static /* synthetic */ Set b(Integer r8) {
            return lambda$registerObserver$3(r8);
        }

        public static /* synthetic */ Set c(Short r8) {
            return lambda$registerObserver$0(r8);
        }

        public static /* synthetic */ Set d(Integer r8) {
            return lambda$registerObserver$1(r8);
        }

        private static /* synthetic */ Set lambda$registerObserver$0(Short r8) {
            return new HashSet();
        }

        private static /* synthetic */ Set lambda$registerObserver$1(Integer r8) {
            return new HashSet();
        }

        private static /* synthetic */ Map lambda$registerObserver$2(Short r8) {
            return new HashMap();
        }

        private static /* synthetic */ Set lambda$registerObserver$3(Integer r8) {
            return new HashSet();
        }

        @Override // com.sdk.bwdl.NearFieldSwap.discovery.DiscoveryDataSubject
        public void notifyDiscoveryConnect(int r8) {
        }

        @Override // com.sdk.bwdl.NearFieldSwap.discovery.DiscoveryDataSubject
        public void notifyDiscoveryResult(short r8, byte r10, BWDLDiscoveryData r11) {
            Map<Integer, Set<BWDLDiscoveryCallback>> r12 = this.mObserverMap.get(Short.valueOf(r8));
            if (r12 == null) goto L10;
            Set<BWDLDiscoveryCallback> r13 = r12.get(Byte.valueOf(r10));
            if (r13 == null) goto L12;
            Iterator<BWDLDiscoveryCallback> r14 = r13.iterator();
        L8:
            if (r14.hasNext() == false) goto L13;
            r14.next().onDiscoveryDataChanged(r8, r10, r11);
            goto L8
        L13:
            return;
        L12:
            return;
        }

        @Override // com.sdk.bwdl.NearFieldSwap.discovery.DiscoveryDataSubject
        public void registerObserver(int r8, BWDLDiscoveryCallback r10) {
            Map<Integer, Set<BWDLDiscoveryCallback>> r11 = this.mObserverTypeMap;
            monitor-enter(r11);
            this.mObserverTypeMap.computeIfAbsent(Integer.valueOf(r8), new d()).add(r10);     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.sdk.bwdl.NearFieldSwap.discovery.DiscoveryDataSubject
        public void unregisterObserver(BWDLDiscoveryCallback r8) {
            Iterator<Map<Integer, Set<BWDLDiscoveryCallback>>> r10 = this.mObserverMap.values().iterator();
        L4:
            if (r10.hasNext() == false) goto L10;
            Map<Integer, Set<BWDLDiscoveryCallback>> r11 = r10.next();
            Iterator<Set<BWDLDiscoveryCallback>> r12 = r11.values().iterator();
        L7:
            if (r12.hasNext() == false) goto L9;
            r12.next().remove(r8);
            goto L7
        L9:
            r11.values().removeIf(new e());
            goto L4
        L10:
            this.mObserverMap.values().removeIf(new f());
        }

        @Override // com.sdk.bwdl.NearFieldSwap.discovery.DiscoveryDataSubject
        public void registerObserver(short r8, int r10, BWDLDiscoveryCallback r11) {
            Map<Short, Map<Integer, Set<BWDLDiscoveryCallback>>> r12 = this.mObserverMap;
            monitor-enter(r12);
            this.mObserverMap.computeIfAbsent(Short.valueOf(r8), new b(0)).computeIfAbsent(Integer.valueOf(r10), new c()).add(r11);     // Catch: Throwable -> L7
            monitor-exit(r12);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.sdk.bwdl.NearFieldSwap.discovery.DiscoveryDataSubject
        public void unregisterObserver(short r8, int r10, BWDLDiscoveryCallback r11) {
            Map<Integer, Set<BWDLDiscoveryCallback>> r12 = this.mObserverMap.get(Short.valueOf(r8));
            if (r12 == null) goto L14;
            Set<BWDLDiscoveryCallback> r13 = r12.get(Integer.valueOf(r10));
            if (r13 != null) goto L7;
            return;
        L7:
            if (r13.remove(r11) == true) goto L9;
            return;
        L9:
            if (r13.isEmpty() == false) goto L17;
            r12.remove(Integer.valueOf(r10));
            if (r12.isEmpty() == false) goto L18;
            this.mObserverMap.remove(Short.valueOf(r8));
            return;
        L18:
            return;
        L17:
            return;
        }

        @Override // com.sdk.bwdl.NearFieldSwap.discovery.DiscoveryDataSubject
        public void registerObserver(short r8, BWDLDiscoveryCallback r10) {
            Map<Short, Set<BWDLDiscoveryCallback>> r11 = this.mObserverUuidMap;
            monitor-enter(r11);
            this.mObserverUuidMap.computeIfAbsent(Short.valueOf(r8), new b(1)).add(r10);     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.sdk.bwdl.NearFieldSwap.discovery.DiscoveryDataSubject
        public void unregisterObserver(short r8, BWDLDiscoveryCallback r10) {
            Set<BWDLDiscoveryCallback> r11 = this.mObserverUuidMap.get(Short.valueOf(r8));
            if (r11 != null) goto L5;
            return;
        L5:
            if (r11.remove(r10) == true) goto L7;
            return;
        L7:
            if (r11.isEmpty() == false) goto L12;
            this.mObserverUuidMap.remove(Short.valueOf(r8));
            return;
        }
    }

    public class SystemBroadcastListener implements BWDLReceiver.ISystemBroadcastListener {
        final /* synthetic */ DiscoveryEngine this$0;

        private SystemBroadcastListener(DiscoveryEngine r8) {
            this.this$0 = r8;
        }

        @Override // com.sdk.bwdl.BWDLReceiver.ISystemBroadcastListener
        public void onBtStateChanged(int r8) {
            if (r8 != 12) goto L6;
            DiscoveryEngine.access$1000(this.this$0);
            return;
        L6:
            if (r8 != 13) goto L8;
        L9:
            DiscoveryEngine.access$1102(this.this$0, false);
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

        public /* synthetic */ SystemBroadcastListener(DiscoveryEngine r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public DiscoveryEngine(Context r8) {
        this.TAG = "DiscoveryEngine";
        this.mBwdlDiscoveryCallback = new CopyOnWriteArrayList();
        this.mBwdlAllDiscoveryCallback = new CopyOnWriteArrayList();
        this.mBWDLDiscoveryData = new CopyOnWriteArrayList();
        this.isRunning = false;
        this.mState = false;
        this.mServiceUuid = 0;
        this.DISCOVERY_TIMEOUT = KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD;
        this.mScanHandler = new AnonymousClass1(this, Looper.getMainLooper());
        this.mScanCallback = new AnonymousClass2(this);
        this.mContext = r8;
        registerBroadcastListener();
        init();
    }

    public static /* synthetic */ void access$100(DiscoveryEngine r8, ScanResult r10) {
        r8.handleScanResultData(r10);
    }

    public static /* synthetic */ boolean access$1000(DiscoveryEngine r8) {
        return r8.init();
    }

    public static /* synthetic */ boolean access$1102(DiscoveryEngine r8, boolean r10) {
        r8.mState = r10;
        return r10;
    }

    public static /* synthetic */ void access$200(DiscoveryEngine r8, List r10) {
        r8.handleScanResponseData(r10);
    }

    public static /* synthetic */ List access$300(DiscoveryEngine r8) {
        return r8.mBwdlDiscoveryCallback;
    }

    public static /* synthetic */ String access$400(DiscoveryEngine r8) {
        return r8.TAG;
    }

    public static /* synthetic */ void access$500(DiscoveryEngine r8) {
        r8.internalStart();
    }

    public static /* synthetic */ void access$600(DiscoveryEngine r8) {
        r8.internalStop();
    }

    public static /* synthetic */ List access$700(DiscoveryEngine r8) {
        return r8.mBWDLDiscoveryData;
    }

    public static /* synthetic */ Handler access$800(DiscoveryEngine r8) {
        return r8.mScanHandler;
    }

    public static /* synthetic */ Context access$900(DiscoveryEngine r8) {
        return r8.mContext;
    }

    private void handleScanResponseData(List<ScanResult> r8) {
    }

    private void handleScanResultData(ScanResult r13) {
        BWDLAdvDataParser r8 = new BWDLAdvDataParser(this.mContext, r13);
        if (r8.getHasValidBWDLData() == true) goto L5;
        return;
    L5:
        if (this.mBwdlDiscoveryCallback.isEmpty() == true) goto L41;
        List<BWDLAdvertisingData> r14 = r8.getBWDLDiscoveryData().getBWDLAdvertisingData();
        if (r14 != null) goto L9;
        return;
    L9:
        if (r14.isEmpty() == true) goto L70;
        Iterator<BWDLAdvertisingData> r15 = r14.iterator();
    L13:
        if (r15.hasNext() == false) goto L41;
        BWDLAdvertisingData r10 = r15.next();
        short r11 = this.mServiceUuid;
        if (r11 == 0) goto L13;
        if (r11 != r10.getServiceUuid()) goto L13;
        BWDLDiscoveryData r12 = r8.getBWDLDiscoveryData();
        if (this.mBWDLDiscoveryData.contains(r12) == true) goto L71;
        if (r12 == null) goto L72;
        if (this.mBWDLDiscoveryData.isEmpty() == true) goto L24;
        Iterator<BWDLDiscoveryData> r16 = this.mBWDLDiscoveryData.iterator();
    L27:
        if (r16.hasNext() == false) goto L36;
        BWDLDiscoveryData r17 = r16.next();
        String r18 = Arrays.toString(r17.getAdvertisingData().getFeatureData());
        String r19 = Arrays.toString(r12.getAdvertisingData().getFeatureData());
        if (r17.getDeviceId() != r12.getDeviceId()) goto L27;
        if (r17.getMacAddress().equals(r12.getMacAddress()) == true) goto L33;
    L35:
        BWDLLog.d(this.TAG, "handleScanResultData remove " + r17.getDeviceName());
        this.mBWDLDiscoveryData.remove(r17);
        goto L27
    L33:
        if (r18.equals(r19) == false) goto L35;
        r17.updateTimeStamp(r12.getTimeStamp());
        boolean r20 = true;
    L37:
        if (r20 == true) goto L13;
        BWDLLog.d(this.TAG, "handleScanResultData new device " + r12.getDeviceName());
        goto L24
    L36:
        r20 = false;
    L24:
        this.mBWDLDiscoveryData.add(r12);
        Handler r21 = this.mScanHandler;
        r21.sendMessage(Message.obtain(r21, 7));
        Handler r22 = this.mScanHandler;
        r22.sendMessageDelayed(Message.obtain(r22, 8), 10000);
        goto L13
    L72:
        return;
    L71:
        return;
    L70:
        return;
    L41:
        if (this.mBwdlAllDiscoveryCallback.isEmpty() == true) goto L73;
        BWDLLog.d(this.TAG, "handleScanResultData mBwdlAllDiscoveryCallback" + this.mBwdlAllDiscoveryCallback);
        Iterator<BWDLDiscoveryCallback> r110 = this.mBwdlAllDiscoveryCallback.iterator();
    L44:
        if (r110.hasNext() == false) goto L74;
        BWDLDiscoveryCallback r111 = r110.next();
        Iterator<BWDLAdvertisingData> r23 = r8.getBWDLDiscoveryData().getBWDLAdvertisingData().iterator();
    L47:
        if (r23.hasNext() == false) goto L44;
        BWDLAdvertisingData r24 = r23.next();
        r111.onDiscoveryDataChanged(r24.getServiceUuid(), r24.getFeatureType(), r8.getBWDLDiscoveryData());
        goto L47
    L74:
        return;
    }

    private boolean init() {
        BluetoothAdapter r8 = BluetoothAdapter.getDefaultAdapter();
        if (r8.isEnabled() == false) goto L5;
        this.mBluetoothAdapter = r8;
        this.mBleScanHelper = new BleExternalScanner(this.mContext, r8);
        this.mBWDLDiscoverySbjectManager = new BWDLDiscoverySbjectManager(this);
        boolean r10 = true;
    L6:
        this.mState = r10;
        BWDLLog.d(this.TAG, "DiscoveryEngine enabled:" + this.mState);
        return this.mState;
    L5:
        r10 = false;
        goto L6
    }

    private void internalStart() {
        if (this.mScanCallback != null) goto L6;
        return;
    L6:
        if (this.mBWDLDiscoveryData.isEmpty() == true) goto L9;
        this.mBWDLDiscoveryData.clear();
    L9:
        if (isDiscoveryStartRunning() == true) goto L12;
        this.mBleScanHelper.startScan(this.mScanCallback);
        this.isRunning = true;
        return;
    }

    private void internalStop() {
        if (this.mScanCallback != null) goto L5;
        return;
    L5:
        BluetoothAdapter r8 = BluetoothAdapter.getDefaultAdapter();
        if (r8 != null) goto L8;
        return;
    L8:
        if (r8.isEnabled() == true) goto L11;
        return;
    L11:
        if (isDiscoveryStartRunning() == false) goto L15;
        this.mBleScanHelper.stopScan(this.mScanCallback);
        this.isRunning = false;
        return;
    }

    private void registerBroadcastListener() {
        this.mSystemBroadcastListener = new SystemBroadcastListener(this, null);
        BWDLReceiver r8 = BWDLReceiver.getInstance(this.mContext);
        this.mBWDLReceiver = r8;
        r8.setSystemBroadcastListener(this.mSystemBroadcastListener);
    }

    public boolean exit() {
        this.mBWDLDiscoveryData.clear();
        this.mBwdlDiscoveryCallback.clear();
        this.mBwdlAllDiscoveryCallback.clear();
        this.mState = false;
        return true;
    }

    public boolean isDiscoveryStartRunning() {
        return this.isRunning;
    }

    public boolean isReady() {
        return this.mState;
    }

    public void pair(String r8, BWDLBleBroadcastReceiver r10) {
        startPairing(r8, r10);
    }

    public void parseAdvData() {
    }

    public void set() {
    }

    public void setDiscoveryInterval(BWDLConstant.DISCOVERY_MODE_LEVEL r8) {
        int r10 = AnonymousClass4.$SwitchMap$com$sdk$bwdl$ExternalAPI$BWDLConstant$DISCOVERY_MODE_LEVEL[r8.ordinal()];
        BleScanHelper r11 = this.mBleScanHelper;
        if (r10 == 1) goto L7;
        if (r10 == 2) goto L6;
        r11.setScanMode(1);
        return;
    L6:
        r11.setScanMode(0);
        return;
    L7:
        r11.setScanMode(2);
    }

    public void start(byte r8, BWDLDiscoveryCallback r10) {
        List<BWDLDiscoveryCallback> r11 = this.mBwdlDiscoveryCallback;
        if (r11 == null) goto L5;
        r11.add(r10);
    L5:
        Handler r12 = this.mScanHandler;
        r12.sendMessage(Message.obtain(r12, 4));
    }

    public void startPairing(final String r8, final BWDLBleBroadcastReceiver r10) {
        BWDLLog.e(this.TAG, "startAutoPairing deviceAddress receiver....." + r10);
        BWDLLog.e(this.TAG, "startAutoPairing deviceAddress deviceAddress....." + r8);
        this.mPairingReceiver = new AnonymousClass3(this, r8, r10);
        this.mContext.registerReceiver(this.mPairingReceiver, new IntentFilter("android.bluetooth.device.action.BOND_STATE_CHANGED"));
        BWDLLog.e(this.TAG, "startAutoPairing registerReceiver - ACTION_BOND_STATE_CHANGED");
        BluetoothDevice r11 = this.mBluetoothAdapter.getRemoteDevice(r8);
        if (r11 == null) goto L12;
        boolean r12 = r11.setPin(new byte[]{1, 2, 3, 4, 5, 6});
        String r13 = this.TAG;
        if (r12 == false) goto L7;
        StringBuilder r14 = new StringBuilder("startAutoPairing  device.createBond  success -");
    L8:
        r14.append(r12);
        BWDLLog.e(r13, r14.toString());
        if (r11.getBondState() != 10) goto L11;
        boolean r15 = r11.createBond();
        String r16 = this.TAG;
        String r17 = "startAutoPairing  device.createBond  start -" + r15;
    L13:
        BWDLLog.e(r16, r17);
        return;
    L11:
        r16 = this.TAG;
        r17 = "startAutoPairing  device.createBond  ok";
        goto L13
    L7:
        r14 = new StringBuilder("startAutoPairing  device.createBond  success failed -");
        goto L8
    L12:
        r16 = this.TAG;
        r17 = "startAutoPairing device.createBond failed";
        goto L13
    }

    public void stop(ScanCallback r8) {
        this.mBleScanHelper.stopScan(r8);
    }

    public DiscoveryEngine(Context r8, BluetoothAdapter r10) {
        this.TAG = "DiscoveryEngine";
        this.mBwdlDiscoveryCallback = new CopyOnWriteArrayList();
        this.mBwdlAllDiscoveryCallback = new CopyOnWriteArrayList();
        this.mBWDLDiscoveryData = new CopyOnWriteArrayList();
        this.isRunning = false;
        this.mState = false;
        this.mServiceUuid = 0;
        this.DISCOVERY_TIMEOUT = KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD;
        this.mScanHandler = new AnonymousClass1(this, Looper.getMainLooper());
        this.mScanCallback = new AnonymousClass2(this);
        this.mContext = r8;
        this.mBluetoothAdapter = r10;
        this.mBleScanHelper = new BleExternalScanner(r8, r10);
        this.mBWDLDiscoverySbjectManager = new BWDLDiscoverySbjectManager(this);
    }

    public void start(BWDLDiscoveryCallback r8) {
        List<BWDLDiscoveryCallback> r10 = this.mBwdlAllDiscoveryCallback;
        if (r10 == null) goto L5;
        r10.add(r8);
    L5:
        Handler r11 = this.mScanHandler;
        r11.sendMessage(Message.obtain(r11, 4));
    }

    public void stop(BWDLDiscoveryCallback r8) {
        if (r8 != null) goto L4;
    L17:
        BWDLLog.d(this.TAG, "stop callback is not exist");
        return;
    L4:
        if (this.mBwdlDiscoveryCallback.contains(r8) == false) goto L17;
        List<BWDLDiscoveryCallback> r10 = this.mBwdlDiscoveryCallback;
        if (r10 == null) goto L10;
        r10.remove(r8);
    L10:
        if (this.mBwdlAllDiscoveryCallback == null) goto L13;
        this.mBwdlDiscoveryCallback.remove(r8);
    L13:
        if (this.mBWDLDiscoveryData.isEmpty() == true) goto L15;
        this.mBWDLDiscoveryData.clear();
    L15:
        Handler r11 = this.mScanHandler;
        r11.sendMessage(Message.obtain(r11, 5));
    }

    public void start(short r8, byte r10, BWDLDiscoveryCallback r11) {
        List<BWDLDiscoveryCallback> r12 = this.mBwdlDiscoveryCallback;
        if (r12 == null) goto L5;
        r12.add(r11);
    L5:
        Handler r13 = this.mScanHandler;
        r13.sendMessage(Message.obtain(r13, 4));
    }

    public void start(short r8, BWDLDiscoveryCallback r10) {
        if (this.mBwdlDiscoveryCallback.contains(r10) == false) goto L6;
        BWDLLog.d(this.TAG, "start callback is already exist");
        return;
    L6:
        List<BWDLDiscoveryCallback> r11 = this.mBwdlDiscoveryCallback;
        if (r11 == null) goto L9;
        r11.add(r10);
    L9:
        this.mServiceUuid = r8;
        Handler r12 = this.mScanHandler;
        r12.sendMessage(Message.obtain(r12, 4));
    }
}
