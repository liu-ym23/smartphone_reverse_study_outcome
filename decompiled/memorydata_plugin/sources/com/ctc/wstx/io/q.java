package com.ctc.wstx.io;

import com.bytedance.rpc.internal.RpcUtils;
import com.ctc.wstx.exc.WstxEOFException;
import com.ctc.wstx.exc.WstxIOException;
import java.io.ByteArrayInputStream;
import java.io.CharConversionException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/* JADX INFO: loaded from: classes2.dex */
public final class q extends k {
    final InputStream k;
    boolean l;
    boolean m;
    boolean n;
    int o;
    boolean p;
    String q;
    int[] r;
    private byte[] s;
    private final boolean t;
    private int u;
    private int v;

    private q(String r2, r r3, InputStream r4) {
        super(r2, r3);
        this.l = true;
        this.m = false;
        this.n = false;
        this.p = false;
        this.q = null;
        this.r = null;
        this.k = r4;
        this.v = 0;
        this.u = 0;
        this.t = true;
    }

    public static q a(String r1, r r2, InputStream r3) {
        return new q(r1, r2, r3);
    }

    private void a(String r4, int r5) {
        if (this.n == true) goto L5;
        return;
    L5:
        if (r5 != this.o) goto L7;
        return;
    L7:
        if (this.p == false) goto L9;
        b("Declared encoding '" + r4 + "' incompatible with auto-detected physical encoding (EBCDIC variant), can not decode input since actual code page not known");
    L9:
        b("Declared encoding '" + r4 + "' uses " + r5 + " bytes per character; but physical encoding appeared to use " + this.o + "; cannot decode");
    }

    private void a(String r2, int r3, boolean r4) {
        if (this.n == false) goto L11;
        a(r2, r3);
        if (r4 == this.l) goto L12;
        if (r4 == false) goto L8;
        String r5 = "big";
    L9:
        b("Declared encoding '" + r2 + "' has different endianness (" + r5 + " endian) than what physical ordering appeared to be; cannot decode");
        return;
    L8:
        r5 = "little";
        goto L9
    L12:
        return;
    }

    private void g(String r3) {
        throw new CharConversionException("Unsupported UCS-4 endianness (" + r3 + ") detected");
    }

    @Override // com.ctc.wstx.io.k
    public int a(String r3) {
        int r0 = this.o;
        if (r0 == 1) goto L11;
        if (r0 != (-1)) goto L9;
        return f(r3);
    L9:
        return e(r3);
    L11:
        return d(r3);
    }

    @Override // com.ctc.wstx.io.k
    public int a(boolean r4) {
        int r0 = this.o;
        if (r0 != 1) goto L5;
        int r1 = q();
    L8:
        if (r4 == false) goto L11;
        if (r1 != 0) goto L11;
        a(j(), "; expected a white space");
    L11:
        int r5 = this.o;
        if (r5 == 1) goto L18;
        if (r5 != (-1)) goto L17;
        return s();
    L17:
        return r();
    L18:
        int r6 = this.u;
        if (r6 >= this.v) goto L21;
        byte[] r2 = this.s;
        this.u = r6 + 1;
        byte r3 = r2[r6];
    L23:
        return r3 & 255;
    L21:
        r3 = p();
        goto L23
    L5:
        if (r0 != (-1)) goto L7;
        r1 = u();
        goto L8
    L7:
        r1 = t();
        goto L8
    }

    @Override // com.ctc.wstx.io.k
    public int a(char[] r10, int r11) {
        int r0 = r10.length;
        int r1 = this.o;
        int r2 = 0;
        boolean r3 = true;
        if (r1 != 1) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == true) goto L9;
        if (r1 <= 1) goto L9;
    L10:
        if (r2 >= r0) goto L39;
        int r5 = 10;
        if (r4 == false) goto L25;
        int r6 = this.u;
        if (r6 >= this.v) goto L16;
        byte[] r7 = this.s;
        this.u = r6 + 1;
        byte r8 = r7[r6];
    L17:
        if (r8 != 0) goto L19;
        l();
    L19:
        if (r8 == 13) goto L23;
        if (r8 == 10) goto L23;
        r5 = r8;
    L24:
        r5 = r5 & 255;
    L36:
        if (r5 == r11) goto L37;
        r10[r2] = (char) r5;
        r2 = r2 + 1;
        goto L10
    L37:
        return r2;
    L23:
        a(r8);
        goto L24
    L16:
        r8 = p();
        goto L17
    L25:
        if (r3 == false) goto L30;
        int r9 = r();
        if (r9 == 13) goto L29;
        if (r9 == 10) goto L29;
    L34:
        r5 = r9;
    L29:
        b(r9);
        goto L36
    L30:
        r9 = s();
        if (r9 == 13) goto L35;
        if (r9 != 10) goto L34;
    L35:
        c(r9);
        goto L36
    L39:
        return -1;
    L9:
        r3 = false;
        goto L10
    L5:
        r4 = false;
        goto L6
    }

    @Override // com.ctc.wstx.io.k
    public Reader a(com.ctc.wstx.a.b r14, boolean r15, int r16) {
        int r2 = r14.n();
        if (r2 >= 128) goto L6;
        r2 = 128;
    L6:
        if (this.s != null) goto L9;
        this.s = r14.m(r2);
    L9:
        m();
        if (o() == false) goto L14;
        a(r15, r16);
        if (this.g == null) goto L18;
        String r1 = c(this.g);
    L19:
        String r3 = "UTF-32BE";
        String r10 = "UTF-16BE";
        if (r1 == null) goto L22;
    L42:
        this.q = r1;
        if (r1 != RpcUtils.CHARSET_UTF8) goto L46;
        c r4 = new t(r14, this.k, this.s, this.u, this.v, this.t);
    L61:
        if (this.i == false) goto L63;
        r4.a(272);
    L63:
        return r4;
    L46:
        if (r1 != "ISO-8859-1") goto L49;
        r4 = new j(r14, this.k, this.s, this.u, this.v, this.t);
        goto L61
    L49:
        if (r1 != "US-ASCII") goto L52;
        r4 = new a(r14, this.k, this.s, this.u, this.v, this.t);
        goto L61
    L52:
        if (r1.startsWith("UTF-32") == false) goto L64;
        if (r1 == "UTF-32") goto L55;
    L59:
        r4 = new s(r14, this.k, this.s, this.u, this.v, this.t, this.l);
        goto L61
    L55:
        if (this.l == true) goto L58;
        r3 = "UTF-32LE";
    L58:
        this.q = r3;
        goto L59
    L64:
        InputStream r6 = this.k;
        if (this.u >= this.v) goto L69;
        if (r6 != null) goto L68;
        byte[] r5 = this.s;
        int r7 = this.u;
        r6 = new ByteArrayInputStream(r5, r7, this.v - r7);
    L72:
        if (r1 == "UTF-16") goto L74;
    L83:
        return new InputStreamReader(r6, r1);
    L80:
        e = move-exception;
        throw new WstxIOException("Unsupported encoding: " + e.getMessage());
    L74:
        if (this.l == true) goto L77;
        r10 = "UTF-16LE";
    L77:
        this.q = r10;
        r1 = r10;
        goto L83
    L68:
        r6 = new n(r14, r6, this.s, this.u, this.v);
        goto L72
    L69:
        if (r6 != null) goto L72;
        r6 = new ByteArrayInputStream(this.s, 0, 0);
        goto L72
    L22:
        if (this.p == true) goto L24;
        int r8 = this.o;
        if (r8 != 2) goto L36;
        if (this.l == false) goto L34;
        r1 = "UTF-16BE";
        goto L42
    L34:
        r1 = "UTF-16LE";
        goto L42
    L36:
        if (r8 == 4) goto L38;
        r1 = RpcUtils.CHARSET_UTF8;
        goto L42
    L38:
        if (this.l == false) goto L40;
        r1 = "UTF-32BE";
        goto L42
    L40:
        r1 = "UTF-32LE";
        goto L42
    L24:
        if (this.g != null) goto L26;
    L27:
        b("Missing encoding declaration: underlying encoding looks like an EBCDIC variant, but no xml encoding declaration found");
    L28:
        r1 = this.g;
        goto L42
    L26:
        if (this.g.length() != 0) goto L28;
    L18:
        r1 = null;
        goto L19
    L14:
        if (272 != r16) goto L16;
        boolean r9 = true;
    L17:
        this.i = r9;
        goto L18
    L16:
        r9 = false;
        goto L17
    }

    public void a(byte r3) {
        if (r3 != 13) goto L11;
        int r4 = this.u;
        if (r4 >= this.v) goto L7;
        byte[] r0 = this.s;
        this.u = r4 + 1;
        byte r5 = r0[r4];
    L9:
        if (r5 == 10) goto L11;
        this.u--;
        goto L11
    L7:
        r5 = p();
    L11:
        this.d++;
        this.e = this.u;
    }

    public boolean a(int r7) {
        int r0 = this.v - this.u;
    L4:
        if (r0 >= r7) goto L13;
        InputStream r2 = this.k;
        if (r2 != null) goto L8;
        int r3 = -1;
    L9:
        if (r3 < 1) goto L10;
        this.v += r3;
        r0 = r0 + r3;
        goto L4
    L10:
        return false;
    L8:
        byte[] r4 = this.s;
        int r5 = this.v;
        r3 = r2.read(r4, r5, r4.length - r5);
        goto L9
    L13:
        return true;
    }

    public void b(int r2) {
        if (r2 == 13) goto L5;
    L7:
        this.d++;
        this.e = this.u;
        return;
    L5:
        if (r() == 10) goto L7;
        this.u -= this.o;
        goto L7
    }

    public String c(String r5) {
        String r6 = g.a(r5);
        if (r6 != RpcUtils.CHARSET_UTF8) goto L6;
    L4:
        a(r6, 1);
    L29:
        return r6;
    L6:
        if (r6 == "ISO-8859-1") goto L4;
        if (r6 == "US-ASCII") goto L4;
        int r1 = 2;
        if (r6 != "UTF-16") goto L15;
    L13:
        a(r6, r1);
        goto L29
    L15:
        if (r6 != "UTF-16LE") goto L18;
    L16:
        a(r6, r1, false);
        goto L29
    L18:
        if (r6 != "UTF-16BE") goto L20;
    L19:
        a(r6, r1, true);
        goto L29
    L20:
        r1 = 4;
        if (r6 == "UTF-32") goto L13;
        if (r6 == "UTF-32LE") goto L16;
        if (r6 != "UTF-32BE") goto L29;
        goto L29
    }

    public void c(int r2) {
        if (r2 == 13) goto L5;
    L7:
        this.d++;
        this.e = this.u;
        return;
    L5:
        if (s() == 10) goto L7;
        this.u--;
        goto L7
    }

    public int d(String r6) {
        int r0 = r6.length();
        int r1 = 1;
    L3:
        if (r1 >= r0) goto L14;
        int r2 = this.u;
        if (r2 >= this.v) goto L7;
        byte[] r3 = this.s;
        this.u = r2 + 1;
        byte r4 = r3[r2];
    L8:
        if (r4 != 0) goto L10;
        l();
    L10:
        int r5 = r4 & 255;
        if (r5 != r6.charAt(r1)) goto L12;
        r1 = r1 + 1;
        goto L3
    L12:
        return r5;
    L7:
        r4 = p();
        goto L8
    L14:
        return 0;
    }

    @Override // com.ctc.wstx.io.k
    public int e() {
        int r0 = this.c + this.u;
        int r2 = this.o;
        if (r2 > 1) goto L5;
        return r0;
    L5:
        return r0 / r2;
    }

    public int e(String r5) {
        int r0 = r5.length();
        int r1 = 1;
    L3:
        if (r1 >= r0) goto L11;
        int r2 = r();
        if (r2 != 0) goto L8;
        l();
    L8:
        if (r2 != r5.charAt(r1)) goto L9;
        r1 = r1 + 1;
        goto L3
    L9:
        return r2;
    L11:
        return 0;
    }

    public int f(String r5) {
        int r0 = r5.length();
        int r1 = 1;
    L3:
        if (r1 >= r0) goto L11;
        int r2 = s();
        if (r2 != 0) goto L8;
        l();
    L8:
        if (r2 != r5.charAt(r1)) goto L9;
        r1 = r1 + 1;
        goto L3
    L9:
        return r2;
    L11:
        return 0;
    }

    @Override // com.ctc.wstx.io.k
    public int g() {
        int r0 = this.u - this.e;
        int r2 = this.o;
        if (r2 > 1) goto L5;
        return r0;
    L5:
        return r0 / r2;
    }

    @Override // com.ctc.wstx.io.k
    public String h() {
        return this.q;
    }

    @Override // com.ctc.wstx.io.k
    public void i() {
        int r0 = this.o;
        int r1 = this.u;
        if (r0 >= 0) goto L5;
        int r2 = r1 + r0;
    L6:
        this.u = r2;
        return;
    L5:
        r2 = r1 - r0;
        goto L6
    }

    @Override // com.ctc.wstx.io.k
    public int j() {
        int r0 = this.o;
        if (r0 != 1) goto L5;
        int r1 = this.u;
        if (r1 >= this.v) goto L13;
        byte[] r2 = this.s;
        this.u = r1 + 1;
        byte r3 = r2[r1];
    L15:
        return r3 & 255;
    L13:
        r3 = p();
        goto L15
    L5:
        if (r0 != (-1)) goto L9;
        return s();
    L9:
        return r();
    }

    @Override // com.ctc.wstx.io.k
    public javax.xml.stream.a k() {
        int r0 = this.c;
        int r1 = this.u;
        int r2 = r0 + r1;
        int r3 = r1 - this.e;
        int r4 = this.o;
        if (r4 <= 1) goto L6;
        r2 = r2 / r4;
        r3 = r3 / r4;
    L6:
        return new WstxInputLocation(null, this.f3533a, this.f3534b, r2 - 1, this.d, r3);
    }

    public void m() {
        boolean r0 = false;
        this.o = 0;
        this.l = true;
        if (a(4) == false) goto L40;
        byte[] r3 = this.s;
        int r4 = (r3[3] & 255) | (((r3[0] << 24) | ((r3[1] & 255) << 16)) | ((r3[2] & 255) << 8));
        if (r4 != (-16842752)) goto L7;
    L33:
        g("3412");
    L34:
        int r2 = this.u;
        if (r2 <= 0) goto L37;
        boolean r5 = true;
    L38:
        this.m = r5;
        this.c = -r2;
        this.e = this.u;
        goto L40
    L37:
        r5 = false;
        goto L38
    L7:
        if (r4 != (-131072)) goto L9;
        this.o = 4;
        this.u = 4;
    L32:
        this.l = false;
        goto L34
    L9:
        if (r4 != 65279) goto L11;
        this.l = true;
        this.o = 4;
        this.u = 4;
        goto L34
    L11:
        if (r4 == 65534) goto L29;
        int r10 = r4 >>> 16;
        if (r10 != 65279) goto L16;
        this.o = 2;
        this.u = 2;
    L15:
        this.l = true;
        goto L34
    L16:
        if (r10 != 65534) goto L19;
        this.o = 2;
        this.u = 2;
        goto L32
    L19:
        if ((r4 >>> 8) != 15711167) goto L22;
        this.u = 3;
    L21:
        this.o = 1;
        goto L15
    L22:
        switch(r4) {
            case 60: goto L28;
            case 15360: goto L29;
            case 3932160: goto L33;
            case 3932223: goto L27;
            case 1006632960: goto L26;
            case 1006649088: goto L25;
            case 1010792557: goto L21;
            case 1282385812: goto L24;
            default: goto L34;
        };
    L24:
        this.o = -1;
        this.p = true;
        this.r = i.a();
        goto L34
    L25:
        this.o = 2;
        goto L32
    L26:
        this.o = 4;
        goto L32
    L27:
        this.o = 2;
        goto L15
    L28:
        this.l = true;
        this.o = 4;
    L29:
        g("2143");
    L40:
        if (this.o == 0) goto L42;
        r0 = true;
    L42:
        this.n = r0;
        if (r0 == true) goto L46;
        this.o = 1;
        this.l = true;
        return;
    }

    public void n() {
        this.c += this.v;
        this.e -= this.v;
        this.u = 0;
        InputStream r1 = this.k;
        if (r1 != null) goto L5;
        int r0 = -1;
    L6:
        this.v = r0;
        if (r0 < 1) goto L10;
        return;
    L10:
        throw new WstxEOFException(" in xml declaration", k());
    L5:
        byte[] r2 = this.s;
        r0 = r1.read(r2, 0, r2.length);
        goto L6
    }

    public boolean o() {
        int r0 = this.o;
        if (r0 != 1) goto L21;
        if (a(6) == false) goto L55;
        byte[] r1 = this.s;
        int r9 = this.u;
        if (r1[r9] == 60) goto L9;
        return false;
    L9:
        if (r1[r9 + 1] == 63) goto L11;
        return false;
    L11:
        if (r1[r9 + 2] == 120) goto L13;
        return false;
    L13:
        if (r1[r9 + 3] == 109) goto L15;
        return false;
    L15:
        if (r1[r9 + 4] == 108) goto L17;
        return false;
    L17:
        if ((r1[r9 + 5] & 255) > 32) goto L61;
        this.u = r9 + 6;
        return true;
    L61:
        return false;
    L55:
        return false;
    L21:
        if (r0 != (-1)) goto L38;
        if (a(6) == false) goto L62;
        int r2 = this.u;
        if (s() == 60) goto L27;
    L52:
        this.u = r2;
        return false;
    L27:
        if (s() != 63) goto L52;
        if (s() != 120) goto L52;
        if (s() != 109) goto L52;
        if (s() != 108) goto L52;
        if (s() > 32) goto L52;
        return true;
    L62:
        return false;
    L38:
        if (a(r0 * 6) == false) goto L63;
        r2 = this.u;
        if (r() != 60) goto L52;
        if (r() != 63) goto L52;
        if (r() != 120) goto L52;
        if (r() != 109) goto L52;
        if (r() != 108) goto L52;
        if (r() > 32) goto L52;
        return true;
    L63:
        return false;
    }

    public byte p() {
        if (this.u < this.v) goto L5;
        n();
    L5:
        byte[] r0 = this.s;
        int r1 = this.u;
        this.u = r1 + 1;
        return r0[r1];
    }

    public int q() {
        int r0 = 0;
    L3:
        int r1 = this.u;
        if (r1 >= this.v) goto L6;
        byte[] r2 = this.s;
        this.u = r1 + 1;
        byte r3 = r2[r1];
    L8:
        if ((r3 & 255) > 32) goto L9;
        if (r3 != 13) goto L14;
    L18:
        a(r3);
    L19:
        r0 = r0 + 1;
        goto L3
    L14:
        if (r3 == 10) goto L18;
        if (r3 != 0) goto L19;
        l();
        goto L19
    L9:
        this.u--;
        return r0;
    L6:
        r3 = p();
        goto L8
    }

    public int r() {
        int r0 = this.u;
        if (r0 >= this.v) goto L5;
        byte[] r1 = this.s;
        this.u = r0 + 1;
        byte r2 = r1[r0];
    L6:
        int r3 = this.u;
        if (r3 >= this.v) goto L9;
        byte[] r4 = this.s;
        this.u = r3 + 1;
        byte r5 = r4[r3];
    L11:
        if (this.o != 2) goto L17;
        int r6 = r2 & 255;
        if (this.l == false) goto L15;
        r6 = r6 << 8;
        int r7 = r5 & 255;
    L16:
        int r8 = r6 | r7;
    L29:
        if (r8 != 0) goto L31;
        l();
    L31:
        return r8;
    L15:
        r7 = (r5 & 255) << 8;
        goto L16
    L17:
        int r9 = this.u;
        if (r9 >= this.v) goto L20;
        byte[] r10 = this.s;
        this.u = r9 + 1;
        byte r11 = r10[r9];
    L21:
        int r12 = this.u;
        if (r12 >= this.v) goto L24;
        byte[] r13 = this.s;
        this.u = r12 + 1;
        byte r14 = r13[r12];
    L26:
        if (this.l == false) goto L28;
        r6 = ((r2 << 24) | ((r5 & 255) << 16)) | ((r11 & 255) << 8);
        r7 = r14 & 255;
        goto L16
    L28:
        int r15 = (r11 & 255) << 16;
        int r16 = (r5 & 255) << 8;
        int r17 = r2 & 255;
        r8 = r17 | (r16 | (r15 | (r14 << 24)));
        goto L29
    L24:
        r14 = p();
        goto L26
    L20:
        r11 = p();
        goto L21
    L9:
        r5 = p();
        goto L11
    L5:
        r2 = p();
        goto L6
    }

    public int s() {
        int r0 = this.u;
        if (r0 >= this.v) goto L5;
        byte[] r1 = this.s;
        this.u = r0 + 1;
        byte r2 = r1[r0];
    L6:
        int r3 = this.r[r2 & 255];
        if (r3 < 0) goto L9;
        return r3;
    L9:
        return -r3;
    L5:
        r2 = p();
        goto L6
    }

    public int t() {
        int r0 = 0;
    L3:
        int r1 = r();
        if (r1 > 32) goto L5;
        if (r1 != 13) goto L10;
    L14:
        b(r1);
    L15:
        r0 = r0 + 1;
        goto L3
    L10:
        if (r1 == 10) goto L14;
        if (r1 != 0) goto L15;
        l();
        goto L15
    L5:
        this.u -= this.o;
        return r0;
    }

    public int u() {
        int r0 = 0;
    L3:
        int r1 = s();
        if (r1 <= 32) goto L10;
        if (r1 == 133) goto L10;
        this.u--;
        return r0;
    L10:
        if (r1 != 13) goto L12;
    L16:
        c(r1);
    L17:
        r0 = r0 + 1;
        goto L3
    L12:
        if (r1 == 10) goto L16;
        if (r1 != 0) goto L17;
        l();
        goto L17
    }
}
