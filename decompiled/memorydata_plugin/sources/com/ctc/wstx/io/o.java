package com.ctc.wstx.io;

import com.ctc.wstx.exc.WstxEOFException;
import com.ctc.wstx.exc.WstxIOException;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.MessageFormat;

/* JADX INFO: loaded from: classes2.dex */
public final class o extends k {
    final Reader k;
    final String l;
    private char[] m;
    private int n;
    private int o;

    private o(String r1, r r2, Reader r3, String r4) {
        super(r1, r2);
        this.k = r3;
        if (r4 == null) goto L5;
    L7:
        this.l = r4;
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r3, InputStreamReader.class) == false) goto L7;
        r4 = ((InputStreamReader) ZeusTransformUtils.preCheckCast(r3, InputStreamReader.class, "com.obric.memorydata.plugin")).getEncoding();
        goto L7
    }

    public static o a(String r1, r r2, Reader r3, String r4) {
        return new o(r1, r2, r3, r4);
    }

    @Override // com.ctc.wstx.io.k
    public int a(String r6) {
        int r0 = r6.length();
        int r1 = 1;
    L3:
        if (r1 >= r0) goto L14;
        int r2 = this.n;
        if (r2 >= this.o) goto L7;
        char[] r3 = this.m;
        this.n = r2 + 1;
        char r4 = r3[r2];
    L9:
        if (r4 != r6.charAt(r1)) goto L10;
        if (r4 != 0) goto L13;
        l();
    L13:
        r1 = r1 + 1;
        goto L3
    L10:
        return r4;
    L7:
        r4 = n();
        goto L9
    L14:
        return 0;
    }

    @Override // com.ctc.wstx.io.k
    public int a(boolean r5) {
        int r0 = 0;
    L3:
        int r1 = this.n;
        if (r1 >= this.o) goto L6;
        char[] r2 = this.m;
        this.n = r1 + 1;
        char r3 = r2[r1];
    L8:
        if (r3 > ' ') goto L9;
        if (r3 != '\r') goto L16;
    L20:
        a(r3);
    L21:
        r0 = r0 + 1;
        goto L3
    L16:
        if (r3 == '\n') goto L20;
        if (r3 != 0) goto L21;
        l();
        goto L21
    L9:
        if (r5 == false) goto L12;
        if (r0 != 0) goto L12;
        a(r3, "; expected a white space");
    L12:
        return r3;
    L6:
        r3 = n();
        goto L8
    }

    @Override // com.ctc.wstx.io.k
    public int a(char[] r6, int r7) {
        int r0 = r6.length;
        int r1 = 0;
    L3:
        int r2 = this.n;
        if (r2 >= this.o) goto L6;
        char[] r3 = this.m;
        this.n = r2 + 1;
        char r4 = r3[r2];
    L8:
        if (r4 != '\r') goto L10;
    L14:
        a(r4);
    L15:
        if (r4 == r7) goto L16;
        if (r1 >= r0) goto L3;
        r6[r1] = r4;
        r1 = r1 + 1;
        goto L3
    L16:
        if (r1 < r0) goto L27;
        return -1;
    L27:
        return r1;
    L10:
        if (r4 == '\n') goto L14;
        if (r4 != 0) goto L15;
        l();
        goto L15
    L6:
        r4 = n();
        goto L8
    }

    @Override // com.ctc.wstx.io.k
    public Reader a(com.ctc.wstx.a.b r7, boolean r8, int r9) {
        if (r7 != null) goto L5;
        char[] r0 = new char[128];
    L6:
        this.m = r0;
        a(7);
        if (this.o < 7) goto L34;
        char[] r1 = this.m;
        int r2 = this.n;
        char r3 = r1[r2];
        if (r3 != 65279) goto L12;
        int r4 = r2 + 1;
        this.n = r4;
        r3 = r1[r4];
    L12:
        if (r3 != '<') goto L29;
        int r5 = this.n;
        if (r1[r5 + 1] != '?') goto L34;
        if (r1[r5 + 2] != 'x') goto L34;
        if (r1[r5 + 3] != 'm') goto L34;
        if (r1[r5 + 4] != 'l') goto L34;
        if (r1[r5 + 5] > ' ') goto L34;
        this.n = r5 + 6;
        a(r8, r9);
        if (this.g == null) goto L34;
        if (this.l == null) goto L34;
        a(r7);
        goto L34
    L29:
        if (r3 != 239) goto L34;
        throw new WstxIOException("Unexpected first character (char code 0xEF), not valid in xml document: could be mangled UTF-8 BOM marker. Make sure that the Reader uses correct encoding or pass an InputStream instead");
    L34:
        if (this.n >= this.o) goto L38;
        return new m(r7, this.k, this.m, this.n, this.o);
    L38:
        return this.k;
    L5:
        r0 = r7.j(128);
        goto L6
    }

    public void a(char r3) {
        if (r3 != '\r') goto L11;
        int r4 = this.n;
        if (r4 >= this.o) goto L7;
        char[] r0 = this.m;
        this.n = r4 + 1;
        char r5 = r0[r4];
    L9:
        if (r5 == '\n') goto L11;
        this.n--;
        goto L11
    L7:
        r5 = n();
    L11:
        this.d++;
        this.e = this.n;
    }

    public void a(com.ctc.wstx.a.b r6) {
        String r0 = this.l;
        if (com.ctc.wstx.util.i.a(r0, this.g) == false) goto L5;
        return;
    L5:
        javax.xml.stream.c r7 = r6.z();
        if (r7 == null) goto L9;
        javax.xml.stream.a r1 = k();
        String r2 = MessageFormat.format(com.ctc.wstx.b.a.i, new Object[]{this.g, r0});
        String r3 = com.ctc.wstx.b.a.d;
        r7.a(r2, r3, new org.codehaus.stax2.validation.e(r1, r2, 1, r3), r1);
        return;
    }

    public boolean a(int r7) {
        this.n = 0;
        this.o = 0;
    L3:
        int r1 = this.o;
        if (r1 >= r7) goto L9;
        Reader r3 = this.k;
        char[] r4 = this.m;
        int r2 = r3.read(r4, r1, r4.length - r1);
        if (r2 < 1) goto L7;
        this.o += r2;
        goto L3
    L7:
        return false;
    L9:
        return true;
    }

    @Override // com.ctc.wstx.io.k
    public int e() {
        return this.c + this.n;
    }

    @Override // com.ctc.wstx.io.k
    public int g() {
        return this.n - this.e;
    }

    @Override // com.ctc.wstx.io.k
    public String h() {
        return this.l;
    }

    @Override // com.ctc.wstx.io.k
    public void i() {
        this.n--;
    }

    @Override // com.ctc.wstx.io.k
    public int j() {
        int r0 = this.n;
        if (r0 >= this.o) goto L6;
        char[] r1 = this.m;
        this.n = r0 + 1;
        return r1[r0];
    L6:
        return n();
    }

    @Override // com.ctc.wstx.io.k
    public javax.xml.stream.a k() {
        return new WstxInputLocation(null, this.f3533a, this.f3534b, (this.c + this.n) - 1, this.d, this.n - this.e);
    }

    public void m() {
        this.c += this.o;
        this.e -= this.o;
        this.n = 0;
        Reader r1 = this.k;
        char[] r2 = this.m;
        int r0 = r1.read(r2, 0, r2.length);
        this.o = r0;
        if (r0 < 1) goto L6;
        return;
    L6:
        throw new WstxEOFException(" in xml declaration", k());
    }

    public char n() {
        if (this.n < this.o) goto L5;
        m();
    L5:
        char[] r0 = this.m;
        int r1 = this.n;
        this.n = r1 + 1;
        return r0[r1];
    }
}
