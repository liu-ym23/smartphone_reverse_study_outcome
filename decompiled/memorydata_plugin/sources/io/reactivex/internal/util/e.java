package io.reactivex.internal.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.t;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes6.dex */
public final class e {
    public static <T> void a(t<? super T> r2, T r3, AtomicInteger r4, AtomicThrowable r5) {
        t r6 = (t) ZeusTransformUtils.wrapperContextForParams(r2, t.class, "com.obric.memorydata.plugin");
        if (r4.get() == 0) goto L5;
        return;
    L5:
        if (r4.compareAndSet(0, 1) == false) goto L14;
        r6.onNext(r3);
        if (r4.decrementAndGet() == 0) goto L15;
        Throwable r7 = r5.terminate();
        if (r7 == null) goto L11;
        r6.onError(r7);
        return;
    L11:
        r6.onComplete();
        return;
    L15:
        return;
    }

    public static void a(t<?> r2, Throwable r3, AtomicInteger r4, AtomicThrowable r5) {
        t r6 = (t) ZeusTransformUtils.wrapperContextForParams(r2, t.class, "com.obric.memorydata.plugin");
        if (r5.addThrowable(r3) == true) goto L5;
        io.reactivex.d.a.a(r3);
        return;
    L5:
        if (r4.getAndIncrement() != 0) goto L9;
        r6.onError(r5.terminate());
        return;
    }

    public static void a(t<?> r2, AtomicInteger r3, AtomicThrowable r4) {
        t r5 = (t) ZeusTransformUtils.wrapperContextForParams(r2, t.class, "com.obric.memorydata.plugin");
        if (r3.getAndIncrement() != 0) goto L9;
        Throwable r6 = r4.terminate();
        if (r6 == null) goto L7;
        r5.onError(r6);
        return;
    L7:
        r5.onComplete();
        return;
    }

    public static <T> void a(org.a.c<? super T> r2, T r3, AtomicInteger r4, AtomicThrowable r5) {
        org.a.c r6 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r2, org.a.c.class, "com.obric.memorydata.plugin");
        if (r4.get() == 0) goto L5;
        return;
    L5:
        if (r4.compareAndSet(0, 1) == false) goto L14;
        r6.onNext(r3);
        if (r4.decrementAndGet() == 0) goto L15;
        Throwable r7 = r5.terminate();
        if (r7 == null) goto L11;
        r6.onError(r7);
        return;
    L11:
        r6.onComplete();
        return;
    L15:
        return;
    }

    public static void a(org.a.c<?> r2, Throwable r3, AtomicInteger r4, AtomicThrowable r5) {
        org.a.c r6 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r2, org.a.c.class, "com.obric.memorydata.plugin");
        if (r5.addThrowable(r3) == true) goto L5;
        io.reactivex.d.a.a(r3);
        return;
    L5:
        if (r4.getAndIncrement() != 0) goto L9;
        r6.onError(r5.terminate());
        return;
    }

    public static void a(org.a.c<?> r2, AtomicInteger r3, AtomicThrowable r4) {
        org.a.c r5 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r2, org.a.c.class, "com.obric.memorydata.plugin");
        if (r3.getAndIncrement() != 0) goto L9;
        Throwable r6 = r4.terminate();
        if (r6 == null) goto L7;
        r5.onError(r6);
        return;
    L7:
        r5.onComplete();
        return;
    }
}
