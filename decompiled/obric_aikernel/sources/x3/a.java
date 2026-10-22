package x3;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Class f13497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Field f13498b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Object f13499c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Object f13500d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Set<Integer> f13501e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Class f13502f;

    /* JADX INFO: renamed from: x3.a$a, reason: collision with other inner class name */
    static class RunnableC0315a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Object f13503c;

        RunnableC0315a(Object r10) {
            this.f13503c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.a(f.h(a.b(), "currentActivityThread", new Object[0]));     // Catch: Throwable -> L11 Exception -> L20
            Object r10 = this.f13503c;
            monitor-enter(r10);
            this.f13503c.notify();     // Catch: Throwable -> L8
            monitor-exit(r10);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        L11:
            th = move-exception;
            monitor-enter(this.f13503c);
            this.f13503c.notify();     // Catch: Throwable -> L17
            throw th;
        L17:
            th = move-exception;
            throw th;
        L21:
            monitor-enter(this.f13503c);
            this.f13503c.notify();     // Catch: Throwable -> L25
            return;
        L25:
            th = move-exception;
            throw th;
        }
    }

    static {
        HashSet r10 = new HashSet();
        f13501e = r10;
        r10.add(113);
        f13501e.add(114);
        f13501e.add(115);
        f13501e.add(116);
        f13501e.add(121);
        f13501e.add(122);
        f13501e.add(100);
        f13501e.add(159);
        f13501e.add(123);
    }

    public a() {
    }

    static /* synthetic */ Object a(Object r10) {
        f13499c = r10;
        return r10;
    }

    static /* synthetic */ Class b() {
        return f13502f;
    }

    public static Object c() {
        if (f13499c != null) goto L36;
        monitor-enter(a.class);     // Catch: Exception -> L33
    L30:
        th = move-exception;
        throw th;     // Catch: Exception -> L33
    L7:
        if (f13499c != null) goto L13;
        if (f13502f != null) goto L11;
        f13502f = Class.forName("android.app.ActivityThread");     // Catch: Throwable -> L30
    L11:
        f13499c = f.h(f13502f, "currentActivityThread", new Object[0]);     // Catch: Throwable -> L30
    L13:
        if (f13499c == null) goto L15;
    L28:
        monitor-exit(a.class);     // Catch: Throwable -> L30
        goto L36
    L15:
        if (Looper.myLooper() == Looper.getMainLooper()) goto L28;
        Object r10 = new Object();     // Catch: Throwable -> L30
        new Handler(Looper.getMainLooper()).post(new RunnableC0315a(r10));     // Catch: Throwable -> L30
        if (f13499c != null) goto L28;
        monitor-enter(r10);     // Catch: Throwable -> L30
        r10.wait(5000);     // Catch: Throwable -> L22 InterruptedException -> L37
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L30
    L24:
        monitor-exit(r10);     // Catch: Throwable -> L22
    L33:
        e = move-exception;
        e.printStackTrace();
    L36:
        return f13499c;
    }

    public static synchronized Class d() {
        monitor-enter(a.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (f13497a == null) goto L18;
    L10:
        Class r10 = f13497a;     // Catch: Throwable -> L13
        monitor-exit(a.class);
        return r10;
    L18:
        f13497a = Class.forName("android.app.ActivityThread");     // Catch: ClassNotFoundException -> L8 Throwable -> L13
    L8:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L13
        goto L10
    }

    public static synchronized Field e() {
        monitor-enter(a.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f13498b != null) goto L7;
        f13498b = b.a(d(), "mH");     // Catch: Throwable -> L10
    L7:
        Field r10 = f13498b;     // Catch: Throwable -> L10
        monitor-exit(a.class);
        return r10;
    }

    public static synchronized Object f() {
        monitor-enter(a.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (f13500d == null) goto L16;
    L10:
        Object r10 = f13500d;     // Catch: Throwable -> L13
        monitor-exit(a.class);
        return r10;
    L16:
        f13500d = e().get(g());     // Catch: IllegalAccessException -> L8 Throwable -> L13
    L8:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L13
        goto L10
    }

    public static synchronized Object g() {
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
            java.lang.Class<x3.a> r0 = x3.a.class
            monitor-enter(r0)
            java.lang.Object r1 = x3.a.f13499c     // Catch: java.lang.Throwable -> L1a java.lang.Throwable -> L1d
            if (r1 != 0) goto L16
            java.lang.Class r1 = d()     // Catch: java.lang.Throwable -> L1a java.lang.Throwable -> L1d
            java.lang.String r2 = "currentActivityThread"
            r3 = 0
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L1a java.lang.Throwable -> L1d
            java.lang.Object r1 = x3.f.h(r1, r2, r3)     // Catch: java.lang.Throwable -> L1a java.lang.Throwable -> L1d
            x3.a.f13499c = r1     // Catch: java.lang.Throwable -> L1a java.lang.Throwable -> L1d
        L16:
            java.lang.Object r1 = x3.a.f13499c     // Catch: java.lang.Throwable -> L1a java.lang.Throwable -> L1d
            monitor-exit(r0)
            return r1
        L1a:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        L1d:
            r1 = 0
            monitor-exit(r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: x3.a.g():java.lang.Object");
    }

    public static boolean h(Message r10) {
        if (r10 != null) goto L6;
        return false;
    L6:
        if (f13501e.contains(Integer.valueOf(r10.what)) == false) goto L9;
        return true;
    L9:
        return false;
    }
}
