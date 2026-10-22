package com.lark.wire;

import com.lark.wire.o0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public abstract class d<E extends o0> extends ProtoAdapter<E> {
    public abstract E n(int r1);

    @Override // com.lark.wire.ProtoAdapter
    public final Object b(h0 r3) {
        Intrinsics.checkNotNullParameter(r3, "reader");
        int r4 = r3.c();
        o0 r0 = n(r4);
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new ProtoAdapter.EnumConstantNotFoundException(r4, getType());
    }

    @Override // com.lark.wire.ProtoAdapter
    public final Object c(g0 r3) {
        Intrinsics.checkNotNullParameter(r3, "reader");
        int r4 = r3.k();
        o0 r0 = n(r4);
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new ProtoAdapter.EnumConstantNotFoundException(r4, getType());
    }

    @Override // com.lark.wire.ProtoAdapter
    public final int k(Object r2) {
        o0 r3 = (o0) r2;
        Intrinsics.checkNotNullParameter(r3, "value");
        int r0 = j0.b;
        return j0.a.a(r3.getValue());
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void f(j0 r2, Object r3) {
        o0 r4 = (o0) r3;
        Intrinsics.checkNotNullParameter(r2, "writer");
        Intrinsics.checkNotNullParameter(r4, "value");
        r2.c(r4.getValue());
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void g(n0 r2, Object r3) {
        o0 r4 = (o0) r3;
        Intrinsics.checkNotNullParameter(r2, "writer");
        Intrinsics.checkNotNullParameter(r4, "value");
        r2.h(r4.getValue());
    }

    public d(KClass<E> r2, Syntax r3, E r4) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "syntax");
        super(FieldEncoding.VARINT, r2, r3, r4);
    }
}
