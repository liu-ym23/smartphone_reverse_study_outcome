package io.reactivex.subjects;

import io.reactivex.internal.observers.DeferredScalarDisposable;
import xb.o;

/* JADX INFO: loaded from: classes2.dex */
public final class AsyncSubject<T> extends a<T> {

    static final class AsyncDisposable<T> extends DeferredScalarDisposable<T> {
        private static final long serialVersionUID = 5629876084736248016L;
        final AsyncSubject<T> parent;

        AsyncDisposable(o<? super T> r10, AsyncSubject<T> r11) {
            super(r10);
        }

        @Override // io.reactivex.internal.observers.DeferredScalarDisposable, io.reactivex.internal.observers.BasicIntQueueDisposable, io.reactivex.disposables.b
        public void dispose() {
            if (super.tryDispose() == true) goto L6;
            return;
        L6:
            throw null;
        }

        void onComplete() {
            if (isDisposed() == true) goto L6;
            this.downstream.onComplete();
            return;
        }

        void onError(Throwable r10) {
            if (isDisposed() == false) goto L5;
            dc.a.n(r10);
            return;
        L5:
            this.downstream.onError(r10);
        }
    }
}
