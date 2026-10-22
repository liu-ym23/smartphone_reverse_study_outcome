package io.reactivex.subjects;

import io.reactivex.disposables.b;
import java.util.concurrent.atomic.AtomicBoolean;
import xb.o;

/* JADX INFO: loaded from: classes2.dex */
public final class PublishSubject<T> extends a<T> {

    static final class PublishDisposable<T> extends AtomicBoolean implements b {
        private static final long serialVersionUID = 3562861878281475070L;
        final o<? super T> downstream;
        final PublishSubject<T> parent;

        PublishDisposable(o<? super T> r10, PublishSubject<T> r11) {
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

        public void onComplete() {
            if (get() == true) goto L6;
            this.downstream.onComplete();
            return;
        }

        public void onError(Throwable r10) {
            if (get() == false) goto L5;
            dc.a.n(r10);
            return;
        L5:
            this.downstream.onError(r10);
        }

        public void onNext(T r10) {
            if (get() == true) goto L6;
            this.downstream.onNext(r10);
            return;
        }
    }
}
