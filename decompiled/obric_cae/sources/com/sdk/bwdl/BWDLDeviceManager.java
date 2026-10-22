package com.sdk.bwdl;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import com.sdk.bwdl.AdapterLayer.GATT.GattAdapter.GattOriginal;
import com.sdk.bwdl.AdapterLayer.IBWDLAdapter;
import com.sdk.bwdl.AdapterLayer.IBWDLAdapterEventListener;
import com.sdk.bwdl.AdapterLayer.Wifi.P2p.P2pAdapter;
import com.sdk.bwdl.ExternalAPI.BWDLConfigs;
import com.sdk.bwdl.StateMachine.ControlLinkSM;
import com.sdk.bwdl.Utils.BWDLInnerConstant;
import com.sdk.bwdl.Utils.BWDLLog;
import defpackage.b;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class BWDLDeviceManager {
    private static final String TAG = "BWDLDeviceManager";
    private static volatile BWDLDeviceManager sInstance;
    private BWDLAdapterEventListener mAdapterEventListener;
    private IBWDLAdapter mBWDLAdapter;
    private final ConcurrentMap<String, BWDLConfigs> mBWDLConfigMap;
    private BWDLReceiver mBWDLReceiver;
    private Context mContext;
    private List<ControlLink> mControlLinkList;
    private final Object mControlLinkLock;
    private ControlLinkSMListener mControlLinkSMListener;
    private final ConcurrentMap<Object, ControlLinkSM> mControlLinkSmMap;
    private IBWDLAdapter mP2PAdapter;
    private SystemBroadcastListener mSystemBroadcastListener;

    /* JADX INFO: renamed from: com.sdk.bwdl.BWDLDeviceManager$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class BWDLAdapterEventListener implements IBWDLAdapterEventListener {
        final /* synthetic */ BWDLDeviceManager this$0;

        private BWDLAdapterEventListener(BWDLDeviceManager r8) {
            this.this$0 = r8;
        }

        @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapterEventListener
        public void onBondStateChanged(BWDLDevice r8, int r10) {
        }

        @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapterEventListener
        public void onConnectTimeOut(IBWDLAdapter r8) {
        }

        @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapterEventListener
        public void onConnected(IBWDLAdapter r8) {
        }

        @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapterEventListener
        public void onConnectionStateChanged(BWDLDevice r8, int r10) {
            int r11 = BWDLDeviceManager.access$300(this.this$0, r8);
            StringBuilder r12 = b.f("onConnectionStateChanged:", r10, " deviceId exit:");
            r12.append(BWDLDeviceManager.access$400(this.this$0).containsKey(Integer.valueOf(r11)));
            r12.append(" deviceId:");
            r12.append(r11);
            BWDLLog.d(BWDLDeviceManager.TAG, r12.toString());
            if (BWDLDeviceManager.access$500(this.this$0).isEmpty() == false) goto L6;
            return;
        L6:
            if (r10 == 4) goto L8;
            return;
        L8:
            if (BWDLDeviceManager.access$400(this.this$0).containsKey(Integer.valueOf(r11)) == true) goto L12;
            BWDLDeviceManager.access$600(this.this$0, r8).sendMessage(300, r10, 0, r8);
            return;
        }

        @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapterEventListener
        public void onDataReceived(byte[] r8) {
        }

        @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapterEventListener
        public void onDisconnected(IBWDLAdapter r8) {
        }

        @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapterEventListener
        public void onWriteComplete(int r8) {
        }

        public /* synthetic */ BWDLAdapterEventListener(BWDLDeviceManager r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public class ControlLinkSMListener implements ControlLinkSM.IControlLinkSMListener {
        final /* synthetic */ BWDLDeviceManager this$0;

        private ControlLinkSMListener(BWDLDeviceManager r8) {
            this.this$0 = r8;
        }

        @Override // com.sdk.bwdl.StateMachine.ControlLinkSM.IControlLinkSMListener
        public void onStateChanged(BWDLDevice r8, BWDLInnerConstant.ControlLinkSmState r10, BWDLInnerConstant.ControlLinkSmState r11, int r12) {
            BWDLLog.d(BWDLDeviceManager.TAG, "ControlLinkSM transform：" + r10 + " to " + r11);
            if (r11 != BWDLInnerConstant.ControlLinkSmState.DisconnectedState) goto L6;
            BWDLDeviceManager.access$700(this.this$0, r8);
            return;
        }

        public /* synthetic */ ControlLinkSMListener(BWDLDeviceManager r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public class SystemBroadcastListener implements BWDLReceiver.ISystemBroadcastListener {
        final /* synthetic */ BWDLDeviceManager this$0;

        private SystemBroadcastListener(BWDLDeviceManager r8) {
            this.this$0 = r8;
        }

        @Override // com.sdk.bwdl.BWDLReceiver.ISystemBroadcastListener
        public void onBtStateChanged(int r8) {
            if (r8 != 12) goto L6;
            BWDLDeviceManager.access$800(this.this$0);
            return;
        L6:
            if (r8 != 10) goto L10;
            BWDLDeviceManager.access$900(this.this$0);
            return;
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

        public /* synthetic */ SystemBroadcastListener(BWDLDeviceManager r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    private BWDLDeviceManager(Context r8) {
        AnonymousClass1 r10 = null;
        this.mControlLinkSMListener = new ControlLinkSMListener(this, r10);
        this.mSystemBroadcastListener = new SystemBroadcastListener(this, r10);
        this.mControlLinkLock = new Object();
        this.mControlLinkSmMap = new ConcurrentHashMap();
        this.mBWDLConfigMap = new ConcurrentHashMap();
        this.mControlLinkList = new CopyOnWriteArrayList();
        this.mContext = r8;
        this.mAdapterEventListener = new BWDLAdapterEventListener(this, r10);
        init();
        BWDLReceiver r11 = BWDLReceiver.getInstance(this.mContext);
        this.mBWDLReceiver = r11;
        r11.setSystemBroadcastListener(this.mSystemBroadcastListener);
    }

    public static /* synthetic */ int access$300(BWDLDeviceManager r8, BWDLDevice r10) {
        return r8.getDeviceIdByBwdlDevice(r10);
    }

    public static /* synthetic */ ConcurrentMap access$400(BWDLDeviceManager r8) {
        return r8.mControlLinkSmMap;
    }

    public static /* synthetic */ ConcurrentMap access$500(BWDLDeviceManager r8) {
        return r8.mBWDLConfigMap;
    }

    public static /* synthetic */ ControlLinkSM access$600(BWDLDeviceManager r8, BWDLDevice r10) {
        return r8.getOrCreateControlLinkSM(r10);
    }

    public static /* synthetic */ void access$700(BWDLDeviceManager r8, BWDLDevice r10) {
        r8.destroyControlLinkSM(r10);
    }

    public static /* synthetic */ void access$800(BWDLDeviceManager r8) {
        r8.init();
    }

    public static /* synthetic */ void access$900(BWDLDeviceManager r8) {
        r8.cleanForBTOff();
    }

    private void cleanForBTOff() {
        BWDLLog.d(TAG, "cleanForBTOff");
        Object r8 = this.mControlLinkLock;
        monitor-enter(r8);
        Iterator<ControlLinkSM> r10 = this.mControlLinkSmMap.values().iterator();     // Catch: Throwable -> L13
    L6:
        if (r10.hasNext() == false) goto L8;
        r10.next().cleanup();     // Catch: Throwable -> L13
        goto L6
    L8:
        this.mControlLinkSmMap.clear();     // Catch: Throwable -> L13
        this.mControlLinkList.clear();     // Catch: Throwable -> L13
        IBWDLAdapter r11 = this.mBWDLAdapter;     // Catch: Throwable -> L13
        if (r11 == null) goto L11;
        r11.close();     // Catch: Throwable -> L13
        this.mBWDLAdapter = null;     // Catch: Throwable -> L13
    L11:
        monitor-exit(r8);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    private void destroyControlLinkSM(BWDLDevice r8) {
        if (r8 != null) goto L5;
        return;
    L5:
        Object r10 = this.mControlLinkLock;
        monitor-enter(r10);
        ControlLinkSM r11 = this.mControlLinkSmMap.get(Integer.valueOf(r8.getDeviceId()));     // Catch: Throwable -> L15
        if (r11 != null) goto L12;
        BWDLLog.d(TAG, "destroyControlLinkSM: " + r8.getDeviceId() + " have none state machine");     // Catch: Throwable -> L15
        monitor-exit(r10);     // Catch: Throwable -> L15
        return;
    L12:
        BWDLLog.d(TAG, "destroyControlLinkSM: destroy state machine for device: " + r8.getDeviceId());     // Catch: Throwable -> L15
        r11.removeControlLinkSMListener(this.mControlLinkSMListener);     // Catch: Throwable -> L15
        r11.cleanup();     // Catch: Throwable -> L15
        this.mControlLinkSmMap.remove(Integer.valueOf(r8.getDeviceId()));     // Catch: Throwable -> L15
        monitor-exit(r10);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    }

    private int getDeviceIdByBwdlDevice(BWDLDevice r8) {
        List<ControlLink> r10 = this.mControlLinkList;
        monitor-enter(r10);
        Iterator<ControlLink> r11 = this.mControlLinkList.iterator();     // Catch: Throwable -> L15
    L6:
        if (r11.hasNext() == false) goto L12;
        ControlLinkProperty r12 = r11.next().getControlLinkProperty();     // Catch: Throwable -> L15
        if (r12.getBWDLDevice().getDeviceInfo() != r8.getDeviceInfo()) goto L6;
        BWDLLog.d(TAG, "Same device info");     // Catch: Throwable -> L15
        int r13 = r12.getBWDLDevice().getDeviceId();     // Catch: Throwable -> L15
        monitor-exit(r10);     // Catch: Throwable -> L15
        return r13;
    L12:
        monitor-exit(r10);     // Catch: Throwable -> L15
        return 0;
    L15:
        th = move-exception;
        throw th;
    }

    public static BWDLDeviceManager getInstance(Context r8) {
        if (sInstance != null) goto L15;
        monitor-enter(BWDLDeviceManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new BWDLDeviceManager(r8);     // Catch: Throwable -> L11
    L9:
        monitor-exit(BWDLDeviceManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private ControlLinkSM getOrCreateControlLinkSM(BWDLDevice r8) {
        if (r8 != null) goto L6;
        return null;
    L6:
        Object r10 = this.mControlLinkLock;
        monitor-enter(r10);
        ControlLinkSM r11 = this.mControlLinkSmMap.get(Integer.valueOf(r8.getDeviceId()));     // Catch: Throwable -> L17
        if (r11 == null) goto L12;
        monitor-exit(r10);     // Catch: Throwable -> L17
        return r11;
    L12:
        BWDLLog.d(TAG, "Create a new control link state machine for " + r8.getDeviceId());     // Catch: Throwable -> L17
        ControlLinkSM r12 = new ControlLinkSM(this.mContext, r8);     // Catch: Throwable -> L17
        r12.setControlLinkSMListener(this.mControlLinkSMListener);     // Catch: Throwable -> L17
        if (r8.getDeviceId() == 0) goto L15;
        this.mControlLinkSmMap.put(Integer.valueOf(r8.getDeviceId()), r12);     // Catch: Throwable -> L17
    L15:
        monitor-exit(r10);     // Catch: Throwable -> L17
        return r12;
    L17:
        th = move-exception;
        throw th;
    }

    private void init() {
        if (BluetoothAdapter.getDefaultAdapter().isEnabled() == false) goto L5;
        GattOriginal r8 = GattOriginal.getInstance(this.mContext);
        this.mBWDLAdapter = r8;
        r8.setBWDLAdapterEventListener(this.mAdapterEventListener);
        this.mBWDLAdapter.init();
        return;
    L5:
        BWDLLog.d(TAG, "BT is not enabled");
    }

    private boolean isConfigurationStatePassed(ControlLinkSM r8) {
        if (r8.getCurrentSmState().ordinal() < BWDLInnerConstant.ControlLinkSmState.ConfigurationState.ordinal()) goto L6;
        return true;
    L6:
        return false;
    }

    public void cleanup() {
        Object r8 = this.mControlLinkLock;
        monitor-enter(r8);
        Iterator<ControlLinkSM> r10 = this.mControlLinkSmMap.values().iterator();     // Catch: Throwable -> L18
    L6:
        if (r10.hasNext() == false) goto L8;
        r10.next().cleanup();     // Catch: Throwable -> L18
        goto L6
    L8:
        this.mControlLinkSmMap.clear();     // Catch: Throwable -> L18
        this.mControlLinkList.clear();     // Catch: Throwable -> L18
        this.mBWDLConfigMap.clear();     // Catch: Throwable -> L18
        IBWDLAdapter r11 = this.mBWDLAdapter;     // Catch: Throwable -> L18
        if (r11 == null) goto L11;
        r11.close();     // Catch: Throwable -> L18
        this.mBWDLAdapter = null;     // Catch: Throwable -> L18
    L11:
        IBWDLAdapter r12 = this.mP2PAdapter;     // Catch: Throwable -> L18
        if (r12 != null) goto L14;
    L16:
        monitor-exit(r8);     // Catch: Throwable -> L18
        return;
    L14:
        if ((r12 instanceof P2pAdapter) == false) goto L16;
        ((P2pAdapter) r12).cleanup();     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    public boolean connect(BWDLConfigs r8, BWDLDevice r10) {
        String r11 = r8.getFeatureName();
        if (r11 != null) goto L5;
        boolean r12 = true;
    L6:
        if (r10 != null) goto L8;
        boolean r13 = true;
    L10:
        if ((r12 | r13) == false) goto L12;
        return false;
    L12:
        ControlLinkSM r14 = getOrCreateControlLinkSM(r10);
        ControlLink r15 = isControlLinkExit(r11, r10);
        if (r15 != null) goto L19;
        r15 = createControlLink(r11, r10, r14);
        if (r15 != null) goto L19;
        BWDLLog.d(TAG, "control link create fail");
        return false;
    L19:
        if (r14.getCurrentSmState() != BWDLInnerConstant.ControlLinkSmState.ActiveState) goto L23;
        r15.sendConnectedToUpper();
        return true;
    L23:
        if (isConfigurationStatePassed(r14) == false) goto L25;
        r14.getChannelConfiguration().channelConfig(r11);
    L26:
        return true;
    L25:
        r14.sendMessage(100, r10);
        goto L26
    L8:
        r13 = false;
        goto L10
    L5:
        r12 = false;
        goto L6
    }

    public ControlLink createControlLink(String r8, BWDLDevice r10, ControlLinkSM r11) {
        BWDLLog.d(TAG, "createControlLink");
        BWDLConfigs r12 = this.mBWDLConfigMap.get(r8);
        if (r12 != null) goto L6;
        return null;
    L6:
        ControlLink r13 = new ControlLink(this.mContext, r12, r11, r10);
        r11.addControlLinkToSm(r13);
        this.mControlLinkList.add(r13);
        return r13;
    }

    public boolean disconnect(BWDLConfigs r8, BWDLDevice r10) {
        BWDLLog.d(TAG, "disconnect");
        String r11 = r8.getFeatureName();
        if (r11 != null) goto L5;
        boolean r12 = true;
    L6:
        if (r10 != null) goto L8;
        boolean r13 = true;
    L10:
        if ((r12 | r13) == false) goto L12;
        return false;
    L12:
        List<ControlLink> r14 = this.mControlLinkList;
        monitor-enter(r14);
        Iterator<ControlLink> r15 = this.mControlLinkList.iterator();     // Catch: Throwable -> L26
    L16:
        if (r15.hasNext() == false) goto L24;
        ControlLinkProperty r16 = r15.next().getControlLinkProperty();     // Catch: Throwable -> L26
        if (r16.getFeature().equals(r11) == false) goto L16;
        if (r16.getBWDLDevice().getDeviceId() != r10.getDeviceId()) goto L16;
        r16.getControlLink().disconnect();     // Catch: Throwable -> L26
        monitor-exit(r14);     // Catch: Throwable -> L26
        return true;
    L24:
        monitor-exit(r14);     // Catch: Throwable -> L26
        return false;
    L26:
        th = move-exception;
        throw th;
    L8:
        r13 = false;
        goto L10
    L5:
        r12 = false;
        goto L6
    }

    public boolean isBWDLFeatureExit(String r8) {
        return this.mBWDLConfigMap.containsKey(r8);
    }

    public ControlLink isControlLinkExit(String r8, BWDLDevice r10) {
        BWDLLog.d(TAG, "isControlLinkExit");
        List<ControlLink> r11 = this.mControlLinkList;
        monitor-enter(r11);
        Iterator<ControlLink> r12 = this.mControlLinkList.iterator();     // Catch: Throwable -> L17
    L6:
        if (r12.hasNext() == false) goto L14;
        ControlLink r13 = r12.next();     // Catch: Throwable -> L17
        ControlLinkProperty r14 = r13.getControlLinkProperty();     // Catch: Throwable -> L17
        if (r14.getFeature().equals(r8) == false) goto L6;
        if (r14.getBWDLDevice().getDeviceId() != r10.getDeviceId()) goto L6;
        BWDLLog.d(TAG, "ControlLink already exit");     // Catch: Throwable -> L17
        monitor-exit(r11);     // Catch: Throwable -> L17
        return r13;
    L14:
        monitor-exit(r11);     // Catch: Throwable -> L17
        return null;
    L17:
        th = move-exception;
        throw th;
    }

    public void listen(BWDLConfigs r8, BWDLDevice r10) {
        BWDLLog.d(TAG, "Listen");
        if (r10.getConnectivityType() != BWDLInnerConstant.ConnectivityType.GATT) goto L5;
        this.mBWDLAdapter = GattOriginal.getInstance(this.mContext);
    L5:
        this.mBWDLAdapter.setBWDLAdapterEventListener(this.mAdapterEventListener);
    }

    public boolean registerFeature(BWDLConfigs r8) {
        String r10 = r8.getFeatureName();
        if (this.mBWDLConfigMap.containsKey(r10) == false) goto L6;
        BWDLLog.d(TAG, "Feature is already registered");
        return false;
    L6:
        this.mBWDLConfigMap.put(r10, r8);
        return true;
    }

    public void removeControlLinkFromList(ControlLink r8) {
        List<ControlLink> r10 = this.mControlLinkList;
        monitor-enter(r10);
        this.mControlLinkList.remove(r8);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void unRegisterFeature(BWDLConfigs r8) {
        String r10 = r8.getFeatureName();
        if (this.mBWDLConfigMap.containsKey(r10) == false) goto L6;
        this.mBWDLConfigMap.remove(r10);
        return;
    }

    public void updateControlLinkSmMap(int r8, ControlLinkSM r10) {
        ConcurrentMap<Object, ControlLinkSM> r11 = this.mControlLinkSmMap;
        monitor-enter(r11);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.mControlLinkSmMap.containsValue(r10) == false) goto L12;
        Iterator<Object> r12 = this.mControlLinkSmMap.keySet().iterator();     // Catch: Throwable -> L15
    L8:
        if (r12.hasNext() == false) goto L13;
        Object r13 = r12.next();     // Catch: Throwable -> L15
        if (this.mControlLinkSmMap.get(r13) != r10) goto L8;
        this.mControlLinkSmMap.remove(r13);     // Catch: Throwable -> L15
        this.mControlLinkSmMap.put(Integer.valueOf(r8), r10);     // Catch: Throwable -> L15
    L13:
        monitor-exit(r11);     // Catch: Throwable -> L15
        return;
    L12:
        BWDLLog.d(TAG, "updateControlLinkSmMap:" + r8);     // Catch: Throwable -> L15
        this.mControlLinkSmMap.put(Integer.valueOf(r8), r10);     // Catch: Throwable -> L15
        goto L13
    }
}
