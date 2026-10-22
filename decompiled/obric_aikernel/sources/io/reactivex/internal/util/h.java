package io.reactivex.internal.util;

import io.reactivex.internal.queue.SpscArrayQueue;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public final class h {
    public static <T> bc.f<T> a(int r10) {
        if (r10 >= 0) goto L6;
        return new io.reactivex.internal.queue.a(-r10);
    L6:
        return new SpscArrayQueue(r10);
    }

    static boolean b(zb.e r10) {
        return r10.getAsBoolean();
    L4:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        return true;
    }

    public static <T> void c(tc.c<? super T> r14, Queue<T> r15, AtomicLong r16, zb.e r17) {
        if (r15.isEmpty() == false) goto L7;
        r14.onComplete();
        return;
    L7:
        if (d(r16.get(), r14, r15, r16, r17) == false) goto L9;
        return;
    L9:
        long r10 = r16.get();
        if ((r10 & Long.MIN_VALUE) != 0) goto L11;
        long r11 = r10 | Long.MIN_VALUE;
        if (r16.compareAndSet(r10, r11) == false) goto L9;
        if (r10 == 0) goto L21;
        d(r11, r14, r15, r16, r17);
        return;
    L21:
        return;
    }

    static <T> boolean d(long r10, tc.c<? super T> r11, Queue<T> r12, AtomicLong r13, zb.e r14) {
        long r15 = r10 & Long.MIN_VALUE;
    L4:
        if (r15 != r10) goto L6;
        if (b(r14) == true) goto L15;
        if (r12.isEmpty() == true) goto L18;
        r10 = r13.get();
        if (r10 != r15) goto L4;
        long r16 = r13.addAndGet(-(r15 & Long.MAX_VALUE));
        if ((Long.MAX_VALUE & r16) == 0) goto L24;
        r10 = r16;
        r15 = r16 & Long.MIN_VALUE;
        goto L4
    L24:
        return false;
    L18:
        r11.onComplete();
        return true;
    L15:
        return true;
    L6:
        if (b(r14) == true) goto L7;
        T r17 = r12.poll();
        if (r17 == null) goto L10;
        r11.onNext(r17);
        r15 = r15 + 1;
        goto L4
    L10:
        r11.onComplete();
        return true;
    L7:
        return true;
    }

    public static <T> boolean e(long r14, tc.c<? super T> r16, Queue<T> r17, AtomicLong r18, zb.e r19) {
    L3:
        long r10 = r18.get();
        long r11 = b.c(Long.MAX_VALUE & r10, r14);
        if (r18.compareAndSet(r10, r11 | (r10 & Long.MIN_VALUE)) == false) goto L3;
        if (r10 != Long.MIN_VALUE) goto L9;
        d(r14 | Long.MIN_VALUE, r16, r17, r18, r19);
        return true;
    L9:
        return false;
    }

    public static void f(tc.d r10, int r11) {
        if (r11 >= 0) goto L4;
        long r12 = Long.MAX_VALUE;
    L5:
        r10.request(r12);
        return;
    L4:
        r12 = r11;
        goto L5
    }
}
