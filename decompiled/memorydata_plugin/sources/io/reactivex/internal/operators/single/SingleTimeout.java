package io.reactivex.internal.operators.single;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.u;
import io.reactivex.v;
import io.reactivex.x;
import io.reactivex.z;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class SingleTimeout<T> extends v<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final z<T> f17088a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f17089b;
    final TimeUnit c;
    final u d;
    final z<? extends T> e;

    static final class TimeoutMainObserver<T> extends AtomicReference<b> implements b, x<T>, Runnable {
        private static final long serialVersionUID = 37497744973048446L;
        final x<? super T> downstream;
        final TimeoutFallbackObserver<T> fallback;
        z<? extends T> other;
        final AtomicReference<b> task;
        final long timeout;
        final TimeUnit unit;

        static final class TimeoutFallbackObserver<T> extends AtomicReference<b> implements x<T> {
            private static final long serialVersionUID = 2071387740092105509L;
            final x<? super T> downstream;

            TimeoutFallbackObserver(x<? super T> r3) {
                this.downstream = (x) ZeusTransformUtils.wrapperContextForParams(r3, x.class, "com.obric.memorydata.plugin");
            }

            @Override // io.reactivex.x
            public void onError(Throwable r1) {
                this.downstream.onError(r1);
            }

            @Override // io.reactivex.x
            public void onSubscribe(b r3) {
                DisposableHelper.setOnce(this, (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin"));
            }

            @Override // io.reactivex.x
            public void onSuccess(T r1) {
                this.downstream.onSuccess(r1);
            }
        }

        TimeoutMainObserver(x<? super T> r3, z<? extends T> r4, long r5, TimeUnit r7) {
            x<? super T> r6 = (x) ZeusTransformUtils.wrapperContextForParams(r3, x.class, "com.obric.memorydata.plugin");
            z<? extends T> r8 = (z) ZeusTransformUtils.wrapperContextForParams(r4, z.class, "com.obric.memorydata.plugin");
            this.downstream = r6;
            this.other = r8;
            this.timeout = r5;
            this.unit = r7;
            this.task = new AtomicReference();
            if (r8 == null) goto L5;
            this.fallback = new TimeoutFallbackObserver(r6);
            return;
        L5:
            this.fallback = null;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
            DisposableHelper.dispose(this.task);
            TimeoutFallbackObserver<T> r1 = this.fallback;
            if (r1 == null) goto L6;
            DisposableHelper.dispose(r1);
            return;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed((b) ZeusTransformUtils.preCheckCast(get(), b.class, "com.obric.memorydata.plugin"));
        }

        @Override // io.reactivex.x
        public void onError(Throwable r4) {
            b r0 = (b) ZeusTransformUtils.preCheckCast(get(), b.class, "com.obric.memorydata.plugin");
            if (r0 != DisposableHelper.DISPOSED) goto L5;
        L7:
            io.reactivex.d.a.a(r4);
            return;
        L5:
            if (compareAndSet(r0, DisposableHelper.DISPOSED) == false) goto L7;
            DisposableHelper.dispose(this.task);
            this.downstream.onError(r4);
        }

        @Override // io.reactivex.x
        public void onSubscribe(b r3) {
            DisposableHelper.setOnce(this, (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin"));
        }

        @Override // io.reactivex.x
        public void onSuccess(T r4) {
            b r0 = (b) ZeusTransformUtils.preCheckCast(get(), b.class, "com.obric.memorydata.plugin");
            if (r0 != DisposableHelper.DISPOSED) goto L5;
            return;
        L5:
            if (compareAndSet(r0, DisposableHelper.DISPOSED) == false) goto L9;
            DisposableHelper.dispose(this.task);
            this.downstream.onSuccess(r4);
            return;
        }

        @Override // java.lang.Runnable
        public void run() {
            b r0 = (b) ZeusTransformUtils.preCheckCast(get(), b.class, "com.obric.memorydata.plugin");
            if (r0 != DisposableHelper.DISPOSED) goto L5;
            return;
        L5:
            if (compareAndSet(r0, DisposableHelper.DISPOSED) == false) goto L14;
            if (r0 == null) goto L8;
            r0.dispose();
        L8:
            z<? extends T> r1 = this.other;
            if (r1 != null) goto L11;
            this.downstream.onError(new TimeoutException(ExceptionHelper.a(this.timeout, this.unit)));
            return;
        L11:
            this.other = null;
            r1.a(this.fallback);
            return;
        }
    }

    @Override // io.reactivex.v
    public void b(x<? super T> r8) {
        x r9 = (x) ZeusTransformUtils.wrapperContextForParams(r8, x.class, "com.obric.memorydata.plugin");
        TimeoutMainObserver r6 = new TimeoutMainObserver(r9, this.e, this.f17089b, this.c);
        r9.onSubscribe(r6);
        DisposableHelper.replace(r6.task, this.d.a(r6, this.f17089b, this.c));
        this.f17088a.a(r6);
    }
}
