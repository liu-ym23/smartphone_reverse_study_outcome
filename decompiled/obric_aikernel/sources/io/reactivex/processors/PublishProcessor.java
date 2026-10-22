package io.reactivex.processors;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.b;
import java.util.concurrent.atomic.AtomicLong;
import tc.c;
import tc.d;

/* JADX INFO: loaded from: classes2.dex */
public final class PublishProcessor<T> extends a<T> {

    static final class PublishSubscription<T> extends AtomicLong implements d {
        private static final long serialVersionUID = 3562861878281475070L;
        final c<? super T> downstream;
        final PublishProcessor<T> parent;

        PublishSubscription(c<? super T> r10, PublishProcessor<T> r11) {
            this.downstream = r10;
        }

        @Override // tc.d
        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) goto L6;
            return;
        L6:
            throw null;
        }

        public boolean isCancelled() {
            if (get() != Long.MIN_VALUE) goto L5;
            return true;
        L5:
            return false;
        }

        boolean isFull() {
            if (get() != 0) goto L5;
            return true;
        L5:
            return false;
        }

        public void onComplete() {
            if (get() == Long.MIN_VALUE) goto L6;
            this.downstream.onComplete();
            return;
        }

        public void onError(Throwable r10) {
            if (get() == Long.MIN_VALUE) goto L5;
            this.downstream.onError(r10);
            return;
        L5:
            dc.a.n(r10);
        }

        public void onNext(T r10) {
            long r11 = get();
            if (r11 != Long.MIN_VALUE) goto L6;
            return;
        L6:
            if (r11 == 0) goto L8;
            this.downstream.onNext(r10);
            b.f(this, 1);
            return;
        L8:
            cancel();
            this.downstream.onError(new MissingBackpressureException("Could not emit value due to lack of requests"));
        }

        @Override // tc.d
        public void request(long r10) {
            if (SubscriptionHelper.validate(r10) == false) goto L6;
            b.b(this, r10);
            return;
        }
    }
}
