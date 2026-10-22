package com.lark.wire;

import java.util.Iterator;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class j<K, V> extends ProtoAdapter<Map<K, ? extends V>> {
    public final i<K, V> v;

    @Override // com.lark.wire.ProtoAdapter
    public final Object b(h0 r7) {
        Intrinsics.checkNotNullParameter(r7, "reader");
        i<K, V> r0 = this.v;
        K r1 = r0.v.e;
        V r2 = r0.w.e;
        int r3 = r7.h();
    L3:
        int r4 = r7.nextTag();
        boolean r5 = true;
        if (r4 == (-1)) goto L11;
        if (r4 != 1) goto L7;
        r1 = this.v.v.b(r7);
        goto L3
    L7:
        if (r4 != 2) goto L3;
        r2 = this.v.w.b(r7);
        goto L3
    L11:
        r7.k(r3);
        if (r1 == null) goto L14;
        boolean r6 = true;
    L15:
        if (r6 == false) goto L25;
        if (r2 != null) goto L19;
        r5 = false;
    L19:
        if (r5 == false) goto L23;
        return MapsKt.mapOf(TuplesKt.to(r1, r2));
    L23:
        throw new IllegalStateException("Map entry with null value".toString());
    L25:
        throw new IllegalStateException("Map entry with null key".toString());
    L14:
        r6 = false;
        goto L15
    }

    @Override // com.lark.wire.ProtoAdapter
    public final Object c(g0 r8) {
        Intrinsics.checkNotNullParameter(r8, "reader");
        i<K, V> r0 = this.v;
        K r1 = r0.v.e;
        V r2 = r0.w.e;
        long r3 = r8.c();
    L3:
        int r4 = r8.e();
        boolean r6 = true;
        if (r4 == (-1)) goto L11;
        if (r4 != 1) goto L7;
        r1 = this.v.v.c(r8);
        goto L3
    L7:
        if (r4 != 2) goto L3;
        r2 = this.v.w.c(r8);
        goto L3
    L11:
        r8.d(r3);
        if (r1 == null) goto L14;
        boolean r5 = true;
    L15:
        if (r5 == false) goto L25;
        if (r2 != null) goto L19;
        r6 = false;
    L19:
        if (r6 == false) goto L23;
        return MapsKt.mapOf(TuplesKt.to(r1, r2));
    L23:
        throw new IllegalStateException("Map entry with null value".toString());
    L25:
        throw new IllegalStateException("Map entry with null key".toString());
    L14:
        r5 = false;
        goto L15
    }

    @Override // com.lark.wire.ProtoAdapter
    public final int k(Object r2) {
        Intrinsics.checkNotNullParameter((Map) r2, "value");
        throw new UnsupportedOperationException("Repeated values can only be sized with a tag.");
    }

    public j(ProtoAdapter<K> r9, ProtoAdapter<V> r10) {
        Intrinsics.checkNotNullParameter(r9, "keyAdapter");
        Intrinsics.checkNotNullParameter(r10, "valueAdapter");
        super(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Map.class), null, r10.d, MapsKt.emptyMap(), 32);
        this.v = new i(r9, r10);
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void f(j0 r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "writer");
        Intrinsics.checkNotNullParameter((Map) r3, "value");
        throw new UnsupportedOperationException("Repeated values can only be encoded with a tag.");
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void g(n0 r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "writer");
        Intrinsics.checkNotNullParameter((Map) r3, "value");
        throw new UnsupportedOperationException("Repeated values can only be encoded with a tag.");
    }

    @Override // com.lark.wire.ProtoAdapter
    public final int l(int r4, Object r5) {
        Map r6 = (Map) r5;
        int r0 = 0;
        if (r6 == null) goto L9;
        Iterator<Map.Entry<K, V>> r7 = r6.entrySet().iterator();
    L7:
        if (r7.hasNext() == false) goto L9;
        Map.Entry<K, V> r1 = r7.next();
        r0 = r0 + this.v.l(r4, r1);
    L9:
        return r0;
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void i(j0 r3, int r4, Object r5) {
        Map r6 = (Map) r5;
        Intrinsics.checkNotNullParameter(r3, "writer");
        if (r6 == null) goto L9;
        Iterator<Map.Entry<K, V>> r7 = r6.entrySet().iterator();
    L7:
        if (r7.hasNext() == false) goto L11;
        Map.Entry<K, V> r0 = r7.next();
        this.v.i(r3, r4, r0);
        goto L7
    L11:
        return;
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void j(n0 r5, int r6, Object r7) {
        Map r8 = (Map) r7;
        Intrinsics.checkNotNullParameter(r5, "writer");
        if (r8 == null) goto L8;
        int r0 = 0;
        Map.Entry[] r9 = (Map.Entry[]) r8.entrySet().toArray(new Map.Entry[0]);
        ArraysKt.reverse(r9);
        int r1 = r9.length;
    L6:
        if (r0 >= r1) goto L10;
        Map.Entry r2 = r9[r0];
        this.v.j(r5, r6, r2);
        r0 = r0 + 1;
        goto L6
    L10:
        return;
    }
}
