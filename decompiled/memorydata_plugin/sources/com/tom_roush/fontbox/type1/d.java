package com.tom_roush.fontbox.type1;

import com.tom_roush.pdfbox.pdmodel.a.d.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c f16035a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b f16036b;

    d() {
    }

    private Token a(Token.Kind r4) {
        Token r3 = this.f16035a.a();
        if (r3 == null) goto L8;
        if (r3.b() != r4) goto L8;
        return r3;
    L8:
        throw new IOException("Found " + r3 + " but expected " + r4);
    }

    private List<Number> a(List<Token> r7) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        ArrayList r8 = new ArrayList();
        int r2 = 1;
        int r1 = r6.size() - 1;
    L3:
        if (r2 >= r1) goto L14;
        Token r3 = (Token) ZeusTransformUtils.preCheckCast(r6.get(r2), Token.class, "com.obric.memorydata.plugin");
        if (r3.b() != Token.d) goto L9;
        Object r4 = Float.valueOf(r3.d());
    L7:
        r8.add(r4);
        r2 = r2 + 1;
        goto L3
    L9:
        if (r3.b() != Token.e) goto L13;
        r4 = Integer.valueOf(r3.c());
        goto L7
    L13:
        throw new IOException("Expected INTEGER or REAL but got " + r3 + " at array position " + r2);
    L14:
        return r8;
    }

    private void a() {
        if (this.f16035a.a(Token.f16029b) == false) goto L10;
        String r0 = this.f16035a.a().a();
        if (r0.equals("StandardEncoding") == false) goto L9;
        this.f16036b.f16032b = com.tom_roush.fontbox.d.c.c;
    L7:
        b(Token.f16029b, "readonly");
        a(Token.f16029b, "def");
        return;
    L9:
        throw new IOException("Unknown encoding: " + r0);
    L10:
        a(Token.e).c();
        b(Token.f16029b, "array");
    L12:
        if (this.f16035a.a(Token.f16029b) == false) goto L28;
        if (this.f16035a.b().a().equals("dup") == true) goto L20;
        if (this.f16035a.b().a().equals("readonly") == true) goto L20;
        if (this.f16035a.b().a().equals("def") == false) goto L28;
    L20:
        HashMap r1 = new HashMap();
    L22:
        if (this.f16035a.a(Token.f16029b) == false) goto L26;
        if (this.f16035a.b().a().equals("dup") == false) goto L26;
        a(Token.f16029b, "dup");
        int r4 = a(Token.e).c();
        String r5 = a(Token.c).a();
        a(Token.f16029b, "put");
        r1.put(Integer.valueOf(r4), r5);
    L26:
        this.f16036b.f16032b = new com.tom_roush.fontbox.d.a(r1);
    L28:
        this.f16035a.a();
        goto L12
    }

    private void a(int r7) {
        int r0 = a(Token.e).c();
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        this.f16036b.F.add(null);
        r2 = r2 + 1;
        goto L3
    L5:
        a(Token.f16029b, "array");
    L6:
        if (r1 >= r0) goto L19;
        if (this.f16035a.b() == null) goto L19;
        if (this.f16035a.a(Token.f16029b) == false) goto L19;
        if (this.f16035a.b().a().equals("dup") == false) goto L19;
        a(Token.f16029b, "dup");
        Token r3 = a(Token.e);
        a(Token.e);
        Token r4 = a(Token.j);
        int r5 = r3.c();
        if (r5 >= this.f16036b.F.size()) goto L18;
        this.f16036b.F.set(r5, a(r4.f(), 4330, r7));
    L18:
        i();
        r1 = r1 + 1;
    L19:
        h();
    }

    private void a(Token.Kind r3, String r4) {
        Token r2 = a(r3);
        if (r2.a() == null) goto L8;
        if (r2.a().equals(r4) == false) goto L8;
        return;
    L8:
        throw new IOException("Found " + r2 + " but expected " + r4);
    }

    private void a(String r5) {
        List<Token> r0 = c();
        if (r5.equals("FontName") == false) goto L6;
        b r4 = this.f16036b;
        r4.f16031a = ((Token) ZeusTransformUtils.preCheckCast(r0.get(0), Token.class, "com.obric.memorydata.plugin")).a();
        return;
    L6:
        if (r5.equals("PaintType") == false) goto L9;
        b r6 = this.f16036b;
        r6.c = ((Token) ZeusTransformUtils.preCheckCast(r0.get(0), Token.class, "com.obric.memorydata.plugin")).c();
        return;
    L9:
        if (r5.equals("FontType") == false) goto L12;
        b r7 = this.f16036b;
        r7.d = ((Token) ZeusTransformUtils.preCheckCast(r0.get(0), Token.class, "com.obric.memorydata.plugin")).c();
        return;
    L12:
        if (r5.equals("FontMatrix") == false) goto L15;
        b r8 = this.f16036b;
        r8.e = a(r0);
        return;
    L15:
        if (r5.equals("FontBBox") == false) goto L18;
        b r9 = this.f16036b;
        r9.f = a(r0);
        return;
    L18:
        if (r5.equals("UniqueID") == false) goto L21;
        b r10 = this.f16036b;
        r10.g = ((Token) ZeusTransformUtils.preCheckCast(r0.get(0), Token.class, "com.obric.memorydata.plugin")).c();
        return;
    L21:
        if (r5.equals("StrokeWidth") == false) goto L24;
        b r11 = this.f16036b;
        r11.h = ((Token) ZeusTransformUtils.preCheckCast(r0.get(0), Token.class, "com.obric.memorydata.plugin")).d();
        return;
    L24:
        if (r5.equals("FID") == false) goto L34;
        b r12 = this.f16036b;
        r12.i = ((Token) ZeusTransformUtils.preCheckCast(r0.get(0), Token.class, "com.obric.memorydata.plugin")).a();
        return;
    }

    private void a(String r4, List<Token> r5) {
        List<Token> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if (r4.equals("BlueValues") == false) goto L6;
        b r7 = this.f16036b;
        r7.s = a(r6);
        return;
    L6:
        if (r4.equals("OtherBlues") == false) goto L9;
        b r8 = this.f16036b;
        r8.t = a(r6);
        return;
    L9:
        if (r4.equals("FamilyBlues") == false) goto L12;
        b r9 = this.f16036b;
        r9.u = a(r6);
        return;
    L12:
        if (r4.equals("FamilyOtherBlues") == false) goto L15;
        b r10 = this.f16036b;
        r10.v = a(r6);
        return;
    L15:
        if (r4.equals("BlueScale") == false) goto L18;
        b r3 = this.f16036b;
        r3.w = ((Token) ZeusTransformUtils.preCheckCast(r6.get(0), Token.class, "com.obric.memorydata.plugin")).d();
        return;
    L18:
        if (r4.equals("BlueShift") == false) goto L21;
        b r11 = this.f16036b;
        r11.x = ((Token) ZeusTransformUtils.preCheckCast(r6.get(0), Token.class, "com.obric.memorydata.plugin")).c();
        return;
    L21:
        if (r4.equals("BlueFuzz") == false) goto L24;
        b r12 = this.f16036b;
        r12.y = ((Token) ZeusTransformUtils.preCheckCast(r6.get(0), Token.class, "com.obric.memorydata.plugin")).c();
        return;
    L24:
        if (r4.equals("StdHW") == false) goto L27;
        b r13 = this.f16036b;
        r13.z = a(r6);
        return;
    L27:
        if (r4.equals("StdVW") == false) goto L30;
        b r14 = this.f16036b;
        r14.A = a(r6);
        return;
    L30:
        if (r4.equals("StemSnapH") == false) goto L33;
        b r15 = this.f16036b;
        r15.B = a(r6);
        return;
    L33:
        if (r4.equals("StemSnapV") == false) goto L36;
        b r16 = this.f16036b;
        r16.C = a(r6);
        return;
    L36:
        if (r4.equals("ForceBold") == false) goto L39;
        b r17 = this.f16036b;
        r17.D = ((Token) ZeusTransformUtils.preCheckCast(r6.get(0), Token.class, "com.obric.memorydata.plugin")).e();
        return;
    L39:
        if (r4.equals("LanguageGroup") == false) goto L54;
        b r18 = this.f16036b;
        r18.E = ((Token) ZeusTransformUtils.preCheckCast(r6.get(0), Token.class, "com.obric.memorydata.plugin")).c();
        return;
    }

    private void a(Map<String, List<Token>> r6) {
        Iterator r7 = ((Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin")).entrySet().iterator();
    L4:
        if (r7.hasNext() == false) goto L32;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r2 = (String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.memorydata.plugin");
        List r1 = (List) ZeusTransformUtils.preCheckCast(r0.getValue(), List.class, "com.obric.memorydata.plugin");
        if (r2.equals("version") == true) goto L7;
        if (r2.equals("Notice") == true) goto L10;
        if (r2.equals("FullName") == true) goto L13;
        if (r2.equals("FamilyName") == true) goto L16;
        if (r2.equals("Weight") == true) goto L19;
        if (r2.equals("ItalicAngle") == true) goto L22;
        if (r2.equals("isFixedPitch") == true) goto L25;
        if (r2.equals("UnderlinePosition") == true) goto L28;
        if (r2.equals("UnderlineThickness") == false) goto L4;
        b r3 = this.f16036b;
        r3.r = ((Token) ZeusTransformUtils.preCheckCast(r1.get(0), Token.class, "com.obric.memorydata.plugin")).d();
        goto L4
    L28:
        b r4 = this.f16036b;
        r4.q = ((Token) ZeusTransformUtils.preCheckCast(r1.get(0), Token.class, "com.obric.memorydata.plugin")).d();
        goto L4
    L25:
        b r5 = this.f16036b;
        r5.p = ((Token) ZeusTransformUtils.preCheckCast(r1.get(0), Token.class, "com.obric.memorydata.plugin")).e();
        goto L4
    L22:
        b r8 = this.f16036b;
        r8.o = ((Token) ZeusTransformUtils.preCheckCast(r1.get(0), Token.class, "com.obric.memorydata.plugin")).d();
        goto L4
    L19:
        b r9 = this.f16036b;
        r9.n = ((Token) ZeusTransformUtils.preCheckCast(r1.get(0), Token.class, "com.obric.memorydata.plugin")).a();
        goto L4
    L16:
        b r10 = this.f16036b;
        r10.m = ((Token) ZeusTransformUtils.preCheckCast(r1.get(0), Token.class, "com.obric.memorydata.plugin")).a();
        goto L4
    L13:
        b r11 = this.f16036b;
        r11.l = ((Token) ZeusTransformUtils.preCheckCast(r1.get(0), Token.class, "com.obric.memorydata.plugin")).a();
        goto L4
    L10:
        b r12 = this.f16036b;
        r12.k = ((Token) ZeusTransformUtils.preCheckCast(r1.get(0), Token.class, "com.obric.memorydata.plugin")).a();
        goto L4
    L7:
        b r13 = this.f16036b;
        r13.j = ((Token) ZeusTransformUtils.preCheckCast(r1.get(0), Token.class, "com.obric.memorydata.plugin")).a();
        goto L4
    }

    private void a(byte[] r7) {
        if (r7.length == 0) goto L45;
        if (r7.length < 2) goto L43;
        int r0 = 0;
        if (r7[0] != 37) goto L9;
    L10:
        c r1 = new c(r7);
        this.f16035a = r1;
        if ("FontDirectory".equals(r1.b().a()) == false) goto L13;
        a(Token.f16029b, "FontDirectory");
        a(Token.c);
        a(Token.f16029b, "known");
        a(Token.h);
        f();
        a(Token.h);
        f();
        a(Token.f16029b, "ifelse");
    L13:
        int r8 = a(Token.e).c();
        a(Token.f16029b, "dict");
        b(Token.f16029b, "dup");
        a(Token.f16029b, "begin");
    L15:
        if (r0 >= r8) goto L40;
        Token r3 = this.f16035a.b();
        if (r3 == null) goto L40;
        if (r3.b() == Token.f16029b) goto L22;
    L26:
        String r2 = a(Token.c).a();
        if (r2.equals("FontInfo") == false) goto L29;
    L38:
        a(b());
    L39:
        r0 = r0 + 1;
        goto L15
    L29:
        if (r2.equals("Fontinfo") == true) goto L38;
        if (r2.equals("Metrics") == false) goto L35;
        b();
        goto L39
    L35:
        if (r2.equals("Encoding") == false) goto L37;
        a();
        goto L39
    L37:
        a(r2);
        goto L39
    L22:
        if (r3.a().equals("currentdict") == true) goto L40;
        if (r3.a().equals("end") == false) goto L26;
    L40:
        b(Token.f16029b, "currentdict");
        a(Token.f16029b, "end");
        a(Token.f16029b, "currentfile");
        a(Token.f16029b, "eexec");
        return;
    L9:
        if (r7[1] == 33) goto L10;
    L43:
        throw new IOException("Invalid start of ASCII segment of type 1 font");
    L45:
        throw new IOException("ASCII segment of type 1 font is empty");
    }

    private byte[] a(byte[] r6, int r7, int r8) {
        if (r8 != (-1)) goto L5;
        return r6;
    L5:
        int r0 = 0;
        if (r6.length == 0) goto L19;
        if (r8 > r6.length) goto L19;
        byte[] r1 = new byte[r6.length - r8];
    L12:
        if (r0 >= r6.length) goto L17;
        int r2 = r6[r0] & 255;
        int r3 = (r7 >> 8) ^ r2;
        if (r0 < r8) goto L16;
        r1[r0 - r8] = (byte) r3;
    L16:
        r7 = 65535 & (((r2 + r7) * 52845) + 22719);
        r0 = r0 + 1;
        goto L12
    L17:
        return r1;
    L19:
        return new byte[0];
    }

    private Token b(Token.Kind r2, String r3) {
        if (this.f16035a.a(r2) == true) goto L5;
        return null;
    L5:
        if (this.f16035a.b().a().equals(r3) == true) goto L7;
        return null;
    L7:
        return this.f16035a.a();
    }

    private Map<String, List<Token>> b() {
        HashMap r0 = new HashMap();
        int r1 = a(Token.e).c();
        a(Token.f16029b, "dict");
        b(Token.f16029b, "dup");
        a(Token.f16029b, "begin");
        int r2 = 0;
    L4:
        if (r2 >= r1) goto L22;
        if (this.f16035a.b() == null) goto L22;
        if (this.f16035a.a(Token.f16029b) == false) goto L14;
        if (this.f16035a.b().a().equals("end") == true) goto L14;
        a(Token.f16029b);
    L14:
        if (this.f16035a.b() == null) goto L22;
        if (this.f16035a.a(Token.f16029b) == false) goto L21;
        if (this.f16035a.b().a().equals("end") == true) goto L22;
    L21:
        r0.put(a(Token.c).a(), c());
        r2 = r2 + 1;
    L22:
        a(Token.f16029b, "end");
        b(Token.f16029b, "readonly");
        a(Token.f16029b, "def");
        return r0;
    }

    private void b(int r7) {
        int r0 = a(Token.e).c();
        a(Token.f16029b, "dict");
        a(Token.f16029b, "dup");
        a(Token.f16029b, "begin");
        int r1 = 0;
    L4:
        if (r1 >= r0) goto L14;
        if (this.f16035a.b() == null) goto L14;
        if (this.f16035a.a(Token.f16029b) == false) goto L13;
        if (this.f16035a.b().a().equals("end") == true) goto L14;
    L13:
        String r2 = a(Token.c).a();
        a(Token.e);
        Token r3 = a(Token.j);
        this.f16036b.G.put(r2, a(r3.f(), 4330, r7));
        h();
        r1 = r1 + 1;
    L14:
        a(Token.f16029b, "end");
    }

    private void b(List<Token> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if (this.f16035a.b() == null) goto L9;
        if ("systemdict".equals(this.f16035a.b().a()) == false) goto L10;
        a(Token.f16029b, "systemdict");
        a(Token.c, "internaldict");
        a(Token.f16029b, "known");
        a(Token.h);
        f();
        a(Token.h);
        f();
        a(Token.f16029b, "ifelse");
        a(Token.h);
        a(Token.f16029b, "pop");
        r4.clear();
        r4.addAll(d());
        a(Token.i);
        a(Token.f16029b, "if");
        return;
    L10:
        return;
    L9:
        throw new IOException("Missing start token for the system dictionary");
    }

    private void b(byte[] r10) {
        int r2 = 4;
        if (c(r10) == false) goto L5;
        byte[] r11 = a(r10, 55665, 4);
    L6:
        c r0 = new c(r11);
        this.f16035a = r0;
        Token r12 = r0.b();
    L8:
        if (r12 == null) goto L12;
        if (i.l.equals(r12.a()) == true) goto L12;
        this.f16035a.a();
        r12 = this.f16035a.b();
    L12:
        if (r12 == null) goto L49;
        a(Token.c, i.l);
        int r13 = a(Token.e).c();
        a(Token.f16029b, "dict");
        b(Token.f16029b, "dup");
        a(Token.f16029b, "begin");
        int r1 = 0;
    L14:
        if (r1 >= r13) goto L41;
        if (this.f16035a.a(Token.c) == false) goto L41;
        String r3 = a(Token.c).a();
        if ("Subrs".equals(r3) == false) goto L22;
        a(r2);
    L39:
        r1 = r1 + 1;
        goto L14
    L22:
        if ("OtherSubrs".equals(r3) == false) goto L25;
        g();
        goto L39
    L25:
        if ("lenIV".equals(r3) == false) goto L28;
        r2 = ((Token) ZeusTransformUtils.preCheckCast(c().get(0), Token.class, "com.obric.memorydata.plugin")).c();
        goto L39
    L28:
        if ("ND".equals(r3) == false) goto L33;
        a(Token.h);
        b(Token.f16029b, "noaccess");
        a(Token.f16029b, "def");
    L30:
        a(Token.i);
    L31:
        b(Token.f16029b, "executeonly");
        b(Token.f16029b, "readonly");
        a(Token.f16029b, "def");
        goto L39
    L33:
        if ("NP".equals(r3) == false) goto L36;
        a(Token.h);
        b(Token.f16029b, "noaccess");
        a(Token.f16029b);
        goto L30
    L36:
        if ("RD".equals(r3) == false) goto L38;
        a(Token.h);
        f();
        b(Token.f16029b, "bind");
        goto L31
    L38:
        a(r3, c());
    L41:
        if (this.f16035a.a(Token.c) == false) goto L47;
        if (this.f16035a.b().a().equals("CharStrings") == false) goto L47;
        a(Token.c, "CharStrings");
        b(r2);
        return;
    L47:
        this.f16035a.a();
        goto L41
    L49:
        throw new IOException("/Private token not found");
    L5:
        r11 = a(d(r10), 55665, 4);
        goto L6
    }

    private List<Token> c() {
        List<Token> r0 = d();
        h();
        return r0;
    }

    private boolean c(byte[] r6) {
        if (r6.length >= 4) goto L5;
        return true;
    L5:
        int r2 = 0;
    L6:
        if (r2 >= 4) goto L19;
        byte r3 = r6[r2];
        if (r3 == 10) goto L18;
        if (r3 == 13) goto L18;
        if (r3 == 32) goto L18;
        if (r3 == 9) goto L18;
        if (Character.digit((char) r3, 16) != (-1)) goto L18;
        return true;
    L18:
        r2 = r2 + 1;
        goto L6
    L19:
        return false;
    }

    private List<Token> d() {
        ArrayList r0 = new ArrayList();
        Token r1 = this.f16035a.a();
        if (this.f16035a.b() != null) goto L5;
        return r0;
    L5:
        r0.add(r1);
        if (r1.b() != Token.f) goto L20;
        int r2 = 1;
    L9:
        if (this.f16035a.b() == null) goto L10;
        if (this.f16035a.a(Token.f) == false) goto L14;
        r2 = r2 + 1;
    L14:
        Token r3 = this.f16035a.a();
        r0.add(r3);
        if (r3.b() != Token.g) goto L9;
        r2 = r2 - 1;
        if (r2 != 0) goto L9;
    L26:
        b(r0);
        return r0;
    L10:
        return r0;
    L20:
        if (r1.b() != Token.h) goto L23;
        r0.addAll(e());
        goto L26
    L23:
        if (r1.b() != Token.k) goto L26;
        a(Token.l);
        return r0;
    }

    private byte[] d(byte[] r9) {
        int r8 = r9.length;
        int r0 = 0;
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r1 >= r8) goto L9;
        if (Character.digit((char) r9[r1], 16) == (-1)) goto L8;
        r2 = r2 + 1;
    L8:
        r1 = r1 + 1;
        goto L4
    L9:
        byte[] r10 = new byte[r2 / 2];
        int r3 = r9.length;
        int r4 = 0;
        int r5 = -1;
    L10:
        if (r0 >= r3) goto L17;
        int r6 = Character.digit((char) r9[r0], 16);
        if (r6 == (-1)) goto L16;
        if (r5 != (-1)) goto L15;
        r5 = r6;
        goto L16
    L15:
        r10[r4] = (byte) ((r5 * 16) + r6);
        r5 = -1;
        r4 = r4 + 1;
    L16:
        r0 = r0 + 1;
        goto L10
    L17:
        return r10;
    }

    private List<Token> e() {
        ArrayList r0 = new ArrayList();
        int r1 = 1;
    L4:
        if (this.f16035a.b() == null) goto L17;
        if (this.f16035a.a(Token.h) == false) goto L8;
        r1 = r1 + 1;
    L8:
        Token r2 = this.f16035a.a();
        r0.add(r2);
        if (r2.b() != Token.i) goto L4;
        r1 = r1 - 1;
        if (r1 != 0) goto L4;
        Token r4 = b(Token.f16029b, "executeonly");
        if (r4 == null) goto L15;
        r0.add(r4);
    L15:
        return r0;
    L17:
        throw new IOException("Malformed procedure: missing token");
    }

    private void f() {
        int r0 = 1;
    L4:
        if (this.f16035a.b() == null) goto L15;
        if (this.f16035a.a(Token.h) == false) goto L9;
        r0 = r0 + 1;
    L9:
        if (this.f16035a.a().b() != Token.i) goto L4;
        r0 = r0 - 1;
        if (r0 != 0) goto L4;
        b(Token.f16029b, "executeonly");
        return;
    L15:
        throw new IOException("Malformed procedure: missing token");
    }

    private void g() {
        if (this.f16035a.b() == null) goto L13;
        if (this.f16035a.a(Token.f) == false) goto L8;
        d();
    L7:
        h();
        return;
    L8:
        int r0 = a(Token.e).c();
        a(Token.f16029b, "array");
        int r1 = 0;
    L9:
        if (r1 >= r0) goto L7;
        a(Token.f16029b, "dup");
        a(Token.e);
        d();
        i();
        r1 = r1 + 1;
        goto L9
    L13:
        throw new IOException("Missing start token of OtherSubrs procedure");
    }

    private void h() {
        b(Token.f16029b, "readonly");
        b(Token.f16029b, "noaccess");
        Token r0 = a(Token.f16029b);
        if (r0.a().equals("ND") == false) goto L5;
        return;
    L5:
        if (r0.a().equals("|-") == false) goto L8;
        return;
    L8:
        if (r0.a().equals("noaccess") == false) goto L11;
        r0 = a(Token.f16029b);
    L11:
        if (r0.a().equals("def") == false) goto L14;
        return;
    L14:
        throw new IOException("Found " + r0 + " but expected ND");
    }

    private void i() {
        b(Token.f16029b, "readonly");
        Token r0 = a(Token.f16029b);
        if (r0.a().equals("NP") == false) goto L5;
        return;
    L5:
        if (r0.a().equals("|") == false) goto L8;
        return;
    L8:
        if (r0.a().equals("noaccess") == false) goto L11;
        r0 = a(Token.f16029b);
    L11:
        if (r0.a().equals("put") == false) goto L14;
        return;
    L14:
        throw new IOException("Found " + r0 + " but expected NP");
    }

    public b a(byte[] r2, byte[] r3) {
        this.f16036b = new b(r2, r3);
        a(r2);     // Catch: NumberFormatException -> L9
        if (r3.length <= 0) goto L8;
        b(r3);
    L8:
        return this.f16036b;
    L9:
        e = move-exception;
        throw new IOException(e);
    }
}
