package io.reactivex.processors;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.internal.util.b;
import java.util.concurrent.atomic.AtomicLong;
import tc.c;
import tc.d;

/* JADX INFO: loaded from: classes2.dex */
public final class BehaviorProcessor<T> extends a<T> {

    static final class BehaviorSubscription<T> extends AtomicLong implements d, io.reactivex.internal.util.a.InterfaceC0204a<Object> {
        private static final long serialVersionUID = 3293175281126227086L;
        volatile boolean cancelled;
        final c<? super T> downstream;
        boolean emitting;
        boolean fastPath;
        long index;
        boolean next;
        io.reactivex.internal.util.a<Object> queue;
        final BehaviorProcessor<T> state;

        BehaviorSubscription(c<? super T> r10, BehaviorProcessor<T> r11) {
            this.downstream = r10;
        }

        @Override // tc.d
        public void cancel() {
            if (this.cancelled == false) goto L5;
            return;
        L5:
            this.cancelled = true;
            throw null;
        }

        void emitFirst() {
            if (this.cancelled == false) goto L5;
            return;
        L5:
            monitor-enter(this);
        L16:
            th = move-exception;
            throw th;
        L7:
            if (this.cancelled == false) goto L11;
            monitor-exit(this);     // Catch: Throwable -> L16
            return;
        L11:
            if (this.next == false) goto L15;
            monitor-exit(this);     // Catch: Throwable -> L16
            return;
        L15:
            throw null;     // Catch: Throwable -> L16
        }

        void emitLoop() {
        L3:
            if (this.cancelled == true) goto L4;
            monitor-enter(this);
            io.reactivex.internal.util.a<Object> r10 = this.queue;     // Catch: Throwable -> L14
            if (r10 == null) goto L8;
            this.queue = null;     // Catch: Throwable -> L14
            monitor-exit(this);     // Catch: Throwable -> L14
            r10.b(this);
            goto L3
        L8:
            this.emitting = false;     // Catch: Throwable -> L14
            monitor-exit(this);     // Catch: Throwable -> L14
            return;
        L14:
            th = move-exception;
            throw th;
        }

        void emitNext(Object r10, long r11) {
            if (this.cancelled == false) goto L6;
            return;
        L6:
            if (this.fastPath == true) goto L30;
            monitor-enter(this);
        L27:
            th = move-exception;
            throw th;
        L9:
            if (this.cancelled == false) goto L13;
            monitor-exit(this);     // Catch: Throwable -> L27
            return;
        L13:
            if (this.index != r11) goto L17;
            monitor-exit(this);     // Catch: Throwable -> L27
            return;
        L17:
            if (this.emitting == false) goto L24;
            io.reactivex.internal.util.a<Object> r12 = this.queue;     // Catch: Throwable -> L27
            if (r12 != null) goto L21;
            r12 = new io.reactivex.internal.util.a(4);     // Catch: Throwable -> L27
            this.queue = r12;     // Catch: Throwable -> L27
        L21:
            r12.a(r10);     // Catch: Throwable -> L27
            monitor-exit(this);     // Catch: Throwable -> L27
            return;
        L24:
            this.next = true;     // Catch: Throwable -> L27
            monitor-exit(this);     // Catch: Throwable -> L27
            this.fastPath = true;
        L30:
            test(r10);
        }

        public boolean isFull() {
            if (get() != 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // tc.d
        public void request(long r10) {
            if (SubscriptionHelper.validate(r10) == false) goto L6;
            b.a(this, r10);
            return;
        }

        @Override // io.reactivex.internal.util.a.InterfaceC0204a, zb.i
        public boolean test(Object r10) {
            if (this.cancelled == false) goto L6;
            return true;
        L6:
            if (NotificationLite.isComplete(r10) == false) goto L10;
            this.downstream.onComplete();
            return true;
        L10:
            if (NotificationLite.isError(r10) == false) goto L13;
            this.downstream.onError(NotificationLite.getError(r10));
            return true;
        L13:
            long r11 = get();
            if (r11 == 0) goto L20;
            this.downstream.onNext((Object) NotificationLite.getValue(r10));
            if (r11 == Long.MAX_VALUE) goto L22;
            decrementAndGet();
            return false;
        L22:
            return false;
        L20:
            cancel();
            this.downstream.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
            return true;
        }
    }
}
