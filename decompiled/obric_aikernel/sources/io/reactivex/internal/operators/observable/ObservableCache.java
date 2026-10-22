package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class ObservableCache<T> extends io.reactivex.internal.operators.observable.a<T, T> implements xb.o<T> {

    static final class CacheDisposable<T> extends AtomicInteger implements io.reactivex.disposables.b {
        private static final long serialVersionUID = 6770240836423125754L;
        volatile boolean disposed;
        final xb.o<? super T> downstream;
        long index;
        a<T> node;
        int offset;
        final ObservableCache<T> parent;

        CacheDisposable(xb.o<? super T> r10, ObservableCache<T> r11) {
            this.downstream = r10;
            throw null;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.disposed == false) goto L5;
            return;
        L5:
            this.disposed = true;
            throw null;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.disposed;
        }
    }

    static final class a<T> {
    }
}
