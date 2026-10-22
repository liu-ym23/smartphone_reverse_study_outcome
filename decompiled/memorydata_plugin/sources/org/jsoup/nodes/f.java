package org.jsoup.nodes;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes7.dex */
public class f extends i {
    public f(String r2, String r3, String r4) {
        org.jsoup.helper.b.a(r2);
        org.jsoup.helper.b.a(r3);
        org.jsoup.helper.b.a(r4);
        a(ActivityLifecycle.NAME, r2);
        a("publicId", r3);
        a("systemId", r4);
        b();
    }

    private void b() {
        if (f("publicId") == false) goto L7;
        String r0 = "PUBLIC";
    L5:
        a("pubSysKey", r0);
        return;
    L7:
        if (f("systemId") == false) goto L10;
        r0 = "SYSTEM";
        goto L5
    }

    private boolean f(String r1) {
        return !org.jsoup.a.b.a(d(r1));
    }

    @Override // org.jsoup.nodes.j
    public String a() {
        return "#doctype";
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
        if (this.e <= 0) goto L8;
        if (r6.e() == false) goto L8;
        r7.append('\n');
    L8:
        if (r6.d() == Document.OutputSettings.Syntax.html) goto L10;
    L14:
        String r8 = "<!DOCTYPE";
    L15:
        r7.append(r8);
        if (f(ActivityLifecycle.NAME) == false) goto L19;
        r7.append(" ").append(d(ActivityLifecycle.NAME));
    L19:
        if (f("pubSysKey") == false) goto L22;
        r7.append(" ").append(d("pubSysKey"));
    L22:
        if (f("publicId") == false) goto L25;
        r7.append(" \"").append(d("publicId")).append(Typography.quote);
    L25:
        if (f("systemId") == false) goto L27;
        r7.append(" \"").append(d("systemId")).append(Typography.quote);
    L27:
        r7.append(Typography.greater);
        return;
    L10:
        if (f("publicId") == true) goto L14;
        if (f("systemId") == true) goto L14;
        r8 = "<!doctype";
        goto L15
    }

    @Override // org.jsoup.nodes.i, org.jsoup.nodes.j
    public /* bridge */ /* synthetic */ j b(String r1) {
        return super.b(r1);
    }

    @Override // org.jsoup.nodes.j
    void b(Appendable r1, int r2, Document.OutputSettings r3) {
        Appendable r0 = (Appendable) ZeusTransformUtils.wrapperContextForParams(r1, Appendable.class, "com.obric.memorydata.plugin");
    }

    @Override // org.jsoup.nodes.i, org.jsoup.nodes.j
    public /* bridge */ /* synthetic */ boolean c(String r1) {
        return super.c(r1);
    }

    @Override // org.jsoup.nodes.i, org.jsoup.nodes.j
    public /* bridge */ /* synthetic */ String d(String r1) {
        return super.d(r1);
    }

    @Override // org.jsoup.nodes.i, org.jsoup.nodes.j
    public /* bridge */ /* synthetic */ j e() {
        return super.e();
    }

    public void e(String r2) {
        if (r2 == null) goto L5;
        a("pubSysKey", r2);
        return;
    }

    @Override // org.jsoup.nodes.i, org.jsoup.nodes.j
    public /* bridge */ /* synthetic */ int f() {
        return super.f();
    }

    @Override // org.jsoup.nodes.i, org.jsoup.nodes.j
    public /* bridge */ /* synthetic */ String g() {
        return super.g();
    }
}
