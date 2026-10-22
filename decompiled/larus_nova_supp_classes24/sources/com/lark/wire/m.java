package com.lark.wire;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class m extends ProtoAdapter<ByteString> {
    @Override // com.lark.wire.ProtoAdapter
    public final ByteString b(h0 r2) {
        Intrinsics.checkNotNullParameter(r2, "reader");
        return r2.f();
    }

    @Override // com.lark.wire.ProtoAdapter
    public final ByteString c(g0 r2) {
        Intrinsics.checkNotNullParameter(r2, "reader");
        return r2.f();
    }

    @Override // com.lark.wire.ProtoAdapter
    public final int k(ByteString r2) {
        ByteString r3 = r2;
        Intrinsics.checkNotNullParameter(r3, "value");
        return r3.size();
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void f(j0 r2, ByteString r3) {
        ByteString r4 = r3;
        Intrinsics.checkNotNullParameter(r2, "writer");
        Intrinsics.checkNotNullParameter(r4, "value");
        r2.a(r4);
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void g(n0 r2, ByteString r3) {
        ByteString r4 = r3;
        Intrinsics.checkNotNullParameter(r2, "writer");
        Intrinsics.checkNotNullParameter(r4, "value");
        r2.d(r4);
    }

    public m(FieldEncoding r8, KClass<ByteString> r9, Syntax r10, ByteString r11) {
        super(r8, r9, null, r10, r11, 32);
    }
}
