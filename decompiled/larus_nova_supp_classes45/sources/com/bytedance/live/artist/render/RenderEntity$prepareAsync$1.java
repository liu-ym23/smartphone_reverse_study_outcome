package com.bytedance.live.artist.render;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class RenderEntity$prepareAsync$1 implements Runnable {
    public final /* synthetic */ RenderEntity a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ Function0 c;

    public RenderEntity$prepareAsync$1(RenderEntity r1, boolean r2, Function0 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [com.bytedance.live.artist.render.RenderEntity$prepareAsync$1$1] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // java.lang.Runnable
    public final void run() {
        EntityState r0 = this.a.h;     // Catch: Throwable -> L14
        int r1 = d.a[r0.ordinal()];     // Catch: Throwable -> L14
        if (r1 == 1) goto L10;
        if (r1 != 2) goto L7;
        return;
    L7:
        if (r1 != 3) goto L12;
        return;
    L12:
        this.a.j.a(new AnonymousClass1(this));     // Catch: Throwable -> L14
        return;
    L10:
        if (this.b == false) goto L12;
        this.a.g(EntityState.Init);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L22;
        throw th;
    }
}
