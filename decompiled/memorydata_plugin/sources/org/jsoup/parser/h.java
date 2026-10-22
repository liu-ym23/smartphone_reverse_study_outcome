package org.jsoup.parser;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import kotlin.text.Typography;
import org.jsoup.nodes.Entities;

/* JADX INFO: loaded from: classes7.dex */
final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final int[] f18296a = null;
    static final /* synthetic */ boolean i = true;
    private static final char[] j = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    StringBuilder f18297b;
    Token.g c;
    Token.f d;
    Token.h e;
    Token.b f;
    Token.d g;
    Token.c h;
    private final a k;
    private final ParseErrorList l;
    private TokeniserState m;
    private Token n;
    private boolean o;
    private String p;
    private final StringBuilder q;
    private String r;
    private String s;
    private int t;
    private int u;
    private final int[] v;
    private final int[] w;

    /* JADX INFO: renamed from: org.jsoup.parser.h$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f18298a = null;

        static {
            int[] r0 = new int[TokeniserState.values().length];
            f18298a = r0;
            r0[TokeniserState.TagOpen.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f18298a[TokeniserState.Data.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    static {
        char[] r0 = {'\t', '\n', '\r', '\f', ' ', Typography.less, Typography.amp};
        j = r0;
        f18296a = new int[]{8364, 129, 8218, 402, 8222, 8230, 8224, 8225, 710, 8240, 352, 8249, 338, 141, 381, 143, 144, 8216, 8217, 8220, 8221, 8226, 8211, 8212, 732, 8482, 353, 8250, 339, 157, 382, 376};
        Arrays.sort(r0);
    }

    h(a r3, ParseErrorList r4) {
        this.m = TokeniserState.Data;
        this.n = null;
        this.o = false;
        this.p = null;
        this.q = new StringBuilder(1024);
        this.f18297b = new StringBuilder(1024);
        this.c = new Token.g();
        this.d = new Token.f();
        this.e = this.c;
        this.f = new Token.b();
        this.g = new Token.d();
        this.h = new Token.c();
        this.u = -1;
        this.v = new int[1];
        this.w = new int[2];
        this.k = r3;
        this.l = r4;
    }

    private void b(String r5, Object... r6) {
        if (this.l.canAddError() == false) goto L6;
        this.l.add(new c(this.k, String.format("Invalid character reference: " + r5, r6)));
        return;
    }

    Token.h a(boolean r1) {
        if (r1 == false) goto L4;
        Token.h r2 = this.c.q();
    L5:
        this.e = r2;
        return r2;
    L4:
        r2 = this.d.q();
        goto L5
    }

    Token a() {
    L3:
        if (this.o == true) goto L5;
        this.m.read(this, this.k);
        goto L3
    L5:
        StringBuilder r0 = this.q;
        if (r0.length() == 0) goto L10;
        String r1 = r0.toString();
        r0.delete(0, r0.length());
        Token.b r2 = this.f.a(r1);
    L8:
        this.p = null;
        return r2;
    L10:
        String r3 = this.p;
        if (r3 == null) goto L13;
        r2 = this.f.a(r3);
        goto L8
    L13:
        this.o = false;
        if (i == true) goto L21;
        if (this.n != null) goto L21;
        throw new AssertionError();
    L21:
        return this.n;
    }

    void a(char r3) {
        if (this.p != null) goto L6;
        this.p = String.valueOf(r3);
    L9:
        this.f.a(this.u);
        this.f.b(this.k.b());
        return;
    L6:
        if (this.q.length() != 0) goto L8;
        this.q.append(this.p);
    L8:
        this.q.append(r3);
        goto L9
    }

    void a(String r3) {
        if (this.p != null) goto L6;
        this.p = r3;
    L9:
        this.f.a(this.u);
        this.f.b(this.k.b());
        return;
    L6:
        if (this.q.length() != 0) goto L8;
        this.q.append(this.p);
    L8:
        this.q.append(r3);
        goto L9
    }

    void a(String r3, Object... r4) {
        if (this.l.canAddError() == false) goto L6;
        this.l.add(new c(this.k, r3, r4));
        return;
    }

    void a(StringBuilder r3) {
        if (this.p != null) goto L6;
        this.p = r3.toString();
    L9:
        this.f.a(this.u);
        this.f.b(this.k.b());
        return;
    L6:
        if (this.q.length() != 0) goto L8;
        this.q.append(this.p);
    L8:
        this.q.append(r3);
        goto L9
    }

    void a(Token r5) {
        org.jsoup.helper.b.b(this.o);
        this.n = r5;
        this.o = true;
        r5.a(this.t);
        r5.b(this.k.b());
        this.u = -1;
        if (r5.f18276a != Token.TokenType.StartTag) goto L6;
        this.r = ((Token.g) ZeusTransformUtils.preCheckCast(r5, Token.g.class, "com.obric.memorydata.plugin")).f18281b;
        this.s = null;
        return;
    L6:
        if (r5.f18276a != Token.TokenType.EndTag) goto L12;
        Token.f r6 = (Token.f) ZeusTransformUtils.preCheckCast(r5, Token.f.class, "com.obric.memorydata.plugin");
        if (r6.s() == false) goto L13;
        a("Attributes incorrectly present on end tag [/%s]", new Object[]{r6.v()});
        return;
    L13:
        return;
    }

    void a(TokeniserState r3) {
        int r0 = AnonymousClass1.f18298a[r3.ordinal()];
        if (r0 != 1) goto L5;
        this.t = this.k.b();
    L11:
        this.m = r3;
        return;
    L5:
        if (r0 != 2) goto L11;
        if (this.u != (-1)) goto L11;
        this.u = this.k.b();
        goto L11
    }

    void a(int[] r4) {
        a(new String(r4, 0, r4.length));
    }

    int[] a(Character r8, boolean r9) {
        if (this.k.g() == false) goto L5;
        return null;
    L5:
        if (r8 == null) goto L10;
        if (r8.charValue() != this.k.h()) goto L10;
        return null;
    L10:
        if (this.k.d(j) == false) goto L12;
        return null;
    L12:
        int[] r10 = this.v;
        this.k.l();
        if (this.k.d("#") == false) goto L49;
        boolean r11 = this.k.e("X");
        a r0 = this.k;
        if (r11 == false) goto L17;
        String r1 = r0.u();
    L19:
        if (r1.length() != 0) goto L23;
        b("numeric reference with no numerals", new Object[0]);
    L21:
        this.k.n();
        return null;
    L23:
        this.k.m();
        if (this.k.d(";") == true) goto L26;
        b("missing semicolon on [&#%s]", new Object[]{r1});
    L26:
        if (r11 == false) goto L28;
        int r12 = 16;
    L83:
        int r13 = Integer.valueOf(r1, r12).intValue();     // Catch: NumberFormatException -> L32
    L33:
        if (r13 != (-1)) goto L35;
    L47:
        b("character [%s] outside of valid range", new Object[]{Integer.valueOf(r13)});
        r10[0] = 65533;
    L48:
        return r10;
    L35:
        if (r13 < 55296) goto L39;
        if (r13 <= 57343) goto L47;
    L39:
        if (r13 > 1114111) goto L47;
        if (r13 < 128) goto L46;
        int[] r2 = f18296a;
        if (r13 >= (r2.length + 128)) goto L46;
        b("character [%s] is not a valid unicode code point", new Object[]{Integer.valueOf(r13)});
        r13 = r2[r13 - 128];
    L46:
        r10[0] = r13;
    L32:
        r13 = -1;
        goto L33
    L28:
        r12 = 10;
        goto L83
    L17:
        r1 = r0.v();
        goto L19
    L49:
        String r3 = this.k.t();
        boolean r5 = this.k.c(';');
        if (Entities.b(r3) == false) goto L52;
    L56:
        boolean r6 = true;
    L57:
        if (r6 == true) goto L62;
        this.k.n();
        if (r5 == false) goto L61;
        b("invalid named reference [%s]", new Object[]{r3});
    L61:
        return null;
    L62:
        if (r9 == true) goto L64;
    L70:
        this.k.m();
        if (this.k.d(";") == true) goto L73;
        b("missing semicolon on [&%s]", new Object[]{r3});
    L73:
        int r14 = Entities.a(r3, this.w);
        if (r14 != 1) goto L78;
        r10[0] = this.w[0];
        return r10;
    L78:
        if (r14 == 2) goto L80;
        org.jsoup.helper.b.b("Unexpected characters returned for " + r3);
        return this.w;
    L80:
        return this.w;
    L64:
        if (this.k.w() == true) goto L21;
        if (this.k.y() == true) goto L21;
        if (this.k.c(new char[]{'=', '-', '_'}) == false) goto L70;
    L52:
        if (Entities.a(r3) == false) goto L55;
        if (r5 == true) goto L56;
    L55:
        r6 = false;
        goto L57
    }

    void b() {
        this.e.t();
        a(this.e);
    }

    void b(TokeniserState r1) {
        a(r1);
        this.k.k();
    }

    void c() {
        this.h.b();
    }

    void c(TokeniserState r6) {
        if (this.l.canAddError() == false) goto L6;
        ParseErrorList r0 = this.l;
        a r5 = this.k;
        r0.add(new c(r5, "Unexpected character '%s' in input state [%s]", new Object[]{Character.valueOf(r5.h()), r6}));
        return;
    }

    void d() {
        a(this.h);
    }

    void d(TokeniserState r5) {
        if (this.l.canAddError() == false) goto L6;
        this.l.add(new c(this.k, "Unexpectedly reached end of file (EOF) in input state [%s]", new Object[]{r5}));
        return;
    }

    void e() {
        this.h.b();
        this.h.f18279b = true;
    }

    void f() {
        this.g.b();
    }

    void g() {
        a(this.g);
    }

    void h() {
        Token.a(this.f18297b);
    }

    boolean i() {
        if (this.r != null) goto L5;
    L7:
        return false;
    L5:
        if (this.e.u().equalsIgnoreCase(this.r) == false) goto L7;
        return true;
    }

    String j() {
        return this.r;
    }

    String k() {
        if (this.s != null) goto L6;
        this.s = "</" + this.r;
    L6:
        return this.s;
    }
}
