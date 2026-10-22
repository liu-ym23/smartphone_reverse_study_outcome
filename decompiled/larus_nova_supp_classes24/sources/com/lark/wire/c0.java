package com.lark.wire;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c0 extends ProtoAdapter<Long> {
    @Override // com.lark.wire.ProtoAdapter
    public final Long b(h0 r3) {
        Intrinsics.checkNotNullParameter(r3, "reader");
        return Long.valueOf(r3.l());
    }

    @Override // com.lark.wire.ProtoAdapter
    public final Long c(g0 r3) {
        Intrinsics.checkNotNullParameter(r3, "reader");
        return Long.valueOf(r3.l());
    }

    @Override // com.lark.wire.ProtoAdapter
    public final int k(Long r3) {
        long r0 = r3.longValue();
        int r4 = j0.b;
        return j0.a.b(r0);
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void f(j0 r3, Long r4) {
        long r0 = r4.longValue();
        Intrinsics.checkNotNullParameter(r3, "writer");
        r3.d(r0);
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void g(n0 r3, Long r4) {
        long r0 = r4.longValue();
        Intrinsics.checkNotNullParameter(r3, "writer");
        r3.i(r0);
    }

    public c0(FieldEncoding r8, KClass<Long> r9, Syntax r10) {
        super(r8, r9, null, r10, 0L, 32);
    }
}
