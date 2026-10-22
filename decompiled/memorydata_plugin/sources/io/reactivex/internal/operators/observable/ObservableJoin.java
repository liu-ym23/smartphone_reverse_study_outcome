package io.reactivex.internal.operators.observable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.Observable;
import io.reactivex.b.h;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.s;
import io.reactivex.t;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class ObservableJoin<TLeft, TRight, TLeftEnd, TRightEnd, R> extends a<TLeft, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final s<? extends TRight> f16956b;
    final h<? super TLeft, ? extends s<TLeftEnd>> c;
    final h<? super TRight, ? extends s<TRightEnd>> d;
    final io.reactivex.b.c<? super TLeft, ? super TRight, ? extends R> e;

    static final class JoinDisposable<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements io.reactivex.disposables.b, ObservableGroupJoin.a {
        static final Integer LEFT_CLOSE = null;
        static final Integer LEFT_VALUE = null;
        static final Integer RIGHT_CLOSE = null;
        static final Integer RIGHT_VALUE = null;
        private static final long serialVersionUID = -6071216598687999801L;
        final AtomicInteger active;
        volatile boolean cancelled;
        final io.reactivex.disposables.a disposables;
        final t<? super R> downstream;
        final AtomicReference<Throwable> error;
        final h<? super TLeft, ? extends s<TLeftEnd>> leftEnd;
        int leftIndex;
        final Map<Integer, TLeft> lefts;
        final io.reactivex.internal.queue.a<Object> queue;
        final io.reactivex.b.c<? super TLeft, ? super TRight, ? extends R> resultSelector;
        final h<? super TRight, ? extends s<TRightEnd>> rightEnd;
        int rightIndex;
        final Map<Integer, TRight> rights;

        static {
            LEFT_VALUE = 1;
            RIGHT_VALUE = 2;
            LEFT_CLOSE = 3;
            RIGHT_CLOSE = 4;
        }

        JoinDisposable(t<? super R> r3, h<? super TLeft, ? extends s<TLeftEnd>> r4, h<? super TRight, ? extends s<TRightEnd>> r5, io.reactivex.b.c<? super TLeft, ? super TRight, ? extends R> r6) {
            t<? super R> r7 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
            h<? super TLeft, ? extends s<TLeftEnd>> r8 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
            h<? super TRight, ? extends s<TRightEnd>> r9 = (h) ZeusTransformUtils.wrapperContextForParams(r5, h.class, "com.obric.memorydata.plugin");
            io.reactivex.b.c<? super TLeft, ? super TRight, ? extends R> r10 = (io.reactivex.b.c) ZeusTransformUtils.wrapperContextForParams(r6, io.reactivex.b.c.class, "com.obric.memorydata.plugin");
            this.downstream = r7;
            this.disposables = new io.reactivex.disposables.a();
            this.queue = new io.reactivex.internal.queue.a(Observable.a());
            this.lefts = new LinkedHashMap();
            this.rights = new LinkedHashMap();
            this.error = new AtomicReference();
            this.leftEnd = r8;
            this.rightEnd = r9;
            this.resultSelector = r10;
            this.active = new AtomicInteger(2);
        }

        void cancelAll() {
            this.disposables.dispose();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.cancelled == true) goto L8;
            this.cancelled = true;
            cancelAll();
            if (getAndIncrement() != 0) goto L9;
            this.queue.clear();
            return;
        L9:
            return;
        }

        void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            io.reactivex.internal.queue.a<?> r0 = this.queue;
            t<? super R> r1 = this.downstream;
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
            if (r4 == false) goto L26;
            if (r8 == false) goto L26;
            this.lefts.clear();
            this.rights.clear();
            this.disposables.dispose();
            r1.onComplete();
            return;
        L26:
            if (r8 == true) goto L27;
            Object r5 = r0.poll();
            if (r7 == LEFT_VALUE) goto L32;
            if (r7 == RIGHT_VALUE) goto L52;
            if (r7 != LEFT_CLOSE) goto L73;
            ObservableGroupJoin.LeftRightEndObserver r6 = (ObservableGroupJoin.LeftRightEndObserver) ZeusTransformUtils.preCheckCast(r5, ObservableGroupJoin.LeftRightEndObserver.class, "com.obric.memorydata.plugin");
            Map r9 = this.lefts;
        L74:
            r9.remove(Integer.valueOf(r6.index));
            this.disposables.b(r6);
            goto L7
        L73:
            r6 = (ObservableGroupJoin.LeftRightEndObserver) ZeusTransformUtils.preCheckCast(r5, ObservableGroupJoin.LeftRightEndObserver.class, "com.obric.memorydata.plugin");
            r9 = this.rights;
            goto L74
        L52:
            int r10 = this.rightIndex;
            this.rightIndex = r10 + 1;
            this.rights.put(Integer.valueOf(r10), (TRight) r5);
            s r11 = (s) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(this.rightEnd.apply(r5), "The rightEnd returned a null ObservableSource"), s.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L67
            ObservableGroupJoin.LeftRightEndObserver r12 = new ObservableGroupJoin.LeftRightEndObserver(this, false, r10);
            this.disposables.a(r12);
            r11.subscribe(r12);
            if (((Throwable) ZeusTransformUtils.preCheckCast(this.error.get(), Throwable.class, "com.obric.memorydata.plugin")) != null) goto L56;
            Iterator<TLeft> r13 = this.lefts.values().iterator();
        L60:
            if (r13.hasNext() == false) goto L7;
            r1.onNext((Object) io.reactivex.internal.functions.a.a(this.resultSelector.apply(r13.next(), r5), "The resultSelector returned a null value"));
        L64:
            th = move-exception;
            fail(th, r1, r0);
            return;
        L56:
            r0.clear();
            cancelAll();
            errorAll(r1);
            return;
        L67:
            th = move-exception;
            fail(th, r1, r0);
            return;
        L32:
            int r14 = this.leftIndex;
            this.leftIndex = r14 + 1;
            this.lefts.put(Integer.valueOf(r14), (TLeft) r5);
            s r15 = (s) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(this.leftEnd.apply(r5), "The leftEnd returned a null ObservableSource"), s.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L47
            ObservableGroupJoin.LeftRightEndObserver r16 = new ObservableGroupJoin.LeftRightEndObserver(this, true, r14);
            this.disposables.a(r16);
            r15.subscribe(r16);
            if (((Throwable) ZeusTransformUtils.preCheckCast(this.error.get(), Throwable.class, "com.obric.memorydata.plugin")) != null) goto L36;
            Iterator<TRight> r17 = this.rights.values().iterator();
        L40:
            if (r17.hasNext() == false) goto L7;
            r1.onNext((Object) io.reactivex.internal.functions.a.a(this.resultSelector.apply(r5, r17.next()), "The resultSelector returned a null value"));
        L44:
            th = move-exception;
            fail(th, r1, r0);
            return;
        L36:
            r0.clear();
            cancelAll();
            errorAll(r1);
            return;
        L47:
            th = move-exception;
            fail(th, r1, r0);
            return;
        L27:
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

        void errorAll(t<?> r3) {
            t r4 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
            Throwable r0 = ExceptionHelper.a(this.error);
            this.lefts.clear();
            this.rights.clear();
            r4.onError(r0);
        }

        void fail(Throwable r3, t<?> r4, io.reactivex.internal.queue.a<?> r5) {
            t<?> r6 = (t) ZeusTransformUtils.wrapperContextForParams(r4, t.class, "com.obric.memorydata.plugin");
            io.reactivex.exceptions.a.a(r3);
            ExceptionHelper.a(this.error, r3);
            r5.clear();
            cancelAll();
            errorAll(r6);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.a
        public void innerClose(boolean r2, ObservableGroupJoin.LeftRightEndObserver r3) {
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

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.a
        public void innerCloseError(Throwable r2) {
            if (ExceptionHelper.a(this.error, r2) == false) goto L5;
            drain();
            return;
        L5:
            io.reactivex.d.a.a(r2);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.a
        public void innerComplete(ObservableGroupJoin.LeftRightObserver r2) {
            this.disposables.delete(r2);
            this.active.decrementAndGet();
            drain();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.a
        public void innerError(Throwable r2) {
            if (ExceptionHelper.a(this.error, r2) == false) goto L5;
            this.active.decrementAndGet();
            drain();
            return;
        L5:
            io.reactivex.d.a.a(r2);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.a
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

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled;
        }
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // io.reactivex.Observable
    public void a(t<? super R> r5) {
        t r6 = (t) ZeusTransformUtils.wrapperContextForParams(r5, t.class, "com.obric.memorydata.plugin");
        JoinDisposable r0 = new JoinDisposable(r6, this.c, this.d, this.e);
        r6.onSubscribe(r0);
        ObservableGroupJoin.LeftRightObserver r7 = new ObservableGroupJoin.LeftRightObserver(r0, true);
        r0.disposables.a(r7);
        ObservableGroupJoin.LeftRightObserver r1 = new ObservableGroupJoin.LeftRightObserver(r0, false);
        r0.disposables.a(r1);
        this.f17034a.subscribe(r7);
        this.f16956b.subscribe(r1);
    }
}
