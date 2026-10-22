package io.reactivex.internal.operators.observable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.g;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.s;
import io.reactivex.t;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class ObservablePublishAlt<T> extends io.reactivex.c.a<T> implements io.reactivex.internal.disposables.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final s<T> f16965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final AtomicReference<PublishConnection<T>> f16966b;

    static final class InnerDisposable<T> extends AtomicReference<PublishConnection<T>> implements io.reactivex.disposables.b {
        private static final long serialVersionUID = 7463222674719692880L;
        final t<? super T> downstream;

        InnerDisposable(t<? super T> r3, PublishConnection<T> r4) {
            this.downstream = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
            lazySet(r4);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            PublishConnection r0 = (PublishConnection) ZeusTransformUtils.preCheckCast(getAndSet(null), PublishConnection.class, "com.obric.memorydata.plugin");
            if (r0 == null) goto L6;
            r0.remove(this);
            return;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            if (get() != null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    static final class PublishConnection<T> extends AtomicReference<InnerDisposable<T>[]> implements io.reactivex.disposables.b, t<T> {
        static final InnerDisposable[] EMPTY = null;
        static final InnerDisposable[] TERMINATED = null;
        private static final long serialVersionUID = -3251430252873581268L;
        final AtomicBoolean connect;
        final AtomicReference<PublishConnection<T>> current;
        Throwable error;
        final AtomicReference<io.reactivex.disposables.b> upstream;

        static {
            EMPTY = new InnerDisposable[0];
            TERMINATED = new InnerDisposable[0];
        }

        PublishConnection(AtomicReference<PublishConnection<T>> r2) {
            this.connect = new AtomicBoolean();
            this.current = r2;
            this.upstream = new AtomicReference();
            lazySet(EMPTY);
        }

        public boolean add(InnerDisposable<T> r5) {
        L2:
            InnerDisposable[] r0 = (InnerDisposable[]) ZeusTransformUtils.preCheckCast(get(), InnerDisposable[].class, "com.obric.memorydata.plugin");
            if (r0 == TERMINATED) goto L4;
            int r1 = r0.length;
            InnerDisposable[] r3 = new InnerDisposable[r1 + 1];
            System.arraycopy(r0, 0, r3, 0, r1);
            r3[r1] = r5;
            if (compareAndSet(r0, r3) == false) goto L2;
            return true;
        L4:
            return false;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            getAndSet(TERMINATED);
            this.current.compareAndSet(this, null);
            DisposableHelper.dispose(this.upstream);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            if (get() != TERMINATED) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // io.reactivex.t
        public void onComplete() {
            this.upstream.lazySet(DisposableHelper.DISPOSED);
            InnerDisposable[] r3 = (InnerDisposable[]) ZeusTransformUtils.preCheckCast(getAndSet(TERMINATED), InnerDisposable[].class, "com.obric.memorydata.plugin");
            int r0 = r3.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            r3[r1].downstream.onComplete();
            r1 = r1 + 1;
            goto L3
        }

        @Override // io.reactivex.t
        public void onError(Throwable r4) {
            this.error = r4;
            this.upstream.lazySet(DisposableHelper.DISPOSED);
            InnerDisposable[] r3 = (InnerDisposable[]) ZeusTransformUtils.preCheckCast(getAndSet(TERMINATED), InnerDisposable[].class, "com.obric.memorydata.plugin");
            int r0 = r3.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            r3[r1].downstream.onError(r4);
            r1 = r1 + 1;
            goto L3
        }

        @Override // io.reactivex.t
        public void onNext(T r4) {
            InnerDisposable[] r3 = (InnerDisposable[]) ZeusTransformUtils.preCheckCast(get(), InnerDisposable[].class, "com.obric.memorydata.plugin");
            int r0 = r3.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            r3[r1].downstream.onNext(r4);
            r1 = r1 + 1;
            goto L3
        }

        @Override // io.reactivex.t
        public void onSubscribe(io.reactivex.disposables.b r3) {
            io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            DisposableHelper.setOnce(this.upstream, r4);
        }

        public void remove(InnerDisposable<T> r7) {
        L2:
            InnerDisposable<T>[] r0 = (InnerDisposable[]) ZeusTransformUtils.preCheckCast(get(), InnerDisposable[].class, "com.obric.memorydata.plugin");
            int r1 = r0.length;
            if (r1 == 0) goto L4;
            int r2 = -1;
            int r4 = 0;
        L6:
            if (r4 >= r1) goto L11;
            if (r0[r4] == r7) goto L9;
            r4 = r4 + 1;
            goto L6
        L9:
            r2 = r4;
        L11:
            if (r2 < 0) goto L12;
            InnerDisposable[] r5 = EMPTY;
            if (r1 == 1) goto L17;
            r5 = new InnerDisposable[r1 - 1];
            System.arraycopy(r0, 0, r5, 0, r2);
            System.arraycopy(r0, r2 + 1, r5, r2, (r1 - r2) - 1);
        L17:
            if (compareAndSet(r0, r5) == false) goto L2;
            return;
        L12:
            return;
        }
    }

    @Override // io.reactivex.c.a
    public void a(g<? super io.reactivex.disposables.b> r5) {
        g r6 = (g) ZeusTransformUtils.wrapperContextForParams(r5, g.class, "com.obric.memorydata.plugin");
    L3:
        PublishConnection<T> r0 = (PublishConnection) ZeusTransformUtils.preCheckCast(this.f16966b.get(), PublishConnection.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
    L7:
        PublishConnection<T> r2 = new PublishConnection(this.f16966b);
        if (this.f16966b.compareAndSet(r0, r2) == false) goto L3;
        r0 = r2;
    L11:
        boolean r3 = true;
        if (r0.connect.get() == false) goto L14;
    L16:
        r3 = false;
    L24:
        r6.accept(r0);     // Catch: Throwable -> L21
        if (r3 == false) goto L29;
        this.f16965a.subscribe(r0);
        return;
    L29:
        return;
    L21:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        throw ExceptionHelper.a(th);
    L14:
        if (r0.connect.compareAndSet(false, true) == false) goto L16;
    L6:
        if (r0.isDisposed() == false) goto L11;
        goto L7
    }

    @Override // io.reactivex.internal.disposables.c
    public void a(io.reactivex.disposables.b r3) {
        io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
        this.f16966b.compareAndSet((PublishConnection) ZeusTransformUtils.preCheckCast(r4, PublishConnection.class, "com.obric.memorydata.plugin"), null);
    }

    @Override // io.reactivex.Observable
    public void a(t<? super T> r5) {
        t r6 = (t) ZeusTransformUtils.wrapperContextForParams(r5, t.class, "com.obric.memorydata.plugin");
    L3:
        PublishConnection<T> r0 = (PublishConnection) ZeusTransformUtils.preCheckCast(this.f16966b.get(), PublishConnection.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L9;
        PublishConnection<T> r2 = new PublishConnection(this.f16966b);
        if (this.f16966b.compareAndSet(r0, r2) == false) goto L3;
        r0 = r2;
    L9:
        InnerDisposable<T> r4 = new InnerDisposable(r6, r0);
        r6.onSubscribe(r4);
        if (r0.add(r4) == true) goto L12;
        Throwable r7 = r0.error;
        if (r7 == null) goto L18;
        r6.onError(r7);
        return;
    L18:
        r6.onComplete();
        return;
    L12:
        if (r4.isDisposed() == false) goto L23;
        r0.remove(r4);
        return;
    }
}
