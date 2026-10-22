package org.jsoup.nodes;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public class d extends i {
    public d(String r1) {
        this.f18264a = r1;
    }

    @Override // org.jsoup.nodes.j
    public String a() {
        return "#comment";
    }

    @Override // org.jsoup.nodes.i, org.jsoup.nodes.j
    public /* bridge */ /* synthetic */ String a(String r1) {
        return super.a(r1);
    }

    @Override // org.jsoup.nodes.i, org.jsoup.nodes.j
    public /* bridge */ /* synthetic */ j a(String r1, String r2) {
        return super.a(r1, r2);
    }

    @Override // org.jsoup.nodes.j
    void a(Appendable r4, int r5, Document.OutputSettings r6) {
        Appendable r7 = (Appendable) ZeusTransformUtils.wrapperContextForParams(r4, Appendable.class, "com.obric.memorydata.plugin");
        if (r6.e() == true) goto L5;
    L13:
        r7.append("<!--").append(b()).append("-->");
        return;
    L5:
        if (af() != 0) goto L11;
        if (ZeusTransformUtils.instanceOf(this.d, Element.class) == false) goto L11;
        if (((Element) ZeusTransformUtils.preCheckCast(this.d, Element.class, "com.obric.memorydata.plugin")).s().d() == false) goto L11;
    L12:
        c(r7, r5, r6);
    L11:
        if (r6.f() == false) goto L13;
        goto L12
    }

    public String b() {
        return h();
    }

    @Override // org.jsoup.nodes.i, org.jsoup.nodes.j
    public /* bridge */ /* synthetic */ j b(String r1) {
        return super.b(r1);
    }

    @Override // org.jsoup.nodes.j
    void b(Appendable r1, int r2, Document.OutputSettings r3) {
        Appendable r0 = (Appendable) ZeusTransformUtils.wrapperContextForParams(r1, Appendable.class, "com.obric.memorydata.plugin");
    }

    public d c() {
        return (d) ZeusTransformUtils.preCheckCast(super.d(), d.class, "com.obric.memorydata.plugin");
    }

    @Override // org.jsoup.nodes.i, org.jsoup.nodes.j
    public /* bridge */ /* synthetic */ boolean c(String r1) {
        return super.c(r1);
    }

    @Override // org.jsoup.nodes.j
    public /* synthetic */ Object clone() {
        return c();
    }

    @Override // org.jsoup.nodes.i, org.jsoup.nodes.j
    public /* bridge */ /* synthetic */ String d(String r1) {
        return super.d(r1);
    }

    @Override // org.jsoup.nodes.j
    public /* synthetic */ j d() {
        return c();
    }

    @Override // org.jsoup.nodes.i, org.jsoup.nodes.j
    public /* bridge */ /* synthetic */ j e() {
        return super.e();
    }

    @Override // org.jsoup.nodes.i, org.jsoup.nodes.j
    public /* bridge */ /* synthetic */ int f() {
        return super.f();
    }

    @Override // org.jsoup.nodes.i, org.jsoup.nodes.j
    public /* bridge */ /* synthetic */ String g() {
        return super.g();
    }

    @Override // org.jsoup.nodes.j
    public String toString() {
        return x_();
    }
}
