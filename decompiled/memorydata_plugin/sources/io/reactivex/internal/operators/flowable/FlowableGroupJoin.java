package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import defpackage.$$Lambda$g$NFitCGeARaziAziawMJBYS968oA;
import io.reactivex.b.h;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.g;
import io.reactivex.internal.a.f;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.j;
import io.reactivex.processors.UnicastProcessor;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableGroupJoin<TLeft, TRight, TLeftEnd, TRightEnd, R> extends io.reactivex.internal.operators.flowable.a<TLeft, R> {
    final org.a.b<? extends TRight> c;
    final h<? super TLeft, ? extends org.a.b<TLeftEnd>> d;
    final h<? super TRight, ? extends org.a.b<TRightEnd>> e;
    final io.reactivex.b.c<? super TLeft, ? super g<TRight>, ? extends R> f;

    static final class GroupJoinSubscription<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements a, org.a.d {
        static final Integer LEFT_CLOSE = null;
        static final Integer LEFT_VALUE = null;
        static final Integer RIGHT_CLOSE = null;
        static final Integer RIGHT_VALUE = null;
        private static final long serialVersionUID = -6071216598687999801L;
        final AtomicInteger active;
        volatile boolean cancelled;
        final io.reactivex.disposables.a disposables;
        final org.a.c<? super R> downstream;
        final AtomicReference<Throwable> error;
        final h<? super TLeft, ? extends org.a.b<TLeftEnd>> leftEnd;
        int leftIndex;
        final Map<Integer, UnicastProcessor<TRight>> lefts;
        final io.reactivex.internal.queue.a<Object> queue;
        final AtomicLong requested;
        final io.reactivex.b.c<? super TLeft, ? super g<TRight>, ? extends R> resultSelector;
        final h<? super TRight, ? extends org.a.b<TRightEnd>> rightEnd;
        int rightIndex;
        final Map<Integer, TRight> rights;

        static {
            LEFT_VALUE = 1;
            RIGHT_VALUE = 2;
            LEFT_CLOSE = 3;
            RIGHT_CLOSE = 4;
        }

        GroupJoinSubscription(org.a.c<? super R> r3, h<? super TLeft, ? extends org.a.b<TLeftEnd>> r4, h<? super TRight, ? extends org.a.b<TRightEnd>> r5, io.reactivex.b.c<? super TLeft, ? super g<TRight>, ? extends R> r6) {
            org.a.c<? super R> r7 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            h<? super TLeft, ? extends org.a.b<TLeftEnd>> r8 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
            h<? super TRight, ? extends org.a.b<TRightEnd>> r9 = (h) ZeusTransformUtils.wrapperContextForParams(r5, h.class, "com.obric.memorydata.plugin");
            io.reactivex.b.c<? super TLeft, ? super g<TRight>, ? extends R> r10 = (io.reactivex.b.c) ZeusTransformUtils.wrapperContextForParams(r6, io.reactivex.b.c.class, "com.obric.memorydata.plugin");
            this.downstream = r7;
            this.requested = new AtomicLong();
            this.disposables = new io.reactivex.disposables.a();
            this.queue = new io.reactivex.internal.queue.a(g.a());
            this.lefts = new LinkedHashMap();
            this.rights = new LinkedHashMap();
            this.error = new AtomicReference();
            this.leftEnd = r8;
            this.rightEnd = r9;
            this.resultSelector = r10;
            this.active = new AtomicInteger(2);
        }

        @Override // org.a.d
        public void cancel() {
            if (this.cancelled == false) goto L5;
            return;
        L5:
            this.cancelled = true;
            cancelAll();
            if (getAndIncrement() != 0) goto L9;
            this.queue.clear();
            return;
        }

        void cancelAll() {
            this.disposables.dispose();
        }

        void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            io.reactivex.internal.queue.a<Object> r0 = this.queue;
            org.a.c<? super R> r1 = this.downstream;
            int r3 = 1;
        L7:
            if (this.cancelled == true) goto L8;
            if (((Throwable) ZeusTransformUtils.preCheckCast(this.error.get(), Throwable.class, "com.obric.memorydata.plugin")) != null) goto L12;
            if (this.active.get() != 0) goto L17;
            boolean r4 = true;
        L18:
            Integer r7 = (Integer) ZeusTransformUtils.preCheckCast(r0.poll(), Integer.class, "com.obric.memorydata.plugin");
            if (r7 != null) goto L21;
            boolean r8 = true;
        L22:
            if (r4 == false) goto L30;
            if (r8 == false) goto L30;
            Iterator<UnicastProcessor<TRight>> r2 = this.lefts.values().iterator();
        L26:
            if (r2.hasNext() == false) goto L28;
            ((UnicastProcessor) ZeusTransformUtils.preCheckCast(r2.next(), UnicastProcessor.class, "com.obric.memorydata.plugin")).onComplete();
            goto L26
        L28:
            this.lefts.clear();
            this.rights.clear();
            this.disposables.dispose();
            r1.onComplete();
            return;
        L30:
            if (r8 == true) goto L31;
            Object r5 = r0.poll();
            if (r7 == LEFT_VALUE) goto L36;
            if (r7 == RIGHT_VALUE) goto L59;
            if (r7 == LEFT_CLOSE) goto L74;
            if (r7 != RIGHT_CLOSE) goto L7;
            LeftRightEndSubscriber r6 = (LeftRightEndSubscriber) ZeusTransformUtils.preCheckCast(r5, LeftRightEndSubscriber.class, "com.obric.memorydata.plugin");
            this.rights.remove(Integer.valueOf(r6.index));
            this.disposables.b(r6);
            goto L7
        L74:
            LeftRightEndSubscriber r9 = (LeftRightEndSubscriber) ZeusTransformUtils.preCheckCast(r5, LeftRightEndSubscriber.class, "com.obric.memorydata.plugin");
            UnicastProcessor r10 = (UnicastProcessor) ZeusTransformUtils.preCheckCast(this.lefts.remove(Integer.valueOf(r9.index)), UnicastProcessor.class, "com.obric.memorydata.plugin");
            this.disposables.b(r9);
            if (r10 == null) goto L7;
            r10.onComplete();
            goto L7
        L59:
            int r11 = this.rightIndex;
            this.rightIndex = r11 + 1;
            this.rights.put(Integer.valueOf(r11), (TRight) r5);
            org.a.b r12 = (org.a.b) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(this.rightEnd.apply(r5), "The rightEnd returned a null Publisher"), org.a.b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L69
            LeftRightEndSubscriber r13 = new LeftRightEndSubscriber(this, false, r11);
            this.disposables.a(r13);
            r12.subscribe(r13);
            if (((Throwable) ZeusTransformUtils.preCheckCast(this.error.get(), Throwable.class, "com.obric.memorydata.plugin")) != null) goto L63;
            Iterator<UnicastProcessor<TRight>> r14 = this.lefts.values().iterator();
        L67:
            if (r14.hasNext() == false) goto L7;
            ((UnicastProcessor) ZeusTransformUtils.preCheckCast(r14.next(), UnicastProcessor.class, "com.obric.memorydata.plugin")).onNext(r5);
            goto L67
        L63:
            r0.clear();
            cancelAll();
            errorAll(r1);
            return;
        L69:
            th = move-exception;
            fail(th, r1, r0);
            return;
        L36:
            UnicastProcessor r15 = UnicastProcessor.c();
            int r16 = this.leftIndex;
            this.leftIndex = r16 + 1;
            this.lefts.put(Integer.valueOf(r16), (UnicastProcessor<TRight>) r15);
            org.a.b r17 = (org.a.b) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(this.leftEnd.apply(r5), "The leftEnd returned a null Publisher"), org.a.b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L54
            LeftRightEndSubscriber r18 = new LeftRightEndSubscriber(this, true, r16);
            this.disposables.a(r18);
            r17.subscribe(r18);
            if (((Throwable) ZeusTransformUtils.preCheckCast(this.error.get(), Throwable.class, "com.obric.memorydata.plugin")) != null) goto L40;
            $$Lambda$g$NFitCGeARaziAziawMJBYS968oA r19 = (Object) io.reactivex.internal.functions.a.a(this.resultSelector.apply(r5, r15), "The resultSelector returned a null value");
            if (this.requested.get() == 0) goto L49;
            r1.onNext(r19);
            io.reactivex.internal.util.b.c(this.requested, 1);
            Iterator<TRight> r20 = this.rights.values().iterator();
        L47:
            if (r20.hasNext() == false) goto L7;
            r15.onNext(r20.next());
            goto L47
        L49:
            fail(new MissingBackpressureException("Could not emit value due to lack of requests"), r1, r0);
            return;
        L51:
            th = move-exception;
            fail(th, r1, r0);
            return;
        L40:
            r0.clear();
            cancelAll();
            errorAll(r1);
            return;
        L54:
            th = move-exception;
            fail(th, r1, r0);
            return;
        L31:
            r3 = addAndGet(-r3);
            if (r3 != 0) goto L7;
            return;
        L21:
            r8 = false;
            goto L22
        L17:
            r4 = false;
            goto L18
        L12:
            r0.clear();
            cancelAll();
            errorAll(r1);
            return;
        L8:
            r0.clear();
        }

        void errorAll(org.a.c<?> r6) {
            org.a.c r7 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r6, org.a.c.class, "com.obric.memorydata.plugin");
            Throwable r0 = ExceptionHelper.a(this.error);
            Iterator<UnicastProcessor<TRight>> r2 = this.lefts.values().iterator();
        L4:
            if (r2.hasNext() == false) goto L6;
            ((UnicastProcessor) ZeusTransformUtils.preCheckCast(r2.next(), UnicastProcessor.class, "com.obric.memorydata.plugin")).onError(r0);
            goto L4
        L6:
            this.lefts.clear();
            this.rights.clear();
            r7.onError(r0);
        }

        void fail(Throwable r3, org.a.c<?> r4, f<?> r5) {
            org.a.c<?> r6 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r4, org.a.c.class, "com.obric.memorydata.plugin");
            f r7 = (f) ZeusTransformUtils.wrapperContextForParams(r5, f.class, "com.obric.memorydata.plugin");
            io.reactivex.exceptions.a.a(r3);
            ExceptionHelper.a(this.error, r3);
            r7.clear();
            cancelAll();
            errorAll(r6);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableGroupJoin.a
        public void innerClose(boolean r2, LeftRightEndSubscriber r3) {
            monitor-enter(this);
            io.reactivex.internal.queue.a<Object> r0 = this.queue;     // Catch: Throwable -> L11
            if (r2 == false) goto L6;
            Integer r4 = LEFT_CLOSE;     // Catch: Throwable -> L11
        L7:
            r0.a(r4, r3);     // Catch: Throwable -> L11
            monitor-exit(this);     // Catch: Throwable -> L11
            drain();
            return;
        L6:
            r4 = RIGHT_CLOSE;     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            throw th;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableGroupJoin.a
        public void innerCloseError(Throwable r2) {
            if (ExceptionHelper.a(this.error, r2) == false) goto L5;
            drain();
            return;
        L5:
            io.reactivex.d.a.a(r2);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableGroupJoin.a
        public void innerComplete(LeftRightSubscriber r2) {
            this.disposables.delete(r2);
            this.active.decrementAndGet();
            drain();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableGroupJoin.a
        public void innerError(Throwable r2) {
            if (ExceptionHelper.a(this.error, r2) == false) goto L5;
            this.active.decrementAndGet();
            drain();
            return;
        L5:
            io.reactivex.d.a.a(r2);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableGroupJoin.a
        public void innerValue(boolean r2, Object r3) {
            monitor-enter(this);
            io.reactivex.internal.queue.a<Object> r0 = this.queue;     // Catch: Throwable -> L11
            if (r2 == false) goto L6;
            Integer r4 = LEFT_VALUE;     // Catch: Throwable -> L11
        L7:
            r0.a(r4, r3);     // Catch: Throwable -> L11
            monitor-exit(this);     // Catch: Throwable -> L11
            drain();
            return;
        L6:
            r4 = RIGHT_VALUE;     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            throw th;
        }

        @Override // org.a.d
        public void request(long r2) {
            if (SubscriptionHelper.validate(r2) == false) goto L6;
            io.reactivex.internal.util.b.a(this.requested, r2);
            return;
        }
    }

    static final class LeftRightEndSubscriber extends AtomicReference<org.a.d> implements io.reactivex.disposables.b, j<Object> {
        private static final long serialVersionUID = 1883890389173668373L;
        final int index;
        final boolean isLeft;
        final a parent;

        LeftRightEndSubscriber(a r3, boolean r4, int r5) {
            this.parent = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
            this.isLeft = r4;
            this.index = r5;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            SubscriptionHelper.cancel(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            if (get() != SubscriptionHelper.CANCELLED) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // org.a.c
        public void onComplete() {
            this.parent.innerClose(this.isLeft, this);
        }

        @Override // org.a.c
        public void onError(Throwable r1) {
            this.parent.innerCloseError(r1);
        }

        @Override // org.a.c
        public void onNext(Object r2) {
            if (SubscriptionHelper.cancel(this) == false) goto L6;
            this.parent.innerClose(this.isLeft, this);
            return;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d r3) {
            SubscriptionHelper.setOnce(this, (org.a.d) ZeusTransformUtils.wrapperContextForParams(r3, org.a.d.class, "com.obric.memorydata.plugin"), Long.MAX_VALUE);
        }
    }

    static final class LeftRightSubscriber extends AtomicReference<org.a.d> implements io.reactivex.disposables.b, j<Object> {
        private static final long serialVersionUID = 1883890389173668373L;
        final boolean isLeft;
        final a parent;

        LeftRightSubscriber(a r3, boolean r4) {
            this.parent = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
            this.isLeft = r4;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            SubscriptionHelper.cancel(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            if (get() != SubscriptionHelper.CANCELLED) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // org.a.c
        public void onComplete() {
            this.parent.innerComplete(this);
        }

        @Override // org.a.c
        public void onError(Throwable r1) {
            this.parent.innerError(r1);
        }

        @Override // org.a.c
        public void onNext(Object r2) {
            this.parent.innerValue(this.isLeft, r2);
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d r3) {
            SubscriptionHelper.setOnce(this, (org.a.d) ZeusTransformUtils.wrapperContextForParams(r3, org.a.d.class, "com.obric.memorydata.plugin"), Long.MAX_VALUE);
        }
    }

    interface a {
        void innerClose(boolean r1, LeftRightEndSubscriber r2);

        void innerCloseError(Throwable r1);

        void innerComplete(LeftRightSubscriber r1);

        void innerError(Throwable r1);

        void innerValue(boolean r1, Object r2);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // io.reactivex.g
    public void a(org.a.c<? super R> r5) {
        org.a.c r6 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r5, org.a.c.class, "com.obric.memorydata.plugin");
        GroupJoinSubscription r0 = new GroupJoinSubscription(r6, this.d, this.e, this.f);
        r6.onSubscribe(r0);
        LeftRightSubscriber r7 = new LeftRightSubscriber(r0, true);
        r0.disposables.a(r7);
        LeftRightSubscriber r1 = new LeftRightSubscriber(r0, false);
        r0.disposables.a(r1);
        this.f16812b.a(r7);
        this.c.subscribe(r1);
    }
}
