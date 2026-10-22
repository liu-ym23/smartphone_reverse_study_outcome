package com.larksuite.framework.thread;

import com.ss.android.lark.log.Log;
import java.lang.reflect.Field;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class m {
    public static volatile Field a;
    public static volatile Field b;

    public m() {
    }

    public static Object b(Object r3) {
    L16:
        e = move-exception;
        e.printStackTrace();
        return null;
    L3:
        if (a != null) goto L15;
        monitor-enter(m.class);     // Catch: Exception -> L16
    L11:
        th = move-exception;
        throw th;     // Catch: Exception -> L16
    L7:
        if (a != null) goto L9;
        a = r3.getClass().getDeclaredField("callable");     // Catch: Throwable -> L11
        a.setAccessible(true);     // Catch: Throwable -> L11
    L9:
        monitor-exit(m.class);     // Catch: Throwable -> L11
    L15:
        return a.get(r3);
    }

    public static String c(Object r6) {
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
            Method dump skipped, instruction units count: 239
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.larksuite.framework.thread.m.c(java.lang.Object):java.lang.String");
    }

    public static void a(long r13, long r15, String r17, t r19) {
        if (r19 == null) goto L5;
        String r1 = r19.d();
    L6:
        boolean r6 = false;
        long r8 = 0;
        if (r19 != null) goto L9;
        long r10 = 5000;
        if (5000 >= r15) goto L25;
    L24:
        r6 = true;
    L25:
        if (r6 == false) goto L32;
        Log.w("TaskMonitor", r1 + ", taskname: " + r17 + ", dispatchtime & runtime is(ms) " + r13 + ", " + r15 + "maxQueueWaitTime & MaxRunTime is " + r8 + ", " + r10);
        if (CoreThreadPool.needMonitorTask() == false) goto L33;
        l.a(r17, r1, r13, r15, r8, r10);
        CoreThreadPool.a r0 = CoreThreadPool.mCoreThreadPoolDep;
        if (r0 == null) goto L34;
        r0.b();
        return;
    L34:
        return;
    L33:
        return;
    L32:
        return;
    L9:
        if ((r19 instanceof b) == false) goto L17;
        b r2 = (b) r19;
        r8 = r2.h;
        if (r8 >= r13) goto L13;
        r6 = true;
    L13:
        r10 = r2.i;
        if (r10 >= r15) goto L25;
    L17:
        if ((r19 instanceof g) == false) goto L21;
        r10 = ((g) r19).b;
        if (r10 >= r15) goto L25;
    L21:
        r10 = 0;
        goto L25
    L5:
        r1 = "NonCoreThreadPool";
        goto L6
    }
}
