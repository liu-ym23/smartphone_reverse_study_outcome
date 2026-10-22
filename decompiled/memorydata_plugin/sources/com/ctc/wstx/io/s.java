package com.ctc.wstx.io;

import java.io.CharConversionException;
import java.io.InputStream;
import okio.Utf8;

/* JADX INFO: loaded from: classes2.dex */
public final class s extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final boolean f3541a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected boolean f3542b;
    protected char h;
    protected int i;
    protected int j;

    public s(com.ctc.wstx.a.b r1, InputStream r2, byte[] r3, int r4, int r5, boolean r6, boolean r7) {
        super(r1, r2, r3, r4, r5, r6);
        this.h = 0;
        this.i = 0;
        this.j = 0;
        this.f3541a = r7;
    }

    private void a(int r5, int r6) {
        int r0 = this.j + r5;
        throw new CharConversionException("Unexpected EOF in the middle of a 4-byte UTF-32 char: got " + r5 + ", needed " + r6 + ", at char #" + this.i + ", byte #" + r0 + ")");
    }

    private void a(int r4, int r5, String r6) {
        int r0 = (this.j + this.e) - 1;
        throw new CharConversionException("Invalid UTF-32 character 0x" + Integer.toHexString(r4) + r6 + " at char #" + (this.i + r5) + ", byte #" + r0 + ")");
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0038 -> B:18:0x003b). Please report as a decompilation issue!!! */
    private boolean c(int r7) {
        this.j += this.f - r7;
        if (r7 > 0) goto L5;
        int r8 = b();
        if (r8 >= 1) goto L19;
        if (r8 >= 0) goto L17;
        c();
        return false;
    L17:
        d();
    L19:
        if ((this.f - this.e) >= 4) goto L24;
        int r9 = b(this.f);
        if (r9 >= 1) goto L19;
        if (r9 >= 0) goto L17;
        c();
        a(this.f, 4);
        goto L17
    L24:
        return true;
    L5:
        if (this.e <= 0) goto L19;
        if (a() == false) goto L19;
        int r2 = 0;
    L9:
        if (r2 >= r7) goto L11;
        this.d[r2] = this.d[this.e + r2];
        r2 = r2 + 1;
        goto L9
    L11:
        this.e = 0;
        this.f = r7;
        goto L19
    }

    @Override // com.ctc.wstx.io.c
    public void a(int r2) {
        if (r2 != 272) goto L5;
        boolean r3 = true;
    L6:
        this.f3542b = r3;
        return;
    L5:
        r3 = false;
        goto L6
    }

    @Override // com.ctc.wstx.io.c, java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public /* bridge */ /* synthetic */ void close() {
        super.close();
    }

    @Override // com.ctc.wstx.io.c, java.io.Reader
    public /* bridge */ /* synthetic */ int read() {
        return super.read();
    }

    @Override // java.io.Reader
    public int read(char[] r11, int r12, int r13) {
        if (r12 >= 0) goto L4;
    L5:
        a(r11, r12, r13);
    L7:
        if (this.d != null) goto L10;
        return -1;
    L10:
        if (r13 >= 1) goto L12;
        return 0;
    L12:
        int r14 = r13 + r12;
        char r2 = this.h;
        if (r2 == 0) goto L15;
        int r1 = r12 + 1;
        r11[r12] = r2;
        this.h = 0;
    L23:
        byte[] r0 = this.d;
        int r3 = this.f - 4;
    L24:
        if (r1 >= r14) goto L66;
        int r4 = this.e;
        if (this.e > r3) goto L66;
        if (this.f3541a == false) goto L31;
        int r5 = ((r0[r4] << 24) | ((r0[r4 + 1] & 255) << 16)) | ((r0[r4 + 2] & 255) << 8);
        int r6 = r0[r4 + 3] & 255;
    L32:
        int r7 = r6 | r5;
        this.e += 4;
        if (r7 < 127) goto L65;
        if (r7 > 159) goto L43;
        if (this.f3542b == false) goto L65;
        if (r7 == 133) goto L41;
        a(r7, r1 - r12, "(can only be included via entity in xml 1.1)");
    L41:
        r7 = 10;
        goto L65
    L43:
        if (r7 < 55296) goto L61;
        if (r7 <= 1114111) goto L48;
        a(r7, r1 - r12, "(above " + Integer.toHexString(1114111) + ") ");
    L48:
        if (r7 <= 65535) goto L54;
        int r8 = r7 - 65536;
        int r9 = r1 + 1;
        r11[r1] = (char) ((r8 >> 10) + 55296);
        r7 = (r8 & 1023) | Utf8.LOG_SURROGATE_HEADER;
        if (r9 >= r14) goto L51;
        r1 = r9;
        goto L65
    L51:
        this.h = (char) r7;
        r1 = r9;
        goto L66
    L54:
        if (r7 >= 57344) goto L58;
        int r10 = r1 - r12;
        String r15 = "(a surrogate char) ";
    L56:
        a(r7, r10, r15);
        goto L65
    L58:
        if (r7 < 65534) goto L65;
        r10 = r1 - r12;
        r15 = "";
        goto L56
    L61:
        if (r7 != 8232) goto L65;
        if (this.f3542b == true) goto L41;
    L65:
        r11[r1] = (char) r7;
        r1 = r1 + 1;
        goto L24
    L31:
        r5 = ((r0[r4] & 255) | ((r0[r4 + 1] & 255) << 8)) | ((r0[r4 + 2] & 255) << 16);
        r6 = r0[r4 + 3] << 24;
    L66:
        int r16 = r1 - r12;
        this.i += r16;
        return r16;
    L15:
        int r17 = this.f - this.e;
        if (r17 < 4) goto L18;
    L22:
        r1 = r12;
        goto L23
    L18:
        if (c(r17) == true) goto L22;
        if (r17 != 0) goto L21;
        return -1;
    L21:
        a(this.f - this.e, 4);
        goto L22
    L4:
        if ((r12 + r13) <= r11.length) goto L7;
        goto L5
    }
}
