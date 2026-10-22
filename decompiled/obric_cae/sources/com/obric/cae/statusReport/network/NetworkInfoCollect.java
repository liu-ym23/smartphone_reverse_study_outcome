package com.obric.cae.statusReport.network;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.CellIdentityNr;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoNr;
import android.telephony.CellInfoWcdma;
import android.telephony.CellSignalStrengthNr;
import android.telephony.TelephonyManager;
import com.obric.cae.smartNetwork.networkHandover.NetworkScore;
import com.obric.cae.utils.CaeWifiUtil;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkInfoCollect {
    public static final int CELL_TYPE_CDMA = 2;
    public static final int CELL_TYPE_GSM = 1;
    public static final int CELL_TYPE_LTE = 3;
    public static final int CELL_TYPE_NR = 4;
    public static final int CELL_TYPE_UNKNOWN = 0;
    public static final int CELL_TYPE_WCDMA = 5;
    public static final int SWITCH_MODE_CELL_TO_WIFI = 2;
    public static final int SWITCH_MODE_WIFI_TO_CELL = 1;
    public static final int SWITCH_REASON_AOSP = 3;
    public static final int SWITCH_REASON_ML = 1;
    public static final int SWITCH_REASON_RULE = 2;
    public static final int SWITCH_REASON_UNKNOWN = 0;
    public static final int SWITCH_SUBREASON_INVALID = 1;
    public static final int SWITCH_SUBREASON_L2_QOE = 2;
    public static final int SWITCH_SUBREASON_L4_QOE = 3;
    public static final int SWITCH_SUBREASON_UNKNOWN = 0;
    private static final String TAG = "NetworkHandoverMetrics";
    private static volatile NetworkInfoCollect sInstance;
    private final ActivityManager mActivityManager;
    private final ConnectivityManager mConnectivityManager;
    private final Context mContext;
    private long mHandoverStartTime;
    private final TelephonyManager mTelephonyManager;
    private final WifiManager mWifiManager;

    public class CellularInfo {
        private long cellId;
        private int rsrp;
        private int sinr;
        private int subId;
        final /* synthetic */ NetworkInfoCollect this$0;
        private int type;

        public CellularInfo(NetworkInfoCollect r8) {
            this.this$0 = r8;
        }

        public long getCellId() {
            return this.cellId;
        }

        public int getRsrp() {
            return this.rsrp;
        }

        public int getSinr() {
            return this.sinr;
        }

        public int getSubId() {
            return this.subId;
        }

        public int getType() {
            return this.type;
        }

        public void setCellId(long r8) {
            this.cellId = r8;
        }

        public void setRsrp(int r8) {
            this.rsrp = r8;
        }

        public void setSinr(int r8) {
            this.sinr = r8;
        }

        public void setSubId(int r8) {
            this.subId = r8;
        }

        public void setType(int r8) {
            this.type = r8;
        }
    }

    public class HandoverInfo {
        private int failedReason;
        private String foregroundApp;
        private long handoverTime;
        private boolean isSuccess;
        private int mode;
        private int reason;
        private int subReason;
        private int switchTimes;
        final /* synthetic */ NetworkInfoCollect this$0;

        public HandoverInfo(NetworkInfoCollect r8) {
            this.this$0 = r8;
            this.foregroundApp = "";
        }

        public int getFailedReason() {
            return this.failedReason;
        }

        public String getForegroundApp() {
            return this.foregroundApp;
        }

        public long getHandoverTime() {
            return this.handoverTime;
        }

        public int getMode() {
            return this.mode;
        }

        public int getReason() {
            return this.reason;
        }

        public int getSubReason() {
            return this.subReason;
        }

        public int getSwitchTimes() {
            return this.switchTimes;
        }

        public boolean isSuccess() {
            return this.isSuccess;
        }

        public void setFailedReason(int r8) {
            this.failedReason = r8;
        }

        public void setForegroundApp(String r8) {
            this.foregroundApp = NetworkInfoCollect.access$000(r8);
        }

        public void setHandoverTime(long r8) {
            this.handoverTime = r8;
        }

        public void setIsSuccess(boolean r8) {
            this.isSuccess = r8;
        }

        public void setMode(int r8) {
            this.mode = r8;
        }

        public void setReason(int r8) {
            this.reason = r8;
        }

        public void setSubReason(int r8) {
            this.subReason = r8;
        }

        public void setSwitchTimes(int r8) {
            this.switchTimes = r8;
        }
    }

    public static class NetworkDetailInfo {
        private int cellRsrp;
        private int cellSinr;
        private int cellType;
        private int wifiFreq;
        private int wifiRssi;
        private String wifiSsid;

        public NetworkDetailInfo() {
        }

        public int getCellRsrp() {
            return this.cellRsrp;
        }

        public int getCellSinr() {
            return this.cellSinr;
        }

        public int getCellType() {
            return this.cellType;
        }

        public int getWifiFreq() {
            return this.wifiFreq;
        }

        public int getWifiRssi() {
            return this.wifiRssi;
        }

        public String getWifiSsid() {
            return this.wifiSsid;
        }

        public void setCellRsrp(int r8) {
            this.cellRsrp = r8;
        }

        public void setCellSinr(int r8) {
            this.cellSinr = r8;
        }

        public void setCellType(int r8) {
            this.cellType = r8;
        }

        public void setWifiFreq(int r8) {
            this.wifiFreq = r8;
        }

        public void setWifiRssi(int r8) {
            this.wifiRssi = r8;
        }

        public void setWifiSsid(String r8) {
            this.wifiSsid = r8;
        }

        public String toString() {
            return "wifiSsid=" + CaeWifiUtil.ssidHide(this.wifiSsid) + ", wifiRssi=" + this.wifiRssi + ", wifiFreq=" + this.wifiFreq + ", cellType=" + this.cellType + ", cellRsrp=" + this.cellRsrp + ", cellSinr=" + this.cellSinr;
        }
    }

    private NetworkInfoCollect(Context r8) {
        this.mContext = r8;
        this.mConnectivityManager = (ConnectivityManager) r8.getSystemService("connectivity");
        this.mTelephonyManager = (TelephonyManager) r8.getSystemService("phone");
        this.mWifiManager = (WifiManager) r8.getSystemService("wifi");
        this.mActivityManager = (ActivityManager) r8.getSystemService("activity");
    }

    public static /* synthetic */ String access$000(String r8) {
        return safeString(r8);
    }

    private String getForegroundPackageName() {
        List<ActivityManager.RunningTaskInfo> r8 = this.mActivityManager.getRunningTasks(1);
        if (r8 != null) goto L5;
        return "";
    L5:
        if (r8.isEmpty() == true) goto L12;
        ComponentName r10 = r8.get(0).topActivity;
        if (r10 != null) goto L9;
        return "";
    L9:
        return safeString(r10.getPackageName());
    L12:
        return "";
    }

    private long getHandoverTime() {
        if (this.mHandoverStartTime != 0) goto L5;
        return 0;
    L5:
        long r8 = System.currentTimeMillis() - this.mHandoverStartTime;
        this.mHandoverStartTime = 0;
        return r8;
    }

    public static NetworkInfoCollect getInstance(Context r8) {
        if (sInstance != null) goto L15;
        monitor-enter(NetworkInfoCollect.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new NetworkInfoCollect(r8);     // Catch: Throwable -> L11
    L9:
        monitor-exit(NetworkInfoCollect.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private boolean isValidWifiInfo(WifiInfo r8) {
        if (r8 != null) goto L4;
        return false;
    L4:
        if (r8.getSSID() != null) goto L6;
        return false;
    L6:
        if (r8.getSSID().isEmpty() == false) goto L9;
        return false;
    L9:
        return !"<unknown ssid>".equals(r8.getSSID());
    }

    private static String safeString(String r8) {
        if (r8 != null) goto L6;
        return "";
    L6:
        return r8;
    }

    public CellularInfo getCellInfoForNetwork() {
        CellularInfo r8 = new CellularInfo(this);
        List<CellInfo> r10 = this.mTelephonyManager.getAllCellInfo();
        if (r10 != null) goto L5;
        return r8;
    L5:
        Iterator<CellInfo> r11 = r10.iterator();
    L7:
        if (r11.hasNext() == false) goto L31;
        CellInfo r12 = r11.next();
        if (r12.isRegistered() == false) goto L7;
        if ((r12 instanceof CellInfoNr) == true) goto L13;
        if ((r12 instanceof CellInfoLte) == true) goto L18;
        if ((r12 instanceof CellInfoWcdma) == false) goto L25;
        r8.setType(5);
        int r13 = ((CellInfoWcdma) r12).getCellIdentity().getCid();
    L22:
        long r14 = r13;
    L23:
        r8.setCellId(r14);
        goto L7
    L25:
        if ((r12 instanceof CellInfoGsm) == false) goto L28;
        r8.setType(1);
        r13 = ((CellInfoGsm) r12).getCellIdentity().getCid();
        goto L22
    L28:
        if ((r12 instanceof CellInfoCdma) == false) goto L30;
        r8.setType(2);
        r13 = ((CellInfoCdma) r12).getCellIdentity().getBasestationId();
        goto L22
    L30:
        r8.setType(0);
        r14 = 0;
        goto L23
    L18:
        r8.setType(3);
        CellInfoLte r15 = (CellInfoLte) r12;
        r8.setCellId(r15.getCellIdentity().getCi());
        r8.setRsrp(r15.getCellSignalStrength().getRsrp());
        int r16 = r15.getCellSignalStrength().getRssnr();
    L15:
        r8.setSinr(r16);
        goto L7
    L13:
        r8.setType(4);
        CellInfoNr r17 = (CellInfoNr) r12;
        r8.setCellId(((CellIdentityNr) r17.getCellIdentity()).getNci());
        CellSignalStrengthNr r18 = (CellSignalStrengthNr) r17.getCellSignalStrength();
        r8.setRsrp(r18.getSsRsrp());
        r16 = r18.getSsSinr();
        if (r16 == Integer.MAX_VALUE) goto L7;
    L31:
        return r8;
    }

    public HandoverInfo getHandoverInfo(Network r8, Network r10, ConcurrentHashMap<Integer, NetworkScore> r11) {
        HandoverInfo r12 = new HandoverInfo(this);
        NetworkCapabilities r13 = this.mConnectivityManager.getNetworkCapabilities(r8);
        NetworkCapabilities r14 = this.mConnectivityManager.getNetworkCapabilities(r10);
        if (r13 == null) goto L15;
        if (r14 == null) goto L15;
        if (r13.hasTransport(0) == false) goto L11;
        if (r14.hasTransport(1) == false) goto L11;
        r12.setMode(2);
    L11:
        if (r13.hasTransport(1) == false) goto L15;
        if (r14.hasTransport(0) == false) goto L15;
        r12.setMode(1);
    L15:
        r12.setForegroundApp(getForegroundPackageName());
        int r15 = Integer.parseInt(r8.toString());
        if (r12.getMode() != 1) goto L31;
        Iterator<NetworkScore> r16 = r11.values().iterator();
    L19:
        if (r16.hasNext() == false) goto L31;
        NetworkScore r17 = r16.next();
        if (r15 != r17.getNetId()) goto L19;
        if (r17.hasPolicy(2) == false) goto L24;
        if (r17.hasPolicy(3) == false) goto L27;
        if (r17.hasPolicy(4) == true) goto L19;
        r12.setSubReason(3);
        goto L19
    L27:
        r12.setSubReason(2);
        goto L19
    L24:
        r12.setSubReason(1);
    L31:
        return r12;
    }

    @SuppressLint({"NewApi"})
    public NetworkDetailInfo getNetworkDetailInfo(Network r8) {
        NetworkDetailInfo r10 = new NetworkDetailInfo();
        if (r8 != null) goto L5;
        return r10;
    L5:
        NetworkCapabilities r11 = this.mConnectivityManager.getNetworkCapabilities(r8);
        if (r11 != null) goto L9;
        return r10;
    L9:
        if (r11.hasTransport(1) == false) goto L14;
        WifiInfo r12 = getWifiInfoForNetwork();
        if (r12 == null) goto L16;
        r10.setWifiSsid(r12.getSSID());
        r10.setWifiRssi(r12.getRssi());
        r10.setWifiFreq(r12.getFrequency());
    L16:
        return r10;
    L14:
        if (r11.hasTransport(0) == false) goto L16;
        CellularInfo r13 = getCellInfoForNetwork();
        r10.setCellType(r13.getType());
        r10.setCellRsrp(r13.getRsrp());
        r10.setCellSinr(r13.getSinr());
        goto L16
    }

    public HandoverInfo getNoCellFailHandoverInfo(int r8, ConcurrentHashMap<Integer, NetworkScore> r10) {
        HandoverInfo r11 = new HandoverInfo(this);
        r11.setMode(1);
        r11.setForegroundApp(getForegroundPackageName());
        NetworkScore r12 = r10.get(Integer.valueOf(r8));
        if (r12 != null) goto L5;
    L10:
        return r11;
    L5:
        if (r12.hasPolicy(3) == true) goto L8;
        r11.setSubReason(2);
        goto L10
    L8:
        if (r12.hasPolicy(4) == true) goto L10;
        r11.setSubReason(3);
        goto L10
    }

    @SuppressLint({"NewApi"})
    public WifiInfo getWifiInfoForNetwork() {
        Network[] r8 = this.mConnectivityManager.getAllNetworks();
        int r10 = r8.length;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L15;
        Network r12 = r8[r11];
        NetworkCapabilities r13 = this.mConnectivityManager.getNetworkCapabilities(r12);
        if (r13 == null) goto L14;
        if (r13.hasTransport(1) == false) goto L14;
        if ((r13.getTransportInfo() instanceof WifiInfo) == false) goto L14;
        WifiInfo r14 = (WifiInfo) r13.getTransportInfo();
        if (isValidWifiInfo(r14) == false) goto L14;
        return r14;
    L14:
        r11 = r11 + 1;
        goto L3
    L15:
        WifiInfo r15 = this.mWifiManager.getConnectionInfo();
        if (isValidWifiInfo(r15) == true) goto L19;
        return null;
    L19:
        return r15;
    }

    public void recordHandoverStartTime() {
        this.mHandoverStartTime = System.currentTimeMillis();
    }
}
