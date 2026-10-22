package com.obric.cae.smartNetwork.netAccel;

import android.content.Context;
import android.telephony.CellIdentityNr;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoNr;
import android.telephony.CellInfoWcdma;
import android.telephony.CellSignalStrengthNr;
import android.telephony.TelephonyManager;
import android.util.EventsUtils;
import com.obric.cae.log.CaeLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class AccelMetric {
    public static final int ACCEL_STATE_DISABLE = 2;
    public static final int ACCEL_STATE_ENABLE = 0;
    public static final int ACCEL_STATE_REENABLE = 1;
    public static final int ACCEL_UID_STATE_DISABLE = 1;
    public static final int ACCEL_UID_STATE_ENABLE = 0;
    public static final int APP_INFO_STATE_ACTIVE = 1;
    public static final int APP_INFO_STATE_INACTIVE = 0;
    public static final int AUTO_DUAL_WLAN_STATE_AUTO = 0;
    public static final int AUTO_DUAL_WLAN_STATE_LOST = 3;
    public static final int AUTO_DUAL_WLAN_STATE_STOP = 1;
    public static final int AUTO_DUAL_WLAN_STATE_SUCCESS = 2;
    public static final int AUTO_DUAL_WLAN_STATE_UNAVAILABLE = 4;
    public static final int CAE_MULTI_NET_ACCEL_EVENT_FEATURE_ID = 123;
    public static final int CELL_TYPE_CDMA = 2;
    public static final int CELL_TYPE_GSM = 1;
    public static final int CELL_TYPE_LTE = 3;
    public static final int CELL_TYPE_NR = 4;
    public static final int CELL_TYPE_UNKNOWN = 0;
    public static final int CELL_TYPE_WCDMA = 5;
    private static final String TAG = "MultiNetwork-AccelMetric";
    public static final int WIFI_TYPE_PRIMARY = 0;
    public static final int WIFI_TYPE_SECONDARY = 1;
    private static AccelMetric sInstance;
    private final Context mContext;
    private TelephonyManager mTelephonyManager;

    private AccelMetric(Context r8) {
        this.mContext = r8;
        this.mTelephonyManager = (TelephonyManager) r8.getSystemService("phone");
    }

    public static AccelMetric getInstance(Context r8) {
        if (sInstance != null) goto L15;
        monitor-enter(AccelMetric.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new AccelMetric(r8);     // Catch: Throwable -> L11
    L9:
        monitor-exit(AccelMetric.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public List<AccelCapability.CellularInfo> getCellularInfoList() {
        ArrayList r8 = new ArrayList();
        TelephonyManager r10 = this.mTelephonyManager;
        if (r10 != null) goto L33;
    L32:
        return r8;
    L33:
        Iterator<CellInfo> r11 = r10.getAllCellInfo().iterator();     // Catch: SecurityException -> L30
    L5:
        if (r11.hasNext() == false) goto L32;
        CellInfo r12 = r11.next();     // Catch: SecurityException -> L30
        if (r12.isRegistered() == false) goto L5;
        AccelCapability.CellularInfo.Builder r13 = AccelCapability.CellularInfo.newBuilder();     // Catch: SecurityException -> L30
        if ((r12 instanceof CellInfoNr) == false) goto L15;
        r13.setType(4);     // Catch: SecurityException -> L30
        r13.setCellId(((CellIdentityNr) ((CellInfoNr) r12).getCellIdentity()).getNci());     // Catch: SecurityException -> L30
        CellSignalStrengthNr r14 = (CellSignalStrengthNr) ((CellInfoNr) r12).getCellSignalStrength();     // Catch: SecurityException -> L30
        r13.setRsrp(r14.getSsRsrp());     // Catch: SecurityException -> L30
        int r15 = r14.getSsSinr();     // Catch: SecurityException -> L30
    L13:
        r13.setSinr(r15);     // Catch: SecurityException -> L30
    L28:
        r8.add(r13.build());     // Catch: SecurityException -> L30
        goto L5
    L15:
        if ((r12 instanceof CellInfoLte) == false) goto L18;
        r13.setType(3);     // Catch: SecurityException -> L30
        r13.setCellId(((CellInfoLte) r12).getCellIdentity().getCi());     // Catch: SecurityException -> L30
        r13.setRsrp(((CellInfoLte) r12).getCellSignalStrength().getRsrp());     // Catch: SecurityException -> L30
        r15 = ((CellInfoLte) r12).getCellSignalStrength().getRssnr();     // Catch: SecurityException -> L30
        goto L13
    L18:
        if ((r12 instanceof CellInfoWcdma) == false) goto L22;
        r13.setType(5);     // Catch: SecurityException -> L30
        int r16 = ((CellInfoWcdma) r12).getCellIdentity().getCid();     // Catch: SecurityException -> L30
    L20:
        r13.setCellId(r16);     // Catch: SecurityException -> L30
        goto L28
    L22:
        if ((r12 instanceof CellInfoGsm) == false) goto L25;
        r13.setType(1);     // Catch: SecurityException -> L30
        r16 = ((CellInfoGsm) r12).getCellIdentity().getCid();     // Catch: SecurityException -> L30
        goto L20
    L25:
        if ((r12 instanceof CellInfoCdma) == false) goto L27;
        r13.setType(2);     // Catch: SecurityException -> L30
        r16 = ((CellInfoCdma) r12).getCellIdentity().getBasestationId();     // Catch: SecurityException -> L30
        goto L20
    L27:
        r13.setType(0);     // Catch: SecurityException -> L30
        r13.setCellId(0);     // Catch: SecurityException -> L30
    L30:
        e = move-exception;
        CaeLog.e(TAG, "Failed to get cell info: " + e.getMessage());
        goto L32
    }

    public void reportAccelCapability(int r8, List<AccelCapability.WifiInfo> r10, List<AccelCapability.CellularInfo> r11) {
        AccelCapability.Builder r12 = AccelCapability.newBuilder();     // Catch: Exception -> L19
        r12.setState(r8);     // Catch: Exception -> L19
        r12.setTimestamp(System.currentTimeMillis());     // Catch: Exception -> L19
        if (r10 == null) goto L10;
        Iterator<AccelCapability.WifiInfo> r13 = r10.iterator();     // Catch: Exception -> L19
    L6:
        if (r13.hasNext() == false) goto L10;
        AccelCapability.WifiInfo r14 = r13.next();     // Catch: Exception -> L19
        if (r14 == null) goto L6;
        r12.addWifiInfo(r14);     // Catch: Exception -> L19
    L10:
        if (r11 == null) goto L17;
        Iterator<AccelCapability.CellularInfo> r15 = r11.iterator();     // Catch: Exception -> L19
    L13:
        if (r15.hasNext() == false) goto L17;
        AccelCapability.CellularInfo r16 = r15.next();     // Catch: Exception -> L19
        if (r16 == null) goto L13;
        r12.addCellularInfo(r16);     // Catch: Exception -> L19
    L17:
        MultiNetAccelProto.Builder r17 = MultiNetAccelProto.newBuilder();     // Catch: Exception -> L19
        MultiNetAccelProtoData.Builder r18 = MultiNetAccelProtoData.newBuilder();     // Catch: Exception -> L19
        r18.setAccelCapability(r12.build());     // Catch: Exception -> L19
        r17.addMultiNetAccelProto(r18.build());     // Catch: Exception -> L19
        EventsUtils.writePbEvent(System.currentTimeMillis(), CAE_MULTI_NET_ACCEL_EVENT_FEATURE_ID, r17.build().toByteArray());     // Catch: Exception -> L19
        return;
    L19:
        e = move-exception;
        defpackage.b.k(e, new StringBuilder("reportAccelCapability failed"), TAG);
    }

    public void reportAccelUidCapability(List<AccelUidCapability.AppInfo> r8) {
        AccelUidCapability.Builder r10 = AccelUidCapability.newBuilder();     // Catch: Exception -> L12
        r10.setTimestamp(System.currentTimeMillis());     // Catch: Exception -> L12
        if (r8 == null) goto L10;
        Iterator<AccelUidCapability.AppInfo> r11 = r8.iterator();     // Catch: Exception -> L12
    L6:
        if (r11.hasNext() == false) goto L10;
        AccelUidCapability.AppInfo r12 = r11.next();     // Catch: Exception -> L12
        if (r12 == null) goto L6;
        r10.addAppInfo(AccelUidCapability.AppInfo.newBuilder(r12).build());     // Catch: Exception -> L12
    L10:
        MultiNetAccelProto.Builder r13 = MultiNetAccelProto.newBuilder();     // Catch: Exception -> L12
        MultiNetAccelProtoData.Builder r14 = MultiNetAccelProtoData.newBuilder();     // Catch: Exception -> L12
        r14.setAccelUidCapability(r10.build());     // Catch: Exception -> L12
        r13.addMultiNetAccelProto(r14.build());     // Catch: Exception -> L12
        EventsUtils.writePbEvent(System.currentTimeMillis(), CAE_MULTI_NET_ACCEL_EVENT_FEATURE_ID, r13.build().toByteArray());     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        defpackage.b.k(e, new StringBuilder("reportAccelUidCapability failed"), TAG);
    }

    public void reportAppSocketStats(AppSocketStats r8) {
        if (r8 != null) goto L16;
        return;
    L16:
        long r10 = System.currentTimeMillis();     // Catch: Exception -> L13
        if (r8.getStartTimestamp() > 0) goto L9;
        r8 = r8.toBuilder().setStartTimestamp(r10).build();     // Catch: Exception -> L13
    L9:
        if (r8.getEndTimestamp() > 0) goto L11;
        r8 = r8.toBuilder().setEndTimestamp(r8.getStartTimestamp()).build();     // Catch: Exception -> L13
    L11:
        MultiNetAccelProto.Builder r11 = MultiNetAccelProto.newBuilder();     // Catch: Exception -> L13
        MultiNetAccelProtoData.Builder r12 = MultiNetAccelProtoData.newBuilder();     // Catch: Exception -> L13
        r12.setAppSocketStats(r8);     // Catch: Exception -> L13
        r11.addMultiNetAccelProto(r12.build());     // Catch: Exception -> L13
        CaeLog.d(TAG, "reportAppSocketStats writePbEvent ");     // Catch: Exception -> L13
        EventsUtils.writePbEvent(System.currentTimeMillis(), CAE_MULTI_NET_ACCEL_EVENT_FEATURE_ID, r11.build().toByteArray());     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        defpackage.b.k(e, new StringBuilder("reportAppSocketStats failed"), TAG);
    }

    public void reportAutoDualWlanCapability(int r8, List<AutoDualWlanCapability.AppInfo> r10) {
        AutoDualWlanCapability.Builder r11 = AutoDualWlanCapability.newBuilder();     // Catch: Exception -> L12
        r11.setState(r8);     // Catch: Exception -> L12
        r11.setTimestamp(System.currentTimeMillis());     // Catch: Exception -> L12
        if (r10 == null) goto L10;
        Iterator<AutoDualWlanCapability.AppInfo> r12 = r10.iterator();     // Catch: Exception -> L12
    L6:
        if (r12.hasNext() == false) goto L10;
        AutoDualWlanCapability.AppInfo r13 = r12.next();     // Catch: Exception -> L12
        if (r13 == null) goto L6;
        r11.addAppInfo(AutoDualWlanCapability.AppInfo.newBuilder(r13).build());     // Catch: Exception -> L12
    L10:
        MultiNetAccelProto.Builder r14 = MultiNetAccelProto.newBuilder();     // Catch: Exception -> L12
        MultiNetAccelProtoData.Builder r15 = MultiNetAccelProtoData.newBuilder();     // Catch: Exception -> L12
        r15.setAutoDualWlanCapability(r11.build());     // Catch: Exception -> L12
        r14.addMultiNetAccelProto(r15.build());     // Catch: Exception -> L12
        EventsUtils.writePbEvent(System.currentTimeMillis(), CAE_MULTI_NET_ACCEL_EVENT_FEATURE_ID, r14.build().toByteArray());     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        defpackage.b.k(e, new StringBuilder("reportAutoDualWlanCapability failed"), TAG);
    }
}
