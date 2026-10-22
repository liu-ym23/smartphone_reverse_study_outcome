package com.bytedance.gkfs.storage.io;

import com.bytedance.android.monitorV2.k;
import com.bytedance.gkfs.d;
import com.bytedance.gkfs.io.a;
import com.lynx.serval.svg.SVGRenderEngine;
import com.lynx.tasm.behavior.ui.utils.p;
import db.c;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001cJ \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0082 ¢\u0006\u0004\b\u0007\u0010\bJ \u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0003H\u0082 ¢\u0006\u0004\b\u000b\u0010\fJ8\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006H\u0082 ¢\u0006\u0004\b\u0013\u0010\u0014J8\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006H\u0082 ¢\u0006\u0004\b\u0016\u0010\u0014J \u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0082 ¢\u0006\u0004\b\u0017\u0010\bJ0\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0003H\u0082 ¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/bytedance/gkfs/storage/io/GkFSBlockBuffer;", "Ljava/io/Closeable;", "Ljava/io/Flushable;", "", "ptr", "length", "", "nRelease", "(JJ)I", "", SVGRenderEngine.PATH, "nCreate", "(Ljava/lang/String;J)J", "offset", "", "bytes", "off", "len", "", "nWrite", "(JJ[BII)V", "cursor", "nRead", "nFlush", "oldSize", "toSize", "nExtend", "(JLjava/lang/String;JJ)J", "com/lynx/tasm/behavior/ui/utils/p", "geckox_noasanRelease"}, k = 1, mv = {1, 4, 0})
public final class GkFSBlockBuffer implements Closeable, Flushable {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static a f4940j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final d f4941k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static File f4942l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final ReentrantReadWriteLock f4943m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final k f4944n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f4945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ReentrantReadWriteLock f4946b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f4947c;
    public final ReentrantReadWriteLock d;
    public final AtomicBoolean e;
    public long f;
    public final d g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a f4948h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final File f4949i;

    static {
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L4
        System.loadLibrary("gkfs");     // Catch: Throwable -> L4
        Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
    L6:
        f4941k = new d();
        f4943m = new ReentrantReadWriteLock();
        f4944n = new k(83886080, 3);
        return;
    L4:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    public GkFSBlockBuffer(a r10, File r11, long r12) {
        this.f4948h = r10;
        this.f4949i = r11;
        this.f4945a = r11.length();
        this.f4946b = new ReentrantReadWriteLock();
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L5
        Object r14 = Result.m124constructorimpl(Long.valueOf(nCreate(r11.getAbsolutePath(), r12)));     // Catch: Throwable -> L5
    L8:
        if (Result.m127exceptionOrNullimpl(r14) != null) goto L12;
        ResultKt.throwOnFailure(r14);
        this.f4947c = ((Number) r14).longValue();
        this.d = new ReentrantReadWriteLock();
        this.e = new AtomicBoolean(false);
        this.f = r12;
        d r15 = new d();
        this.g = r15;
        d.c(r15, "GkFSBlockBuffer", "create buffer:[blockId:" + this.f4948h + ", initSize:" + r12 + ", backingFile=" + this.f4949i + ']', 0, 12);
        return;
    L12:
        throw new IOException("mmap failed:[blockId:" + this.f4948h + ", initSize:" + r12 + ", backingFile=" + this.f4949i + ']');
    L5:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r14 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    private final native long nCreate(String r5, long r10);

    private final native long nExtend(long r5, String r10, long r11, long r12);

    private final native int nFlush(long r5, long r10);

    private final native void nRead(long r5, long r10, byte[] r11, int r12, int r13);

    private final native int nRelease(long r5, long r10);

    private final native void nWrite(long r5, long r10, byte[] r11, int r12, int r13);

    public final void b(long r14, byte[] r16, int r17, int r18) {
        boolean r5 = this.e.get();
        a r10 = this.f4948h;
        if (r5 == true) goto L36;
        if (r17 < 0) goto L34;
        if (r18 < 0) goto L34;
        if (r18 > (r16.length - r17)) goto L34;
        if (r18 != 0) goto L10;
        return;
    L10:
        ReentrantReadWriteLock.ReadLock r11 = this.f4946b.readLock();
        r11.lock();
        long r12 = this.f4945a;     // Catch: Throwable -> L30
        r11.unlock();
        long r13 = r12 - r14;
        if (r13 > 0) goto L16;
        StringBuilder r15 = dn.a.K(r14, "no available bytes from ", " of block ");
        r15.append(r10.f4853a);
        r15.append(" can be read, writePos=");
        r15.append(r12);
        String r19 = r15.toString();
        d.c(this.g, "GkFSBlockBuffer", r19, 0, 12);
        return;
    L16:
        int r20 = Math.min(r18, (int) r13);
        ReentrantReadWriteLock.ReadLock r21 = this.d.readLock();
        r21.lock();
        long r22 = this.f4947c;     // Catch: Throwable -> L27
        Long r23 = Long.valueOf(r22);     // Catch: Throwable -> L27
        r21.unlock();
        if (r22 != 0) goto L22;
        r23 = null;
    L22:
        if (r23 == null) goto L26;
        nRead(r23.longValue(), r14, r16, r17, r20);
        return;
    L26:
        throw new IOException(androidx.constraintlayout.motion.widget.a.s(new StringBuilder("can not read bytes from buffer "), r10.f4853a, ", ptr=0"));
    L27:
        th = move-exception;
        r21.unlock();
        throw th;
    L30:
        th = move-exception;
        r11.unlock();
        throw th;
    L34:
        throw new IndexOutOfBoundsException();
    L36:
        throw new IOException(androidx.constraintlayout.motion.widget.a.s(new StringBuilder("buffer "), r10.f4853a, " closed"));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        int r5 = 0;
        if (this.e.compareAndSet(false, true) == false) goto L22;
        p.o(this.f4948h);
        ReentrantReadWriteLock r10 = this.d;
        ReentrantReadWriteLock.ReadLock r11 = r10.readLock();
        if (r10.getWriteHoldCount() != 0) goto L7;
        int r12 = r10.getReadHoldCount();
    L8:
        int r13 = 0;
    L9:
        if (r13 >= r12) goto L11;
        r11.unlock();
        r13 = r13 + 1;
        goto L9
    L11:
        ReentrantReadWriteLock.WriteLock r14 = r10.writeLock();
        r14.lock();
        nRelease(this.f4947c, this.f);     // Catch: Throwable -> L17
        this.f4947c = 0;     // Catch: Throwable -> L17
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L17
    L13:
        if (r5 >= r12) goto L15;
        r11.lock();
        r5 = r5 + 1;
        goto L13
    L15:
        r14.unlock();
        return;
    L17:
        th = move-exception;
    L18:
        if (r5 >= r12) goto L20;
        r11.lock();
        r5 = r5 + 1;
        goto L18
    L20:
        r14.unlock();
        throw th;
    L7:
        r12 = 0;
        goto L8
    }

    public final void d(byte[] r16, int r17, int r18) {
        boolean r5 = this.e.get();
        a r10 = this.f4948h;
        if (r5 == true) goto L56;
        if (r17 < 0) goto L54;
        if (r17 > r16.length) goto L54;
        if (r18 < 0) goto L54;
        int r11 = r17 + r18;
        if (r11 > r16.length) goto L54;
        if (r11 < 0) goto L54;
        if (r18 != 0) goto L13;
        return;
    L13:
        ReentrantReadWriteLock r12 = this.f4946b;
        ReentrantReadWriteLock.ReadLock r13 = r12.readLock();
        int r14 = 0;
        if (r12.getWriteHoldCount() != 0) goto L16;
        int r15 = r12.getReadHoldCount();
    L17:
        int r19 = 0;
    L18:
        if (r19 >= r15) goto L20;
        r13.unlock();
        r19 = r19 + 1;
        goto L18
    L20:
        ReentrantReadWriteLock.WriteLock r110 = r12.writeLock();
        r110.lock();
    L45:
        th = move-exception;
    L49:
        if (r14 >= r15) goto L51;
        r13.lock();
        r14 = r14 + 1;
        goto L49
    L51:
        r110.unlock();
        throw th;
    L22:
        if (this.f4947c == 0) goto L48;
        e(r18);     // Catch: Throwable -> L45
        nWrite(this.f4947c, this.f4945a, r16, r17, r18);     // Catch: Throwable -> L45
        this.f4945a += (long) r18;     // Catch: Throwable -> L45
        Unit r20 = Unit.INSTANCE;     // Catch: Throwable -> L45
        int r21 = 0;
    L25:
        if (r21 >= r15) goto L27;
        r13.lock();
        r21 = r21 + 1;
        goto L25
    L27:
        r110.unlock();
        ReentrantReadWriteLock r22 = f4943m;
        ReentrantReadWriteLock.ReadLock r23 = r22.readLock();
        if (r22.getWriteHoldCount() != 0) goto L30;
        int r24 = r22.getReadHoldCount();
    L31:
        int r25 = 0;
    L32:
        if (r25 >= r24) goto L34;
        r23.unlock();
        r25 = r25 + 1;
        goto L32
    L34:
        ReentrantReadWriteLock.WriteLock r26 = r22.writeLock();
        r26.lock();
        c r27 = (c) f4944n.put(r10, new c(this));     // Catch: Throwable -> L40
    L36:
        if (r14 >= r24) goto L38;
        r23.lock();
        r14 = r14 + 1;
        goto L36
    L38:
        r26.unlock();
        return;
    L40:
        th = move-exception;
    L41:
        if (r14 >= r24) goto L43;
        r23.lock();
        r14 = r14 + 1;
        goto L41
    L43:
        r26.unlock();
        throw th;
    L30:
        r24 = 0;
        goto L31
    L48:
        throw new IOException("can not read bytes from buffer " + r10.f4853a + ", ptr=0");     // Catch: Throwable -> L45
    L16:
        r15 = 0;
    L54:
        throw new IndexOutOfBoundsException();
    L56:
        throw new IOException(androidx.constraintlayout.motion.widget.a.s(new StringBuilder("buffer "), r10.f4853a, " closed"));
    }

    public final void e(int r14) {
        monitor-enter(this);
        ReentrantReadWriteLock.ReadLock r5 = this.f4946b.readLock();     // Catch: Throwable -> L9
        r5.lock();     // Catch: Throwable -> L9
        long r10 = this.f4945a + ((long) r14);
        r5.unlock();     // Catch: Throwable -> L9
        ReentrantReadWriteLock r15 = this.d;     // Catch: Throwable -> L9
        ReentrantReadWriteLock.ReadLock r11 = r15.readLock();     // Catch: Throwable -> L9
        int r12 = 0;
        if (r15.getWriteHoldCount() != 0) goto L11;
        int r13 = r15.getReadHoldCount();     // Catch: Throwable -> L9
    L12:
        int r16 = 0;
    L13:
        if (r16 >= r13) goto L15;
        r11.unlock();     // Catch: Throwable -> L9
        r16 = r16 + 1;     // Catch: Throwable -> L9
        goto L13
    L15:
        ReentrantReadWriteLock.WriteLock r17 = r15.writeLock();     // Catch: Throwable -> L9
        r17.lock();     // Catch: Throwable -> L9
    L19:
        th = move-exception;
    L27:
        if (r12 >= r13) goto L29;
        r11.lock();     // Catch: Throwable -> L9
        r12 = r12 + 1;     // Catch: Throwable -> L9
        goto L27
    L29:
        r17.unlock();     // Catch: Throwable -> L9
        throw th;     // Catch: Throwable -> L9
    L17:
        if (r10 <= this.f) goto L21;
        this.f4947c = nExtend(this.f4947c, this.f4949i.getAbsolutePath(), this.f, r10);     // Catch: Throwable -> L19
        d.c(this.g, "GkFSBlockBuffer", "extend block " + this.f4948h.f4853a + " from " + this.f + " to " + r10 + ", new ptr=" + this.f4947c, 0, 12);     // Catch: Throwable -> L19
        this.f = r10;     // Catch: Throwable -> L19
    L21:
        Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L19
    L22:
        if (r12 >= r13) goto L24;
        r11.lock();     // Catch: Throwable -> L9
        r12 = r12 + 1;     // Catch: Throwable -> L9
        goto L22
    L24:
        r17.unlock();     // Catch: Throwable -> L9
        Unit r19 = Unit.INSTANCE;     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L11:
        r13 = 0;
        goto L12
    L31:
        th = move-exception;
        r5.unlock();     // Catch: Throwable -> L9
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public final void finalize() {
        d.c(this.g, "GkFSBlockBuffer", "release " + this + " cause finalize", 0, 12);
        long r5 = this.f4947c;
        if (r5 != 0) goto L5;
        return;
    L5:
        nRelease(r5, this.f4945a);
        this.f4947c = 0;
    }

    @Override // java.io.Flushable
    public final void flush() {
        ReentrantReadWriteLock r5 = this.d;
        monitor-enter(r5);
        ReentrantReadWriteLock.ReadLock r10 = this.d.readLock();     // Catch: Throwable -> L9
        r10.lock();     // Catch: Throwable -> L9
        nFlush(this.f4947c, this.f);     // Catch: Throwable -> L11
        r10.unlock();     // Catch: Throwable -> L9
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L9
        monitor-exit(r5);
        return;
    L11:
        th = move-exception;
        r10.unlock();     // Catch: Throwable -> L9
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("GkFSBlockBuffer@");
        r5.append(hashCode());
        r5.append("(id=");
        r5.append(this.f4948h.f4853a);
        r5.append(", cacheSize=");
        ReentrantReadWriteLock.ReadLock r10 = this.f4946b.readLock();
        r10.lock();
        long r11 = this.f4945a;     // Catch: Throwable -> L6
        r10.unlock();
        r5.append(r11);
        r5.append(", backingFile=");
        r5.append(this.f4949i);
        r5.append(')');
        return r5.toString();
    L6:
        th = move-exception;
        r10.unlock();
        throw th;
    }
}
