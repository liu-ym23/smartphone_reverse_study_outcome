package com.lark.wire;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class y extends ProtoAdapter<Map<String, ?>> {
    @Override // com.lark.wire.ProtoAdapter
    public final Map<String, ?> b(h0 r11) {
        Intrinsics.checkNotNullParameter(r11, "reader");
        LinkedHashMap r1 = new LinkedHashMap();
        int r2 = r11.h();
    L3:
        int r3 = r11.nextTag();
        if (r3 == (-1)) goto L20;
        if (r3 != 1) goto L7;
        int r4 = r11.h();
        String r6 = null;
        Object r7 = null;
    L9:
        int r8 = r11.nextTag();
        if (r8 == (-1)) goto L17;
        if (r8 != 1) goto L13;
        ProtoAdapter.q.getClass();
        Intrinsics.checkNotNullParameter(r11, "reader");
        r6 = r11.e();
        goto L9
    L13:
        if (r8 != 2) goto L14;
        r7 = ProtoAdapter.u.b(r11);
        goto L9
    L14:
        r11.m(r8);
        goto L9
    L17:
        r11.k(r4);
        if (r6 == null) goto L3;
        r1.put(r6, r7);
        goto L3
    L7:
        r11.b();
        goto L3
    L20:
        r11.k(r2);
        return r1;
    }

    @Override // com.lark.wire.ProtoAdapter
    public final Map<String, ?> c(g0 r13) {
        Intrinsics.checkNotNullParameter(r13, "reader");
        LinkedHashMap r1 = new LinkedHashMap();
        long r2 = r13.c();
    L3:
        int r4 = r13.e();
        if (r4 == (-1)) goto L20;
        if (r4 != 1) goto L7;
        long r7 = r13.c();
        String r5 = null;
        Object r9 = null;
    L9:
        int r10 = r13.e();
        if (r10 == (-1)) goto L17;
        if (r10 != 1) goto L13;
        ProtoAdapter.q.getClass();
        Intrinsics.checkNotNullParameter(r13, "reader");
        r5 = r13.i();
        goto L9
    L13:
        if (r10 != 2) goto L14;
        r9 = ProtoAdapter.u.c(r13);
        goto L9
    L14:
        r13.j(r10);
        goto L9
    L17:
        r13.d(r7);
        if (r5 == null) goto L3;
        r1.put(r5, r9);
        goto L3
    L7:
        r13.m();
        goto L3
    L20:
        r13.d(r2);
        return r1;
    }

    @Override // com.lark.wire.ProtoAdapter
    public final int k(Map<String, ?> r6) {
        Map<String, ?> r7 = r6;
        int r0 = 0;
        if (r7 == null) goto L9;
        Iterator<Map.Entry<String, ?>> r8 = r7.entrySet().iterator();
    L7:
        if (r8.hasNext() == false) goto L9;
        Map.Entry<String, ?> r1 = r8.next();
        String r2 = r1.getKey();
        Object r3 = r1.getValue();
        int r4 = ProtoAdapter.q.l(1, r2) + ProtoAdapter.u.l(2, r3);
        int r5 = j0.b;
        FieldEncoding r9 = FieldEncoding.VARINT;
        Intrinsics.checkNotNullParameter(r9, "fieldEncoding");
        r0 = r0 + ((j0.a.a(r9.getValue$wire_runtime() | 8) + j0.a.a(r4)) + r4);
    L9:
        return r0;
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void f(j0 r9, Map<String, ?> r10) {
        Map<String, ?> r11 = r10;
        Intrinsics.checkNotNullParameter(r9, "writer");
        if (r11 == null) goto L9;
        Iterator<Map.Entry<String, ?>> r12 = r11.entrySet().iterator();
    L7:
        if (r12.hasNext() == false) goto L11;
        Map.Entry<String, ?> r0 = r12.next();
        String r1 = r0.getKey();
        Object r2 = r0.getValue();
        w r3 = ProtoAdapter.q;
        int r4 = r3.l(1, r1);
        a0 r5 = ProtoAdapter.u;
        int r6 = r4 + r5.l(2, r2);
        r9.b(1, FieldEncoding.LENGTH_DELIMITED);
        r9.c(r6);
        r3.i(r9, 1, r1);
        r5.i(r9, 2, r2);
        goto L7
    L11:
        return;
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void g(n0 r8, Map<String, ?> r9) {
        Map<String, ?> r10 = r9;
        Intrinsics.checkNotNullParameter(r8, "writer");
        if (r10 == null) goto L8;
        int r0 = 0;
        Map.Entry[] r11 = (Map.Entry[]) r10.entrySet().toArray(new Map.Entry[0]);
        ArraysKt.reverse(r11);
        int r1 = r11.length;
    L6:
        if (r0 >= r1) goto L10;
        Map.Entry r2 = r11[r0];
        String r3 = (String) r2.getKey();
        Object r4 = r2.getValue();
        int r5 = r8.b();
        ProtoAdapter.u.j(r8, 2, r4);
        ProtoAdapter.q.j(r8, 1, r3);
        r8.h(r8.b() - r5);
        r8.g(1, FieldEncoding.LENGTH_DELIMITED);
        r0 = r0 + 1;
        goto L6
    L10:
        return;
    }

    public y(FieldEncoding r8, KClass<Map<?, ?>> r9, Syntax r10) {
        super(r8, r9, "type.googleapis.com/google.protobuf.Struct", r10, null, 48);
    }
}
