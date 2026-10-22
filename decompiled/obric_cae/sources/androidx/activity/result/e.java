package androidx.activity.result;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import androidx.lifecycle.h;
import androidx.lifecycle.k;
import androidx.lifecycle.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f522a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f523b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f524c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ArrayList<String> f525d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final transient HashMap f526e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashMap f527f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Bundle f528g;

    public static class a<O> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final androidx.activity.result.a<O> f529a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final b.a<?, O> f530b;

        public a(b.a r8, androidx.activity.result.a r10) {
            this.f529a = r10;
            this.f530b = r8;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final h f531a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ArrayList<k> f532b;

        public b(h r8) {
            this.f531a = r8;
            this.f532b = new ArrayList();
        }
    }

    public e() {
        this.f522a = new HashMap();
        this.f523b = new HashMap();
        this.f524c = new HashMap();
        this.f525d = new ArrayList();
        this.f526e = new HashMap();
        this.f527f = new HashMap();
        this.f528g = new Bundle();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*  JADX ERROR: JadxRuntimeException in pass: FinishTypeInference
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r5v2 boolean
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.dex.visitors.typeinference.FinishTypeInference.lambda$visit$0(FinishTypeInference.java:27)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.dex.visitors.typeinference.FinishTypeInference.visit(FinishTypeInference.java:22)
        */
    public final boolean a(int r4, int r5, android.content.Intent r6) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r5v2 boolean
            	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:341)
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
            r3 = this;
            java.util.HashMap r0 = r3.f522a
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            java.lang.Object r4 = r0.get(r4)
            java.lang.String r4 = (java.lang.String) r4
            if (r4 != 0) goto L10
            r3 = 0
            return r3
        L10:
            java.util.HashMap r0 = r3.f526e
            java.lang.Object r0 = r0.get(r4)
            androidx.activity.result.e$a r0 = (androidx.activity.result.e.a) r0
            if (r0 == 0) goto L35
            androidx.activity.result.a<O> r1 = r0.f529a
            if (r1 == 0) goto L35
            java.util.ArrayList<java.lang.String> r2 = r3.f525d
            boolean r2 = r2.contains(r4)
            if (r2 == 0) goto L35
            b.a<?, O> r0 = r0.f530b
            java.lang.Object r5 = r0.c(r6, r5)
            r1.a(r5)
            java.util.ArrayList<java.lang.String> r3 = r3.f525d
            r3.remove(r4)
            goto L44
        L35:
            java.util.HashMap r0 = r3.f527f
            r0.remove(r4)
            androidx.activity.result.ActivityResult r0 = new androidx.activity.result.ActivityResult
            r0.<init>(r6, r5)
            android.os.Bundle r3 = r3.f528g
            r3.putParcelable(r4, r0)
        L44:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.activity.result.e.a(int, int, android.content.Intent):boolean");
    }

    public abstract void b(int r8, b.a r10, @SuppressLint({"UnknownNullness"}) Object r11);

    public final c c(final String r8, m r10, final b.a r11, final androidx.activity.result.a r12) {
        h r13 = r10.getLifecycle();
        if (r13.b().compareTo(h.b.f2160n) < 0) goto L5;
        boolean r14 = true;
    L6:
        if (r14 == true) goto L13;
        e(r8);
        HashMap r15 = this.f524c;
        b r16 = (b) r15.get(r8);
        if (r16 != null) goto L10;
        r16 = new b(r13);
    L10:
        k r17 = new ActivityResultRegistry$1(this, r8, r12, r11);
        r16.f531a.a(r17);
        r16.f532b.add(r17);
        r15.put(r8, r16);
        return new c(this, r8, r11);
    L13:
        throw new IllegalStateException("LifecycleOwner " + r10 + " is attempting to register while current state is " + r13.b() + ". LifecycleOwners must call register before they are STARTED.");
    L5:
        r14 = false;
        goto L6
    }

    public final d d(String r8, b.a r10, androidx.activity.result.a r11) {
        e(r8);
        this.f526e.put(r8, new a(r10, r11));
        HashMap r12 = this.f527f;
        if (r12.containsKey(r8) == false) goto L5;
        Object r13 = r12.get(r8);
        r12.remove(r8);
        r11.a(r13);
    L5:
        Bundle r14 = this.f528g;
        ActivityResult r15 = (ActivityResult) r14.getParcelable(r8);
        if (r15 == null) goto L9;
        r14.remove(r8);
        r11.a(r10.c(r15.f506b, r15.f505a));
    L9:
        return new d(this, r8, r10);
    }

    public final void e(String r8) {
        HashMap r10 = this.f523b;
        if (((Integer) r10.get(r8)) == null) goto L5;
        return;
    L5:
        ie.c.f8327a.getClass();
        int r11 = ie.c.f8328b.b() + 65536;
        HashMap r12 = this.f522a;
        if (r12.containsKey(Integer.valueOf(r11)) == true) goto L5;
        r12.put(Integer.valueOf(r11), r8);
        r10.put(r8, Integer.valueOf(r11));
    }

    public final void f(String r8) {
        if (this.f525d.contains(r8) == true) goto L7;
        Integer r10 = (Integer) this.f523b.remove(r8);
        if (r10 == null) goto L7;
        this.f522a.remove(r10);
    L7:
        this.f526e.remove(r8);
        HashMap r11 = this.f527f;
        if (r11.containsKey(r8) == false) goto L10;
        StringBuilder r12 = defpackage.b.h("Dropping pending result for request ", r8, ": ");
        r12.append(r11.get(r8));
        Log.w("ActivityResultRegistry", r12.toString());
        r11.remove(r8);
    L10:
        Bundle r13 = this.f528g;
        if (r13.containsKey(r8) == false) goto L13;
        StringBuilder r14 = defpackage.b.h("Dropping pending result for request ", r8, ": ");
        r14.append(r13.getParcelable(r8));
        Log.w("ActivityResultRegistry", r14.toString());
        r13.remove(r8);
    L13:
        HashMap r15 = this.f524c;
        b r16 = (b) r15.get(r8);
        if (r16 == null) goto L22;
        ArrayList<k> r17 = r16.f532b;
        Iterator<k> r18 = r17.iterator();
    L17:
        if (r18.hasNext() == false) goto L19;
        k r19 = r18.next();
        r16.f531a.c(r19);
        goto L17
    L19:
        r17.clear();
        r15.remove(r8);
        return;
    }
}
