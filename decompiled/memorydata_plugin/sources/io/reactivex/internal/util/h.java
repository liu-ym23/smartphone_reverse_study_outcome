package io.reactivex.internal.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.queue.SpscArrayQueue;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes6.dex */
public final class h {
    public static <T> io.reactivex.internal.a.f<T> a(int r1) {
        if (r1 >= 0) goto L6;
        return new io.reactivex.internal.queue.a(-r1);
    L6:
        return new SpscArrayQueue(r1);
    }

    public static <T> void a(org.a.c<? super T> r8, Queue<T> r9, AtomicLong r10, io.reactivex.b.e r11) {
        org.a.c r12 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r8, org.a.c.class, "com.obric.memorydata.plugin");
        Queue r13 = (Queue) ZeusTransformUtils.wrapperContextForParams(r9, Queue.class, "com.obric.memorydata.plugin");
        io.reactivex.b.e r14 = (io.reactivex.b.e) ZeusTransformUtils.wrapperContextForParams(r11, io.reactivex.b.e.class, "com.obric.memorydata.plugin");
        if (r13.isEmpty() == false) goto L7;
        r12.onComplete();
        return;
    L7:
        if (b(r10.get(), r12, r13, r10, r14) == false) goto L9;
        return;
    L9:
        long r0 = r10.get();
        if ((r0 & Long.MIN_VALUE) != 0) goto L11;
        long r2 = Long.MIN_VALUE | r0;
        if (r10.compareAndSet(r0, r2) == false) goto L9;
        if (r0 == 0) goto L21;
        b(r2, r12, r13, r10, r14);
        return;
    L21:
        return;
    }

    public static void a(org.a.d r2, int r3) {
        org.a.d r4 = (org.a.d) ZeusTransformUtils.wrapperContextForParams(r2, org.a.d.class, "com.obric.memorydata.plugin");
        if (r3 >= 0) goto L5;
        long r0 = Long.MAX_VALUE;
    L6:
        r4.request(r0);
        return;
    L5:
        r0 = r3;
        goto L6
    }

    public static <T> boolean a(long r10, org.a.c<? super T> r12, Queue<T> r13, AtomicLong r14, io.reactivex.b.e r15) {
        org.a.c r4 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r12, org.a.c.class, "com.obric.memorydata.plugin");
        Queue r5 = (Queue) ZeusTransformUtils.wrapperContextForParams(r13, Queue.class, "com.obric.memorydata.plugin");
        io.reactivex.b.e r7 = (io.reactivex.b.e) ZeusTransformUtils.wrapperContextForParams(r15, io.reactivex.b.e.class, "com.obric.memorydata.plugin");
    L3:
        long r16 = r14.get();
        long r0 = b.a(Long.MAX_VALUE & r16, r10);
        if (r14.compareAndSet(r16, r0 | (r16 & Long.MIN_VALUE)) == false) goto L3;
        if (r16 != Long.MIN_VALUE) goto L9;
        b(Long.MIN_VALUE | r10, r4, r5, r14, r7);
        return true;
    L9:
        return false;
    }

    static boolean a(io.reactivex.b.e r2) {
        return ((io.reactivex.b.e) ZeusTransformUtils.wrapperContextForParams(r2, io.reactivex.b.e.class, "com.obric.memorydata.plugin")).getAsBoolean();
    L5:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static <T> boolean b(long r8, org.a.c<? super T> r10, Queue<T> r11, AtomicLong r12, io.reactivex.b.e r13) {
        org.a.c r14 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r10, org.a.c.class, "com.obric.memorydata.plugin");
        Queue r15 = (Queue) ZeusTransformUtils.wrapperContextForParams(r11, Queue.class, "com.obric.memorydata.plugin");
        io.reactivex.b.e r16 = (io.reactivex.b.e) ZeusTransformUtils.wrapperContextForParams(r13, io.reactivex.b.e.class, "com.obric.memorydata.plugin");
        long r2 = r8 & Long.MIN_VALUE;
    L4:
        if (r2 != r8) goto L6;
        if (a(r16) == true) goto L15;
        if (r15.isEmpty() == true) goto L18;
        r8 = r12.get();
        if (r8 != r2) goto L4;
        long r3 = r12.addAndGet(-(r2 & Long.MAX_VALUE));
        if ((Long.MAX_VALUE & r3) == 0) goto L24;
        r8 = r3;
        r2 = r3 & Long.MIN_VALUE;
        goto L4
    L24:
        return false;
    L18:
        r14.onComplete();
        return true;
    L15:
        return true;
    L6:
        if (a(r16) == true) goto L7;
        Object r4 = r15.poll();
        if (r4 == null) goto L10;
        r14.onNext(r4);
        r2 = r2 + 1;
        goto L4
    L10:
        r14.onComplete();
        return true;
    L7:
        return true;
    }
}
