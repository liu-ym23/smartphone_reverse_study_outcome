package io.reactivex.processors;

import com.lynx.tasm.behavior.v0;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
final class BehaviorProcessor$BehaviorSubscription<T> extends AtomicLong implements zu.d, io.reactivex.internal.util.a {
    private static final long serialVersionUID = 3293175281126227086L;
    volatile boolean cancelled;
    final zu.c downstream;
    boolean emitting;
    boolean fastPath;
    long index;
    boolean next;
    io.reactivex.internal.util.b queue;
    final b state;

    public BehaviorProcessor$BehaviorSubscription(zu.c r5, b r10) {
        this.downstream = r5;
    }

    @Override // zu.d
    public void cancel() {
        if (this.cancelled == false) goto L5;
        return;
    L5:
        this.cancelled = true;
        throw null;
    }

    public void emitFirst() {
        if (this.cancelled == false) goto L5;
        return;
    L5:
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L7:
        if (this.cancelled == false) goto L13;
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L13:
        if (this.next == false) goto L17;
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L17:
        throw null;     // Catch: Throwable -> L10
    }

    public void emitLoop() {
    L3:
        if (this.cancelled == true) goto L4;
        monitor-enter(this);
        io.reactivex.internal.util.b r5 = this.queue;     // Catch: Throwable -> L11
        if (r5 == null) goto L8;
        this.queue = null;     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        r5.b(this);
        goto L3
    L8:
        this.emitting = false;     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public void emitNext(Object r5, long r10) {
        if (this.cancelled == false) goto L6;
        return;
    L6:
        if (this.fastPath == true) goto L31;
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L9:
        if (this.cancelled == false) goto L15;
        monitor-exit(this);     // Catch: Throwable -> L12
        return;
    L15:
        if (this.index != r10) goto L19;
        monitor-exit(this);     // Catch: Throwable -> L12
        return;
    L19:
        if (this.emitting == false) goto L26;
        io.reactivex.internal.util.b r11 = this.queue;     // Catch: Throwable -> L12
        if (r11 != null) goto L23;
        r11 = new io.reactivex.internal.util.b();     // Catch: Throwable -> L12
        this.queue = r11;     // Catch: Throwable -> L12
    L23:
        r11.a(r5);     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
        return;
    L26:
        this.next = true;     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
        this.fastPath = true;
    L31:
        test(r5);
    }

    public boolean isFull() {
        if (get() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // zu.d
    public void request(long r5) {
        if (SubscriptionHelper.validate(r5) == false) goto L6;
        v0.r(this, r5);
        return;
    }

    @Override // pt.p
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
        long r5 = get();
        if (r5 == 0) goto L20;
        this.downstream.onNext(NotificationLite.getValue(r10));
        if (r5 == Long.MAX_VALUE) goto L22;
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
