package io.reactivex.internal.operators.observable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import defpackage.$$Lambda$g$NFitCGeARaziAziawMJBYS968oA;
import io.reactivex.b.h;
import io.reactivex.internal.a.f;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.s;
import io.reactivex.t;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class ObservableSwitchMap<T, R> extends a<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h<? super T, ? extends s<? extends R>> f17000b;
    final int c;
    final boolean d;

    static final class SwitchMapInnerObserver<T, R> extends AtomicReference<io.reactivex.disposables.b> implements t<R> {
        private static final long serialVersionUID = 3837284832786408377L;
        final int bufferSize;
        volatile boolean done;
        final long index;
        final SwitchMapObserver<T, R> parent;
        volatile f<R> queue;

        SwitchMapInnerObserver(SwitchMapObserver<T, R> r1, long r2, int r4) {
            this.parent = r1;
            this.index = r2;
            this.bufferSize = r4;
        }

        public void cancel() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.t
        public void onComplete() {
            if (this.index != this.parent.unique) goto L6;
            this.done = true;
            this.parent.drain();
            return;
        }

        @Override // io.reactivex.t
        public void onError(Throwable r2) {
            this.parent.innerError(this, r2);
        }

        @Override // io.reactivex.t
        public void onNext(R r5) {
            if (this.index != this.parent.unique) goto L8;
            if (r5 == null) goto L6;
            this.queue.offer(r5);
        L6:
            this.parent.drain();
            return;
        }

        @Override // io.reactivex.t
        public void onSubscribe(io.reactivex.disposables.b r3) {
            io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            if (DisposableHelper.setOnce(this, r4) == true) goto L5;
            return;
        L5:
            if (ZeusTransformUtils.instanceOf(r4, io.reactivex.internal.a.b.class) == false) goto L14;
            io.reactivex.internal.a.b r5 = (io.reactivex.internal.a.b) ZeusTransformUtils.preCheckCast(r4, io.reactivex.internal.a.b.class, "com.obric.memorydata.plugin");
            int r0 = r5.requestFusion(7);
            if (r0 != 1) goto L11;
            this.queue = r5;
            this.done = true;
            this.parent.drain();
            return;
        L11:
            if (r0 != 2) goto L14;
            this.queue = r5;
            return;
        L14:
            this.queue = new io.reactivex.internal.queue.a(this.bufferSize);
        }
    }

    static final class SwitchMapObserver<T, R> extends AtomicInteger implements io.reactivex.disposables.b, t<T> {
        static final SwitchMapInnerObserver<Object, Object> CANCELLED = null;
        private static final long serialVersionUID = -3491074160481096299L;
        final AtomicReference<SwitchMapInnerObserver<T, R>> active;
        final int bufferSize;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final t<? super R> downstream;
        final AtomicThrowable errors;
        final h<? super T, ? extends s<? extends R>> mapper;
        volatile long unique;
        io.reactivex.disposables.b upstream;

        static {
            SwitchMapInnerObserver<Object, Object> r0 = new SwitchMapInnerObserver(null, -1, 1);
            CANCELLED = r0;
            r0.cancel();
        }

        SwitchMapObserver(t<? super R> r3, h<? super T, ? extends s<? extends R>> r4, int r5, boolean r6) {
            t<? super R> r7 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
            h<? super T, ? extends s<? extends R>> r8 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
            this.active = new AtomicReference();
            this.downstream = r7;
            this.mapper = r8;
            this.bufferSize = r5;
            this.delayErrors = r6;
            this.errors = new AtomicThrowable();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.cancelled == true) goto L6;
            this.cancelled = true;
            this.upstream.dispose();
            disposeInner();
            return;
        }

        void disposeInner() {
            SwitchMapInnerObserver<Object, Object> r0 = (SwitchMapInnerObserver) ZeusTransformUtils.preCheckCast(this.active.get(), SwitchMapInnerObserver.class, "com.obric.memorydata.plugin");
            SwitchMapInnerObserver<Object, Object> r1 = CANCELLED;
            if (r0 == r1) goto L9;
            SwitchMapInnerObserver<Object, Object> r3 = (SwitchMapInnerObserver) ZeusTransformUtils.preCheckCast(this.active.getAndSet((SwitchMapInnerObserver<T, R>) r1), SwitchMapInnerObserver.class, "com.obric.memorydata.plugin");
            if (r3 == r1) goto L10;
            if (r3 == null) goto L11;
            r3.cancel();
            return;
        L11:
            return;
        L10:
            return;
        }

        void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            t<? super R> r0 = this.downstream;
            AtomicReference<SwitchMapInnerObserver<T, R>> r1 = this.active;
            boolean r2 = this.delayErrors;
            int r4 = 1;
        L7:
            if (this.cancelled == true) goto L8;
            if (this.done == true) goto L12;
        L29:
            SwitchMapInnerObserver<T, R> r5 = (SwitchMapInnerObserver) ZeusTransformUtils.preCheckCast(r1.get(), SwitchMapInnerObserver.class, "com.obric.memorydata.plugin");
            if (r5 == null) goto L74;
            f<R> r8 = r5.queue;
            if (r8 == null) goto L74;
            if (r5.done == false) goto L44;
            boolean r9 = r8.isEmpty();
            if (r2 == false) goto L40;
            if (r9 == false) goto L44;
        L38:
            r1.compareAndSet(r5, null);
            goto L7
        L40:
            if (((Throwable) ZeusTransformUtils.preCheckCast(this.errors.get(), Throwable.class, "com.obric.memorydata.plugin")) != null) goto L24;
            if (r9 == false) goto L44;
        L24:
            r0.onError(this.errors.terminate());
            return;
        L44:
            boolean r10 = false;
        L46:
            if (this.cancelled == true) goto L47;
            if (r5 != r1.get()) goto L50;
            if (r2 == false) goto L53;
        L55:
            boolean r11 = r5.done;
            $$Lambda$g$NFitCGeARaziAziawMJBYS968oA r12 = r8.poll();     // Catch: Throwable -> L58
        L64:
            if (r12 != null) goto L66;
            boolean r13 = true;
        L67:
            if (r11 == false) goto L70;
            if (r13 == false) goto L70;
            r1.compareAndSet(r5, null);
        L70:
            if (r13 == true) goto L71;
            r0.onNext(r12);
        L71:
            if (r10 == false) goto L74;
        L66:
            r13 = false;
        L58:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            this.errors.addThrowable(th);
            r1.compareAndSet(r5, null);
            if (r2 == true) goto L62;
            disposeInner();
            this.upstream.dispose();
            this.done = true;
        L63:
            r10 = true;
            r12 = null;
            goto L64
        L62:
            r5.cancel();
            goto L63
        L53:
            if (((Throwable) ZeusTransformUtils.preCheckCast(this.errors.get(), Throwable.class, "com.obric.memorydata.plugin")) == null) goto L55;
        L50:
            r10 = true;
            goto L71
        L47:
            return;
        L74:
            r4 = addAndGet(-r4);
            if (r4 != 0) goto L7;
            return;
        L12:
            if (r1.get() != null) goto L14;
            boolean r6 = true;
        L15:
            if (r2 == false) goto L23;
            if (r6 == false) goto L29;
            Throwable r14 = (Throwable) ZeusTransformUtils.preCheckCast(this.errors.get(), Throwable.class, "com.obric.memorydata.plugin");
            if (r14 == null) goto L20;
            r0.onError(r14);
            return;
        L20:
            r0.onComplete();
            return;
        L23:
            if (((Throwable) ZeusTransformUtils.preCheckCast(this.errors.get(), Throwable.class, "com.obric.memorydata.plugin")) != null) goto L24;
            if (r6 == false) goto L29;
            r0.onComplete();
            return;
        L14:
            r6 = false;
            goto L15
        }

        void innerError(SwitchMapInnerObserver<T, R> r5, Throwable r6) {
            if (r5.index == this.unique) goto L5;
        L10:
            io.reactivex.d.a.a(r6);
            return;
        L5:
            if (this.errors.addThrowable(r6) == false) goto L10;
            if (this.delayErrors == true) goto L9;
            this.upstream.dispose();
            this.done = true;
        L9:
            r5.done = true;
            drain();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.t
        public void onComplete() {
            if (this.done == true) goto L6;
            this.done = true;
            drain();
            return;
        }

        @Override // io.reactivex.t
        public void onError(Throwable r2) {
            if (this.done == false) goto L5;
        L10:
            io.reactivex.d.a.a(r2);
            return;
        L5:
            if (this.errors.addThrowable(r2) == false) goto L10;
            if (this.delayErrors == true) goto L9;
            disposeInner();
        L9:
            this.done = true;
            drain();
        }

        @Override // io.reactivex.t
        public void onNext(T r6) {
            long r0 = this.unique + 1;
            this.unique = r0;
            SwitchMapInnerObserver r2 = (SwitchMapInnerObserver) ZeusTransformUtils.preCheckCast(this.active.get(), SwitchMapInnerObserver.class, "com.obric.memorydata.plugin");
            if (r2 == null) goto L17;
            r2.cancel();
        L17:
            s r7 = (s) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(this.mapper.apply(r6), "The ObservableSource returned is null"), s.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
            SwitchMapInnerObserver<T, R> r3 = new SwitchMapInnerObserver(this, r0, this.bufferSize);
        L7:
            SwitchMapInnerObserver<T, R> r1 = (SwitchMapInnerObserver) ZeusTransformUtils.preCheckCast(this.active.get(), SwitchMapInnerObserver.class, "com.obric.memorydata.plugin");
            if (r1 == CANCELLED) goto L22;
            if (this.active.compareAndSet(r1, r3) == false) goto L7;
            r7.subscribe(r3);
            return;
        L22:
            return;
        L14:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            this.upstream.dispose();
            onError(th);
        }

        @Override // io.reactivex.t
        public void onSubscribe(io.reactivex.disposables.b r3) {
            io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            if (DisposableHelper.validate(this.upstream, r4) == false) goto L6;
            this.upstream = r4;
            this.downstream.onSubscribe(this);
            return;
        }
    }

    @Override // io.reactivex.Observable
    public void a(t<? super R> r5) {
        t r6 = (t) ZeusTransformUtils.wrapperContextForParams(r5, t.class, "com.obric.memorydata.plugin");
        if (ObservableScalarXMap.a(this.f17034a, r6, this.f17000b) == false) goto L5;
        return;
    L5:
        this.f17034a.subscribe(new SwitchMapObserver(r6, this.f17000b, this.c, this.d));
    }
}
