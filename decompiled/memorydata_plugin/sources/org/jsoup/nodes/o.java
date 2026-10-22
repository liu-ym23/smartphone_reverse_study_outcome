package org.jsoup.nodes;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes7.dex */
public class o extends i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f18271b;

    private void a(Appendable r10, Document.OutputSettings r11) {
        Appendable r12 = (Appendable) ZeusTransformUtils.wrapperContextForParams(r10, Appendable.class, "com.obric.memorydata.plugin");
        Iterator<a> r0 = p().iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        a r2 = (a) ZeusTransformUtils.preCheckCast(r0.next(), a.class, "com.obric.memorydata.plugin");
        String r3 = r2.a();
        String r4 = r2.b();
        if (r3.equals(a()) == true) goto L4;
        r12.append(' ');
        r12.append(r3);
        if (r4.isEmpty() == true) goto L4;
        r12.append("=\"");
        Entities.a(r12, r4, r11, true, false, false, false);
        r12.append(Typography.quote);
        goto L4
    }

    @Override // org.jsoup.nodes.j
    public String a() {
        return "#declaration";
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
        Appendable r8 = r7.append("<");
        String r1 = "!";
        if (this.f18271b == false) goto L5;
        CharSequence r0 = "!";
    L6:
        r8.append(r0).append(h());
        a(r7, r6);
        if (this.f18271b == true) goto L10;
        r1 = "?";
    L10:
        r7.append(r1).append(">");
        return;
    L5:
        r0 = "?";
        goto L6
    }

    @Override // org.jsoup.nodes.i, org.jsoup.nodes.j
    public /* bridge */ /* synthetic */ j b(String r1) {
        return super.b(r1);
    }

    public o b() {
        return (o) ZeusTransformUtils.preCheckCast(super.d(), o.class, "com.obric.memorydata.plugin");
    }

    @Override // org.jsoup.nodes.j
    void b(Appendable r1, int r2, Document.OutputSettings r3) {
        Appendable r0 = (Appendable) ZeusTransformUtils.wrapperContextForParams(r1, Appendable.class, "com.obric.memorydata.plugin");
    }

    @Override // org.jsoup.nodes.i, org.jsoup.nodes.j
    public /* bridge */ /* synthetic */ boolean c(String r1) {
        return super.c(r1);
    }

    @Override // org.jsoup.nodes.j
    public /* synthetic */ Object clone() {
        return b();
    }

    @Override // org.jsoup.nodes.i, org.jsoup.nodes.j
    public /* bridge */ /* synthetic */ String d(String r1) {
        return super.d(r1);
    }

    @Override // org.jsoup.nodes.j
    public /* synthetic */ j d() {
        return b();
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
