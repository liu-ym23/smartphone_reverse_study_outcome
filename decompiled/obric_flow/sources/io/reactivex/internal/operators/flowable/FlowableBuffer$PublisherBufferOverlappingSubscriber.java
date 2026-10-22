package io.reactivex.internal.operators.flowable;

import com.lynx.tasm.behavior.v0;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableBuffer$PublisherBufferOverlappingSubscriber<T, C extends Collection<? super T>> extends AtomicLong implements mt.g, zu.d, pt.e {
    private static final long serialVersionUID = -7370244972039324525L;
    final Callable<C> bufferSupplier;
    final ArrayDeque<C> buffers;
    volatile boolean cancelled;
    boolean done;
    final zu.c downstream;
    int index;
    final AtomicBoolean once;
    long produced;
    final int size;
    final int skip;
    zu.d upstream;

    public FlowableBuffer$PublisherBufferOverlappingSubscriber(zu.c r5, int r10, int r11, Callable<C> r12) {
        this.downstream = r5;
        this.size = r10;
        this.skip = r11;
        this.bufferSupplier = r12;
        this.once = new AtomicBoolean();
        this.buffers = new ArrayDeque();
    }

    @Override // zu.d
    public void cancel() {
        this.cancelled = true;
        this.upstream.cancel();
    }

    @Override // pt.e
    public boolean getAsBoolean() {
        return this.cancelled;
    }

    @Override // zu.c
    public void onComplete() {
        if (this.done == false) goto L5;
        return;
    L5:
        this.done = true;
        long r5 = this.produced;
        if (r5 == 0) goto L8;
        v0.y(this, r5);
    L8:
        zu.c r10 = this.downstream;
        ArrayDeque<C> r11 = this.buffers;
        if (r11.isEmpty() == false) goto L12;
        r10.onComplete();
        return;
    L12:
        if (com.lynx.tasm.behavior.utils.d.n(get(), r10, r11, this, this) == true) goto L28;
    L14:
        long r12 = get();
        if ((r12 & Long.MIN_VALUE) != 0) goto L29;
        long r13 = Long.MIN_VALUE | r12;
        if (compareAndSet(r12, r13) == false) goto L14;
        if (r12 == 0) goto L27;
        com.lynx.tasm.behavior.utils.d.n(r13, r10, r11, this, this);
        return;
    L27:
        return;
    L29:
        return;
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        if (this.done == false) goto L6;
        wn.f.k(r5);
        return;
    L6:
        this.done = true;
        this.buffers.clear();
        this.downstream.onError(r5);
    }

    @Override // zu.c
    public void onNext(T r10) {
        if (this.done == false) goto L5;
        return;
    L5:
        ArrayDeque<C> r5 = this.buffers;
        int r11 = this.index;
        int r12 = r11 + 1;
        if (r11 == 0) goto L26;
    L12:
        Collection r13 = (Collection) r5.peek();
        if (r13 != null) goto L15;
    L17:
        Iterator r14 = r5.iterator();
    L19:
        if (r14.hasNext() == false) goto L22;
        ((Collection) r14.next()).add(r10);
        goto L19
    L22:
        if (r12 != this.skip) goto L24;
        r12 = 0;
    L24:
        this.index = r12;
        return;
    L15:
        if ((r13.size() + 1) != this.size) goto L17;
        r5.poll();
        r13.add(r10);
        this.produced++;
        this.downstream.onNext(r13);
        goto L17
    L26:
        C r15 = this.bufferSupplier.call();     // Catch: Throwable -> L9
        io.reactivex.internal.functions.e.d(r15, "The bufferSupplier returned a null buffer");     // Catch: Throwable -> L9
        r5.offer(r15);
    L9:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        cancel();
        onError(th);
    }

    @Override // zu.c
    public void onSubscribe(zu.d r5) {
        if (SubscriptionHelper.validate(this.upstream, r5) == false) goto L6;
        this.upstream = r5;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // zu.d
    public void request(long r12) {
        if (SubscriptionHelper.validate(r12) == false) goto L20;
        zu.c r5 = this.downstream;
        ArrayDeque<C> r10 = this.buffers;
    L5:
        long r11 = get();
        if (compareAndSet(r11, v0.t(Long.MAX_VALUE & r11, r12) | (r11 & Long.MIN_VALUE)) == false) goto L5;
        if (r11 != Long.MIN_VALUE) goto L12;
        com.lynx.tasm.behavior.utils.d.n(r12 | Long.MIN_VALUE, r5, r10, this, this);
        return;
    L12:
        if (this.once.get() == false) goto L14;
    L16:
        this.upstream.request(v0.x(this.skip, r12));
        return;
    L14:
        if (this.once.compareAndSet(false, true) == false) goto L16;
        this.upstream.request(v0.t(this.size, v0.x(this.skip, r12 - 1)));
        return;
    }
}
