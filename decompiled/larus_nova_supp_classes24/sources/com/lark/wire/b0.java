package com.lark.wire;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b0 extends ProtoAdapter<Integer> {
    @Override // com.lark.wire.ProtoAdapter
    public final Integer b(h0 r2) {
        Intrinsics.checkNotNullParameter(r2, "reader");
        return Integer.valueOf(r2.c());
    }

    @Override // com.lark.wire.ProtoAdapter
    public final Integer c(g0 r2) {
        Intrinsics.checkNotNullParameter(r2, "reader");
        return Integer.valueOf(r2.k());
    }

    @Override // com.lark.wire.ProtoAdapter
    public final int k(Integer r2) {
        int r3 = r2.intValue();
        int r0 = j0.b;
        return j0.a.a(r3);
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void f(j0 r2, Integer r3) {
        int r4 = r3.intValue();
        Intrinsics.checkNotNullParameter(r2, "writer");
        r2.c(r4);
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void g(n0 r2, Integer r3) {
        int r4 = r3.intValue();
        Intrinsics.checkNotNullParameter(r2, "writer");
        r2.h(r4);
    }

    public b0(FieldEncoding r8, KClass<Integer> r9, Syntax r10) {
        super(r8, r9, null, r10, 0, 32);
    }
}
