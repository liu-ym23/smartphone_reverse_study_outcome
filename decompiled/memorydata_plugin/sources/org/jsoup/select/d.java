package org.jsoup.select;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.j;

/* JADX INFO: loaded from: classes7.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f18327a = true;

    static {
    }

    public d() {
    }

    public static NodeFilter.FilterResult a(NodeFilter r6, j r7) {
        NodeFilter r8 = (NodeFilter) ZeusTransformUtils.wrapperContextForParams(r6, NodeFilter.class, "com.obric.memorydata.plugin");
        j r1 = r7;
        int r2 = 0;
    L3:
        if (r1 == null) goto L47;
        NodeFilter.FilterResult r3 = r8.head(r1, r2);
        if (r3 == NodeFilter.FilterResult.STOP) goto L6;
        if (r3 != NodeFilter.FilterResult.CONTINUE) goto L13;
        if (r1.f() <= 0) goto L13;
        r1 = r1.b(0);
        r2 = r2 + 1;
    L13:
        if (f18327a == true) goto L19;
        if (r1 != null) goto L19;
        throw new AssertionError();
    L19:
        if (r1.ad() != null) goto L34;
        if (r2 <= 0) goto L34;
        if (r3 != NodeFilter.FilterResult.CONTINUE) goto L25;
    L26:
        r3 = r8.a(r1, r2);
        if (r3 == NodeFilter.FilterResult.STOP) goto L28;
    L29:
        j r4 = r1.Y();
        r2 = r2 - 1;
        if (r3 != NodeFilter.FilterResult.REMOVE) goto L32;
        r1.aa();
    L32:
        r3 = NodeFilter.FilterResult.CONTINUE;
        r1 = r4;
        goto L13
    L28:
        return r3;
    L25:
        if (r3 != NodeFilter.FilterResult.SKIP_CHILDREN) goto L29;
    L34:
        if (r3 != NodeFilter.FilterResult.CONTINUE) goto L36;
    L37:
        r3 = r8.a(r1, r2);
        if (r3 == NodeFilter.FilterResult.STOP) goto L39;
    L40:
        if (r1 == r7) goto L41;
        j r5 = r1.ad();
        if (r3 != NodeFilter.FilterResult.REMOVE) goto L45;
        r1.aa();
    L45:
        r1 = r5;
        goto L3
    L41:
        return r3;
    L39:
        return r3;
    L36:
        if (r3 != NodeFilter.FilterResult.SKIP_CHILDREN) goto L40;
    L6:
        return r3;
    L47:
        return NodeFilter.FilterResult.CONTINUE;
    }

    public static void a(NodeFilter r3, Elements r4) {
        NodeFilter r5 = (NodeFilter) ZeusTransformUtils.wrapperContextForParams(r3, NodeFilter.class, "com.obric.memorydata.plugin");
        org.jsoup.helper.b.a(r5);
        org.jsoup.helper.b.a(r4);
        Iterator<Element> r6 = r4.iterator();
    L4:
        if (r6.hasNext() == false) goto L7;
        if (a(r5, (Element) ZeusTransformUtils.preCheckCast(r6.next(), Element.class, "com.obric.memorydata.plugin")) != NodeFilter.FilterResult.STOP) goto L4;
        return;
    }

    public static void a(e r7, j r8) {
        e r9 = (e) ZeusTransformUtils.wrapperContextForParams(r7, e.class, "com.obric.memorydata.plugin");
        org.jsoup.helper.b.a(r9);
        org.jsoup.helper.b.a(r8);
        j r1 = r8;
        int r2 = 0;
    L3:
        if (r1 == null) goto L36;
        j r3 = r1.Y();
        if (r3 == null) goto L7;
        int r4 = r3.f();
    L8:
        j r5 = r1.ad();
        r9.head(r1, r2);
        if (r3 == null) goto L19;
        if (r1.V() == true) goto L19;
        if (r4 != r3.f()) goto L15;
        r1 = r3.b(r1.af());
        goto L19
    L15:
        if (r5 == null) goto L16;
        r1 = r5;
        goto L3
    L16:
        r2 = r2 - 1;
        r1 = r3;
    L19:
        if (r1.f() > 0) goto L20;
    L22:
        if (f18327a == true) goto L28;
        if (r1 != null) goto L28;
        throw new AssertionError();
    L28:
        if (r1.ad() != null) goto L32;
        if (r2 <= 0) goto L32;
        r9.a(r1, r2);
        r1 = r1.Y();
        r2 = r2 - 1;
    L32:
        r9.a(r1, r2);
        if (r1 == r8) goto L55;
        r1 = r1.ad();
        goto L3
    L55:
        return;
    L20:
        r1 = r1.b(0);
        r2 = r2 + 1;
        goto L3
    L7:
        r4 = 0;
        goto L8
    }

    public static void a(e r3, Elements r4) {
        e r5 = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.memorydata.plugin");
        org.jsoup.helper.b.a(r5);
        org.jsoup.helper.b.a(r4);
        Iterator<Element> r6 = r4.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        a(r5, (Element) ZeusTransformUtils.preCheckCast(r6.next(), Element.class, "com.obric.memorydata.plugin"));
        goto L4
    }
}
