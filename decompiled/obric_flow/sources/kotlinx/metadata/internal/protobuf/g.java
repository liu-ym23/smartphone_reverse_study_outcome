package kotlinx.metadata.internal.protobuf;

import java.io.OutputStream;

/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f19166a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f19167b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f19168c;
    public final OutputStream d;

    public g(byte[] r5, int r10) {
        this.d = null;
        this.f19166a = r5;
        this.f19168c = 0;
        this.f19167b = r10;
    }

    public static int a(e r5) {
        int r10 = f(r5.size());
        return r5.size() + r10;
    }

    public static int b(int r5, int r10) {
        int r11 = h(r5);
        return d(r10) + r11;
    }

    public static int c(int r5, int r10) {
        int r11 = h(r5);
        return d(r10) + r11;
    }

    public static int d(int r5) {
        if (r5 >= 0) goto L4;
        return 10;
    L4:
        return f(r5);
    }

    public static int e(int r5, z r10) {
        int r11 = h(r5);
        int r12 = r10.getSerializedSize();
        return (f(r12) + r12) + r11;
    }

    public static int f(int r5) {
        if ((r5 & (-128)) != 0) goto L7;
        return 1;
    L7:
        if ((r5 & (-16384)) != 0) goto L11;
        return 2;
    L11:
        if (((-2097152) & r5) != 0) goto L15;
        return 3;
    L15:
        if ((r5 & (-268435456)) != 0) goto L18;
        return 4;
    L18:
        return 5;
    }

    public static int g(long r5) {
        if (((-128) & r5) != 0) goto L7;
        return 1;
    L7:
        if (((-16384) & r5) != 0) goto L11;
        return 2;
    L11:
        if (((-2097152) & r5) != 0) goto L15;
        return 3;
    L15:
        if (((-268435456) & r5) != 0) goto L19;
        return 4;
    L19:
        if (((-34359738368L) & r5) != 0) goto L23;
        return 5;
    L23:
        if (((-4398046511104L) & r5) != 0) goto L27;
        return 6;
    L27:
        if (((-562949953421312L) & r5) != 0) goto L31;
        return 7;
    L31:
        if (((-72057594037927936L) & r5) != 0) goto L35;
        return 8;
    L35:
        if ((r5 & Long.MIN_VALUE) != 0) goto L38;
        return 9;
    L38:
        return 10;
    }

    public static int h(int r5) {
        return f(r5 << 3);
    }

    public static g j(OutputStream r5, int r10) {
        return new g(r5, new byte[r10]);
    }

    public final void i() {
        if (this.d == null) goto L6;
        k();
        return;
    }

    public final void k() {
        OutputStream r5 = this.d;
        if (r5 == null) goto L7;
        r5.write(this.f19166a, 0, this.f19168c);
        this.f19168c = 0;
        return;
    L7:
        throw new CodedOutputStream$OutOfSpaceException();
    }

    public final void l(int r5, e r10) {
        x(r5, 2);
        v(r10.size());
        r(r10);
    }

    public final void m(int r5, int r10) {
        x(r5, 0);
        o(r10);
    }

    public final void n(int r5, int r10) {
        x(r5, 0);
        o(r10);
    }

    public final void o(int r5) {
        if (r5 < 0) goto L4;
        v(r5);
        return;
    L4:
        w(r5);
    }

    public final void p(int r5, z r10) {
        x(r5, 2);
        v(r10.getSerializedSize());
        r10.writeTo(this);
    }

    public final void q(int r5) {
        byte r10 = (byte) r5;
        if (this.f19168c != this.f19167b) goto L5;
        k();
    L5:
        int r11 = this.f19168c;
        this.f19168c = r11 + 1;
        this.f19166a[r11] = r10;
    }

    public final void r(e r10) {
        int r5 = r10.size();
        int r11 = this.f19168c;
        int r12 = this.f19167b;
        int r13 = r12 - r11;
        byte[] r14 = this.f19166a;
        if (r13 < r5) goto L5;
        r10.e(r14, 0, r11, r5);
        this.f19168c += r5;
        return;
    L5:
        r10.e(r14, 0, r11, r13);
        int r15 = r5 - r13;
        this.f19168c = r12;
        k();
        if (r15 > r12) goto L8;
        r10.e(r14, r13, 0, r15);
        this.f19168c = r15;
        return;
    L8:
        if (r13 < 0) goto L20;
        if (r15 < 0) goto L18;
        int r16 = r13 + r15;
        if (r16 > r10.size()) goto L16;
        if (r15 <= 0) goto L23;
        r10.q(this.d, r13, r15);
        return;
    L23:
        return;
    L16:
        throw new IndexOutOfBoundsException(androidx.constraintlayout.motion.widget.a.i(39, "Source end offset exceeded: ", r16));
    L18:
        throw new IndexOutOfBoundsException(androidx.constraintlayout.motion.widget.a.i(23, "Length < 0: ", r15));
    L20:
        throw new IndexOutOfBoundsException(androidx.constraintlayout.motion.widget.a.i(30, "Source offset < 0: ", r13));
    }

    public final void s(byte[] r10) {
        int r5 = r10.length;
        int r11 = this.f19168c;
        int r12 = this.f19167b;
        int r13 = r12 - r11;
        byte[] r14 = this.f19166a;
        if (r13 < r5) goto L5;
        System.arraycopy(r10, 0, r14, r11, r5);
        this.f19168c += r5;
        return;
    L5:
        System.arraycopy(r10, 0, r14, r11, r13);
        int r15 = r5 - r13;
        this.f19168c = r12;
        k();
        if (r15 > r12) goto L8;
        System.arraycopy(r10, r13, r14, 0, r15);
        this.f19168c = r15;
        return;
    L8:
        this.d.write(r10, r13, r15);
    }

    public final void t(int r5) {
        q(r5 & 255);
        q((r5 >> 8) & 255);
        q((r5 >> 16) & 255);
        q((r5 >> 24) & 255);
    }

    public final void u(long r5) {
        q(((int) r5) & 255);
        q(((int) (r5 >> 8)) & 255);
        q(((int) (r5 >> 16)) & 255);
        q(((int) (r5 >> 24)) & 255);
        q(((int) (r5 >> 32)) & 255);
        q(((int) (r5 >> 40)) & 255);
        q(((int) (r5 >> 48)) & 255);
        q(((int) (r5 >> 56)) & 255);
    }

    public final void v(int r5) {
    L3:
        if ((r5 & (-128)) == 0) goto L4;
        q((r5 & 127) | 128);
        r5 = r5 >>> 7;
        goto L3
    L4:
        q(r5);
    }

    public final void w(long r5) {
    L3:
        if (((-128) & r5) == 0) goto L4;
        q((((int) r5) & 127) | 128);
        r5 = r5 >>> 7;
        goto L3
    L4:
        q((int) r5);
    }

    public final void x(int r5, int r10) {
        v((r5 << 3) | r10);
    }

    public g(OutputStream r5, byte[] r10) {
        this.d = r5;
        this.f19166a = r10;
        this.f19168c = 0;
        this.f19167b = r10.length;
    }
}
