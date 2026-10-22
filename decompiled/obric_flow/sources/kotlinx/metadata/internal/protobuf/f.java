package kotlinx.metadata.internal.protobuf;

import androidx.core.view.accessibility.AccessibilityEventCompat;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f19158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f19159b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f19160c;
    public int d;
    public final InputStream e;
    public int f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f19161h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f19162i;

    public f(byte[] r5, int r10) {
        this.f19161h = Integer.MAX_VALUE;
        this.f19158a = r5;
        this.f19159b = r10;
        this.d = 0;
        this.g = 0;
        this.e = null;
    }

    public final void a(int r5) {
        if (this.f != r5) goto L6;
        return;
    L6:
        throw InvalidProtocolBufferException.invalidEndTag();
    }

    public final int b() {
        int r5 = this.f19161h;
        if (r5 != Integer.MAX_VALUE) goto L7;
        return -1;
    L7:
        return r5 - (this.g + this.d);
    }

    public final void c(int r5) {
        this.f19161h = r5;
        o();
    }

    public final int d(int r5) {
        if (r5 < 0) goto L10;
        int r10 = (this.g + this.d) + r5;
        int r11 = this.f19161h;
        if (r10 > r11) goto L8;
        this.f19161h = r10;
        o();
        return r11;
    L8:
        throw InvalidProtocolBufferException.truncatedMessage();
    L10:
        throw InvalidProtocolBufferException.negativeSize();
    }

    public final x e() {
        int r5 = k();
        int r10 = this.f19159b;
        int r11 = this.d;
        if (r5 > (r10 - r11)) goto L7;
        if (r5 <= 0) goto L7;
        byte[] r12 = new byte[r5];
        System.arraycopy(this.f19158a, r11, r12, 0, r5);
        x r13 = new x(r12);
        this.d += r5;
        return r13;
    L7:
        if (r5 != 0) goto L11;
        return e.f19154a;
    L11:
        return new x(h(r5));
    }

    public final int f() {
        return k();
    }

    public final z g(b0 r5, i r10) {
        int r11 = k();
        if (this.f19162i >= 64) goto L7;
        int r12 = d(r11);
        this.f19162i++;
        z r13 = (z) r5.a(this, r10);
        a(0);
        this.f19162i--;
        c(r12);
        return r13;
    L7:
        throw InvalidProtocolBufferException.recursionLimitExceeded();
    }

    public final byte[] h(int r14) {
        if (r14 > 0) goto L8;
        if (r14 != 0) goto L7;
        return t.f19206a;
    L7:
        throw InvalidProtocolBufferException.negativeSize();
    L8:
        int r5 = this.g;
        int r10 = this.d;
        int r11 = (r5 + r10) + r14;
        int r12 = this.f19161h;
        if (r11 > r12) goto L35;
        byte[] r13 = this.f19158a;
        if (r14 >= 4096) goto L17;
        byte[] r15 = new byte[r14];
        int r16 = this.f19159b - r10;
        System.arraycopy(r13, r10, r15, 0, r16);
        this.d = this.f19159b;
        int r17 = r14 - r16;
        if (r17 <= 0) goto L15;
        p(r17);
    L15:
        System.arraycopy(r13, 0, r15, r16, r17);
        this.d = r17;
        return r15;
    L17:
        int r18 = this.f19159b;
        this.g = r5 + r18;
        this.d = 0;
        this.f19159b = 0;
        int r19 = r18 - r10;
        int r20 = r14 - r19;
        ArrayList r21 = new ArrayList();
    L18:
        if (r20 <= 0) goto L30;
        int r22 = Math.min(r20, 4096);
        byte[] r23 = new byte[r22];
        int r24 = 0;
    L20:
        if (r24 >= r22) goto L29;
        InputStream r110 = this.e;
        if (r110 != null) goto L24;
        int r111 = -1;
    L25:
        if (r111 == (-1)) goto L28;
        this.g += r111;
        r24 = r24 + r111;
        goto L20
    L28:
        throw InvalidProtocolBufferException.truncatedMessage();
    L24:
        r111 = r110.read(r23, r24, r22 - r24);
        goto L25
    L29:
        r20 = r20 - r22;
        r21.add(r23);
        goto L18
    L30:
        byte[] r112 = new byte[r14];
        System.arraycopy(r13, r10, r112, 0, r19);
        Iterator r113 = r21.iterator();
    L32:
        if (r113.hasNext() == false) goto L34;
        byte[] r25 = (byte[]) r113.next();
        System.arraycopy(r25, 0, r112, r19, r25.length);
        r19 = r19 + r25.length;
        goto L32
    L34:
        return r112;
    L35:
        r((r12 - r5) - r10);
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public final int i() {
        int r5 = this.d;
        if ((this.f19159b - r5) >= 4) goto L5;
        p(4);
        r5 = this.d;
    L5:
        this.d = r5 + 4;
        byte[] r10 = this.f19158a;
        int r11 = ((r10[r5] & UByte.MAX_VALUE) | ((r10[r5 + 1] & UByte.MAX_VALUE) << 8)) | ((r10[r5 + 2] & UByte.MAX_VALUE) << 16);
        return ((r10[r5 + 3] & UByte.MAX_VALUE) << 24) | r11;
    }

    public final long j() {
        int r5 = this.d;
        if ((this.f19159b - r5) >= 8) goto L5;
        p(8);
        r5 = this.d;
    L5:
        this.d = r5 + 8;
        byte[] r10 = this.f19158a;
        long r11 = ((long) r10[r5]) & 255;
        return ((((((((((long) r10[r5 + 1]) & 255) << 8) | r11) | ((((long) r10[r5 + 2]) & 255) << 16)) | ((((long) r10[r5 + 3]) & 255) << 24)) | ((((long) r10[r5 + 4]) & 255) << 32)) | ((((long) r10[r5 + 5]) & 255) << 40)) | ((((long) r10[r5 + 6]) & 255) << 48)) | ((((long) r10[r5 + 7]) & 255) << 56);
    }

    public final int k() {
        int r5 = this.d;
        int r10 = this.f19159b;
        if (r10 == r5) goto L36;
        int r11 = r5 + 1;
        byte[] r12 = this.f19158a;
        byte r13 = r12[r5];
        if (r13 < 0) goto L10;
        this.d = r11;
        return r13;
    L10:
        if ((r10 - r11) < 9) goto L36;
        int r14 = r5 + 2;
        int r15 = (r12[r11] << 7) ^ r13;
        long r16 = r15;
        if (r16 >= 0) goto L15;
        int r17 = (int) ((-128) ^ r16);
    L40:
        this.d = r14;
        return r17;
    L15:
        int r18 = r5 + 3;
        int r19 = (r12[r14] << 14) ^ r15;
        long r20 = r19;
        if (r20 < 0) goto L19;
        r17 = (int) (16256 ^ r20);
    L18:
        r14 = r18;
        goto L40
    L19:
        int r21 = r5 + 4;
        int r22 = r19 ^ (r12[r18] << 21);
        long r23 = r22;
        if (r23 >= 0) goto L23;
        r17 = (int) ((-2080896) ^ r23);
    L22:
        r14 = r21;
        goto L40
    L23:
        r18 = r5 + 5;
        byte r24 = r12[r21];
        int r25 = (int) (((long) (r22 ^ (r24 << 28))) ^ 266354560);
        if (r24 >= 0) goto L38;
        r21 = r5 + 6;
        if (r12[r18] >= 0) goto L39;
        r18 = r5 + 7;
        if (r12[r21] >= 0) goto L38;
        r21 = r5 + 8;
        if (r12[r18] >= 0) goto L39;
        r18 = r5 + 9;
        if (r12[r21] >= 0) goto L38;
        int r26 = r5 + 10;
        if (r12[r18] < 0) goto L36;
        r14 = r26;
        r17 = r25;
    L39:
        r17 = r25;
    L38:
        r17 = r25;
    L36:
        return (int) m();
    }

    public final long l() {
        int r5 = this.d;
        int r10 = this.f19159b;
        if (r10 == r5) goto L40;
        int r11 = r5 + 1;
        byte[] r12 = this.f19158a;
        byte r13 = r12[r5];
        if (r13 < 0) goto L10;
        this.d = r11;
        return r13;
    L10:
        if ((r10 - r11) < 9) goto L40;
        int r14 = r5 + 2;
        long r15 = (r12[r11] << 7) ^ r13;
        if (r15 >= 0) goto L16;
        long r16 = -128;
    L15:
        long r17 = r16 ^ r15;
    L43:
        this.d = r14;
        return r17;
    L16:
        int r18 = r5 + 3;
        long r19 = r15 ^ ((long) (r12[r14] << 14));
        if (r19 < 0) goto L20;
        long r20 = 16256;
    L19:
        r14 = r18;
        r17 = r20 ^ r19;
        goto L43
    L20:
        r14 = r5 + 4;
        r15 = r19 ^ ((long) (r12[r18] << 21));
        if (r15 >= 0) goto L23;
        r16 = -2080896;
        goto L15
    L23:
        r18 = r5 + 5;
        r19 = r15 ^ (((long) r12[r14]) << 28);
        if (r19 < 0) goto L26;
        r20 = 266354560;
        goto L19
    L26:
        r14 = r5 + 6;
        r15 = r19 ^ (((long) r12[r18]) << 35);
        if (r15 >= 0) goto L29;
        r16 = -34093383808L;
        goto L15
    L29:
        r18 = r5 + 7;
        r19 = r15 ^ (((long) r12[r14]) << 42);
        if (r19 < 0) goto L32;
        r20 = 4363953127296L;
        goto L19
    L32:
        r14 = r5 + 8;
        r15 = r19 ^ (((long) r12[r18]) << 49);
        if (r15 >= 0) goto L35;
        r16 = -558586000294016L;
        goto L15
    L35:
        int r21 = r5 + 9;
        long r22 = (r15 ^ (((long) r12[r14]) << 56)) ^ 71499008037633920L;
        if (r22 >= 0) goto L42;
        r14 = r5 + 10;
        if (r12[r21] < 0) goto L40;
    L41:
        r17 = r22;
        goto L43
    L42:
        r14 = r21;
    L40:
        return m();
    }

    public final long m() {
        long r5 = 0;
        int r10 = 0;
    L4:
        if (r10 >= 64) goto L13;
        if (this.d != this.f19159b) goto L8;
        p(1);
    L8:
        int r11 = this.d;
        this.d = r11 + 1;
        byte r12 = this.f19158a[r11];
        r5 = r5 | (((long) (r12 & ByteCompanionObject.MAX_VALUE)) << r10);
        if ((r12 & ByteCompanionObject.MIN_VALUE) == 0) goto L10;
        r10 = r10 + 7;
        goto L4
    L10:
        return r5;
    L13:
        throw InvalidProtocolBufferException.malformedVarint();
    }

    public final int n() {
        if (this.d == this.f19159b) goto L5;
    L8:
        int r5 = k();
        this.f = r5;
        if ((r5 >>> 3) == 0) goto L12;
        return r5;
    L12:
        throw InvalidProtocolBufferException.invalidTag();
    L5:
        if (s(1) == true) goto L8;
        this.f = 0;
        return 0;
    }

    public final void o() {
        int r5 = this.f19159b + this.f19160c;
        this.f19159b = r5;
        int r10 = this.g + r5;
        int r11 = this.f19161h;
        if (r10 <= r11) goto L5;
        int r12 = r10 - r11;
        this.f19160c = r12;
        this.f19159b = r5 - r12;
        return;
    L5:
        this.f19160c = 0;
    }

    public final void p(int r5) {
        if (s(r5) == false) goto L6;
        return;
    L6:
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public final boolean q(int r5, g r10) {
        int r11 = r5 & 7;
        if (r11 == 0) goto L29;
        if (r11 != 1) goto L6;
        long r12 = j();
        r10.v(r5);
        r10.u(r12);
        return true;
    L6:
        if (r11 != 2) goto L8;
        x r13 = e();
        r10.v(r5);
        r10.v(r13.size());
        r10.r(r13);
        return true;
    L8:
        if (r11 == 3) goto L18;
        if (r11 != 4) goto L11;
        return false;
    L11:
        if (r11 != 5) goto L15;
        int r14 = i();
        r10.v(r5);
        r10.t(r14);
        return true;
    L15:
        throw InvalidProtocolBufferException.invalidWireType();
    L18:
        r10.v(r5);
    L19:
        int r15 = n();
        if (r15 == 0) goto L23;
        if (q(r15, r10) == true) goto L19;
    L23:
        int r16 = ((r5 >>> 3) << 3) | 4;
        a(r16);
        r10.v(r16);
        return true;
    L29:
        long r17 = l();
        r10.v(r5);
        r10.w(r17);
        return true;
    }

    public final void r(int r10) {
        int r5 = this.f19159b;
        int r11 = this.d;
        if (r10 > (r5 - r11)) goto L6;
        if (r10 < 0) goto L6;
        this.d = r11 + r10;
        return;
    L6:
        if (r10 < 0) goto L18;
        int r12 = this.g;
        int r13 = (r12 + r11) + r10;
        int r14 = this.f19161h;
        if (r13 > r14) goto L15;
        int r15 = r5 - r11;
        this.d = r5;
        p(1);
    L10:
        int r16 = r10 - r15;
        int r17 = this.f19159b;
        if (r16 <= r17) goto L13;
        r15 = r15 + r17;
        this.d = r17;
        p(1);
        goto L10
    L13:
        this.d = r16;
        return;
    L15:
        r((r14 - r12) - r11);
        throw InvalidProtocolBufferException.truncatedMessage();
    L18:
        throw InvalidProtocolBufferException.negativeSize();
    }

    public final boolean s(int r10) {
        int r5 = this.d;
        int r11 = r5 + r10;
        int r12 = this.f19159b;
        if (r11 > r12) goto L5;
        StringBuilder r13 = new StringBuilder(77);
        r13.append("refillBuffer() called when ");
        r13.append(r10);
        r13.append(" bytes were already available in buffer");
        throw new IllegalStateException(r13.toString());
    L5:
        if (((this.g + r5) + r10) <= this.f19161h) goto L7;
        return false;
    L7:
        InputStream r14 = this.e;
        if (r14 == null) goto L32;
        byte[] r15 = this.f19158a;
        if (r5 <= 0) goto L14;
        if (r12 <= r5) goto L13;
        System.arraycopy(r15, r5, r15, 0, r12 - r5);
    L13:
        this.g += r5;
        this.f19159b -= r5;
        this.d = 0;
    L14:
        int r16 = this.f19159b;
        int r17 = r14.read(r15, r16, r15.length - r16);
        if (r17 != 0) goto L17;
    L30:
        StringBuilder r18 = new StringBuilder(102);
        r18.append("InputStream#read(byte[]) returned invalid result: ");
        r18.append(r17);
        r18.append("\nThe InputStream implementation is buggy.");
        throw new IllegalStateException(r18.toString());
    L17:
        if (r17 < (-1)) goto L30;
        if (r17 > r15.length) goto L30;
        if (r17 <= 0) goto L32;
        this.f19159b += r17;
        if (((this.g + r10) - AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) > 0) goto L29;
        o();
        if (this.f19159b < r10) goto L27;
        return true;
    L27:
        return s(r10);
    L29:
        throw InvalidProtocolBufferException.sizeLimitExceeded();
    L32:
        return false;
    }

    public f(InputStream r5) {
        this.f19161h = Integer.MAX_VALUE;
        this.f19158a = new byte[4096];
        this.f19159b = 0;
        this.d = 0;
        this.g = 0;
        this.e = r5;
    }

    public f(x r5) {
        this.f19161h = Integer.MAX_VALUE;
        byte[] r10 = r5.f19212b;
        this.f19158a = r10;
        this.d = 0;
        this.f19159b = r10.length;
        this.g = -0;
        this.e = null;
    }
}
