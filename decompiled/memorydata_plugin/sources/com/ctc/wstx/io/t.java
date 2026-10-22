package com.ctc.wstx.io;

import java.io.CharConversionException;
import java.io.InputStream;
import okio.Utf8;
import org.msgpack.core.MessagePack;

/* JADX INFO: loaded from: classes2.dex */
public final class t extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f3543a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    char f3544b;
    int h;
    int i;

    public t(com.ctc.wstx.a.b r1, InputStream r2, byte[] r3, int r4, int r5, boolean r6) {
        super(r1, r2, r3, r4, r5, r6);
        this.f3543a = false;
        this.f3544b = 0;
        this.h = 0;
        this.i = 0;
    }

    private void a(int r4, int r5) {
        int r0 = (this.i + this.e) - 1;
        throw new CharConversionException("Invalid UTF-8 start byte 0x" + Integer.toHexString(r4) + " (at char #" + ((this.h + r5) + 1) + ", byte #" + r0 + ")");
    }

    private void a(int r4, int r5, String r6) {
        int r0 = (this.i + this.e) - 1;
        throw new CharConversionException("Invalid UTF-8 character 0x" + Integer.toHexString(r4) + r6 + " at char #" + (this.h + r5) + ", byte #" + r0 + ")");
    }

    private void b(int r4, int r5) {
        int r0 = (this.i + this.e) - 1;
        throw new CharConversionException("Invalid UTF-8 middle byte 0x" + Integer.toHexString(r4) + " (at char #" + (this.h + r5) + ", byte #" + r0 + ")");
    }

    private void c(int r5, int r6) {
        int r0 = this.i + r5;
        throw new CharConversionException("Unexpected EOF in the middle of a multi-byte char: got " + r5 + ", needed " + r6 + ", at char #" + this.h + ", byte #" + r0 + ")");
    }

    private boolean c(int r7) {
        this.i += this.f - r7;
        if (r7 > 0) goto L5;
        int r8 = b();
        if (r8 >= 1) goto L18;
        if (r8 >= 0) goto L17;
        c();
        return false;
    L17:
        d();
    L18:
        byte r9 = this.d[this.e];
        if (r9 < 0) goto L22;
        return true;
    L22:
        if ((r9 & MessagePack.Code.NEGFIXINT_PREFIX) != 192) goto L25;
        int r10 = 2;
    L32:
        if ((this.e + r10) <= this.f) goto L38;
        int r0 = b(this.f);
        if (r0 >= 1) goto L32;
        if (r0 >= 0) goto L37;
        c();
        c(this.f, r10);
    L37:
        d();
        goto L32
    L38:
        return true;
    L25:
        if ((r9 & 240) != 224) goto L28;
        r10 = 3;
        goto L32
    L28:
        if ((r9 & 248) != 240) goto L30;
        r10 = 4;
        goto L32
    L30:
        a(r9 & 255, 0);
        r10 = 1;
        goto L32
    L5:
        if (this.e <= 0) goto L18;
        if (a() == false) goto L18;
        int r2 = 0;
    L9:
        if (r2 >= r7) goto L11;
        this.d[r2] = this.d[this.e + r2];
        r2 = r2 + 1;
        goto L9
    L11:
        this.e = 0;
        this.f = r7;
        goto L18
    }

    @Override // com.ctc.wstx.io.c
    public void a(int r2) {
        if (r2 != 272) goto L5;
        boolean r3 = true;
    L6:
        this.f3543a = r3;
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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.io.Reader
    public int read(char[] r17, int r18, int r19) {
        if (r18 >= 0) goto L5;
    L6:
        a(r17, r18, r19);
    L8:
        if (this.d != null) goto L10;
        return -1;
    L10:
        int r6 = 1;
        if (r19 >= 1) goto L13;
        return 0;
    L13:
        int r3 = r19 + r18;
        char r7 = this.f3544b;
        if (r7 == 0) goto L19;
        int r8 = r18 + 1;
        r17[r18] = r7;
        this.f3544b = 0;
        if (this.e < this.f) goto L28;
        this.h++;
        return 1;
    L28:
        byte[] r4 = this.d;
        int r9 = this.e;
        int r10 = this.f;
    L29:
        if (r8 >= r3) goto L120;
        int r11 = r9 + 1;
        int r12 = r4[r9];
        if (r12 < 0) goto L54;
        if (r12 == 127) goto L34;
    L36:
        int r13 = r8 + 1;
        r17[r8] = (char) r12;
        int r14 = r3 - r13;
        int r15 = r10 - r11;
        if (r15 >= r14) goto L39;
        r14 = r15;
    L39:
        int r16 = r11 + r14;
    L40:
        r9 = r11;
        r8 = r13;
        if (r9 >= r16) goto L120;
        r11 = r9 + 1;
        r12 = r4[r9] & 255;
        if (r12 >= 127) goto L45;
        r13 = r8 + 1;
        r17[r8] = (char) r12;
        goto L40
    L45:
        if (r12 != 127) goto L54;
        if (this.f3543a == false) goto L49;
        a(r12, (this.i + r11) - r6, this.h + (r8 - r18));
    L49:
        r17[r8] = (char) r12;
        r9 = r11;
        r8 = r8 + 1;
        if (r11 < r16) goto L29;
    L34:
        if (this.f3543a == false) goto L36;
        a(r12, (this.i + r11) - r6, this.h + (r8 - r18));
    L54:
        if (((r12 == true ? 1 : 0) & 224) != 192) goto L58;
        r12 = (r12 == true ? 1 : 0) & 31;
    L56:
        int r110 = r6;
    L65:
        if ((r10 - r11) < r110) goto L66;
        int r111 = r11 + 1;
        byte r112 = r4[r11];
        if ((r112 & MessagePack.Code.NIL) == 128) goto L70;
        b(r112 & 255, r8 - r18);
    L70:
        int r20 = (r12 << 6) | (r112 & Utf8.REPLACEMENT_BYTE);
        if (r110 <= r6) goto L106;
        int r113 = r111 + 1;
        byte r114 = r4[r111];
        if ((r114 & MessagePack.Code.NIL) == 128) goto L75;
        b(r114 & 255, r8 - r18);
    L75:
        r20 = (r114 & Utf8.REPLACEMENT_BYTE) | (r20 << 6);
        if (r110 <= 2) goto L87;
        int r115 = r113 + 1;
        byte r116 = r4[r113];
        if ((r116 & MessagePack.Code.NIL) == 128) goto L80;
        b(r116 & 255, r8 - r18);
    L80:
        int r5 = (r20 << 6) | (r116 & Utf8.REPLACEMENT_BYTE);
        if (r5 <= 1114111) goto L83;
        a(r5, r8 - r18, "(above " + Integer.toHexString(1114111) + ") ");
    L83:
        int r21 = r5 - 65536;
        int r22 = r8 + 1;
        r17[r8] = (char) ((r21 >> 10) + 55296);
        int r23 = (r21 & 1023) | Utf8.LOG_SURROGATE_HEADER;
        if (r22 >= r3) goto L85;
        r8 = r22;
        r111 = r115;
        r6 = 1;
        r20 = r23;
    L116:
        r17[r8] = (char) r20;
        r8 = r8 + 1;
        r9 = r111;
        if (r111 < r10) goto L29;
    L85:
        this.f3544b = (char) r23;
        r8 = r22;
        r9 = r115;
        goto L120
    L87:
        if (r20 < 55296) goto L96;
        if (r20 >= 57344) goto L93;
        int r24 = r8 - r18;
        String r25 = "(a surrogate character) ";
    L91:
        a(r20, r24, r25);
    L104:
        r111 = r113;
    L112:
        r6 = 1;
        goto L116
    L93:
        if (r20 < 65534) goto L104;
        r24 = r8 - r18;
        r25 = "";
        goto L91
    L96:
        if (this.f3543a == false) goto L104;
        if (r20 != 8232) goto L104;
        if (r8 <= r18) goto L103;
        int r26 = r8 - 1;
        if (r17[r26] != '\r') goto L103;
        r17[r26] = '\n';
    L103:
        r20 = 10;
        goto L104
    L106:
        if (this.f3543a == false) goto L112;
        if (r20 > 159) goto L112;
        if (r20 != 133) goto L114;
        r20 = 10;
        goto L112
    L114:
        if (r20 < 127) goto L112;
        r6 = 1;
        a(r20, (this.i + r111) - 1, this.h + (r8 - r18));
        goto L116
    L66:
        r9 = r11 - 1;
        goto L120
    L58:
        if (((r12 == true ? 1 : 0) & 240) != 224) goto L61;
        r12 = (r12 == true ? 1 : 0) & 15;
        r110 = 2;
        goto L65
    L61:
        if (((r12 == true ? 1 : 0) & 248) != 240) goto L63;
        r12 = (r12 == true ? 1 : 0) & 15;
        r110 = 3;
        goto L65
    L63:
        a((r12 == true ? 1 : 0) & 255, r8 - r18);
    L120:
        this.e = r9;
        int r27 = r8 - r18;
        this.h += r27;
        return r27;
    L19:
        int r28 = this.f - this.e;
        if (r28 >= 4) goto L27;
        if (r28 < 1) goto L25;
        if (this.d[this.e] >= 0) goto L27;
    L25:
        if (c(r28) == true) goto L27;
        return -1;
    L27:
        r8 = r18;
        goto L28
    L5:
        if ((r18 + r19) <= r17.length) goto L8;
        goto L6
    }
}
