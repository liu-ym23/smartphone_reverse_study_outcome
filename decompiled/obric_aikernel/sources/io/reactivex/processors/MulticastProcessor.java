package io.reactivex.processors;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import tc.c;
import tc.d;

/* JADX INFO: loaded from: classes2.dex */
public final class MulticastProcessor<T> extends a<T> {

    static final class MulticastSubscription<T> extends AtomicLong implements d {
        private static final long serialVersionUID = -363282618957264509L;
        final c<? super T> downstream;
        long emitted;
        final MulticastProcessor<T> parent;

        MulticastSubscription(c<? super T> r10, MulticastProcessor<T> r11) {
            this.downstream = r10;
        }

        @Override // tc.d
        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) goto L6;
            return;
        L6:
            throw null;
        }

        void onComplete() {
            if (get() == Long.MIN_VALUE) goto L6;
            this.downstream.onComplete();
            return;
        }

        void onError(Throwable r10) {
            if (get() == Long.MIN_VALUE) goto L6;
            this.downstream.onError(r10);
            return;
        }

        void onNext(T r10) {
            if (get() == Long.MIN_VALUE) goto L6;
            this.emitted++;
            this.downstream.onNext(r10);
            return;
        }

        @Override // tc.d
        public void request(long r10) {
            if (SubscriptionHelper.validate(r10) == false) goto L18;
        L4:
            long r11 = get();
            if (r11 == Long.MIN_VALUE) goto L23;
            long r12 = Long.MAX_VALUE;
            if (r11 == Long.MAX_VALUE) goto L24;
            long r13 = r11 + r10;
            if (r13 < 0) goto L14;
            r12 = r13;
        L14:
            if (compareAndSet(r11, r12) == false) goto L4;
            throw null;
        L24:
            return;
        L23:
            return;
        }
    }
}
