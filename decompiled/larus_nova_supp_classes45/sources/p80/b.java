package p80;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b<T, R> implements ObservableTransformer<T, T> {
    public final Observable<R> a;
    public final R b;

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "UntilEventObservableTransformer{lifecycle=" + this.a + ", event=" + this.b + '}';
    }

    public final ObservableSource<T> apply(Observable<T> r4) {
        Observable<R> r0 = this.a;
        final R r1 = this.b;
        return r4.takeUntil(r0.filter(new a(r1)).take(1));
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if (r4 != null) goto L8;
    L15:
        return false;
    L8:
        if (b.class != r4.getClass()) goto L15;
        b r5 = (b) r4;
        if (this.a.equals(r5.a) == true) goto L14;
        return false;
    L14:
        return this.b.equals(r5.b);
    }

    public b(Observable<R> r1, R r2) {
        this.a = r1;
        this.b = r2;
    }
}
