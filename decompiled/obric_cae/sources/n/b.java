package n;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class b<K, V> extends h<K, V> implements Map<K, V> {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public a f9358r;

    public b() {
    }

    public b(b r8) {
        if (r8 == null) goto L10;
        int r10 = r8.f9401m;
        c(this.f9401m + r10);
        int r11 = 0;
        if (this.f9401m != 0) goto L8;
        if (r10 <= 0) goto L12;
        System.arraycopy(r8.f9399a, 0, this.f9399a, 0, r10);
        System.arraycopy(r8.f9400b, 0, this.f9400b, 0, r10 << 1);
        this.f9401m = r10;
        return;
    L12:
        return;
    L8:
        if (r11 >= r10) goto L14;
        put(r8.i(r11), r8.k(r11));
        r11 = r11 + 1;
        goto L8
    L14:
        return;
    }

    @Override // java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        if (this.f9358r != null) goto L5;
        this.f9358r = new a(this);
    L5:
        a r8 = this.f9358r;
        if (r8.f9380a != null) goto L9;
        r8.f9380a = new g.b(r8);
    L9:
        return r8.f9380a;
    }

    @Override // java.util.Map
    public final Set<K> keySet() {
        if (this.f9358r != null) goto L5;
        this.f9358r = new a(this);
    L5:
        a r8 = this.f9358r;
        if (r8.f9381b != null) goto L9;
        r8.f9381b = new g.c(r8);
    L9:
        return r8.f9381b;
    }

    @Override // java.util.Map
    public final void putAll(Map<? extends K, ? extends V> r8) {
        int r10 = this.f9401m;
        c(r8.size() + r10);
        Iterator<Map.Entry<? extends K, ? extends V>> r11 = r8.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Map.Entry<? extends K, ? extends V> r12 = r11.next();
        put(r12.getKey(), r12.getValue());
        goto L4
    }

    @Override // java.util.Map
    public final Collection<V> values() {
        if (this.f9358r != null) goto L5;
        this.f9358r = new a(this);
    L5:
        a r8 = this.f9358r;
        if (r8.f9382c != null) goto L9;
        r8.f9382c = new g.e(r8);
    L9:
        return r8.f9382c;
    }
}
