package com.bytedance.forest.utils.io;

import ai.j0;
import com.bytedance.forest.utils.q;
import com.lynx.tasm.p;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends ByteArrayOutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f4631a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f4632b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CountDownLatch f4633c;
    public final Object d;
    public com.bytedance.forest.utils.d e;
    public final AtomicInteger f;

    public a(int r5, com.bytedance.forest.utils.d r10, AtomicInteger r11) {
        super(r5);
        this.e = r10;
        this.f = r11;
        this.f4631a = new AtomicBoolean(false);
        this.f4632b = new AtomicBoolean(false);
        this.f4633c = new CountDownLatch(1);
        this.d = new Object();
    }

    public final int a(int r26, byte[] r27, int r28, int r29) {
        if (this.f4632b.get() == true) goto L43;
        Ref.IntRef r5 = new Ref.IntRef();
        int r10 = this.f.getAndIncrement();
        Object r11 = this.d;
        monitor-enter(r11);
        r5.element = ((ByteArrayOutputStream) this).count - r26;     // Catch: Throwable -> L20
    L8:
        if (r5.element > 0) goto L26;
        com.bytedance.forest.utils.d.b(this.e, 3, "Concurrent", '[' + r10 + "]count=" + ((ByteArrayOutputStream) this).count + ", start=" + r26 + ", sizeCanRead=" + r5.element + ", isFulFilled=" + this.f4631a.get() + ", isClosed=" + this.f4632b, false, null, null, 56);     // Catch: Throwable -> L20
        if (this.f4631a.get() == true) goto L22;
        if (this.f4632b.get() == true) goto L22;
        com.bytedance.forest.utils.d.b(this.e, 3, "Concurrent", '[' + r10 + "]start to wait writing", false, null, null, 56);     // Catch: Throwable -> L20
        Object r12 = this.d;     // Catch: Throwable -> L20
        if (q.b() == false) goto L17;
        long r13 = 500;
    L18:
        r12.wait(r13);     // Catch: Throwable -> L20
        com.bytedance.forest.utils.d.b(this.e, 3, "Concurrent", '[' + r10 + "]receive write side release", false, null, null, 56);     // Catch: Throwable -> L20
        r5.element = ((ByteArrayOutputStream) this).count - r26;     // Catch: Throwable -> L20
        goto L8
    L17:
        r13 = 1000;
    L22:
        monitor-exit(r11);
        return -1;
    L26:
        if (this.f4632b.get() == false) goto L29;
        monitor-exit(r11);
        return -1;
    L29:
        Integer r14 = Integer.valueOf(((ByteArrayOutputStream) this).count);     // Catch: Throwable -> L20
        byte[] r15 = ((ByteArrayOutputStream) this).buf;     // Catch: Throwable -> L20
        if (r15 != null) goto L32;
        Intrinsics.throwNpe();     // Catch: Throwable -> L20
    L32:
        Pair r16 = TuplesKt.to(r14, r15);     // Catch: Throwable -> L20
        monitor-exit(r11);
        int r17 = ((Number) r16.component1()).intValue();
        byte[] r18 = (byte[]) r16.component2();
        com.bytedance.forest.utils.d r19 = this.e;
        StringBuilder r20 = j0.v("[", r10, r17, "]get snapshot: {maxReadableSize:", ", buffer:");
        r20.append(r18);
        r20.append(", sizeCanRead=");
        com.bytedance.forest.utils.d.b(r19, 4, "Concurrent", j0.n(r20, r5.element, '}'), false, null, null, 56);
        int r21 = Integer.min(r27.length - r28, r29);
        if (r21 > 0) goto L38;
        return 0;
    L38:
        int r22 = Integer.min(r5.element, r21);
        com.bytedance.forest.utils.d r23 = this.e;
        StringBuilder r24 = p.d(r10, "[", "]read from buffer: {sizeCanRead:");
        androidx.room.jarjarred.org.antlr.runtime.a.C(r24, r5.element, ", sizeToRead:", r21, ", readSize=");
        com.bytedance.forest.utils.d.b(r23, 4, "Concurrent", j0.n(r24, r22, '}'), false, null, null, 56);
        ArraysKt.copyInto(r18, r27, r28, r26, r26 + r22);
        return r22;
    L20:
        th = move-exception;
        throw th;
    L43:
        throw new IOException("ConcurrentIOMeta closed!");
    }

    public final void b() {
        if (this.f4631a.compareAndSet(false, true) == true) goto L6;
        com.bytedance.forest.utils.d.b(this.e, 4, "Concurrent", "already finished when invoke finish", false, null, null, 56);
        return;
    L6:
        com.bytedance.forest.utils.d.b(this.e, 4, "Concurrent", "invoke finished success, closed=" + this.f4632b.get(), false, null, null, 56);
        int r5 = e();
        byte[] r10 = ((ByteArrayOutputStream) this).buf;
        if (r10 != null) goto L10;
        Intrinsics.throwNpe();
    L10:
        if (r5 >= r10.length) goto L12;
        ((ByteArrayOutputStream) this).buf = Arrays.copyOf(((ByteArrayOutputStream) this).buf, e());
    L12:
        Object r11 = this.d;
        monitor-enter(r11);
        com.bytedance.forest.utils.d.b(this.e, 3, "Concurrent", "release locker for #finish", false, null, null, 56);     // Catch: Throwable -> L18
        this.d.notifyAll();     // Catch: Throwable -> L18
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L18
        monitor-exit(r11);
        this.f4633c.countDown();
        com.bytedance.forest.utils.d.b(this.e, 3, "Concurrent", "release finishWaiter for #finish", false, null, null, 56);
        return;
    L18:
        th = move-exception;
        throw th;
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f4632b.compareAndSet(false, true) == false) goto L14;
        com.bytedance.forest.utils.d.b(this.e, 4, "Concurrent", "ConcurrentIOMeta@" + hashCode() + " closed", false, null, null, 56);
        super.close();
        Object r5 = this.d;
        monitor-enter(r5);
        ((ByteArrayOutputStream) this).buf = null;     // Catch: Throwable -> L11
        ((ByteArrayOutputStream) this).count = 0;     // Catch: Throwable -> L11
        com.bytedance.forest.utils.d.b(this.e, 3, "Concurrent", "release locker for #close", false, null, null, 56);     // Catch: Throwable -> L11
        this.d.notifyAll();     // Catch: Throwable -> L11
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r5);
        this.f4633c.countDown();
        com.bytedance.forest.utils.d.b(this.e, 3, "Concurrent", "release finishWaiter for #close", false, null, null, 56);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final byte[] d() {
        return ((ByteArrayOutputStream) this).buf;
    }

    public final int e() {
        Object r5 = this.d;
        monitor-enter(r5);
        int r10 = ((ByteArrayOutputStream) this).count;     // Catch: Throwable -> L7
        monitor-exit(r5);
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.io.ByteArrayOutputStream
    public final String toString() {
        return "ConcurrentIOMeta@" + hashCode() + "(readAvailable=" + e() + ", isFulFilled=" + this.f4631a.get() + ", isClosed=" + this.f4632b.get() + ')';
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public final void write(byte[] r13, int r14, int r15) {
        if (r13 == null) goto L21;
        Object r5 = this.d;
        monitor-enter(r5);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.f4632b.get() == true) goto L17;
        if (this.f4631a.get() == false) goto L13;
        com.bytedance.forest.utils.d.b(this.e, 6, "Concurrent", "buffer has been fulfilled, buffer={b:" + ((ByteArrayOutputStream) this).buf + ", size:" + ((ByteArrayOutputStream) this).count + "}, write={b:" + r13 + ", off:" + r14 + ", len:" + r15 + '}', true, null, null, 48);     // Catch: Throwable -> L11
    L13:
        com.bytedance.forest.utils.d.b(this.e, 3, "Concurrent", "write (bytes:" + r13 + ", size=" + Integer.min(r13.length - r14, r15) + ')', false, null, null, 56);     // Catch: Throwable -> L11
        super.write(r13, r14, r15);     // Catch: Throwable -> L11
        this.d.notifyAll();     // Catch: Throwable -> L11
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r5);
        return;
    L17:
        throw new IOException("ConcurrentIOMeta closed!");     // Catch: Throwable -> L11
    L21:
        throw new IOException("ByteArray is NULL!");
    }
}
