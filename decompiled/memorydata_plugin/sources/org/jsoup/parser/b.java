package org.jsoup.parser;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.InputDeviceCompat;
import com.obric.aikernel.sdk.autotest.AutoTestConstant;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.j;
import org.jsoup.nodes.n;

/* JADX INFO: loaded from: classes7.dex */
public class b extends i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final String[] f18284a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final String[] f18285b = null;
    static final String[] c = null;
    static final String[] d = null;
    static final String[] e = null;
    static final String[] f = null;
    static final String[] g = null;
    static final String[] h = null;
    static final /* synthetic */ boolean i = true;
    private List<String> A;
    private Token.f B;
    private boolean C;
    private boolean D;
    private boolean E;
    private String[] F;
    private HtmlTreeBuilderState s;
    private HtmlTreeBuilderState t;
    private boolean u;
    private Element v;
    private org.jsoup.nodes.h w;
    private Element x;
    private ArrayList<Element> y;
    private ArrayList<HtmlTreeBuilderState> z;

    static {
        f18284a = new String[]{"applet", "caption", "html", "marquee", "object", "table", "td", "th"};
        f18285b = new String[]{"ol", "ul"};
        c = new String[]{"button"};
        d = new String[]{"html", "table"};
        e = new String[]{"optgroup", "option"};
        f = new String[]{"dd", "dt", "li", "optgroup", "option", "p", com.tom_roush.pdfbox.pdmodel.a.d.f.f16171b, "rp", "rt", "rtc"};
        g = new String[]{"caption", "colgroup", "dd", "dt", "li", "optgroup", "option", "p", com.tom_roush.pdfbox.pdmodel.a.d.f.f16171b, "rp", "rt", "rtc", "tbody", "td", "tfoot", "th", "thead", "tr"};
        h = new String[]{MemoryKeyInfoEntity.KEY_ADDRESS, "applet", "area", "article", "aside", "base", "basefont", "bgsound", "blockquote", "body", "br", "button", "caption", "center", "col", "colgroup", "command", "dd", "details", "dir", "div", "dl", "dt", "embed", "fieldset", "figcaption", "figure", "footer", "form", TypedValues.AttributesType.S_FRAME, "frameset", "h1", "h2", "h3", "h4", "h5", "h6", "head", "header", "hgroup", "hr", "html", "iframe", "img", "input", "isindex", "li", "link", "listing", "marquee", "menu", "meta", "nav", "noembed", "noframes", "noscript", "object", "ol", "p", AutoTestConstant.PARAM, "plaintext", "pre", "script", "section", "select", "style", "summary", "table", "tbody", "td", "textarea", "tfoot", "th", "thead", "title", "tr", "ul", "wbr", "xmp"};
    }

    public b() {
        this.F = new String[]{null};
    }

    private void a(ArrayList<Element> r1, Element r2, Element r3) {
        int r0 = r1.lastIndexOf(r2);
        if (r0 == (-1)) goto L5;
        boolean r4 = true;
    L6:
        org.jsoup.helper.b.a(r4);
        r1.set(r0, r3);
        return;
    L5:
        r4 = false;
        goto L6
    }

    private boolean a(String r3, String[] r4, String[] r5) {
        String[] r0 = this.F;
        r0[0] = r3;
        return a(r0, r4, r5);
    }

    private static boolean a(ArrayList<Element> r7, Element r8) {
        int r0 = r7.size() - 1;
        if (r0 < 256) goto L5;
        int r3 = r0 + InputDeviceCompat.SOURCE_ANY;
    L6:
        if (r0 < r3) goto L11;
        if (((Element) ZeusTransformUtils.preCheckCast(r7.get(r0), Element.class, "com.obric.memorydata.plugin")) == r8) goto L9;
        r0 = r0 - 1;
        goto L6
    L9:
        return true;
    L11:
        return false;
    L5:
        r3 = 0;
        goto L6
    }

    private boolean a(String[] r8, String[] r9, String[] r10) {
        int r0 = this.n.size() - 1;
        if (r0 <= 100) goto L5;
        int r2 = r0 - 100;
    L6:
        if (r0 < r2) goto L18;
        String r4 = ((Element) ZeusTransformUtils.preCheckCast(this.n.get(r0), Element.class, "com.obric.memorydata.plugin")).r();
        if (org.jsoup.a.b.b(r4, r8) == true) goto L9;
        if (org.jsoup.a.b.b(r4, r9) == true) goto L12;
        if (r10 == null) goto L17;
        if (org.jsoup.a.b.b(r4, r10) == false) goto L17;
        return false;
    L17:
        r0 = r0 - 1;
        goto L6
    L12:
        return false;
    L9:
        return true;
    L18:
        return false;
    L5:
        r2 = 0;
        goto L6
    }

    private void c(j r4, Token r5) {
        if (this.n.isEmpty() == false) goto L6;
        this.m.a(r4);
    L12:
        if (ZeusTransformUtils.instanceOf(r4, Element.class) == true) goto L14;
    L18:
        a(r4, r5);
        return;
    L14:
        if (((Element) ZeusTransformUtils.preCheckCast(r4, Element.class, "com.obric.memorydata.plugin")).s().j() == false) goto L18;
        org.jsoup.nodes.h r0 = this.w;
        if (r0 == null) goto L18;
        r0.b((Element) ZeusTransformUtils.preCheckCast(r4, Element.class, "com.obric.memorydata.plugin"));
        goto L18
    L6:
        if (q() == true) goto L8;
    L10:
        E().a(r4);
        goto L12
    L8:
        if (org.jsoup.a.b.b(E().r(), HtmlTreeBuilderState.a.A) == false) goto L10;
        a(r4);
        goto L12
    }

    private void c(String... r5) {
        int r0 = this.n.size() - 1;
    L3:
        if (r0 < 0) goto L10;
        Element r1 = (Element) ZeusTransformUtils.preCheckCast(this.n.get(r0), Element.class, "com.obric.memorydata.plugin");
        if (org.jsoup.a.b.a(r1.r(), r5) == true) goto L14;
        if (r1.r().equals("html") == true) goto L15;
        this.n.remove(r0);
        r0 = r0 - 1;
        goto L3
    L15:
        return;
    L14:
        return;
    }

    private boolean d(Element r2, Element r3) {
        if (r2.r().equals(r3.r()) == true) goto L5;
    L7:
        return false;
    L5:
        if (r2.p().equals(r3.p()) == false) goto L7;
        return true;
    }

    private void insert(Element r1, Token r2) {
        c(r1, r2);
        this.n.add(r1);
    }

    HtmlTreeBuilderState A() {
        if (this.z.size() <= 0) goto L6;
        ArrayList<HtmlTreeBuilderState> r2 = this.z;
        return (HtmlTreeBuilderState) ZeusTransformUtils.preCheckCast(r2.remove(r2.size() - 1), HtmlTreeBuilderState.class, "com.obric.memorydata.plugin");
    L6:
        return null;
    }

    int B() {
        return this.z.size();
    }

    HtmlTreeBuilderState C() {
        if (this.z.size() <= 0) goto L5;
        ArrayList<HtmlTreeBuilderState> r2 = this.z;
        return (HtmlTreeBuilderState) ZeusTransformUtils.preCheckCast(r2.get(r2.size() - 1), HtmlTreeBuilderState.class, "com.obric.memorydata.plugin");
    L5:
        return null;
    }

    @Override // org.jsoup.parser.i
    List<j> a(String r3, Element r4, String r5, e r6) {
        this.s = HtmlTreeBuilderState.Initial;
        a(new StringReader(r3), r5, r6);
        this.x = r4;
        byte r7 = 1;
        this.E = true;
        if (r4 != null) goto L5;
        Element r8 = null;
    L69:
        D();
        if (r4 == null) goto L77;
        List<j> r2 = r8.ac();
        if (r2.isEmpty() == true) goto L75;
        r8.a(-1, r2);
    L75:
        return r8.W();
    L77:
        return this.m.W();
    L5:
        if (r4.Z() == null) goto L7;
        this.m.a(r4.Z().k());
    L7:
        String r0 = r4.r();
        r0.hashCode();
        switch(r0.hashCode()) {
            case -1321546630: goto L50;
            case -1191214428: goto L47;
            case -1003243718: goto L43;
            case -907685685: goto L39;
            case 118807: goto L35;
            case 109780401: goto L31;
            case 110371416: goto L27;
            case 1192721831: goto L23;
            case 1551550924: goto L19;
            case 1973234167: goto L15;
            case 2115613112: goto L11;
            default: goto L9;
        };
    L9:
        r7 = -1;
    L53:
        switch(r7) {
            case 0: goto L61;
            case 1: goto L60;
            case 2: goto L58;
            case 3: goto L57;
            case 4: goto L60;
            case 5: goto L60;
            case 6: goto L58;
            case 7: goto L60;
            case 8: goto L56;
            case 9: goto L55;
            case 10: goto L60;
            default: goto L56;
        };
    L55:
        h r9 = this.l;
        TokeniserState r1 = TokeniserState.PLAINTEXT;
    L59:
        r9.a(r1);
    L62:
        r8 = new Element(a(r0, this.q), r5);
        this.m.a(r8);
        this.n.add(r8);
        n();
        Element r10 = r4;
    L63:
        if (r10 == null) goto L69;
        if (ZeusTransformUtils.instanceOf(r10, org.jsoup.nodes.h.class) == true) goto L66;
        r10 = r10.v();
        goto L63
    L66:
        this.w = (org.jsoup.nodes.h) ZeusTransformUtils.preCheckCast(r10, org.jsoup.nodes.h.class, "com.obric.memorydata.plugin");
        goto L69
    L56:
        r9 = this.l;
        r1 = TokeniserState.Data;
        goto L59
    L57:
        r9 = this.l;
        r1 = TokeniserState.ScriptData;
        goto L59
    L58:
        r9 = this.l;
        r1 = TokeniserState.Rcdata;
        goto L59
    L60:
        r9 = this.l;
        r1 = TokeniserState.Rawtext;
        goto L59
    L61:
        this.l.a(TokeniserState.Data);
        c(HtmlTreeBuilderState.InTemplate);
        goto L62
    L11:
        if (r0.equals("noembed") == false) goto L80;
        r7 = 10;
        goto L53
    L80:
        r7 = -1;
        goto L53
    L15:
        if (r0.equals("plaintext") == false) goto L81;
        r7 = 9;
        goto L53
    L81:
        r7 = -1;
        goto L53
    L19:
        if (r0.equals("noscript") == false) goto L82;
        r7 = 8;
        goto L53
    L82:
        r7 = -1;
        goto L53
    L23:
        if (r0.equals("noframes") == false) goto L83;
        r7 = 7;
        goto L53
    L83:
        r7 = -1;
        goto L53
    L27:
        if (r0.equals("title") == false) goto L84;
        r7 = 6;
        goto L53
    L84:
        r7 = -1;
        goto L53
    L31:
        if (r0.equals("style") == false) goto L85;
        r7 = 5;
        goto L53
    L85:
        r7 = -1;
        goto L53
    L35:
        if (r0.equals("xml") == false) goto L86;
        r7 = 4;
        goto L53
    L86:
        r7 = -1;
        goto L53
    L39:
        if (r0.equals("script") == false) goto L87;
        r7 = 3;
        goto L53
    L87:
        r7 = -1;
        goto L53
    L43:
        if (r0.equals("textarea") == false) goto L88;
        r7 = 2;
        goto L53
    L88:
        r7 = -1;
        goto L53
    L47:
        if (r0.equals("iframe") == true) goto L53;
        r7 = -1;
        goto L53
    L50:
        if (r0.equals("template") == false) goto L90;
        r7 = 0;
        goto L53
    L90:
        r7 = -1;
        goto L53
    }

    Element a(String r3) {
        Element r0 = new Element(a(r3, this.q), null);
        insert(r0);
        return r0;
    }

    Element a(Token.g r5) {
        f r0 = a(r5.u(), this.q);
        Element r1 = new Element(r0, null, this.q.a(r5.e));
        c(r1, r5);
        if (r5.x() == true) goto L5;
    L10:
        return r1;
    L5:
        if (r0.h() == true) goto L7;
        r0.k();
        goto L10
    L7:
        if (r0.f() == true) goto L10;
        this.l.a("Tag [%s] cannot be self closing; not a void tag", new Object[]{r0.b()});
        goto L10
    }

    org.jsoup.nodes.h a(Token.g r5, boolean r6, boolean r7) {
        org.jsoup.nodes.h r1 = new org.jsoup.nodes.h(a(r5.u(), this.q), null, this.q.a(r5.e));
        if (r7 == true) goto L5;
    L6:
        a(r1);
    L7:
        c(r1, r5);
        if (r6 == false) goto L10;
        this.n.add(r1);
    L10:
        return r1;
    L5:
        if (b("template") == true) goto L7;
        goto L6
    }

    @Override // org.jsoup.parser.i
    d a() {
        return d.f18288a;
    }

    @Override // org.jsoup.parser.i
    public void a(Reader r1, String r2, e r3) {
        super.a(r1, r2, r3);
        this.s = HtmlTreeBuilderState.Initial;
        this.t = null;
        this.u = false;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = new ArrayList();
        this.z = new ArrayList();
        this.A = new ArrayList();
        this.B = new Token.f();
        this.C = true;
        this.D = false;
        this.E = false;
    }

    void a(Element r2) {
        if (this.u == false) goto L5;
        return;
    L5:
        String r3 = r2.a("href");
        if (r3.length() == 0) goto L9;
        this.o = r3;
        this.u = true;
        this.m.z(r3);
        return;
    }

    void a(Element r2, int r3) {
        j(r2);
        this.y.add(r3, r2);     // Catch: IndexOutOfBoundsException -> L5
        return;
    L5:
        this.y.add(r2);
    }

    void a(Element r3, Element r4) {
        int r5 = this.n.lastIndexOf(r3);
        if (r5 == (-1)) goto L5;
        boolean r1 = true;
    L6:
        org.jsoup.helper.b.a(r1);
        this.n.add(r5 + 1, r4);
        return;
    L5:
        r1 = false;
        goto L6
    }

    void a(org.jsoup.nodes.h r1) {
        this.w = r1;
    }

    void a(j r5) {
        Element r0 = c("table");
        boolean r1 = false;
        if (r0 != null) goto L5;
        Element r4 = (Element) ZeusTransformUtils.preCheckCast(this.n.get(0), Element.class, "com.obric.memorydata.plugin");
    L9:
        if (r1 == false) goto L11;
        org.jsoup.helper.b.a(r0);
        r0.b(r5);
        return;
    L11:
        r4.a(r5);
        return;
    L5:
        if (r0.v() == null) goto L7;
        r4 = r0.v();
        r1 = true;
        goto L9
    L7:
        r4 = e(r0);
        goto L9
    }

    void a(HtmlTreeBuilderState r1) {
        this.s = r1;
    }

    void a(boolean r1) {
        this.C = r1;
    }

    void a(String... r5) {
        int r0 = this.n.size() - 1;
    L3:
        if (r0 < 0) goto L8;
        Element r1 = (Element) ZeusTransformUtils.preCheckCast(this.n.get(r0), Element.class, "com.obric.memorydata.plugin");
        this.n.remove(r0);
        if (org.jsoup.a.b.b(r1.r(), r5) == true) goto L11;
        r0 = r0 - 1;
        goto L3
    L11:
        return;
    }

    @Override // org.jsoup.parser.i
    public /* bridge */ /* synthetic */ boolean a(String r1, org.jsoup.nodes.b r2) {
        return super.a(r1, r2);
    }

    boolean a(String r2, String[] r3) {
        return a(r2, f18284a, r3);
    }

    @Override // org.jsoup.parser.i
    public boolean a(Token r2) {
        this.p = r2;
        return this.s.process(r2, this);
    }

    boolean a(Token r1, HtmlTreeBuilderState r2) {
        this.p = r1;
        return r2.process(r1, this);
    }

    HtmlTreeBuilderState b() {
        return this.s;
    }

    void b(Element r1) {
        this.n.add(r1);
    }

    void b(Element r2, Element r3) {
        a(this.n, r2, r3);
    }

    void b(HtmlTreeBuilderState r7) {
        if (this.j.c().canAddError() == false) goto L6;
        this.j.c().add(new c(this.k, "Unexpected %s token [%s] when in state [%s]", new Object[]{this.p.a(), this.p, r7}));
        return;
    }

    void b(boolean r1) {
        this.D = r1;
    }

    boolean b(String r1) {
        if (c(r1) == null) goto L5;
        return true;
    L5:
        return false;
    }

    boolean b(String[] r3) {
        return a(r3, f18284a, null);
    }

    Element c(String r6) {
        int r0 = this.n.size() - 1;
        if (r0 < 256) goto L5;
        int r1 = r0 + InputDeviceCompat.SOURCE_ANY;
    L6:
        if (r0 < r1) goto L11;
        Element r2 = (Element) ZeusTransformUtils.preCheckCast(this.n.get(r0), Element.class, "com.obric.memorydata.plugin");
        if (r2.r().equals(r6) == true) goto L9;
        r0 = r0 - 1;
        goto L6
    L9:
        return r2;
    L11:
        return null;
    L5:
        r1 = 0;
        goto L6
    }

    void c() {
        this.t = this.s;
    }

    void c(Element r2, Element r3) {
        a(this.y, r2, r3);
    }

    void c(HtmlTreeBuilderState r1) {
        this.z.add(r1);
    }

    void c(boolean r2) {
        if (r2 == false) goto L4;
        String[] r3 = g;
    L6:
        if (org.jsoup.a.b.b(E().r(), r3) == false) goto L8;
        i();
        goto L6
    L8:
        return;
    L4:
        r3 = f;
        goto L6
    }

    boolean c(Element r1) {
        return a(this.n, r1);
    }

    Element d(String r5) {
        int r0 = this.n.size() - 1;
    L3:
        if (r0 < 0) goto L11;
        Element r1 = (Element) ZeusTransformUtils.preCheckCast(this.n.get(r0), Element.class, "com.obric.memorydata.plugin");
        this.n.remove(r0);
        if (r1.r().equals(r5) == true) goto L7;
        r0 = r0 - 1;
        goto L3
    L7:
        if (ZeusTransformUtils.instanceOf(this.p, Token.f.class) == false) goto L9;
        b(r1, this.p);
    L9:
        return r1;
    L11:
        return null;
    }

    HtmlTreeBuilderState d() {
        return this.t;
    }

    boolean d(Element r6) {
        int r0 = this.n.size() - 1;
    L3:
        if (r0 < 0) goto L9;
        if (((Element) ZeusTransformUtils.preCheckCast(this.n.get(r0), Element.class, "com.obric.memorydata.plugin")) == r6) goto L6;
        r0 = r0 - 1;
        goto L3
    L6:
        this.n.remove(r0);
        return true;
    L9:
        return false;
    }

    Element e(Element r5) {
        if (i == false) goto L5;
    L9:
        int r0 = this.n.size() - 1;
    L10:
        if (r0 < 0) goto L16;
        if (((Element) ZeusTransformUtils.preCheckCast(this.n.get(r0), Element.class, "com.obric.memorydata.plugin")) == r5) goto L14;
        r0 = r0 - 1;
        goto L10
    L14:
        return (Element) ZeusTransformUtils.preCheckCast(this.n.get(r0 - 1), Element.class, "com.obric.memorydata.plugin");
    L16:
        return null;
    L5:
        if (c(r5) == true) goto L9;
        throw new AssertionError();
    }

    void e(String r5) {
        int r0 = this.n.size() - 1;
    L3:
        if (r0 < 0) goto L8;
        if (((Element) ZeusTransformUtils.preCheckCast(this.n.get(r0), Element.class, "com.obric.memorydata.plugin")).r().equals(r5) == true) goto L11;
        this.n.remove(r0);
        r0 = r0 - 1;
        goto L3
    L11:
        return;
    }

    boolean e() {
        return this.C;
    }

    Document f() {
        return this.m;
    }

    void f(Element r1) {
        this.v = r1;
    }

    boolean f(String r2) {
        return a(r2, null);
    }

    String g() {
        return this.o;
    }

    boolean g(String r2) {
        return a(r2, f18285b);
    }

    boolean g(Element r1) {
        return org.jsoup.a.b.b(r1.r(), h);
    }

    int h(Element r3) {
        int r0 = 0;
    L4:
        if (r0 >= this.y.size()) goto L9;
        if (r3 == this.y.get(r0)) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        return r0;
    L9:
        return -1;
    }

    boolean h() {
        return this.E;
    }

    boolean h(String r2) {
        return a(r2, c);
    }

    Element i() {
        return (Element) ZeusTransformUtils.preCheckCast(this.n.remove(this.n.size() - 1), Element.class, "com.obric.memorydata.plugin");
    }

    void i(Element r1) {
        j(r1);
        this.y.add(r1);
    }

    boolean i(String r3) {
        return a(r3, d, null);
    }

    Element insert(Token.g r6) {
        if (r6.s() == false) goto L10;
        if (r6.e.b() == true) goto L10;
        if (r6.e.a(this.q) <= 0) goto L10;
        a("Dropped duplicate attribute(s) in tag [%s]", new Object[]{r6.c});
    L10:
        if (r6.x() == false) goto L13;
        Element r7 = a(r6);
        this.n.add(r7);
        this.l.a(TokeniserState.Data);
        this.l.a(this.B.q().b(r7.q()));
        return r7;
    L13:
        Element r0 = new Element(a(r6.u(), this.q), null, this.q.a(r6.e));
        insert(r0, r6);
        return r0;
    }

    void insert(Element r2) {
        c(r2, null);
        this.n.add(r2);
    }

    void insert(Token.b r5) {
        Element r0 = E();
        String r1 = r0.r();
        String r2 = r5.q();
        if (r5.n() == false) goto L6;
        j r3 = new org.jsoup.nodes.c(r2);
    L9:
        r0.a(r3);
        a(r3, r5);
        return;
    L6:
        if (n(r1) == false) goto L8;
        r3 = new org.jsoup.nodes.e(r2);
        goto L9
    L8:
        r3 = new n(r2);
        goto L9
    }

    void insert(Token.c r3) {
        c(new org.jsoup.nodes.d(r3.q()), r3);
    }

    ArrayList<Element> j() {
        return this.n;
    }

    void j(Element r7) {
        int r0 = this.y.size() - 1;
        int r1 = r0 - 12;
        int r2 = 0;
        if (r1 >= 0) goto L5;
        r1 = 0;
    L5:
        if (r0 < r1) goto L21;
        Element r3 = (Element) ZeusTransformUtils.preCheckCast(this.y.get(r0), Element.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L22;
        if (d(r7, r3) == false) goto L13;
        r2 = r2 + 1;
    L13:
        if (r2 == 3) goto L14;
        r0 = r0 - 1;
        goto L5
    L14:
        this.y.remove(r0);
        return;
    L22:
        return;
    }

    boolean j(String r7) {
        int r0 = this.n.size() - 1;
    L4:
        if (r0 < 0) goto L12;
        String r3 = ((Element) ZeusTransformUtils.preCheckCast(this.n.get(r0), Element.class, "com.obric.memorydata.plugin")).r();
        if (r3.equals(r7) == true) goto L7;
        if (org.jsoup.a.b.b(r3, e) == false) goto L10;
        r0 = r0 - 1;
        goto L4
    L10:
        return false;
    L7:
        return true;
    L12:
        org.jsoup.helper.b.b("Should not be reachable");
        return false;
    }

    void k() {
        c(new String[]{"table", "template"});
    }

    void k(String r3) {
    L3:
        if (org.jsoup.a.b.b(E().r(), f) == false) goto L9;
        if (r3 == null) goto L8;
        if (q(r3) == false) goto L8;
        return;
    L8:
        i();
        goto L3
    }

    void k(Element r5) {
        int r0 = this.y.size() - 1;
    L3:
        if (r0 < 0) goto L11;
        if (((Element) ZeusTransformUtils.preCheckCast(this.y.get(r0), Element.class, "com.obric.memorydata.plugin")) == r5) goto L6;
        r0 = r0 - 1;
        goto L3
    L6:
        this.y.remove(r0);
        return;
    }

    void l() {
        c(new String[]{"tbody", "tfoot", "thead", "template"});
    }

    void l(String r2) {
        k(r2);
        if (r2.equals(E().r()) == true) goto L5;
        b(b());
    L5:
        d(r2);
    }

    boolean l(Element r1) {
        return a(this.y, r1);
    }

    Element m(String r5) {
        int r0 = this.y.size() - 1;
    L3:
        if (r0 < 0) goto L11;
        Element r1 = (Element) ZeusTransformUtils.preCheckCast(this.y.get(r0), Element.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L16;
        if (r1.r().equals(r5) == true) goto L9;
        r0 = r0 - 1;
        goto L3
    L9:
        return r1;
    L16:
        return null;
    L11:
        return null;
    }

    void m() {
        c(new String[]{"tr", "template"});
    }

    boolean n() {
        int r0 = this.n.size() - 1;
        if (r0 < 256) goto L5;
        int r2 = r0 + InputDeviceCompat.SOURCE_ANY;
    L6:
        HtmlTreeBuilderState r4 = this.s;
        if (this.n.size() != 0) goto L9;
        a(HtmlTreeBuilderState.InBody);
    L9:
        boolean r5 = false;
    L10:
        if (r0 < r2) goto L107;
        Element r6 = (Element) ZeusTransformUtils.preCheckCast(this.n.get(r0), Element.class, "com.obric.memorydata.plugin");
        if (r0 == r2) goto L14;
    L17:
        if (r6 == null) goto L19;
        String r7 = r6.r();
    L20:
        r7.hashCode();
        byte r8 = -1;
        switch(r7.hashCode()) {
            case -1644953643: goto L80;
            case -1321546630: goto L76;
            case -906021636: goto L72;
            case -636197633: goto L68;
            case 3696: goto L64;
            case 3700: goto L60;
            case 3710: goto L56;
            case 3029410: goto L52;
            case 3198432: goto L48;
            case 3213227: goto L44;
            case 110115790: goto L40;
            case 110157846: goto L36;
            case 110277346: goto L32;
            case 110326868: goto L28;
            case 552573414: goto L24;
            default: goto L83;
        };
    L83:
        switch(r8) {
            case 0: goto L105;
            case 1: goto L104;
            case 2: goto L102;
            case 3: goto L101;
            case 4: goto L96;
            case 5: goto L96;
            case 6: goto L95;
            case 7: goto L94;
            case 8: goto L92;
            case 9: goto L89;
            case 10: goto L87;
            case 11: goto L86;
            case 12: goto L86;
            case 13: goto L86;
            case 14: goto L85;
            default: goto L98;
        };
    L92:
        if (r5 == true) goto L98;
        HtmlTreeBuilderState r1 = HtmlTreeBuilderState.InHead;
    L103:
        a(r1);
        goto L107
    L96:
        if (r5 == true) goto L98;
        r1 = HtmlTreeBuilderState.InCell;
    L98:
        if (r5 == true) goto L94;
        r0 = r0 - 1;
        goto L10
    L85:
        r1 = HtmlTreeBuilderState.InCaption;
        goto L103
    L86:
        r1 = HtmlTreeBuilderState.InTableBody;
        goto L103
    L87:
        r1 = HtmlTreeBuilderState.InTable;
        goto L103
    L89:
        if (this.v != null) goto L91;
        r1 = HtmlTreeBuilderState.BeforeHead;
        goto L103
    L91:
        r1 = HtmlTreeBuilderState.AfterHead;
    L94:
        r1 = HtmlTreeBuilderState.InBody;
        goto L103
    L95:
        r1 = HtmlTreeBuilderState.InRow;
        goto L103
    L101:
        r1 = HtmlTreeBuilderState.InColumnGroup;
        goto L103
    L102:
        r1 = HtmlTreeBuilderState.InSelect;
        goto L103
    L104:
        r1 = C();
        org.jsoup.helper.b.b(r1, "Bug: no template insertion mode on stack!");
        goto L103
    L105:
        r1 = HtmlTreeBuilderState.InFrameset;
        goto L103
    L24:
        if (r7.equals("caption") == false) goto L83;
        r8 = 14;
        goto L83
    L28:
        if (r7.equals("thead") == false) goto L83;
        r8 = 13;
        goto L83
    L32:
        if (r7.equals("tfoot") == false) goto L83;
        r8 = 12;
        goto L83
    L36:
        if (r7.equals("tbody") == false) goto L83;
        r8 = 11;
        goto L83
    L40:
        if (r7.equals("table") == false) goto L83;
        r8 = 10;
        goto L83
    L44:
        if (r7.equals("html") == false) goto L83;
        r8 = 9;
        goto L83
    L48:
        if (r7.equals("head") == false) goto L83;
        r8 = 8;
        goto L83
    L52:
        if (r7.equals("body") == false) goto L83;
        r8 = 7;
        goto L83
    L56:
        if (r7.equals("tr") == false) goto L83;
        r8 = 6;
        goto L83
    L60:
        if (r7.equals("th") == false) goto L83;
        r8 = 5;
        goto L83
    L64:
        if (r7.equals("td") == false) goto L83;
        r8 = 4;
        goto L83
    L68:
        if (r7.equals("colgroup") == false) goto L83;
        r8 = 3;
        goto L83
    L72:
        if (r7.equals("select") == false) goto L83;
        r8 = 2;
        goto L83
    L76:
        if (r7.equals("template") == false) goto L83;
        r8 = 1;
        goto L83
    L80:
        if (r7.equals("frameset") == false) goto L83;
        r8 = 0;
        goto L83
    L19:
        r7 = "";
        goto L20
    L14:
        if (this.E == false) goto L16;
        r6 = this.x;
    L16:
        r5 = true;
    L107:
        if (this.s == r4) goto L110;
        return true;
    L110:
        return false;
    L5:
        r2 = 0;
        goto L6
    }

    @Override // org.jsoup.parser.i
    public boolean n(String r1) {
        if (r1.equals("script") == false) goto L5;
    L8:
        return true;
    L5:
        if (r1.equals("style") == true) goto L8;
        return false;
    }

    void o() {
        if (b("body") == true) goto L5;
        this.n.add(this.m.b());
    L5:
        a(HtmlTreeBuilderState.InBody);
    }

    Element p() {
        return this.v;
    }

    boolean q() {
        return this.D;
    }

    org.jsoup.nodes.h r() {
        return this.w;
    }

    void s() {
        this.A = new ArrayList();
    }

    List<String> t() {
        return this.A;
    }

    public String toString() {
        return "TreeBuilder{currentToken=" + this.p + ", state=" + this.s + ", currentElement=" + E() + '}';
    }

    void u() {
        c(false);
    }

    Element v() {
        if (this.y.size() <= 0) goto L5;
        ArrayList<Element> r2 = this.y;
        return (Element) ZeusTransformUtils.preCheckCast(r2.get(r2.size() - 1), Element.class, "com.obric.memorydata.plugin");
    L5:
        return null;
    }

    Element w() {
        int r0 = this.y.size();
        if (r0 > 0) goto L5;
        return null;
    L5:
        return (Element) ZeusTransformUtils.preCheckCast(this.y.remove(r0 - 1), Element.class, "com.obric.memorydata.plugin");
    }

    void x() {
        if (this.n.size() <= 256) goto L5;
        return;
    L5:
        Element r0 = v();
        if (r0 != null) goto L8;
        return;
    L8:
        if (c(r0) == true) goto L34;
        int r1 = this.y.size();
        int r2 = r1 - 12;
        if (r2 >= 0) goto L13;
        r2 = 0;
    L13:
        boolean r4 = true;
        int r3 = r1 - 1;
        int r5 = r3;
    L15:
        if (r5 == r2) goto L22;
        r5 = r5 - 1;
        r0 = (Element) ZeusTransformUtils.preCheckCast(this.y.get(r5), Element.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L21;
        if (c(r0) == false) goto L15;
    L21:
        r4 = false;
    L22:
        if (r4 == true) goto L24;
        r5 = r5 + 1;
        r0 = (Element) ZeusTransformUtils.preCheckCast(this.y.get(r5), Element.class, "com.obric.memorydata.plugin");
    L24:
        org.jsoup.helper.b.a(r0);
        Element r6 = new Element(a(r0.r(), this.q), null, r0.p().e());
        insert(r6);
        this.y.set(r5, r6);
        if (r5 == r3) goto L35;
        r4 = false;
        goto L22
    L35:
        return;
    }

    void y() {
    L3:
        if (this.y.isEmpty() == true) goto L6;
        if (w() != null) goto L3;
        return;
    }

    void z() {
        this.y.add(null);
    }
}
