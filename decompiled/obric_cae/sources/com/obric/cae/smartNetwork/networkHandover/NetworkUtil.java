package com.obric.cae.smartNetwork.networkHandover;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.CellSignalStrength;
import android.telephony.CellSignalStrengthLte;
import android.telephony.CellSignalStrengthNr;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartNetwork.qoe.CellularQoEParam;
import com.obric.cae.smartNetwork.qoe.CellularQoeEvaluateStats;
import com.obric.cae.smartNetwork.qoe.WiFiQoEParam;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkUtil {
    public static final String ACTION_CAE_NEAR_ELEVATOR = "com.obric.cae.ACTION_CAE_NEAR_ELEVATOR";
    public static final String ACTION_CAE_NEAR_ELEVATOR_PERMISSION = "com.obric.cae.permission.ACTION_CAE_NEAR_ELEVATOR";
    public static final int HANDOVER_FAILED_REASON_BACKGROUND_DOWNLOAD = 21;
    public static final int HANDOVER_FAILED_REASON_CELL_CONNECTIVITY_INVALID = 12;
    public static final int HANDOVER_FAILED_REASON_CELL_DISABLED = 11;
    public static final int HANDOVER_FAILED_REASON_CELL_HIGH_RTT = 17;
    public static final int HANDOVER_FAILED_REASON_CELL_L4_QOE_BAD = 16;
    public static final int HANDOVER_FAILED_REASON_CELL_LOW_STANDARD = 13;
    public static final int HANDOVER_FAILED_REASON_CELL_NO_SIM = 10;
    public static final int HANDOVER_FAILED_REASON_CELL_RLF_ERROR = 15;
    public static final int HANDOVER_FAILED_REASON_CELL_WEAK_SIGNAL = 14;
    public static final int HANDOVER_FAILED_REASON_FOREGROUND_BLACKLIST = 20;
    public static final int HANDOVER_FAILED_REASON_SWITCH_LIMITED = 40;
    public static final int HANDOVER_FAILED_REASON_TRAFFIC_WARNING_BACKGROUND = 30;
    public static final int HANDOVER_FAILED_REASON_TRAFFIC_WARNING_TOTAL = 31;
    public static final int HANDOVER_FAILED_REASON_UNKNOWN = 0;
    public static final int INVALID_UID = -1;
    public static final int NETWORK_TYPE_UNKNOWN = -1;
    private static final String TAG = "NetworkUtil";
    public static final int UNVALID_NETWORK_ID = -1;
    private static final ConcurrentHashMap<String, Integer> sIfnameToNetworkIdMap = null;
    private static final ConcurrentHashMap<String, Integer> sIfnameToNetworkTypeMap = null;
    private static volatile boolean sIsNetworkCallbackRegistered;
    private static final ConcurrentHashMap<Network, String> sNetworkToIfnameMap = null;

    static {
        sIfnameToNetworkTypeMap = new ConcurrentHashMap();
        sIfnameToNetworkIdMap = new ConcurrentHashMap();
        sNetworkToIfnameMap = new ConcurrentHashMap();
        sIsNetworkCallbackRegistered = false;
    }

    public NetworkUtil() {
    }

    public static /* synthetic */ ConcurrentHashMap access$000() {
        return sNetworkToIfnameMap;
    }

    public static /* synthetic */ ConcurrentHashMap access$100() {
        return sIfnameToNetworkIdMap;
    }

    public static /* synthetic */ String access$200() {
        return TAG;
    }

    public static /* synthetic */ ConcurrentHashMap access$300() {
        return sIfnameToNetworkTypeMap;
    }

    public static Network getDefaultNetwork(Context r8) {
        return ((ConnectivityManager) r8.getSystemService("connectivity")).getActiveNetwork();
    }

    public static Network getNetworkForNetId(Context r8, int r10) {
        Network[] r11 = ((ConnectivityManager) r8.getSystemService("connectivity")).getAllNetworks();
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L8;
        Network r14 = r11[r13];
        if (r14.toString().equals(Integer.toString(r10)) == true) goto L6;
        r13 = r13 + 1;
        goto L3
    L6:
        return r14;
    L8:
        return null;
    }

    public static int getNetworkIdForIfname(Context r8, String r10) {
        if (r10 != null) goto L5;
    L24:
        return -1;
    L5:
        if (r10.isEmpty() == true) goto L24;
        registerNetworkCallbackIfNeeded(r8);
        Integer r11 = sIfnameToNetworkIdMap.get(r10);
        if (r11 != null) goto L10;
        ConnectivityManager r12 = (ConnectivityManager) r8.getSystemService("connectivity");
        if (r12 != null) goto L14;
        return -1;
    L14:
        Network[] r13 = r12.getAllNetworks();
        int r14 = r13.length;
        int r15 = 0;
    L15:
        if (r15 >= r14) goto L24;
        Network r16 = r13[r15];
        LinkProperties r17 = r12.getLinkProperties(r16);
        if (r17 == null) goto L23;
        if (Objects.equals(r17.getInterfaceName(), r10) == false) goto L23;
        int r18 = Integer.parseInt(r16.toString());     // Catch: NumberFormatException -> L22
        sIfnameToNetworkIdMap.put(r10, Integer.valueOf(r18));     // Catch: NumberFormatException -> L22
        sNetworkToIfnameMap.put(r16, r10);     // Catch: NumberFormatException -> L22
        return r18;
    L22:
        CaeLog.e(TAG, "getNetworkIdForIfname: Failed to parse network id from " + r16.toString());
    L23:
        r15 = r15 + 1;
        goto L15
    L10:
        return r11.intValue();
    }

    public static int getNetworkType(Context r8, Network r10) {
        NetworkInfo r11 = ((ConnectivityManager) r8.getSystemService("connectivity")).getNetworkInfo(r10);
        if (r11 != null) goto L5;
        return -1;
    L5:
        return r11.getType();
    }

    public static int getNetworkTypeForIfname(Context r10, String r11) {
        if (r11 != null) goto L5;
    L33:
        return -1;
    L5:
        if (r11.isEmpty() == true) goto L33;
        registerNetworkCallbackIfNeeded(r10);
        Integer r8 = sIfnameToNetworkTypeMap.get(r11);
        if (r8 != null) goto L10;
        ConnectivityManager r12 = (ConnectivityManager) r10.getSystemService("connectivity");
        if (r12 != null) goto L14;
        return -1;
    L14:
        Network[] r13 = r12.getAllNetworks();
        int r14 = r13.length;
        int r15 = 0;
    L15:
        if (r15 >= r14) goto L33;
        Network r16 = r13[r15];
        LinkProperties r17 = r12.getLinkProperties(r16);
        if (r17 == null) goto L32;
        if (Objects.equals(r17.getInterfaceName(), r11) == false) goto L32;
        NetworkCapabilities r18 = r12.getNetworkCapabilities(r16);
        if (r18 == null) goto L32;
        int r19 = 1;
        if (r18.hasTransport(1) == false) goto L26;
    L29:
        if (r19 == (-1)) goto L32;
        sIfnameToNetworkTypeMap.put(r11, Integer.valueOf(r19));
        sNetworkToIfnameMap.put(r16, r11);
        return r19;
    L26:
        if (r18.hasTransport(0) == false) goto L28;
        r19 = 0;
        goto L29
    L28:
        r19 = -1;
    L32:
        r15 = r15 + 1;
        goto L15
    L10:
        return r8.intValue();
    }

    public static int getNetworkTypeForNetId(Context r8, int r10) {
        ConnectivityManager r11 = (ConnectivityManager) r8.getSystemService("connectivity");
        Network[] r12 = r11.getAllNetworks();
        int r13 = r12.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L11;
        Network r15 = r12[r14];
        if (r15.toString().equals(Integer.toString(r10)) == false) goto L10;
        NetworkInfo r16 = r11.getNetworkInfo(r15);
        if (r16 == null) goto L10;
        return r16.getType();
    L10:
        r14 = r14 + 1;
        goto L3
    L11:
        return -1;
    }

    public static int getUidFromPackageName(Context r8, String r10) {
        return r8.getPackageManager().getPackageUid(r10, 0);
    L4:
        CaeLog.e(TAG, "getPackageUid failed. packageName: " + r10);
        return -1;
    }

    private static int getWifiBand(int r8) {
        if (r8 < 2412) goto L9;
        if (r8 > 2484) goto L9;
        return 0;
    L9:
        if (r8 >= 5160) goto L11;
        return -1;
    L11:
        if (r8 > 5885) goto L16;
        return 1;
    L16:
        return -1;
    }

    public static String getWifiBandString(int r8) {
        if (r8 != 0) goto L4;
        return "2.4G";
    L4:
        if (r8 != 1) goto L6;
        return "5G";
    L6:
        if (r8 == 2) goto L9;
        return "unknown";
    L9:
        return "6G";
    }

    public static String intToIp(int r8) {
        return (r8 & 255) + "." + ((r8 >> 8) & 255) + "." + ((r8 >> 16) & 255) + "." + ((r8 >> 24) & 255);
    }

    public static boolean isCellDataEnabled(Context r8) {
        return ((TelephonyManager) r8.getSystemService("phone")).isDataEnabled();
    }

    public static boolean isDisconnectedNetwork(Context r8, Network r10) {
        NetworkInfo r11 = ((ConnectivityManager) r8.getSystemService("connectivity")).getNetworkInfo(r10);
        if (r11 != null) goto L6;
        return true;
    L6:
        return !r11.isConnected();
    }

    public static boolean isLowStandardCell(Context r8) {
        int r10 = ((TelephonyManager) r8.getSystemService("phone")).getNetworkType();     // Catch: Exception -> L11
        if (r10 != 13) goto L7;
        return false;
    L7:
        if (r10 == 20) goto L16;
        return true;
    L16:
        return false;
    L11:
        e = move-exception;
        String r11 = TAG;
        defpackage.b.k(e, new StringBuilder("isLowStandardCell failed: "), r11);
        return true;
    }

    public static boolean isSimStateReady(Context r8) {
        if (((TelephonyManager) r8.getSystemService("phone")).getSimState() != 5) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isValidCellQoEParam(CellularQoEParam r8) {
        if (r8 == null) goto L4;
        return true;
    L4:
        return false;
    }

    public static boolean isValidCellularQoeEvaluateStats(CellularQoeEvaluateStats r8) {
        if (r8 == null) goto L4;
        return true;
    L4:
        return false;
    }

    public static boolean isValidWifiQoEParam(WiFiQoEParam r8) {
        if (r8 != null) goto L4;
    L8:
        return false;
    L4:
        if (r8.getRxThroughput() <= 0) goto L8;
        if (r8.getTxThroughput() <= 0) goto L8;
        return true;
    }

    public static boolean isWeakSignalCell(Context r8) {
        HandoverParameterManager r10 = HandoverParameterManager.getInstance(r8);
        SignalStrength r11 = ((TelephonyManager) r8.getSystemService("phone")).getSignalStrength();     // Catch: Exception -> L25
        if (r11 != null) goto L6;
        return true;
    L6:
        List<CellSignalStrength> r12 = r11.getCellSignalStrengths();     // Catch: Exception -> L25
        if (r12 == null) goto L36;
        Iterator<CellSignalStrength> r13 = r12.iterator();     // Catch: Exception -> L25
    L9:
        if (r13.hasNext() == false) goto L38;
        CellSignalStrength r14 = r13.next();     // Catch: Exception -> L25
        if ((r14 instanceof CellSignalStrengthNr) == false) goto L15;
        int r15 = ((CellSignalStrengthNr) r14).getSsRsrp();     // Catch: Exception -> L25
        int r16 = r10.getCellNrRsrpThreshold();     // Catch: Exception -> L25
    L19:
        if (r15 == Integer.MIN_VALUE) goto L9;
        if (r16 == Integer.MIN_VALUE) goto L9;
        if (r15 <= r16) goto L37;
        return false;
    L37:
        return true;
    L15:
        if ((r14 instanceof CellSignalStrengthLte) == false) goto L18;
        r15 = ((CellSignalStrengthLte) r14).getRsrp();     // Catch: Exception -> L25
        r16 = r10.getCellLteRsrpThreshold();     // Catch: Exception -> L25
        goto L19
    L18:
        r15 = Integer.MIN_VALUE;
        r16 = Integer.MIN_VALUE;
        goto L19
    L38:
        return true;
    L36:
        return true;
    L25:
        e = move-exception;
        defpackage.b.k(e, new StringBuilder("isWeakSignalCell failed: "), TAG);
        return true;
    }

    public static boolean isWeakSignalWifi(Context r8) {
        WifiManager r10 = (WifiManager) r8.getSystemService("wifi");     // Catch: Exception -> L23
        if (r10 != null) goto L7;
        CaeLog.e(TAG, "isWeakSignalWifi failed: wifiManager is null");     // Catch: Exception -> L23
        return false;
    L7:
        WifiInfo r11 = r10.getConnectionInfo();     // Catch: Exception -> L23
        if (r11 != null) goto L11;
        CaeLog.e(TAG, "isWeakSignalWifi failed: wifiInfo is null");     // Catch: Exception -> L23
        return false;
    L11:
        int r12 = getWifiBand(r11.getFrequency());     // Catch: Exception -> L23
        int r13 = r11.getRssi();     // Catch: Exception -> L23
        HandoverParameterManager r14 = HandoverParameterManager.getInstance(r8);     // Catch: Exception -> L23
        CaeLog.i(TAG, "isWeakSignalWifi: rssi=" + r13 + ", band=" + getWifiBandString(r12) + ", 24G threshold=" + r14.getWifi24GUnswitchWeakRssiThreshold() + ", 5G threshold=" + r14.getWifi5GUnswitchWeakRssiThreshold());     // Catch: Exception -> L23
        if (r12 == 0) goto L20;
        if (r12 == 1) goto L16;
        return false;
    L16:
        if (r13 < r14.getWifi5GUnswitchWeakRssiThreshold()) goto L18;
        return false;
    L18:
        return true;
    L20:
        if (r13 < r14.getWifi24GUnswitchWeakRssiThreshold()) goto L22;
        return false;
    L22:
        return true;
    L23:
        e = move-exception;
        defpackage.b.k(e, new StringBuilder("isWeakSignalWifi failed: "), TAG);
        return false;
    }

    private static void registerNetworkCallbackIfNeeded(Context r8) {
        if (sIsNetworkCallbackRegistered == false) goto L6;
        return;
    L6:
        monitor-enter(NetworkUtil.class);
    L18:
        th = move-exception;
        throw th;
    L8:
        if (sIsNetworkCallbackRegistered == false) goto L11;
        monitor-exit(NetworkUtil.class);     // Catch: Throwable -> L18
        return;
    L11:
        final ConnectivityManager r10 = (ConnectivityManager) r8.getApplicationContext().getSystemService("connectivity");     // Catch: Throwable -> L18
        if (r10 != null) goto L15;
        monitor-exit(NetworkUtil.class);     // Catch: Throwable -> L18
        return;
    L15:
        r10.registerNetworkCallback(new NetworkRequest.Builder().build(), new AnonymousClass1(r10));     // Catch: Throwable -> L18
        sIsNetworkCallbackRegistered = true;     // Catch: Throwable -> L18
        monitor-exit(NetworkUtil.class);     // Catch: Throwable -> L18
    }
}
