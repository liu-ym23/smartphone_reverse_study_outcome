package com.sdk.bwdl.AdapterLayer.Wifi.P2p;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.net.wifi.p2p.WifiP2pConfig;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pGroup;
import android.net.wifi.p2p.WifiP2pInfo;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.sdk.bwdl.Utils.BWDLLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class P2pController {
    private static final int P2P_CONNECT_TIMEOUT_MS = 10000;
    private static final int P2P_GROUP_CREATE_MAX_RETRY_COUNT = 5;
    private static final String TAG = "P2pAdapter";
    private static volatile P2pController sInstance;
    private List<WifiP2pDevice> mClients;
    private final WifiP2pManager.ActionListener mConnectActionListener;
    private boolean mConnectTimeoutTimerSet;
    private int mConnectionCounter;
    private Context mContext;
    private final WifiP2pManager.ActionListener mCreateGroupListener;
    private int mCreateGroupRetryCount;
    private final WifiP2pManager.DeviceInfoListener mDeviceInfoListener;
    private final WifiP2pManager.GroupInfoListener mGroupInfoListener;
    private Handler mHander;
    private NetworkInfo mNetworkInfo;
    private WifiP2pDevice mOwner;
    private int mP2pBand;
    private P2pOriginal mP2pOriginal;
    private final WifiP2pManager.P2pStateListener mP2pStateListener;
    private WifiCapabilities mPeerCapabilities;
    private final BroadcastReceiver mReceiver;
    private final WifiP2pManager.ActionListener mRemoveClientListener;
    private final WifiP2pManager.ActionListener mRemoveGroupListener;
    private int mRole;
    private int mState;
    private Handler mTimeoutHandler;
    private Runnable mTimeoutTask;
    private WifiManager mWifiManager;
    private WifiP2pConfig mWifiP2pConfig;
    private WifiP2pDevice mWifiP2pDevice;
    private WifiP2pGroup mWifiP2pGroup;
    private WifiP2pInfo mWifiP2pInfo;

    public P2pController(Context r8, int r10) {
        this.mClients = new ArrayList();
        this.mConnectTimeoutTimerSet = false;
        this.mP2pBand = 0;
        this.mP2pStateListener = new AnonymousClass1(this);
        this.mConnectActionListener = new AnonymousClass3(this);
        this.mCreateGroupListener = new AnonymousClass4(this);
        this.mGroupInfoListener = new AnonymousClass5(this);
        this.mDeviceInfoListener = new AnonymousClass6(this);
        this.mRemoveGroupListener = new AnonymousClass7(this);
        this.mRemoveClientListener = new AnonymousClass8(this);
        this.mReceiver = new AnonymousClass9(this);
        this.mContext = r8;
        this.mP2pBand = r10;
        this.mTimeoutHandler = new Handler(Looper.getMainLooper());
        this.mP2pOriginal = P2pOriginal.getInstance(r8);
        this.mWifiManager = (WifiManager) this.mContext.getSystemService("wifi");
        initP2pOperation();
    }

    public static /* synthetic */ int access$000(P2pController r8) {
        return r8.mConnectionCounter;
    }

    public static /* synthetic */ NetworkInfo access$1000(P2pController r8) {
        return r8.mNetworkInfo;
    }

    public static /* synthetic */ NetworkInfo access$1002(P2pController r8, NetworkInfo r10) {
        r8.mNetworkInfo = r10;
        return r10;
    }

    public static /* synthetic */ boolean access$102(P2pController r8, boolean r10) {
        r8.mConnectTimeoutTimerSet = r10;
        return r10;
    }

    public static /* synthetic */ int access$1100(P2pController r8, NetworkInfo r10) {
        return r8.getP2pStateFromNetwork(r10);
    }

    public static /* synthetic */ int access$1200(P2pController r8, WifiP2pGroup r10) {
        return r8.getP2pRoleFromGroup(r10);
    }

    public static /* synthetic */ int access$1300(P2pController r8) {
        return r8.mState;
    }

    public static /* synthetic */ int access$1400(P2pController r8) {
        return r8.mRole;
    }

    public static /* synthetic */ void access$1500(P2pController r8, int r10, int r11, int r12, int r13) {
        r8.updateStateAndRole(r10, r11, r12, r13);
    }

    public static /* synthetic */ Handler access$200(P2pController r8) {
        return r8.mHander;
    }

    public static /* synthetic */ P2pDevice access$300(P2pController r8, WifiP2pDevice r10) {
        return r8.buildP2pDevice(r10);
    }

    public static /* synthetic */ void access$400(P2pController r8) {
        r8.startConnectP2pGroup();
    }

    public static /* synthetic */ int access$500(P2pController r8) {
        return r8.mCreateGroupRetryCount;
    }

    public static /* synthetic */ int access$502(P2pController r8, int r10) {
        r8.mCreateGroupRetryCount = r10;
        return r10;
    }

    public static /* synthetic */ int access$508(P2pController r8) {
        int r10 = r8.mCreateGroupRetryCount;
        r8.mCreateGroupRetryCount = r10 + 1;
        return r10;
    }

    public static /* synthetic */ WifiCapabilities access$600(P2pController r8) {
        return r8.mPeerCapabilities;
    }

    public static /* synthetic */ WifiP2pDevice access$702(P2pController r8, WifiP2pDevice r10) {
        r8.mWifiP2pDevice = r10;
        return r10;
    }

    public static /* synthetic */ WifiP2pGroup access$800(P2pController r8) {
        return r8.mWifiP2pGroup;
    }

    public static /* synthetic */ WifiP2pGroup access$802(P2pController r8, WifiP2pGroup r10) {
        r8.mWifiP2pGroup = r10;
        return r10;
    }

    public static /* synthetic */ WifiP2pInfo access$900(P2pController r8) {
        return r8.mWifiP2pInfo;
    }

    public static /* synthetic */ WifiP2pInfo access$902(P2pController r8, WifiP2pInfo r10) {
        r8.mWifiP2pInfo = r10;
        return r10;
    }

    private WifiP2pConfig buildP2pConfig(WifiCapabilities r8, boolean r10) {
        WifiP2pConfig.Builder r11 = new WifiP2pConfig.Builder();
        r11.setNetworkName("DIRECT-" + P2pUtil.getAndroidId(this.mContext));
        r11.setPassphrase(P2pUtil.generateRandomPassword(8));
        if (Build.VERSION.SDK_INT < 33) goto L6;
        if (r10 == false) goto L6;
        r11.setGroupOperatingFrequency(P2pChannelManager.negotiateP2pFrequency(getWifiCapabilities(), r8));
    L7:
        r11.enablePersistentMode(true);
        WifiP2pConfig r12 = r11.build();
        BWDLLog.d(TAG, "build p2p config:" + r12.toString());
        return r12;
    L6:
        r11.setGroupOperatingBand(P2pChannelManager.negotiateP2pBand(getWifiCapabilities(), r8));
        goto L7
    }

    private P2pDevice buildP2pDevice(WifiP2pDevice r8) {
        P2pDevice.Builder r10 = new P2pDevice.Builder();
        int r11 = getP2pRoleFromGroup(this.mWifiP2pGroup);
        r10.setRole(r11);
        if (getP2pStateFromNetwork(this.mNetworkInfo) != 7) goto L6;
        r10.setLocalAddress(P2pUtil.getLocalP2pAddress());
    L6:
        if (r11 != 2) goto L8;
        r10.setPeerAddress(this.mWifiP2pInfo.groupOwnerAddress);
    L8:
        r10.setPeerWifiP2pDevice(r8);
        r10.setWifiP2pGroup(this.mWifiP2pGroup);
        r10.setWifiP2pConfig(this.mWifiP2pConfig);
        r10.setWifiP2pInfo(this.mWifiP2pInfo);
        return r10.build();
    }

    private void cancelConnectTimeoutTask() {
        if (this.mConnectTimeoutTimerSet == false) goto L6;
        this.mTimeoutHandler.removeCallbacks(this.mTimeoutTask);
        this.mConnectTimeoutTimerSet = false;
        BWDLLog.d(TAG, "cancel p2p connect timeout task.");
        return;
    }

    public static P2pController getInstance(Context r8, int r10) {
        if (sInstance != null) goto L13;
        monitor-enter(P2pController.class);
        sInstance = new P2pController(r8, r10);     // Catch: Throwable -> L9
        monitor-exit(P2pController.class);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L13:
        return sInstance;
    }

    private int getP2pRoleFromGroup(WifiP2pGroup r8) {
        if (r8 != null) goto L4;
        return 0;
    L4:
        if (this.mWifiP2pGroup.isGroupOwner() == false) goto L6;
        return 1;
    L6:
        return 2;
    }

    private int getP2pStateFromNetwork(NetworkInfo r8) {
        if (r8 != null) goto L4;
        return 4;
    L4:
        if (r8.getState() != NetworkInfo.State.CONNECTED) goto L8;
        return 7;
    L8:
        if (this.mNetworkInfo.getState() != NetworkInfo.State.DISCONNECTED) goto L12;
        return 6;
    L12:
        if (this.mNetworkInfo.getState() != NetworkInfo.State.CONNECTING) goto L17;
        return 5;
    L17:
        return 4;
    }

    private WifiCapabilities getWifiCapabilities() {
        WifiCapabilities.Builder r8 = new WifiCapabilities.Builder();
        int r10 = this.mP2pBand;
        boolean r11 = false;
        if (r10 != 1) goto L6;
        r8.setSupported5GHz(false);
    L29:
        r8.setWifiApEnabled(((Boolean) this.mWifiManager.getClass().getDeclaredMethod("isWifiApEnabled", new Class[0]).invoke(this.mWifiManager, new Object[0])).booleanValue());     // Catch: Throwable -> L12
    L14:
        r8.setSupportDualBand(isSupportDualBand());
        boolean r12 = this.mWifiManager.isWifiEnabled();
        r8.setEnabled(r12);
        if (r12 == false) goto L17;
        WifiInfo r13 = this.mWifiManager.getConnectionInfo();
        if (r13 != null) goto L21;
    L23:
        r8.setConnected(r11);
        if (r11 == false) goto L26;
        r8.setFrequency(r13.getFrequency());
        return r8.build();
    L26:
        return r8.build();
    L21:
        if (r13.getNetworkId() == (-1)) goto L23;
        r11 = true;
        goto L23
    L17:
        return r8.build();
    L12:
        e = move-exception;
        BWDLLog.e(TAG, "getWifiApEnabledStatus: " + e);
        goto L14
    L6:
        if (r10 != 2) goto L8;
        r8.setSupported5GHz(true);
        goto L29
    L8:
        if (r10 != 0) goto L29;
        r8.setSupported5GHz(this.mWifiManager.is5GHzBandSupported());
        goto L29
    }

    private boolean isSupportDualBand() {
        int r8 = Build.VERSION.SDK_INT;
        if (r8 < 34) goto L6;
        return this.mWifiManager.isDualBandSimultaneousSupported();
    L6:
        if (r8 < 33) goto L9;
        return this.mWifiManager.isStaConcurrencyForMultiInternetSupported();
    L9:
        if (this.mWifiManager.isMakeBeforeBreakWifiSwitchingSupported() == false) goto L11;
    L14:
        return true;
    L11:
        if (this.mWifiManager.isStaConcurrencyForLocalOnlyConnectionsSupported() == true) goto L14;
        return false;
    }

    private void notifyP2pClientsChange(List<WifiP2pDevice> r8, List<WifiP2pDevice> r10) {
        if (r10.size() <= r8.size()) goto L11;
        Iterator<WifiP2pDevice> r11 = r10.iterator();
    L6:
        if (r11.hasNext() == false) goto L27;
        WifiP2pDevice r12 = r11.next();
        if (r8.contains(r12) == true) goto L6;
        BWDLLog.d(TAG, "send MSG_WIFI_P2P_PEER_STATE_CONNECTED msg. Client:" + r12);
        Handler r13 = this.mHander;
        int r14 = 8;
    L18:
        P2pUtil.sendMessageWithParam(r13, r14, buildP2pDevice(r12));
        return;
    L27:
        return;
    L11:
        if (r10.size() >= r8.size()) goto L26;
        Iterator<WifiP2pDevice> r15 = r8.iterator();
    L14:
        if (r15.hasNext() == false) goto L28;
        r12 = r15.next();
        if (r10.contains(r12) == true) goto L14;
        BWDLLog.d(TAG, "send MSG_WIFI_P2P_PEER_STATE_DISCONNECTED msg. Client:" + r12);
        r13 = this.mHander;
        r14 = 9;
        goto L18
    L28:
        return;
    }

    private void setConnectTimeoutTask(int r8) {
        if (this.mConnectTimeoutTimerSet == false) goto L5;
        return;
    L5:
        this.mConnectTimeoutTimerSet = true;
        Runnable r10 = new AnonymousClass2(this);
        this.mTimeoutTask = r10;
        this.mTimeoutHandler.postDelayed(r10, r8);
    }

    private void startConnectP2pGroup() {
        if (this.mConnectTimeoutTimerSet == true) goto L6;
        return;
    L6:
        if (this.mWifiP2pConfig != null) goto L8;
        return;
    L8:
        if (this.mState != 7) goto L10;
        return;
    L10:
        if (this.mRole != 0) goto L15;
        this.mConnectionCounter++;
        BWDLLog.d(TAG, "start connecting p2p group. connection counter: " + this.mConnectionCounter);
        this.mP2pOriginal.connect(this.mWifiP2pConfig, this.mConnectActionListener);
        return;
    }

    private void updateStateAndRole(int r8, int r10, int r11, int r12) {
        this.mState = r10;
        this.mRole = r12;
        if (r10 == 6) goto L23;
        if (r10 == 7) goto L7;
    L33:
        this.mClients.clear();
        WifiP2pGroup r13 = this.mWifiP2pGroup;
        if (r13 == null) goto L38;
        this.mOwner = r13.getOwner();
        this.mClients.addAll(this.mWifiP2pGroup.getClientList());
        return;
    L38:
        return;
    L7:
        if (r8 != 4) goto L9;
    L14:
        if (r12 == 2) goto L16;
        if (r12 != 1) goto L33;
        BWDLLog.d(TAG, "send MSG_WIFI_P2P_GROUP_CREATE_SUCCESS msg.");
        P2pUtil.sendMessageWithParam(this.mHander, 2);
        goto L33
    L16:
        if (this.mWifiP2pGroup != null) goto L18;
    L20:
        cancelConnectTimeoutTask();
        goto L33
    L18:
        if (this.mWifiP2pInfo == null) goto L20;
        BWDLLog.d(TAG, "send MSG_WIFI_P2P_PEER_STATE_CONNECTED and MSG_WIFI_P2P_GROUP_IP_AVAILABLE msg.");
        P2pUtil.sendMessageWithParam(this.mHander, 8, buildP2pDevice(this.mWifiP2pGroup.getOwner()));
        P2pUtil.sendMessageWithParam(this.mHander, 11, this.mWifiP2pInfo.groupOwnerAddress);
        goto L20
    L9:
        if (r8 == 5) goto L14;
        if (r8 == 6) goto L14;
        if (r8 != 7) goto L33;
        notifyP2pClientsChange(this.mClients, new ArrayList(this.mWifiP2pGroup.getClientList()));
        goto L33
    L23:
        if (r8 != 7) goto L33;
        if (r11 == 1) goto L29;
        if (r11 != 2) goto L33;
        BWDLLog.d(TAG, "send MSG_WIFI_P2P_PEER_STATE_DISCONNECTED msg. Owner:" + this.mOwner);
        P2pUtil.sendMessageWithParam(this.mHander, 9, buildP2pDevice(this.mOwner));
        goto L33
    L29:
        Iterator<WifiP2pDevice> r14 = this.mClients.iterator();
    L31:
        if (r14.hasNext() == false) goto L33;
        WifiP2pDevice r15 = r14.next();
        BWDLLog.d(TAG, "send MSG_WIFI_P2P_PEER_STATE_DISCONNECTED msg. Client:" + r15);
        P2pUtil.sendMessageWithParam(this.mHander, 9, buildP2pDevice(r15));
        goto L31
    }

    public void cleanup() {
        this.mContext.unregisterReceiver(this.mReceiver);
    }

    public void connectP2pGroup(WifiP2pConfig r8) {
        if (r8 != null) goto L5;
        BWDLLog.d(TAG, "WifiP2pConfig is null, return.");
    L5:
        this.mConnectionCounter = 0;
        this.mWifiP2pConfig = r8;
        cancelConnectTimeoutTask();
        setConnectTimeoutTask(10000);
        if (this.mWifiP2pGroup == null) goto L8;
        BWDLLog.d(TAG, "remove current group, after trying connect new group.");
        this.mP2pOriginal.removeGroup(this.mRemoveGroupListener);
        return;
    L8:
        startConnectP2pGroup();
    }

    public void createGroup(WifiCapabilities r8) {
        this.mCreateGroupRetryCount = 0;
        this.mPeerCapabilities = r8;
        startCreateGroup(r8, true);
    }

    public WifiCapabilities getCapabilities() {
        return getWifiCapabilities();
    }

    public int getP2pReadyState() {
        boolean r8 = ((Boolean) this.mWifiManager.getClass().getDeclaredMethod("isWifiApEnabled", new Class[0]).invoke(this.mWifiManager, new Object[0])).booleanValue();     // Catch: Throwable -> L5
    L7:
        if (r8 == false) goto L10;
        return 11;
    L10:
        return 0;
    L5:
        e = move-exception;
        BWDLLog.e(TAG, "getWifiApEnabledStatus: " + e);
        r8 = false;
        goto L7
    }

    public int getP2pRole() {
        return this.mRole;
    }

    public int getP2pState() {
        return this.mState;
    }

    public WifiP2pConfig getWifiP2pConfig() {
        return this.mWifiP2pConfig;
    }

    public WifiP2pInfo getWifiP2pInfo() {
        return this.mWifiP2pInfo;
    }

    public WifiP2pGroup getWifiP2pgroup() {
        return this.mWifiP2pGroup;
    }

    public void initP2pOperation() {
        IntentFilter r8 = new IntentFilter();
        r8.addAction("android.net.wifi.p2p.CONNECTION_STATE_CHANGE");
        this.mContext.registerReceiver(this.mReceiver, r8);
        this.mRole = 0;
        this.mState = 6;
        BWDLLog.d(TAG, "init p2p, first remove current group.");
        removeGroup();
    }

    public void registerMsgHander(Handler r8) {
        this.mHander = r8;
    }

    public void removeGroup() {
        if (this.mP2pOriginal == null) goto L6;
        BWDLLog.d(TAG, "remove current group.");
        this.mP2pOriginal.removeGroup(this.mRemoveGroupListener);
        return;
    }

    public void requestDeviceInfo() {
        P2pOriginal r8 = this.mP2pOriginal;
        if (r8 == null) goto L6;
        r8.requestDeviceInfo(this.mDeviceInfoListener);
        return;
    }

    public void requestGroupInfo() {
        P2pOriginal r8 = this.mP2pOriginal;
        if (r8 == null) goto L6;
        r8.requestGroupInfo(this.mGroupInfoListener);
        return;
    }

    public void requestP2pState() {
        P2pOriginal r8 = this.mP2pOriginal;
        if (r8 == null) goto L6;
        r8.requestP2pState(this.mP2pStateListener);
        return;
    }

    public void startCreateGroup(WifiCapabilities r8, boolean r10) {
        if (this.mP2pOriginal == null) goto L6;
        BWDLLog.d(TAG, "start create group. force negotiate freq:" + r10);
        this.mP2pOriginal.createGroup(buildP2pConfig(r8, r10), this.mCreateGroupListener);
        return;
    }
}
