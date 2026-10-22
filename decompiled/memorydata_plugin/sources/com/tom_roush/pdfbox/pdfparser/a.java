package com.tom_roush.pdfbox.pdfparser;

import android.util.Log;
import com.tom_roush.pdfbox.a.k;
import com.tom_roush.pdfbox.a.l;
import com.tom_roush.pdfbox.a.m;
import com.tom_roush.pdfbox.a.o;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import kotlin.text.Typography;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes6.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final int f16130a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final j f16131b;
    protected com.tom_roush.pdfbox.a.e c;
    private final CharsetDecoder d;

    static {
        f16130a = Long.toString(Long.MAX_VALUE).length();
    }

    a(j r3) {
        j r4 = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.memorydata.plugin");
        this.d = com.tom_roush.pdfbox.util.a.f.newDecoder();
        this.f16131b = r4;
    }

    private com.tom_roush.pdfbox.a.b a(m r4) {
        com.tom_roush.pdfbox.a.e r0 = this.c;
        if (r0 == null) goto L7;
        return r0.a(r4);
    L7:
        throw new IOException("object reference " + r4 + " at offset " + this.f16131b.b() + " in content stream");
    }

    private boolean a(com.tom_roush.pdfbox.a.d r7) {
        com.tom_roush.pdfbox.a.i r0 = e();
        if (r0 != null) goto L5;
    L6:
        Log.w("PdfBox-Android", "Empty COSName at offset " + this.f16131b.b());
    L7:
        com.tom_roush.pdfbox.a.b r2 = r();
        l();
        if (r2 != null) goto L12;
        Log.w("PdfBox-Android", "Bad dictionary declaration at offset " + this.f16131b.b());
        return false;
    L12:
        if (ZeusTransformUtils.instanceOf(r2, com.tom_roush.pdfbox.a.h.class) == true) goto L14;
    L16:
        r2.a(true);
        r7.a(r0, r2);
    L17:
        return true;
    L14:
        if (((com.tom_roush.pdfbox.a.h) ZeusTransformUtils.preCheckCast(r2, com.tom_roush.pdfbox.a.h.class, "com.obric.memorydata.plugin")).d() == true) goto L16;
        Log.w("PdfBox-Android", "Skipped out of range number value at offset " + this.f16131b.b());
        goto L17
    L5:
        if (r0.a().isEmpty() == false) goto L7;
        goto L6
    }

    private boolean a(byte[] r1) {
        this.d.decode(ByteBuffer.wrap(r1));     // Catch: CharacterCodingException -> L5
        return true;
    L5:
        return false;
    }

    private static boolean b(char r1) {
        if (f(r1) == false) goto L5;
    L14:
        return true;
    L5:
        if (r1 < 'a') goto L9;
        if (r1 <= 'f') goto L14;
    L9:
        if (r1 >= 'A') goto L11;
    L13:
        return false;
    L11:
        if (r1 > 'F') goto L13;
        goto L13
    }

    public static boolean f(int r1) {
        if (r1 >= 48) goto L5;
    L7:
        return false;
    L5:
        if (r1 > 57) goto L7;
        return true;
    }

    private int g(int r9) {
        byte[] r1 = new byte[3];
        int r2 = this.f16131b.a(r1);
        if (r2 == 3) goto L5;
    L17:
        if (r2 <= 0) goto L19;
        this.f16131b.b(r1, 0, r2);
    L19:
        return r9;
    L5:
        if (r1[0] != 13) goto L17;
        if (r1[1] != 10) goto L11;
        if (r1[2] != 47) goto L11;
    L16:
        r9 = 0;
    L11:
        if (r1[2] == 62) goto L16;
        if (r1[1] == 47) goto L16;
        if (r1[1] != 62) goto L17;
        goto L16
    }

    private boolean h(int r1) {
        if (10 != r1) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean i(int r1) {
        if (13 != r1) goto L5;
        return true;
    L5:
        return false;
    }

    private com.tom_roush.pdfbox.a.b r() {
        long r0 = this.f16131b.b();
        com.tom_roush.pdfbox.a.b r2 = f();
        l();
        if (ZeusTransformUtils.instanceOf(r2, k.class) == true) goto L5;
    L25:
        return r2;
    L5:
        if (k() == false) goto L25;
        long r3 = this.f16131b.b();
        com.tom_roush.pdfbox.a.b r5 = f();
        l();
        a('R');
        if (ZeusTransformUtils.instanceOf(r2, com.tom_roush.pdfbox.a.h.class) == true) goto L12;
        Log.e("PdfBox-Android", "expected number, actual=" + r2 + " at offset " + r0);
        return com.tom_roush.pdfbox.a.j.f16062b;
    L12:
        if (ZeusTransformUtils.instanceOf(r5, com.tom_roush.pdfbox.a.h.class) == true) goto L15;
        Log.e("PdfBox-Android", "expected number, actual=" + r5 + " at offset " + r3);
        return com.tom_roush.pdfbox.a.j.f16062b;
    L15:
        long r4 = ((com.tom_roush.pdfbox.a.h) ZeusTransformUtils.preCheckCast(r2, com.tom_roush.pdfbox.a.h.class, "com.obric.memorydata.plugin")).b();
        if (r4 > 0) goto L19;
        Log.w("PdfBox-Android", "invalid object number value =" + r4 + " at offset " + r0);
        return com.tom_roush.pdfbox.a.j.f16062b;
    L19:
        int r6 = ((com.tom_roush.pdfbox.a.h) ZeusTransformUtils.preCheckCast(r5, com.tom_roush.pdfbox.a.h.class, "com.obric.memorydata.plugin")).c();
        if (r6 >= 0) goto L24;
        Log.e("PdfBox-Android", "invalid generation number value =" + r6 + " at offset " + r0);
        return com.tom_roush.pdfbox.a.j.f16062b;
    L24:
        return a(new m(r4, r6));
    }

    private boolean s() {
    L2:
        int r0 = this.f16131b.a();
        boolean r2 = false;
        if (r0 == (-1)) goto L39;
        if (r0 == 47) goto L39;
        if (r0 == 62) goto L39;
        if (r0 != 101) goto L2;
        if (this.f16131b.a() != 110) goto L2;
        if (this.f16131b.a() != 100) goto L2;
        int r1 = this.f16131b.a();
        if (r1 == 115) goto L17;
    L27:
        boolean r3 = false;
    L28:
        if (r3 == false) goto L30;
    L36:
        if (r3 == true) goto L38;
        if (r2 == false) goto L2;
    L38:
        return true;
    L30:
        if (r1 != 111) goto L36;
        if (this.f16131b.a() != 98) goto L36;
        if (this.f16131b.a() != 106) goto L36;
        r2 = true;
        goto L36
    L17:
        if (this.f16131b.a() != 116) goto L27;
        if (this.f16131b.a() != 114) goto L27;
        if (this.f16131b.a() != 101) goto L27;
        if (this.f16131b.a() != 97) goto L27;
        if (this.f16131b.a() != 109) goto L27;
        r3 = true;
    L39:
        if (r0 != (-1)) goto L41;
        return true;
    L41:
        this.f16131b.a(r0);
        return false;
    }

    private o t() {
        StringBuilder r0 = new StringBuilder();
    L3:
        int r1 = this.f16131b.a();
        char r2 = (char) r1;
        if (b(r2) == true) goto L5;
        if (r1 == 62) goto L32;
        if (r1 < 0) goto L36;
        if (r1 == 32) goto L3;
        if (r1 == 10) goto L3;
        if (r1 == 9) goto L3;
        if (r1 == 13) goto L3;
        if (r1 == 8) goto L3;
        if (r1 == 12) goto L3;
        if ((r0.length() % 2) == 0) goto L27;
        r0.deleteCharAt(r0.length() - 1);
    L27:
        int r3 = this.f16131b.a();
        if (r3 == 62) goto L30;
        if (r3 >= 0) goto L27;
    L30:
        if (r3 >= 0) goto L32;
        throw new IOException("Missing closing bracket for hex string. Reached EOS.");
    L36:
        throw new IOException("Missing closing bracket for hex string. Reached EOS.");
    L32:
        return o.a(r0.toString());
    L5:
        r0.append(r2);
        goto L3
    }

    private k u() {
        StringBuilder r0 = new StringBuilder();
    L3:
        int r1 = this.f16131b.a();
        char r2 = (char) r1;
        if (Character.isDigit(r2) == true) goto L21;
        if (r2 == '-') goto L21;
        if (r2 == '+') goto L21;
        if (r2 == '.') goto L21;
        if (r2 == 'E') goto L21;
        if (r2 == 'e') goto L21;
        if (r1 == (-1)) goto L20;
        this.f16131b.a(r1);
    L20:
        return k.a(r0.toString());
    L21:
        r0.append(r2);
        goto L3
    }

    public com.tom_roush.pdfbox.a.d a() {
        a(Typography.less);
        a(Typography.less);
        l();
        com.tom_roush.pdfbox.a.d r0 = new com.tom_roush.pdfbox.a.d();
        boolean r1 = false;
    L4:
        if (r1 == true) goto L16;
        l();
        char r3 = (char) this.f16131b.c();
        if (r3 == '>') goto L7;
        if (r3 == '/') goto L11;
        Log.w("PdfBox-Android", "Invalid dictionary, found: '" + r3 + "' but expected: '/' at offset " + this.f16131b.b());
        if (s() == false) goto L4;
        return r0;
    L11:
        if (a(r0) == true) goto L4;
        return r0;
    L7:
        r1 = true;
        goto L4
    L16:
        a(Typography.greater);
        a(Typography.greater);
        return r0;
    }

    public void a(char r5) {
        char r0 = (char) this.f16131b.a();
        if (r0 != r5) goto L6;
        return;
    L6:
        throw new IOException("expected='" + r5 + "' actual='" + r0 + "' at offset " + this.f16131b.b());
    }

    public void a(String r2) {
        a(r2.toCharArray(), false);
    }

    public final void a(char[] r4, boolean r5) {
        l();
        int r6 = r4.length;
        int r0 = 0;
    L3:
        if (r0 >= r6) goto L9;
        char r1 = r4[r0];
        if (this.f16131b.a() != r1) goto L8;
        r0 = r0 + 1;
        goto L3
    L8:
        throw new IOException("Expected string '" + new String(r4) + "' but missed at character '" + r1 + "' at offset " + this.f16131b.b());
    L9:
        l();
    }

    public boolean a(int r1) {
        if (r1 != 32) goto L5;
    L31:
        return true;
    L5:
        if (r1 == 13) goto L31;
        if (r1 == 10) goto L31;
        if (r1 == 9) goto L31;
        if (r1 == 62) goto L31;
        if (r1 == 60) goto L31;
        if (r1 == 91) goto L31;
        if (r1 == 47) goto L31;
        if (r1 == 93) goto L31;
        if (r1 == 41) goto L31;
        if (r1 == 40) goto L31;
        if (r1 == 0) goto L31;
        if (r1 == 12) goto L31;
        if (r1 == 37) goto L31;
        return false;
    }

    public void b() {
    L2:
        int r0 = this.f16131b.a();
        if (32 == r0) goto L2;
        if (13 != r0) goto L10;
        r0 = this.f16131b.a();
        if (10 == r0) goto L15;
    L11:
        this.f16131b.a(r0);
        return;
    L15:
        return;
    L10:
        if (10 != r0) goto L11;
    }

    public boolean b(int r1) {
        if (r1 != 93) goto L5;
        return true;
    L5:
        return false;
    }

    public o c() {
        char r0 = (char) this.f16131b.a();
        if (r0 != '<') goto L7;
        return t();
    L7:
        if (r0 != '(') goto L76;
        ByteArrayOutputStream r1 = new ByteArrayOutputStream();
        int r2 = this.f16131b.a();
        int r3 = 1;
    L10:
        if (r3 <= 0) goto L71;
        if (r2 == (-1)) goto L71;
        char r4 = (char) r2;
        if (r4 != ')') goto L18;
        r3 = g(r3 - 1);
        if (r3 != 0) goto L20;
    L17:
        r2 = -2;
    L68:
        if (r2 != (-2)) goto L10;
        r2 = this.f16131b.a();
    L20:
        r1.write(r4);
        goto L17
    L18:
        if (r4 != '(') goto L22;
        r3 = r3 + 1;
        goto L20
    L22:
        if (r4 != '\\') goto L20;
        r4 = (char) this.f16131b.a();
        if (r4 == '\n') goto L64;
        if (r4 == '\r') goto L64;
        if (r4 == '\\') goto L20;
        if (r4 != 'b') goto L31;
        r1.write(8);
        goto L17
    L31:
        if (r4 != 'f') goto L33;
        r4 = '\f';
        goto L20
    L33:
        if (r4 != 'n') goto L35;
        r1.write(10);
        goto L17
    L35:
        if (r4 != 'r') goto L37;
        r1.write(13);
        goto L17
    L37:
        if (r4 == 't') goto L59;
        if (r4 == '(') goto L20;
        if (r4 == ')') goto L55;
        switch(r4) {
            case 48: goto L42;
            case 49: goto L42;
            case 50: goto L42;
            case 51: goto L42;
            case 52: goto L42;
            case 53: goto L42;
            case 54: goto L42;
            case 55: goto L42;
            default: goto L20;
        };
    L42:
        StringBuilder r5 = new StringBuilder();
        r5.append(r4);
        r2 = this.f16131b.a();
        char r6 = (char) r2;
        if (r6 >= '0') goto L45;
    L77:
        r1.write(Integer.parseInt(r5.toString(), 8));
    L52:
        e = move-exception;
        throw new IOException("Error: Expected octal character, actual='" + r5 + "'", e);
    L45:
        if (r6 > '7') goto L77;
        r5.append(r6);
        r2 = this.f16131b.a();
        char r7 = (char) r2;
        if (r7 < '0') goto L77;
        if (r7 > '7') goto L77;
        r5.append(r7);
        r2 = -2;
        goto L77
    L55:
        r3 = g(r3);
        if (r3 != 0) goto L20;
        r1.write(92);
        goto L17
    L59:
        r4 = '\t';
    L64:
        r2 = this.f16131b.a();
        if (c(r2) == false) goto L68;
        if (r2 == (-1)) goto L68;
    L71:
        if (r2 == (-1)) goto L74;
        this.f16131b.a(r2);
    L74:
        return new o(r1.toByteArray());
    L76:
        throw new IOException("parseCOSString string should start with '(' or '<' and not '" + r0 + "' at offset " + this.f16131b.b());
    }

    public boolean c(int r2) {
        if (h(r2) == false) goto L5;
    L8:
        return true;
    L5:
        if (i(r2) == true) goto L8;
        return false;
    }

    public com.tom_roush.pdfbox.a.a d() {
        long r0 = this.f16131b.b();
        a('[');
        com.tom_roush.pdfbox.a.a r3 = new com.tom_roush.pdfbox.a.a();
    L3:
        l();
        int r4 = this.f16131b.c();
        if (r4 <= 0) goto L31;
        if (((char) r4) == ']') goto L31;
        com.tom_roush.pdfbox.a.b r5 = f();
        if (ZeusTransformUtils.instanceOf(r5, l.class) == true) goto L10;
    L19:
        if (r5 != null) goto L20;
        Log.w("PdfBox-Android", "Corrupt array element at offset " + this.f16131b.b() + ", start offset: " + r0);
        String r6 = g();
        if (r6.isEmpty() == true) goto L24;
    L26:
        this.f16131b.b(r6.getBytes(com.tom_roush.pdfbox.util.a.d));
        if ("endobj".equals(r6) == true) goto L30;
        if ("endstream".equals(r6) == false) goto L3;
    L30:
        return r3;
    L24:
        if (this.f16131b.c() != 91) goto L26;
        return r3;
    L20:
        r3.a(r5);
        goto L3
    L10:
        if (r3.b() > 0) goto L12;
    L18:
        r5 = null;
        goto L19
    L12:
        if (ZeusTransformUtils.instanceOf(r3.b(r3.b() - 1), com.tom_roush.pdfbox.a.h.class) == false) goto L18;
        com.tom_roush.pdfbox.a.h r7 = (com.tom_roush.pdfbox.a.h) ZeusTransformUtils.preCheckCast(r3.f(r3.b() - 1), com.tom_roush.pdfbox.a.h.class, "com.obric.memorydata.plugin");
        if (r3.b() <= 0) goto L18;
        if (ZeusTransformUtils.instanceOf(r3.b(r3.b() - 1), com.tom_roush.pdfbox.a.h.class) == false) goto L18;
        r5 = a(new m(((com.tom_roush.pdfbox.a.h) ZeusTransformUtils.preCheckCast(r3.f(r3.b() - 1), com.tom_roush.pdfbox.a.h.class, "com.obric.memorydata.plugin")).b(), r7.c()));
    L31:
        this.f16131b.a();
        l();
        return r3;
    }

    public boolean d(int r1) {
        if (r1 != 0) goto L4;
    L15:
        return true;
    L4:
        if (r1 == 9) goto L15;
        if (r1 == 12) goto L15;
        if (r1 == 10) goto L15;
        if (r1 == 13) goto L15;
        if (r1 == 32) goto L15;
        return false;
    }

    public com.tom_roush.pdfbox.a.i e() {
        a('/');
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
    L3:
        int r1 = this.f16131b.a();
    L5:
        if (r1 == (-1)) goto L28;
        if (r1 != 35) goto L25;
        int r3 = this.f16131b.a();
        int r4 = this.f16131b.a();
        char r5 = (char) r3;
        if (b(r5) == false) goto L18;
        char r6 = (char) r4;
        if (b(r6) == false) goto L18;
        String r2 = Character.toString(r5) + r6;
        r0.write(Integer.parseInt(r2, 16));     // Catch: NumberFormatException -> L15
        r3 = this.f16131b.a();
    L22:
        r1 = r3;
    L15:
        e = move-exception;
        throw new IOException("Error: expected hex digit, actual='" + r2 + "'", e);
    L18:
        if (r4 == (-1)) goto L23;
        if (r3 == (-1)) goto L23;
        this.f16131b.a(r4);
        r0.write(r1);
    L23:
        Log.e("PdfBox-Android", "Premature EOF in BaseParser#parseCOSName");
        r1 = -1;
        goto L28
    L25:
        if (a(r1) == true) goto L28;
        r0.write(r1);
    L28:
        if (r1 == (-1)) goto L30;
        this.f16131b.a(r1);
    L30:
        byte[] r7 = r0.toByteArray();
        if (a(r7) == false) goto L33;
        String r8 = new String(r7, com.tom_roush.pdfbox.util.a.f);
    L35:
        return com.tom_roush.pdfbox.a.i.a(r8);
    L33:
        r8 = new String(r7, com.tom_roush.pdfbox.util.a.e);
        goto L35
    }

    public boolean e(int r1) {
        if (32 != r1) goto L5;
        return true;
    L5:
        return false;
    }

    public com.tom_roush.pdfbox.a.b f() {
        l();
        char r0 = (char) this.f16131b.c();
        if (r0 == '(') goto L70;
        if (r0 == '/') goto L68;
        if (r0 != '<') goto L9;
        int r1 = this.f16131b.a();
        char r2 = (char) this.f16131b.c();
        this.f16131b.a(r1);
        if (r2 != '<') goto L66;
        return a();
    L66:
        return c();
    L9:
        if (r0 != 'R') goto L11;
        this.f16131b.a();
        return new l(null);
    L11:
        if (r0 == '[') goto L59;
        if (r0 != 'f') goto L15;
        String r3 = new String(this.f16131b.b(5), com.tom_roush.pdfbox.util.a.d);
        if (r3.equals("false") == false) goto L57;
        return com.tom_roush.pdfbox.a.c.d;
    L57:
        throw new IOException("expected false actual='" + r3 + "' " + this.f16131b + "' at offset " + this.f16131b.b());
    L15:
        if (r0 != 'n') goto L17;
        a("null");
        return com.tom_roush.pdfbox.a.j.f16062b;
    L17:
        if (r0 != 't') goto L19;
        String r4 = new String(this.f16131b.b(4), com.tom_roush.pdfbox.util.a.d);
        if (r4.equals("true") == false) goto L49;
        return com.tom_roush.pdfbox.a.c.c;
    L49:
        throw new IOException("expected true actual='" + r4 + "' " + this.f16131b + "' at offset " + this.f16131b.b());
    L19:
        if (r0 != 65535) goto L21;
        return null;
    L21:
        if (Character.isDigit(r0) == true) goto L42;
        if (r0 == '-') goto L42;
        if (r0 == '+') goto L42;
        if (r0 == '.') goto L42;
        long r5 = this.f16131b.b();
        String r6 = g();
        if (r6.isEmpty() == false) goto L32;
        int r7 = this.f16131b.c();
        throw new IOException("Unknown dir object c='" + r0 + "' cInt=" + r0 + " peek='" + ((char) r7) + "' peekInt=" + r7 + " at offset " + this.f16131b.b() + " (start offset: " + r5 + ")");
    L32:
        if ("endobj".equals(r6) == false) goto L34;
    L37:
        this.f16131b.b(r6.getBytes(com.tom_roush.pdfbox.util.a.d));
    L38:
        return null;
    L34:
        if ("endstream".equals(r6) == true) goto L37;
        Log.w("PdfBox-Android", "Skipped unexpected dir object = '" + r6 + "' at offset " + this.f16131b.b() + " (start offset: " + r5 + ")");
    L42:
        return u();
    L59:
        return d();
    L68:
        return e();
    L70:
        return c();
    }

    public String g() {
        l();
        StringBuilder r0 = new StringBuilder();
    L3:
        int r1 = this.f16131b.a();
        char r2 = (char) r1;
        if (a(r2) == true) goto L7;
        if (r1 == (-1)) goto L7;
        r0.append(r2);
    L7:
        if (r1 == (-1)) goto L10;
        this.f16131b.a(r1);
    L10:
        return r0.toString();
    }

    public String h() {
        if (this.f16131b.d() == true) goto L19;
        StringBuilder r0 = new StringBuilder(11);
    L5:
        int r1 = this.f16131b.a();
        if (r1 == (-1)) goto L12;
        if (c(r1) == true) goto L12;
        r0.append((char) r1);
    L12:
        if (i(r1) == false) goto L17;
        if (h(this.f16131b.c()) == false) goto L17;
        this.f16131b.a();
    L17:
        return r0.toString();
    L19:
        throw new IOException("Error: End-of-File, expected line at offset " + this.f16131b.b());
    }

    public boolean i() {
        return d(this.f16131b.c());
    }

    public boolean j() {
        return e(this.f16131b.c());
    }

    public boolean k() {
        return f(this.f16131b.c());
    }

    public void l() {
    L2:
        int r0 = this.f16131b.a();
    L4:
        if (d(r0) == true) goto L10;
        if (r0 == 37) goto L10;
        if (r0 == (-1)) goto L23;
        this.f16131b.a(r0);
        return;
    L23:
        return;
    L10:
        if (r0 != 37) goto L2;
    L11:
        r0 = this.f16131b.a();
        if (c(r0) == true) goto L4;
        if (r0 == (-1)) goto L4;
        goto L4
    }

    public long m() {
        long r0 = p();
        if (r0 < 0) goto L8;
        if (r0 >= 10000000000L) goto L8;
        return r0;
    L8:
        throw new IOException("Object Number '" + r0 + "' has more than 10 digits or is negative");
    }

    public int n() {
        int r4 = o();
        if (r4 < 0) goto L8;
        if (r4 > WebSocketProtocol.PAYLOAD_SHORT_MAX) goto L8;
        return r4;
    L8:
        throw new IOException("Generation Number '" + r4 + "' has more than 5 digits");
    }

    public int o() {
        l();
        StringBuilder r0 = q();
        return Integer.parseInt(r0.toString());
    L5:
        e = move-exception;
        this.f16131b.b(r0.toString().getBytes(com.tom_roush.pdfbox.util.a.d));
        throw new IOException("Error: Expected an integer type at offset " + this.f16131b.b() + ", instead got '" + r0 + "'", e);
    }

    public long p() {
        l();
        StringBuilder r0 = q();
        return Long.parseLong(r0.toString());
    L5:
        e = move-exception;
        this.f16131b.b(r0.toString().getBytes(com.tom_roush.pdfbox.util.a.d));
        throw new IOException("Error: Expected a long type at offset " + this.f16131b.b() + ", instead got '" + r0 + "'", e);
    }

    public final StringBuilder q() {
        StringBuilder r0 = new StringBuilder();
    L3:
        int r1 = this.f16131b.a();
        if (r1 < 48) goto L13;
        if (r1 > 57) goto L13;
        r0.append((char) r1);
        if (r0.length() <= f16130a) goto L3;
        throw new IOException("Number '" + r0 + "' is getting too long, stop reading at offset " + this.f16131b.b());
    L13:
        if (r1 == (-1)) goto L15;
        this.f16131b.a(r1);
    L15:
        return r0;
    }
}
