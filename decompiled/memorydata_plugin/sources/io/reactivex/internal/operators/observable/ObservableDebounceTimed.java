package io.reactivex.internal.operators.observable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.t;
import io.reactivex.u;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class ObservableDebounceTimed<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f16939b;
    final TimeUnit c;
    final u d;

    static final class DebounceEmitter<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, Runnable {
        private static final long serialVersionUID = 6812032969491025141L;
        final long idx;
        final AtomicBoolean once;
        final a<T> parent;
        final T value;

        DebounceEmitter(T r2, long r3, a<T> r5) {
            this.once = new AtomicBoolean();
            this.value = r2;
            this.idx = r3;
            this.parent = r5;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            if (get() != DisposableHelper.DISPOSED) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.once.compareAndSet(false, true) == false) goto L6;
            this.parent.a(this.idx, this.value, this);
            return;
        }

        public void setResource(io.reactivex.disposables.b r3) {
            DisposableHelper.replace(this, (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
        }
    }

    static final class a<T> implements io.reactivex.disposables.b, t<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final t<? super T> f16940a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f16941b;
        final TimeUnit c;
        final u.c d;
        io.reactivex.disposables.b e;
        io.reactivex.disposables.b f;
        volatile long g;
        boolean h;

        a(t<? super T> r3, long r4, TimeUnit r6, u.c r7) {
            this.f16940a = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
            this.f16941b = r4;
            this.c = r6;
            this.d = r7;
        }

        void a(long r3, T r5, DebounceEmitter<T> r6) {
            if (r3 != this.g) goto L6;
            this.f16940a.onNext(r5);
            r6.dispose();
            return;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.e.dispose();
            this.d.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.d.isDisposed();
        }

        @Override // io.reactivex.t
        public void onComplete() {
            if (this.h == false) goto L5;
            return;
        L5:
            this.h = true;
            io.reactivex.disposables.b r0 = this.f;
            if (r0 == null) goto L8;
            r0.dispose();
        L8:
            DebounceEmitter r1 = (DebounceEmitter) ZeusTransformUtils.preCheckCast(r0, DebounceEmitter.class, "com.obric.memorydata.plugin");
            if (r1 == null) goto L11;
            r1.run();
        L11:
            this.f16940a.onComplete();
            this.d.dispose();
        }

        @Override // io.reactivex.t
        public void onError(Throwable r2) {
            if (this.h == false) goto L6;
            io.reactivex.d.a.a(r2);
            return;
        L6:
            io.reactivex.disposables.b r0 = this.f;
            if (r0 == null) goto L9;
            r0.dispose();
        L9:
            this.h = true;
            this.f16940a.onError(r2);
            this.d.dispose();
        }

        @Override // io.reactivex.t
        public void onNext(T r5) {
            if (this.h == false) goto L5;
            return;
        L5:
            long r0 = this.g + 1;
            this.g = r0;
            io.reactivex.disposables.b r2 = this.f;
            if (r2 == null) goto L8;
            r2.dispose();
        L8:
            DebounceEmitter r3 = new DebounceEmitter(r5, r0, this);
            this.f = r3;
            r3.setResource(this.d.a(r3, this.f16941b, this.c));
        }

        @Override // io.reactivex.t
        public void onSubscribe(io.reactivex.disposables.b r3) {
            io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            if (DisposableHelper.validate(this.e, r4) == false) goto L6;
            this.e = r4;
            this.f16940a.onSubscribe(this);
            return;
        }
    }

    @Override // io.reactivex.Observable
    public void a(t<? super T> r9) {
        t r10 = (t) ZeusTransformUtils.wrapperContextForParams(r9, t.class, "com.obric.memorydata.plugin");
        this.f17034a.subscribe(new a(new io.reactivex.observers.b(r10), this.f16939b, this.c, this.d.a()));
    }
}
