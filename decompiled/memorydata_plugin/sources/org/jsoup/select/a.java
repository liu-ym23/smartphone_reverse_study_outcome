package org.jsoup.select;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.j;

/* JADX INFO: loaded from: classes7.dex */
public class a {

    /* JADX INFO: renamed from: org.jsoup.select.a$a, reason: collision with other inner class name */
    static class C0899a implements NodeFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Element f18301a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Element f18302b;
        private final c c;

        C0899a(c r2) {
            this.f18301a = null;
            this.f18302b = null;
            this.c = r2;
        }

        Element a(Element r1, Element r2) {
            this.f18301a = r1;
            this.f18302b = null;
            d.a(this, r2);
            return this.f18302b;
        }

        @Override // org.jsoup.select.NodeFilter
        public NodeFilter.FilterResult a(j r1, int r2) {
            return NodeFilter.FilterResult.CONTINUE;
        }

        @Override // org.jsoup.select.NodeFilter
        public NodeFilter.FilterResult head(j r2, int r3) {
            if (ZeusTransformUtils.instanceOf(r2, Element.class) == false) goto L9;
            Element r4 = (Element) ZeusTransformUtils.preCheckCast(r2, Element.class, "com.obric.memorydata.plugin");
            if (this.c.a(this.f18301a, r4) == false) goto L9;
            this.f18302b = r4;
            return NodeFilter.FilterResult.STOP;
        L9:
            return NodeFilter.FilterResult.CONTINUE;
        }
    }

    public static Elements a(final c r2, final Element r3) {
        final Elements r0 = new Elements();
        d.a(new $$Lambda$a$kNsrYnhPBxdvVIQh1fxob5mwho(r2, r3, r0), r3);
        return r0;
    }

    private static /* synthetic */ void a(c r1, Element r2, Elements r3, j r4, int r5) {
        if (ZeusTransformUtils.instanceOf(r4, Element.class) == false) goto L8;
        Element r6 = (Element) ZeusTransformUtils.preCheckCast(r4, Element.class, "com.obric.memorydata.plugin");
        if (r1.a(r2, r6) == false) goto L9;
        r3.add(r6);
        return;
    L9:
        return;
    }

    /* JADX INFO: renamed from: lambda$kNsrYnhPBxdvVI-Qh1fxob5mwho, reason: not valid java name */
    public static /* synthetic */ void m3206lambda$kNsrYnhPBxdvVIQh1fxob5mwho(c r0, Element r1, Elements r2, j r3, int r4) {
        a(r0, r1, r2, r3, r4);
    }
}
