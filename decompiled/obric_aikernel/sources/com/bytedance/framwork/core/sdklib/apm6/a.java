package com.bytedance.framwork.core.sdklib.apm6;

import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static File f1892a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static File f1893b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static File f1894c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static File f1895d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static File f1896e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static File f1897f;

    public static synchronized File a() {
        monitor-enter(a.class);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (f1893b != null) goto L12;
        File r10 = new File(g(), "flush");     // Catch: Throwable -> L15
        if (r10.exists() == true) goto L9;
        r10.mkdirs();     // Catch: Throwable -> L15
    L9:
        f1893b = r10;     // Catch: Throwable -> L15
        if (j.f() == false) goto L12;
        j3.c.a("APM-SDK", "prepare FlushDirectory success. name=" + f1893b);     // Catch: Throwable -> L15
    L12:
        File r11 = f1893b;     // Catch: Throwable -> L15
        monitor-exit(a.class);
        return r11;
    }

    public static synchronized File b() {
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
            java.lang.Class<com.bytedance.framwork.core.sdklib.apm6.a> r0 = com.bytedance.framwork.core.sdklib.apm6.a.class
            monitor-enter(r0)
            java.io.File r1 = com.bytedance.framwork.core.sdklib.apm6.a.f1897f     // Catch: java.lang.Throwable -> L1e java.lang.Exception -> L20
            if (r1 != 0) goto L28
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L1e java.lang.Exception -> L20
            java.io.File r2 = g()     // Catch: java.lang.Throwable -> L1e java.lang.Exception -> L20
            java.lang.String r3 = "header"
            r1.<init>(r2, r3)     // Catch: java.lang.Throwable -> L1e java.lang.Exception -> L20
            boolean r2 = r1.exists()     // Catch: java.lang.Throwable -> L1e java.lang.Exception -> L20
            if (r2 != 0) goto L1b
            r1.mkdirs()     // Catch: java.lang.Throwable -> L1e java.lang.Exception -> L20
        L1b:
            com.bytedance.framwork.core.sdklib.apm6.a.f1897f = r1     // Catch: java.lang.Throwable -> L1e java.lang.Exception -> L20
            goto L28
        L1e:
            r1 = move-exception
            goto L2c
        L20:
            r1 = move-exception
            java.lang.String r2 = "APM-SDK"
            java.lang.String r3 = "header"
            j3.c.c(r2, r3, r1)     // Catch: java.lang.Throwable -> L1e
        L28:
            java.io.File r1 = com.bytedance.framwork.core.sdklib.apm6.a.f1897f     // Catch: java.lang.Throwable -> L1e
            monitor-exit(r0)
            return r1
        L2c:
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.framwork.core.sdklib.apm6.a.b():java.io.File");
    }

    public static File c() {
        return new File(g(), "file.lock");
    }

    public static synchronized File d() {
        monitor-enter(a.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (f1896e != null) goto L10;
        File r10 = new File(g(), "log");     // Catch: Throwable -> L13
        if (r10.exists() == true) goto L9;
        r10.mkdirs();     // Catch: Throwable -> L13
    L9:
        f1896e = r10;     // Catch: Throwable -> L13
    L10:
        File r11 = f1896e;     // Catch: Throwable -> L13
        monitor-exit(a.class);
        return r11;
    }

    public static synchronized File e() {
        monitor-enter(a.class);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (f1894c != null) goto L12;
        File r10 = new File(g(), "persistent");     // Catch: Throwable -> L15
        if (r10.exists() == true) goto L9;
        r10.mkdirs();     // Catch: Throwable -> L15
    L9:
        f1894c = r10;     // Catch: Throwable -> L15
        if (j.f() == false) goto L12;
        j3.c.a("APM-SDK", "prepare PersistentDirectory success. name=" + f1894c);     // Catch: Throwable -> L15
    L12:
        File r11 = f1894c;     // Catch: Throwable -> L15
        monitor-exit(a.class);
        return r11;
    }

    public static synchronized File f() {
        monitor-enter(a.class);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (f1892a == null) goto L21;
    L15:
        File r10 = f1892a;     // Catch: Throwable -> L18
        monitor-exit(a.class);
        return r10;
    L21:
        File r11 = new File(e(), ya.a.a(j.c()).replace(".", "_").replace(":", "-") + ".bin");     // Catch: Exception -> L13 Throwable -> L18
        if (r11.exists() == true) goto L9;
        r11.createNewFile();     // Catch: Exception -> L13 Throwable -> L18
    L9:
        f1892a = r11;     // Catch: Exception -> L13 Throwable -> L18
        if (j.f() == false) goto L15;
        j3.c.a("APM-SDK", "prepare PersistentFile success. fileName=" + f1892a);     // Catch: Exception -> L13 Throwable -> L18
    L13:
        e = move-exception;
        j3.c.c("APM-SDK", "prepare PersistentFile fail.", e);     // Catch: Throwable -> L18
        goto L15
    }

    public static synchronized File g() {
        monitor-enter(a.class);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (f1895d != null) goto L9;
        File r10 = new File(j.c().getFilesDir(), "apm6_sdk");     // Catch: Throwable -> L12
        f1895d = r10;     // Catch: Throwable -> L12
        if (r10.exists() == true) goto L9;
        f1895d.mkdirs();     // Catch: Throwable -> L12
    L9:
        File r11 = f1895d;     // Catch: Throwable -> L12
        monitor-exit(a.class);
        return r11;
    }
}
