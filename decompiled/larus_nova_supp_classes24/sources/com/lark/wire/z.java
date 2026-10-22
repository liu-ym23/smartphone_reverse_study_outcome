package com.lark.wire;

import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class z extends ProtoAdapter {
    @Override // com.lark.wire.ProtoAdapter
    public final Object b(h0 r4) {
        Intrinsics.checkNotNullParameter(r4, "reader");
        int r5 = r4.c();
        if (r5 != 0) goto L7;
        return null;
    L7:
        throw new IOException("expected 0 but was " + r5);
    }

    @Override // com.lark.wire.ProtoAdapter
    public final Object c(g0 r4) {
        Intrinsics.checkNotNullParameter(r4, "reader");
        int r5 = r4.k();
        if (r5 != 0) goto L7;
        return null;
    L7:
        throw new IOException("expected 0 but was " + r5);
    }

    @Override // com.lark.wire.ProtoAdapter
    public final int k(Object r1) {
        Void r2 = (Void) r1;
        int r3 = j0.b;
        return j0.a.a(0);
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void f(j0 r1, Object r2) {
        Void r3 = (Void) r2;
        Intrinsics.checkNotNullParameter(r1, "writer");
        r1.c(0);
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void g(n0 r1, Object r2) {
        Void r3 = (Void) r2;
        Intrinsics.checkNotNullParameter(r1, "writer");
        r1.h(0);
    }

    @Override // com.lark.wire.ProtoAdapter
    public final int l(int r3, Object r4) {
        Void r5 = (Void) r4;
        int r6 = j0.b;
        int r7 = j0.a.a(0);
        FieldEncoding r0 = FieldEncoding.VARINT;
        Intrinsics.checkNotNullParameter(r0, "fieldEncoding");
        return j0.a.a((r3 << 3) | r0.getValue$wire_runtime()) + j0.a.a(r7);
    }

    public z(FieldEncoding r8, KClass r9, Syntax r10) {
        super(r8, r9, "type.googleapis.com/google.protobuf.NullValue", r10, null, 48);
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void i(j0 r2, int r3, Object r4) {
        Void r5 = (Void) r4;
        Intrinsics.checkNotNullParameter(r2, "writer");
        r2.b(r3, this.a);
        Intrinsics.checkNotNullParameter(r2, "writer");
        r2.c(0);
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void j(n0 r1, int r2, Object r3) {
        Void r4 = (Void) r3;
        Intrinsics.checkNotNullParameter(r1, "writer");
        Intrinsics.checkNotNullParameter(r1, "writer");
        r1.h(0);
        r1.g(r2, this.a);
    }
}
