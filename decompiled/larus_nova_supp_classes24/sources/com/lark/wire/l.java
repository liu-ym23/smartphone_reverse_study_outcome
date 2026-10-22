package com.lark.wire;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class l extends ProtoAdapter<Boolean> {
    @Override // com.lark.wire.ProtoAdapter
    public final Boolean b(h0 r2) {
        Intrinsics.checkNotNullParameter(r2, "reader");
        if (r2.c() != 0) goto L5;
        boolean r3 = false;
    L7:
        return Boolean.valueOf(r3);
    L5:
        r3 = true;
        goto L7
    }

    @Override // com.lark.wire.ProtoAdapter
    public final Boolean c(g0 r2) {
        Intrinsics.checkNotNullParameter(r2, "reader");
        if (r2.k() != 0) goto L5;
        boolean r3 = false;
    L7:
        return Boolean.valueOf(r3);
    L5:
        r3 = true;
        goto L7
    }

    @Override // com.lark.wire.ProtoAdapter
    public final /* bridge */ /* synthetic */ int k(Boolean r1) {
        r1.booleanValue();
        return 1;
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void f(j0 r2, Boolean r3) {
        boolean r4 = r3.booleanValue();
        Intrinsics.checkNotNullParameter(r2, "writer");
        r2.c(r4 ? 1 : 0);
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void g(n0 r2, Boolean r3) {
        boolean r4 = r3.booleanValue();
        Intrinsics.checkNotNullParameter(r2, "writer");
        r2.h(r4 ? 1 : 0);
    }

    public l(FieldEncoding r8, KClass<Boolean> r9, Syntax r10) {
        super(r8, r9, null, r10, Boolean.FALSE, 32);
    }
}
