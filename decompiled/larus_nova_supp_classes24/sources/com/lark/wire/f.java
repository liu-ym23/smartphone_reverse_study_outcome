package com.lark.wire;

import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class f extends ProtoAdapter<Float> {
    public f() {
        super(FieldEncoding.FIXED32, Reflection.getOrCreateKotlinClass(Float.TYPE), null, Syntax.PROTO_2, Float.valueOf(0.0f), 32);
    }

    @Override // com.lark.wire.ProtoAdapter
    public final Float b(h0 r2) {
        Intrinsics.checkNotNullParameter(r2, "reader");
        FloatCompanionObject r0 = FloatCompanionObject.INSTANCE;
        return Float.valueOf(Float.intBitsToFloat(r2.d()));
    }

    @Override // com.lark.wire.ProtoAdapter
    public final Float c(g0 r2) {
        Intrinsics.checkNotNullParameter(r2, "reader");
        FloatCompanionObject r0 = FloatCompanionObject.INSTANCE;
        return Float.valueOf(Float.intBitsToFloat(r2.g()));
    }

    @Override // com.lark.wire.ProtoAdapter
    public final /* bridge */ /* synthetic */ int k(Float r1) {
        r1.floatValue();
        return 4;
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void f(j0 r2, Float r3) {
        float r4 = r3.floatValue();
        Intrinsics.checkNotNullParameter(r2, "writer");
        int r5 = Float.floatToIntBits(r4);
        r2.a.writeIntLe(r5);
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void g(n0 r2, Float r3) {
        float r4 = r3.floatValue();
        Intrinsics.checkNotNullParameter(r2, "writer");
        r2.e(Float.floatToIntBits(r4));
    }
}
