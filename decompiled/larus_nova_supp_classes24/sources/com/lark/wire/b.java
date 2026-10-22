package com.lark.wire;

import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b extends ProtoAdapter<double[]> {
    public final ProtoAdapter<Double> v;

    public b(c r9) {
        Intrinsics.checkNotNullParameter(r9, "originalAdapter");
        super(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(double[].class), null, r9.d, new double[0], 32);
        this.v = r9;
    }

    @Override // com.lark.wire.ProtoAdapter
    public final double[] b(h0 r4) {
        Intrinsics.checkNotNullParameter(r4, "reader");
        DoubleCompanionObject r1 = DoubleCompanionObject.INSTANCE;
        return new double[]{Double.longBitsToDouble(r4.g())};
    }

    @Override // com.lark.wire.ProtoAdapter
    public final double[] c(g0 r4) {
        Intrinsics.checkNotNullParameter(r4, "reader");
        DoubleCompanionObject r1 = DoubleCompanionObject.INSTANCE;
        return new double[]{Double.longBitsToDouble(r4.h())};
    }

    @Override // com.lark.wire.ProtoAdapter
    public final int k(double[] r7) {
        double[] r8 = r7;
        Intrinsics.checkNotNullParameter(r8, "value");
        int r0 = r8.length;
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r2 = r2 + this.v.k(Double.valueOf(r8[r1]));
        r1 = r1 + 1;
        goto L3
    L5:
        return r2;
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void f(j0 r6, double[] r7) {
        double[] r8 = r7;
        Intrinsics.checkNotNullParameter(r6, "writer");
        Intrinsics.checkNotNullParameter(r8, "value");
        int r0 = r8.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        this.v.f(r6, Double.valueOf(r8[r1]));
        r1 = r1 + 1;
        goto L3
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void g(n0 r5, double[] r6) {
        double[] r7 = r6;
        Intrinsics.checkNotNullParameter(r5, "writer");
        Intrinsics.checkNotNullParameter(r7, "value");
        int r0 = r7.length - 1;
    L3:
        if ((-1) >= r0) goto L5;
        r5.f(Double.doubleToLongBits(r7[r0]));
        r0 = r0 - 1;
        goto L3
    }

    @Override // com.lark.wire.ProtoAdapter
    public final int l(int r3, double[] r4) {
        double[] r5 = r4;
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
    public final void i(j0 r3, int r4, double[] r5) {
        double[] r6 = r5;
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
    public final void j(n0 r3, int r4, double[] r5) {
        double[] r6 = r5;
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
