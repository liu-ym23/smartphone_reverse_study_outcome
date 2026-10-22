package io.reactivex.internal.operators.observable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.Observable;
import io.reactivex.b.h;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.s;
import io.reactivex.subjects.UnicastSubject;
import io.reactivex.t;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class ObservableGroupJoin<TLeft, TRight, TLeftEnd, TRightEnd, R> extends io.reactivex.internal.operators.observable.a<TLeft, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final s<? extends TRight> f16951b;
    final h<? super TLeft, ? extends s<TLeftEnd>> c;
    final h<? super TRight, ? extends s<TRightEnd>> d;
    final io.reactivex.b.c<? super TLeft, ? super Observable<TRight>, ? extends R> e;

    static final class GroupJoinDisposable<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements io.reactivex.disposables.b, a {
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
        final Map<Integer, UnicastSubject<TRight>> lefts;
        final io.reactivex.internal.queue.a<Object> queue;
        final io.reactivex.b.c<? super TLeft, ? super Observable<TRight>, ? extends R> resultSelector;
        final h<? super TRight, ? extends s<TRightEnd>> rightEnd;
        int rightIndex;
        final Map<Integer, TRight> rights;

        static {
            LEFT_VALUE = 1;
            RIGHT_VALUE = 2;
            LEFT_CLOSE = 3;
            RIGHT_CLOSE = 4;
        }

        GroupJoinDisposable(t<? super R> r3, h<? super TLeft, ? extends s<TLeftEnd>> r4, h<? super TRight, ? extends s<TRightEnd>> r5, io.reactivex.b.c<? super TLeft, ? super Observable<TRight>, ? extends R> r6) {
            t<? super R> r7 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
            h<? super TLeft, ? extends s<TLeftEnd>> r8 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
            h<? super TRight, ? extends s<TRightEnd>> r9 = (h) ZeusTransformUtils.wrapperContextForParams(r5, h.class, "com.obric.memorydata.plugin");
            io.reactivex.b.c<? super TLeft, ? super Observable<TRight>, ? extends R> r10 = (io.reactivex.b.c) ZeusTransformUtils.wrapperContextForParams(r6, io.reactivex.b.c.class, "com.obric.memorydata.plugin");
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
            if (this.cancelled == false) goto L5;
            return;
        L5:
            this.cancelled = true;
            cancelAll();
            if (getAndIncrement() != 0) goto L9;
            this.queue.clear();
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
            if (r4 == false) goto L30;
            if (r8 == false) goto L30;
            Iterator<UnicastSubject<TRight>> r2 = this.lefts.values().iterator();
        L26:
            if (r2.hasNext() == false) goto L28;
            ((UnicastSubject) ZeusTransformUtils.preCheckCast(r2.next(), UnicastSubject.class, "com.obric.memorydata.plugin")).onComplete();
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
            if (r7 == RIGHT_VALUE) goto L55;
            if (r7 == LEFT_CLOSE) goto L70;
            if (r7 != RIGHT_CLOSE) goto L7;
            LeftRightEndObserver r6 = (LeftRightEndObserver) ZeusTransformUtils.preCheckCast(r5, LeftRightEndObserver.class, "com.obric.memorydata.plugin");
            this.rights.remove(Integer.valueOf(r6.index));
            this.disposables.b(r6);
            goto L7
        L70:
            LeftRightEndObserver r9 = (LeftRightEndObserver) ZeusTransformUtils.preCheckCast(r5, LeftRightEndObserver.class, "com.obric.memorydata.plugin");
            UnicastSubject r10 = (UnicastSubject) ZeusTransformUtils.preCheckCast(this.lefts.remove(Integer.valueOf(r9.index)), UnicastSubject.class, "com.obric.memorydata.plugin");
            this.disposables.b(r9);
            if (r10 == null) goto L7;
            r10.onComplete();
            goto L7
        L55:
            int r11 = this.rightIndex;
            this.rightIndex = r11 + 1;
            this.rights.put(Integer.valueOf(r11), (TRight) r5);
            s r12 = (s) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(this.rightEnd.apply(r5), "The rightEnd returned a null ObservableSource"), s.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L65
            LeftRightEndObserver r13 = new LeftRightEndObserver(this, false, r11);
            this.disposables.a(r13);
            r12.subscribe(r13);
            if (((Throwable) ZeusTransformUtils.preCheckCast(this.error.get(), Throwable.class, "com.obric.memorydata.plugin")) != null) goto L59;
            Iterator<UnicastSubject<TRight>> r14 = this.lefts.values().iterator();
        L63:
            if (r14.hasNext() == false) goto L7;
            ((UnicastSubject) ZeusTransformUtils.preCheckCast(r14.next(), UnicastSubject.class, "com.obric.memorydata.plugin")).onNext(r5);
            goto L63
        L59:
            r0.clear();
            cancelAll();
            errorAll(r1);
            return;
        L65:
            th = move-exception;
            fail(th, r1, r0);
            return;
        L36:
            UnicastSubject r15 = UnicastSubject.b();
            int r16 = this.leftIndex;
            this.leftIndex = r16 + 1;
            this.lefts.put(Integer.valueOf(r16), (UnicastSubject<TRight>) r15);
            s r17 = (s) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(this.leftEnd.apply(r5), "The leftEnd returned a null ObservableSource"), s.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L50
            LeftRightEndObserver r18 = new LeftRightEndObserver(this, true, r16);
            this.disposables.a(r18);
            r17.subscribe(r18);
            if (((Throwable) ZeusTransformUtils.preCheckCast(this.error.get(), Throwable.class, "com.obric.memorydata.plugin")) != null) goto L40;
            r1.onNext((Object) io.reactivex.internal.functions.a.a(this.resultSelector.apply(r5, r15), "The resultSelector returned a null value"));
            Iterator<TRight> r19 = this.rights.values().iterator();
        L45:
            if (r19.hasNext() == false) goto L7;
            r15.onNext(r19.next());
        L47:
            th = move-exception;
            fail(th, r1, r0);
            return;
        L40:
            r0.clear();
            cancelAll();
            errorAll(r1);
            return;
        L50:
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

        void errorAll(t<?> r6) {
            t r7 = (t) ZeusTransformUtils.wrapperContextForParams(r6, t.class, "com.obric.memorydata.plugin");
            Throwable r0 = ExceptionHelper.a(this.error);
            Iterator<UnicastSubject<TRight>> r2 = this.lefts.values().iterator();
        L4:
            if (r2.hasNext() == false) goto L6;
            ((UnicastSubject) ZeusTransformUtils.preCheckCast(r2.next(), UnicastSubject.class, "com.obric.memorydata.plugin")).onError(r0);
            goto L4
        L6:
            this.lefts.clear();
            this.rights.clear();
            r7.onError(r0);
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
        public void innerClose(boolean r2, LeftRightEndObserver r3) {
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
        public void innerComplete(LeftRightObserver r2) {
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

    static final class LeftRightEndObserver extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, t<Object> {
        private static final long serialVersionUID = 1883890389173668373L;
        final int index;
        final boolean isLeft;
        final a parent;

        LeftRightEndObserver(a r3, boolean r4, int r5) {
            this.parent = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
            this.isLeft = r4;
            this.index = r5;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed((io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(get(), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
        }

        @Override // io.reactivex.t
        public void onComplete() {
            this.parent.innerClose(this.isLeft, this);
        }

        @Override // io.reactivex.t
        public void onError(Throwable r1) {
            this.parent.innerCloseError(r1);
        }

        @Override // io.reactivex.t
        public void onNext(Object r2) {
            if (DisposableHelper.dispose(this) == false) goto L6;
            this.parent.innerClose(this.isLeft, this);
            return;
        }

        @Override // io.reactivex.t
        public void onSubscribe(io.reactivex.disposables.b r3) {
            DisposableHelper.setOnce(this, (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
        }
    }

    static final class LeftRightObserver extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, t<Object> {
        private static final long serialVersionUID = 1883890389173668373L;
        final boolean isLeft;
        final a parent;

        LeftRightObserver(a r3, boolean r4) {
            this.parent = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
            this.isLeft = r4;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed((io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(get(), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
        }

        @Override // io.reactivex.t
        public void onComplete() {
            this.parent.innerComplete(this);
        }

        @Override // io.reactivex.t
        public void onError(Throwable r1) {
            this.parent.innerError(r1);
        }

        @Override // io.reactivex.t
        public void onNext(Object r2) {
            this.parent.innerValue(this.isLeft, r2);
        }

        @Override // io.reactivex.t
        public void onSubscribe(io.reactivex.disposables.b r3) {
            DisposableHelper.setOnce(this, (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
        }
    }

    interface a {
        void innerClose(boolean r1, LeftRightEndObserver r2);

        void innerCloseError(Throwable r1);

        void innerComplete(LeftRightObserver r1);

        void innerError(Throwable r1);

        void innerValue(boolean r1, Object r2);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // io.reactivex.Observable
    public void a(t<? super R> r5) {
        t r6 = (t) ZeusTransformUtils.wrapperContextForParams(r5, t.class, "com.obric.memorydata.plugin");
        GroupJoinDisposable r0 = new GroupJoinDisposable(r6, this.c, this.d, this.e);
        r6.onSubscribe(r0);
        LeftRightObserver r7 = new LeftRightObserver(r0, true);
        r0.disposables.a(r7);
        LeftRightObserver r1 = new LeftRightObserver(r0, false);
        r0.disposables.a(r1);
        this.f17034a.subscribe(r7);
        this.f16951b.subscribe(r1);
    }
}
