package okhttp3;

import java.util.List;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: classes3.dex */
public final class k0 extends q0 {
    public static final h0 e = null;
    public static final h0 f = null;
    public static final byte[] g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final byte[] f20669h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final byte[] f20670i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h0 f20671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f20672b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ByteString f20673c;
    public final List d;

    static {
        Pattern r5 = h0.e;
        e = z.f("multipart/mixed");
        z.f("multipart/alternative");
        z.f("multipart/digest");
        z.f("multipart/parallel");
        f = z.f("multipart/form-data");
        g = new byte[]{(byte) 58, (byte) 32};
        f20669h = new byte[]{(byte) 13, (byte) 10};
        byte r10 = (byte) 45;
        f20670i = new byte[]{r10, r10};
    }

    public k0(ByteString r5, h0 r10, List r11) {
        Intrinsics.checkNotNullParameter(r5, "boundaryByteString");
        Intrinsics.checkNotNullParameter(r10, "type");
        Intrinsics.checkNotNullParameter(r11, "parts");
        this.f20673c = r5;
        this.d = r11;
        Pattern r12 = h0.e;
        this.f20671a = z.f(r10 + "; boundary=" + r5.utf8());
        this.f20672b = -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long a(nu.k r17, boolean r18) {
        if (r18 == false) goto L5;
        nu.k r5 = new nu.j();
        nu.j r10 = r5;
    L6:
        List r11 = this.d;
        int r12 = r11.size();
        long r13 = 0;
        int r14 = 0;
    L7:
        ByteString r15 = this.f20673c;
        byte[] r16 = f20670i;
        byte[] r19 = f20669h;
        if (r14 >= r12) goto L28;
        j0 r110 = (j0) r11.get(r14);
        c0 r111 = r110.f20664a;
        Intrinsics.checkNotNull(r5);
        r5.write(r16);
        r5.F(r15);
        r5.write(r19);
        if (r111 == null) goto L14;
        int r20 = r111.size();
        int r112 = 0;
    L12:
        if (r112 >= r20) goto L14;
        r5.l(r111.c(r112)).write(g).l(r111.e(r112)).write(r19);
        r112 = r112 + 1;
    L14:
        q0 r21 = r110.f20665b;
        h0 r113 = r21.contentType();
        if (r113 == null) goto L17;
        r5.l("Content-Type: ").l(r113.f20657a).write(r19);
    L17:
        long r114 = r21.contentLength();
        if (r114 == (-1)) goto L20;
        r5.l("Content-Length: ").t(r114).write(r19);
    L23:
        r5.write(r19);
        if (r18 == false) goto L26;
        r13 = r13 + r114;
    L27:
        r5.write(r19);
        r14 = r14 + 1;
        goto L7
    L26:
        r21.writeTo(r5);
        goto L27
    L20:
        if (r18 == false) goto L23;
        Intrinsics.checkNotNull(r10);
        r10.b();
        return -1;
    L28:
        Intrinsics.checkNotNull(r5);
        r5.write(r16);
        r5.F(r15);
        r5.write(r16);
        r5.write(r19);
        if (r18 == false) goto L37;
        Intrinsics.checkNotNull(r10);
        long r22 = r13 + r10.f20328b;
        r10.b();
        return r22;
    L37:
        return r13;
    L5:
        r10 = 0;
        r5 = r17;
        goto L6
    }

    @Override // okhttp3.q0
    public final long contentLength() {
        long r5 = this.f20672b;
        if (r5 != (-1)) goto L6;
        long r10 = a(null, true);
        this.f20672b = r10;
        return r10;
    L6:
        return r5;
    }

    @Override // okhttp3.q0
    public final h0 contentType() {
        return this.f20671a;
    }

    @Override // okhttp3.q0
    public final void writeTo(nu.k r5) {
        Intrinsics.checkNotNullParameter(r5, "sink");
        a(r5, false);
    }
}
