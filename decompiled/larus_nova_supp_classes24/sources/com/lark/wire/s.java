package com.lark.wire;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class s extends ProtoAdapter<Integer> {
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
        if (r3 >= 0) goto L7;
        return 10;
    L7:
        return j0.a.a(r3);
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void f(j0 r3, Integer r4) {
        int r5 = r4.intValue();
        Intrinsics.checkNotNullParameter(r3, "writer");
        if (r5 < 0) goto L5;
        r3.c(r5);
        return;
    L5:
        r3.d(r5);
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void g(n0 r3, Integer r4) {
        int r5 = r4.intValue();
        Intrinsics.checkNotNullParameter(r3, "writer");
        if (r5 < 0) goto L5;
        r3.h(r5);
        return;
    L5:
        r3.i(r5);
    }

    public s(FieldEncoding r8, KClass<Integer> r9, Syntax r10) {
        super(r8, r9, null, r10, 0, 32);
    }
}
