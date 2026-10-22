package org.jsoup.select;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.j;

/* JADX INFO: loaded from: classes7.dex */
abstract class g extends org.jsoup.select.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    org.jsoup.select.c f18330a;

    static class a extends g {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final org.jsoup.select.a.C0899a f18331b;

        public a(org.jsoup.select.c r2) {
            this.f18330a = r2;
            this.f18331b = new org.jsoup.select.a.C0899a(r2);
        }

        @Override // org.jsoup.select.c
        public boolean a(Element r6, Element r7) {
            int r0 = 0;
        L4:
            if (r0 >= r7.f()) goto L12;
            j r1 = r7.b(r0);
            if (ZeusTransformUtils.instanceOf(r1, Element.class) == false) goto L11;
            if (this.f18331b.a(r7, (Element) ZeusTransformUtils.preCheckCast(r1, Element.class, "com.obric.memorydata.plugin")) == null) goto L11;
            return true;
        L11:
            r0 = r0 + 1;
            goto L4
        L12:
            return false;
        }

        public String toString() {
            return String.format(":has(%s)", new Object[]{this.f18330a});
        }
    }

    static class b extends g {
        public b(org.jsoup.select.c r1) {
            this.f18330a = r1;
        }

        @Override // org.jsoup.select.c
        public boolean a(Element r2, Element r3) {
            if (r2 != r3) goto L5;
            return false;
        L5:
            Element r4 = r3.v();
            if (r4 != null) goto L8;
            return false;
        L8:
            if (this.f18330a.a(r2, r4) == false) goto L12;
            return true;
        L12:
            return false;
        }

        public String toString() {
            return String.format("%s > ", new Object[]{this.f18330a});
        }
    }

    static class c extends g {
        public c(org.jsoup.select.c r1) {
            this.f18330a = r1;
        }

        @Override // org.jsoup.select.c
        public boolean a(Element r2, Element r3) {
            if (r2 != r3) goto L5;
            return false;
        L5:
            Element r4 = r3.F();
            if (r4 != null) goto L8;
            return false;
        L8:
            if (this.f18330a.a(r2, r4) == false) goto L12;
            return true;
        L12:
            return false;
        }

        public String toString() {
            return String.format("%s + ", new Object[]{this.f18330a});
        }
    }

    static class d extends g {
        public d(org.jsoup.select.c r1) {
            this.f18330a = r1;
        }

        @Override // org.jsoup.select.c
        public boolean a(Element r1, Element r2) {
            return !this.f18330a.a(r1, r2);
        }

        public String toString() {
            return String.format(":not(%s)", new Object[]{this.f18330a});
        }
    }

    static class e extends g {
        public e(org.jsoup.select.c r1) {
            this.f18330a = r1;
        }

        @Override // org.jsoup.select.c
        public boolean a(Element r3, Element r4) {
            if (r3 != r4) goto L5;
            return false;
        L5:
            r4 = r4.v();
            if (r4 == null) goto L12;
            if (this.f18330a.a(r3, r4) == true) goto L9;
            if (r4 != r3) goto L5;
        L9:
            return true;
        L12:
            return false;
        }

        public String toString() {
            return String.format("%s ", new Object[]{this.f18330a});
        }
    }

    static class f extends g {
        public f(org.jsoup.select.c r1) {
            this.f18330a = r1;
        }

        @Override // org.jsoup.select.c
        public boolean a(Element r3, Element r4) {
            if (r3 != r4) goto L5;
            return false;
        L5:
            r4 = r4.F();
            if (r4 == null) goto L11;
            if (this.f18330a.a(r3, r4) == false) goto L5;
            return true;
        L11:
            return false;
        }

        public String toString() {
            return String.format("%s ~ ", new Object[]{this.f18330a});
        }
    }

    /* JADX INFO: renamed from: org.jsoup.select.g$g, reason: collision with other inner class name */
    static class C0902g extends org.jsoup.select.c {
        C0902g() {
        }

        @Override // org.jsoup.select.c
        public boolean a(Element r1, Element r2) {
            if (r1 != r2) goto L4;
            return true;
        L4:
            return false;
        }
    }

    g() {
    }
}
