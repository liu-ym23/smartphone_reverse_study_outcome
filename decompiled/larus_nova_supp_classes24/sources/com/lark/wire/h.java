package com.lark.wire;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class h extends ProtoAdapter<long[]> {
    public final ProtoAdapter<Long> v;

    public h(ProtoAdapter<Long> r9) {
        Intrinsics.checkNotNullParameter(r9, "originalAdapter");
        super(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(long[].class), null, r9.d, new long[0], 32);
        this.v = r9;
    }

    @Override // com.lark.wire.ProtoAdapter
    public final long[] b(h0 r4) {
        Intrinsics.checkNotNullParameter(r4, "reader");
        return new long[]{this.v.b(r4).longValue()};
    }

    @Override // com.lark.wire.ProtoAdapter
    public final long[] c(g0 r4) {
        Intrinsics.checkNotNullParameter(r4, "reader");
        return new long[]{this.v.c(r4).longValue()};
    }

    @Override // com.lark.wire.ProtoAdapter
    public final int k(long[] r7) {
        long[] r8 = r7;
        Intrinsics.checkNotNullParameter(r8, "value");
        int r0 = r8.length;
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r2 = r2 + this.v.k(Long.valueOf(r8[r1]));
        r1 = r1 + 1;
        goto L3
    L5:
        return r2;
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void f(j0 r6, long[] r7) {
        long[] r8 = r7;
        Intrinsics.checkNotNullParameter(r6, "writer");
        Intrinsics.checkNotNullParameter(r8, "value");
        int r0 = r8.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        this.v.f(r6, Long.valueOf(r8[r1]));
        r1 = r1 + 1;
        goto L3
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void g(n0 r6, long[] r7) {
        long[] r8 = r7;
        Intrinsics.checkNotNullParameter(r6, "writer");
        Intrinsics.checkNotNullParameter(r8, "value");
        int r0 = r8.length - 1;
    L3:
        if ((-1) >= r0) goto L5;
        this.v.g(r6, Long.valueOf(r8[r0]));
        r0 = r0 - 1;
        goto L3
    }

    @Override // com.lark.wire.ProtoAdapter
    public final int l(int r3, long[] r4) {
        long[] r5 = r4;
        if (r5 != null) goto L5;
        return 0;
    L5:
        if (r5.length != 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L11;
        return 0;
    L11:
        return super.l(r3, r5);
    L7:
        r1 = false;
        goto L8
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void i(j0 r3, int r4, long[] r5) {
        long[] r6 = r5;
        Intrinsics.checkNotNullParameter(r3, "writer");
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.length != 0) goto L7;
        boolean r0 = true;
    L9:
        if ((!r0) == false) goto L13;
        super.i(r3, r4, r6);
        return;
    L13:
        return;
    L7:
        r0 = false;
        goto L9
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void j(n0 r3, int r4, long[] r5) {
        long[] r6 = r5;
        Intrinsics.checkNotNullParameter(r3, "writer");
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.length != 0) goto L7;
        boolean r0 = true;
    L9:
        if ((!r0) == false) goto L13;
        super.j(r3, r4, r6);
        return;
    L13:
        return;
    L7:
        r0 = false;
        goto L9
    }
}
