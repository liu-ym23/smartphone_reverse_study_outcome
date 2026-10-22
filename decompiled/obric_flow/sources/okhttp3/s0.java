package okhttp3;

import java.io.Closeable;
import java.io.EOFException;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.connection.Exchange;

/* JADX INFO: loaded from: classes3.dex */
public final class s0 implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h f20745a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Request f20746b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Protocol f20747c;
    public final String d;
    public final int e;
    public final a0 f;
    public final c0 g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final w0 f20748h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final s0 f20749i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final s0 f20750j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final s0 f20751k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f20752l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f20753m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Exchange f20754n;

    public s0(Request r10, Protocol r11, String r12, int r13, a0 r14, c0 r15, w0 r16, s0 r17, s0 r18, s0 r19, long r110, long r111, Exchange r21) {
        Intrinsics.checkNotNullParameter(r10, "request");
        Intrinsics.checkNotNullParameter(r11, "protocol");
        Intrinsics.checkNotNullParameter(r12, "message");
        Intrinsics.checkNotNullParameter(r15, "headers");
        this.f20746b = r10;
        this.f20747c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        this.g = r15;
        this.f20748h = r16;
        this.f20749i = r17;
        this.f20750j = r18;
        this.f20751k = r19;
        this.f20752l = r110;
        this.f20753m = r111;
        this.f20754n = r21;
    }

    public final h b() {
        h r5 = this.f20745a;
        if (r5 != null) goto L6;
        h r10 = h.f20647n;
        h r11 = z.i(this.g);
        this.f20745a = r11;
        return r11;
    L6:
        return r5;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        w0 r5 = this.f20748h;
        if (r5 == null) goto L7;
        r5.close();
        return;
    L7:
        throw new IllegalStateException("response is not eligible for a body and must not be closed");
    }

    public final String d(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "name");
        String r11 = this.g.b(r5);
        if (r11 != null) goto L5;
        return r10;
    L5:
        return r11;
    }

    public final boolean e() {
        int r5 = this.e;
        if (200 <= r5) goto L6;
    L8:
        return false;
    L6:
        if (299 < r5) goto L8;
        return true;
    }

    public final r0 f() {
        Intrinsics.checkNotNullParameter(this, "response");
        r0 r5 = new r0();
        r5.f20735a = this.f20746b;
        r5.f20736b = this.f20747c;
        r5.f20737c = this.e;
        r5.d = this.d;
        r5.e = this.f;
        r5.f = this.g.d();
        r5.g = this.f20748h;
        r5.f20738h = this.f20749i;
        r5.f20739i = this.f20750j;
        r5.f20740j = this.f20751k;
        r5.f20741k = this.f20752l;
        r5.f20742l = this.f20753m;
        r5.f20743m = this.f20754n;
        return r5;
    }

    public final u0 g() {
        w0 r10 = this.f20748h;
        Intrinsics.checkNotNull(r10);
        nu.x r5 = r10.source().peek();
        nu.j r11 = new nu.j();
        r5.request(10240);
        long r12 = Math.min(10240, r5.f20349a.f20328b);
        Intrinsics.checkNotNullParameter(r5, "source");
    L4:
        if (r12 <= 0) goto L10;
        long r13 = r5.read(r11, r12);
        if (r13 == (-1)) goto L9;
        r12 = r12 - r13;
        goto L4
    L9:
        throw new EOFException();
    L10:
        v0 r14 = w0.Companion;
        h0 r15 = r10.contentType();
        long r16 = r11.f20328b;
        r14.getClass();
        return v0.b(r11, r15, r16);
    }

    public final String toString() {
        return "Response{protocol=" + this.f20747c + ", code=" + this.e + ", message=" + this.d + ", url=" + this.f20746b.url() + '}';
    }
}
