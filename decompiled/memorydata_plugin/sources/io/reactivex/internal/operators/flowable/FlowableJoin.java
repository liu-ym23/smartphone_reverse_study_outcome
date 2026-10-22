package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import defpackage.$$Lambda$g$NFitCGeARaziAziawMJBYS968oA;
import io.reactivex.b.h;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.g;
import io.reactivex.internal.a.f;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableJoin<TLeft, TRight, TLeftEnd, TRightEnd, R> extends a<TLeft, R> {
    final org.a.b<? extends TRight> c;
    final h<? super TLeft, ? extends org.a.b<TLeftEnd>> d;
    final h<? super TRight, ? extends org.a.b<TRightEnd>> e;
    final io.reactivex.b.c<? super TLeft, ? super TRight, ? extends R> f;

    static final class JoinSubscription<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements FlowableGroupJoin.a, org.a.d {
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
        final Map<Integer, TLeft> lefts;
        final io.reactivex.internal.queue.a<Object> queue;
        final AtomicLong requested;
        final io.reactivex.b.c<? super TLeft, ? super TRight, ? extends R> resultSelector;
        final h<? super TRight, ? extends org.a.b<TRightEnd>> rightEnd;
        int rightIndex;
        final Map<Integer, TRight> rights;

        static {
            LEFT_VALUE = 1;
            RIGHT_VALUE = 2;
            LEFT_CLOSE = 3;
            RIGHT_CLOSE = 4;
        }

        JoinSubscription(org.a.c<? super R> r3, h<? super TLeft, ? extends org.a.b<TLeftEnd>> r4, h<? super TRight, ? extends org.a.b<TRightEnd>> r5, io.reactivex.b.c<? super TLeft, ? super TRight, ? extends R> r6) {
            org.a.c<? super R> r7 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            h<? super TLeft, ? extends org.a.b<TLeftEnd>> r8 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
            h<? super TRight, ? extends org.a.b<TRightEnd>> r9 = (h) ZeusTransformUtils.wrapperContextForParams(r5, h.class, "com.obric.memorydata.plugin");
            io.reactivex.b.c<? super TLeft, ? super TRight, ? extends R> r10 = (io.reactivex.b.c) ZeusTransformUtils.wrapperContextForParams(r6, io.reactivex.b.c.class, "com.obric.memorydata.plugin");
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
            io.reactivex.internal.queue.a<Object> r2 = this.queue;
            org.a.c<? super R> r3 = this.downstream;
            boolean r0 = true;
            int r4 = 1;
        L7:
            if (this.cancelled == true) goto L8;
            if (((Throwable) ZeusTransformUtils.preCheckCast(this.error.get(), Throwable.class, "com.obric.memorydata.plugin")) != null) goto L12;
            if (this.active.get() != 0) goto L17;
            boolean r5 = r0;
        L18:
            Integer r8 = (Integer) ZeusTransformUtils.preCheckCast(r2.poll(), Integer.class, "com.obric.memorydata.plugin");
            if (r8 != null) goto L21;
            boolean r9 = r0;
        L22:
            if (r5 == false) goto L26;
            if (r9 == false) goto L26;
            this.lefts.clear();
            this.rights.clear();
            this.disposables.dispose();
            r3.onComplete();
            return;
        L26:
            if (r9 == true) goto L27;
            Object r6 = r2.poll();
            if (r8 != LEFT_VALUE) goto L58;
            int r7 = this.leftIndex;
            this.leftIndex = r7 + 1;
            this.lefts.put(Integer.valueOf(r7), (TLeft) r6);
            org.a.b r10 = (org.a.b) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(this.leftEnd.apply(r6), "The leftEnd returned a null Publisher"), org.a.b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L54
            FlowableGroupJoin.LeftRightEndSubscriber r11 = new FlowableGroupJoin.LeftRightEndSubscriber(this, r0, r7);
            this.disposables.a(r11);
            r10.subscribe(r11);
            if (((Throwable) ZeusTransformUtils.preCheckCast(this.error.get(), Throwable.class, "com.obric.memorydata.plugin")) != null) goto L36;
            long r12 = this.requested.get();
            Iterator<TRight> r13 = this.rights.values().iterator();
            long r14 = 0;
        L40:
            if (r13.hasNext() == false) goto L52;
            $$Lambda$g$NFitCGeARaziAziawMJBYS968oA r1 = (Object) io.reactivex.internal.functions.a.a(this.resultSelector.apply(r6, r13.next()), "The resultSelector returned a null value");
            if (r14 == r12) goto L46;
            r3.onNext(r1);
            r14 = r14 + 1;
            goto L40
        L46:
            ExceptionHelper.a(this.error, new MissingBackpressureException("Could not emit value due to lack of requests"));
            r2.clear();
            cancelAll();
            errorAll(r3);
            return;
        L48:
            th = move-exception;
            fail(th, r3, r2);
            return;
        L52:
            if (r14 == 0) goto L91;
            io.reactivex.internal.util.b.c(this.requested, r14);
        L91:
            r0 = true;
            goto L7
        L36:
            r2.clear();
            cancelAll();
            errorAll(r3);
            return;
        L54:
            th = move-exception;
            fail(th, r3, r2);
            return;
        L58:
            if (r8 != RIGHT_VALUE) goto L85;
            int r15 = this.rightIndex;
            this.rightIndex = r15 + 1;
            this.rights.put(Integer.valueOf(r15), (TRight) r6);
            org.a.b r16 = (org.a.b) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(this.rightEnd.apply(r6), "The rightEnd returned a null Publisher"), org.a.b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L81
            FlowableGroupJoin.LeftRightEndSubscriber r17 = new FlowableGroupJoin.LeftRightEndSubscriber(this, false, r15);
            this.disposables.a(r17);
            r16.subscribe(r17);
            if (((Throwable) ZeusTransformUtils.preCheckCast(this.error.get(), Throwable.class, "com.obric.memorydata.plugin")) != null) goto L63;
            long r18 = this.requested.get();
            Iterator<TLeft> r19 = this.lefts.values().iterator();
            long r20 = 0;
        L67:
            if (r19.hasNext() == false) goto L79;
            $$Lambda$g$NFitCGeARaziAziawMJBYS968oA r110 = (Object) io.reactivex.internal.functions.a.a(this.resultSelector.apply(r19.next(), r6), "The resultSelector returned a null value");
            if (r20 == r18) goto L73;
            r3.onNext(r110);
            r20 = r20 + 1;
            goto L67
        L73:
            ExceptionHelper.a(this.error, new MissingBackpressureException("Could not emit value due to lack of requests"));
            r2.clear();
            cancelAll();
            errorAll(r3);
            return;
        L75:
            th = move-exception;
            fail(th, r3, r2);
            return;
        L79:
            if (r20 == 0) goto L91;
            io.reactivex.internal.util.b.c(this.requested, r20);
            goto L91
        L63:
            r2.clear();
            cancelAll();
            errorAll(r3);
            return;
        L81:
            th = move-exception;
            fail(th, r3, r2);
            return;
        L85:
            if (r8 != LEFT_CLOSE) goto L89;
            FlowableGroupJoin.LeftRightEndSubscriber r21 = (FlowableGroupJoin.LeftRightEndSubscriber) ZeusTransformUtils.preCheckCast(r6, FlowableGroupJoin.LeftRightEndSubscriber.class, "com.obric.memorydata.plugin");
            Map r22 = this.lefts;
        L87:
            r22.remove(Integer.valueOf(r21.index));
            this.disposables.b(r21);
            goto L91
        L89:
            if (r8 != RIGHT_CLOSE) goto L91;
            r21 = (FlowableGroupJoin.LeftRightEndSubscriber) ZeusTransformUtils.preCheckCast(r6, FlowableGroupJoin.LeftRightEndSubscriber.class, "com.obric.memorydata.plugin");
            r22 = this.rights;
            goto L87
        L27:
            r4 = addAndGet(-r4);
            if (r4 != 0) goto L7;
            return;
        L21:
            r9 = false;
            goto L22
        L17:
            r5 = false;
            goto L18
        L12:
            r2.clear();
            cancelAll();
            errorAll(r3);
            return;
        L8:
            r2.clear();
        }

        void errorAll(org.a.c<?> r3) {
            org.a.c r4 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            Throwable r0 = ExceptionHelper.a(this.error);
            this.lefts.clear();
            this.rights.clear();
            r4.onError(r0);
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
        public void innerClose(boolean r2, FlowableGroupJoin.LeftRightEndSubscriber r3) {
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
        public void innerComplete(FlowableGroupJoin.LeftRightSubscriber r2) {
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

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // io.reactivex.g
    public void a(org.a.c<? super R> r5) {
        org.a.c r6 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r5, org.a.c.class, "com.obric.memorydata.plugin");
        JoinSubscription r0 = new JoinSubscription(r6, this.d, this.e, this.f);
        r6.onSubscribe(r0);
        FlowableGroupJoin.LeftRightSubscriber r7 = new FlowableGroupJoin.LeftRightSubscriber(r0, true);
        r0.disposables.a(r7);
        FlowableGroupJoin.LeftRightSubscriber r1 = new FlowableGroupJoin.LeftRightSubscriber(r0, false);
        r0.disposables.a(r1);
        this.f16812b.a(r7);
        this.c.subscribe(r1);
    }
}
