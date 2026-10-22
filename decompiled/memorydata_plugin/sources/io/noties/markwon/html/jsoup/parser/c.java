package io.noties.markwon.html.jsoup.parser;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes6.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final int[] f16592a = null;
    private static final char[] i = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    StringBuilder f16593b;
    Token.h c;
    Token.g d;
    Token.f e;
    Token.b f;
    Token.d g;
    Token.c h;
    private final a j;
    private final ParseErrorList k;
    private TokeniserState l;
    private Token m;
    private boolean n;
    private String o;
    private StringBuilder p;
    private String q;
    private final int[] r;
    private final int[] s;

    static {
        char[] r0 = {'\t', '\n', '\r', '\f', ' ', Typography.less, Typography.amp};
        i = r0;
        f16592a = new int[]{8364, 129, 8218, 402, 8222, 8230, 8224, 8225, 710, 8240, 352, 8249, 338, 141, 381, 143, 144, 8216, 8217, 8220, 8221, 8226, 8211, 8212, 732, 8482, 353, 8250, 339, 157, 382, 376};
        Arrays.sort(r0);
    }

    public c(a r3, ParseErrorList r4) {
        this.l = TokeniserState.Data;
        this.n = false;
        this.o = null;
        this.p = new StringBuilder(1024);
        this.f16593b = new StringBuilder(1024);
        this.d = new Token.g();
        this.e = new Token.f();
        this.f = new Token.b();
        this.g = new Token.d();
        this.h = new Token.c();
        this.r = new int[1];
        this.s = new int[2];
        this.j = r3;
        this.k = r4;
    }

    private void c(String r5) {
        if (this.k.canAddError() == false) goto L6;
        this.k.add(new b(this.j.a(), "Invalid character reference: %s", new Object[]{r5}));
        return;
    }

    Token.h a(boolean r1) {
        if (r1 == false) goto L4;
        Token.h r2 = this.d.b();
    L5:
        this.c = r2;
        return r2;
    L4:
        r2 = this.e.b();
        goto L5
    }

    public Token a() {
    L3:
        if (this.n == true) goto L6;
        this.l.read(this, this.j);
        goto L3
    L6:
        if (this.p.length() <= 0) goto L9;
        String r0 = this.p.toString();
        StringBuilder r3 = this.p;
        r3.delete(0, r3.length());
        this.o = null;
        return this.f.a(r0);
    L9:
        String r1 = this.o;
        if (r1 == null) goto L13;
        Token.b r2 = this.f.a(r1);
        this.o = null;
        return r2;
    L13:
        this.n = false;
        return this.m;
    }

    void a(char r1) {
        a(String.valueOf(r1));
    }

    void a(Token r4) {
        io.noties.markwon.html.jsoup.a.b.a(this.n, "There is an unread token pending!");
        this.m = r4;
        this.n = true;
        if (r4.f16583a != Token.TokenType.StartTag) goto L6;
        this.q = ((Token.g) ZeusTransformUtils.preCheckCast(r4, Token.g.class, "com.obric.memorydata.plugin")).f16587b;
        return;
    L6:
        if (r4.f16583a == Token.TokenType.EndTag) goto L8;
        return;
    L8:
        if (((Token.f) ZeusTransformUtils.preCheckCast(r4, Token.f.class, "com.obric.memorydata.plugin")).e == null) goto L13;
        b("Attributes incorrectly present on end tag");
        return;
    }

    void a(TokeniserState r1) {
        this.l = r1;
    }

    void a(String r3) {
        if (this.o != null) goto L6;
        this.o = r3;
        return;
    L6:
        if (this.p.length() != 0) goto L8;
        this.p.append(this.o);
    L8:
        this.p.append(r3);
    }

    void a(int[] r4) {
        a(new String(r4, 0, r4.length));
    }

    int[] a(Character r9, boolean r10) {
        if (this.j.b() == false) goto L5;
        return null;
    L5:
        if (r9 == null) goto L10;
        if (r9.charValue() != this.j.c()) goto L10;
        return null;
    L10:
        if (this.j.d(i) == false) goto L12;
        return null;
    L12:
        int[] r11 = this.r;
        this.j.g();
        if (this.j.d("#") == false) goto L50;
        boolean r12 = this.j.e("X");
        a r0 = this.j;
        if (r12 == false) goto L17;
        String r1 = r0.n();
    L19:
        if (r1.length() != 0) goto L24;
        c("numeric reference with no numerals");
    L21:
        this.j.h();
        return null;
    L24:
        if (this.j.d(";") == true) goto L26;
        c("missing semicolon");
    L26:
        if (r12 == false) goto L28;
        int r13 = 16;
    L81:
        int r14 = Integer.valueOf(r1, r13).intValue();     // Catch: NumberFormatException -> L32
    L33:
        if (r14 != (-1)) goto L35;
    L48:
        c("character outside of valid range");
        r11[0] = 65533;
        return r11;
    L35:
        if (r14 < 55296) goto L39;
        if (r14 <= 57343) goto L48;
    L39:
        if (r14 > 1114111) goto L48;
        if (r14 < 128) goto L46;
        int[] r2 = f16592a;
        if (r14 >= (r2.length + 128)) goto L46;
        c("character is not a valid unicode code point");
        r14 = r2[r14 - 128];
    L46:
        r11[0] = r14;
        return r11;
    L32:
        r14 = -1;
        goto L33
    L28:
        r13 = 10;
        goto L81
    L17:
        r1 = r0.o();
        goto L19
    L50:
        String r3 = this.j.m();
        boolean r5 = this.j.c(';');
        if (io.noties.markwon.html.jsoup.nodes.c.a(r3) == false) goto L54;
        if (r5 == false) goto L54;
        boolean r6 = true;
    L55:
        if (r6 == true) goto L60;
        this.j.h();
        if (r5 == false) goto L59;
        c(String.format("invalid named referenece '%s'", new Object[]{r3}));
    L59:
        return null;
    L60:
        if (r10 == false) goto L69;
        if (this.j.p() == true) goto L21;
        if (this.j.q() == true) goto L21;
        if (this.j.c(new char[]{'=', '-', '_'}) == true) goto L21;
    L69:
        if (this.j.d(";") == true) goto L71;
        c("missing semicolon");
    L71:
        int r15 = io.noties.markwon.html.jsoup.nodes.c.a(r3, this.s);
        if (r15 != 1) goto L76;
        r11[0] = this.s[0];
        return r11;
    L76:
        if (r15 == 2) goto L78;
        io.noties.markwon.html.jsoup.a.b.b("Unexpected characters returned for " + r3);
        return this.s;
    L78:
        return this.s;
    L54:
        r6 = false;
        goto L55
    }

    public Token.h b() {
        return this.c;
    }

    void b(TokeniserState r2) {
        this.j.f();
        this.l = r2;
    }

    void b(String r3) {
        if (this.k.canAddError() == false) goto L6;
        this.k.add(new b(this.j.a(), r3));
        return;
    }

    void c() {
        this.c.d();
        a(this.c);
    }

    void c(TokeniserState r6) {
        if (this.k.canAddError() == false) goto L6;
        this.k.add(new b(this.j.a(), "Unexpected character '%s' in input state [%s]", new Object[]{Character.valueOf(this.j.c()), r6}));
        return;
    }

    void d() {
        this.h.a();
    }

    void d(TokeniserState r5) {
        if (this.k.canAddError() == false) goto L6;
        this.k.add(new b(this.j.a(), "Unexpectedly reached end of file (EOF) in input state [%s]", new Object[]{r5}));
        return;
    }

    void e() {
        a(this.h);
    }

    void f() {
        this.g.a();
    }

    void g() {
        a(this.g);
    }

    void h() {
        Token.a(this.f16593b);
    }

    boolean i() {
        if (this.q != null) goto L5;
    L7:
        return false;
    L5:
        if (this.c.e().equalsIgnoreCase(this.q) == false) goto L7;
        return true;
    }

    String j() {
        return this.q;
    }
}
