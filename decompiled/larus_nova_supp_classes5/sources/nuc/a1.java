package nuc;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import juc.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a1<K, V> extends k1<K, V, Map<K, ? extends V>, LinkedHashMap<K, V>> {
    public final z0 c;

    @Override // nuc.a
    public final Object a() {
        return new LinkedHashMap();
    }

    @Override // nuc.k1, juc.d, juc.n, juc.c
    public final luc.f getDescriptor() {
        return this.c;
    }

    @Override // nuc.a
    public final int b(Object r2) {
        LinkedHashMap r3 = (LinkedHashMap) r2;
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return r3.size() * 2;
    }

    @Override // nuc.a
    public final Iterator d(Object r2) {
        Map r3 = (Map) r2;
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return r3.entrySet().iterator();
    }

    @Override // nuc.a
    public final int e(Object r2) {
        Map r3 = (Map) r2;
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return r3.size();
    }

    @Override // nuc.a
    public final Object i(Object r2) {
        Intrinsics.checkNotNullParameter(null, "<this>");
        return new LinkedHashMap(null);
    }

    @Override // nuc.a
    public final Object j(Object r2) {
        LinkedHashMap r3 = (LinkedHashMap) r2;
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return r3;
    }

    public a1(d<K> r2, d<V> r3) {
        Intrinsics.checkNotNullParameter(r2, "kSerializer");
        Intrinsics.checkNotNullParameter(r3, "vSerializer");
        super(r2, r3);
        this.c = new z0(r2.getDescriptor(), r3.getDescriptor());
    }

    @Override // nuc.a
    public final void c(Object r1, int r2) {
        Intrinsics.checkNotNullParameter((LinkedHashMap) r1, "<this>");
    }
}
