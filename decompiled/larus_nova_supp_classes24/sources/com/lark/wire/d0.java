package com.lark.wire;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class d0 extends ProtoAdapter<Object> {
    public final /* synthetic */ ProtoAdapter<Object> v;

    @Override // com.lark.wire.ProtoAdapter
    public final Object b(h0 r6) {
        Intrinsics.checkNotNullParameter(r6, "reader");
        ProtoAdapter<Object> r0 = this.v;
        Object r1 = r0.e;
        int r2 = r6.h();
    L3:
        int r3 = r6.nextTag();
        if (r3 == (-1)) goto L9;
        if (r3 == 1) goto L7;
        r6.m(r3);
        goto L3
    L7:
        r1 = r0.b(r6);
        goto L3
    L9:
        r6.k(r2);
        return r1;
    }

    @Override // com.lark.wire.ProtoAdapter
    public final Object c(g0 r7) {
        Intrinsics.checkNotNullParameter(r7, "reader");
        ProtoAdapter<Object> r0 = this.v;
        Object r1 = r0.e;
        long r2 = r7.c();
    L3:
        int r4 = r7.e();
        if (r4 == (-1)) goto L9;
        if (r4 == 1) goto L7;
        r7.j(r4);
        goto L3
    L7:
        r1 = r0.c(r7);
        goto L3
    L9:
        r7.d(r2);
        return r1;
    }

    @Override // com.lark.wire.ProtoAdapter
    public final int k(Object r3) {
        if (r3 != null) goto L4;
        return 0;
    L4:
        if (Intrinsics.areEqual(r3, this.v.e) == false) goto L7;
        return 0;
    L7:
        return this.v.l(1, r3);
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void f(j0 r3, Object r4) {
        Intrinsics.checkNotNullParameter(r3, "writer");
        if (r4 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r4, this.v.e) == true) goto L9;
        this.v.i(r3, 1, r4);
        return;
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void g(n0 r3, Object r4) {
        Intrinsics.checkNotNullParameter(r3, "writer");
        if (r4 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r4, this.v.e) == true) goto L9;
        this.v.j(r3, 1, r4);
        return;
    }

    public d0(String r8, ProtoAdapter<Object> r9, FieldEncoding r10, KClass<?> r11, Syntax r12, Object r13) {
        this.v = r9;
        super(r10, r11, r8, r12, r13, 32);
    }
}
