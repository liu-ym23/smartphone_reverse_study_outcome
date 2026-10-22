package com.sdk.bwdl.AdapterLayer.Wifi.P2p;

import android.content.Context;
import android.net.wifi.p2p.WifiP2pConfig;
import android.net.wifi.p2p.WifiP2pGroup;
import android.net.wifi.p2p.WifiP2pInfo;
import com.sdk.bwdl.AdapterLayer.IBWDLAdapter;
import com.sdk.bwdl.AdapterLayer.IBWDLAdapterEventListener;
import com.sdk.bwdl.BWDLDevice;
import com.sdk.bwdl.Utils.BWDLInnerConstant;
import com.sdk.bwdl.Utils.BWDLLog;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes2.dex */
public class P2pAdapter implements IBWDLAdapter {
    private static final String TAG = "P2pAdapter";
    private static volatile P2pAdapter sInstance;
    private ArrayList<IBWDLAdapterEventListener> mAdapterEventListenerList;
    private final ConcurrentMap<P2pDevice, IBWDLAdapterEventListener> mAdapterEventListenerMap;
    private Context mContext;
    private ArrayList<P2pCallback> mP2PCallbackList;
    private P2pController mP2PController;
    private P2pEventHander mP2PEventHander;
    private int mP2pBand;

    public P2pAdapter(Context r8, int r10) {
        this.mAdapterEventListenerMap = new ConcurrentHashMap();
        this.mAdapterEventListenerList = new ArrayList();
        this.mP2PCallbackList = new ArrayList();
        this.mContext = r8;
        this.mP2pBand = r10;
        initP2p(r8);
    }

    public static P2pAdapter getInstance(Context r8, int r10) {
        if (sInstance != null) goto L13;
        monitor-enter(P2pAdapter.class);
        sInstance = new P2pAdapter(r8, r10);     // Catch: Throwable -> L9
        monitor-exit(P2pAdapter.class);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L13:
        return sInstance;
    }

    private void initP2p(Context r8) {
        this.mP2PController = P2pController.getInstance(r8, this.mP2pBand);
        if (this.mP2PEventHander != null) goto L6;
        this.mP2PEventHander = new P2pEventHander(r8, this, this.mP2pBand);
        return;
    }

    @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapter
    public void accept() {
    }

    public void cleanup() {
        this.mP2PController.cleanup();
        this.mAdapterEventListenerMap.clear();
        this.mAdapterEventListenerList.clear();
        this.mP2PCallbackList.clear();
    }

    @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapter
    public void close() {
    }

    @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapter
    public boolean connect(BWDLDevice r8) {
        if (r8 != null) goto L4;
        return false;
    L4:
        if ((r8.getDeviceInfo() instanceof WifiP2pConfig) == false) goto L9;
        BWDLLog.d(TAG, "connect p2p device:" + ((WifiP2pConfig) r8.getDeviceInfo()));
        this.mP2PController.connectP2pGroup((WifiP2pConfig) r8.getDeviceInfo());
        return true;
    L9:
        return false;
    }

    @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapter
    public boolean disconnect(BWDLDevice r8) {
        P2pController r10 = this.mP2PController;
        if (r10 == null) goto L7;
        r10.removeGroup();
        return true;
    L7:
        return true;
    }

    @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapter
    public void encrypt(BWDLDevice r8) {
    }

    @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapter
    public Object getCapabilities() {
        return this.mP2PController.getCapabilities();
    }

    public InetAddress getGroupOwnerIp() {
        WifiP2pInfo r8 = this.mP2PController.getWifiP2pInfo();
        if (r8 != null) goto L7;
        return null;
    L7:
        return r8.groupOwnerAddress;
    }

    public WifiP2pConfig getP2pConfig() {
        return this.mP2PController.getWifiP2pConfig();
    }

    public P2pEventHander getP2pEventHander() {
        return this.mP2PEventHander;
    }

    public WifiP2pGroup getP2pGroup() {
        return this.mP2PController.getWifiP2pgroup();
    }

    public int getP2pRole() {
        return this.mP2PController.getP2pRole();
    }

    public int getP2pState() {
        return this.mP2PController.getP2pState();
    }

    @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapter
    public boolean init() {
        return true;
    }

    @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapter
    public int isAdapterReady() {
        return this.mP2PController.getP2pReadyState();
    }

    @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapter
    public void listen() {
    }

    @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapter
    public int recv(byte[] r8) {
        return 0;
    }

    public void registerP2pCallback(P2pCallback r8) {
        if (this.mP2PCallbackList.contains(r8) == true) goto L6;
        BWDLLog.d(TAG, "registerP2pCallback:" + r8);
        this.mP2PCallbackList.add(r8);
        return;
    }

    @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapter
    public void removeBWDLAdapterEventListener(IBWDLAdapterEventListener r8) {
        ArrayList<IBWDLAdapterEventListener> r10 = this.mAdapterEventListenerList;
        monitor-enter(r10);
        BWDLLog.d(TAG, "removeBWDLAdapterEventListener:" + r8);     // Catch: Throwable -> L19
        this.mAdapterEventListenerList.remove(r8);     // Catch: Throwable -> L19
        monitor-exit(r10);     // Catch: Throwable -> L19
        ConcurrentMap<P2pDevice, IBWDLAdapterEventListener> r11 = this.mAdapterEventListenerMap;
        monitor-enter(r11);
        Iterator<P2pDevice> r12 = this.mAdapterEventListenerMap.keySet().iterator();     // Catch: Throwable -> L16
    L10:
        if (r12.hasNext() == false) goto L14;
        P2pDevice r13 = r12.next();     // Catch: Throwable -> L16
        if (this.mAdapterEventListenerMap.get(r13) != r8) goto L10;
        BWDLLog.d(TAG, "removeBWDLAdapterEventListener device:" + r13 + " listener:" + r8);     // Catch: Throwable -> L16
        this.mAdapterEventListenerMap.remove(r13);     // Catch: Throwable -> L16
        goto L10
    L14:
        monitor-exit(r11);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    L19:
        th = move-exception;
        throw th;
    }

    @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapter
    public void send(BWDLDevice r8, byte[] r10) {
    }

    public void sendConnectionStateToUpper(BWDLDevice r8, int r10) {
        if (r8 != null) goto L5;
        return;
    L5:
        if (r8.getConnectivityType() != BWDLInnerConstant.ConnectivityType.P2P) goto L32;
        ConcurrentMap<P2pDevice, IBWDLAdapterEventListener> r11 = this.mAdapterEventListenerMap;
        monitor-enter(r11);
        BWDLLog.d(TAG, "sendConnectionStateToUpper device:" + r8 + " state:" + r10);     // Catch: Throwable -> L23
        if (this.mAdapterEventListenerMap.containsKey(r8.getDeviceInfo()) == false) goto L11;
        this.mAdapterEventListenerMap.get((P2pDevice) r8.getDeviceInfo()).onConnectionStateChanged(r8, r10);     // Catch: Throwable -> L23
    L11:
        monitor-exit(r11);     // Catch: Throwable -> L23
        ArrayList<IBWDLAdapterEventListener> r12 = this.mAdapterEventListenerList;
        monitor-enter(r12);
        Iterator<IBWDLAdapterEventListener> r13 = this.mAdapterEventListenerList.iterator();     // Catch: Throwable -> L20
    L16:
        if (r13.hasNext() == false) goto L18;
        IBWDLAdapterEventListener r14 = r13.next();     // Catch: Throwable -> L20
        BWDLLog.d(TAG, "sendConnectionStateToUpper:" + r10);     // Catch: Throwable -> L20
        r14.onConnectionStateChanged(r8, r10);     // Catch: Throwable -> L20
        goto L16
    L18:
        monitor-exit(r12);     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        throw th;
    L23:
        th = move-exception;
        throw th;
    }

    public void sendP2pGroupAvailableToUpper(WifiP2pGroup r8) {
        if (r8 == null) goto L7;
        Iterator<P2pCallback> r10 = this.mP2PCallbackList.iterator();
    L5:
        if (r10.hasNext() == false) goto L9;
        P2pCallback r11 = r10.next();
        BWDLLog.d(TAG, "sendP2pGroupAvailableToUpper:" + r8);
        r11.onP2pGroupAvailable(r8);
        goto L5
    L9:
        return;
    }

    public void sendP2pGroupIpAvailableToUpper(InetAddress r8) {
        if (r8 == null) goto L7;
        Iterator<P2pCallback> r10 = this.mP2PCallbackList.iterator();
    L5:
        if (r10.hasNext() == false) goto L9;
        P2pCallback r11 = r10.next();
        BWDLLog.d(TAG, "sendP2pGroupIpAvailableToUpper:" + r8);
        r11.onP2pGroupIpAvailable(r8);
        goto L5
    L9:
        return;
    }

    @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapter
    public void setBWDLAdapterEventListener(IBWDLAdapterEventListener r8) {
        ArrayList<IBWDLAdapterEventListener> r10 = this.mAdapterEventListenerList;
        monitor-enter(r10);
        if (r8 != null) goto L11;
    L6:
        monitor-exit(r10);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    L11:
        BWDLLog.d(TAG, "setBWDLAdapterEventListener:" + r8);     // Catch: Throwable -> L8
        this.mAdapterEventListenerList.add(r8);     // Catch: Throwable -> L8
        goto L6
    }

    public void startP2pGroup(WifiCapabilities r8) {
        this.mP2PController.createGroup(r8);
    }

    public void unRegisterP2pCallback(P2pCallback r8) {
        if (this.mP2PCallbackList.contains(r8) == false) goto L5;
        BWDLLog.d(TAG, "unRegisterP2pCallback:" + r8);
        this.mP2PCallbackList.remove(r8);
        boolean r10 = true;
    L6:
        if (r10 == true) goto L9;
        BWDLLog.d(TAG, "unregister callback is not found.");
        return;
    L9:
        return;
    L5:
        r10 = false;
        goto L6
    }

    @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapter
    public void setBWDLAdapterEventListener(BWDLDevice r8, IBWDLAdapterEventListener r10) {
        ConcurrentMap<P2pDevice, IBWDLAdapterEventListener> r11 = this.mAdapterEventListenerMap;
        monitor-enter(r11);
        if (r8 == null) goto L7;
        if (r10 == null) goto L7;
        BWDLLog.d(TAG, "setBWDLAdapterEventListener:" + r10);     // Catch: Throwable -> L9
        this.mAdapterEventListenerMap.put((P2pDevice) r8.getDeviceInfo(), r10);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L7:
        monitor-exit(r11);     // Catch: Throwable -> L9
    }
}
