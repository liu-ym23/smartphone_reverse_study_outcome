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
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
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

    JavaCrashHandler(CrashDumper r3) {
        this.mLatch = new AtomicBoolean(false);
        this.mCrashDumper = r3;
        this.mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    private static void afterIgnore(Throwable r4, Thread r5) {
        int r0 = 0;
    L3:
        ArrayList<CrashIgnoreHandler> r1 = sCrashIgnoreHandlers;
        if (r0 >= r1.size()) goto L17;
        ((CrashIgnoreHandler) ZeusTransformUtils.preCheckCast(r1.get(r0), CrashIgnoreHandler.class, "com.obric.memorydata.plugin")).afterIgnore(r4, r5);     // Catch: Throwable -> L9
    L7:
        r0 = r0 + 1;
    L8:
        return;
    }

    private void handleCallbacks(Thread r14, Throwable r15, File r16, CrashType r17, long r18, boolean r20) {
        String r10 = ThrowableDumper.load(r16);
        boolean r11 = isJavaOom(r15);
        Iterator<CrashListener> r12 = MonitorManager.getCrashListenerList().iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        handleMonitorCallbacks((CrashListener) ZeusTransformUtils.preCheckCast(r12.next(), CrashListener.class, "com.obric.memorydata.plugin"), r20, r11, r17, r15, r14, r10, r18);
        goto L4
    }

    private boolean handleException(Thread r18, Throwable r19) {
        boolean r10 = true;
        Global.setHasCrashBefore(true);
        AppMonitor r1 = MonitorManager.getAppMonitor();
        if (r1 != null) goto L5;
    L11:
        long r12 = System.currentTimeMillis();
        File r14 = this.mCrashDumper.getDirectory();
        FileSystemUtils.createDirectory(r14);
        boolean r6 = isLaunchCrash(r12);
        if (r6 == false) goto L14;
        CrashType r2 = CrashType.LAUNCH;
    L15:
        CrashType r15 = r2;
        boolean r16 = isOutOfMemory(r19);
        if (sIsDropData == true) goto L19;
        JavaCrashSummary.dump(r14, r18, r19, r12, r6, r16);
        ThrowableDumper.dump(r14, r19);
        NpthLog.e("NPTH", r19 + " has been detected!");
        NpthLog.e("NPTH", "handleException：" + r14);
        this.mCrashDumper.dumpAppVersion();
        handlePreCallbacks(r15, r12);
        this.mCrashDumper.dumpCrashInfoFromJava(r15, r12, isDumpViewTree, isDumpHistoryMessage);
    L19:
        if ((ignoreTag(r19, r18) & 1) != 0) goto L22;
        r10 = false;
    L22:
        if (r10 == true) goto L27;
    L24:
        handleCallbacks(r18, r19, r14, r15, r12, r16);
        return r10;
    L27:
        new File(r14, "ignore").createNewFile();     // Catch: Throwable -> L26
        goto L24
    L14:
        r2 = CrashType.JAVA;
        goto L15
    L5:
        if (r1.getUserDataCenter().isIgnored(r18, r19) == false) goto L11;
        if ((ignoreTag(r19, r18) & 1) == 0) goto L10;
        return true;
    L10:
        return false;
    }

    private void handleMonitorCallbacks(CrashListener r7, boolean r8, boolean r9, CrashType r10, Throwable r11, Thread r12, String r13, long r14) {
        if (r7 != null) goto L4;
        return;
    L4:
        UserDataCenter r6 = r7.getUserDataCenter();
        List<IOOMCallback> r15 = null;
        if (r8 == true) goto L7;
        if (r9 == true) goto L7;
    L9:
        if (r15 == null) goto L16;
        Iterator<IOOMCallback> r16 = r15.iterator();
    L12:
        if (r16.hasNext() == false) goto L16;
        ((IOOMCallback) ZeusTransformUtils.preCheckCast(r16.next(), IOOMCallback.class, "com.obric.memorydata.plugin")).onCrash(r10, r11, r12, r14);     // Catch: Throwable -> L25
    L16:
        List<ICrashCallback> r17 = r6.getCrashCallback(r10);
        if (r17 == null) goto L24;
        Iterator<ICrashCallback> r18 = r17.iterator();
    L20:
        if (r18.hasNext() == false) goto L37;
        ((ICrashCallback) ZeusTransformUtils.preCheckCast(r18.next(), ICrashCallback.class, "com.obric.memorydata.plugin")).onCrash(r10, r13, r12);     // Catch: Throwable -> L26
        goto L20
    L37:
        return;
    L24:
        return;
    L7:
        r15 = r6.getOOMCallback();
        goto L9
    }

    private void handlePreCallbacks(CrashType r4, long r5) {
        AppMonitor r3 = MonitorManager.getAppMonitor();     // Catch: Throwable -> L13
        if (r3 != null) goto L5;
        return;
    L5:
        Iterator<IPreCrashCallback> r6 = r3.getUserDataCenter().getPreCrashCallback(r4).iterator();     // Catch: Throwable -> L13
    L7:
        if (r6.hasNext() == false) goto L21;
        ((IPreCrashCallback) ZeusTransformUtils.preCheckCast(r6.next(), IPreCrashCallback.class, "com.obric.memorydata.plugin")).onCrash(r4, r5);     // Catch: Throwable -> L12
        goto L7
    L21:
        return;
    }

    private static int ignoreTag(Throwable r5, Thread r6) {
        int r0 = 0;
        int r1 = 0;
    L3:
        ArrayList<CrashIgnoreHandler> r2 = sCrashIgnoreHandlers;
        if (r0 >= r2.size()) goto L9;
        r1 = r1 | ((CrashIgnoreHandler) ZeusTransformUtils.preCheckCast(r2.get(r0), CrashIgnoreHandler.class, "com.obric.memorydata.plugin")).shouldIgnore(r5, r6);
    L8:
        r0 = r0 + 1;
    L9:
        return r1;
    }

    private static boolean isJavaOom(Throwable r2) {
    L2:
        if (r2 == null) goto L27;
        if (ZeusTransformUtils.instanceOf(r2, OutOfMemoryError.class) == false) goto L13;
        String r0 = r2.getMessage();     // Catch: Throwable -> L17
        if (r0 == null) goto L13;
        if (r0.contains("allocate") == true) goto L11;
        if (r0.contains("thrown") == false) goto L13;
        return true;
    L11:
        return true;
    L13:
        r2 = r2.getCause();     // Catch: Throwable -> L17
    L15:
        return false;
    L27:
        return false;
    }

    public static boolean isLaunchCrash(long r2) {
        if ((r2 - Global.getAppStartTime()) <= RuntimeConfig.getLaunchCrashInterval()) goto L5;
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

    public static boolean isOutOfMemory(Throwable r2) {
        int r0 = 20;
    L3:
        if (r2 == null) goto L20;
        int r1 = r0 - 1;
        if (r0 <= 0) goto L21;
        if (ZeusTransformUtils.instanceOf(r2, OutOfMemoryError.class) == true) goto L8;
        r2 = r2.getCause();     // Catch: Throwable -> L14
        r0 = r1;
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

    public static void setDropData(boolean r0) {
        sIsDropData = r0;
    }

    public static void setDumpHistoryMessageEnable(boolean r0) {
        isDumpHistoryMessage = r0;
    }

    public static void setDumpViewTreeEnable(boolean r0) {
        isDumpViewTree = r0;
    }

    public static void setHprofEnable(boolean r0) {
        isHprofEnable = r0;
    }

    public static void setIgnoreHandler(CrashIgnoreHandler r1) {
        sCrashIgnoreHandlers.add(r1);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread r4, Throwable r5) {
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
