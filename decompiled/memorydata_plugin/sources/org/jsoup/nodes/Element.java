package org.jsoup.nodes;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;
import kotlin.text.Typography;
import org.jsoup.helper.ChangeNotifyingArrayList;
import org.jsoup.select.Elements;
import org.jsoup.select.NodeFilter;
import org.jsoup.select.Selector;

/* JADX INFO: loaded from: classes7.dex */
public class Element extends j {
    private static final List<Element> f = null;
    private static final Pattern g = null;
    private static final String h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    List<j> f18249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    b f18250b;
    private org.jsoup.parser.f i;
    private WeakReference<List<Element>> j;

    private static final class NodeList extends ChangeNotifyingArrayList<j> {
        private final Element owner;

        NodeList(Element r1, int r2) {
            super(r2);
            this.owner = r1;
        }

        @Override // org.jsoup.helper.ChangeNotifyingArrayList
        public void onContentsChanged() {
            this.owner.A();
        }
    }

    static {
        f = Collections.emptyList();
        g = Pattern.compile("\\s+");
        h = b.i("baseUri");
    }

    public Element(org.jsoup.parser.f r2, String r3) {
        this(r2, r3, null);
    }

    public Element(org.jsoup.parser.f r2, String r3, b r4) {
        org.jsoup.helper.b.a(r2);
        this.f18249a = c;
        this.f18250b = r4;
        this.i = r2;
        if (r3 == null) goto L6;
        z(r3);
        return;
    }

    private static <E extends Element> int a(Element r4, List<E> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        int r0 = r6.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        if (r6.get(r2) == r4) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r2;
    L8:
        return 0;
    }

    private static String a(Element r1, String r2) {
    L2:
        if (r1 == null) goto L10;
        b r0 = r1.f18250b;
        if (r0 == null) goto L9;
        if (r0.g(r2) == false) goto L9;
        return r1.f18250b.b(r2);
    L9:
        r1 = r1.v();
        goto L2
    L10:
        return "";
    }

    static /* synthetic */ org.jsoup.parser.f a(Element r0) {
        return r0.i;
    }

    private static /* synthetic */ NodeFilter.FilterResult a(AtomicBoolean r1, j r2, int r3) {
        if (ZeusTransformUtils.instanceOf(r2, n.class) == false) goto L9;
        if (((n) ZeusTransformUtils.preCheckCast(r2, n.class, "com.obric.memorydata.plugin")).j() == true) goto L9;
        r1.set(true);
        return NodeFilter.FilterResult.STOP;
    L9:
        return NodeFilter.FilterResult.CONTINUE;
    }

    private void a(StringBuilder r5) {
        int r0 = 0;
    L4:
        if (r0 >= f()) goto L14;
        j r1 = (j) ZeusTransformUtils.preCheckCast(this.f18249a.get(r0), j.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, n.class) == false) goto L9;
        b(r5, (n) ZeusTransformUtils.preCheckCast(r1, n.class, "com.obric.memorydata.plugin"));
    L13:
        r0 = r0 + 1;
        goto L4
    L9:
        if (r1.A("br") == false) goto L13;
        if (n.a(r5) == true) goto L13;
        r5.append(" ");
        goto L13
    }

    private static /* synthetic */ void a(StringBuilder r1, j r2, int r3) {
        if (ZeusTransformUtils.instanceOf(r2, e.class) == false) goto L7;
        String r4 = ((e) ZeusTransformUtils.preCheckCast(r2, e.class, "com.obric.memorydata.plugin")).b();
    L5:
        r1.append(r4);
        return;
    L7:
        if (ZeusTransformUtils.instanceOf(r2, d.class) == false) goto L10;
        r4 = ((d) ZeusTransformUtils.preCheckCast(r2, d.class, "com.obric.memorydata.plugin")).b();
        goto L5
    L10:
        if (ZeusTransformUtils.instanceOf(r2, c.class) == false) goto L13;
        r4 = ((c) ZeusTransformUtils.preCheckCast(r2, c.class, "com.obric.memorydata.plugin")).i();
        goto L5
    }

    static /* synthetic */ void a(StringBuilder r0, n r1) {
        b(r0, r1);
    }

    private static void a(j r2, StringBuilder r3) {
        if (ZeusTransformUtils.instanceOf(r2, n.class) == false) goto L7;
        String r4 = ((n) ZeusTransformUtils.preCheckCast(r2, n.class, "com.obric.memorydata.plugin")).i();
    L5:
        r3.append(r4);
        return;
    L7:
        if (r2.A("br") == false) goto L10;
        r4 = "\n";
        goto L5
    }

    private boolean a(Document.OutputSettings r2) {
        if (this.i.d() == false) goto L5;
    L12:
        return true;
    L5:
        if (v() == null) goto L9;
        if (v().s().d() == true) goto L12;
    L9:
        if (r2.f() == true) goto L12;
        return false;
    }

    private static /* synthetic */ void b(StringBuilder r0, j r1, int r2) {
        a(r1, r0);
    }

    private static void b(StringBuilder r2, n r3) {
        String r0 = r3.i();
        if (d(r3.d) == false) goto L5;
    L8:
        r2.append(r0);
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r3, c.class) == true) goto L8;
        org.jsoup.a.b.a(r2, r0, n.a(r2));
    }

    private boolean c(Document.OutputSettings r2) {
        if (s().e() == true) goto L5;
    L13:
        return false;
    L5:
        if (v() == null) goto L9;
        if (v().t() == false) goto L13;
    L9:
        if (ae() == null) goto L13;
        if (r2.f() == true) goto L13;
        return true;
    }

    static boolean d(j r4) {
        if (ZeusTransformUtils.instanceOf(r4, Element.class) == false) goto L11;
        Element r5 = (Element) ZeusTransformUtils.preCheckCast(r4, Element.class, "com.obric.memorydata.plugin");
        int r0 = 0;
    L6:
        if (r5.i.i() == true) goto L7;
        r5 = r5.v();
        r0 = r0 + 1;
        if (r0 >= 6) goto L11;
        if (r5 != null) goto L6;
    L7:
        return true;
    L11:
        return false;
    }

    /* JADX INFO: renamed from: lambda$8_7-wHV-JkeVxcWhiYSnHlXq4Bg, reason: not valid java name */
    public static /* synthetic */ NodeFilter.FilterResult m3203lambda$8_7wHVJkeVxcWhiYSnHlXq4Bg(AtomicBoolean r0, j r1, int r2) {
        return a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$_bkNU7-uhSnCuZ972BjHKB35lpA, reason: not valid java name */
    public static /* synthetic */ void m3204lambda$_bkNU7uhSnCuZ972BjHKB35lpA(StringBuilder r0, j r1, int r2) {
        b(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$djoQ9ZZ-x2tJTpnt1AcY3vounvA, reason: not valid java name */
    public static /* synthetic */ void m3205lambda$djoQ9ZZx2tJTpnt1AcY3vounvA(StringBuilder r0, j r1, int r2) {
        a(r0, r1, r2);
    }

    @Override // org.jsoup.nodes.j
    void A() {
        super.A();
        this.j = null;
    }

    public List<n> B() {
        ArrayList r0 = new ArrayList();
        Iterator<j> r4 = this.f18249a.iterator();
    L4:
        if (r4.hasNext() == false) goto L9;
        j r1 = (j) ZeusTransformUtils.preCheckCast(r4.next(), j.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, n.class) == false) goto L4;
        r0.add((n) ZeusTransformUtils.preCheckCast(r1, n.class, "com.obric.memorydata.plugin"));
        goto L4
    L9:
        return Collections.unmodifiableList(r0);
    }

    public Element C() {
        this.f18249a.clear();
        return this;
    }

    public Elements D() {
        if (this.d == null) goto L5;
        List<Element> r0 = v().z();
        Elements r1 = new Elements(r0.size() - 1);
        Iterator<Element> r2 = r0.iterator();
    L8:
        if (r2.hasNext() == false) goto L12;
        Element r3 = (Element) ZeusTransformUtils.preCheckCast(r2.next(), Element.class, "com.obric.memorydata.plugin");
        if (r3 == this) goto L8;
        r1.add(r3);
        goto L8
    L12:
        return r1;
    L5:
        return new Elements(0);
    }

    public Element E() {
        if (this.d != null) goto L5;
        return null;
    L5:
        List<Element> r0 = v().z();
        int r3 = a(this, r0);
        int r4 = r3 + 1;
        if (r0.size() > r4) goto L8;
        return null;
    L8:
        return (Element) ZeusTransformUtils.preCheckCast(r0.get(r4), Element.class, "com.obric.memorydata.plugin");
    }

    public Element F() {
        if (this.d != null) goto L5;
        return null;
    L5:
        List<Element> r0 = v().z();
        int r2 = a(this, r0);
        if (r2 > 0) goto L8;
        return null;
    L8:
        return (Element) ZeusTransformUtils.preCheckCast(r0.get(r2 - 1), Element.class, "com.obric.memorydata.plugin");
    }

    public int G() {
        if (v() != null) goto L7;
        return 0;
    L7:
        return a(this, v().z());
    }

    public String H() {
        final StringBuilder r0 = org.jsoup.a.b.a();
        org.jsoup.select.d.a(new AnonymousClass1(this, r0), this);
        return org.jsoup.a.b.a(r0).trim();
    }

    public String I() {
        final StringBuilder r0 = org.jsoup.a.b.a();
        org.jsoup.select.d.a(new $$Lambda$Element$_bkNU7uhSnCuZ972BjHKB35lpA(r0), this);
        return org.jsoup.a.b.a(r0);
    }

    public String J() {
        StringBuilder r0 = org.jsoup.a.b.a();
        int r1 = f();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L6;
        a((j) ZeusTransformUtils.preCheckCast(this.f18249a.get(r2), j.class, "com.obric.memorydata.plugin"), r0);
        r2 = r2 + 1;
        goto L3
    L6:
        return org.jsoup.a.b.a(r0);
    }

    public String K() {
        StringBuilder r0 = org.jsoup.a.b.a();
        a(r0);
        return org.jsoup.a.b.a(r0).trim();
    }

    public boolean L() {
        final AtomicBoolean r0 = new AtomicBoolean(false);
        a(new $$Lambda$Element$8_7wHVJkeVxcWhiYSnHlXq4Bg(r0));
        return r0.get();
    }

    public String M() {
        final StringBuilder r0 = org.jsoup.a.b.a();
        a(new $$Lambda$Element$djoQ9ZZx2tJTpnt1AcY3vounvA(r0));
        return org.jsoup.a.b.a(r0);
    }

    public String N() {
        return d("class").trim();
    }

    public Set<String> O() {
        LinkedHashSet r0 = new LinkedHashSet(Arrays.asList(g.split(N())));
        r0.remove("");
        return r0;
    }

    public String P() {
        if (r().equals("textarea") == false) goto L7;
        return H();
    L7:
        return d(EventBody.KEY_VALUE);
    }

    public m Q() {
        return m.a(this, false);
    }

    public String R() {
        StringBuilder r0 = org.jsoup.a.b.a();
        a(r0);
        String r1 = org.jsoup.a.b.a(r0);
        if (k.a(this).e() == true) goto L5;
        return r1;
    L5:
        return r1.trim();
    }

    public Element S() {
        return (Element) ZeusTransformUtils.preCheckCast(super.T(), Element.class, "com.obric.memorydata.plugin");
    }

    @Override // org.jsoup.nodes.j
    public /* synthetic */ j T() {
        return S();
    }

    @Override // org.jsoup.nodes.j
    public /* synthetic */ j U() {
        return v();
    }

    @Override // org.jsoup.nodes.j
    public <T extends Appendable> T a(T r6) {
        T r7 = (T) ZeusTransformUtils.wrapperContextForParams(r6, Appendable.class, "com.obric.memorydata.plugin");
        int r0 = this.f18249a.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        ((j) ZeusTransformUtils.preCheckCast(this.f18249a.get(r2), j.class, "com.obric.memorydata.plugin")).b(r7);
        r2 = r2 + 1;
        goto L3
    L5:
        return r7;
    }

    @Override // org.jsoup.nodes.j
    public String a() {
        return this.i.a();
    }

    public Element a(int r2) {
        return (Element) ZeusTransformUtils.preCheckCast(z().get(r2), Element.class, "com.obric.memorydata.plugin");
    }

    public Element a(int r5, Collection<? extends j> r6) {
        Collection r7 = (Collection) ZeusTransformUtils.wrapperContextForParams(r6, Collection.class, "com.obric.memorydata.plugin");
        org.jsoup.helper.b.b(r7, "Children collection to be inserted must not be null.");
        int r0 = f();
        if (r5 >= 0) goto L6;
        r5 = r5 + (r0 + 1);
    L6:
        if (r5 < 0) goto L9;
        if (r5 > r0) goto L9;
        boolean r1 = true;
    L10:
        org.jsoup.helper.b.a(r1, "Insert position out of bounds.");
        a(r5, (j[]) ZeusTransformUtils.preCheckCast(new ArrayList(r7).toArray(new j[0]), j[].class, "com.obric.memorydata.plugin"));
        return this;
    L9:
        r1 = false;
        goto L10
    }

    public Element a(Collection<? extends j> r3) {
        a(-1, (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin"));
        return this;
    }

    public Element a(Set<String> r4) {
        Set r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        org.jsoup.helper.b.a(r5);
        if (r5.isEmpty() == false) goto L5;
        p().e("class");
    L6:
        return this;
    L5:
        p().b("class", org.jsoup.a.b.a(r5, " "));
        goto L6
    }

    public Element a(j r2) {
        org.jsoup.helper.b.a(r2);
        l(r2);
        n();
        this.f18249a.add(r2);
        r2.c(this.f18249a.size() - 1);
        return this;
    }

    public Element a(NodeFilter r3) {
        return (Element) ZeusTransformUtils.preCheckCast(super.b((NodeFilter) ZeusTransformUtils.wrapperContextForParams(r3, NodeFilter.class, "com.obric.memorydata.plugin")), Element.class, "com.obric.memorydata.plugin");
    }

    public Element a(org.jsoup.select.e r3) {
        return (Element) ZeusTransformUtils.preCheckCast(super.b((org.jsoup.select.e) ZeusTransformUtils.wrapperContextForParams(r3, org.jsoup.select.e.class, "com.obric.memorydata.plugin")), Element.class, "com.obric.memorydata.plugin");
    }

    @Override // org.jsoup.nodes.j
    public /* synthetic */ j a(String r1, String r2) {
        return b(r1, r2);
    }

    @Override // org.jsoup.nodes.j
    void a(Appendable r3, int r4, Document.OutputSettings r5) {
        Appendable r6 = (Appendable) ZeusTransformUtils.wrapperContextForParams(r3, Appendable.class, "com.obric.memorydata.plugin");
        if (b(r5) == true) goto L5;
    L9:
        r6.append(Typography.less).append(q());
        b r7 = this.f18250b;
        if (r7 == null) goto L13;
        r7.a(r6, r5);
    L13:
        if (this.f18249a.isEmpty() == true) goto L15;
    L22:
        r6.append(Typography.greater);
        return;
    L15:
        if (this.i.g() == false) goto L22;
        if (r5.d() == Document.OutputSettings.Syntax.html) goto L19;
    L21:
        r6.append(" />");
        return;
    L19:
        if (this.i.f() == false) goto L21;
    L5:
        if (ZeusTransformUtils.instanceOf(r6, StringBuilder.class) == true) goto L7;
    L8:
        c(r6, r4, r5);
        goto L9
    L7:
        if (((StringBuilder) ZeusTransformUtils.preCheckCast(r6, StringBuilder.class, "com.obric.memorydata.plugin")).length() <= 0) goto L9;
        goto L8
    }

    public boolean a(org.jsoup.select.c r2) {
        return r2.a(S(), this);
    }

    public Element b(String r1, String r2) {
        super.a(r1, r2);
        return this;
    }

    public Element b(j r2) {
        return (Element) ZeusTransformUtils.preCheckCast(super.h(r2), Element.class, "com.obric.memorydata.plugin");
    }

    @Override // org.jsoup.nodes.j
    public /* synthetic */ j b(String r1) {
        return v(r1);
    }

    @Override // org.jsoup.nodes.j
    public /* synthetic */ j b(NodeFilter r3) {
        return a((NodeFilter) ZeusTransformUtils.wrapperContextForParams(r3, NodeFilter.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.jsoup.nodes.j
    public /* synthetic */ j b(org.jsoup.select.e r3) {
        return a((org.jsoup.select.e) ZeusTransformUtils.wrapperContextForParams(r3, org.jsoup.select.e.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.jsoup.nodes.j
    void b(Appendable r3, int r4, Document.OutputSettings r5) {
        Appendable r6 = (Appendable) ZeusTransformUtils.wrapperContextForParams(r3, Appendable.class, "com.obric.memorydata.plugin");
        if (this.f18249a.isEmpty() == false) goto L7;
        if (this.i.g() == false) goto L7;
        return;
    L7:
        if (r5.e() == true) goto L9;
    L21:
        r6.append("</").append(q()).append(Typography.greater);
        return;
    L9:
        if (this.f18249a.isEmpty() == true) goto L21;
        if (this.i.d() == false) goto L13;
    L20:
        c(r6, r4, r5);
        goto L21
    L13:
        if (r5.f() == false) goto L21;
        if (this.f18249a.size() > 1) goto L20;
        if (this.f18249a.size() != 1) goto L21;
        if (ZeusTransformUtils.instanceOf(this.f18249a.get(0), Element.class) == false) goto L21;
        goto L20
    }

    boolean b(Document.OutputSettings r2) {
        if (r2.e() == true) goto L5;
    L9:
        return false;
    L5:
        if (a(r2) == false) goto L9;
        if (c(r2) == true) goto L9;
        return true;
    }

    public Element c(j r2) {
        return (Element) ZeusTransformUtils.preCheckCast(super.g(r2), Element.class, "com.obric.memorydata.plugin");
    }

    @Override // org.jsoup.nodes.j
    public /* synthetic */ Object clone() {
        return m();
    }

    @Override // org.jsoup.nodes.j
    public /* synthetic */ j d() {
        return m();
    }

    public Element e(j r3) {
        Element r4 = (Element) ZeusTransformUtils.preCheckCast(super.f(r3), Element.class, "com.obric.memorydata.plugin");
        b r0 = this.f18250b;
        if (r0 == null) goto L5;
        b r1 = r0.e();
    L6:
        r4.f18250b = r1;
        NodeList r2 = new NodeList(r4, this.f18249a.size());
        r4.f18249a = r2;
        r2.addAll(this.f18249a);
        return r4;
    L5:
        r1 = null;
        goto L6
    }

    @Override // org.jsoup.nodes.j
    public /* synthetic */ j e() {
        return C();
    }

    @Override // org.jsoup.nodes.j
    public int f() {
        return this.f18249a.size();
    }

    public Element f(String r3) {
        org.jsoup.helper.b.a(r3);
        C();
        Document r0 = Z();
        if (r0 != null) goto L5;
    L7:
        j r1 = new n(r3);
    L8:
        a(r1);
        return this;
    L5:
        if (r0.l().a(r()) == false) goto L7;
        r1 = new e(r3);
        goto L8
    }

    @Override // org.jsoup.nodes.j
    public /* synthetic */ j f(j r1) {
        return e(r1);
    }

    @Override // org.jsoup.nodes.j
    public String g() {
        return a(this, h);
    }

    @Override // org.jsoup.nodes.j
    public /* synthetic */ j g(j r1) {
        return c(r1);
    }

    @Override // org.jsoup.nodes.j
    public void g(String r2) {
        p().b(h, r2);
    }

    public Element h(String r2) {
        org.jsoup.helper.b.a(r2, "tagName");
        this.i = org.jsoup.parser.f.a(r2, k.b(this).e());
        return this;
    }

    @Override // org.jsoup.nodes.j
    public /* synthetic */ j h(j r1) {
        return b(r1);
    }

    public Elements i(String r1) {
        return Selector.a(r1, this);
    }

    public Element j(String r3) {
        Element r0 = new Element(org.jsoup.parser.f.a(r3, k.b(this).e()), g());
        a(r0);
        return r0;
    }

    public Element k(String r3) {
        org.jsoup.helper.b.a(r3);
        a((j[]) ZeusTransformUtils.preCheckCast(k.b(this).a(r3, this, g()).toArray(new j[0]), j[].class, "com.obric.memorydata.plugin"));
        return this;
    }

    public Element l(String r4) {
        org.jsoup.helper.b.a(r4);
        a(0, (j[]) ZeusTransformUtils.preCheckCast(k.b(this).a(r4, this, g()).toArray(new j[0]), j[].class, "com.obric.memorydata.plugin"));
        return this;
    }

    public Element m() {
        return (Element) ZeusTransformUtils.preCheckCast(super.d(), Element.class, "com.obric.memorydata.plugin");
    }

    public Element m(String r2) {
        return (Element) ZeusTransformUtils.preCheckCast(super.y(r2), Element.class, "com.obric.memorydata.plugin");
    }

    @Override // org.jsoup.nodes.j
    public List<j> n() {
        if (this.f18249a != c) goto L6;
        this.f18249a = new NodeList(this, 4);
    L6:
        return this.f18249a;
    }

    public Element n(String r2) {
        return (Element) ZeusTransformUtils.preCheckCast(super.x(r2), Element.class, "com.obric.memorydata.plugin");
    }

    public Element o(String r2) {
        return (Element) ZeusTransformUtils.preCheckCast(super.w(r2), Element.class, "com.obric.memorydata.plugin");
    }

    @Override // org.jsoup.nodes.j
    public boolean o() {
        if (this.f18250b == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.jsoup.nodes.j
    public b p() {
        if (this.f18250b != null) goto L6;
        this.f18250b = new b();
    L6:
        return this.f18250b;
    }

    public boolean p(String r13) {
        b r12 = this.f18250b;
        if (r12 != null) goto L5;
        return false;
    L5:
        String r14 = r12.c("class");
        int r1 = r14.length();
        int r8 = r13.length();
        if (r1 == 0) goto L31;
        if (r1 < r8) goto L31;
        if (r1 == r8) goto L11;
        boolean r2 = false;
        int r9 = 0;
        int r10 = 0;
    L13:
        if (r10 >= r1) goto L26;
        if (Character.isWhitespace(r14.charAt(r10)) == false) goto L23;
        if (r2 == false) goto L25;
        if ((r10 - r9) == r8) goto L20;
    L22:
        r2 = false;
        goto L25
    L20:
        if (r14.regionMatches(true, r9, r13, 0, r8) == false) goto L22;
        return true;
    L25:
        r10 = r10 + 1;
        goto L13
    L23:
        if (r2 == true) goto L25;
        r9 = r10;
        r2 = true;
        goto L25
    L26:
        if (r2 == false) goto L31;
        if ((r1 - r9) != r8) goto L31;
        return r14.regionMatches(true, r9, r13, 0, r8);
    L11:
        return r13.equalsIgnoreCase(r14);
    L31:
        return false;
    }

    public String q() {
        return this.i.a();
    }

    public Element q(String r2) {
        org.jsoup.helper.b.a(r2);
        Set<String> r0 = O();
        r0.add(r2);
        a(r0);
        return this;
    }

    @Override // org.jsoup.nodes.j
    public String r() {
        return this.i.b();
    }

    public Element r(String r2) {
        org.jsoup.helper.b.a(r2);
        Set<String> r0 = O();
        r0.remove(r2);
        a(r0);
        return this;
    }

    public Element s(String r3) {
        org.jsoup.helper.b.a(r3);
        Set<String> r0 = O();
        if (r0.contains(r3) == false) goto L5;
        r0.remove(r3);
    L6:
        a(r0);
        return this;
    L5:
        r0.add(r3);
        goto L6
    }

    public org.jsoup.parser.f s() {
        return this.i;
    }

    public Element t(String r3) {
        if (r().equals("textarea") == false) goto L5;
        f(r3);
    L6:
        return this;
    L5:
        b(EventBody.KEY_VALUE, r3);
        goto L6
    }

    public boolean t() {
        return this.i.c();
    }

    public String u() {
        b r1 = this.f18250b;
        if (r1 != null) goto L7;
        return "";
    L7:
        return r1.c(OaidModel.KEY_ID);
    }

    public Element u(String r1) {
        C();
        k(r1);
        return this;
    }

    public final Element v() {
        return (Element) ZeusTransformUtils.preCheckCast(this.d, Element.class, "com.obric.memorydata.plugin");
    }

    public Element v(String r2) {
        return (Element) ZeusTransformUtils.preCheckCast(super.b(r2), Element.class, "com.obric.memorydata.plugin");
    }

    @Override // org.jsoup.nodes.j
    public /* synthetic */ j w(String r1) {
        return o(r1);
    }

    public Elements w() {
        Elements r0 = new Elements();
    L3:
        Element this = this.v();
        if (this == null) goto L8;
        if (this.A("#root") == true) goto L8;
        r0.add(this);
    L8:
        return r0;
    }

    public int x() {
        return z().size();
    }

    @Override // org.jsoup.nodes.j
    public /* synthetic */ j x(String r1) {
        return n(r1);
    }

    @Override // org.jsoup.nodes.j
    public /* synthetic */ j y(String r1) {
        return m(r1);
    }

    public Elements y() {
        return new Elements(z());
    }

    List<Element> z() {
        if (f() == 0) goto L5;
        WeakReference<List<Element>> r1 = this.j;
        if (r1 == null) goto L10;
        List<Element> r2 = (List) ZeusTransformUtils.preCheckCast(r1.get(), List.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L10;
        return r2;
    L10:
        int r3 = this.f18249a.size();
        ArrayList r4 = new ArrayList(r3);
        int r5 = 0;
    L11:
        if (r5 >= r3) goto L16;
        j r6 = (j) ZeusTransformUtils.preCheckCast(this.f18249a.get(r5), j.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, Element.class) == false) goto L15;
        r4.add((Element) ZeusTransformUtils.preCheckCast(r6, Element.class, "com.obric.memorydata.plugin"));
    L15:
        r5 = r5 + 1;
        goto L11
    L16:
        this.j = new WeakReference(r4);
        return r4;
    L5:
        return f;
    }
}
