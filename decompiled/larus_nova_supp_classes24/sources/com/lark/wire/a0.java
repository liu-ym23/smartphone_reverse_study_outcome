package com.lark.wire;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a0 extends ProtoAdapter<Object> {
    @Override // com.lark.wire.ProtoAdapter
    public final Object b(h0 r7) {
        Intrinsics.checkNotNullParameter(r7, "reader");
        int r1 = r7.h();
    L3:
        Object r3 = null;
    L4:
        int r4 = r7.nextTag();
        if (r4 == (-1)) goto L14;
        switch(r4) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            default: goto L7;
        };
    L8:
        r3 = ProtoAdapter.s.b(r7);
        goto L4
    L9:
        r3 = ProtoAdapter.r.b(r7);
        goto L4
    L10:
        r3 = ProtoAdapter.g.b(r7);
        goto L4
    L11:
        ProtoAdapter.q.getClass();
        Intrinsics.checkNotNullParameter(r7, "reader");
        r3 = r7.e();
        goto L4
    L12:
        r3 = ProtoAdapter.o.b(r7);
        goto L4
    L13:
        ProtoAdapter.t.b(r7);
        goto L3
    L7:
        r7.b();
        goto L4
    L14:
        r7.k(r1);
        return r3;
    }

    @Override // com.lark.wire.ProtoAdapter
    public final Object c(g0 r8) {
        Intrinsics.checkNotNullParameter(r8, "reader");
        long r1 = r8.c();
    L3:
        Object r4 = null;
    L4:
        int r5 = r8.e();
        if (r5 == (-1)) goto L14;
        switch(r5) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            default: goto L7;
        };
    L8:
        r4 = ProtoAdapter.s.c(r8);
        goto L4
    L9:
        r4 = ProtoAdapter.r.c(r8);
        goto L4
    L10:
        r4 = ProtoAdapter.g.c(r8);
        goto L4
    L11:
        ProtoAdapter.q.getClass();
        Intrinsics.checkNotNullParameter(r8, "reader");
        r4 = r8.i();
        goto L4
    L12:
        r4 = ProtoAdapter.o.c(r8);
        goto L4
    L13:
        ProtoAdapter.t.c(r8);
        goto L3
    L7:
        r8.m();
        goto L4
    L14:
        r8.d(r1);
        return r4;
    }

    @Override // com.lark.wire.ProtoAdapter
    public final int k(Object r4) {
        if (r4 != null) goto L5;
        return ProtoAdapter.t.l(1, r4);
    L5:
        if ((r4 instanceof Number) == false) goto L8;
        return ProtoAdapter.o.l(2, Double.valueOf(((Number) r4).doubleValue()));
    L8:
        if ((r4 instanceof String) == false) goto L11;
        return ProtoAdapter.q.l(3, r4);
    L11:
        if ((r4 instanceof Boolean) == false) goto L14;
        return ProtoAdapter.g.l(4, r4);
    L14:
        if ((r4 instanceof Map) == false) goto L17;
        y r0 = ProtoAdapter.r;
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, *>");
        return r0.l(5, (Map) r4);
    L17:
        if ((r4 instanceof List) == false) goto L21;
        return ProtoAdapter.s.l(6, r4);
    L21:
        throw new IllegalArgumentException("unexpected struct value: " + r4);
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void f(j0 r4, Object r5) {
        Intrinsics.checkNotNullParameter(r4, "writer");
        if (r5 != null) goto L6;
        ProtoAdapter.t.i(r4, 1, r5);
        return;
    L6:
        if ((r5 instanceof Number) == false) goto L9;
        ProtoAdapter.o.i(r4, 2, Double.valueOf(((Number) r5).doubleValue()));
        return;
    L9:
        if ((r5 instanceof String) == false) goto L12;
        ProtoAdapter.q.i(r4, 3, r5);
        return;
    L12:
        if ((r5 instanceof Boolean) == false) goto L15;
        ProtoAdapter.g.i(r4, 4, r5);
        return;
    L15:
        if ((r5 instanceof Map) == false) goto L18;
        y r0 = ProtoAdapter.r;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, *>");
        r0.i(r4, 5, (Map) r5);
        return;
    L18:
        if ((r5 instanceof List) == false) goto L22;
        ProtoAdapter.s.i(r4, 6, r5);
        return;
    L22:
        throw new IllegalArgumentException("unexpected struct value: " + r5);
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void g(n0 r4, Object r5) {
        Intrinsics.checkNotNullParameter(r4, "writer");
        if (r5 != null) goto L6;
        ProtoAdapter.t.j(r4, 1, r5);
        return;
    L6:
        if ((r5 instanceof Number) == false) goto L9;
        ProtoAdapter.o.j(r4, 2, Double.valueOf(((Number) r5).doubleValue()));
        return;
    L9:
        if ((r5 instanceof String) == false) goto L12;
        ProtoAdapter.q.j(r4, 3, r5);
        return;
    L12:
        if ((r5 instanceof Boolean) == false) goto L15;
        ProtoAdapter.g.j(r4, 4, r5);
        return;
    L15:
        if ((r5 instanceof Map) == false) goto L18;
        y r0 = ProtoAdapter.r;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, *>");
        r0.j(r4, 5, (Map) r5);
        return;
    L18:
        if ((r5 instanceof List) == false) goto L22;
        ProtoAdapter.s.j(r4, 6, r5);
        return;
    L22:
        throw new IllegalArgumentException("unexpected struct value: " + r5);
    }

    @Override // com.lark.wire.ProtoAdapter
    public final int l(int r3, Object r4) {
        if (r4 != null) goto L6;
        int r5 = k(r4);
        int r0 = j0.b;
        FieldEncoding r1 = FieldEncoding.VARINT;
        Intrinsics.checkNotNullParameter(r1, "fieldEncoding");
        return (j0.a.a((r3 << 3) | r1.getValue$wire_runtime()) + j0.a.a(r5)) + r5;
    L6:
        return super.l(r3, r4);
    }

    public a0(FieldEncoding r8, KClass<Object> r9, Syntax r10) {
        super(r8, r9, "type.googleapis.com/google.protobuf.Value", r10, null, 48);
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void i(j0 r2, int r3, Object r4) {
        Intrinsics.checkNotNullParameter(r2, "writer");
        if (r4 != null) goto L5;
        r2.b(r3, this.a);
        r2.c(k(r4));
        f(r2, r4);
        return;
    L5:
        super.i(r2, r3, r4);
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void j(n0 r2, int r3, Object r4) {
        Intrinsics.checkNotNullParameter(r2, "writer");
        if (r4 != null) goto L5;
        int r0 = r2.b();
        g(r2, r4);
        r2.h(r2.b() - r0);
        r2.g(r3, this.a);
        return;
    L5:
        super.j(r2, r3, r4);
    }
}
