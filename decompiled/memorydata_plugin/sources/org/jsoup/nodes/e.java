package org.jsoup.nodes;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public class e extends i {
    public e(String r1) {
        this.f18264a = r1;
    }

    @Override // org.jsoup.nodes.j
    public String a() {
        return "#data";
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
    void a(Appendable r1, int r2, Document.OutputSettings r3) {
        ((Appendable) ZeusTransformUtils.wrapperContextForParams(r1, Appendable.class, "com.obric.memorydata.plugin")).append(b());
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

    public e c() {
        return (e) ZeusTransformUtils.preCheckCast(super.d(), e.class, "com.obric.memorydata.plugin");
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
