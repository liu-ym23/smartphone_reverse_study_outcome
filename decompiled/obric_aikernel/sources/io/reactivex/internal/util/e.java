package io.reactivex.internal.util;

import java.util.concurrent.atomic.AtomicInteger;
import xb.o;

/* JADX INFO: loaded from: classes2.dex */
public final class e {
    public static void a(tc.c<?> r10, AtomicInteger r11, AtomicThrowable r12) {
        if (r11.getAndIncrement() != 0) goto L9;
        Throwable r13 = r12.terminate();
        if (r13 == null) goto L7;
        r10.onError(r13);
        return;
    L7:
        r10.onComplete();
        return;
    }

    public static void b(o<?> r10, AtomicInteger r11, AtomicThrowable r12) {
        if (r11.getAndIncrement() != 0) goto L9;
        Throwable r13 = r12.terminate();
        if (r13 == null) goto L7;
        r10.onError(r13);
        return;
    L7:
        r10.onComplete();
        return;
    }

    public static void c(tc.c<?> r10, Throwable r11, AtomicInteger r12, AtomicThrowable r13) {
        if (r13.addThrowable(r11) == true) goto L5;
        dc.a.n(r11);
        return;
    L5:
        if (r12.getAndIncrement() != 0) goto L9;
        r10.onError(r13.terminate());
        return;
    }

    public static void d(o<?> r10, Throwable r11, AtomicInteger r12, AtomicThrowable r13) {
        if (r13.addThrowable(r11) == true) goto L5;
        dc.a.n(r11);
        return;
    L5:
        if (r12.getAndIncrement() != 0) goto L9;
        r10.onError(r13.terminate());
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void e(tc.c<? super T> r10, T r11, AtomicInteger r12, AtomicThrowable r13) {
        if (r12.get() == 0) goto L5;
        return;
    L5:
        if (r12.compareAndSet(0, 1) == false) goto L14;
        r10.onNext(r11);
        if (r12.decrementAndGet() == 0) goto L15;
        Throwable r14 = r13.terminate();
        if (r14 == null) goto L11;
        r10.onError(r14);
        return;
    L11:
        r10.onComplete();
        return;
    L15:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void f(o<? super T> r10, T r11, AtomicInteger r12, AtomicThrowable r13) {
        if (r12.get() == 0) goto L5;
        return;
    L5:
        if (r12.compareAndSet(0, 1) == false) goto L14;
        r10.onNext(r11);
        if (r12.decrementAndGet() == 0) goto L15;
        Throwable r14 = r13.terminate();
        if (r14 == null) goto L11;
        r10.onError(r14);
        return;
    L11:
        r10.onComplete();
        return;
    L15:
        return;
    }
}
