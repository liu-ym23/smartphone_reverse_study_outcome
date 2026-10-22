package com.lark.wire;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class p extends ProtoAdapter<Integer> {
    @Override // com.lark.wire.ProtoAdapter
    public final Integer b(h0 r2) {
        Intrinsics.checkNotNullParameter(r2, "reader");
        return Integer.valueOf(r2.d());
    }

    @Override // com.lark.wire.ProtoAdapter
    public final Integer c(g0 r2) {
        Intrinsics.checkNotNullParameter(r2, "reader");
        return Integer.valueOf(r2.g());
    }

    @Override // com.lark.wire.ProtoAdapter
    public final /* bridge */ /* synthetic */ int k(Integer r1) {
        r1.intValue();
        return 4;
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void f(j0 r2, Integer r3) {
        int r4 = r3.intValue();
        Intrinsics.checkNotNullParameter(r2, "writer");
        r2.a.writeIntLe(r4);
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void g(n0 r2, Integer r3) {
        int r4 = r3.intValue();
        Intrinsics.checkNotNullParameter(r2, "writer");
        r2.e(r4);
    }

    public p(FieldEncoding r8, KClass<Integer> r9, Syntax r10) {
        super(r8, r9, null, r10, 0, 32);
    }
}
