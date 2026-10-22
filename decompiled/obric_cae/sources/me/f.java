package me;

import ge.l;
import java.util.Iterator;
import ne.i;

/* JADX INFO: loaded from: classes2.dex */
public final class f<T, R> implements b<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b<T> f9353a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l<T, R> f9354b;

    public static final class a implements Iterator<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator<T> f9355a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f<T, R> f9356b;

        public a(f<T, R> r8) {
            this.f9356b = r8;
            this.f9355a = r8.f9353a.iterator();
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f9355a.hasNext();
        }

        @Override // java.util.Iterator
        public final R next() {
            return (R) this.f9356b.f9354b.invoke(this.f9355a.next());
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public f(ne.a r8, i r10) {
        this.f9353a = r8;
        this.f9354b = r10;
    }

    @Override // me.b
    public final Iterator<R> iterator() {
        return new a(this);
    }
}
