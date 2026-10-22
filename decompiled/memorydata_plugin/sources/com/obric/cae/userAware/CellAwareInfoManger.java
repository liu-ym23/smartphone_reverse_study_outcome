package com.obric.cae.userAware;

import android.content.Context;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityNr;
import android.telephony.CellInfo;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoNr;
import android.telephony.CellSignalStrengthLte;
import android.telephony.CellSignalStrengthNr;
import android.telephony.TelephonyManager;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.obric.cae.libs.useraware.CellAwareInfo;
import com.obric.cae.log.a;
import com.obric.cae.userAware.utils.UserAwareUtil;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class CellAwareInfoManger {
    private static final String KEY_FILE_CELL_EVENTS = "cell_events";
    private static final long REMOVE_DUP_TIME_RANGE = 5000;
    private static final String TAG = "CellAwareInfoManger";
    private static Context mContext;
    private static CellAwareInfoMonitor mMonitor;
    private static volatile CellAwareInfoManger sInstance;
    private CellAwareInfo lastCellInfo;
    private List<CellAwareInfo> lastCellNeighborInfos;
    private File mCellEventsFile;
    private final TelephonyManager mTelephonyManager;

    private CellAwareInfoManger(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        this.lastCellNeighborInfos = new ArrayList();
        initCellEventsFile();
        this.mTelephonyManager = (TelephonyManager) ZeusTransformUtils.preCheckCast(r4.getSystemService(MemoryKeyInfoEntity.KEY_PHONE), TelephonyManager.class, "com.obric.memorydata.plugin");
    }

    public static synchronized CellAwareInfoManger getInstance(Context r3) {
        monitor-enter(CellAwareInfoManger.class);
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        if (sInstance != null) goto L15;
        monitor-enter(CellAwareInfoManger.class);     // Catch: Throwable -> L18
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L8:
        if (sInstance != null) goto L10;
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        mContext = r5;     // Catch: Throwable -> L12
        sInstance = new CellAwareInfoManger(r5);     // Catch: Throwable -> L12
    L10:
        monitor-exit(CellAwareInfoManger.class);     // Catch: Throwable -> L12
    L15:
        CellAwareInfoManger r6 = sInstance;     // Catch: Throwable -> L18
        monitor-exit(CellAwareInfoManger.class);
        return r6;
    L18:
        th = move-exception;
        throw th;
    }

    private void initCellEventsFile() {
        File r0 = new File(UserAwareUtil.getLocalDir(mContext, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL), "cell_events.log");
        r0.delete();
        r0.createNewFile();     // Catch: IOException -> L5
    L6:
        this.mCellEventsFile = r0;
        a.c(TAG, "initCellEventsFile, file: " + this.mCellEventsFile);
        a.a(KEY_FILE_CELL_EVENTS, this.mCellEventsFile);
        return;
    L5:
        a.i(TAG, "IO error occurred!");
        goto L6
    }

    private CellAwareInfo parseCellInfo(CellInfo r2) {
        CellAwareInfo r3 = parseCellInfoEx(r2, true);
        if (shouldSkipDuplicateInfo(r3, this.lastCellInfo) == false) goto L6;
        return null;
    L6:
        this.lastCellInfo = r3;
        return r3;
    }

    private CellAwareInfo parseCellInfoEx(CellInfo r4, boolean r5) {
        if (r4 != null) goto L6;
        return null;
    L6:
        if (ZeusTransformUtils.instanceOf(r4, CellInfoNr.class) == false) goto L10;
        CellInfoNr r6 = (CellInfoNr) ZeusTransformUtils.preCheckCast(r4, CellInfoNr.class, "com.obric.memorydata.plugin");
        return parseCellInfoNr((CellIdentityNr) ZeusTransformUtils.preCheckCast(r6.getCellIdentity(), CellIdentityNr.class, "com.obric.memorydata.plugin"), (CellSignalStrengthNr) ZeusTransformUtils.preCheckCast(r6.getCellSignalStrength(), CellSignalStrengthNr.class, "com.obric.memorydata.plugin"), r5);
    L10:
        if (ZeusTransformUtils.instanceOf(r4, CellInfoLte.class) == false) goto L13;
        CellInfoLte r7 = (CellInfoLte) ZeusTransformUtils.preCheckCast(r4, CellInfoLte.class, "com.obric.memorydata.plugin");
        return parseCellInfoLte(r7.getCellIdentity(), r7.getCellSignalStrength(), r5);
    L13:
        return null;
    }

    private CellAwareInfo parseCellInfoLte(CellIdentityLte r4, CellSignalStrengthLte r5, boolean r6) {
        return new CellAwareInfo.a().a(UserAwareUtil.formatDateToFullString(new Date(System.currentTimeMillis()))).b("LTE").a(r4.getEarfcn()).b(r4.getPci()).c(r4.getTac()).a(r4.getCi()).a(r4.getBands()).c(r4.getMccString()).d(r4.getMncString()).d(r5.getRsrp()).e(r5.getRsrq()).f(r5.getLevel()).a(r6).a();
    }

    private CellAwareInfo parseCellInfoNr(CellIdentityNr r4, CellSignalStrengthNr r5, boolean r6) {
        return new CellAwareInfo.a().a(UserAwareUtil.formatDateToFullString(new Date(System.currentTimeMillis()))).b("NR").a(r4.getNrarfcn()).b(r4.getPci()).c(r4.getTac()).a(r4.getNci()).a(r4.getBands()).c(r4.getMccString()).d(r4.getMncString()).d(r5.getSsRsrp()).e(r5.getSsRsrq()).f(r5.getLevel()).a(r6).a();
    }

    private List<CellAwareInfo> parseCellNeighborInfo(List<CellInfo> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        ArrayList r0 = new ArrayList();
        Iterator r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L9;
        CellInfo r2 = (CellInfo) ZeusTransformUtils.preCheckCast(r7.next(), CellInfo.class, "com.obric.memorydata.plugin");
        if (r2.isRegistered() == true) goto L4;
        r0.add(parseCellInfoEx(r2, false));
        goto L4
    L9:
        if (r0.isEmpty() == false) goto L12;
        return null;
    L12:
        if (this.lastCellNeighborInfos.isEmpty() == false) goto L14;
    L16:
        this.lastCellNeighborInfos = r0;
        return r0;
    L14:
        if (shouldSkipDuplicateInfos(this.lastCellNeighborInfos, r0) == false) goto L16;
        return null;
    }

    private boolean shouldSkipDuplicateInfo(CellAwareInfo r5, CellAwareInfo r6) {
        if (r5 == null) goto L11;
        if (r6 == null) goto L14;
        boolean r0 = UserAwareUtil.isTimeDiffLessThanMillis(UserAwareUtil.parseFullDateString(r5.getTimestamp()), UserAwareUtil.parseFullDateString(r6.getTimestamp()), 5000);
        boolean r7 = r5.compareTo(r6);
        if (r0 == false) goto L12;
        if (r7 == false) goto L13;
        return true;
    L13:
        return false;
    L12:
        return false;
    L14:
        return false;
    L11:
        return false;
    }

    private boolean shouldSkipDuplicateInfos(List<CellAwareInfo> r8, List<CellAwareInfo> r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L18;
        if (r11 == null) goto L18;
        if (r10.isEmpty() == true) goto L18;
        if (r10.size() == r11.size()) goto L11;
        return false;
    L11:
        int r2 = 0;
    L13:
        if (r2 >= r10.size()) goto L18;
        if (shouldSkipDuplicateInfo((CellAwareInfo) ZeusTransformUtils.preCheckCast(r10.get(r2), CellAwareInfo.class, "com.obric.memorydata.plugin"), (CellAwareInfo) ZeusTransformUtils.preCheckCast(r11.get(r2), CellAwareInfo.class, "com.obric.memorydata.plugin")) == false) goto L16;
        r2 = r2 + 1;
        goto L13
    L16:
        return false;
    L18:
        return true;
    }

    public CellAwareInfo getCurrentCellInfo() {
        this.lastCellInfo = null;
        TelephonyManager r1 = this.mTelephonyManager;     // Catch: SecurityException -> L15
        if (r1 == null) goto L14;
        List<CellInfo> r2 = r1.getAllCellInfo();     // Catch: SecurityException -> L15
        if (r2 == null) goto L14;
        Iterator<CellInfo> r3 = r2.iterator();     // Catch: SecurityException -> L15
    L9:
        if (r3.hasNext() == false) goto L14;
        CellInfo r4 = (CellInfo) ZeusTransformUtils.preCheckCast(r3.next(), CellInfo.class, "com.obric.memorydata.plugin");     // Catch: SecurityException -> L15
        if (r4.isRegistered() == false) goto L9;
        handleCellInfoChange(r4);     // Catch: SecurityException -> L15
        return parseCellInfoEx(r4, true);
    L14:
        return null;
    L15:
        e = move-exception;
        a.a(TAG, "Missing required permissions", e);
        return null;
    }

    public List<CellAwareInfo> getCurrentCellNeighborInfo() {
        ArrayList r0 = new ArrayList();
        TelephonyManager r2 = this.mTelephonyManager;     // Catch: SecurityException -> L18
        if (r2 == null) goto L17;
        List<CellInfo> r3 = r2.getAllCellInfo();     // Catch: SecurityException -> L18
        if (r3 != null) goto L8;
        return null;
    L8:
        Iterator<CellInfo> r4 = r3.iterator();     // Catch: SecurityException -> L18
    L10:
        if (r4.hasNext() == false) goto L15;
        CellInfo r5 = (CellInfo) ZeusTransformUtils.preCheckCast(r4.next(), CellInfo.class, "com.obric.memorydata.plugin");     // Catch: SecurityException -> L18
        if (r5.isRegistered() == true) goto L10;
        r0.add(parseCellInfoEx(r5, false));     // Catch: SecurityException -> L18
        goto L10
    L15:
        if (r0.isEmpty() == true) goto L17;
        handleCellNeighborInfoChange(r3);     // Catch: SecurityException -> L18
    L17:
        return r0;
    L18:
        e = move-exception;
        a.a(TAG, "Missing required permissions", e);
        return null;
    }

    public void handleCellInfoChange(CellInfo r4) {
        String r0 = TAG;
        a.c(r0, "handleCellInfoChange, info=" + r4);
        CellAwareInfo r5 = parseCellInfo(r4);
        if (r5 != null) goto L6;
        return;
    L6:
        if (SceneCollectionSessionContext.getInstance().shouldUseRawOutput() == false) goto L8;
        String r1 = r5.toUnmaskedString();
    L9:
        a.c(r0, r1, this.mCellEventsFile);
        UserAwareManager.getInstance().postHarLevel2Data(r5);
        CellAwareInfoMonitor r3 = mMonitor;
        if (r3 == null) goto L13;
        r3.onCellInfoChange(r5);
        return;
    L13:
        return;
    L8:
        r1 = r5.toString();
        goto L9
    }

    public void handleCellNeighborInfoChange(List<CellInfo> r7) {
        List<CellAwareInfo> r8 = parseCellNeighborInfo((List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin"));
        if (r8 != null) goto L5;
        return;
    L5:
        if (r8.isEmpty() == true) goto L24;
        Iterator<CellAwareInfo> r0 = r8.iterator();
    L9:
        if (r0.hasNext() == false) goto L15;
        CellAwareInfo r2 = (CellAwareInfo) ZeusTransformUtils.preCheckCast(r0.next(), CellAwareInfo.class, "com.obric.memorydata.plugin");
        String r3 = TAG;
        if (SceneCollectionSessionContext.getInstance().shouldUseRawOutput() == false) goto L13;
        String r4 = r2.toUnmaskedString();
    L14:
        a.c(r3, r4, this.mCellEventsFile);
        UserAwareManager.getInstance().postHarLevel2Data(r2);
        goto L9
    L13:
        r4 = r2.toString();
        goto L14
    L15:
        CellAwareInfoMonitor r6 = mMonitor;
        if (r6 == null) goto L23;
        r6.onCellNeighbourInfoChange(r8);
        return;
    L23:
        return;
    }

    public void registerMonitor(CellAwareInfoMonitor r2) {
        mMonitor = (CellAwareInfoMonitor) ZeusTransformUtils.wrapperContextForParams(r2, CellAwareInfoMonitor.class, "com.obric.memorydata.plugin");
    }
}
