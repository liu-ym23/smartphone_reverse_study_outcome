package com.larus.dora.impl.frameassembler;

import g49.d;
import java.io.IOException;
import java.io.OutputStream;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class l extends com.larus.dora.impl.frameassembler.a {
    public final j q;
    public OutputStream r;
    public boolean s;
    public long t;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.dora.impl.frameassembler.a
    public final long e() {
        return this.t + this.n;
    }

    public final void j() throws IOException {
        if (this.s == true) goto L6;
        this.r = this.q.a(c());
        this.s = true;
        return;
    }

    public final void l() {
        this.e.lock();
        d.e("DoraStreamingFrameSession", "onTimeout: key=" + this.a + ", receivedBytes=" + (this.t + this.n) + ", finished=" + this.o);     // Catch: Throwable -> L32
        if (this.o == false) goto L8;
    L5:
        this.e.unlock();
        return;
    L8:
        this.o = true;     // Catch: Throwable -> L32
        j();     // Catch: Throwable -> L14 Exception -> L16
        if (this.b.j == DoraIncompleteSessionPolicy.DISCARD) goto L29;
        j r1 = this.q;     // Catch: Throwable -> L14 Exception -> L16
        h r2 = c();     // Catch: Throwable -> L14 Exception -> L16
        OutputStream r3 = this.r;     // Catch: Throwable -> L14 Exception -> L16
        if (r3 == null) goto L19;
        r1.e(r2, r3, DoraIncompleteReason.TIMEOUT);     // Catch: Throwable -> L14 Exception -> L16
        this.d.c.incrementAndGet();     // Catch: Throwable -> L14 Exception -> L16
        goto L29
    L19:
        throw new IllegalStateException("Required value was null.".toString());     // Catch: Throwable -> L14 Exception -> L16
    L29:
        m();     // Catch: Throwable -> L32
    L14:
        th = move-exception;
        m();     // Catch: Throwable -> L32
        throw th;     // Catch: Throwable -> L32
    L16:
        e = move-exception;
        k("onTimeout failed", e);     // Catch: Throwable -> L14
        j r4 = this.q;     // Catch: Throwable -> L14 Exception -> L26
        h r5 = c();     // Catch: Throwable -> L14 Exception -> L26
        OutputStream r6 = this.r;     // Catch: Throwable -> L14 Exception -> L26
        if (r6 == null) goto L25;
        r4.c(r5, r6, e);     // Catch: Throwable -> L14 Exception -> L26
    L28:
        this.d.b();     // Catch: Throwable -> L14
        goto L29
    L25:
        throw new IllegalStateException("Required value was null.".toString());     // Catch: Throwable -> L14 Exception -> L26
    L26:
        e = move-exception;
        k("onTimeout failed onError", e);     // Catch: Throwable -> L14
    L32:
        th = move-exception;
        this.e.unlock();
        throw th;
    }

    public final void m() {
        OutputStream r0 = this.r;     // Catch: IOException -> L7
        if (r0 == null) goto L5;
        r0.close();     // Catch: IOException -> L7
    L5:
        this.c.a(this.n);
        this.n = 0;
    }

    @Override // com.larus.dora.impl.frameassembler.a
    public final void h(byte[] r5) {
        OutputStream r0 = this.r;     // Catch: Throwable -> L8 Exception -> L10
        if (r0 == null) goto L7;
        j();     // Catch: Throwable -> L8 Exception -> L10
        this.q.b(c(), r0);     // Catch: Throwable -> L8 Exception -> L10
        this.d.a();     // Catch: Throwable -> L8 Exception -> L10
    L20:
        m();
        return;
    L7:
        throw new IllegalStateException("Required value was null.".toString());     // Catch: Throwable -> L8 Exception -> L10
    L8:
        th = move-exception;
        m();
        throw th;
    L10:
        e = move-exception;
        k("onCompleted failed", e);     // Catch: Throwable -> L8
        j r1 = this.q;     // Catch: Throwable -> L8 Exception -> L17
        h r2 = c();     // Catch: Throwable -> L8 Exception -> L17
        OutputStream r3 = this.r;     // Catch: Throwable -> L8 Exception -> L17
        if (r3 == null) goto L16;
        r1.c(r2, r3, e);     // Catch: Throwable -> L8 Exception -> L17
    L19:
        this.d.b();     // Catch: Throwable -> L8
        goto L20
    L16:
        throw new IllegalStateException("Required value was null.".toString());     // Catch: Throwable -> L8 Exception -> L17
    L17:
        e = move-exception;
        k("onCompleted failed onError", e);     // Catch: Throwable -> L8
        goto L19
    }

    @Override // com.larus.dora.impl.frameassembler.a
    public final boolean a(byte[] r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "data");
        j();     // Catch: Exception -> L8
        j r0 = this.q;     // Catch: Exception -> L8
        h r1 = c();     // Catch: Exception -> L8
        OutputStream r2 = this.r;     // Catch: Exception -> L8
        if (r2 == null) goto L7;
        r0.d(r1, r2, r4, r5);     // Catch: Exception -> L8
        this.t += (long) r4.length;     // Catch: Exception -> L8
        return true;
    L7:
        throw new IllegalStateException("Required value was null.".toString());     // Catch: Exception -> L8
    L8:
        e = move-exception;
        k("onChunk failed", e);
        return false;
    }

    public final void k(String r2, Throwable r3) {
        d.c("DoraStreamingFrameSession", r2 + ", key=" + this.a, r3);
    }

    @Override // com.larus.dora.impl.frameassembler.a
    public final void i(DoraIncompleteReason r7, byte[] r8, Throwable r9) {
        Intrinsics.checkNotNullParameter(r7, "reason");
        this.e.lock();
        d.c("DoraStreamingFrameSession", "onForceClose: key=" + this.a + ", reason=" + r7 + ", receivedBytes=" + (this.t + this.n) + ", finished=" + this.o, r9);     // Catch: Throwable -> L39
        if (this.o == false) goto L8;
    L5:
        this.e.unlock();
        return;
    L8:
        this.o = true;     // Catch: Throwable -> L39
        j();     // Catch: Throwable -> L29 Exception -> L31
        if (r7 == DoraIncompleteReason.RESOURCE_LIMIT) goto L25;
        if (r7 == DoraIncompleteReason.TOTAL_SEQ_MISMATCH) goto L25;
        if (r7 == DoraIncompleteReason.SEQ_MISMATCH) goto L25;
        j r10 = this.q;     // Catch: Throwable -> L29 Exception -> L31
        h r11 = c();     // Catch: Throwable -> L29 Exception -> L31
        OutputStream r1 = this.r;     // Catch: Throwable -> L29 Exception -> L31
        if (r1 == null) goto L23;
        if (r9 != null) goto L21;
        r9 = new IllegalStateException("session closed");     // Catch: Throwable -> L29 Exception -> L31
    L21:
        r10.c(r11, r1, r9);     // Catch: Throwable -> L29 Exception -> L31
        this.d.b();     // Catch: Throwable -> L29 Exception -> L31
    L36:
        m();     // Catch: Throwable -> L39
        goto L5
    L23:
        throw new IllegalStateException("Required value was null.".toString());     // Catch: Throwable -> L29 Exception -> L31
    L25:
        if (this.b.j == DoraIncompleteSessionPolicy.DISCARD) goto L36;
        j r12 = this.q;     // Catch: Throwable -> L29 Exception -> L31
        h r13 = c();     // Catch: Throwable -> L29 Exception -> L31
        OutputStream r2 = this.r;     // Catch: Throwable -> L29 Exception -> L31
        if (r2 == null) goto L34;
        r12.e(r13, r2, r7);     // Catch: Throwable -> L29 Exception -> L31
        this.d.c.incrementAndGet();     // Catch: Throwable -> L29 Exception -> L31
        goto L36
    L34:
        throw new IllegalStateException("Required value was null.".toString());     // Catch: Throwable -> L29 Exception -> L31
    L29:
        th = move-exception;
        m();     // Catch: Throwable -> L39
        throw th;     // Catch: Throwable -> L39
    L31:
        e = move-exception;
        k("onForceClose failed", e);     // Catch: Throwable -> L29
    L39:
        th = move-exception;
        this.e.unlock();
        throw th;
    }

    public l(i r8, e r9, g r10, f r11, j r12, long r13) {
        Intrinsics.checkNotNullParameter(r8, "key");
        Intrinsics.checkNotNullParameter(r9, "config");
        Intrinsics.checkNotNullParameter(r10, "resourceTracker");
        Intrinsics.checkNotNullParameter(r11, "metrics");
        Intrinsics.checkNotNullParameter(r12, "consumer");
        super(r8, r9, r10, r11, r13);
        this.q = r12;
    }
}
