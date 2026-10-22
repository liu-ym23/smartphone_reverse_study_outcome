package com.bytedance.bdlocation.utils.cell;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityNr;
import android.telephony.CellIdentityTdscdma;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoNr;
import android.telephony.CellInfoTdscdma;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.CellSignalStrengthCdma;
import android.telephony.CellSignalStrengthGsm;
import android.telephony.CellSignalStrengthLte;
import android.telephony.CellSignalStrengthNr;
import android.telephony.CellSignalStrengthTdscdma;
import android.telephony.CellSignalStrengthWcdma;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.network.model.BaseStation;
import com.bytedance.bdlocation.network.model.BssInfo;
import com.bytedance.bdlocation.network.model.RefreshBaseStationInfo;
import com.bytedance.bdlocation.service.BDLocationExtrasService;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.ttnet.org.chromium.base.TimeUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BaseStationHelper {
    private Context mContext;
    private final TelephonyManager mTelephonyManager;

    private interface CellInfoFecher {
        List<CellInfo> fetchCellInfo();
    }

    public BaseStationHelper(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        this.mContext = ZeusTransformUtils.wrapperContext(r4, "com.obric.memorydata.plugin");
        this.mTelephonyManager = (TelephonyManager) ZeusTransformUtils.preCheckCast(r4.getSystemService(MemoryKeyInfoEntity.KEY_PHONE), TelephonyManager.class, "com.obric.memorydata.plugin");
    }

    static /* synthetic */ Context access$000(BaseStationHelper r0) {
        return r0.mContext;
    }

    static /* synthetic */ TelephonyManager access$100(BaseStationHelper r0) {
        return r0.mTelephonyManager;
    }

    private void addCellInfo(BssInfo r7, CellInfo r8, int r9, int r10, Object r11) {
        if (r7 == null) goto L6;
        if (r8 == null) goto L6;
        r7.timestamp = ((System.currentTimeMillis() - SystemClock.elapsedRealtime()) + (r8.getTimeStamp() / TimeUtils.NANOSECONDS_PER_MILLISECOND)) / 1000;
        r7.isRegistered = r8.isRegistered();
    L6:
        if (ZeusTransformUtils.instanceOf(r8, CellInfoGsm.class) == false) goto L12;
        CellInfoGsm r6 = (CellInfoGsm) ZeusTransformUtils.preCheckCast(r8, CellInfoGsm.class, "com.obric.memorydata.plugin");
        CellIdentityGsm r12 = r6.getCellIdentity();
        CellSignalStrengthGsm r13 = r6.getCellSignalStrength();
        r7.radioType = LocationInfoConst.GSM;
        r7.lac = r12.getLac();
        r7.cid = r12.getCid();
        r7.psc = r12.getPsc();
        r7.bsss = r13.getDbm();
        r7.mcc = doCheckAndReturnBackup(r12.getMcc(), r9);
        int r14 = r12.getMnc();
    L8:
        int r15 = doCheckAndReturnBackup(r14, r10);
    L9:
        long r16 = r15;
    L10:
        r7.mnc = r16;
        return;
    L12:
        if (ZeusTransformUtils.instanceOf(r8, CellInfoCdma.class) == false) goto L15;
        CellInfoCdma r17 = (CellInfoCdma) ZeusTransformUtils.preCheckCast(r8, CellInfoCdma.class, "com.obric.memorydata.plugin");
        CellIdentityCdma r18 = r17.getCellIdentity();
        CellSignalStrengthCdma r19 = r17.getCellSignalStrength();
        r7.radioType = LocationInfoConst.CDMA;
        r7.bid = r18.getBasestationId();
        r7.lat = r18.getLatitude();
        r7.longi = r18.getLongitude();
        r7.nid = r18.getNetworkId();
        r7.sid = r18.getSystemId();
        r7.bsss = r19.getDbm();
        r7.mcc = r9;
        r16 = r10;
        goto L10
    L15:
        if (ZeusTransformUtils.instanceOf(r8, CellInfoLte.class) == false) goto L24;
        CellInfoLte r20 = (CellInfoLte) ZeusTransformUtils.preCheckCast(r8, CellInfoLte.class, "com.obric.memorydata.plugin");
        CellIdentityLte r21 = r20.getCellIdentity();
        CellSignalStrengthLte r22 = r20.getCellSignalStrength();
        if (Build.VERSION.SDK_INT < 28) goto L19;
        r7.bw = r21.getBandwidth();
    L19:
        r7.ci = r21.getCi();
        if (Build.VERSION.SDK_INT < 24) goto L22;
        r7.earfcn = r21.getEarfcn();
    L22:
        r7.radioType = LocationInfoConst.LTE;
        r7.pci = r21.getPci();
        r7.tac = BDLocationExtrasService.getBPEAManager().getTac(r21, r11);
        r7.bsss = r22.getDbm();
        r7.mcc = doCheckAndReturnBackup(r21.getMcc(), r9);
        r14 = r21.getMnc();
        goto L8
    L24:
        if (Build.VERSION.SDK_INT < 18) goto L29;
        if (ZeusTransformUtils.instanceOf(r8, CellInfoWcdma.class) == false) goto L29;
        CellInfoWcdma r23 = (CellInfoWcdma) ZeusTransformUtils.preCheckCast(r8, CellInfoWcdma.class, "com.obric.memorydata.plugin");
        CellIdentityWcdma r24 = r23.getCellIdentity();
        CellSignalStrengthWcdma r25 = r23.getCellSignalStrength();
        r7.radioType = LocationInfoConst.WCDMA;
        r7.cid = r24.getCid();
        r7.lac = r24.getLac();
        r7.psc = r24.getPsc();
        r7.bsss = r25.getDbm();
        r7.mcc = doCheckAndReturnBackup(r24.getMcc(), r9);
        r14 = r24.getMnc();
    L29:
        if (Build.VERSION.SDK_INT < 29) goto L42;
        if (ZeusTransformUtils.instanceOf(r8, CellInfoNr.class) == false) goto L42;
        CellInfoNr r26 = (CellInfoNr) ZeusTransformUtils.preCheckCast(r8, CellInfoNr.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L39
        CellSignalStrengthNr r27 = (CellSignalStrengthNr) ZeusTransformUtils.preCheckCast(r26.getCellSignalStrength(), CellSignalStrengthNr.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L39
        if (r27 == null) goto L35;
        r7.bsss = r27.getSsRsrp();     // Catch: Exception -> L39
    L35:
        CellIdentityNr r28 = (CellIdentityNr) ZeusTransformUtils.preCheckCast(r26.getCellIdentity(), CellIdentityNr.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L39
        if (r28 == null) goto L52;
        r7.radioType = LocationInfoConst.NR;     // Catch: Exception -> L39
        r7.tac = r28.getTac();     // Catch: Exception -> L39
        r7.pci = r28.getPci();     // Catch: Exception -> L39
        r7.nci = r28.getNci();     // Catch: Exception -> L39
        r7.mcc = doCheckAndReturnBackup(r28.getMccString(), r9);     // Catch: Exception -> L39
        r7.mnc = doCheckAndReturnBackup(r28.getMncString(), r10);     // Catch: Exception -> L39
        r7.earfcn = r28.getNrarfcn();     // Catch: Exception -> L39
        return;
    L52:
        return;
    L39:
        e = move-exception;
        Logger.i("CellInfoNr error:" + e.toString());
        return;
    L42:
        if (Build.VERSION.SDK_INT >= 29) goto L44;
        return;
    L44:
        if (ZeusTransformUtils.instanceOf(r8, CellInfoTdscdma.class) == false) goto L55;
        CellInfoTdscdma r29 = (CellInfoTdscdma) ZeusTransformUtils.preCheckCast(r8, CellInfoTdscdma.class, "com.obric.memorydata.plugin");
        CellSignalStrengthTdscdma r30 = r29.getCellSignalStrength();
        if (r30 == null) goto L48;
        r7.bsss = r30.getDbm();
    L48:
        CellIdentityTdscdma r31 = r29.getCellIdentity();
        r7.radioType = LocationInfoConst.WCDMA;
        r7.lac = r31.getLac();
        r7.cid = r31.getCid();
        r7.cpid = r31.getCpid();
        r7.mcc = doCheckAndReturnBackup(r31.getMccString(), r9);
        r15 = doCheckAndReturnBackup(r31.getMncString(), r10);
        goto L9
    }

    private void addCurrentCellInfo(BaseStation r3, CellLocation r4, Object r5) {
        if (ZeusTransformUtils.instanceOf(r4, GsmCellLocation.class) == false) goto L6;
        GsmCellLocation r2 = (GsmCellLocation) ZeusTransformUtils.preCheckCast(r4, GsmCellLocation.class, "com.obric.memorydata.plugin");
        r3.current.radioType = LocationInfoConst.GSM;
        r3.current.cid = BDLocationExtrasService.getBPEAManager().getCid(r2, r5);
        r3.current.lac = BDLocationExtrasService.getBPEAManager().getLac(r2, r5);
        r3.current.psc = BDLocationExtrasService.getBPEAManager().getPsc(r2, r5);
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r4, CdmaCellLocation.class) == false) goto L10;
        CdmaCellLocation r6 = (CdmaCellLocation) ZeusTransformUtils.preCheckCast(r4, CdmaCellLocation.class, "com.obric.memorydata.plugin");
        r3.current.radioType = LocationInfoConst.CDMA;
        r3.current.bid = BDLocationExtrasService.getBPEAManager().getBaseStationId(r6, r5);
        r3.current.lat = BDLocationExtrasService.getBPEAManager().getBaseStationLatitude(r6, r5);
        r3.current.longi = BDLocationExtrasService.getBPEAManager().getBaseStationLongitude(r6, r5);
        r3.current.nid = BDLocationExtrasService.getBPEAManager().getNetworkId(r6, r5);
        r3.current.sid = BDLocationExtrasService.getBPEAManager().getSystemId(r6, r5);
        return;
    }

    private BaseStation buildBaseStation(Object r17, CellInfoFecher r18) {
        CellInfoFecher r0 = (CellInfoFecher) ZeusTransformUtils.wrapperContextForParams(r18, CellInfoFecher.class, "com.obric.memorydata.plugin");
        BaseStation r9 = new BaseStation();
        TelephonyManager r1 = this.mTelephonyManager;
        if (r1 == null) goto L27;
        int r2 = Integer.MAX_VALUE;
        int[] r3 = getMccMncPair(r1.getNetworkOperator());     // Catch: Exception -> L13
        if (r3 == null) goto L11;
        int r4 = r3[0];     // Catch: Exception -> L13
        int r5 = r3[1];     // Catch: Exception -> L28
        r2 = r4;
    L12:
        int r11 = r5;
        int r10 = r2;
    L15:
        r9.current = new BssInfo();
        r9.neighboring = new ArrayList();
        long r12 = -1;
        if (Build.VERSION.SDK_INT < 17) goto L25;
        List<CellInfo> r14 = r0.fetchCellInfo();
        if (r14 != null) goto L20;
    L26:
        r9.baseStationGap = (System.currentTimeMillis() / 1000) - r12;
        Logger.i("buildBaseStation baseStationGap: " + r9.baseStationGap);
        goto L27
    L20:
        if (r14.isEmpty() == true) goto L26;
        addCellInfo(r9.current, (CellInfo) ZeusTransformUtils.preCheckCast(r14.get(0), CellInfo.class, "com.obric.memorydata.plugin"), r10, r11, r17);
        Iterator<CellInfo> r15 = r14.iterator();
    L23:
        if (r15.hasNext() == false) goto L26;
        CellInfo r6 = (CellInfo) ZeusTransformUtils.preCheckCast(r15.next(), CellInfo.class, "com.obric.memorydata.plugin");
        BssInfo r16 = new BssInfo();
        addCellInfo(r16, r6, r10, r11, r17);
        r9.neighboring.add(r16);
        r12 = Math.max(r12, r16.timestamp);
        goto L23
    L25:
        addCurrentCellInfo(r9, CellInfoUtil.getCellLocation(this.mContext, this.mTelephonyManager, r17, false), r17);
    L14:
        r11 = Integer.MAX_VALUE;
        r10 = r4;
        goto L15
    L11:
        r5 = Integer.MAX_VALUE;
    L13:
        r4 = Integer.MAX_VALUE;
    L27:
        return r9;
    }

    private static int doCheckAndReturnBackup(int r1, int r2) {
        if (r1 != Integer.MAX_VALUE) goto L5;
        return r2;
    L5:
        return r1;
    }

    private static int doCheckAndReturnBackup(String r1, int r2) {
        if (TextUtils.isEmpty(r1) == false) goto L8;
        return r2;
    L8:
        return Integer.parseInt(r1);
    L7:
        return r2;
    }

    public static int[] getMccMncPair(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return null;
    L5:
        if (r3.length() > 3) goto L12;
        return null;
    L12:
        return new int[]{Integer.parseInt(r3.substring(0, 3)), Integer.parseInt(r3.substring(3))};
    L15:
        return null;
    }

    public BaseStation buildBaseState(Object r3, List<CellInfo> r4) {
        final List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        return buildBaseStation(r3, new AnonymousClass2(this, r5));
    }

    public BaseStation getBaseStation(final Object r2, final boolean r3, final RefreshBaseStationInfo r4) {
        return buildBaseStation(r2, new AnonymousClass1(this, r2, r3, r4));
    }

    public BaseStation getLightBaseStation(Object r12, boolean r13, boolean r14) {
        BaseStation r0 = new BaseStation();
        TelephonyManager r1 = this.mTelephonyManager;
        if (r1 == null) goto L38;
        int r2 = Integer.MAX_VALUE;
        int[] r3 = getMccMncPair(r1.getNetworkOperator());     // Catch: Exception -> L12
        if (r3 == null) goto L11;
        int r4 = r3[0];     // Catch: Exception -> L12
        r2 = r3[1];     // Catch: Exception -> L40
    L13:
        int r5 = r2;
        r2 = r4;
    L15:
        if (Build.VERSION.SDK_INT < 17) goto L36;
        List<CellInfo> r15 = CellInfoUtil.getAllCellInfo(this.mContext, this.mTelephonyManager, r12, false, r13, null);
        if (r15 != null) goto L19;
        return null;
    L19:
        if (r15.isEmpty() == true) goto L57;
        Iterator<CellInfo> r16 = r15.iterator();
    L22:
        if (r16.hasNext() == false) goto L35;
        CellInfo r6 = (CellInfo) ZeusTransformUtils.preCheckCast(r16.next(), CellInfo.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L22;
        if (r6.isRegistered() == true) goto L27;
        if (r14 == false) goto L22;
        if (r0.neighboring != null) goto L34;
        r0.neighboring = new ArrayList();
    L34:
        BssInfo r7 = new BssInfo();
        addCellInfo(r7, r6, r2, r5, r12);
        r0.neighboring.add(r7);
        goto L22
    L27:
        r0.current = new BssInfo();
        addCellInfo(r0.current, r6, r2, r5, r12);
        if (r14 == true) goto L22;
        return r0;
    L35:
        return r0;
    L57:
        return null;
    L36:
        addCurrentCellInfo(r0, CellInfoUtil.getCellLocation(this.mContext, this.mTelephonyManager, r12, r13), r12);
        return r0;
    L11:
        r5 = Integer.MAX_VALUE;
    L12:
        r4 = Integer.MAX_VALUE;
        goto L13
    L38:
        return null;
    }
}
