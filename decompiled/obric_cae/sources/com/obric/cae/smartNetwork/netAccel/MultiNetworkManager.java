package com.obric.cae.smartNetwork.netAccel;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.net.TransportInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Pair;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartNetwork.netAccel.cellularAccel.CellularConnector;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class MultiNetworkManager {
    private static final String TAG = "MultiNetworkManager";
    private final boolean DEBUG;
    private AccelConfigManager mAccelConfigManager;
    private AccelControl mAccelControl;
    private AccelMetric mAccelMetric;
    private final AvailableNetwork mAvailableNetwork;
    private CellularConnector mCellularConnector;
    private final ConnectivityManager mConnectivityManager;
    private Context mContext;
    private Network mDefaultNetwork;
    private final Handler mHandler;
    private final MultiNetInfo mMultiNetInfo;
    private final ConnectivityManager.NetworkCallback mNetworkCallback;

    public static class AvailableNetwork {
        private static final int DISABLE = 2;
        private static final int ENABLE = 0;
        private static final int REENABLE = 1;
        private final List<Pair<Integer, NetworkCapabilities>> cellular;
        private final Map<Integer, LinkProperties> linkPropertiesMap;
        private final List<Pair<Integer, WifiInfo>> wifi;
        private final Map<Integer, NetworkCapabilities> wifiCapabilitiesMap;

        private AvailableNetwork() {
            this.wifi = Collections.synchronizedList(new ArrayList());
            this.wifiCapabilitiesMap = Collections.synchronizedMap(new HashMap());
            this.cellular = Collections.synchronizedList(new ArrayList());
            this.linkPropertiesMap = Collections.synchronizedMap(new HashMap());
        }

        public static /* synthetic */ List access$500(AvailableNetwork r8) {
            return r8.cellular;
        }

        public static /* synthetic */ List access$600(AvailableNetwork r8) {
            return r8.wifi;
        }

        public void addCellular(int r8, NetworkCapabilities r10) {
            this.cellular.add(new Pair(Integer.valueOf(r8), r10));
        }

        public void addWifi(int r8, WifiInfo r10, NetworkCapabilities r11) {
            this.wifi.add(new Pair(Integer.valueOf(r8), r10));
            this.wifiCapabilitiesMap.put(Integer.valueOf(r8), r11);
        }

        public void copyFrom(AvailableNetwork r8) {
            this.wifi.clear();
            this.wifi.addAll(r8.wifi);
            this.cellular.clear();
            this.cellular.addAll(r8.cellular);
        }

        public Map<Integer, LinkProperties> getLinkPropertiesMap() {
            return new HashMap(this.linkPropertiesMap);
        }

        public int getNextAction(AvailableNetwork r8) {
            if (r8.getTotalSize() >= 2) goto L9;
            if (getTotalSize() < 2) goto L9;
            return 0;
        L9:
            if (r8.getTotalSize() < 2) goto L15;
            if (getTotalSize() < 2) goto L15;
            return 1;
        L15:
            if (r8.getTotalSize() < 2) goto L17;
            getTotalSize();
        L17:
            return 2;
        }

        public int getTotalSize() {
            int r8 = this.wifi.size();
            return this.cellular.size() + r8;
        }

        public NetworkCapabilities getWifiCapabilities(int r8) {
            return this.wifiCapabilitiesMap.get(Integer.valueOf(r8));
        }

        public ArrayList<Pair<Integer, WifiInfo>> getWifiList() {
            return new ArrayList(this.wifi);
        }

        public boolean isChanged(AvailableNetwork r8) {
            if (this.wifi.size() == r8.wifi.size()) goto L6;
            return true;
        L6:
            if (this.cellular.size() == r8.cellular.size()) goto L8;
            return true;
        L8:
            return false;
        }

        public boolean isNeedCalcWifiQuota() {
            if (this.wifi.size() < 2) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean isNeedDisableAccel() {
            if (getTotalSize() < 2) goto L5;
            return true;
        L5:
            return false;
        }

        public void setLinkProperties(int r8, LinkProperties r10) {
            this.linkPropertiesMap.put(Integer.valueOf(r8), r10);
        }

        public /* synthetic */ AvailableNetwork(AnonymousClass1 r8) {
            this();
        }
    }

    public MultiNetworkManager(Context r8, AccelControl r10, CellularConnector r11) {
        this.DEBUG = false;
        this.mContext = r8;
        this.mConnectivityManager = (ConnectivityManager) r8.getSystemService("connectivity");
        this.mNetworkCallback = createNetworkCallback();
        HandlerThread r12 = new HandlerThread("MultiNetworkManager");
        r12.start();
        this.mHandler = new Handler(r12.getLooper());
        this.mAccelControl = r10;
        this.mDefaultNetwork = null;
        MultiNetInfo r13 = new MultiNetInfo();
        this.mMultiNetInfo = r13;
        r13.putNetType(2, "wlan0");
        r13.putNetType(3, "wlan1");
        r13.putNetType(0, "rmnet_data0");
        this.mAvailableNetwork = new AvailableNetwork(null);
        this.mAccelConfigManager = AccelConfigManager.getInstance(r8);
        this.mAccelMetric = AccelMetric.getInstance(r8);
        this.mCellularConnector = r11;
    }

    public static /* synthetic */ String access$100() {
        return TAG;
    }

    public static /* synthetic */ void access$200(MultiNetworkManager r8) {
        r8.processDefaultNetworkChange();
    }

    public static /* synthetic */ void access$300(MultiNetworkManager r8) {
        r8.processMultiNetwork();
    }

    public static /* synthetic */ ConnectivityManager access$400(MultiNetworkManager r8) {
        return r8.mConnectivityManager;
    }

    private HashMap<Integer, Integer> calcQuota(AvailableNetwork r8) {
        AccelConfigManager.QuotaCfg r10 = this.mAccelConfigManager.getQuotaConfig();
        CaeLog.i(TAG, "quotaCfg: " + r10.toString());
        if (r10.mode.equals(AccelConfigManager.QuotaCfg.SPEED_BASED) == true) goto L5;
        HashMap<Integer, Integer> r11 = new HashMap();
        Iterator r12 = AvailableNetwork.access$600(r8).iterator();
    L20:
        if (r12.hasNext() == false) goto L28;
        Pair r13 = (Pair) r12.next();
        int r14 = ((WifiInfo) r13.second).getFrequency();
        if (r14 >= 4900) goto L24;
    L26:
        r11.put((Integer) r13.first, Integer.valueOf(r10.wifi24));
        String r15 = TAG;
        StringBuilder r16 = new StringBuilder("netType ");
        r16.append(r13.first);
        r16.append(" | quota: ");
        int r17 = r10.wifi24;
    L27:
        defpackage.b.p(r16, r17, r15);
        goto L20
    L24:
        if (r14 > 5900) goto L26;
        r11.put((Integer) r13.first, Integer.valueOf(r10.wifi5));
        r15 = TAG;
        r16 = new StringBuilder("netType ");
        r16.append(r13.first);
        r16.append(" | quota: ");
        r17 = r10.wifi5;
        goto L27
    L28:
        Iterator r18 = AvailableNetwork.access$500(r8).iterator();
    L30:
        if (r18.hasNext() == false) goto L33;
        Pair r19 = (Pair) r18.next();
        r11.put((Integer) r19.first, Integer.valueOf(r10.cellular));
        String r20 = TAG;
        StringBuilder r21 = new StringBuilder("netType ");
        r21.append(r19.first);
        r21.append(" | quota: ");
        defpackage.b.p(r21, r10.cellular, r20);
        goto L30
    L33:
        return r11;
    L5:
        if (r8.isNeedCalcWifiQuota() == false) goto L10;
        HashMap<Integer, Integer> r22 = new HashMap(calcWifiQuota(r8.getWifiList(), 0.5f));
        Iterator r23 = AvailableNetwork.access$500(r8).iterator();
    L8:
        if (r23.hasNext() == false) goto L41;
        Pair r24 = (Pair) r23.next();
        r22.put((Integer) r24.first, 1);
        CaeLog.i(TAG, "netType " + r24.first + " | quota: 1");
        goto L8
    L41:
        return r22;
    L10:
        HashMap<Integer, Integer> r25 = new HashMap();
        Iterator r26 = AvailableNetwork.access$600(r8).iterator();
    L12:
        if (r26.hasNext() == false) goto L14;
        Pair r27 = (Pair) r26.next();
        r25.put((Integer) r27.first, 1);
        CaeLog.i(TAG, "netType " + r27.first + " | quota: 1");
        goto L12
    L14:
        Iterator r28 = AvailableNetwork.access$500(r8).iterator();
    L16:
        if (r28.hasNext() == false) goto L42;
        Pair r29 = (Pair) r28.next();
        r25.put((Integer) r29.first, 1);
        CaeLog.i(TAG, "netType " + r29.first + " | quota: 1");
        goto L16
    L42:
        return r25;
    }

    private HashMap<Integer, Integer> calcWifiQuota(ArrayList<Pair<Integer, WifiInfo>> r10, float r11) {
        HashMap r8 = new HashMap();
        Iterator<Pair<Integer, WifiInfo>> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L10;
        Pair<Integer, WifiInfo> r13 = r12.next();
        Integer r14 = (Integer) r13.first;
        float r15 = ((WifiInfo) r13.second).getRxLinkSpeedMbps();
        if (r15 > 0.0f) goto L8;
        String r16 = TAG;
        StringBuilder r17 = new StringBuilder("netType ");
        r17.append(r14);
        String r18 = " rxLinkSpeed is invalid: ";
    L9:
        r17.append(r18);
        r17.append(r15);
        CaeLog.i(r16, r17.toString());
        goto L4
    L8:
        r8.put(r14, Float.valueOf(r15));
        r16 = TAG;
        r17 = new StringBuilder("netType ");
        r17.append(r14);
        r18 = " rxLinkSpeedMbps: ";
        goto L9
    L10:
        ArrayList r19 = new ArrayList(r8.entrySet());
        Collections.sort(r19, new AnonymousClass2(this));
        float r20 = ((Float) ((Map.Entry) r19.get(0)).getValue()).floatValue();
        CaeLog.i(TAG, "min rxLinkSpeedMbps: " + r20);
        HashMap<Integer, Integer> r21 = new HashMap();
        Iterator r22 = r19.iterator();
    L12:
        if (r22.hasNext() == false) goto L22;
        Map.Entry r23 = (Map.Entry) r22.next();
        Integer r24 = (Integer) r23.getKey();
        float r25 = ((Float) r23.getValue()).floatValue();
        float r26 = Math.round((r25 / r20) * 100.0f) / 100.0f;
        int r27 = 1;
        if (r25 == r20) goto L21;
        int r28 = (int) Math.floor(r26);
        if ((r26 - r28) < r11) goto L20;
        r28 = r28 + 1;
    L20:
        r27 = Math.max(r28, 1);
    L21:
        r21.put(r24, Integer.valueOf(r27));
        String r29 = TAG;
        StringBuilder r30 = new StringBuilder("netType ");
        r30.append(r24);
        r30.append(" | ratio: ");
        r30.append(r26);
        r30.append(" | quota: ");
        defpackage.b.p(r30, r27, r29);
        goto L12
    L22:
        return r21;
    }

    private ConnectivityManager.NetworkCallback createNetworkCallback() {
        return new AnonymousClass1(this);
    }

    private void disableAccel() {
        this.mAccelControl.disableAccel();
    }

    private void enableAccel(AvailableNetwork r8) {
        this.mMultiNetInfo.clearAvailableNet();
        this.mMultiNetInfo.clearEnabledUidMap();
        Iterator<Map.Entry<Integer, Integer>> r10 = calcQuota(r8).entrySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        Map.Entry<Integer, Integer> r11 = r10.next();
        Integer r12 = r11.getKey();
        Integer r13 = r11.getValue();
        this.mMultiNetInfo.setAvailableNetQuota(r12.byteValue(), r13.intValue());
        goto L4
    L6:
        updateAccelNetLinkpreperties(r8);
        updateAccelUidEnable();
        this.mAccelControl.enableAccel(this.mMultiNetInfo);
    }

    private AvailableNetwork getAvaliableNetwork() {
        AvailableNetwork r8 = new AvailableNetwork(null);
        Network[] r10 = this.mConnectivityManager.getAllNetworks();
        if (r10 == null) goto L37;
        int r11 = r10.length;
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L37;
        Network r13 = r10[r12];
        NetworkCapabilities r14 = this.mConnectivityManager.getNetworkCapabilities(r13);
        if (r14 == null) goto L36;
        LinkProperties r15 = this.mConnectivityManager.getLinkProperties(r13);
        if (r15 == null) goto L36;
        String r16 = r15.getInterfaceName();
        if (r16 == null) goto L36;
        if (r14.hasTransport(1) == false) goto L29;
        if (r14.hasCapability(16) == true) goto L20;
        CaeLog.e(TAG, "wifi not validated");
        goto L36
    L20:
        int r17 = this.mMultiNetInfo.getNetType(r16);
        if (r17 == (-1)) goto L36;
        TransportInfo r18 = r14.getTransportInfo();
        if ((r18 instanceof WifiInfo) == false) goto L36;
        WifiInfo r19 = (WifiInfo) r18;
        if (r19.getRxLinkSpeedMbps() > this.mAccelConfigManager.getValidWifiRxLinkSpeed()) goto L27;
        CaeLog.d(TAG, "wifi rxLinkSpeed is invalid: " + r19.getRxLinkSpeedMbps());
        goto L36
    L27:
        r8.addWifi(r17, r19, r14);
        r8.setLinkProperties(r17, r15);
        goto L36
    L29:
        if (this.mCellularConnector.isAccelerating() == false) goto L36;
        if (r14.hasCapability(1) == false) goto L36;
        if (r14.hasCapability(16) == false) goto L36;
        this.mMultiNetInfo.putNetType(0, r16);
        r8.addCellular(0, r14);
        r8.setLinkProperties(0, r15);
    L36:
        r12 = r12 + 1;
    L37:
        return r8;
    }

    private int getNetType(Network r8) {
        NetworkCapabilities r10 = this.mConnectivityManager.getNetworkCapabilities(r8);
        LinkProperties r11 = this.mConnectivityManager.getLinkProperties(r8);
        if (r10 == null) goto L16;
        if (r11 == null) goto L16;
        if (r10.hasTransport(0) == false) goto L10;
        return 0;
    L10:
        if (r10.hasTransport(1) == false) goto L18;
        String r12 = r11.getInterfaceName();
        if (r12 != null) goto L14;
        return -1;
    L14:
        return this.mMultiNetInfo.getNetType(r12);
    L18:
        return -1;
    L16:
        CaeLog.e(TAG, "getNetworkCapabilities or getLinkProperties failed");
        return -1;
    }

    private Pair<String, String> getSsidFromNetworkCapabilities(NetworkCapabilities r8) {
        String r10 = "";
        Method r11 = NetworkCapabilities.class.getDeclaredMethod("getSsid", new Class[0]);     // Catch: Exception -> L7 NoSuchMethodException -> L9
        r11.setAccessible(true);     // Catch: Exception -> L7 NoSuchMethodException -> L9
        Object r12 = r11.invoke(r8, new Object[0]);     // Catch: Exception -> L7 NoSuchMethodException -> L9
        if (r12 == null) goto L12;
        String r13 = r12.toString();     // Catch: Exception -> L7 NoSuchMethodException -> L9
    L13:
        WifiManager r14 = (WifiManager) this.mContext.getSystemService("wifi");
        String r15 = r14.getConnectionInfo().getSSID();
        String r16 = r14.getConnectionInfo().getBSSID();
        if (r15 == null) goto L19;
        if (r15.equals(r13) == false) goto L19;
        r10 = r16;
    L19:
        return new Pair(r13, r10);
    L12:
        r13 = "";
    L9:
        e = move-exception;
        String r17 = TAG;
        StringBuilder r18 = new StringBuilder("getSsidMethod not found: ");
        String r19 = e.getMessage();
    L11:
        r18.append(r19);
        CaeLog.e(r17, r18.toString());
    L7:
        e = move-exception;
        r17 = TAG;
        r18 = new StringBuilder("getSsidMethod failed: ");
        r19 = e.getMessage();
        goto L11
    }

    private int getUidByPackageName(String r8) {
        return this.mContext.getPackageManager().getApplicationInfo(r8, 0).uid;
    L4:
        return -1;
    }

    private void processDefaultNetworkChange() {
        Network r8 = this.mConnectivityManager.getActiveNetwork();
        Network r10 = this.mDefaultNetwork;
        if (r10 != null) goto L5;
        if (r8 == null) goto L5;
    L9:
        int r11 = getNetType(r8);
        if (r11 == (-1)) goto L16;
        this.mAccelControl.setDefaultNetType(r11);
        this.mDefaultNetwork = r8;
        defpackage.b.m("Default network changed to ", r11, TAG);
        return;
    L16:
        return;
    L5:
        if (r10 == null) goto L13;
        if (r8 != null) goto L8;
        return;
    L8:
        if (r10.equals(r8) == false) goto L9;
        return;
    }

    private void processMultiNetwork() {
        AvailableNetwork r8 = getAvaliableNetwork();
        if (r8.isChanged(this.mAvailableNetwork) == false) goto L15;
        String r10 = TAG;
        CaeLog.i(r10, "AvaliableNetwork [cellular.size: " + AvailableNetwork.access$500(r8).size() + ", wifi.size: " + AvailableNetwork.access$600(r8).size() + "]");
        int r11 = r8.getNextAction(this.mAvailableNetwork);
        if (r11 == 0) goto L14;
        int r12 = 1;
        if (r11 == 1) goto L12;
        r12 = 2;
        if (r11 != 2) goto L15;
        disableAccel();
        String r13 = "less AvaliableNetwork, disable accel";
    L13:
        CaeLog.i(r10, r13);
        reportAccelCapability(r12, r8);
        goto L15
    L12:
        disableAccel();
        enableAccel(r8);
        r13 = "more AvaliableNetwork, reenable accel";
        goto L13
    L14:
        enableAccel(r8);
        CaeLog.i(r10, "more AvaliableNetwork, enable accel");
        reportAccelCapability(0, r8);
    L15:
        updateAccelNetLinkpreperties(r8);
        this.mAvailableNetwork.copyFrom(r8);
    }

    private void reportAccelCapability(int r8, AvailableNetwork r10) {
        ArrayList r11 = new ArrayList();     // Catch: Exception -> L14
        Iterator r12 = AvailableNetwork.access$600(r10).iterator();     // Catch: Exception -> L14
    L4:
        if (r12.hasNext() == false) goto L8;
        Pair r13 = (Pair) r12.next();     // Catch: Exception -> L14
        Pair<String, String> r14 = getSsidFromNetworkCapabilities(r10.getWifiCapabilities(((Integer) r13.first).intValue()));     // Catch: Exception -> L14
        WifiInfo r15 = (WifiInfo) r13.second;     // Catch: Exception -> L14
        if (r15 == null) goto L4;
        r11.add(AccelCapability.WifiInfo.newBuilder().setSsid((String) r14.first).setBssid((String) r14.second).setStandard(r15.getWifiStandard()).setFreq(r15.getFrequency()).setRssi(r15.getRssi()).setLinkspeed(r15.getLinkSpeed()).setRxLinkspeed(r15.getRxLinkSpeedMbps()).setInteface(this.mMultiNetInfo.getIfaceName(((Integer) r13.first).intValue())).build());     // Catch: Exception -> L14
        goto L4
    L8:
        AccelMetric r16 = this.mAccelMetric;     // Catch: Exception -> L14
        if (AvailableNetwork.access$500(r10).isEmpty() == false) goto L11;
        List<AccelCapability.CellularInfo> r17 = null;
    L12:
        r16.reportAccelCapability(r8, r11, r17);     // Catch: Exception -> L14
        return;
    L11:
        r17 = this.mAccelMetric.getCellularInfoList();     // Catch: Exception -> L14
    L14:
        e = move-exception;
        CaeLog.e(TAG, "reportAccelCapability failed", e);
    }

    private void updateAccelNetLinkpreperties(AvailableNetwork r8) {
        Iterator<Map.Entry<Integer, LinkProperties>> r10 = r8.getLinkPropertiesMap().entrySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        Map.Entry<Integer, LinkProperties> r11 = r10.next();
        this.mMultiNetInfo.setAvailableNetLinkproperties(r11.getKey().byteValue(), r11.getValue());
        goto L4
    }

    private void updateAccelUidEnable() {
        Iterator<Map.Entry<String, AccelConfigManager.PackageRule>> r8 = this.mAccelConfigManager.getAllPackageRules().entrySet().iterator();
    L4:
        if (r8.hasNext() == false) goto L9;
        Map.Entry<String, AccelConfigManager.PackageRule> r10 = r8.next();
        int r11 = getUidByPackageName(r10.getKey());
        if (r11 < 0) goto L4;
        this.mMultiNetInfo.setUidEnabled(r11, Boolean.valueOf(r10.getValue().isEnable()));
        this.mMultiNetInfo.setUidFlowSchedEnable(r11, r10.getValue().getFlowSchedEnable());
        goto L4
    }

    public void setPackageEnable(String r8, boolean r10) {
        this.mAccelConfigManager.setPackageAccelEnable(r8, r10);
        int r11 = getUidByPackageName(r8);
        if (r11 >= 0) goto L5;
        return;
    L5:
        this.mMultiNetInfo.setUidEnabled(r11, Boolean.valueOf(r10));
        this.mAccelControl.setUidEnabled(r11);
    }

    public void setPackageFlowSched(String r8, boolean r10) {
        this.mAccelConfigManager.setPackageFlowSched(r8, r10);
        int r11 = getUidByPackageName(r8);
        if (r11 >= 0) goto L5;
        return;
    L5:
        this.mMultiNetInfo.setUidFlowSchedEnable(r11, r10);
    }

    public void start() {
        NetworkRequest r8 = new NetworkRequest.Builder().addCapability(12).addTransportType(0).addTransportType(1).build();
        ConnectivityManager r10 = this.mConnectivityManager;
        if (r10 == null) goto L6;
        r10.registerNetworkCallback(r8, this.mNetworkCallback, this.mHandler);
        return;
    }

    public void stop() {
        ConnectivityManager r8 = this.mConnectivityManager;
        if (r8 == null) goto L6;
        r8.unregisterNetworkCallback(this.mNetworkCallback);
    L6:
        if (this.mAvailableNetwork.isNeedDisableAccel() == false) goto L9;
        disableAccel();
        return;
    }

    public void updateAllPackageEnable() {
        updateAccelUidEnable();
        this.mAccelControl.updateAllAccelUidEnable();
    }
}
