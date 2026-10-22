package com.bytedance.crash.crash;

import com.bytedance.crash.CrashType;
import com.bytedance.crash.Global;
import com.bytedance.crash.ICrashCallback;
import com.bytedance.crash.IOOMCallback;
import com.bytedance.crash.IPreCrashCallback;
import com.bytedance.crash.NpthCore;
import com.bytedance.crash.UserDataCenter;
import com.bytedance.crash.config.RuntimeConfig;
import com.bytedance.crash.dumper.tools.ThrowableDumper;
import com.bytedance.crash.java.CrashIgnoreHandler;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.CrashListener;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.NpthLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public class JavaCrashHandler implements Thread.UncaughtExceptionHandler {
    private static volatile boolean isDumpHistoryMessage;
    private static volatile boolean isDumpViewTree;
    private static volatile boolean isHprofEnable;
    private static final ArrayList<CrashIgnoreHandler> sCrashIgnoreHandlers = null;
    private static boolean sIsDropData;
    private JSONArray mAllData;
    private final CrashDumper mCrashDumper;
    private final Thread.UncaughtExceptionHandler mDefaultHandler;
    private final AtomicBoolean mLatch;

    static {
        sCrashIgnoreHandlers = new ArrayList();
    }

    JavaCrashHandler(CrashDumper r10) {
        this.mLatch = new AtomicBoolean(false);
        this.mCrashDumper = r10;
        this.mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    private static void afterIgnore(Throwable r10, Thread r11) {
        int r12 = 0;
    L3:
        ArrayList<CrashIgnoreHandler> r13 = sCrashIgnoreHandlers;
        if (r12 >= r13.size()) goto L17;
        r13.get(r12).afterIgnore(r10, r11);     // Catch: Throwable -> L9
    L7:
        r12 = r12 + 1;
    L8:
        return;
    }

    private void handleCallbacks(Thread r14, Throwable r15, File r16, CrashType r17, long r18, boolean r20) {
        String r10 = ThrowableDumper.load(r16);
        boolean r11 = isJavaOom(r15);
        Iterator<CrashListener> r12 = MonitorManager.getCrashListenerList().iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        handleMonitorCallbacks(r12.next(), r20, r11, r17, r15, r14, r10, r18);
        goto L4
    }

    private boolean handleException(Thread r18, Throwable r19) {
        boolean r10 = true;
        Global.setHasCrashBefore(true);
        AppMonitor r11 = MonitorManager.getAppMonitor();
        if (r11 != null) goto L5;
    L11:
        long r12 = System.currentTimeMillis();
        File r14 = this.mCrashDumper.getDirectory();
        FileSystemUtils.createDirectory(r14);
        boolean r13 = isLaunchCrash(r12);
        if (r13 == false) goto L14;
        CrashType r15 = CrashType.LAUNCH;
    L15:
        CrashType r16 = r15;
        boolean r17 = isOutOfMemory(r19);
        if (sIsDropData == true) goto L19;
        JavaCrashSummary.dump(r14, r18, r19, r12, r13, r17);
        ThrowableDumper.dump(r14, r19);
        NpthLog.e("NPTH", r19 + " has been detected!");
        NpthLog.e("NPTH", "handleException：" + r14);
        this.mCrashDumper.dumpAppVersion();
        handlePreCallbacks(r16, r12);
        this.mCrashDumper.dumpCrashInfoFromJava(r16, r12, isDumpViewTree, isDumpHistoryMessage);
    L19:
        if ((ignoreTag(r19, r18) & 1) != 0) goto L22;
        r10 = false;
    L22:
        if (r10 == true) goto L27;
    L24:
        handleCallbacks(r18, r19, r14, r16, r12, r17);
        return r10;
    L27:
        new File(r14, "ignore").createNewFile();     // Catch: Throwable -> L26
        goto L24
    L14:
        r15 = CrashType.JAVA;
        goto L15
    L5:
        if (r11.getUserDataCenter().isIgnored(r18, r19) == false) goto L11;
        if ((ignoreTag(r19, r18) & 1) == 0) goto L10;
        return true;
    L10:
        return false;
    }

    private void handleMonitorCallbacks(CrashListener r10, boolean r11, boolean r12, CrashType r13, Throwable r14, Thread r15, String r16, long r17) {
        if (r10 != null) goto L4;
        return;
    L4:
        UserDataCenter r18 = r10.getUserDataCenter();
        List<IOOMCallback> r19 = null;
        if (r11 == true) goto L7;
        if (r12 == true) goto L7;
    L8:
        if (r19 == null) goto L15;
        Iterator<IOOMCallback> r20 = r19.iterator();
    L11:
        if (r20.hasNext() == false) goto L15;
        r20.next().onCrash(r13, r14, r15, r17);     // Catch: Throwable -> L24
    L15:
        List<ICrashCallback> r21 = r18.getCrashCallback(r13);
        if (r21 == null) goto L23;
        Iterator<ICrashCallback> r22 = r21.iterator();
    L19:
        if (r22.hasNext() == false) goto L36;
        r22.next().onCrash(r13, r16, r15);     // Catch: Throwable -> L25
        goto L19
    L36:
        return;
    L23:
        return;
    L7:
        r19 = r18.getOOMCallback();
        goto L8
    }

    private void handlePreCallbacks(CrashType r10, long r11) {
        AppMonitor r12 = MonitorManager.getAppMonitor();     // Catch: Throwable -> L13
        if (r12 != null) goto L5;
        return;
    L5:
        Iterator<IPreCrashCallback> r13 = r12.getUserDataCenter().getPreCrashCallback(r10).iterator();     // Catch: Throwable -> L13
    L7:
        if (r13.hasNext() == false) goto L21;
        r13.next().onCrash(r10, r11);     // Catch: Throwable -> L12
        goto L7
    L21:
        return;
    }

    private static int ignoreTag(Throwable r10, Thread r11) {
        int r12 = 0;
        int r13 = 0;
    L3:
        ArrayList<CrashIgnoreHandler> r14 = sCrashIgnoreHandlers;
        if (r12 >= r14.size()) goto L9;
        r13 = r13 | r14.get(r12).shouldIgnore(r10, r11);
    L8:
        r12 = r12 + 1;
    L9:
        return r13;
    }

    private static boolean isJavaOom(Throwable r10) {
    L2:
        if (r10 == null) goto L27;
        if ((r10 instanceof OutOfMemoryError) == false) goto L13;
        String r11 = r10.getMessage();     // Catch: Throwable -> L17
        if (r11 == null) goto L13;
        if (r11.contains("allocate") == true) goto L11;
        if (r11.contains("thrown") == false) goto L13;
        return true;
    L11:
        return true;
    L13:
        r10 = r10.getCause();     // Catch: Throwable -> L17
    L15:
        return false;
    L27:
        return false;
    }

    public static boolean isLaunchCrash(long r10) {
        if ((r10 - Global.getAppStartTime()) <= RuntimeConfig.getLaunchCrashInterval()) goto L5;
    L9:
        return false;
    L5:
        if (NpthCore.isCurrentMiniAppProcess() == true) goto L7;
    L8:
        return true;
    L7:
        if (NpthCore.getMiniAppId() == 0) goto L9;
        goto L8
    }

    public static boolean isOutOfMemory(Throwable r10) {
        int r11 = 20;
    L3:
        if (r10 == null) goto L20;
        int r12 = r11 - 1;
        if (r11 <= 0) goto L21;
        if ((r10 instanceof OutOfMemoryError) == true) goto L8;
        r10 = r10.getCause();     // Catch: Throwable -> L14
        r11 = r12;
        goto L3
    L8:
        return true;
    L12:
        return false;
    L21:
        return false;
    L20:
        return false;
    }

    public static void setDropData(boolean r10) {
        sIsDropData = r10;
    }

    public static void setDumpHistoryMessageEnable(boolean r10) {
        isDumpHistoryMessage = r10;
    }

    public static void setDumpViewTreeEnable(boolean r10) {
        isDumpViewTree = r10;
    }

    public static void setHprofEnable(boolean r10) {
        isHprofEnable = r10;
    }

    public static void setIgnoreHandler(CrashIgnoreHandler r10) {
        sCrashIgnoreHandlers.add(r10);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread r10, Throwable r11) {
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
            this = this;
            monitor-enter(r3)
            r0 = 0
            java.util.concurrent.atomic.AtomicBoolean r1 = r3.mLatch     // Catch: java.lang.Throwable -> L10
            r2 = 1
            boolean r1 = r1.compareAndSet(r0, r2)     // Catch: java.lang.Throwable -> L10
            if (r1 == 0) goto L14
            boolean r0 = r3.handleException(r4, r5)     // Catch: java.lang.Throwable -> L10
            goto L14
        L10:
            r1 = move-exception
            com.bytedance.crash.util.NpthLog.i(r1)     // Catch: java.lang.Throwable -> L21
        L14:
            if (r0 != 0) goto L1c
            java.lang.Thread$UncaughtExceptionHandler r0 = r3.mDefaultHandler     // Catch: java.lang.Throwable -> L21
            r0.uncaughtException(r4, r5)     // Catch: java.lang.Throwable -> L21
            goto L1f
        L1c:
            afterIgnore(r5, r4)     // Catch: java.lang.Throwable -> L21
        L1f:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L21
            return
        L21:
            r4 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L21
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.crash.crash.JavaCrashHandler.uncaughtException(java.lang.Thread, java.lang.Throwable):void");
    }
}
