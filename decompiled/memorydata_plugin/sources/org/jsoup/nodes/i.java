package org.jsoup.nodes;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
abstract class i extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f18264a;

    i() {
    }

    private void b() {
        if (o() == true) goto L8;
        Object r0 = this.f18264a;
        b r1 = new b();
        this.f18264a = r1;
        if (r0 == null) goto L9;
        r1.b(a(), (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin"));
        return;
    L9:
        return;
    }

    @Override // org.jsoup.nodes.j
    public String a(String r1) {
        b();
        return super.a(r1);
    }

    public i a(j r3) {
        i r4 = (i) ZeusTransformUtils.preCheckCast(super.f(r3), i.class, "com.obric.memorydata.plugin");
        if (o() == false) goto L5;
        r4.f18264a = ((b) ZeusTransformUtils.preCheckCast(this.f18264a, b.class, "com.obric.memorydata.plugin")).e();
    L5:
        return r4;
    }

    @Override // org.jsoup.nodes.j
    public j a(String r2, String r3) {
        if (o() == false) goto L5;
    L7:
        b();
        super.a(r2, r3);
    L8:
        return this;
    L5:
        if (r2.equals(a()) == false) goto L7;
        this.f18264a = r3;
        goto L8
    }

    @Override // org.jsoup.nodes.j
    public j b(String r1) {
        b();
        return super.b(r1);
    }

    @Override // org.jsoup.nodes.j
    public boolean c(String r1) {
        b();
        return super.c(r1);
    }

    @Override // org.jsoup.nodes.j
    public String d(String r2) {
        if (o() == true) goto L10;
        if (a().equals(r2) == true) goto L11;
        return "";
    L11:
        return (String) ZeusTransformUtils.preCheckCast(this.f18264a, String.class, "com.obric.memorydata.plugin");
    L10:
        return super.d(r2);
    }

    @Override // org.jsoup.nodes.j
    public j e() {
        return this;
    }

    @Override // org.jsoup.nodes.j
    public int f() {
        return 0;
    }

    @Override // org.jsoup.nodes.j
    public /* synthetic */ j f(j r1) {
        return a(r1);
    }

    @Override // org.jsoup.nodes.j
    public String g() {
        if (V() == true) goto L7;
        return "";
    L7:
        return U().g();
    }

    @Override // org.jsoup.nodes.j
    public void g(String r1) {
    }

    String h() {
        return d(a());
    }

    @Override // org.jsoup.nodes.j
    public List<j> n() {
        return c;
    }

    @Override // org.jsoup.nodes.j
    public final boolean o() {
        return ZeusTransformUtils.instanceOf(this.f18264a, b.class);
    }

    @Override // org.jsoup.nodes.j
    public final b p() {
        b();
        return (b) ZeusTransformUtils.preCheckCast(this.f18264a, b.class, "com.obric.memorydata.plugin");
    }
}
