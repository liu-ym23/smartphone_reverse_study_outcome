package io.reactivex.processors;

import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import tc.c;

/* JADX INFO: loaded from: classes2.dex */
public final class AsyncProcessor<T> extends a<T> {

    static final class AsyncSubscription<T> extends DeferredScalarSubscription<T> {
        private static final long serialVersionUID = 5629876084736248016L;
        final AsyncProcessor<T> parent;

        AsyncSubscription(c<? super T> r10, AsyncProcessor<T> r11) {
            super(r10);
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, io.reactivex.internal.subscriptions.BasicIntQueueSubscription, tc.d
        public void cancel() {
            if (super.tryCancel() == true) goto L6;
            return;
        L6:
            throw null;
        }

        void onComplete() {
            if (isCancelled() == true) goto L6;
            this.downstream.onComplete();
            return;
        }

        void onError(Throwable r10) {
            if (isCancelled() == false) goto L5;
            dc.a.n(r10);
            return;
        L5:
            this.downstream.onError(r10);
        }
    }
}
