package com.lark.wire;

import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c extends ProtoAdapter<Double> {
    public c() {
        super(FieldEncoding.FIXED64, Reflection.getOrCreateKotlinClass(Double.TYPE), null, Syntax.PROTO_2, Double.valueOf(0.0d), 32);
    }

    @Override // com.lark.wire.ProtoAdapter
    public final Double b(h0 r3) {
        Intrinsics.checkNotNullParameter(r3, "reader");
        DoubleCompanionObject r0 = DoubleCompanionObject.INSTANCE;
        return Double.valueOf(Double.longBitsToDouble(r3.g()));
    }

    @Override // com.lark.wire.ProtoAdapter
    public final Double c(g0 r3) {
        Intrinsics.checkNotNullParameter(r3, "reader");
        DoubleCompanionObject r0 = DoubleCompanionObject.INSTANCE;
        return Double.valueOf(Double.longBitsToDouble(r3.h()));
    }

    @Override // com.lark.wire.ProtoAdapter
    public final /* bridge */ /* synthetic */ int k(Double r1) {
        r1.doubleValue();
        return 8;
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void f(j0 r3, Double r4) {
        double r0 = r4.doubleValue();
        Intrinsics.checkNotNullParameter(r3, "writer");
        long r1 = Double.doubleToLongBits(r0);
        r3.a.writeLongLe(r1);
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void g(n0 r3, Double r4) {
        double r0 = r4.doubleValue();
        Intrinsics.checkNotNullParameter(r3, "writer");
        r3.f(Double.doubleToLongBits(r0));
    }
}
