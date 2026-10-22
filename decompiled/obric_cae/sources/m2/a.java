package m2;

import android.text.TextUtils;
import android.util.Log;
import c2.k;
import com.bytedance.apm.doctor.DoctorManager;
import j3.d;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import m2.c;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class a<T extends c> implements v8.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList<T> f9253a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f9254b;

    /* JADX INFO: renamed from: m2.a$a, reason: collision with other inner class name */
    public class RunnableC0113a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f9255a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f9256b;

        public RunnableC0113a(a r8, c r10) {
            this.f9256b = r8;
            this.f9255a = r10;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public final void run() {
            this.f9256b.f(this.f9255a);
        }
    }

    public a() {
        this.f9253a = new LinkedList();
    }

    public static void h(String r8, String r10, JSONObject r11, boolean r12, boolean r13) {
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
            Method dump skipped, instruction units count: 379
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m2.a.h(java.lang.String, java.lang.String, org.json.JSONObject, boolean, boolean):void");
    }

    @Override // v8.a
    public void a(JSONObject r8) {
    }

    @Override // v8.a
    public final void b() {
        this.f9254b = true;
        b3.b.C0032b.f3038a.c(new b(this));
        if (k.d() == false) goto L9;
        ArrayList r8 = DoctorManager.getInstance().f3760a;
        if (l6.a.d0(r8) == true) goto L10;
        ArrayList r10 = new ArrayList(r8);
        Object r11 = c8.d.f3410e;
        c8.d.a.f3417a.e(new com.bytedance.apm.doctor.a(r10));
        return;
    L10:
        return;
    }

    public boolean c(T r8) {
        return true;
    }

    public final void d(T r8) {
        b3.b r10 = b3.b.C0032b.f3038a;
        if (r10.b() == true) goto L5;
        r10.c(new RunnableC0113a(this, r8));
        return;
    L5:
        f(r8);
    }

    public abstract void e(T r8);

    public final void f(T r8) {
        if (c(r8) == true) goto L5;
        return;
    L5:
        g(r8);
        if (this.f9254b == false) goto L8;
        e(r8);
        return;
    L8:
        if (r8 == null) goto L28;
        LinkedList<T> r10 = this.f9253a;
        monitor-enter(r10);
    L19:
        th = move-exception;
        throw th;
    L13:
        if (this.f9253a.size() > 1000) goto L25;
    L16:
        this.f9253a.add(r8);     // Catch: Throwable -> L19
        monitor-exit(r10);     // Catch: Throwable -> L19
        return;
    L25:
        this.f9253a.poll().c().toString();     // Catch: Exception -> L22 Throwable -> L19
        goto L16
    }

    public void g(T r8) {
    }
}
