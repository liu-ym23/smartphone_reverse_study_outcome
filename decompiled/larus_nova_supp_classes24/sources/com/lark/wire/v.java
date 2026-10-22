package com.lark.wire;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class v extends ProtoAdapter<Long> {
    @Override // com.lark.wire.ProtoAdapter
    public final Long b(h0 r7) {
        Intrinsics.checkNotNullParameter(r7, "reader");
        int r0 = j0.b;
        long r1 = r7.l();
        long r2 = r1 >>> 1;
        return Long.valueOf((-(r1 & 1)) ^ r2);
    }

    @Override // com.lark.wire.ProtoAdapter
    public final Long c(g0 r7) {
        Intrinsics.checkNotNullParameter(r7, "reader");
        int r0 = j0.b;
        long r1 = r7.l();
        long r2 = r1 >>> 1;
        return Long.valueOf((-(r1 & 1)) ^ r2);
    }

    @Override // com.lark.wire.ProtoAdapter
    public final int k(Long r5) {
        long r0 = r5.longValue();
        int r6 = j0.b;
        long r2 = r0 << 1;
        return j0.a.b((r0 >> 63) ^ r2);
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void f(j0 r5, Long r6) {
        long r0 = r6.longValue();
        Intrinsics.checkNotNullParameter(r5, "writer");
        int r7 = j0.b;
        long r2 = r0 << 1;
        r5.d((r0 >> 63) ^ r2);
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void g(n0 r5, Long r6) {
        long r0 = r6.longValue();
        Intrinsics.checkNotNullParameter(r5, "writer");
        int r7 = j0.b;
        long r2 = r0 << 1;
        r5.i((r0 >> 63) ^ r2);
    }

    public v(FieldEncoding r8, KClass<Long> r9, Syntax r10) {
        super(r8, r9, null, r10, 0L, 32);
    }
}
