package org.jsoup.select;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.text.Typography;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes7.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f18328a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final char[] f18329b = null;
    private static final String[] c = null;
    private static final Pattern g = null;
    private static final Pattern h = null;
    private final org.jsoup.parser.g d;
    private final String e;
    private final List<c> f;

    static {
        f18329b = new char[]{',', Typography.greater, '+', '~', ' '};
        c = new String[]{"=", "!=", "^=", "$=", "*=", "~="};
        g = Pattern.compile("(([+-])?(\\d+)?)n(\\s*([+-])?\\s*\\d+)?", 2);
        h = Pattern.compile("([+-])?(\\d+)");
    }

    private f(String r2) {
        this.f = new ArrayList();
        org.jsoup.helper.b.a(r2);
        String r3 = r2.trim();
        this.e = r3;
        this.d = new org.jsoup.parser.g(r3);
    }

    public static c a(String r1) {
        return new f(r1).a();
    L4:
        e = move-exception;
        throw new Selector.SelectorParseException(e.getMessage());
    }

    private void a(char r12) {
        this.d.e();
        c r0 = a(b());
        if (this.f.size() != 1) goto L14;
        c r1 = (c) ZeusTransformUtils.preCheckCast(this.f.get(0), c.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, b.C0900b.class) == false) goto L15;
        if (r12 == ',') goto L15;
        c r6 = ((b.C0900b) ZeusTransformUtils.preCheckCast(r1, b.C0900b.class, "com.obric.memorydata.plugin")).a();
        if (f18328a == true) goto L13;
        if (r6 != null) goto L13;
        throw new AssertionError();
    L13:
        boolean r7 = true;
        c r8 = r1;
        r1 = r6;
    L16:
        this.f.clear();
        if (r12 != ' ') goto L19;
        c r13 = new b.a(new c[]{new g.e(r1), r0});
    L36:
        if (r7 == false) goto L38;
        ((b.C0900b) ZeusTransformUtils.preCheckCast(r8, b.C0900b.class, "com.obric.memorydata.plugin")).a(r13);
        c r9 = r8;
    L39:
        this.f.add(r9);
        return;
    L38:
        r9 = r13;
        goto L39
    L19:
        if (r12 != '>') goto L21;
        r13 = new b.a(new c[]{new g.b(r1), r0});
        goto L36
    L21:
        if (r12 != '~') goto L23;
        r13 = new b.a(new c[]{new g.f(r1), r0});
        goto L36
    L23:
        if (r12 == '+') goto L32;
        if (r12 != ',') goto L31;
        if (ZeusTransformUtils.instanceOf(r1, b.C0900b.class) == false) goto L28;
        b.C0900b r14 = (b.C0900b) ZeusTransformUtils.preCheckCast(r1, b.C0900b.class, "com.obric.memorydata.plugin");
    L29:
        r14.b(r0);
        r13 = r14;
        goto L36
    L28:
        b.C0900b r15 = new b.C0900b();
        r15.b(r1);
        r14 = r15;
        goto L29
    L31:
        throw new Selector.SelectorParseException("Unknown combinator '%s'", new Object[]{Character.valueOf(r12)});
    L32:
        r13 = new b.a(new c[]{new g.c(r1), r0});
    L15:
        r8 = r1;
        r7 = false;
        goto L16
    L14:
        r1 = new b.a(this.f);
        goto L15
    }

    private void a(boolean r5) {
        if (r5 == false) goto L4;
        String r0 = ":containsOwn";
    L5:
        this.d.c(r0);
        String r1 = org.jsoup.parser.g.f(this.d.a('(', ')'));
        org.jsoup.helper.b.b(r1, r0 + "(text) query must not be empty");
        List<c> r4 = this.f;
        if (r5 == false) goto L8;
        c r6 = new c.m(r1);
    L9:
        r4.add(r6);
        return;
    L8:
        r6 = new c.n(r1);
        goto L9
    L4:
        r0 = ":contains";
        goto L5
    }

    private void a(boolean r9, boolean r10) {
        String r0 = org.jsoup.a.a.b(this.d.e(")"));
        Matcher r1 = g.matcher(r0);
        Matcher r2 = h.matcher(r0);
        int r4 = 2;
        int r5 = 0;
        if ("odd".equals(r0) == false) goto L6;
        r5 = 1;
    L21:
        List<c> r8 = this.f;
        if (r10 == false) goto L26;
        if (r9 == false) goto L25;
        c r11 = new c.ad(r4, r5);
    L29:
        r8.add(r11);
        return;
    L25:
        r11 = new c.ae(r4, r5);
        goto L29
    L26:
        if (r9 == false) goto L28;
        r11 = new c.ac(r4, r5);
        goto L29
    L28:
        r11 = new c.ab(r4, r5);
        goto L29
    L6:
        if ("even".equals(r0) == true) goto L21;
        if (r1.matches() == false) goto L19;
        if (r1.group(3) == null) goto L13;
        int r3 = Integer.parseInt(r1.group(1).replaceFirst("^\\+", ""));
    L15:
        if (r1.group(4) == null) goto L17;
        r5 = Integer.parseInt(r1.group(4).replaceFirst("^\\+", ""));
    L17:
        r4 = r3;
        goto L21
    L13:
        r3 = 1;
        goto L15
    L19:
        if (r2.matches() == false) goto L32;
        r4 = 0;
        r5 = Integer.parseInt(r2.group().replaceFirst("^\\+", ""));
        goto L21
    L32:
        throw new Selector.SelectorParseException("Could not parse nth-index '%s': unexpected format", new Object[]{r0});
    }

    private String b() {
        StringBuilder r0 = org.jsoup.a.b.a();
    L4:
        if (this.d.a() == true) goto L20;
        if (this.d.a("(") == true) goto L7;
        if (this.d.a("[") == true) goto L11;
        if (this.d.a(f18329b) == true) goto L15;
        r0.append(this.d.d());
        goto L4
    L15:
        if (r0.length() > 0) goto L20;
        this.d.d();
        goto L4
    L11:
        StringBuilder r1 = r0.append("[").append(this.d.a('[', ']'));
        String r2 = "]";
    L8:
        r1.append(r2);
        goto L4
    L7:
        r1 = r0.append("(").append(this.d.a('(', ')'));
        r2 = ")";
    L20:
        return org.jsoup.a.b.a(r0);
    }

    private void b(boolean r5) {
        if (r5 == false) goto L4;
        String r0 = ":containsWholeOwnText";
    L5:
        this.d.c(r0);
        String r1 = org.jsoup.parser.g.f(this.d.a('(', ')'));
        org.jsoup.helper.b.b(r1, r0 + "(text) query must not be empty");
        List<c> r4 = this.f;
        if (r5 == false) goto L8;
        c r6 = new c.o(r1);
    L9:
        r4.add(r6);
        return;
    L8:
        r6 = new c.p(r1);
        goto L9
    L4:
        r0 = ":containsWholeText";
        goto L5
    }

    private void c() {
        if (this.d.b("#") == false) goto L6;
        d();
        return;
    L6:
        if (this.d.b(".") == false) goto L9;
        e();
        return;
    L9:
        if (this.d.c() == false) goto L11;
    L103:
        f();
        return;
    L11:
        if (this.d.a("*|") == true) goto L103;
        if (this.d.a("[") == false) goto L17;
        g();
        return;
    L17:
        if (this.d.b("*") == false) goto L20;
        h();
        return;
    L20:
        if (this.d.b(":lt(") == false) goto L23;
        i();
        return;
    L23:
        if (this.d.b(":gt(") == false) goto L26;
        j();
        return;
    L26:
        if (this.d.b(":eq(") == false) goto L29;
        k();
        return;
    L29:
        if (this.d.a(":has(") == false) goto L32;
        m();
        return;
    L32:
        if (this.d.a(":contains(") == false) goto L35;
        a(false);
        return;
    L35:
        if (this.d.a(":containsOwn(") == false) goto L38;
        a(true);
        return;
    L38:
        if (this.d.a(":containsWholeText(") == false) goto L41;
        b(false);
        return;
    L41:
        if (this.d.a(":containsWholeOwnText(") == false) goto L44;
        b(true);
        return;
    L44:
        if (this.d.a(":containsData(") == false) goto L47;
        n();
        return;
    L47:
        if (this.d.a(":matches(") == false) goto L50;
        c(false);
        return;
    L50:
        if (this.d.a(":matchesOwn(") == false) goto L53;
        c(true);
        return;
    L53:
        if (this.d.a(":matchesWholeText(") == false) goto L56;
        d(false);
        return;
    L56:
        if (this.d.a(":matchesWholeOwnText(") == false) goto L59;
        d(true);
        return;
    L59:
        if (this.d.a(":not(") == false) goto L62;
        o();
        return;
    L62:
        if (this.d.b(":nth-child(") == false) goto L65;
        a(false, false);
        return;
    L65:
        if (this.d.b(":nth-last-child(") == false) goto L68;
        a(true, false);
        return;
    L68:
        if (this.d.b(":nth-of-type(") == false) goto L71;
        a(false, true);
        return;
    L71:
        if (this.d.b(":nth-last-of-type(") == false) goto L74;
        a(true, true);
        return;
    L74:
        if (this.d.b(":first-child") == false) goto L78;
        List<c> r5 = this.f;
        c r0 = new c.x();
    L76:
        r5.add(r0);
        return;
    L78:
        if (this.d.b(":last-child") == false) goto L81;
        r5 = this.f;
        r0 = new c.z();
        goto L76
    L81:
        if (this.d.b(":first-of-type") == false) goto L84;
        r5 = this.f;
        r0 = new c.y();
        goto L76
    L84:
        if (this.d.b(":last-of-type") == false) goto L87;
        r5 = this.f;
        r0 = new c.aa();
        goto L76
    L87:
        if (this.d.b(":only-child") == false) goto L90;
        r5 = this.f;
        r0 = new c.af();
        goto L76
    L90:
        if (this.d.b(":only-of-type") == false) goto L93;
        r5 = this.f;
        r0 = new c.ag();
        goto L76
    L93:
        if (this.d.b(":empty") == false) goto L96;
        r5 = this.f;
        r0 = new c.w();
        goto L76
    L96:
        if (this.d.b(":root") == false) goto L99;
        r5 = this.f;
        r0 = new c.ah();
        goto L76
    L99:
        if (this.d.b(":matchText") == false) goto L102;
        r5 = this.f;
        r0 = new c.ai();
        goto L76
    L102:
        throw new Selector.SelectorParseException("Could not parse query '%s': unexpected token at '%s'", new Object[]{this.e, this.d.h()});
    }

    private void c(boolean r5) {
        if (r5 == false) goto L4;
        String r0 = ":matchesOwn";
    L5:
        this.d.c(r0);
        String r1 = this.d.a('(', ')');
        org.jsoup.helper.b.b(r1, r0 + "(regex) query must not be empty");
        List<c> r4 = this.f;
        if (r5 == false) goto L8;
        c r6 = new c.ak(Pattern.compile(r1));
    L9:
        r4.add(r6);
        return;
    L8:
        r6 = new c.aj(Pattern.compile(r1));
        goto L9
    L4:
        r0 = ":matches";
        goto L5
    }

    private void d() {
        String r0 = this.d.g();
        org.jsoup.helper.b.a(r0);
        this.f.add(new c.r(r0));
    }

    private void d(boolean r5) {
        if (r5 == false) goto L4;
        String r0 = ":matchesWholeOwnText";
    L5:
        this.d.c(r0);
        String r1 = this.d.a('(', ')');
        org.jsoup.helper.b.b(r1, r0 + "(regex) query must not be empty");
        List<c> r4 = this.f;
        if (r5 == false) goto L8;
        c r6 = new c.al(Pattern.compile(r1));
    L9:
        r4.add(r6);
        return;
    L8:
        r6 = new c.am(Pattern.compile(r1));
        goto L9
    L4:
        r0 = ":matchesWholeText";
        goto L5
    }

    private void e() {
        String r0 = this.d.g();
        org.jsoup.helper.b.a(r0);
        this.f.add(new c.k(r0.trim()));
    }

    private void f() {
        String r0 = org.jsoup.a.a.b(this.d.f());
        org.jsoup.helper.b.a(r0);
        if (r0.startsWith("*|") == false) goto L6;
        String r4 = r0.substring(2);
        this.f.add(new b.C0900b(new c[]{new c.an(r4), new c.ao(r0.replace("*|", ParameterizedMessage.ERROR_MSG_SEPARATOR))}));
        return;
    L6:
        if (r0.contains("|") == false) goto L8;
        r0 = r0.replace("|", ParameterizedMessage.ERROR_MSG_SEPARATOR);
    L8:
        this.f.add(new c.an(r0));
    }

    private void g() {
        org.jsoup.parser.g r0 = new org.jsoup.parser.g(this.d.a('[', ']'));
        String r1 = r0.b(c);
        org.jsoup.helper.b.a(r1);
        r0.e();
        if (r0.a() == false) goto L10;
        boolean r2 = r1.startsWith("^");
        List<c> r5 = this.f;
        if (r2 == false) goto L7;
        c r3 = new c.d(r1.substring(1));
    L8:
        r5.add(r3);
        return;
    L7:
        r3 = new c.b(r1);
        goto L8
    L10:
        if (r0.b("=") == false) goto L14;
        List<c> r6 = this.f;
        c r4 = new c.e(r1, r0.h());
    L12:
        r6.add(r4);
        return;
    L14:
        if (r0.b("!=") == false) goto L17;
        r6 = this.f;
        r4 = new c.i(r1, r0.h());
        goto L12
    L17:
        if (r0.b("^=") == false) goto L20;
        r6 = this.f;
        r4 = new c.j(r1, r0.h());
        goto L12
    L20:
        if (r0.b("$=") == false) goto L23;
        r6 = this.f;
        r4 = new c.g(r1, r0.h());
        goto L12
    L23:
        if (r0.b("*=") == false) goto L26;
        r6 = this.f;
        r4 = new c.f(r1, r0.h());
        goto L12
    L26:
        if (r0.b("~=") == false) goto L30;
        r6 = this.f;
        r4 = new c.h(r1, Pattern.compile(r0.h()));
        goto L12
    L30:
        throw new Selector.SelectorParseException("Could not parse attribute query '%s': unexpected token at '%s'", new Object[]{this.e, r0.h()});
    }

    private void h() {
        this.f.add(new c.a());
    }

    private void i() {
        this.f.add(new c.v(l()));
    }

    private void j() {
        this.f.add(new c.u(l()));
    }

    private void k() {
        this.f.add(new c.s(l()));
    }

    private int l() {
        String r2 = this.d.e(")").trim();
        org.jsoup.helper.b.a(org.jsoup.a.b.b(r2), "Index must be numeric");
        return Integer.parseInt(r2);
    }

    private void m() {
        this.d.c(":has");
        String r0 = this.d.a('(', ')');
        org.jsoup.helper.b.b(r0, ":has(selector) sub-select must not be empty");
        this.f.add(new g.a(a(r0)));
    }

    private void n() {
        this.d.c(":containsData");
        String r0 = org.jsoup.parser.g.f(this.d.a('(', ')'));
        org.jsoup.helper.b.b(r0, ":containsData(text) query must not be empty");
        this.f.add(new c.l(r0));
    }

    private void o() {
        this.d.c(":not");
        String r0 = this.d.a('(', ')');
        org.jsoup.helper.b.b(r0, ":not(selector) subselect must not be empty");
        this.f.add(new g.d(a(r0)));
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x003c -> B:5:0x0019). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0041 -> B:6:0x001f). Please report as a decompilation issue!!! */
    c a() {
        this.d.e();
        if (this.d.a(f18329b) == false) goto L7;
        this.f.add(new g.C0902g());
    L5:
        char r0 = this.d.d();
    L6:
        a(r0);
    L9:
        if (this.d.a() == true) goto L16;
        boolean r1 = this.d.e();
        if (this.d.a(f18329b) == true) goto L5;
        if (r1 == true) goto L14;
    L7:
        c();
        goto L9
    L14:
        r0 = ' ';
        goto L6
    L16:
        if (this.f.size() != 1) goto L20;
        return (c) ZeusTransformUtils.preCheckCast(this.f.get(0), c.class, "com.obric.memorydata.plugin");
    L20:
        return new b.a(this.f);
    L21:
        c();
        goto L9
    }

    public String toString() {
        return this.e;
    }
}
