package io.reactivex.internal.operators.single;

import io.reactivex.disposables.b;
import java.util.concurrent.atomic.AtomicBoolean;
import xb.q;
import xb.r;

/* JADX INFO: loaded from: classes2.dex */
public final class SingleCache<T> extends q<T> implements r<T> {

    static final class CacheDisposable<T> extends AtomicBoolean implements b {
        private static final long serialVersionUID = 7514387411091976596L;
        final r<? super T> downstream;
        final SingleCache<T> parent;

        CacheDisposable(r<? super T> r10, SingleCache<T> r11) {
            this.downstream = r10;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (compareAndSet(false, true) == true) goto L6;
            return;
        L6:
            throw null;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return get();
        }
    }
}
