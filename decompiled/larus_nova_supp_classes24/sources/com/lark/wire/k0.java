package com.lark.wire;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class k0<E> extends ProtoAdapter<List<? extends E>> {
    public final ProtoAdapter<E> v;

    public k0(ProtoAdapter<E> r9) {
        Intrinsics.checkNotNullParameter(r9, "originalAdapter");
        super(r9.a, Reflection.getOrCreateKotlinClass(List.class), null, r9.d, CollectionsKt.emptyList(), 32);
        this.v = r9;
    }

    @Override // com.lark.wire.ProtoAdapter
    public final Object b(h0 r2) {
        Intrinsics.checkNotNullParameter(r2, "reader");
        return CollectionsKt.listOf(this.v.b(r2));
    }

    @Override // com.lark.wire.ProtoAdapter
    public final Object c(g0 r2) {
        Intrinsics.checkNotNullParameter(r2, "reader");
        return CollectionsKt.listOf(this.v.c(r2));
    }

    @Override // com.lark.wire.ProtoAdapter
    public final int k(Object r2) {
        Intrinsics.checkNotNullParameter((List) r2, "value");
        throw new UnsupportedOperationException("Repeated values can only be sized with a tag.");
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void f(j0 r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "writer");
        Intrinsics.checkNotNullParameter((List) r3, "value");
        throw new UnsupportedOperationException("Repeated values can only be encoded with a tag.");
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void g(n0 r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "writer");
        Intrinsics.checkNotNullParameter((List) r3, "value");
        throw new UnsupportedOperationException("Repeated values can only be encoded with a tag.");
    }

    /* JADX WARN: Multi-variable type inference failed */
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
    @Override // com.lark.wire.ProtoAdapter
    public final int l(int r6, Object r7) {
        List r8 = (List) r7;
        int r0 = 0;
        if (r8 == null) goto L11;
        int r1 = r8.size();
        int r2 = 0;
    L6:
        if (r0 >= r1) goto L9;
        r2 = r2 + this.v.l(r6, ListProtector.get(r8, r0));
        r0 = r0 + 1;
        goto L6
    L9:
        return r2;
    L11:
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
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
    @Override // com.lark.wire.ProtoAdapter
    public final void i(j0 r5, int r6, Object r7) {
        List r8 = (List) r7;
        Intrinsics.checkNotNullParameter(r5, "writer");
        if (r8 == null) goto L8;
        int r0 = r8.size();
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L10;
        this.v.i(r5, r6, ListProtector.get(r8, r1));
        r1 = r1 + 1;
        goto L6
    L10:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
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
    @Override // com.lark.wire.ProtoAdapter
    public final void j(n0 r5, int r6, Object r7) {
        List r8 = (List) r7;
        Intrinsics.checkNotNullParameter(r5, "writer");
        if (r8 == null) goto L8;
        int r0 = r8.size() - 1;
    L6:
        if ((-1) >= r0) goto L10;
        this.v.j(r5, r6, ListProtector.get(r8, r0));
        r0 = r0 - 1;
        goto L6
    L10:
        return;
    }
}
