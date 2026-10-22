package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public final class FlowableCache<T> extends io.reactivex.internal.operators.flowable.a<T, T> implements xb.g<T> {

    static final class CacheSubscription<T> extends AtomicInteger implements tc.d {
        private static final long serialVersionUID = 6770240836423125754L;
        final tc.c<? super T> downstream;
        long index;
        a<T> node;
        int offset;
        final FlowableCache<T> parent;
        final AtomicLong requested;

        CacheSubscription(tc.c<? super T> r10, FlowableCache<T> r11) {
            this.downstream = r10;
            throw null;
        }

        @Override // tc.d
        public void cancel() {
            if (this.requested.getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) goto L6;
            return;
        L6:
            throw null;
        }

        @Override // tc.d
        public void request(long r10) {
            if (SubscriptionHelper.validate(r10) == true) goto L5;
            return;
        L5:
            io.reactivex.internal.util.b.b(this.requested, r10);
            throw null;
        }
    }

    static final class a<T> {
    }
}
