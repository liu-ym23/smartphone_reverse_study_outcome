package com.bytedance.bdlocation.utils.cell;

import android.content.Context;
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
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.network.model.BaseStation;
import com.bytedance.bdlocation.network.model.BssInfo;
import com.bytedance.bdlocation.network.model.RefreshBaseStationInfo;
import com.bytedance.bdlocation.service.BDLocationExtrasService;
import com.obric.cae.BWDL.BwdlDrop.BwdlDropUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BaseStationHelper {
    private Context mContext;
    private final TelephonyManager mTelephonyManager;

    public interface CellInfoFecher {
        List<CellInfo> fetchCellInfo();
    }

    public BaseStationHelper(Context r8) {
        this.mContext = r8;
        this.mTelephonyManager = (TelephonyManager) r8.getSystemService("phone");
    }

    public static /* synthetic */ Context access$000(BaseStationHelper r8) {
        return r8.mContext;
    }

    public static /* synthetic */ TelephonyManager access$100(BaseStationHelper r8) {
        return r8.mTelephonyManager;
    }

    private void addCellInfo(BssInfo r8, CellInfo r10, int r11, int r12, Object r13) {
        if (r8 == null) goto L6;
        if (r10 == null) goto L6;
        r8.timestamp = ((r10.getTimeStamp() / BwdlDropUtils.DROP_SHOW_MEGABYTES) + (System.currentTimeMillis() - SystemClock.elapsedRealtime())) / 1000;
        r8.isRegistered = r10.isRegistered();
    L6:
        if ((r10 instanceof CellInfoGsm) == false) goto L12;
        CellInfoGsm r14 = (CellInfoGsm) r10;
        CellIdentityGsm r15 = r14.getCellIdentity();
        CellSignalStrengthGsm r16 = r14.getCellSignalStrength();
        r8.radioType = "gsm";
        r8.lac = r15.getLac();
        r8.cid = r15.getCid();
        r8.psc = r15.getPsc();
        r8.bsss = r16.getDbm();
        r8.mcc = doCheckAndReturnBackup(r15.getMcc(), r11);
        int r17 = r15.getMnc();
    L8:
        int r18 = doCheckAndReturnBackup(r17, r12);
    L9:
        long r19 = r18;
    L10:
        r8.mnc = r19;
        return;
    L12:
        if ((r10 instanceof CellInfoCdma) == false) goto L15;
        CellInfoCdma r20 = (CellInfoCdma) r10;
        CellIdentityCdma r21 = r20.getCellIdentity();
        CellSignalStrengthCdma r22 = r20.getCellSignalStrength();
        r8.radioType = "cdma";
        r8.bid = r21.getBasestationId();
        r8.lat = r21.getLatitude();
        r8.longi = r21.getLongitude();
        r8.nid = r21.getNetworkId();
        r8.sid = r21.getSystemId();
        r8.bsss = r22.getDbm();
        r8.mcc = r11;
        r19 = r12;
        goto L10
    L15:
        if ((r10 instanceof CellInfoLte) == false) goto L18;
        CellInfoLte r23 = (CellInfoLte) r10;
        CellIdentityLte r24 = r23.getCellIdentity();
        CellSignalStrengthLte r25 = r23.getCellSignalStrength();
        r8.bw = r24.getBandwidth();
        r8.ci = r24.getCi();
        r8.earfcn = r24.getEarfcn();
        r8.radioType = "lte";
        r8.pci = r24.getPci();
        r8.tac = BDLocationExtrasService.getBPEAManager().getTac(r24, r13);
        r8.bsss = r25.getDbm();
        r8.mcc = doCheckAndReturnBackup(r24.getMcc(), r11);
        r17 = r24.getMnc();
        goto L8
    L18:
        if ((r10 instanceof CellInfoWcdma) == false) goto L21;
        CellInfoWcdma r26 = (CellInfoWcdma) r10;
        CellIdentityWcdma r27 = r26.getCellIdentity();
        CellSignalStrengthWcdma r28 = r26.getCellSignalStrength();
        r8.radioType = "wcdma";
        r8.cid = r27.getCid();
        r8.lac = r27.getLac();
        r8.psc = r27.getPsc();
        r8.bsss = r28.getDbm();
        r8.mcc = doCheckAndReturnBackup(r27.getMcc(), r11);
        r17 = r27.getMnc();
        goto L8
    L21:
        if ((r10 instanceof CellInfoNr) == false) goto L32;
        CellInfoNr r29 = (CellInfoNr) r10;     // Catch: Exception -> L29
        CellSignalStrengthNr r30 = (CellSignalStrengthNr) r29.getCellSignalStrength();     // Catch: Exception -> L29
        if (r30 == null) goto L25;
        r8.bsss = r30.getSsRsrp();     // Catch: Exception -> L29
    L25:
        CellIdentityNr r31 = (CellIdentityNr) r29.getCellIdentity();     // Catch: Exception -> L29
        if (r31 == null) goto L40;
        r8.radioType = "nr";     // Catch: Exception -> L29
        r8.tac = r31.getTac();     // Catch: Exception -> L29
        r8.pci = r31.getPci();     // Catch: Exception -> L29
        r8.nci = r31.getNci();     // Catch: Exception -> L29
        r8.mcc = doCheckAndReturnBackup(r31.getMccString(), r11);     // Catch: Exception -> L29
        r8.mnc = doCheckAndReturnBackup(r31.getMncString(), r12);     // Catch: Exception -> L29
        r8.earfcn = r31.getNrarfcn();     // Catch: Exception -> L29
        return;
    L40:
        return;
    L29:
        e = move-exception;
        Logger.i("CellInfoNr error:" + e.toString());
        return;
    L32:
        if ((r10 instanceof CellInfoTdscdma) == false) goto L42;
        CellInfoTdscdma r32 = (CellInfoTdscdma) r10;
        CellSignalStrengthTdscdma r33 = r32.getCellSignalStrength();
        if (r33 == null) goto L36;
        r8.bsss = r33.getDbm();
    L36:
        CellIdentityTdscdma r34 = r32.getCellIdentity();
        r8.radioType = "wcdma";
        r8.lac = r34.getLac();
        r8.cid = r34.getCid();
        r8.cpid = r34.getCpid();
        r8.mcc = doCheckAndReturnBackup(r34.getMccString(), r11);
        r18 = doCheckAndReturnBackup(r34.getMncString(), r12);
        goto L9
    }

    private void addCurrentCellInfo(BaseStation r8, CellLocation r10, Object r11) {
        if ((r10 instanceof GsmCellLocation) == false) goto L6;
        GsmCellLocation r12 = (GsmCellLocation) r10;
        BssInfo r13 = r8.current;
        r13.radioType = "gsm";
        r13.cid = BDLocationExtrasService.getBPEAManager().getCid(r12, r11);
        r8.current.lac = BDLocationExtrasService.getBPEAManager().getLac(r12, r11);
        r8.current.psc = BDLocationExtrasService.getBPEAManager().getPsc(r12, r11);
        return;
    L6:
        if ((r10 instanceof CdmaCellLocation) == false) goto L10;
        CdmaCellLocation r14 = (CdmaCellLocation) r10;
        BssInfo r15 = r8.current;
        r15.radioType = "cdma";
        r15.bid = BDLocationExtrasService.getBPEAManager().getBaseStationId(r14, r11);
        r8.current.lat = BDLocationExtrasService.getBPEAManager().getBaseStationLatitude(r14, r11);
        r8.current.longi = BDLocationExtrasService.getBPEAManager().getBaseStationLongitude(r14, r11);
        r8.current.nid = BDLocationExtrasService.getBPEAManager().getNetworkId(r14, r11);
        r8.current.sid = BDLocationExtrasService.getBPEAManager().getSystemId(r14, r11);
        return;
    }

    private BaseStation buildBaseStation(Object r14, CellInfoFecher r15) {
        BaseStation r8 = new BaseStation();
        TelephonyManager r10 = this.mTelephonyManager;
        if (r10 == null) goto L24;
        int r11 = Integer.MAX_VALUE;
        int[] r12 = getMccMncPair(r10.getNetworkOperator());     // Catch: Exception -> L12
        if (r12 == null) goto L11;
        int r13 = r12[0];     // Catch: Exception -> L12
        int r16 = r12[1];     // Catch: Exception -> L25
    L14:
        r11 = r13;
    L15:
        r8.current = new BssInfo();
        r8.neighboring = new ArrayList();
        List<CellInfo> r17 = r15.fetchCellInfo();
        long r18 = -1;
        if (r17 != null) goto L18;
    L23:
        r8.baseStationGap = (System.currentTimeMillis() / 1000) - r18;
        Logger.i("buildBaseStation baseStationGap: " + r8.baseStationGap);
        goto L24
    L18:
        if (r17.isEmpty() == true) goto L23;
        addCellInfo(r8.current, r17.get(0), r11, r16, r14);
        Iterator<CellInfo> r19 = r17.iterator();
    L21:
        if (r19.hasNext() == false) goto L23;
        CellInfo r20 = r19.next();
        BssInfo r21 = new BssInfo();
        addCellInfo(r21, r20, r11, r16, r14);
        r8.neighboring.add(r21);
        r18 = Math.max(r18, r21.timestamp);
    L13:
        r16 = Integer.MAX_VALUE;
        goto L14
    L11:
        r16 = Integer.MAX_VALUE;
    L12:
        r13 = Integer.MAX_VALUE;
    L24:
        return r8;
    }

    private static int doCheckAndReturnBackup(int r8, int r10) {
        if (r8 != Integer.MAX_VALUE) goto L5;
        return r10;
    L5:
        return r8;
    }

    public static int[] getMccMncPair(String r8) {
        if (TextUtils.isEmpty(r8) == false) goto L5;
        return null;
    L5:
        if (r8.length() > 3) goto L12;
        return null;
    L12:
        return new int[]{Integer.parseInt(r8.substring(0, 3)), Integer.parseInt(r8.substring(3))};
    L15:
        return null;
    }

    public BaseStation buildBaseState(Object r8, final List<CellInfo> r10) {
        return buildBaseStation(r8, new AnonymousClass2(this, r10));
    }

    public BaseStation getBaseStation(final Object r8, final boolean r10, final RefreshBaseStationInfo r11) {
        return buildBaseStation(r8, new AnonymousClass1(this, r8, r10, r11));
    }

    public BaseStation getLightBaseStation(Object r11, boolean r12, boolean r13) {
        BaseStation r8 = new BaseStation();
        TelephonyManager r10 = this.mTelephonyManager;
        if (r10 == null) goto L33;
        int r14 = Integer.MAX_VALUE;
        int[] r15 = getMccMncPair(r10.getNetworkOperator());     // Catch: Exception -> L12
        if (r15 == null) goto L11;
        int r16 = r15[0];     // Catch: Exception -> L12
        r14 = r15[1];     // Catch: Exception -> L35
    L10:
        int r17 = r14;
        r14 = r16;
    L13:
        List<CellInfo> r18 = CellInfoUtil.getAllCellInfo(this.mContext, this.mTelephonyManager, r11, false, r12, null);
        if (r18 != null) goto L16;
        return null;
    L16:
        if (r18.isEmpty() == true) goto L52;
        Iterator<CellInfo> r19 = r18.iterator();
    L19:
        if (r19.hasNext() == false) goto L32;
        CellInfo r20 = r19.next();
        if (r20 == null) goto L19;
        if (r20.isRegistered() == true) goto L24;
        if (r13 == false) goto L19;
        if (r8.neighboring != null) goto L31;
        r8.neighboring = new ArrayList();
    L31:
        BssInfo r21 = new BssInfo();
        addCellInfo(r21, r20, r14, r17, r11);
        r8.neighboring.add(r21);
        goto L19
    L24:
        BssInfo r22 = new BssInfo();
        r8.current = r22;
        addCellInfo(r22, r20, r14, r17, r11);
        if (r13 == true) goto L19;
        return r8;
    L32:
        return r8;
    L52:
        return null;
    L11:
        r17 = Integer.MAX_VALUE;
    L12:
        r16 = Integer.MAX_VALUE;
        goto L10
    L33:
        return null;
    }

    private static int doCheckAndReturnBackup(String r8, int r10) {
        if (TextUtils.isEmpty(r8) == false) goto L8;
        return r10;
    L8:
        return Integer.parseInt(r8);
    L7:
        return r10;
    }
}
