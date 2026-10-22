package org.jsoup.nodes;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public class c extends n {
    public c(String r1) {
        super(r1);
    }

    @Override // org.jsoup.nodes.n, org.jsoup.nodes.j
    public String a() {
        return "#cdata";
    }

    @Override // org.jsoup.nodes.n, org.jsoup.nodes.j
    void a(Appendable r1, int r2, Document.OutputSettings r3) {
        ((Appendable) ZeusTransformUtils.wrapperContextForParams(r1, Appendable.class, "com.obric.memorydata.plugin")).append("<![CDATA[").append(i());
    }

    public c b() {
        return (c) ZeusTransformUtils.preCheckCast(super.c(), c.class, "com.obric.memorydata.plugin");
    }

    @Override // org.jsoup.nodes.n, org.jsoup.nodes.j
    void b(Appendable r1, int r2, Document.OutputSettings r3) {
        ((Appendable) ZeusTransformUtils.wrapperContextForParams(r1, Appendable.class, "com.obric.memorydata.plugin")).append("]]>");
    }

    @Override // org.jsoup.nodes.n
    public /* synthetic */ n c() {
        return b();
    }

    @Override // org.jsoup.nodes.n, org.jsoup.nodes.j
    public /* synthetic */ Object clone() {
        return b();
    }

    @Override // org.jsoup.nodes.n, org.jsoup.nodes.j
    public /* synthetic */ j d() {
        return b();
    }
}
