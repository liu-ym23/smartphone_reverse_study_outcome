package io.reactivex.internal.subscriptions;

import io.reactivex.internal.functions.a;
import io.reactivex.internal.util.b;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import tc.d;

/* JADX INFO: loaded from: classes2.dex */
public class SubscriptionArbiter extends AtomicInteger implements d {
    private static final long serialVersionUID = -2189523197179400958L;
    d actual;
    final boolean cancelOnReplace;
    volatile boolean cancelled;
    final AtomicLong missedProduced;
    final AtomicLong missedRequested;
    final AtomicReference<d> missedSubscription;
    long requested;
    protected boolean unbounded;

    public SubscriptionArbiter(boolean r10) {
        this.cancelOnReplace = r10;
        this.missedSubscription = new AtomicReference();
        this.missedRequested = new AtomicLong();
        this.missedProduced = new AtomicLong();
    }

    public void cancel() {
        if (this.cancelled == true) goto L6;
        this.cancelled = true;
        drain();
        return;
    }

    final void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        drainLoop();
    }

    final void drainLoop() {
        int r10 = 1;
        d r11 = null;
        long r12 = 0;
    L3:
        d r13 = this.missedSubscription.get();
        if (r13 == null) goto L6;
        r13 = this.missedSubscription.getAndSet(null);
    L6:
        long r14 = this.missedRequested.get();
        if (r14 == 0) goto L9;
        r14 = this.missedRequested.getAndSet(0);
    L9:
        long r15 = this.missedProduced.get();
        if (r15 == 0) goto L12;
        r15 = this.missedProduced.getAndSet(0);
    L12:
        d r16 = this.actual;
        if (this.cancelled == false) goto L18;
        if (r16 == null) goto L16;
        r16.cancel();
        this.actual = null;
    L16:
        if (r13 == null) goto L38;
        r13.cancel();
    L38:
        r10 = addAndGet(-r10);
        if (r10 != 0) goto L3;
        if (r12 == 0) goto L46;
        r11.request(r12);
        return;
    L46:
        return;
    L18:
        long r17 = this.requested;
        if (r17 == Long.MAX_VALUE) goto L26;
        r17 = b.c(r17, r14);
        if (r17 == Long.MAX_VALUE) goto L25;
        r17 = r17 - r15;
        if (r17 >= 0) goto L25;
        SubscriptionHelper.reportMoreProduced(r17);
        r17 = 0;
    L25:
        this.requested = r17;
    L26:
        if (r13 == null) goto L34;
        if (r16 != null) goto L29;
    L31:
        this.actual = r13;
        if (r17 == 0) goto L38;
        r12 = b.c(r12, r17);
        r11 = r13;
        goto L38
    L29:
        if (this.cancelOnReplace == false) goto L31;
        r16.cancel();
        goto L31
    L34:
        if (r16 == null) goto L38;
        if (r14 == 0) goto L38;
        r12 = b.c(r12, r14);
        r11 = r16;
        goto L38
    }

    public final boolean isCancelled() {
        return this.cancelled;
    }

    public final boolean isUnbounded() {
        return this.unbounded;
    }

    public final void produced(long r10) {
        if (this.unbounded == false) goto L6;
        return;
    L6:
        if (get() == 0) goto L8;
    L20:
        b.a(this.missedProduced, r10);
        drain();
        return;
    L8:
        if (compareAndSet(0, 1) == false) goto L20;
        long r11 = this.requested;
        if (r11 == Long.MAX_VALUE) goto L16;
        long r12 = r11 - r10;
        if (r12 >= 0) goto L14;
        SubscriptionHelper.reportMoreProduced(r12);
        r12 = 0;
    L14:
        this.requested = r12;
    L16:
        if (decrementAndGet() != 0) goto L18;
        return;
    L18:
        drainLoop();
    }

    @Override // tc.d
    public final void request(long r10) {
        if (SubscriptionHelper.validate(r10) == true) goto L5;
        return;
    L5:
        if (this.unbounded == false) goto L8;
        return;
    L8:
        if (get() == 0) goto L10;
    L22:
        b.a(this.missedRequested, r10);
        drain();
        return;
    L10:
        if (compareAndSet(0, 1) == false) goto L22;
        long r11 = this.requested;
        if (r11 == Long.MAX_VALUE) goto L16;
        long r12 = b.c(r11, r10);
        this.requested = r12;
        if (r12 != Long.MAX_VALUE) goto L16;
        this.unbounded = true;
    L16:
        d r13 = this.actual;
        if (decrementAndGet() == 0) goto L19;
        drainLoop();
    L19:
        if (r13 == null) goto L24;
        r13.request(r10);
        return;
    }

    public final void setSubscription(d r10) {
        if (this.cancelled == false) goto L6;
        r10.cancel();
        return;
    L6:
        a.d(r10, "s is null");
        if (get() == 0) goto L9;
    L22:
        d r11 = this.missedSubscription.getAndSet(r10);
        if (r11 != null) goto L25;
    L27:
        drain();
        return;
    L25:
        if (this.cancelOnReplace == false) goto L27;
        r11.cancel();
        goto L27
    L9:
        if (compareAndSet(0, 1) == false) goto L22;
        d r12 = this.actual;
        if (r12 != null) goto L13;
    L15:
        this.actual = r10;
        long r13 = this.requested;
        if (decrementAndGet() == 0) goto L19;
        drainLoop();
    L19:
        if (r13 == 0) goto L29;
        r10.request(r13);
        return;
    L29:
        return;
    L13:
        if (this.cancelOnReplace == false) goto L15;
        r12.cancel();
        goto L15
    }
}
