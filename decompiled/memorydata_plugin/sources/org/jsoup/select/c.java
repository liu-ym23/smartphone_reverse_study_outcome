package org.jsoup.select;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.regex.Pattern;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: loaded from: classes7.dex */
public abstract class c {

    public static final class a extends c {
        public a() {
        }

        @Override // org.jsoup.select.c
        public boolean a(Element r1, Element r2) {
            return true;
        }

        public String toString() {
            return "*";
        }
    }

    public static final class aa extends ad {
        public aa() {
            super(0, 1);
        }

        @Override // org.jsoup.select.c.q
        public String toString() {
            return ":last-of-type";
        }
    }

    public static final class ab extends q {
        public ab(int r1, int r2) {
            super(r1, r2);
        }

        @Override // org.jsoup.select.c.q
        public String a() {
            return "nth-child";
        }

        @Override // org.jsoup.select.c.q
        public int b(Element r1, Element r2) {
            return r2.G() + 1;
        }
    }

    public static final class ac extends q {
        public ac(int r1, int r2) {
            super(r1, r2);
        }

        @Override // org.jsoup.select.c.q
        public String a() {
            return "nth-last-child";
        }

        @Override // org.jsoup.select.c.q
        public int b(Element r1, Element r2) {
            if (r2.v() != null) goto L7;
            return 0;
        L7:
            return r2.v().y().size() - r2.G();
        }
    }

    public static class ad extends q {
        public ad(int r1, int r2) {
            super(r1, r2);
        }

        @Override // org.jsoup.select.c.q
        public String a() {
            return "nth-last-of-type";
        }

        @Override // org.jsoup.select.c.q
        public int b(Element r5, Element r6) {
            int r7 = 0;
            if (r6.v() != null) goto L5;
            return 0;
        L5:
            Elements r4 = r6.v().y();
            int r0 = r6.G();
        L7:
            if (r0 >= r4.size()) goto L12;
            if (((Element) ZeusTransformUtils.preCheckCast(r4.get(r0), Element.class, "com.obric.memorydata.plugin")).s().equals(r6.s()) == false) goto L11;
            r7 = r7 + 1;
        L11:
            r0 = r0 + 1;
            goto L7
        L12:
            return r7;
        }
    }

    public static class ae extends q {
        public ae(int r1, int r2) {
            super(r1, r2);
        }

        @Override // org.jsoup.select.c.q
        public String a() {
            return "nth-of-type";
        }

        @Override // org.jsoup.select.c.q
        public int b(Element r4, Element r5) {
            int r6 = 0;
            if (r5.v() != null) goto L5;
            return 0;
        L5:
            Iterator<Element> r3 = r5.v().y().iterator();
        L7:
            if (r3.hasNext() == false) goto L12;
            Element r0 = (Element) ZeusTransformUtils.preCheckCast(r3.next(), Element.class, "com.obric.memorydata.plugin");
            if (r0.s().equals(r5.s()) == false) goto L11;
            r6 = r6 + 1;
        L11:
            if (r0 != r5) goto L7;
        L12:
            return r6;
        }
    }

    public static final class af extends c {
        public af() {
        }

        @Override // org.jsoup.select.c
        public boolean a(Element r1, Element r2) {
            Element r0 = r2.v();
            if (r0 != null) goto L5;
        L9:
            return false;
        L5:
            if (ZeusTransformUtils.instanceOf(r0, Document.class) == true) goto L9;
            if (r2.D().isEmpty() == false) goto L9;
            return true;
        }

        public String toString() {
            return ":only-child";
        }
    }

    public static final class ag extends c {
        public ag() {
        }

        @Override // org.jsoup.select.c
        public boolean a(Element r5, Element r6) {
            Element r4 = r6.v();
            if (r4 != null) goto L5;
            return false;
        L5:
            if (ZeusTransformUtils.instanceOf(r4, Document.class) == true) goto L24;
            Iterator<Element> r7 = r4.y().iterator();
            int r0 = 0;
        L9:
            if (r7.hasNext() == false) goto L14;
            if (((Element) ZeusTransformUtils.preCheckCast(r7.next(), Element.class, "com.obric.memorydata.plugin")).s().equals(r6.s()) == false) goto L9;
            r0 = r0 + 1;
            goto L9
        L14:
            if (r0 == 1) goto L16;
            return false;
        L16:
            return true;
        L24:
            return false;
        }

        public String toString() {
            return ":only-of-type";
        }
    }

    public static final class ah extends c {
        public ah() {
        }

        @Override // org.jsoup.select.c
        public boolean a(Element r2, Element r3) {
            if (ZeusTransformUtils.instanceOf(r2, Document.class) == false) goto L5;
            r2 = r2.a(0);
        L5:
            if (r3 != r2) goto L8;
            return true;
        L8:
            return false;
        }

        public String toString() {
            return ":root";
        }
    }

    public static final class ai extends c {
        public ai() {
        }

        @Override // org.jsoup.select.c
        public boolean a(Element r5, Element r6) {
            if (ZeusTransformUtils.instanceOf(r6, org.jsoup.nodes.l.class) == false) goto L6;
            return true;
        L6:
            Iterator<org.jsoup.nodes.n> r4 = r6.B().iterator();
        L8:
            if (r4.hasNext() == false) goto L10;
            org.jsoup.nodes.j r7 = (org.jsoup.nodes.n) ZeusTransformUtils.preCheckCast(r4.next(), org.jsoup.nodes.n.class, "com.obric.memorydata.plugin");
            org.jsoup.nodes.l r0 = new org.jsoup.nodes.l(org.jsoup.parser.f.a(r6.q()), r6.g(), r6.p());
            r7.j(r0);
            r0.a(r7);
            goto L8
        L10:
            return false;
        }

        public String toString() {
            return ":matchText";
        }
    }

    public static final class aj extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Pattern f18305a;

        public aj(Pattern r1) {
            this.f18305a = r1;
        }

        @Override // org.jsoup.select.c
        public boolean a(Element r1, Element r2) {
            return this.f18305a.matcher(r2.H()).find();
        }

        public String toString() {
            return String.format(":matches(%s)", new Object[]{this.f18305a});
        }
    }

    public static final class ak extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Pattern f18306a;

        public ak(Pattern r1) {
            this.f18306a = r1;
        }

        @Override // org.jsoup.select.c
        public boolean a(Element r1, Element r2) {
            return this.f18306a.matcher(r2.K()).find();
        }

        public String toString() {
            return String.format(":matchesOwn(%s)", new Object[]{this.f18306a});
        }
    }

    public static final class al extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Pattern f18307a;

        public al(Pattern r1) {
            this.f18307a = r1;
        }

        @Override // org.jsoup.select.c
        public boolean a(Element r1, Element r2) {
            return this.f18307a.matcher(r2.J()).find();
        }

        public String toString() {
            return String.format(":matchesWholeOwnText(%s)", new Object[]{this.f18307a});
        }
    }

    public static final class am extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Pattern f18308a;

        public am(Pattern r1) {
            this.f18308a = r1;
        }

        @Override // org.jsoup.select.c
        public boolean a(Element r1, Element r2) {
            return this.f18308a.matcher(r2.I()).find();
        }

        public String toString() {
            return String.format(":matchesWholeText(%s)", new Object[]{this.f18308a});
        }
    }

    public static final class an extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f18309a;

        public an(String r1) {
            this.f18309a = r1;
        }

        @Override // org.jsoup.select.c
        public boolean a(Element r1, Element r2) {
            return r2.r().equals(this.f18309a);
        }

        public String toString() {
            return String.format("%s", new Object[]{this.f18309a});
        }
    }

    public static final class ao extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f18310a;

        public ao(String r1) {
            this.f18310a = r1;
        }

        @Override // org.jsoup.select.c
        public boolean a(Element r1, Element r2) {
            return r2.r().endsWith(this.f18310a);
        }

        public String toString() {
            return String.format("%s", new Object[]{this.f18310a});
        }
    }

    public static final class b extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f18311a;

        public b(String r1) {
            this.f18311a = r1;
        }

        @Override // org.jsoup.select.c
        public boolean a(Element r1, Element r2) {
            return r2.c(this.f18311a);
        }

        public String toString() {
            return String.format("[%s]", new Object[]{this.f18311a});
        }
    }

    /* JADX INFO: renamed from: org.jsoup.select.c$c, reason: collision with other inner class name */
    public static abstract class AbstractC0901c extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f18312a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f18313b;

        public AbstractC0901c(String r2, String r3) {
            this(r2, r3, true);
        }

        public AbstractC0901c(String r3, String r4, boolean r5) {
            org.jsoup.helper.b.a(r3);
            org.jsoup.helper.b.a(r4);
            this.f18312a = org.jsoup.a.a.b(r3);
            if (r4.startsWith("'") == false) goto L7;
            if (r4.endsWith("'") == false) goto L7;
        L10:
            boolean r6 = true;
        L12:
            if (r6 == false) goto L14;
            r4 = r4.substring(1, r4.length() - 1);
        L14:
            if (r5 == false) goto L16;
            String r7 = org.jsoup.a.a.b(r4);
        L17:
            this.f18313b = r7;
            return;
        L16:
            r7 = org.jsoup.a.a.a(r4, r6);
        L7:
            if (r4.startsWith("\"") == true) goto L9;
        L11:
            r6 = false;
            goto L12
        L9:
            if (r4.endsWith("\"") == false) goto L11;
            goto L10
        }
    }

    public static final class d extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f18314a;

        public d(String r1) {
            org.jsoup.helper.b.a(r1);
            this.f18314a = org.jsoup.a.a.a(r1);
        }

        @Override // org.jsoup.select.c
        public boolean a(Element r3, Element r4) {
            Iterator<org.jsoup.nodes.a> r5 = r4.p().c().iterator();
        L4:
            if (r5.hasNext() == false) goto L9;
            if (org.jsoup.a.a.a(((org.jsoup.nodes.a) ZeusTransformUtils.preCheckCast(r5.next(), org.jsoup.nodes.a.class, "com.obric.memorydata.plugin")).a()).startsWith(this.f18314a) == false) goto L4;
            return true;
        L9:
            return false;
        }

        public String toString() {
            return String.format("[^%s]", new Object[]{this.f18314a});
        }
    }

    public static final class e extends AbstractC0901c {
        public e(String r1, String r2) {
            super(r1, r2);
        }

        @Override // org.jsoup.select.c
        public boolean a(Element r1, Element r2) {
            if (r2.c(this.f18312a) == true) goto L5;
        L7:
            return false;
        L5:
            if (this.f18313b.equalsIgnoreCase(r2.d(this.f18312a).trim()) == false) goto L7;
            return true;
        }

        public String toString() {
            return String.format("[%s=%s]", new Object[]{this.f18312a, this.f18313b});
        }
    }

    public static final class f extends AbstractC0901c {
        public f(String r1, String r2) {
            super(r1, r2);
        }

        @Override // org.jsoup.select.c
        public boolean a(Element r1, Element r2) {
            if (r2.c(this.f18312a) == true) goto L5;
        L7:
            return false;
        L5:
            if (org.jsoup.a.a.a(r2.d(this.f18312a)).contains(this.f18313b) == false) goto L7;
            return true;
        }

        public String toString() {
            return String.format("[%s*=%s]", new Object[]{this.f18312a, this.f18313b});
        }
    }

    public static final class g extends AbstractC0901c {
        public g(String r2, String r3) {
            super(r2, r3, false);
        }

        @Override // org.jsoup.select.c
        public boolean a(Element r1, Element r2) {
            if (r2.c(this.f18312a) == true) goto L5;
        L7:
            return false;
        L5:
            if (org.jsoup.a.a.a(r2.d(this.f18312a)).endsWith(this.f18313b) == false) goto L7;
            return true;
        }

        public String toString() {
            return String.format("[%s$=%s]", new Object[]{this.f18312a, this.f18313b});
        }
    }

    public static final class h extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f18315a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Pattern f18316b;

        public h(String r1, Pattern r2) {
            this.f18315a = org.jsoup.a.a.b(r1);
            this.f18316b = r2;
        }

        @Override // org.jsoup.select.c
        public boolean a(Element r1, Element r2) {
            if (r2.c(this.f18315a) == true) goto L5;
        L7:
            return false;
        L5:
            if (this.f18316b.matcher(r2.d(this.f18315a)).find() == false) goto L7;
            return true;
        }

        public String toString() {
            return String.format("[%s~=%s]", new Object[]{this.f18315a, this.f18316b.toString()});
        }
    }

    public static final class i extends AbstractC0901c {
        public i(String r1, String r2) {
            super(r1, r2);
        }

        @Override // org.jsoup.select.c
        public boolean a(Element r1, Element r2) {
            return !this.f18313b.equalsIgnoreCase(r2.d(this.f18312a));
        }

        public String toString() {
            return String.format("[%s!=%s]", new Object[]{this.f18312a, this.f18313b});
        }
    }

    public static final class j extends AbstractC0901c {
        public j(String r2, String r3) {
            super(r2, r3, false);
        }

        @Override // org.jsoup.select.c
        public boolean a(Element r1, Element r2) {
            if (r2.c(this.f18312a) == true) goto L5;
        L7:
            return false;
        L5:
            if (org.jsoup.a.a.a(r2.d(this.f18312a)).startsWith(this.f18313b) == false) goto L7;
            return true;
        }

        public String toString() {
            return String.format("[%s^=%s]", new Object[]{this.f18312a, this.f18313b});
        }
    }

    public static final class k extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f18317a;

        public k(String r1) {
            this.f18317a = r1;
        }

        @Override // org.jsoup.select.c
        public boolean a(Element r1, Element r2) {
            return r2.p(this.f18317a);
        }

        public String toString() {
            return String.format(".%s", new Object[]{this.f18317a});
        }
    }

    public static final class l extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f18318a;

        public l(String r1) {
            this.f18318a = org.jsoup.a.a.a(r1);
        }

        @Override // org.jsoup.select.c
        public boolean a(Element r1, Element r2) {
            return org.jsoup.a.a.a(r2.M()).contains(this.f18318a);
        }

        public String toString() {
            return String.format(":containsData(%s)", new Object[]{this.f18318a});
        }
    }

    public static final class m extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f18319a;

        public m(String r1) {
            this.f18319a = org.jsoup.a.a.a(org.jsoup.a.b.c(r1));
        }

        @Override // org.jsoup.select.c
        public boolean a(Element r1, Element r2) {
            return org.jsoup.a.a.a(r2.K()).contains(this.f18319a);
        }

        public String toString() {
            return String.format(":containsOwn(%s)", new Object[]{this.f18319a});
        }
    }

    public static final class n extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f18320a;

        public n(String r1) {
            this.f18320a = org.jsoup.a.a.a(org.jsoup.a.b.c(r1));
        }

        @Override // org.jsoup.select.c
        public boolean a(Element r1, Element r2) {
            return org.jsoup.a.a.a(r2.H()).contains(this.f18320a);
        }

        public String toString() {
            return String.format(":contains(%s)", new Object[]{this.f18320a});
        }
    }

    public static final class o extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f18321a;

        public o(String r1) {
            this.f18321a = r1;
        }

        @Override // org.jsoup.select.c
        public boolean a(Element r1, Element r2) {
            return r2.J().contains(this.f18321a);
        }

        public String toString() {
            return String.format(":containsWholeOwnText(%s)", new Object[]{this.f18321a});
        }
    }

    public static final class p extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f18322a;

        public p(String r1) {
            this.f18322a = r1;
        }

        @Override // org.jsoup.select.c
        public boolean a(Element r1, Element r2) {
            return r2.I().contains(this.f18322a);
        }

        public String toString() {
            return String.format(":containsWholeText(%s)", new Object[]{this.f18322a});
        }
    }

    public static abstract class q extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final int f18323a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected final int f18324b;

        public q(int r1, int r2) {
            this.f18323a = r1;
            this.f18324b = r2;
        }

        public abstract String a();

        @Override // org.jsoup.select.c
        public boolean a(Element r4, Element r5) {
            Element r0 = r5.v();
            if (r0 != null) goto L5;
            return false;
        L5:
            if (ZeusTransformUtils.instanceOf(r0, Document.class) == true) goto L22;
            int r6 = b(r4, r5);
            int r7 = this.f18323a;
            int r3 = this.f18324b;
            if (r7 != 0) goto L13;
            if (r6 == r3) goto L11;
            return false;
        L11:
            return true;
        L13:
            if (((r6 - r3) * r7) >= 0) goto L15;
            return false;
        L15:
            if (((r6 - r3) % r7) == 0) goto L17;
            return false;
        L17:
            return true;
        L22:
            return false;
        }

        public abstract int b(Element r1, Element r2);

        public String toString() {
            if (this.f18323a != 0) goto L7;
            return String.format(":%s(%d)", new Object[]{a(), Integer.valueOf(this.f18324b)});
        L7:
            if (this.f18324b != 0) goto L11;
            return String.format(":%s(%dn)", new Object[]{a(), Integer.valueOf(this.f18323a)});
        L11:
            return String.format(":%s(%dn%+d)", new Object[]{a(), Integer.valueOf(this.f18323a), Integer.valueOf(this.f18324b)});
        }
    }

    public static final class r extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f18325a;

        public r(String r1) {
            this.f18325a = r1;
        }

        @Override // org.jsoup.select.c
        public boolean a(Element r1, Element r2) {
            return this.f18325a.equals(r2.u());
        }

        public String toString() {
            return String.format("#%s", new Object[]{this.f18325a});
        }
    }

    public static final class s extends t {
        public s(int r1) {
            super(r1);
        }

        @Override // org.jsoup.select.c
        public boolean a(Element r1, Element r2) {
            if (r2.G() != this.f18326a) goto L5;
            return true;
        L5:
            return false;
        }

        public String toString() {
            return String.format(":eq(%d)", new Object[]{Integer.valueOf(this.f18326a)});
        }
    }

    public static abstract class t extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f18326a;

        public t(int r1) {
            this.f18326a = r1;
        }
    }

    public static final class u extends t {
        public u(int r1) {
            super(r1);
        }

        @Override // org.jsoup.select.c
        public boolean a(Element r1, Element r2) {
            if (r2.G() <= this.f18326a) goto L5;
            return true;
        L5:
            return false;
        }

        public String toString() {
            return String.format(":gt(%d)", new Object[]{Integer.valueOf(this.f18326a)});
        }
    }

    public static final class v extends t {
        public v(int r1) {
            super(r1);
        }

        @Override // org.jsoup.select.c
        public boolean a(Element r1, Element r2) {
            if (r1 != r2) goto L4;
        L6:
            return false;
        L4:
            if (r2.G() >= this.f18326a) goto L6;
            return true;
        }

        public String toString() {
            return String.format(":lt(%d)", new Object[]{Integer.valueOf(this.f18326a)});
        }
    }

    public static final class w extends c {
        public w() {
        }

        @Override // org.jsoup.select.c
        public boolean a(Element r2, Element r3) {
            Iterator<org.jsoup.nodes.j> r1 = r3.W().iterator();
        L4:
            if (r1.hasNext() == false) goto L13;
            org.jsoup.nodes.j r4 = (org.jsoup.nodes.j) ZeusTransformUtils.preCheckCast(r1.next(), org.jsoup.nodes.j.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r4, org.jsoup.nodes.d.class) == true) goto L4;
            if (ZeusTransformUtils.instanceOf(r4, org.jsoup.nodes.o.class) == true) goto L4;
            if (ZeusTransformUtils.instanceOf(r4, org.jsoup.nodes.f.class) == true) goto L4;
            return false;
        L13:
            return true;
        }

        public String toString() {
            return ":empty";
        }
    }

    public static final class x extends c {
        public x() {
        }

        @Override // org.jsoup.select.c
        public boolean a(Element r1, Element r2) {
            Element r0 = r2.v();
            if (r0 != null) goto L5;
        L9:
            return false;
        L5:
            if (ZeusTransformUtils.instanceOf(r0, Document.class) == true) goto L9;
            if (r2.G() != 0) goto L9;
            return true;
        }

        public String toString() {
            return ":first-child";
        }
    }

    public static final class y extends ae {
        public y() {
            super(0, 1);
        }

        @Override // org.jsoup.select.c.q
        public String toString() {
            return ":first-of-type";
        }
    }

    public static final class z extends c {
        public z() {
        }

        @Override // org.jsoup.select.c
        public boolean a(Element r2, Element r3) {
            Element r1 = r3.v();
            if (r1 != null) goto L5;
        L9:
            return false;
        L5:
            if (ZeusTransformUtils.instanceOf(r1, Document.class) == true) goto L9;
            if (r3.G() != (r1.y().size() - 1)) goto L9;
            return true;
        }

        public String toString() {
            return ":last-child";
        }
    }

    public c() {
    }

    public abstract boolean a(Element r1, Element r2);
}
