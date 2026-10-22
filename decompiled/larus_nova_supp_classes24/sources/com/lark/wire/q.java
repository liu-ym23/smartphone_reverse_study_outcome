package com.lark.wire;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class q extends ProtoAdapter<Long> {
    @Override // com.lark.wire.ProtoAdapter
    public final Long b(h0 r3) {
        Intrinsics.checkNotNullParameter(r3, "reader");
        return Long.valueOf(r3.g());
    }

    @Override // com.lark.wire.ProtoAdapter
    public final Long c(g0 r3) {
        Intrinsics.checkNotNullParameter(r3, "reader");
        return Long.valueOf(r3.h());
    }

    @Override // com.lark.wire.ProtoAdapter
    public final /* bridge */ /* synthetic */ int k(Long r1) {
        r1.longValue();
        return 8;
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void f(j0 r3, Long r4) {
        long r0 = r4.longValue();
        Intrinsics.checkNotNullParameter(r3, "writer");
        r3.a.writeLongLe(r0);
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void g(n0 r3, Long r4) {
        long r0 = r4.longValue();
        Intrinsics.checkNotNullParameter(r3, "writer");
        r3.f(r0);
    }

    public q(FieldEncoding r8, KClass<Long> r9, Syntax r10) {
        super(r8, r9, null, r10, 0L, 32);
    }
}
