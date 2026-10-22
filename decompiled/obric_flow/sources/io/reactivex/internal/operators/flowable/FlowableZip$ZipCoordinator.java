package io.reactivex.internal.operators.flowable;

import com.lynx.tasm.behavior.v0;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableZip$ZipCoordinator<T, R> extends AtomicInteger implements zu.d {
    private static final long serialVersionUID = -2434867452883857743L;
    volatile boolean cancelled;
    final Object[] current;
    final boolean delayErrors;
    final zu.c downstream;
    final AtomicThrowable errors;
    final AtomicLong requested;
    final FlowableZip$ZipSubscriber<T, R>[] subscribers;
    final pt.o zipper;

    public FlowableZip$ZipCoordinator(zu.c r5, pt.o r10, int r11, int r12, boolean r13) {
        this.downstream = r5;
        this.zipper = r10;
        this.delayErrors = r13;
        FlowableZip$ZipSubscriber<T, R>[] r14 = new FlowableZip$ZipSubscriber[r11];
        int r15 = 0;
    L3:
        if (r15 >= r11) goto L5;
        r14[r15] = new FlowableZip$ZipSubscriber(this, r12);
        r15 = r15 + 1;
        goto L3
    L5:
        this.current = new Object[r11];
        this.subscribers = r14;
        this.requested = new AtomicLong();
        this.errors = new AtomicThrowable();
    }

    @Override // zu.d
    public void cancel() {
        if (this.cancelled == true) goto L6;
        this.cancelled = true;
        cancelAll();
        return;
    }

    public void cancelAll() {
        FlowableZip$ZipSubscriber<T, R>[] r5 = this.subscribers;
        int r10 = r5.length;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        r5[r11].cancel();
        r11 = r11 + 1;
        goto L3
    }

    public void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        zu.c r5 = this.downstream;
        FlowableZip$ZipSubscriber<T, R>[] r10 = this.subscribers;
        int r11 = r10.length;
        Object[] r12 = this.current;
        int r13 = 1;
    L6:
        long r14 = this.requested.get();
        long r15 = 0;
    L8:
        if (r14 == r15) goto L54;
        if (this.cancelled == true) goto L11;
        if (this.delayErrors == false) goto L15;
    L18:
        boolean r16 = false;
        int r17 = 0;
    L19:
        if (r17 >= r11) goto L47;
        FlowableZip$ZipSubscriber<T, R> r18 = r10[r17];
        if (r12[r17] != null) goto L46;
        boolean r19 = r18.done;     // Catch: Throwable -> L25
        rt.h r110 = r18.queue;     // Catch: Throwable -> L25
        if (r110 == null) goto L27;
        Object r111 = r110.poll();     // Catch: Throwable -> L25
    L28:
        if (r111 != null) goto L30;
        boolean r112 = true;
    L31:
        if (r19 == false) goto L38;
        if (r112 == false) goto L38;
        cancelAll();     // Catch: Throwable -> L25
        if (this.errors.get() == null) goto L36;
        r5.onError(this.errors.terminate());     // Catch: Throwable -> L25
        return;
    L36:
        r5.onComplete();     // Catch: Throwable -> L25
        return;
    L38:
        if (r112 == true) goto L45;
        r12[r17] = r111;     // Catch: Throwable -> L25
    L45:
        r16 = true;
        goto L46
    L30:
        r112 = false;
        goto L31
    L27:
        r111 = null;
    L25:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.errors.addThrowable(th);
        if (this.delayErrors == true) goto L45;
        cancelAll();
        r5.onError(this.errors.terminate());
        return;
    L46:
        r17 = r17 + 1;
        goto L19
    L47:
        if (r16 == true) goto L54;
        Object r20 = this.zipper.apply(r12.clone());     // Catch: Throwable -> L51
        io.reactivex.internal.functions.e.d(r20, "The zipper returned a null value");     // Catch: Throwable -> L51
        r5.onNext(r20);
        r15 = r15 + 1;
        Arrays.fill(r12, null);
    L51:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        cancelAll();
        this.errors.addThrowable(th);
        r5.onError(this.errors.terminate());
        return;
    L15:
        if (this.errors.get() == null) goto L18;
        cancelAll();
        r5.onError(this.errors.terminate());
        return;
    L11:
        return;
    L54:
        if (r14 != r15) goto L93;
        if (this.cancelled == true) goto L57;
        if (this.delayErrors == false) goto L61;
    L64:
        int r21 = 0;
    L65:
        if (r21 >= r11) goto L93;
        FlowableZip$ZipSubscriber<T, R> r22 = r10[r21];
        if (r12[r21] != null) goto L91;
        boolean r113 = r22.done;     // Catch: Throwable -> L71
        rt.h r23 = r22.queue;     // Catch: Throwable -> L71
        if (r23 == null) goto L73;
        Object r24 = r23.poll();     // Catch: Throwable -> L71
    L74:
        if (r24 != null) goto L76;
        boolean r114 = true;
    L77:
        if (r113 == false) goto L84;
        if (r114 == false) goto L84;
        cancelAll();     // Catch: Throwable -> L71
        if (this.errors.get() == null) goto L82;
        r5.onError(this.errors.terminate());     // Catch: Throwable -> L71
        return;
    L82:
        r5.onComplete();     // Catch: Throwable -> L71
        return;
    L84:
        if (r114 == true) goto L91;
        r12[r21] = r24;     // Catch: Throwable -> L71
        goto L91
    L76:
        r114 = false;
        goto L77
    L73:
        r24 = null;
    L71:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.errors.addThrowable(th);
        if (this.delayErrors == true) goto L91;
        cancelAll();
        r5.onError(this.errors.terminate());
        return;
    L91:
        r21 = r21 + 1;
        goto L65
    L61:
        if (this.errors.get() == null) goto L64;
        cancelAll();
        r5.onError(this.errors.terminate());
        return;
    L57:
        return;
    L93:
        if (r15 == 0) goto L100;
        int r25 = r10.length;
        int r26 = 0;
    L95:
        if (r26 >= r25) goto L98;
        r10[r26].request(r15);
        r26 = r26 + 1;
        goto L95
    L98:
        if (r14 == Long.MAX_VALUE) goto L100;
        this.requested.addAndGet(-r15);
    L100:
        r13 = addAndGet(-r13);
        if (r13 != 0) goto L6;
    }

    public void error(FlowableZip$ZipSubscriber<T, R> r5, Throwable r10) {
        if (this.errors.addThrowable(r10) == false) goto L5;
        r5.done = true;
        drain();
        return;
    L5:
        wn.f.k(r10);
    }

    @Override // zu.d
    public void request(long r5) {
        if (SubscriptionHelper.validate(r5) == false) goto L6;
        v0.r(this.requested, r5);
        drain();
        return;
    }

    public void subscribe(zu.b[] r5, int r10) {
        FlowableZip$ZipSubscriber<T, R>[] r11 = this.subscribers;
        int r12 = 0;
    L3:
        if (r12 >= r10) goto L12;
        if (this.cancelled == true) goto L18;
        if (this.delayErrors == true) goto L11;
        if (this.errors.get() == null) goto L11;
        return;
    L11:
        r5[r12].subscribe(r11[r12]);
        r12 = r12 + 1;
        goto L3
    L18:
        return;
    }
}
