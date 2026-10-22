package nu;

import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: classes3.dex */
public final class w implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f20346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f20347b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a0 f20348c;

    public w(a0 r5) {
        Intrinsics.checkNotNullParameter(r5, "sink");
        this.f20348c = r5;
        this.f20346a = new j();
    }

    @Override // nu.k
    public final k B(long r5) {
        if (this.f20347b == true) goto L7;
        this.f20346a.V(r5);
        k();
        return this;
    L7:
        throw new IllegalStateException("closed");
    }

    @Override // nu.k
    public final k F(ByteString r5) {
        Intrinsics.checkNotNullParameter(r5, "byteString");
        if (this.f20347b == true) goto L7;
        this.f20346a.Q(r5);
        k();
        return this;
    L7:
        throw new IllegalStateException("closed");
    }

    @Override // nu.k
    public final long G(c0 r10) {
        Intrinsics.checkNotNullParameter(r10, "source");
        long r5 = 0;
    L3:
        d r11 = (d) r10;
        long r12 = r11.read(this.f20346a, 8192);
        if (r12 == (-1)) goto L5;
        r5 = r5 + r12;
        k();
        goto L3
    L5:
        return r5;
    }

    @Override // nu.a0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        a0 r5 = this.f20348c;
        if (this.f20347b == true) goto L23;
        j r10 = this.f20346a;     // Catch: Throwable -> L9
        long r11 = r10.f20328b;     // Catch: Throwable -> L9
        if (r11 <= 0) goto L8;
        r5.write(r10, r11);     // Catch: Throwable -> L9
    L8:
        th = null;
    L21:
        r5.close();     // Catch: Throwable -> L12
    L15:
        this.f20347b = true;
        if (th != null) goto L18;
        return;
    L18:
        throw th;
    L12:
        th = move-exception;
        if (th != null) goto L15;
        th = th;
    L9:
        th = th;
        goto L21
    }

    @Override // nu.k, nu.a0, java.io.Flushable
    public final void flush() {
        if (this.f20347b == true) goto L10;
        j r5 = this.f20346a;
        long r10 = r5.f20328b;
        a0 r11 = this.f20348c;
        if (r10 <= 0) goto L7;
        r11.write(r5, r10);
    L7:
        r11.flush();
        return;
    L10:
        throw new IllegalStateException("closed");
    }

    @Override // nu.k
    public final j h() {
        return this.f20346a;
    }

    @Override // nu.k
    public final k i() {
        if (this.f20347b == true) goto L9;
        j r5 = this.f20346a;
        long r10 = r5.f20328b;
        if (r10 <= 0) goto L7;
        this.f20348c.write(r5, r10);
    L7:
        return this;
    L9:
        throw new IllegalStateException("closed");
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.f20347b;
    }

    @Override // nu.k
    public final k j(long r5) {
        if (this.f20347b == true) goto L7;
        this.f20346a.X(f4.a.m(r5));
        k();
        return this;
    L7:
        throw new IllegalStateException("closed");
    }

    @Override // nu.k
    public final k k() {
        if (this.f20347b == true) goto L9;
        j r5 = this.f20346a;
        long r10 = r5.f();
        if (r10 <= 0) goto L7;
        this.f20348c.write(r5, r10);
    L7:
        return this;
    L9:
        throw new IllegalStateException("closed");
    }

    @Override // nu.k
    public final k l(String r5) {
        Intrinsics.checkNotNullParameter(r5, "string");
        if (this.f20347b == true) goto L7;
        this.f20346a.b0(r5);
        k();
        return this;
    L7:
        throw new IllegalStateException("closed");
    }

    @Override // nu.k
    public final k t(long r5) {
        if (this.f20347b == true) goto L7;
        this.f20346a.U(r5);
        k();
        return this;
    L7:
        throw new IllegalStateException("closed");
    }

    @Override // nu.a0
    public final f0 timeout() {
        return this.f20348c.timeout();
    }

    public final String toString() {
        return "buffer(" + this.f20348c + ')';
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer r5) {
        Intrinsics.checkNotNullParameter(r5, "source");
        if (this.f20347b == true) goto L7;
        int r10 = this.f20346a.write(r5);
        k();
        return r10;
    L7:
        throw new IllegalStateException("closed");
    }

    @Override // nu.k
    public final k writeByte(int r5) {
        if (this.f20347b == true) goto L7;
        this.f20346a.T(r5);
        k();
        return this;
    L7:
        throw new IllegalStateException("closed");
    }

    @Override // nu.k
    public final k writeInt(int r5) {
        if (this.f20347b == true) goto L7;
        this.f20346a.W(r5);
        k();
        return this;
    L7:
        throw new IllegalStateException("closed");
    }

    @Override // nu.k
    public final k writeShort(int r5) {
        if (this.f20347b == true) goto L7;
        this.f20346a.Y(r5);
        k();
        return this;
    L7:
        throw new IllegalStateException("closed");
    }

    @Override // nu.k
    public final k x(int r5) {
        if (this.f20347b == true) goto L7;
        this.f20346a.W(f4.a.l(r5));
        k();
        return this;
    L7:
        throw new IllegalStateException("closed");
    }

    @Override // nu.a0
    public final void write(j r5, long r10) {
        Intrinsics.checkNotNullParameter(r5, "source");
        if (this.f20347b == true) goto L7;
        this.f20346a.write(r5, r10);
        k();
        return;
    L7:
        throw new IllegalStateException("closed");
    }

    @Override // nu.k
    public final k write(byte[] r5) {
        Intrinsics.checkNotNullParameter(r5, "source");
        if (this.f20347b == true) goto L7;
        this.f20346a.R(r5);
        k();
        return this;
    L7:
        throw new IllegalStateException("closed");
    }

    @Override // nu.k
    public final k write(byte[] r5, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "source");
        if (this.f20347b == true) goto L7;
        this.f20346a.S(r5, r10, r11);
        k();
        return this;
    L7:
        throw new IllegalStateException("closed");
    }
}
