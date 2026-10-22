package j;

import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class a<K, V> extends b<K, V> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final HashMap<K, b.c<K, V>> f8355o;

    public a() {
        this.f8355o = new HashMap();
    }

    @Override // j.b
    public final b.c<K, V> a(K r8) {
        return this.f8355o.get(r8);
    }

    @Override // j.b
    public final V b(K r8, V r10) {
        b.c<K, V> r11 = a(r8);
        if (r11 != null) goto L5;
        HashMap<K, b.c<K, V>> r12 = this.f8355o;
        b.c<K, V> r13 = new b.c(r8, r10);
        this.f8359n++;
        b.c<K, V> r14 = this.f8357b;
        if (r14 != null) goto L9;
        this.f8356a = r13;
    L10:
        this.f8357b = r13;
        r12.put(r8, r13);
        return null;
    L9:
        r14.f8362m = r13;
        r13.f8363n = r14;
        goto L10
    L5:
        return r11.f8361b;
    }

    @Override // j.b
    public final V c(K r8) {
        V r10 = (V) super.c(r8);
        this.f8355o.remove(r8);
        return r10;
    }
}
