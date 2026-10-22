package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Publisher;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableZip$ZipCoordinator<T, R> extends AtomicInteger implements tc.d {
    private static final long serialVersionUID = -2434867452883857743L;
    volatile boolean cancelled;
    final Object[] current;
    final boolean delayErrors;
    final tc.c<? super R> downstream;
    final AtomicThrowable errors;
    final AtomicLong requested;
    final FlowableZip$ZipSubscriber<T, R>[] subscribers;
    final zb.h<? super Object[], ? extends R> zipper;

    FlowableZip$ZipCoordinator(tc.c<? super R> r10, zb.h<? super Object[], ? extends R> r11, int r12, int r13, boolean r14) {
        this.downstream = r10;
        this.zipper = r11;
        this.delayErrors = r14;
        FlowableZip$ZipSubscriber<T, R>[] r15 = new FlowableZip$ZipSubscriber[r12];
        int r16 = 0;
    L3:
        if (r16 >= r12) goto L5;
        r15[r16] = new FlowableZip$ZipSubscriber(this, r13);
        r16 = r16 + 1;
        goto L3
    L5:
        this.current = new Object[r12];
        this.subscribers = r15;
        this.requested = new AtomicLong();
        this.errors = new AtomicThrowable();
    }

    @Override // tc.d
    public void cancel() {
        if (this.cancelled == true) goto L6;
        this.cancelled = true;
        cancelAll();
        return;
    }

    void cancelAll() {
        FlowableZip$ZipSubscriber<T, R>[] r10 = this.subscribers;
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r10[r12].cancel();
        r12 = r12 + 1;
        goto L3
    }

    void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        tc.c<? super R> r10 = this.downstream;
        FlowableZip$ZipSubscriber<T, R>[] r11 = this.subscribers;
        int r12 = r11.length;
        Object[] r13 = this.current;
        int r14 = 1;
    L6:
        long r15 = this.requested.get();
        long r16 = 0;
    L8:
        if (r15 == r16) goto L52;
        if (this.cancelled == true) goto L11;
        if (this.delayErrors == false) goto L15;
    L19:
        boolean r17 = false;
        int r18 = 0;
    L20:
        if (r18 >= r12) goto L46;
        FlowableZip$ZipSubscriber<T, R> r19 = r11[r18];
        if (r13[r18] != null) goto L45;
        boolean r110 = r19.done;     // Catch: Throwable -> L40
        bc.f<T> r111 = r19.queue;     // Catch: Throwable -> L40
        if (r111 == null) goto L26;
        T r112 = r111.poll();     // Catch: Throwable -> L40
    L27:
        if (r112 != null) goto L29;
        boolean r113 = true;
    L30:
        if (r110 == false) goto L37;
        if (r113 == false) goto L37;
        cancelAll();     // Catch: Throwable -> L40
        if (this.errors.get() == null) goto L35;
        r10.onError(this.errors.terminate());     // Catch: Throwable -> L40
        return;
    L35:
        r10.onComplete();     // Catch: Throwable -> L40
        return;
    L37:
        if (r113 == true) goto L44;
        r13[r18] = r112;     // Catch: Throwable -> L40
    L44:
        r17 = true;
        goto L45
    L29:
        r113 = false;
        goto L30
    L26:
        r112 = null;
    L40:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.errors.addThrowable(th);
        if (this.delayErrors == true) goto L44;
    L16:
        cancelAll();
    L17:
        r10.onError(this.errors.terminate());
        return;
    L45:
        r18 = r18 + 1;
        goto L20
    L46:
        if (r17 == true) goto L52;
        r10.onNext((Object) io.reactivex.internal.functions.a.d(this.zipper.apply(r13.clone()), "The zipper returned a null value"));
        r16 = r16 + 1;
        Arrays.fill(r13, null);
    L50:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        cancelAll();
        this.errors.addThrowable(th);
        goto L17
    L15:
        if (this.errors.get() == null) goto L19;
    L11:
        return;
    L52:
        if (r15 != r16) goto L88;
        if (this.cancelled == true) goto L55;
        if (this.delayErrors == false) goto L59;
    L61:
        int r20 = 0;
    L62:
        if (r20 >= r12) goto L88;
        FlowableZip$ZipSubscriber<T, R> r21 = r11[r20];
        if (r13[r20] != null) goto L86;
        boolean r114 = r21.done;     // Catch: Throwable -> L82
        bc.f<T> r22 = r21.queue;     // Catch: Throwable -> L82
        if (r22 == null) goto L68;
        T r23 = r22.poll();     // Catch: Throwable -> L82
    L69:
        if (r23 != null) goto L71;
        boolean r115 = true;
    L72:
        if (r114 == false) goto L79;
        if (r115 == false) goto L79;
        cancelAll();     // Catch: Throwable -> L82
        if (this.errors.get() == null) goto L77;
        r10.onError(this.errors.terminate());     // Catch: Throwable -> L82
        return;
    L77:
        r10.onComplete();     // Catch: Throwable -> L82
        return;
    L79:
        if (r115 == true) goto L86;
        r13[r20] = r23;     // Catch: Throwable -> L82
        goto L86
    L71:
        r115 = false;
        goto L72
    L68:
        r23 = null;
    L82:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.errors.addThrowable(th);
        if (this.delayErrors == false) goto L16;
    L86:
        r20 = r20 + 1;
        goto L62
    L59:
        if (this.errors.get() == null) goto L61;
    L55:
        return;
    L88:
        if (r16 == 0) goto L95;
        int r24 = r11.length;
        int r25 = 0;
    L90:
        if (r25 >= r24) goto L93;
        r11[r25].request(r16);
        r25 = r25 + 1;
        goto L90
    L93:
        if (r15 == Long.MAX_VALUE) goto L95;
        this.requested.addAndGet(-r16);
    L95:
        r14 = addAndGet(-r14);
        if (r14 != 0) goto L6;
    }

    void error(FlowableZip$ZipSubscriber<T, R> r10, Throwable r11) {
        if (this.errors.addThrowable(r11) == false) goto L5;
        r10.done = true;
        drain();
        return;
    L5:
        dc.a.n(r11);
    }

    @Override // tc.d
    public void request(long r10) {
        if (SubscriptionHelper.validate(r10) == false) goto L6;
        io.reactivex.internal.util.b.a(this.requested, r10);
        drain();
        return;
    }

    void subscribe(Publisher<? extends T>[] r10, int r11) {
        FlowableZip$ZipSubscriber<T, R>[] r12 = this.subscribers;
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L12;
        if (this.cancelled == true) goto L18;
        if (this.delayErrors == true) goto L11;
        if (this.errors.get() == null) goto L11;
        return;
    L11:
        r10[r13].subscribe(r12[r13]);
        r13 = r13 + 1;
        goto L3
    L18:
        return;
    }
}
