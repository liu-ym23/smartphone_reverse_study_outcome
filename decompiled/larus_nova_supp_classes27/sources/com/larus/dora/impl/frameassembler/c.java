package com.larus.dora.impl.frameassembler;

import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import g49.d;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class c extends com.larus.dora.impl.frameassembler.a {
    public final b q;
    public final List<byte[]> r;
    public long s;
    public File t;
    public BufferedOutputStream u;
    public long v;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.dora.impl.frameassembler.a
    public final long e() {
        return this.s + this.v;
    }

    public final byte[] j() throws IOException {
        File r0 = this.t;
        if (r0 != null) goto L8;
        byte[] r1 = new byte[(int) this.s];
        Iterator r2 = ((ArrayList) this.r).iterator();
        int r3 = 0;
    L6:
        if (r2.hasNext() == false) goto L48;
        byte[] r4 = (byte[]) r2.next();
        System.arraycopy(r4, 0, r1, r3, r4.length);
        r3 = r3 + r4.length;
        goto L6
    L48:
        return r1;
    L8:
        k();
        long r5 = this.v + this.s;
        if (this.c.c(r5) == false) goto L37;
        this.n += r5;
        int r6 = (int) r5;
        byte[] r7 = new byte[r6];
        PolarisFileInputStreamWrapper r8 = new PolarisFileInputStreamWrapper(r0);
        BufferedInputStream r9 = new BufferedInputStream(r8);     // Catch: Throwable -> L31
        int r10 = 0;
    L41:
        int r11 = r9.read(r7, r10, r6 - r10);     // Catch: Throwable -> L26
        if (r11 <= 0) goto L17;
        r10 = r10 + r11;     // Catch: Throwable -> L26
        goto L41
    L17:
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L26
    L19:
        CloseableKt.closeFinally(r9, null);     // Catch: Throwable -> L31
        CloseableKt.closeFinally(r8, null);
        Iterator r13 = ((ArrayList) this.r).iterator();
    L22:
        if (r13.hasNext() == false) goto L25;
        byte[] r14 = (byte[]) r13.next();
        System.arraycopy(r14, 0, r7, r10, r14.length);
        r10 = r10 + r14.length;
        goto L22
    L25:
        return r7;
    L26:
        th = move-exception;
        throw th;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        CloseableKt.closeFinally(r9, th);     // Catch: Throwable -> L31
        throw th;     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        throw th;     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        CloseableKt.closeFinally(r8, th);
        throw th;
    L37:
        throw new IOException("No memory to materialize payload of size=" + r5);
    }

    public final void k() {
        BufferedOutputStream r0 = this.u;     // Catch: IOException -> L7
        if (r0 == null) goto L5;
        r0.close();     // Catch: IOException -> L7
    L5:
        this.u = null;
    }

    public final void l() {
        File r0 = this.t;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.delete();
        this.t = null;
    }

    public final void n() {
        this.e.lock();
        d.e("DoraAggregateFrameSession", "onTimeout: key=" + this.a + ", receivedBytes=" + (this.s + this.v) + ", finished=" + this.o);     // Catch: Throwable -> L29
        if (this.o == false) goto L8;
    L5:
        this.e.unlock();
        return;
    L8:
        this.o = true;     // Catch: Throwable -> L29
        if (this.b.j != DoraIncompleteSessionPolicy.NOTIFY_PARTIAL) goto L34;
        j();     // Catch: IOException -> L12 Throwable -> L29
    L12:
        e = move-exception;
        m("buildPayload on timeout failed", e);     // Catch: Throwable -> L29
    L34:
    L22:
        th = move-exception;
        m("onIncomplete failed", th);     // Catch: Throwable -> L26
        this.q.c(c(), th);     // Catch: Throwable -> L26
        this.d.b();     // Catch: Throwable -> L26
        k();     // Catch: Throwable -> L29
        l();     // Catch: Throwable -> L29
        g r2 = this.c;     // Catch: Throwable -> L29
        long r3 = this.n;     // Catch: Throwable -> L29
    L20:
        r2.a(r3);     // Catch: Throwable -> L29
        this.n = 0;     // Catch: Throwable -> L29
        goto L5
    L26:
        th = move-exception;
        k();     // Catch: Throwable -> L29
        l();     // Catch: Throwable -> L29
        this.c.a(this.n);     // Catch: Throwable -> L29
        this.n = 0;     // Catch: Throwable -> L29
        throw th;     // Catch: Throwable -> L29
    L16:
        if (this.b.j == DoraIncompleteSessionPolicy.DISCARD) goto L18;
        this.q.b(c(), DoraIncompleteReason.TIMEOUT);     // Catch: Throwable -> L22
    L18:
        this.d.c.incrementAndGet();     // Catch: Throwable -> L22
        k();     // Catch: Throwable -> L29
        l();     // Catch: Throwable -> L29
        r2 = this.c;     // Catch: Throwable -> L29
        r3 = this.n;     // Catch: Throwable -> L29
        goto L20
    L29:
        th = move-exception;
        this.e.unlock();
        throw th;
    }

    public final void o() throws IOException {
        if (this.t == null) goto L5;
        return;
    L5:
        PolarisFileWrapper r0 = this.b.h;
        if (r0.exists() == false) goto L8;
    L12:
        File r1 = File.createTempFile("frame-session-", ".tmp", r0);
        d.d("DoraAggregateFrameSession", "startSpooling: switching to disk, file=" + r1.getAbsolutePath() + ", bytesInMemory=" + this.n);
        this.t = r1;
        this.u = new BufferedOutputStream(new PolarisFileOutputStreamWrapper(r1));
        this.p = true;
        this.d.e.incrementAndGet();
        Iterator r2 = ((ArrayList) this.r).iterator();
    L14:
        if (r2.hasNext() == false) goto L19;
        byte[] r3 = (byte[]) r2.next();
        BufferedOutputStream r4 = this.u;
        if (r4 == null) goto L18;
        r4.write(r3);
    L18:
        this.v += (long) r3.length;
        this.n -= (long) r3.length;
        this.c.a(r3.length);
        goto L14
    L19:
        ((ArrayList) this.r).clear();
        this.s = 0;
        return;
    L8:
        if (r0.mkdirs() == true) goto L12;
        throw new IOException("Failed to create spool directory: " + r0);
    }

    @Override // com.larus.dora.impl.frameassembler.a
    public final void h(byte[] r6) {
        byte[] r7 = j();     // Catch: Throwable -> L5
        this.q.a(c(), r7);     // Catch: Throwable -> L5
    L4:
        k();
        l();
        this.c.a(this.n);
        this.n = 0;
        this.d.a();
        return;
    L5:
        th = move-exception;
        m("onCompleted failed", th);     // Catch: Throwable -> L10
        this.q.c(c(), th);     // Catch: Throwable -> L10
        this.d.b();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        k();
        l();
        this.c.a(this.n);
        this.n = 0;
        this.d.a();
        throw th;
    }

    @Override // com.larus.dora.impl.frameassembler.a
    public final boolean a(byte[] r13, int r14) {
        Intrinsics.checkNotNullParameter(r13, "data");
        long r0 = r13.length;
        if (this.t != null) goto L35;
        long r5 = this.s + r0;
        d.d("DoraAggregateFrameSession", "appendInOrder, dataId=" + this.a.a + ", predicted=" + r5 + ", spoolThresholdBytes=" + this.b.g);
        e r2 = this.b;
        if (r5 <= r2.g) goto L15;
        o();     // Catch: IOException -> L11
        BufferedOutputStream r15 = this.u;     // Catch: IOException -> L11
        if (r15 == null) goto L9;
        r15.write(r13);     // Catch: IOException -> L11
    L9:
        this.v += (long) r13.length;     // Catch: IOException -> L11
        return true;
    L11:
        e = move-exception;
        m("startSpooling failed", e);
        return false;
    L15:
        if ((this.n + r0) <= r2.e) goto L19;
        d.b("DoraAggregateFrameSession", "appendInOrder, dataId=" + this.a.a + ", bytesInMemory + len > config.maxSessionBufferedBytes, len=" + r0);
        return false;
    L19:
        if (this.c.c(r0) == true) goto L22;
        d.b("DoraAggregateFrameSession", "appendInOrder, dataId=" + this.a.a + ", tryAcquireBytes failed, len=" + r0);
        return false;
    L22:
        d.d("DoraAggregateFrameSession", "appendInOrder, dataId=" + this.a.a + ", seq=" + r14 + ", len=" + r0);
        this.n = this.n + r0;
        ((ArrayList) this.r).add(r13);
        this.s = this.s + r0;
        return true;
    L35:
        BufferedOutputStream r16 = this.u;     // Catch: IOException -> L27
        if (r16 == null) goto L29;
        r16.write(r13);     // Catch: IOException -> L27
    L29:
        this.v += (long) r13.length;     // Catch: IOException -> L27
        return true;
    L27:
        e = move-exception;
        m("writeToSpool failed", e);
        return false;
    }

    public final void m(String r2, Throwable r3) {
        d.c("DoraAggregateFrameSession", r2 + ", key=" + this.a, r3);
    }

    @Override // com.larus.dora.impl.frameassembler.a
    public final void i(DoraIncompleteReason r7, byte[] r8, Throwable r9) {
        Intrinsics.checkNotNullParameter(r7, "reason");
        this.e.lock();
        d.c("DoraAggregateFrameSession", "onForceClose: key=" + this.a + ", reason=" + r7 + ", receivedBytes=" + (this.s + this.v) + ", finished=" + this.o, r9);     // Catch: Throwable -> L42
        if (this.o == false) goto L8;
    L5:
        this.e.unlock();
        return;
    L8:
        this.o = true;     // Catch: Throwable -> L42
    L31:
        th = move-exception;
        m("onForceClose callback failed", th);     // Catch: Throwable -> L39
        k();     // Catch: Throwable -> L42
        l();     // Catch: Throwable -> L42
        g r10 = this.c;     // Catch: Throwable -> L42
        long r11 = this.n;     // Catch: Throwable -> L42
    L34:
        r10.a(r11);     // Catch: Throwable -> L42
        this.n = 0;     // Catch: Throwable -> L42
        goto L5
    L39:
        th = move-exception;
        k();     // Catch: Throwable -> L42
        l();     // Catch: Throwable -> L42
        this.c.a(this.n);     // Catch: Throwable -> L42
        this.n = 0;     // Catch: Throwable -> L42
        throw th;     // Catch: Throwable -> L42
    L11:
        if (r7 != DoraIncompleteReason.RESOURCE_LIMIT) goto L19;
        if (this.b.j != DoraIncompleteSessionPolicy.NOTIFY_PARTIAL) goto L19;
        j();     // Catch: IOException -> L16 Throwable -> L31
    L16:
        e = move-exception;
        m("buildPayload on forceClose failed", e);     // Catch: Throwable -> L31
    L19:
        if (r7 == DoraIncompleteReason.RESOURCE_LIMIT) goto L28;
        if (r7 == DoraIncompleteReason.TOTAL_SEQ_MISMATCH) goto L28;
        b r12 = this.q;     // Catch: Throwable -> L31
        h r13 = c();     // Catch: Throwable -> L31
        if (r9 != null) goto L26;
        r9 = new IllegalStateException("session closed");     // Catch: Throwable -> L31
    L26:
        r12.c(r13, r9);     // Catch: Throwable -> L31
        this.d.b();     // Catch: Throwable -> L31
    L33:
        k();     // Catch: Throwable -> L42
        l();     // Catch: Throwable -> L42
        r10 = this.c;     // Catch: Throwable -> L42
        r11 = this.n;     // Catch: Throwable -> L42
    L28:
        if (this.b.j == DoraIncompleteSessionPolicy.DISCARD) goto L33;
        this.q.b(c(), r7);     // Catch: Throwable -> L31
        this.d.c.incrementAndGet();     // Catch: Throwable -> L31
    L42:
        th = move-exception;
        this.e.unlock();
        throw th;
    }

    public c(i r8, e r9, g r10, f r11, b r12, long r13) {
        Intrinsics.checkNotNullParameter(r8, "key");
        Intrinsics.checkNotNullParameter(r9, "config");
        Intrinsics.checkNotNullParameter(r10, "resourceTracker");
        Intrinsics.checkNotNullParameter(r11, "metrics");
        Intrinsics.checkNotNullParameter(r12, "consumer");
        super(r8, r9, r10, r11, r13);
        this.q = r12;
        this.r = new ArrayList();
    }
}
