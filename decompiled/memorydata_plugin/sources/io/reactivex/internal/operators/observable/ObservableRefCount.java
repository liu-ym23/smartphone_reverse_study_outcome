package io.reactivex.internal.operators.observable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.Observable;
import io.reactivex.b.g;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.t;
import io.reactivex.u;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class ObservableRefCount<T> extends Observable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final io.reactivex.c.a<T> f16974a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f16975b;
    final long c;
    final TimeUnit d;
    final u e;
    RefConnection f;

    static final class RefConnection extends AtomicReference<io.reactivex.disposables.b> implements g<io.reactivex.disposables.b>, Runnable {
        private static final long serialVersionUID = -4552101107598366241L;
        boolean connected;
        boolean disconnectedEarly;
        final ObservableRefCount<?> parent;
        long subscriberCount;
        io.reactivex.disposables.b timer;

        RefConnection(ObservableRefCount<?> r1) {
            this.parent = r1;
        }

        /* JADX INFO: renamed from: accept, reason: avoid collision after fix types in other method */
        public void accept2(io.reactivex.disposables.b r4) {
            io.reactivex.disposables.b r5 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r4, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            DisposableHelper.replace(this, r5);
            ObservableRefCount<?> r0 = this.parent;
            monitor-enter(r0);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (this.disconnectedEarly == false) goto L7;
            ((io.reactivex.internal.disposables.c) ZeusTransformUtils.preCheckCast(this.parent.f16974a, io.reactivex.internal.disposables.c.class, "com.obric.memorydata.plugin")).a(r5);     // Catch: Throwable -> L9
        L7:
            monitor-exit(r0);     // Catch: Throwable -> L9
        }

        @Override // io.reactivex.b.g
        public /* synthetic */ void accept(io.reactivex.disposables.b r3) {
            accept2((io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
        }

        @Override // java.lang.Runnable
        public void run() {
            this.parent.e(this);
        }
    }

    static final class RefCountObserver<T> extends AtomicBoolean implements io.reactivex.disposables.b, t<T> {
        private static final long serialVersionUID = -7419642935409022375L;
        final RefConnection connection;
        final t<? super T> downstream;
        final ObservableRefCount<T> parent;
        io.reactivex.disposables.b upstream;

        RefCountObserver(t<? super T> r3, ObservableRefCount<T> r4, RefConnection r5) {
            this.downstream = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
            this.parent = r4;
            this.connection = r5;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.upstream.dispose();
            if (compareAndSet(false, true) == false) goto L6;
            this.parent.a(this.connection);
            return;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.t
        public void onComplete() {
            if (compareAndSet(false, true) == false) goto L6;
            this.parent.b(this.connection);
            this.downstream.onComplete();
            return;
        }

        @Override // io.reactivex.t
        public void onError(Throwable r3) {
            if (compareAndSet(false, true) == false) goto L5;
            this.parent.b(this.connection);
            this.downstream.onError(r3);
            return;
        L5:
            io.reactivex.d.a.a(r3);
        }

        @Override // io.reactivex.t
        public void onNext(T r1) {
            this.downstream.onNext(r1);
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

    void a(RefConnection r5) {
        monitor-enter(this);
        RefConnection r0 = this.f;     // Catch: Throwable -> L25
        if (r0 == null) goto L23;
        if (r0 != r5) goto L23;
        long r1 = r5.subscriberCount - 1;     // Catch: Throwable -> L25
        r5.subscriberCount = r1;     // Catch: Throwable -> L25
        if (r1 == 0) goto L10;
    L21:
        monitor-exit(this);     // Catch: Throwable -> L25
        return;
    L10:
        if (r5.connected == false) goto L21;
        if (this.c != 0) goto L17;
        e(r5);     // Catch: Throwable -> L25
        monitor-exit(this);     // Catch: Throwable -> L25
        return;
    L17:
        SequentialDisposable r2 = new SequentialDisposable();     // Catch: Throwable -> L25
        r5.timer = r2;     // Catch: Throwable -> L25
        monitor-exit(this);     // Catch: Throwable -> L25
        r2.replace(this.e.a(r5, this.c, this.d));
        return;
    L23:
        monitor-exit(this);     // Catch: Throwable -> L25
        return;
    L25:
        th = move-exception;
        throw th;
    }

    @Override // io.reactivex.Observable
    public void a(t<? super T> r8) {
        t r9 = (t) ZeusTransformUtils.wrapperContextForParams(r8, t.class, "com.obric.memorydata.plugin");
        monitor-enter(this);
        RefConnection r0 = this.f;     // Catch: Throwable -> L23
        if (r0 != null) goto L7;
        r0 = new RefConnection(this);     // Catch: Throwable -> L23
        this.f = r0;     // Catch: Throwable -> L23
    L7:
        long r1 = r0.subscriberCount;     // Catch: Throwable -> L23
        if (r1 == 0) goto L10;
    L12:
        long r2 = r1 + 1;     // Catch: Throwable -> L23
        r0.subscriberCount = r2;     // Catch: Throwable -> L23
        boolean r4 = true;
        if (r0.connected == false) goto L15;
    L17:
        r4 = false;
    L18:
        monitor-exit(this);     // Catch: Throwable -> L23
        this.f16974a.subscribe(new RefCountObserver(r9, this, r0));
        if (r4 == false) goto L28;
        this.f16974a.a(r0);
        return;
    L28:
        return;
    L15:
        if (r2 != this.f16975b) goto L17;
        r0.connected = true;     // Catch: Throwable -> L23
        goto L18
    L10:
        if (r0.timer == null) goto L12;
        r0.timer.dispose();     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    }

    void b(RefConnection r9) {
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L4:
        if (ZeusTransformUtils.instanceOf(this.f16974a, c.class) == false) goto L12;
        RefConnection r0 = this.f;     // Catch: Throwable -> L20
        if (r0 == null) goto L9;
        if (r0 != r9) goto L9;
        this.f = null;     // Catch: Throwable -> L20
        c(r9);     // Catch: Throwable -> L20
    L9:
        long r1 = r9.subscriberCount - 1;     // Catch: Throwable -> L20
        r9.subscriberCount = r1;     // Catch: Throwable -> L20
        if (r1 != 0) goto L18;
    L11:
        d(r9);     // Catch: Throwable -> L20
    L18:
        monitor-exit(this);     // Catch: Throwable -> L20
        return;
    L12:
        RefConnection r2 = this.f;     // Catch: Throwable -> L20
        if (r2 == null) goto L18;
        if (r2 != r9) goto L18;
        c(r9);     // Catch: Throwable -> L20
        long r6 = r9.subscriberCount - 1;     // Catch: Throwable -> L20
        r9.subscriberCount = r6;     // Catch: Throwable -> L20
        if (r6 != 0) goto L18;
        this.f = null;     // Catch: Throwable -> L20
        goto L11
    }

    void c(RefConnection r1) {
        if (r1.timer == null) goto L6;
        r1.timer.dispose();
        r1.timer = null;
        return;
    }

    void d(RefConnection r4) {
        if (ZeusTransformUtils.instanceOf(this.f16974a, io.reactivex.disposables.b.class) == false) goto L6;
        ((io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(this.f16974a, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin")).dispose();
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(this.f16974a, io.reactivex.internal.disposables.c.class) == false) goto L10;
        ((io.reactivex.internal.disposables.c) ZeusTransformUtils.preCheckCast(this.f16974a, io.reactivex.internal.disposables.c.class, "com.obric.memorydata.plugin")).a((io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(r4.get(), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
        return;
    }

    void e(RefConnection r5) {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (r5.subscriberCount == 0) goto L6;
    L15:
        monitor-exit(this);     // Catch: Throwable -> L17
        return;
    L6:
        if (r5 != this.f) goto L15;
        this.f = null;     // Catch: Throwable -> L17
        io.reactivex.disposables.b r0 = (io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(r5.get(), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        DisposableHelper.dispose(r5);     // Catch: Throwable -> L17
        if (ZeusTransformUtils.instanceOf(this.f16974a, io.reactivex.disposables.b.class) == false) goto L11;
        ((io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(this.f16974a, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin")).dispose();     // Catch: Throwable -> L17
        goto L15
    L11:
        if (ZeusTransformUtils.instanceOf(this.f16974a, io.reactivex.internal.disposables.c.class) == false) goto L15;
        if (r0 != null) goto L14;
        r5.disconnectedEarly = true;     // Catch: Throwable -> L17
        goto L15
    L14:
        ((io.reactivex.internal.disposables.c) ZeusTransformUtils.preCheckCast(this.f16974a, io.reactivex.internal.disposables.c.class, "com.obric.memorydata.plugin")).a(r0);     // Catch: Throwable -> L17
        goto L15
    }
}
