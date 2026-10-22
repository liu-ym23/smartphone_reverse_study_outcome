package io.reactivex.internal.subscriptions;

import com.lynx.tasm.behavior.v0;
import io.reactivex.internal.functions.e;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import zu.d;

/* JADX INFO: loaded from: classes3.dex */
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

    public SubscriptionArbiter(boolean r5) {
        this.cancelOnReplace = r5;
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

    public final void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        drainLoop();
    }

    public final void drainLoop() {
        int r5 = 1;
        long r10 = 0;
        d r11 = null;
    L3:
        d r12 = this.missedSubscription.get();
        if (r12 == null) goto L6;
        r12 = this.missedSubscription.getAndSet(null);
    L6:
        long r13 = this.missedRequested.get();
        if (r13 == 0) goto L9;
        r13 = this.missedRequested.getAndSet(0);
    L9:
        long r14 = this.missedProduced.get();
        if (r14 == 0) goto L12;
        r14 = this.missedProduced.getAndSet(0);
    L12:
        d r15 = this.actual;
        if (this.cancelled == false) goto L18;
        if (r15 == null) goto L16;
        r15.cancel();
        this.actual = null;
    L16:
        if (r12 == null) goto L38;
        r12.cancel();
    L38:
        r5 = addAndGet(-r5);
        if (r5 != 0) goto L3;
        if (r10 == 0) goto L46;
        r11.request(r10);
        return;
    L46:
        return;
    L18:
        long r16 = this.requested;
        if (r16 == Long.MAX_VALUE) goto L26;
        r16 = v0.t(r16, r13);
        if (r16 == Long.MAX_VALUE) goto L25;
        r16 = r16 - r14;
        if (r16 >= 0) goto L25;
        SubscriptionHelper.reportMoreProduced(r16);
        r16 = 0;
    L25:
        this.requested = r16;
    L26:
        if (r12 == null) goto L34;
        if (r15 != null) goto L29;
    L31:
        this.actual = r12;
        if (r16 == 0) goto L38;
        r10 = v0.t(r10, r16);
        r11 = r12;
        goto L38
    L29:
        if (this.cancelOnReplace == false) goto L31;
        r15.cancel();
        goto L31
    L34:
        if (r15 == null) goto L38;
        if (r13 == 0) goto L38;
        r10 = v0.t(r10, r13);
        r11 = r15;
        goto L38
    }

    public final boolean isCancelled() {
        return this.cancelled;
    }

    public final boolean isUnbounded() {
        return this.unbounded;
    }

    public final void produced(long r5) {
        if (this.unbounded == false) goto L6;
        return;
    L6:
        if (get() == 0) goto L8;
    L20:
        v0.r(this.missedProduced, r5);
        drain();
        return;
    L8:
        if (compareAndSet(0, 1) == false) goto L20;
        long r10 = this.requested;
        if (r10 == Long.MAX_VALUE) goto L16;
        long r11 = r10 - r5;
        if (r11 >= 0) goto L14;
        SubscriptionHelper.reportMoreProduced(r11);
        r11 = 0;
    L14:
        this.requested = r11;
    L16:
        if (decrementAndGet() != 0) goto L18;
        return;
    L18:
        drainLoop();
    }

    @Override // zu.d
    public final void request(long r10) {
        if (SubscriptionHelper.validate(r10) == true) goto L5;
        return;
    L5:
        if (this.unbounded == false) goto L8;
        return;
    L8:
        if (get() == 0) goto L10;
    L22:
        v0.r(this.missedRequested, r10);
        drain();
        return;
    L10:
        if (compareAndSet(0, 1) == false) goto L22;
        long r5 = this.requested;
        if (r5 == Long.MAX_VALUE) goto L16;
        long r11 = v0.t(r5, r10);
        this.requested = r11;
        if (r11 != Long.MAX_VALUE) goto L16;
        this.unbounded = true;
    L16:
        d r12 = this.actual;
        if (decrementAndGet() == 0) goto L19;
        drainLoop();
    L19:
        if (r12 == null) goto L24;
        r12.request(r10);
        return;
    }

    public final void setSubscription(d r5) {
        if (this.cancelled == false) goto L6;
        r5.cancel();
        return;
    L6:
        e.d(r5, "s is null");
        if (get() == 0) goto L9;
    L22:
        d r10 = this.missedSubscription.getAndSet(r5);
        if (r10 != null) goto L25;
    L27:
        drain();
        return;
    L25:
        if (this.cancelOnReplace == false) goto L27;
        r10.cancel();
        goto L27
    L9:
        if (compareAndSet(0, 1) == false) goto L22;
        d r11 = this.actual;
        if (r11 != null) goto L13;
    L15:
        this.actual = r5;
        long r12 = this.requested;
        if (decrementAndGet() == 0) goto L19;
        drainLoop();
    L19:
        if (r12 == 0) goto L29;
        r5.request(r12);
        return;
    L29:
        return;
    L13:
        if (this.cancelOnReplace == false) goto L15;
        r11.cancel();
        goto L15
    }
}
