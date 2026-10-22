package com.lark.wire;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class o extends ProtoAdapter<Unit> {
    @Override // com.lark.wire.ProtoAdapter
    public final Unit b(h0 r4) {
        Intrinsics.checkNotNullParameter(r4, "reader");
        int r0 = r4.h();
    L3:
        int r1 = r4.nextTag();
        if (r1 == (-1)) goto L6;
        r4.m(r1);
        goto L3
    L6:
        r4.k(r0);
        return Unit.INSTANCE;
    }

    @Override // com.lark.wire.ProtoAdapter
    public final Unit c(g0 r5) {
        Intrinsics.checkNotNullParameter(r5, "reader");
        long r0 = r5.c();
    L3:
        int r2 = r5.e();
        if (r2 == (-1)) goto L6;
        r5.j(r2);
        goto L3
    L6:
        r5.d(r0);
        return Unit.INSTANCE;
    }

    @Override // com.lark.wire.ProtoAdapter
    public final int k(Unit r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        return 0;
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void f(j0 r2, Unit r3) {
        Intrinsics.checkNotNullParameter(r2, "writer");
        Intrinsics.checkNotNullParameter(r3, "value");
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void g(n0 r2, Unit r3) {
        Intrinsics.checkNotNullParameter(r2, "writer");
        Intrinsics.checkNotNullParameter(r3, "value");
    }

    public o(FieldEncoding r8, KClass<Unit> r9, Syntax r10) {
        super(r8, r9, "type.googleapis.com/google.protobuf.Empty", r10, null, 48);
    }
}
