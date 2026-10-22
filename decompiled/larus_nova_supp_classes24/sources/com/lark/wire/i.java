package com.lark.wire;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class i<K, V> extends ProtoAdapter<Map.Entry<? extends K, ? extends V>> {
    public final ProtoAdapter<K> v;
    public final ProtoAdapter<V> w;

    @Override // com.lark.wire.ProtoAdapter
    public final Object c(g0 r2) {
        Intrinsics.checkNotNullParameter(r2, "reader");
        throw new UnsupportedOperationException();
    }

    @Override // com.lark.wire.ProtoAdapter
    public final int k(Object r4) {
        Map.Entry r5 = (Map.Entry) r4;
        Intrinsics.checkNotNullParameter(r5, "value");
        return this.v.l(1, (K) r5.getKey()) + this.w.l(2, (V) r5.getValue());
    }

    public i(ProtoAdapter<K> r9, ProtoAdapter<V> r10) {
        Intrinsics.checkNotNullParameter(r9, "keyAdapter");
        Intrinsics.checkNotNullParameter(r10, "valueAdapter");
        super(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Map.Entry.class), null, r10.d, null, 48);
        this.v = r9;
        this.w = r10;
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void f(j0 r4, Object r5) {
        Map.Entry r6 = (Map.Entry) r5;
        Intrinsics.checkNotNullParameter(r4, "writer");
        Intrinsics.checkNotNullParameter(r6, "value");
        this.v.i(r4, 1, (K) r6.getKey());
        this.w.i(r4, 2, (V) r6.getValue());
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void g(n0 r4, Object r5) {
        Map.Entry r6 = (Map.Entry) r5;
        Intrinsics.checkNotNullParameter(r4, "writer");
        Intrinsics.checkNotNullParameter(r6, "value");
        this.w.j(r4, 2, (V) r6.getValue());
        this.v.j(r4, 1, (K) r6.getKey());
    }
}
