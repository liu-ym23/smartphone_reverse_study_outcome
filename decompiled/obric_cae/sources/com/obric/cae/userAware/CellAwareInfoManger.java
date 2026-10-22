package com.obric.cae.userAware;

import android.annotation.SuppressLint;
import android.content.Context;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityNr;
import android.telephony.CellInfo;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoNr;
import android.telephony.CellSignalStrengthLte;
import android.telephony.CellSignalStrengthNr;
import android.telephony.TelephonyManager;
import com.obric.cae.libs.useraware.CellAwareInfo;
import com.obric.cae.log.CommSenseLog;
import com.obric.cae.userAware.utils.UserAwareUtil;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class CellAwareInfoManger {
    private static final String KEY_FILE_CELL_EVENTS = "cell_events";
    private static final long REMOVE_DUP_TIME_RANGE = 5000;
    private static final String TAG = "CellAwareInfoManger";

    @SuppressLint({"StaticFieldLeak"})
    private static Context mContext;
    private static CellAwareInfoMonitor mMonitor;

    @SuppressLint({"StaticFieldLeak"})
    private static volatile CellAwareInfoManger sInstance;
    private CellAwareInfo lastCellInfo;
    private List<CellAwareInfo> lastCellNeighborInfos;
    private File mCellEventsFile;
    private final TelephonyManager mTelephonyManager;

    private CellAwareInfoManger(Context r8) {
        this.lastCellNeighborInfos = new ArrayList();
        initCellEventsFile();
        this.mTelephonyManager = (TelephonyManager) r8.getSystemService("phone");
    }

    public static synchronized CellAwareInfoManger getInstance(Context r8) {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            java.lang.Class<com.obric.cae.userAware.CellAwareInfoManger> r0 = com.obric.cae.userAware.CellAwareInfoManger.class
            monitor-enter(r0)
            com.obric.cae.userAware.CellAwareInfoManger r1 = com.obric.cae.userAware.CellAwareInfoManger.sInstance     // Catch: java.lang.Throwable -> L24
            if (r1 != 0) goto L20
            java.lang.Class<com.obric.cae.userAware.CellAwareInfoManger> r1 = com.obric.cae.userAware.CellAwareInfoManger.class
            monitor-enter(r1)     // Catch: java.lang.Throwable -> L24
            com.obric.cae.userAware.CellAwareInfoManger r2 = com.obric.cae.userAware.CellAwareInfoManger.sInstance     // Catch: java.lang.Throwable -> L1d
            if (r2 != 0) goto L1b
            android.content.Context r3 = r3.getApplicationContext()     // Catch: java.lang.Throwable -> L1d
            com.obric.cae.userAware.CellAwareInfoManger.mContext = r3     // Catch: java.lang.Throwable -> L1d
            com.obric.cae.userAware.CellAwareInfoManger r2 = new com.obric.cae.userAware.CellAwareInfoManger     // Catch: java.lang.Throwable -> L1d
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L1d
            com.obric.cae.userAware.CellAwareInfoManger.sInstance = r2     // Catch: java.lang.Throwable -> L1d
        L1b:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L1d
            goto L20
        L1d:
            r3 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L1d
            throw r3     // Catch: java.lang.Throwable -> L24
        L20:
            com.obric.cae.userAware.CellAwareInfoManger r3 = com.obric.cae.userAware.CellAwareInfoManger.sInstance     // Catch: java.lang.Throwable -> L24
            monitor-exit(r0)
            return r3
        L24:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.obric.cae.userAware.CellAwareInfoManger.getInstance(android.content.Context):com.obric.cae.userAware.CellAwareInfoManger");
    }

    private void initCellEventsFile() {
        File r8 = new File(UserAwareUtil.getLocalDir(mContext, "cell"), "cell_events.log");
        r8.delete();
        r8.createNewFile();     // Catch: IOException -> L5
    L6:
        this.mCellEventsFile = r8;
        CommSenseLog.d(TAG, "initCellEventsFile, file: " + this.mCellEventsFile);
        CommSenseLog.recordFileWithKey("cell_events", this.mCellEventsFile);
        return;
    L5:
        CommSenseLog.e(TAG, "IO error occurred!");
        goto L6
    }

    private CellAwareInfo parseCellInfo(CellInfo r8) {
        CellAwareInfo r10 = parseCellInfoEx(r8, true);
        if (shouldSkipDuplicateInfo(r10, this.lastCellInfo) == false) goto L6;
        return null;
    L6:
        this.lastCellInfo = r10;
        return r10;
    }

    private CellAwareInfo parseCellInfoEx(CellInfo r8, boolean r10) {
        if (r8 != null) goto L6;
        return null;
    L6:
        if ((r8 instanceof CellInfoNr) == false) goto L10;
        CellInfoNr r11 = (CellInfoNr) r8;
        return parseCellInfoNr((CellIdentityNr) r11.getCellIdentity(), (CellSignalStrengthNr) r11.getCellSignalStrength(), r10);
    L10:
        if ((r8 instanceof CellInfoLte) == false) goto L13;
        CellInfoLte r12 = (CellInfoLte) r8;
        return parseCellInfoLte(r12.getCellIdentity(), r12.getCellSignalStrength(), r10);
    L13:
        return null;
    }

    private CellAwareInfo parseCellInfoLte(CellIdentityLte r8, CellSignalStrengthLte r10, boolean r11) {
        return new CellAwareInfo.Builder().timestamp(UserAwareUtil.formatDateToFullString(new Date(System.currentTimeMillis()))).standard("LTE").arfcn(r8.getEarfcn()).pci(r8.getPci()).tac(r8.getTac()).ci(r8.getCi()).bands(r8.getBands()).mcc(r8.getMccString()).mnc(r8.getMncString()).signalStrength(r10.getRsrp()).signalQuality(r10.getRsrq()).level(r10.getLevel()).registered(r11).build();
    }

    private CellAwareInfo parseCellInfoNr(CellIdentityNr r8, CellSignalStrengthNr r10, boolean r11) {
        return new CellAwareInfo.Builder().timestamp(UserAwareUtil.formatDateToFullString(new Date(System.currentTimeMillis()))).standard("NR").arfcn(r8.getNrarfcn()).pci(r8.getPci()).tac(r8.getTac()).ci(r8.getNci()).bands(r8.getBands()).mcc(r8.getMccString()).mnc(r8.getMncString()).signalStrength(r10.getSsRsrp()).signalQuality(r10.getSsRsrq()).level(r10.getLevel()).registered(r11).build();
    }

    private List<CellAwareInfo> parseCellNeighborInfo(List<CellInfo> r8) {
        ArrayList r10 = new ArrayList();
        Iterator<CellInfo> r11 = r8.iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        CellInfo r12 = r11.next();
        if (r12.isRegistered() == true) goto L4;
        r10.add(parseCellInfoEx(r12, false));
        goto L4
    L9:
        if (r10.isEmpty() == false) goto L12;
        return null;
    L12:
        if (this.lastCellNeighborInfos.isEmpty() == false) goto L14;
    L16:
        this.lastCellNeighborInfos = r10;
        return r10;
    L14:
        if (shouldSkipDuplicateInfos(this.lastCellNeighborInfos, r10) == false) goto L16;
        return null;
    }

    private boolean shouldSkipDuplicateInfo(CellAwareInfo r8, CellAwareInfo r10) {
        if (r8 == null) goto L11;
        if (r10 == null) goto L14;
        boolean r11 = UserAwareUtil.isTimeDiffLessThanMillis(UserAwareUtil.parseFullDateString(r8.getTimestamp()), UserAwareUtil.parseFullDateString(r10.getTimestamp()), 5000);
        boolean r12 = r8.compareTo(r10);
        if (r11 == false) goto L12;
        if (r12 == false) goto L13;
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

    private boolean shouldSkipDuplicateInfos(List<CellAwareInfo> r8, List<CellAwareInfo> r10) {
        if (r8 == null) goto L18;
        if (r10 == null) goto L18;
        if (r8.isEmpty() == true) goto L18;
        if (r8.size() == r10.size()) goto L11;
        return false;
    L11:
        int r11 = 0;
    L13:
        if (r11 >= r8.size()) goto L18;
        if (shouldSkipDuplicateInfo(r8.get(r11), r10.get(r11)) == false) goto L16;
        r11 = r11 + 1;
        goto L13
    L16:
        return false;
    L18:
        return true;
    }

    public CellAwareInfo getCurrentCellInfo() {
        this.lastCellInfo = null;
        TelephonyManager r8 = this.mTelephonyManager;     // Catch: SecurityException -> L15
        if (r8 == null) goto L14;
        List<CellInfo> r10 = r8.getAllCellInfo();     // Catch: SecurityException -> L15
        if (r10 == null) goto L14;
        Iterator<CellInfo> r11 = r10.iterator();     // Catch: SecurityException -> L15
    L9:
        if (r11.hasNext() == false) goto L14;
        CellInfo r12 = r11.next();     // Catch: SecurityException -> L15
        if (r12.isRegistered() == false) goto L9;
        handleCellInfoChange(r12);     // Catch: SecurityException -> L15
        return parseCellInfoEx(r12, true);
    L14:
        return null;
    L15:
        e = move-exception;
        CommSenseLog.e(TAG, "Missing required permissions", e);
        return null;
    }

    public List<CellAwareInfo> getCurrentCellNeighborInfo() {
        ArrayList r8 = new ArrayList();
        TelephonyManager r10 = this.mTelephonyManager;     // Catch: SecurityException -> L18
        if (r10 == null) goto L17;
        List<CellInfo> r11 = r10.getAllCellInfo();     // Catch: SecurityException -> L18
        if (r11 != null) goto L8;
        return null;
    L8:
        Iterator<CellInfo> r12 = r11.iterator();     // Catch: SecurityException -> L18
    L10:
        if (r12.hasNext() == false) goto L15;
        CellInfo r13 = r12.next();     // Catch: SecurityException -> L18
        if (r13.isRegistered() == true) goto L10;
        r8.add(parseCellInfoEx(r13, false));     // Catch: SecurityException -> L18
        goto L10
    L15:
        if (r8.isEmpty() == true) goto L17;
        handleCellNeighborInfoChange(r11);     // Catch: SecurityException -> L18
    L17:
        return r8;
    L18:
        e = move-exception;
        CommSenseLog.e(TAG, "Missing required permissions", e);
        return null;
    }

    public void handleCellInfoChange(CellInfo r8) {
        String r10 = TAG;
        CommSenseLog.d(r10, "handleCellInfoChange, info=" + r8);
        CellAwareInfo r11 = parseCellInfo(r8);
        if (r11 != null) goto L5;
        return;
    L5:
        CommSenseLog.dumpI(r10, r11.toString(), this.mCellEventsFile);
        UserAwareManager.getInstance().postHarLevel2Data(r11);
        CellAwareInfoMonitor r12 = mMonitor;
        if (r12 == null) goto L9;
        r12.onCellInfoChange(r11);
        return;
    }

    public void handleCellNeighborInfoChange(List<CellInfo> r8) {
        List<CellAwareInfo> r10 = parseCellNeighborInfo(r8);
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.isEmpty() == true) goto L18;
        Iterator<CellAwareInfo> r11 = r10.iterator();
    L9:
        if (r11.hasNext() == false) goto L11;
        CellAwareInfo r12 = r11.next();
        CommSenseLog.dumpI(TAG, r12.toString(), this.mCellEventsFile);
        UserAwareManager.getInstance().postHarLevel2Data(r12);
        goto L9
    L11:
        CellAwareInfoMonitor r13 = mMonitor;
        if (r13 == null) goto L17;
        r13.onCellNeighbourInfoChange(r10);
        return;
    L17:
        return;
    }

    public void registerMonitor(CellAwareInfoMonitor r8) {
        mMonitor = r8;
    }
}
