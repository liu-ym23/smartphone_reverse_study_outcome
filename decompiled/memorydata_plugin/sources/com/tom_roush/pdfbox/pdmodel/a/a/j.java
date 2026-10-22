package com.tom_roush.pdfbox.pdmodel.a.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class j extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f16153a = "UserProperties";

    public j() {
        a(f16153a);
    }

    public j(com.tom_roush.pdfbox.a.d r1) {
        super(r1);
    }

    public void a(k r4) {
        ((com.tom_roush.pdfbox.a.a) ZeusTransformUtils.preCheckCast(a().a(com.tom_roush.pdfbox.a.i.fV), com.tom_roush.pdfbox.a.a.class, "com.obric.memorydata.plugin")).a(r4);
        d();
    }

    public void a(List<k> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        com.tom_roush.pdfbox.a.a r0 = new com.tom_roush.pdfbox.a.a();
        Iterator r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        r0.a((k) ZeusTransformUtils.preCheckCast(r7.next(), k.class, "com.obric.memorydata.plugin"));
        goto L4
    L6:
        a().a(com.tom_roush.pdfbox.a.i.fV, r0);
    }

    public void b(k r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        ((com.tom_roush.pdfbox.a.a) ZeusTransformUtils.preCheckCast(a().a(com.tom_roush.pdfbox.a.i.fV), com.tom_roush.pdfbox.a.a.class, "com.obric.memorydata.plugin")).b(r4.a());
        d();
    }

    public void c(k r1) {
    }

    public List<k> f() {
        com.tom_roush.pdfbox.a.a r0 = (com.tom_roush.pdfbox.a.a) ZeusTransformUtils.preCheckCast(a().a(com.tom_roush.pdfbox.a.i.fV), com.tom_roush.pdfbox.a.a.class, "com.obric.memorydata.plugin");
        ArrayList r1 = new ArrayList(r0.b());
        int r3 = 0;
    L4:
        if (r3 >= r0.b()) goto L6;
        r1.add(new k((com.tom_roush.pdfbox.a.d) ZeusTransformUtils.preCheckCast(r0.a(r3), com.tom_roush.pdfbox.a.d.class, "com.obric.memorydata.plugin"), this));
        r3 = r3 + 1;
        goto L4
    L6:
        return r1;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.a.a.a
    public String toString() {
        return super.toString() + ", userProperties=" + f();
    }
}
