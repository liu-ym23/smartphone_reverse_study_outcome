package t3;

import com.bytedance.memory.shrink.BaseType;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InputStream f12940a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f12941b;

    public g(InputStream r10) {
        this.f12941b = 0;
        this.f12940a = r10;
    }

    private int b(e r17) {
        f r10 = j.e(this.f12940a, this.f12941b);
        int r11 = j.a(this.f12940a);
        f r12 = j.e(this.f12940a, this.f12941b);
        f r13 = j.e(this.f12940a, this.f12941b);
        j.i(this.f12940a, this.f12941b << 2);
        int r14 = j.a(this.f12940a);
        int r15 = ((this.f12941b * 7) + 4) + 4;
        short r16 = j.c(this.f12940a);
        int r18 = r15 + 2;
        int r19 = 0;
        int r20 = 0;
    L3:
        if (r20 >= r16) goto L5;
        j.i(this.f12940a, 2);
        r18 = r18 + (u() + 2);
        r20 = r20 + 1;
        goto L3
    L5:
        int r21 = j.c(this.f12940a);
        d[] r22 = new d[r21];
        int r23 = r18 + 2;
        int r110 = 0;
    L6:
        if (r110 >= r21) goto L12;
        f r111 = j.e(this.f12940a, this.f12941b);
        int r112 = this.f12940a.read();
        BaseType r113 = BaseType.getType(r112);
        if (r113 == null) goto L11;
        r22[r110] = new d(r112, r111, j.h(this.f12940a, r113, this.f12941b));
        int r114 = this.f12941b;
        r23 = r23 + ((r114 + 1) + r113.getSize(r114));
        r110 = r110 + 1;
        goto L6
    L11:
        throw new IllegalStateException("accept class failed, lost type def of typeId: " + r112);
    L12:
        int r24 = j.c(this.f12940a);
        d[] r115 = new d[r24];
        int r25 = r23 + 2;
    L13:
        if (r19 >= r24) goto L15;
        r115[r19] = new d(this.f12940a.read(), j.e(this.f12940a, this.f12941b), null);
        r25 = r25 + (this.f12941b + 1);
        r19 = r19 + 1;
        goto L13
    L15:
        r17.c(r10, r11, r12, r13, r14, r22, r115);
        return r25;
    }

    private void c(h r10) {
        String r11 = j.f(this.f12940a);
        int r12 = j.a(this.f12940a);
        if (r12 <= 0) goto L9;
        if (r12 >= 1073741823) goto L9;
        long r13 = j.b(this.f12940a);
        this.f12941b = r12;
        r10.b(r11, r12, r13);
        return;
    L9:
        throw new IOException("bad idSize: " + r12);
    }

    private int d(e r10) {
        r10.d(j.a(this.f12940a), j.e(this.f12940a, this.f12941b));
        return this.f12941b + 4;
    }

    private void e(int r10, int r11, long r12, h r13) {
        e r14 = r13.c(r10, r11, r12);
        if (r14 != null) goto L7;
        j.i(this.f12940a, r12);
        return;
    L7:
        if (r12 <= 0) goto L35;
        int r15 = this.f12940a.read();
        long r16 = r12 - 1;
        if (r15 != 144) goto L11;
    L28:
        r14.b(r15, j.e(this.f12940a, this.f12941b));
        int r17 = this.f12941b;
    L33:
        r12 = r16 - ((long) r17);
        goto L7
    L11:
        if (r15 != 195) goto L13;
    L22:
        r17 = m(r15, r14);
        goto L33
    L13:
        if (r15 != 254) goto L15;
        r17 = d(r14);
        goto L33
    L15:
        if (r15 == 255) goto L28;
        switch(r15) {
            case 1: goto L32;
            case 2: goto L31;
            case 3: goto L30;
            case 4: goto L29;
            case 5: goto L28;
            case 6: goto L27;
            case 7: goto L28;
            case 8: goto L26;
            default: goto L17;
        };
    L17:
        switch(r15) {
            case 32: goto L25;
            case 33: goto L24;
            case 34: goto L23;
            case 35: goto L22;
            default: goto L18;
        };
    L18:
        switch(r15) {
            case 137: goto L28;
            case 138: goto L28;
            case 139: goto L28;
            case 140: goto L28;
            case 141: goto L28;
            case 142: goto L21;
            default: goto L20;
        };
    L21:
        r17 = i(r14);
        goto L33
    L20:
        throw new IllegalArgumentException("acceptHeapDumpRecord loop with unknown tag " + r15 + " with " + this.f12940a.available() + " bytes possibly remaining");
    L23:
        r17 = l(r14);
        goto L33
    L24:
        r17 = f(r14);
        goto L33
    L25:
        r17 = b(r14);
        goto L33
    L26:
        r17 = s(r14);
        goto L33
    L27:
        r17 = r(r14);
        goto L33
    L29:
        r17 = k(r14);
        goto L33
    L30:
        r17 = g(r14);
        goto L33
    L31:
        r17 = h(r14);
        goto L33
    L32:
        r14.b(r15, j.e(this.f12940a, this.f12941b));
        j.i(this.f12940a, this.f12941b);
        r17 = this.f12941b << 1;
        goto L33
    L35:
        r14.a();
    }

    private int f(e r10) {
        f r11 = j.e(this.f12940a, this.f12941b);
        int r12 = j.a(this.f12940a);
        f r13 = j.e(this.f12940a, this.f12941b);
        int r14 = j.a(this.f12940a);
        byte[] r15 = new byte[r14];
        j.d(this.f12940a, r15, 0, r14);
        r10.e(r11, r12, r13, r15);
        int r16 = this.f12941b;
        return (((r16 + 4) + r16) + 4) + r14;
    }

    private int g(e r10) {
        r10.f(j.e(this.f12940a, this.f12941b), j.a(this.f12940a), j.a(this.f12940a));
        return (this.f12941b + 4) + 4;
    }

    private int h(e r10) {
        r10.g(j.e(this.f12940a, this.f12941b), j.a(this.f12940a), j.a(this.f12940a));
        return (this.f12941b + 4) + 4;
    }

    private int i(e r10) {
        r10.h(j.e(this.f12940a, this.f12941b), j.a(this.f12940a), j.a(this.f12940a));
        return (this.f12941b + 4) + 4;
    }

    private void j(int r10, long r11, h r13) {
        r13.d(j.a(this.f12940a), j.e(this.f12940a, this.f12941b), j.a(this.f12940a), j.e(this.f12940a, this.f12941b), r10, r11);
    }

    private int k(e r10) {
        r10.i(j.e(this.f12940a, this.f12941b), j.a(this.f12940a));
        return this.f12941b + 4;
    }

    private int l(e r11) {
        f r10 = j.e(this.f12940a, this.f12941b);
        int r12 = j.a(this.f12940a);
        int r13 = j.a(this.f12940a);
        f r14 = j.e(this.f12940a, this.f12941b);
        int r15 = this.f12941b * r13;
        byte[] r16 = new byte[r15];
        j.d(this.f12940a, r16, 0, r15);
        r11.j(r10, r12, r13, r14, r16);
        int r17 = this.f12941b;
        return (((r17 + 4) + 4) + r17) + r15;
    }

    private int m(int r12, e r13) {
        f r10 = j.e(this.f12940a, this.f12941b);
        int r11 = j.a(this.f12940a);
        int r14 = j.a(this.f12940a);
        int r15 = this.f12940a.read();
        BaseType r16 = BaseType.getType(r15);
        if (r16 == null) goto L7;
        int r17 = r16.getSize(this.f12941b) * r14;
        byte[] r18 = new byte[r17];
        j.d(this.f12940a, r18, 0, r17);
        r13.k(r12, r10, r11, r14, r15, r18);
        return (((this.f12941b + 4) + 4) + 1) + r17;
    L7:
        throw new IllegalStateException("accept primitive array failed, lost type def of typeId: " + r15);
    }

    private void n(h r10) {
    L22:
        int r11 = this.f12940a.read();     // Catch: EOFException -> L21
        int r12 = j.a(this.f12940a);     // Catch: EOFException -> L21
        long r13 = 4294967295L & ((long) j.a(this.f12940a));     // Catch: EOFException -> L21
        if (r11 != 1) goto L5;
        q(r12, r13, r10);     // Catch: EOFException -> L21
        goto L22
    L5:
        if (r11 != 2) goto L7;
        j(r12, r13, r10);     // Catch: EOFException -> L21
        goto L22
    L7:
        if (r11 != 4) goto L9;
        o(r12, r13, r10);     // Catch: EOFException -> L21
        goto L22
    L9:
        if (r11 != 5) goto L11;
        p(r12, r13, r10);     // Catch: EOFException -> L21
        goto L22
    L11:
        if (r11 == 12) goto L15;
        if (r11 == 28) goto L15;
        t(r11, r12, r13, r10);     // Catch: EOFException -> L21
    L15:
        e(r11, r12, r13, r10);     // Catch: EOFException -> L21
    }

    private void o(int r14, long r15, h r17) {
        r17.e(j.e(this.f12940a, this.f12941b), j.e(this.f12940a, this.f12941b), j.e(this.f12940a, this.f12941b), j.e(this.f12940a, this.f12941b), j.a(this.f12940a), j.a(this.f12940a), r14, r15);
    }

    private void p(int r10, long r11, h r12) {
        int r13 = j.a(this.f12940a);
        int r14 = j.a(this.f12940a);
        int r15 = j.a(this.f12940a);
        f[] r16 = new f[r15];
        int r17 = 0;
    L3:
        if (r17 >= r15) goto L5;
        r16[r17] = j.e(this.f12940a, this.f12941b);
        r17 = r17 + 1;
        goto L3
    L5:
        r12.f(r13, r14, r16, r10, r11);
    }

    private void q(int r10, long r11, h r12) {
        r12.g(j.e(this.f12940a, this.f12941b), j.g(this.f12940a, r11 - ((long) this.f12941b)), r10, r11);
    }

    private int r(e r10) {
        r10.l(j.e(this.f12940a, this.f12941b), j.a(this.f12940a));
        return this.f12941b + 4;
    }

    private int s(e r10) {
        r10.m(j.e(this.f12940a, this.f12941b), j.a(this.f12940a), j.a(this.f12940a));
        return (this.f12941b + 4) + 4;
    }

    private void t(int r10, int r11, long r12, h r13) {
        byte[] r14 = new byte[(int) r12];
        j.d(this.f12940a, r14, 0, r12);
        r13.h(r10, r11, r12, r14);
    }

    private int u() {
        int r10 = this.f12940a.read();
        BaseType r11 = BaseType.getType(r10);
        if (r11 == null) goto L7;
        int r12 = r11.getSize(this.f12941b);
        j.i(this.f12940a, r12);
        return r12 + 1;
    L7:
        throw new IllegalStateException("failure to skip type, cannot find type def of typeid: " + r10);
    }

    public void a(h r10) {
        c(r10);
        n(r10);
        r10.a();
    }
}
