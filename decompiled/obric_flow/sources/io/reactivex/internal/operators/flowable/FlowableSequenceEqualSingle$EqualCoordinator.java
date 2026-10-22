package io.reactivex.internal.operators.flowable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import mt.b0;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableSequenceEqualSingle$EqualCoordinator<T> extends AtomicInteger implements Disposable, t {
    private static final long serialVersionUID = -6178010334400373240L;
    final pt.d comparer;
    final b0 downstream;
    final AtomicThrowable error;
    final FlowableSequenceEqual$EqualSubscriber<T> first;
    final FlowableSequenceEqual$EqualSubscriber<T> second;
    T v1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    T f17653v2;

    public FlowableSequenceEqualSingle$EqualCoordinator(b0 r5, int r10, pt.d r11) {
        this.downstream = r5;
        this.comparer = r11;
        this.first = new FlowableSequenceEqual$EqualSubscriber(this, r10);
        this.second = new FlowableSequenceEqual$EqualSubscriber(this, r10);
        this.error = new AtomicThrowable();
    }

    public void cancelAndClear() {
        this.first.cancel();
        this.first.clear();
        this.second.cancel();
        this.second.clear();
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.first.cancel();
        this.second.cancel();
        if (getAndIncrement() != 0) goto L6;
        this.first.clear();
        this.second.clear();
        return;
    }

    @Override // io.reactivex.internal.operators.flowable.t
    public void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        int r5 = 1;
    L6:
        rt.h r10 = this.first.queue;
        rt.h r11 = this.second.queue;
        if (r10 == null) goto L60;
        if (r11 == null) goto L60;
    L10:
        if (isDisposed() == true) goto L11;
        if (this.error.get() != null) goto L15;
        boolean r12 = this.first.done;
        T r13 = this.v1;
        if (r13 == null) goto L74;
    L24:
        boolean r14 = false;
        if (r13 != null) goto L27;
        boolean r15 = true;
    L28:
        boolean r16 = this.second.done;
        T r17 = this.f17653v2;
        if (r17 == null) goto L72;
    L35:
        if (r17 != null) goto L37;
        r14 = true;
    L37:
        if (r12 == false) goto L43;
        if (r16 == false) goto L43;
        if (r15 == false) goto L43;
        if (r14 == false) goto L43;
        this.downstream.onSuccess(Boolean.TRUE);
        return;
    L43:
        if (r12 == false) goto L48;
        if (r16 == false) goto L48;
        if (r15 == r14) goto L48;
        cancelAndClear();
        this.downstream.onSuccess(Boolean.FALSE);
        return;
    L48:
        if (r15 == true) goto L67;
        if (r14 == true) goto L67;
        ((com.lynx.tasm.utils.c) this.comparer).getClass();     // Catch: Throwable -> L56
        if (io.reactivex.internal.functions.e.b(r13, r17) == false) goto L53;
        this.v1 = null;
        this.f17653v2 = null;
        this.first.request();
        this.second.request();
        goto L10
    L53:
        cancelAndClear();
        this.downstream.onSuccess(Boolean.FALSE);
        return;
    L56:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        cancelAndClear();
        this.error.addThrowable(th);
        this.downstream.onError(this.error.terminate());
        return;
    L67:
        r5 = addAndGet(-r5);
        if (r5 != 0) goto L6;
        return;
    L72:
        r17 = (T) r11.poll();
        this.f17653v2 = r17;
    L32:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        cancelAndClear();
        this.error.addThrowable(th);
        this.downstream.onError(this.error.terminate());
        return;
    L27:
        r15 = false;
        goto L28
    L74:
        r13 = (T) r10.poll();
        this.v1 = r13;
    L21:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        cancelAndClear();
        this.error.addThrowable(th);
        this.downstream.onError(this.error.terminate());
        return;
    L15:
        cancelAndClear();
        this.downstream.onError(this.error.terminate());
        return;
    L11:
        this.first.clear();
        this.second.clear();
        return;
    L60:
        if (isDisposed() == true) goto L61;
        if (this.error.get() == null) goto L67;
        cancelAndClear();
        this.downstream.onError(this.error.terminate());
        return;
    L61:
        this.first.clear();
        this.second.clear();
    }

    @Override // io.reactivex.internal.operators.flowable.t
    public void innerError(Throwable r5) {
        if (this.error.addThrowable(r5) == false) goto L5;
        drain();
        return;
    L5:
        wn.f.k(r5);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (this.first.get() != SubscriptionHelper.CANCELLED) goto L5;
        return true;
    L5:
        return false;
    }

    public void subscribe(zu.b r5, zu.b r10) {
        r5.subscribe(this.first);
        r10.subscribe(this.second);
    }
}
