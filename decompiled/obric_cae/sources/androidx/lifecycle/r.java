package androidx.lifecycle;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class r<T> extends t<T> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final j.b<LiveData<?>, a<?>> f2189l;

    public static class a<V> implements u<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LiveData<V> f2190a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final u<? super V> f2191b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f2192c;

        public a(LiveData r8, s1.i r10) {
            this.f2192c = -1;
            this.f2190a = r8;
            this.f2191b = r10;
        }

        @Override // androidx.lifecycle.u
        public final void a(V r8) {
            int r10 = this.f2192c;
            int r11 = this.f2190a.f2104g;
            if (r10 == r11) goto L6;
            this.f2192c = r11;
            this.f2191b.a(r8);
            return;
        }
    }

    public r() {
        this.f2189l = new j.b();
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // androidx.lifecycle.LiveData
    public final void e() {
        Iterator<Map.Entry<LiveData<?>, a<?>>> r8 = this.f2189l.iterator();
    L3:
        j.b.e r10 = (j.b.e) r8;
        if (r10.hasNext() == false) goto L6;
        a r11 = (a) ((Map.Entry) r10.next()).getValue();
        r11.f2190a.d(r11);
        goto L3
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // androidx.lifecycle.LiveData
    public final void f() {
        Iterator<Map.Entry<LiveData<?>, a<?>>> r8 = this.f2189l.iterator();
    L3:
        j.b.e r10 = (j.b.e) r8;
        if (r10.hasNext() == false) goto L6;
        a r11 = (a) ((Map.Entry) r10.next()).getValue();
        r11.f2190a.h(r11);
        goto L3
    }
}
