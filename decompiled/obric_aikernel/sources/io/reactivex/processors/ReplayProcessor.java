package io.reactivex.processors;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.b;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import tc.c;
import tc.d;

/* JADX INFO: loaded from: classes2.dex */
public final class ReplayProcessor<T> extends a<T> {

    static final class Node<T> extends AtomicReference<Node<T>> {
        private static final long serialVersionUID = 6404226426336033100L;
        final T value;

        Node(T r10) {
            this.value = r10;
        }
    }

    static final class ReplaySubscription<T> extends AtomicInteger implements d {
        private static final long serialVersionUID = 466549804534799122L;
        volatile boolean cancelled;
        final c<? super T> downstream;
        long emitted;
        Object index;
        final AtomicLong requested;
        final ReplayProcessor<T> state;

        ReplaySubscription(c<? super T> r10, ReplayProcessor<T> r11) {
            this.downstream = r10;
            this.requested = new AtomicLong();
        }

        @Override // tc.d
        public void cancel() {
            if (this.cancelled == false) goto L5;
            return;
        L5:
            this.cancelled = true;
            throw null;
        }

        @Override // tc.d
        public void request(long r10) {
            if (SubscriptionHelper.validate(r10) == true) goto L5;
            return;
        L5:
            b.a(this.requested, r10);
            throw null;
        }
    }

    static final class TimedNode<T> extends AtomicReference<TimedNode<T>> {
        private static final long serialVersionUID = 6404226426336033100L;
        final long time;
        final T value;

        TimedNode(T r10, long r11) {
            this.value = r10;
            this.time = r11;
        }
    }
}
