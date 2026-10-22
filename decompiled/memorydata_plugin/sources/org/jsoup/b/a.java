package org.jsoup.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.j;
import org.jsoup.nodes.n;
import org.jsoup.parser.f;
import org.jsoup.select.d;
import org.jsoup.select.e;

/* JADX INFO: loaded from: classes7.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final org.jsoup.b.b f18237a;

    /* JADX INFO: renamed from: org.jsoup.b.a$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: renamed from: org.jsoup.b.a$a, reason: collision with other inner class name */
    private final class C0897a implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f18238a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f18239b;
        private final Element c;
        private Element d;

        private C0897a(a r1, Element r2, Element r3) {
            this.f18238a = r1;
            this.f18239b = 0;
            this.c = r2;
            this.d = r3;
        }

        /* synthetic */ C0897a(a r1, Element r2, Element r3, AnonymousClass1 r4) {
            this(r1, r2, r3);
        }

        static /* synthetic */ int a(C0897a r0) {
            return r0.f18239b;
        }

        @Override // org.jsoup.select.e
        public void a(j r1, int r2) {
            if (ZeusTransformUtils.instanceOf(r1, Element.class) == true) goto L5;
            return;
        L5:
            if (a.a(this.f18238a).a(r1.a()) == false) goto L9;
            this.d = this.d.v();
            return;
        }

        @Override // org.jsoup.select.e
        public void head(j r3, int r4) {
            if (ZeusTransformUtils.instanceOf(r3, Element.class) == false) goto L11;
            Element r5 = (Element) ZeusTransformUtils.preCheckCast(r3, Element.class, "com.obric.memorydata.plugin");
            if (a.a(this.f18238a).a(r5.r()) == false) goto L8;
            b r6 = a.a(this.f18238a, r5);
            Element r7 = r6.f18240a;
            this.d.a(r7);
            this.f18239b += r6.f18241b;
            this.d = r7;
            return;
        L8:
            if (r3 == this.c) goto L22;
        L19:
            this.f18239b++;
            return;
        L22:
            return;
        L11:
            if (ZeusTransformUtils.instanceOf(r3, n.class) == false) goto L15;
            j r8 = new n(((n) ZeusTransformUtils.preCheckCast(r3, n.class, "com.obric.memorydata.plugin")).i());
        L13:
            this.d.a(r8);
            return;
        L15:
            if (ZeusTransformUtils.instanceOf(r3, org.jsoup.nodes.e.class) == false) goto L19;
            if (a.a(this.f18238a).a(r3.U().a()) == false) goto L19;
            r8 = new org.jsoup.nodes.e(((org.jsoup.nodes.e) ZeusTransformUtils.preCheckCast(r3, org.jsoup.nodes.e.class, "com.obric.memorydata.plugin")).b());
            goto L13
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Element f18240a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f18241b;

        b(Element r1, int r2) {
            this.f18240a = r1;
            this.f18241b = r2;
        }
    }

    public a(org.jsoup.b.b r1) {
        org.jsoup.helper.b.a(r1);
        this.f18237a = r1;
    }

    private int a(Element r3, Element r4) {
        C0897a r0 = new C0897a(this, r3, r4, null);
        d.a(r0, r3);
        return C0897a.a(r0);
    }

    static /* synthetic */ b a(a r0, Element r1) {
        return r0.a(r1);
    }

    private b a(Element r10) {
        String r0 = r10.q();
        org.jsoup.nodes.b r1 = new org.jsoup.nodes.b();
        Element r2 = new Element(f.a(r0), r10.g(), r1);
        Iterator<org.jsoup.nodes.a> r3 = r10.p().iterator();
        int r5 = 0;
    L4:
        if (r3.hasNext() == false) goto L9;
        org.jsoup.nodes.a r6 = (org.jsoup.nodes.a) ZeusTransformUtils.preCheckCast(r3.next(), org.jsoup.nodes.a.class, "com.obric.memorydata.plugin");
        if (this.f18237a.a(r0, r10, r6) == true) goto L7;
        r5 = r5 + 1;
        goto L4
    L7:
        r1.a(r6);
        goto L4
    L9:
        r1.a(this.f18237a.b(r0));
        if (r10.ah().a() == false) goto L13;
        r10.ah().b(r2, true);
    L13:
        if (r10.Q().a() == false) goto L16;
        r10.Q().b(r2, false);
    L16:
        return new b(r2, r5);
    }

    static /* synthetic */ org.jsoup.b.b a(a r0) {
        return r0.f18237a;
    }

    public Document a(Document r4) {
        org.jsoup.helper.b.a(r4);
        Document r0 = Document.e(r4.g());
        a(r4.b(), r0.b());
        r0.a(r4.j().i());
        return r0;
    }
}
