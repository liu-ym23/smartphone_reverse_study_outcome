package io.reactivex.internal.operators.observable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.h;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.s;
import io.reactivex.t;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes6.dex */
public final class ObservableScalarXMap {

    public static final class ScalarDisposable<T> extends AtomicInteger implements io.reactivex.internal.a.b<T>, Runnable {
        static final int FUSED = 1;
        static final int ON_COMPLETE = 3;
        static final int ON_NEXT = 2;
        static final int START = 0;
        private static final long serialVersionUID = 3880992722410194083L;
        final t<? super T> observer;
        final T value;

        public ScalarDisposable(t<? super T> r3, T r4) {
            this.observer = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
            this.value = r4;
        }

        @Override // io.reactivex.internal.a.f
        public void clear() {
            lazySet(3);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            set(3);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            if (get() != 3) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // io.reactivex.internal.a.f
        public boolean isEmpty() {
            if (get() != 1) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // io.reactivex.internal.a.f
        public boolean offer(T r1) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        public boolean offer(T r1, T r2) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        @Override // io.reactivex.internal.a.f
        public T poll() {
            if (get() != 1) goto L6;
            lazySet(3);
            return this.value;
        L6:
            return null;
        }

        @Override // io.reactivex.internal.a.c
        public int requestFusion(int r2) {
            if ((r2 & 1) == 0) goto L6;
            lazySet(1);
            return 1;
        L6:
            return 0;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (get() == 0) goto L5;
            return;
        L5:
            if (compareAndSet(0, 2) == false) goto L11;
            this.observer.onNext(this.value);
            if (get() != 2) goto L12;
            lazySet(3);
            this.observer.onComplete();
            return;
        L12:
            return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T, R> boolean a(s<T> r3, t<? super R> r4, h<? super T, ? extends s<? extends R>> r5) {
        s r6 = (s) ZeusTransformUtils.wrapperContextForParams(r3, s.class, "com.obric.memorydata.plugin");
        t<? super T> r7 = (t) ZeusTransformUtils.wrapperContextForParams(r4, t.class, "com.obric.memorydata.plugin");
        h r8 = (h) ZeusTransformUtils.wrapperContextForParams(r5, h.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, Callable.class) == true) goto L24;
        return false;
    L24:
        Object r9 = ((Callable) ZeusTransformUtils.preCheckCast(r6, Callable.class, "com.obric.memorydata.plugin")).call();     // Catch: Throwable -> L17
        if (r9 != null) goto L9;
        EmptyDisposable.complete(r7);
        return true;
    L9:
        s r10 = (s) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(r8.apply(r9), "The mapper returned a null ObservableSource"), s.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        if (ZeusTransformUtils.instanceOf(r10, Callable.class) == false) goto L20;
        Object r11 = ((Callable) ZeusTransformUtils.preCheckCast(r10, Callable.class, "com.obric.memorydata.plugin")).call();     // Catch: Throwable -> L17
        if (r11 != null) goto L16;
        EmptyDisposable.complete(r7);
        return true;
    L16:
        ScalarDisposable r12 = new ScalarDisposable(r7, r11);
        r7.onSubscribe(r12);
        r12.run();
    L21:
        return true;
    L20:
        r10.subscribe(r7);
    L17:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        EmptyDisposable.error(th, r7);
        return true;
    }
}
