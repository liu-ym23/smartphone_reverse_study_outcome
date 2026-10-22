package com.lark.wire;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class x extends ProtoAdapter<List<?>> {
    @Override // com.lark.wire.ProtoAdapter
    public final List<?> b(h0 r5) {
        Intrinsics.checkNotNullParameter(r5, "reader");
        ArrayList r0 = new ArrayList();
        int r1 = r5.h();
    L3:
        int r2 = r5.nextTag();
        if (r2 == (-1)) goto L9;
        if (r2 != 1) goto L7;
        r0.add(ProtoAdapter.u.b(r5));
        goto L3
    L7:
        r5.b();
        goto L3
    L9:
        r5.k(r1);
        return r0;
    }

    @Override // com.lark.wire.ProtoAdapter
    public final List<?> c(g0 r6) {
        Intrinsics.checkNotNullParameter(r6, "reader");
        ArrayList r0 = new ArrayList();
        long r1 = r6.c();
    L3:
        int r3 = r6.e();
        if (r3 == (-1)) goto L9;
        if (r3 != 1) goto L7;
        r0.add(ProtoAdapter.u.c(r6));
        goto L3
    L7:
        r6.m();
        goto L3
    L9:
        r6.d(r1);
        return r0;
    }

    @Override // com.lark.wire.ProtoAdapter
    public final int k(List<?> r5) {
        List<?> r6 = r5;
        int r0 = 0;
        if (r6 == null) goto L9;
        Iterator<?> r7 = r6.iterator();
    L7:
        if (r7.hasNext() == false) goto L9;
        Object r1 = r7.next();
        r0 = r0 + ProtoAdapter.u.l(1, r1);
    L9:
        return r0;
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void f(j0 r4, List<?> r5) {
        List<?> r6 = r5;
        Intrinsics.checkNotNullParameter(r4, "writer");
        if (r6 == null) goto L9;
        Iterator<?> r7 = r6.iterator();
    L7:
        if (r7.hasNext() == false) goto L11;
        Object r0 = r7.next();
        ProtoAdapter.u.i(r4, 1, r0);
        goto L7
    L11:
        return;
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void g(n0 r5, List<?> r6) {
        List<?> r7 = r6;
        Intrinsics.checkNotNullParameter(r5, "writer");
        if (r7 == null) goto L9;
        int r0 = r7.size() - 1;
    L7:
        if ((-1) >= r0) goto L11;
        ProtoAdapter.u.j(r5, 1, ListProtector.get(r7, r0));
        r0 = r0 - 1;
        goto L7
    L11:
        return;
    }

    public x(FieldEncoding r8, KClass<Map<?, ?>> r9, Syntax r10) {
        super(r8, r9, "type.googleapis.com/google.protobuf.ListValue", r10, null, 48);
    }
}
