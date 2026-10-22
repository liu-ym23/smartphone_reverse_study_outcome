package io.reactivex.internal.operators.parallel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.schedulers.h;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.b;
import io.reactivex.j;
import io.reactivex.u;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.a.c;
import org.a.d;

/* JADX INFO: loaded from: classes6.dex */
public final class ParallelRunOn<T> extends io.reactivex.parallel.a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final io.reactivex.parallel.a<? extends T> f17046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final u f17047b;
    final int c;

    static abstract class BaseRunOnSubscriber<T> extends AtomicInteger implements j<T>, Runnable, d {
        private static final long serialVersionUID = 9222303586456402150L;
        volatile boolean cancelled;
        int consumed;
        volatile boolean done;
        Throwable error;
        final int limit;
        final int prefetch;
        final SpscArrayQueue<T> queue;
        final AtomicLong requested;
        d upstream;
        final u.c worker;

        BaseRunOnSubscriber(int r2, SpscArrayQueue<T> r3, u.c r4) {
            this.requested = new AtomicLong();
            this.prefetch = r2;
            this.queue = r3;
            this.limit = r2 - (r2 >> 2);
            this.worker = r4;
        }

        @Override // org.a.d
        public final void cancel() {
            if (this.cancelled == true) goto L8;
            this.cancelled = true;
            this.upstream.cancel();
            this.worker.dispose();
            if (getAndIncrement() != 0) goto L9;
            this.queue.clear();
            return;
        L9:
            return;
        }

        @Override // org.a.c
        public final void onComplete() {
            if (this.done == false) goto L5;
            return;
        L5:
            this.done = true;
            schedule();
        }

        @Override // org.a.c
        public final void onError(Throwable r2) {
            if (this.done == false) goto L6;
            io.reactivex.d.a.a(r2);
            return;
        L6:
            this.error = r2;
            this.done = true;
            schedule();
        }

        @Override // org.a.c
        public final void onNext(T r2) {
            if (this.done == false) goto L6;
            return;
        L6:
            if (this.queue.offer(r2) == true) goto L9;
            this.upstream.cancel();
            onError(new MissingBackpressureException("Queue is full?!"));
            return;
        L9:
            schedule();
        }

        @Override // org.a.d
        public final void request(long r2) {
            if (SubscriptionHelper.validate(r2) == false) goto L6;
            b.a(this.requested, r2);
            schedule();
            return;
        }

        final void schedule() {
            if (getAndIncrement() != 0) goto L6;
            this.worker.a(this);
            return;
        }
    }

    static final class RunOnConditionalSubscriber<T> extends BaseRunOnSubscriber<T> {
        private static final long serialVersionUID = 1075119423897941642L;
        final io.reactivex.internal.a.a<? super T> downstream;

        RunOnConditionalSubscriber(io.reactivex.internal.a.a<? super T> r3, int r4, SpscArrayQueue<T> r5, u.c r6) {
            io.reactivex.internal.a.a<? super T> r7 = (io.reactivex.internal.a.a) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.internal.a.a.class, "com.obric.memorydata.plugin");
            super(r4, r5, r6);
            this.downstream = r7;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(d r3) {
            d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
            if (SubscriptionHelper.validate(this.upstream, r4) == false) goto L6;
            this.upstream = r4;
            this.downstream.onSubscribe(this);
            r4.request(this.prefetch);
            return;
        }

        @Override // java.lang.Runnable
        public void run() {
            int r1 = this.consumed;
            SpscArrayQueue<T> r2 = this.queue;
            io.reactivex.internal.a.a<? super T> r3 = this.downstream;
            int r4 = this.limit;
            int r6 = 1;
        L3:
            long r7 = this.requested.get();
            long r11 = 0;
        L5:
            if (r11 == r7) goto L32;
            if (this.cancelled == true) goto L8;
            boolean r14 = this.done;
            if (r14 == false) goto L17;
            Throwable r15 = this.error;
            if (r15 == null) goto L17;
            r2.clear();
            r3.onError(r15);
        L15:
            this.worker.dispose();
            return;
        L17:
            T r16 = r2.poll();
            if (r16 != null) goto L20;
            boolean r17 = true;
        L21:
            if (r14 == false) goto L24;
            if (r17 == false) goto L24;
        L23:
            r3.onComplete();
        L24:
            if (r17 == true) goto L32;
            if (r3.tryOnNext(r16) == false) goto L29;
            r11 = r11 + 1;
        L29:
            r1 = r1 + 1;
            if (r1 != r4) goto L5;
            this.upstream.request(r1);
            r1 = 0;
            goto L5
        L20:
            r17 = false;
            goto L21
        L8:
            r2.clear();
            return;
        L32:
            if (r11 != r7) goto L46;
            if (this.cancelled == true) goto L35;
            if (this.done == false) goto L46;
            Throwable r13 = this.error;
            if (r13 != null) goto L41;
            if (r2.isEmpty() == false) goto L46;
        L41:
            r2.clear();
            r3.onError(r13);
            goto L15
        L35:
            r2.clear();
            return;
        L46:
            if (r11 != 0) goto L48;
        L50:
            int r8 = get();
            if (r8 == r6) goto L52;
            r6 = r8;
            goto L3
        L52:
            this.consumed = r1;
            r6 = addAndGet(-r6);
            if (r6 != 0) goto L3;
            return;
        L48:
            if (r7 == Long.MAX_VALUE) goto L50;
            this.requested.addAndGet(-r11);
            goto L50
        }
    }

    static final class RunOnSubscriber<T> extends BaseRunOnSubscriber<T> {
        private static final long serialVersionUID = 1075119423897941642L;
        final c<? super T> downstream;

        RunOnSubscriber(c<? super T> r3, int r4, SpscArrayQueue<T> r5, u.c r6) {
            c<? super T> r7 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
            super(r4, r5, r6);
            this.downstream = r7;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(d r3) {
            d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
            if (SubscriptionHelper.validate(this.upstream, r4) == false) goto L6;
            this.upstream = r4;
            this.downstream.onSubscribe(this);
            r4.request(this.prefetch);
            return;
        }

        @Override // java.lang.Runnable
        public void run() {
            int r1 = this.consumed;
            SpscArrayQueue<T> r2 = this.queue;
            c<? super T> r3 = this.downstream;
            int r4 = this.limit;
            int r6 = 1;
        L3:
            long r7 = this.requested.get();
            long r11 = 0;
        L5:
            if (r11 == r7) goto L29;
            if (this.cancelled == true) goto L8;
            boolean r14 = this.done;
            if (r14 == false) goto L17;
            Throwable r15 = this.error;
            if (r15 == null) goto L17;
            r2.clear();
            r3.onError(r15);
        L15:
            this.worker.dispose();
            return;
        L17:
            T r16 = r2.poll();
            if (r16 != null) goto L20;
            boolean r17 = true;
        L21:
            if (r14 == false) goto L24;
            if (r17 == false) goto L24;
        L23:
            r3.onComplete();
        L24:
            if (r17 == true) goto L29;
            r3.onNext(r16);
            r11 = r11 + 1;
            r1 = r1 + 1;
            if (r1 != r4) goto L5;
            this.upstream.request(r1);
            r1 = 0;
            goto L5
        L20:
            r17 = false;
            goto L21
        L8:
            r2.clear();
            return;
        L29:
            if (r11 != r7) goto L43;
            if (this.cancelled == true) goto L32;
            if (this.done == false) goto L43;
            Throwable r13 = this.error;
            if (r13 != null) goto L38;
            if (r2.isEmpty() == false) goto L43;
        L38:
            r2.clear();
            r3.onError(r13);
            goto L15
        L32:
            r2.clear();
            return;
        L43:
            if (r11 != 0) goto L45;
        L47:
            int r8 = get();
            if (r8 == r6) goto L49;
            r6 = r8;
            goto L3
        L49:
            this.consumed = r1;
            r6 = addAndGet(-r6);
            if (r6 != 0) goto L3;
            return;
        L45:
            if (r7 == Long.MAX_VALUE) goto L47;
            this.requested.addAndGet(-r11);
            goto L47
        }
    }

    final class a implements h.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final c<? super T>[] f17048a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final c<T>[] f17049b;
        final /* synthetic */ ParallelRunOn c;

        a(ParallelRunOn r1, c<? super T>[] r2, c<T>[] r3) {
            this.c = r1;
            this.f17048a = r2;
            this.f17049b = r3;
        }

        @Override // io.reactivex.internal.schedulers.h.a
        public void a(int r3, u.c r4) {
            this.c.a(r3, this.f17048a, this.f17049b, r4);
        }
    }

    @Override // io.reactivex.parallel.a
    public int a() {
        return this.f17046a.a();
    }

    void a(int r5, c<? super T>[] r6, c<T>[] r7, u.c r8) {
        c<? super T> r9 = r6[r5];
        SpscArrayQueue r0 = new SpscArrayQueue(this.c);
        if (ZeusTransformUtils.instanceOf(r9, io.reactivex.internal.a.a.class) == false) goto L5;
        r7[r5] = new RunOnConditionalSubscriber((io.reactivex.internal.a.a) ZeusTransformUtils.preCheckCast(r9, io.reactivex.internal.a.a.class, "com.obric.memorydata.plugin"), this.c, r0, r8);
        return;
    L5:
        r7[r5] = new RunOnSubscriber(r9, this.c, r0, r8);
    }

    @Override // io.reactivex.parallel.a
    public void a(c<? super T>[] r6) {
        if (b(r6) == true) goto L5;
        return;
    L5:
        int r0 = r6.length;
        c<T>[] r1 = new c[r0];
        if (ZeusTransformUtils.instanceOf(this.f17047b, h.class) == false) goto L8;
        ((h) ZeusTransformUtils.preCheckCast(this.f17047b, h.class, "com.obric.memorydata.plugin")).a(r0, new a(this, r6, r1));
    L11:
        this.f17046a.a(r1);
        return;
    L8:
        int r2 = 0;
    L9:
        if (r2 >= r0) goto L11;
        a(r2, r6, r1, this.f17047b.a());
        r2 = r2 + 1;
        goto L9
    }
}
