package lh;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.UByte;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ja.d f19615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f19616b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f19617c;

    public b(ja.d r5) {
        this.f19616b = 0;
        this.f19617c = 0;
        this.f19615a = r5;
    }

    @Override // java.io.InputStream
    public final int available() {
        return Math.max(((i4.a) this.f19615a.f18301a).a() - this.f19616b, 2);
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        ja.d r5 = this.f19615a;
        if (((AtomicInteger) r5.d).decrementAndGet() > 0) goto L15;
        ((c) r5.f18302b).close();
        i4.a r10 = (i4.a) r5.f18301a;
        int r11 = r10.a();
        if (r11 < 0) goto L14;
        ReentrantReadWriteLock.WriteLock r12 = (ReentrantReadWriteLock.WriteLock) r10.f17502b;
        r12.lock();
        ((com.airbnb.lottie.parser.moshi.c) r10.d).a(r11);     // Catch: Throwable -> L10
        r12.unlock();
        return;
    L10:
        th = move-exception;
        r12.unlock();
        throw th;
    L14:
        throw new IndexOutOfBoundsException();
    }

    @Override // java.io.InputStream
    public final void mark(int r5) {
        this.f19617c = this.f19616b;
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public final int read() {
        ja.d r5 = this.f19615a;
        if (((AtomicInteger) r5.d).get() <= 0) goto L46;
        if (this.f19616b < ((i4.a) r5.f18301a).a()) goto L8;
        r5.b();
    L8:
        if (((AtomicBoolean) r5.f18303c).get() == true) goto L10;
    L13:
        i4.a r10 = (i4.a) r5.f18301a;
        int r11 = this.f19616b;
        this.f19616b = r11 + 1;
        if (r11 < 0) goto L43;
        ReentrantReadWriteLock.ReadLock r12 = (ReentrantReadWriteLock.ReadLock) r10.f17503c;
        ReentrantReadWriteLock.ReadLock r13 = (ReentrantReadWriteLock.ReadLock) r10.f17503c;
        r12.lock();
        com.airbnb.lottie.parser.moshi.c r14 = (com.airbnb.lottie.parser.moshi.c) r10.d;     // Catch: Throwable -> L21
        a r15 = ((a[]) r14.d)[r14.f1313a];     // Catch: Throwable -> L21
        if (r15 == null) goto L19;
    L23:
        if (r15 != null) goto L25;
    L29:
        int r16 = r14.g(r11);     // Catch: Throwable -> L21
        boolean r17 = true;
        if (r16 >= 0) goto L32;
    L34:
        r17 = false;
    L35:
        if (r17 == false) goto L40;
        int r18 = r14.f1313a + r16;     // Catch: Throwable -> L21
        a[] r19 = (a[]) r14.d;     // Catch: Throwable -> L21
        a r20 = r19[r18 % r19.length];     // Catch: Throwable -> L21
        byte r21 = r20.f19614c[r11 - r20.f19612a];     // Catch: Throwable -> L21
        r13.unlock();
        return r21 & UByte.MAX_VALUE;
    L40:
        throw new IndexOutOfBoundsException();     // Catch: Throwable -> L21
    L32:
        if (r16 >= r14.f1314b) goto L34;
    L25:
        if (r11 >= r15.f19612a) goto L29;
    L28:
        throw new IOException("Attempt to read the cache which has been cleared; Only clear the cache when it will not be read anymore!");     // Catch: Throwable -> L21
    L19:
        if (r11 < r14.f1315c) goto L28;
    L21:
        th = move-exception;
        r13.unlock();
        throw th;
    L43:
        r10.getClass();
        throw new IndexOutOfBoundsException();
    L10:
        if (this.f19616b < ((i4.a) r5.f18301a).a()) goto L13;
        return -1;
    L46:
        throw new IOException();
    }

    @Override // java.io.InputStream
    public final void reset() {
        this.f19616b = this.f19617c;
    }

    @Override // java.io.InputStream
    public final int read(byte[] r17, int r18, int r19) {
        r17.getClass();
        if (r18 < 0) goto L68;
        if (r19 < 0) goto L68;
        if (r19 > (r17.length - r18)) goto L68;
        ja.d r5 = this.f19615a;
        if (((AtomicInteger) r5.d).get() <= 0) goto L66;
        int r10 = Math.min(r17.length - r18, r19);
        int r11 = 0;
    L10:
        if (r11 >= r10) goto L64;
        if (this.f19616b < ((i4.a) r5.f18301a).a()) goto L20;
        if (r11 > 0) goto L64;
        if (((AtomicBoolean) r5.f18303c).get() == true) goto L17;
        r5.b();
        goto L20
    L17:
        return -1;
    L20:
        i4.a r12 = (i4.a) r5.f18301a;
        int r13 = this.f19616b;
        int r14 = r18 + r11;
        int r15 = r10 - r11;
        r12.getClass();
        if (r13 < 0) goto L63;
        if (r15 < 0) goto L63;
        if (r14 > r17.length) goto L63;
        if (r15 > (r17.length - r14)) goto L63;
        int r16 = Math.min(r15, r17.length - r14);
        ReentrantReadWriteLock.ReadLock r110 = (ReentrantReadWriteLock.ReadLock) r12.f17503c;
        r110.lock();
        com.airbnb.lottie.parser.moshi.c r20 = (com.airbnb.lottie.parser.moshi.c) r12.d;     // Catch: Throwable -> L33
        a r111 = ((a[]) r20.d)[r20.f1313a];     // Catch: Throwable -> L33
        if (r111 == null) goto L31;
    L35:
        if (r111 != null) goto L37;
    L41:
        int r112 = r20.g(r13);     // Catch: Throwable -> L33
        int r113 = 0;
    L42:
        if (r113 >= r16) goto L59;
        if (r112 >= 0) goto L45;
    L47:
        boolean r114 = false;
    L48:
        if (r114 == false) goto L59;
        int r115 = r20.f1313a + r112;     // Catch: Throwable -> L33
        a[] r116 = (a[]) r20.d;     // Catch: Throwable -> L33
        a r117 = r116[r115 % r116.length];     // Catch: Throwable -> L33
        if (r117 == null) goto L52;
        r112 = r112 + 1;     // Catch: Throwable -> L33
    L52:
        int r118 = r117.f19613b;     // Catch: Throwable -> L33
        int r119 = r13 - r117.f19612a;
        int r120 = r118 - r119;
        int r21 = r120 + r113;
        byte[] r121 = r117.f19614c;
        if (r21 <= r16) goto L56;
        int r22 = r16 - r113;     // Catch: Throwable -> L33
        System.arraycopy(r121, r119, r17, r113 + r14, r22);     // Catch: Throwable -> L33
        r13 = r13 + r22;
        r113 = r16;
        goto L42
    L56:
        System.arraycopy(r121, r119, r17, r113 + r14, r120);     // Catch: Throwable -> L33
        r13 = r13 + r120;     // Catch: Throwable -> L33
        r113 = r21;
        goto L42
    L45:
        if (r112 >= r20.f1314b) goto L47;
        r114 = true;
    L59:
        r110.unlock();
        r11 = r11 + r113;
        this.f19616b += r113;
        goto L10
    L37:
        if (r13 >= r111.f19612a) goto L41;
    L40:
        throw new IOException("Attempt to read the cache which has been cleared; Only clear the cache when it will not be read anymore!");     // Catch: Throwable -> L33
    L31:
        if (r13 < r20.f1315c) goto L40;
    L33:
        th = move-exception;
        r110.unlock();
        throw th;
    L63:
        throw new IndexOutOfBoundsException();
    L64:
        return r11;
    L66:
        throw new IOException();
    L68:
        throw new IndexOutOfBoundsException();
    }
}
