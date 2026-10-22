package com.lark.wire;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class k<E> extends ProtoAdapter<List<? extends E>> {
    public final ProtoAdapter<E> v;

    public k(ProtoAdapter<E> r9) {
        Intrinsics.checkNotNullParameter(r9, "originalAdapter");
        super(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(List.class), null, r9.d, CollectionsKt.emptyList(), 32);
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
    public final int k(Object r6) {
        List r7 = (List) r6;
        Intrinsics.checkNotNullParameter(r7, "value");
        int r0 = r7.size();
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r2 = r2 + this.v.k((E) ListProtector.get(r7, r1));
        r1 = r1 + 1;
        goto L3
    L5:
        return r2;
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void f(j0 r5, Object r6) {
        List r7 = (List) r6;
        Intrinsics.checkNotNullParameter(r5, "writer");
        Intrinsics.checkNotNullParameter(r7, "value");
        int r0 = r7.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        this.v.f(r5, (E) ListProtector.get(r7, r1));
        r1 = r1 + 1;
        goto L3
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void g(n0 r5, Object r6) {
        List r7 = (List) r6;
        Intrinsics.checkNotNullParameter(r5, "writer");
        Intrinsics.checkNotNullParameter(r7, "value");
        int r0 = r7.size() - 1;
    L3:
        if ((-1) >= r0) goto L5;
        this.v.g(r5, (E) ListProtector.get(r7, r0));
        r0 = r0 - 1;
        goto L3
    }

    @Override // com.lark.wire.ProtoAdapter
    public final int l(int r2, Object r3) {
        List r4 = (List) r3;
        if (r4 != null) goto L5;
    L8:
        return 0;
    L5:
        if (r4.isEmpty() == true) goto L8;
        return super.l(r2, r4);
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void i(j0 r2, int r3, Object r4) {
        List r5 = (List) r4;
        Intrinsics.checkNotNullParameter(r2, "writer");
        if (r5 != null) goto L5;
        return;
    L5:
        if ((!r5.isEmpty()) == false) goto L9;
        super.i(r2, r3, r5);
        return;
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void j(n0 r2, int r3, Object r4) {
        List r5 = (List) r4;
        Intrinsics.checkNotNullParameter(r2, "writer");
        if (r5 != null) goto L5;
        return;
    L5:
        if ((!r5.isEmpty()) == false) goto L9;
        super.j(r2, r3, r5);
        return;
    }
}
