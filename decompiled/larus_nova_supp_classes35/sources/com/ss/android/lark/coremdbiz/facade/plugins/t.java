package com.ss.android.lark.coremdbiz.facade.plugins;

import android.content.Context;
import com.ss.android.lark.coremd.base.parse.TextFutureRunner;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class t implements com.ss.android.lark.coremd.base.parse.x {
    public final /* synthetic */ cab.b a;
    public final /* synthetic */ com.ss.android.lark.coremd.base.parse.r<v7b.n> b;
    public final /* synthetic */ LarkLinkPlugin c;

    public t(cab.b r1, com.ss.android.lark.coremd.impl.parse.k r2, LarkLinkPlugin r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.ss.android.lark.coremdbiz.facade.plugins.LarkLinkPlugin$visitLink$1$1] */
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
    @Override // com.ss.android.lark.coremd.base.parse.x
    public final void a(final TextFutureRunner.a r7) {
        Intrinsics.checkNotNullParameter(r7, "it");
        cab.b r0 = this.a;
        Context r1 = this.b.getContext();
        v7b.n r2 = this.b.getNode();
        final LarkLinkPlugin r4 = this.c;
        final com.ss.android.lark.coremd.base.parse.r<v7b.n> r5 = this.b;
        r0.b(r1, r2, new LarkLinkPlugin$visitLink$1$1(r7, r4, r5));
    }
}
