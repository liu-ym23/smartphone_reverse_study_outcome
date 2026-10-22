package com.tom_roush.pdfbox.pdmodel.a.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public abstract class h implements com.tom_roush.pdfbox.pdmodel.common.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.tom_roush.pdfbox.a.d f16151a;

    public h(com.tom_roush.pdfbox.a.d r1) {
        this.f16151a = r1;
    }

    public h(String r2) {
        com.tom_roush.pdfbox.a.d r0 = new com.tom_roush.pdfbox.a.d();
        this.f16151a = r0;
        r0.a(com.tom_roush.pdfbox.a.i.iz, r2);
    }

    public static h a(com.tom_roush.pdfbox.a.d r2) {
        String r0 = r2.g(com.tom_roush.pdfbox.a.i.iz);
        if ("StructTreeRoot".equals(r0) == true) goto L5;
        if (r0 == null) goto L13;
        if (g.f16150a.equals(r0) == true) goto L13;
        throw new IllegalArgumentException("Dictionary must not include a Type entry with a value that is neither StructTreeRoot nor StructElem.");
    L13:
        return new g(r2);
    L5:
        return new i(r2);
    }

    private com.tom_roush.pdfbox.pdmodel.common.c b(com.tom_roush.pdfbox.a.d r2) {
        String r1 = r2.g(com.tom_roush.pdfbox.a.i.iz);
        if (r1 == null) goto L18;
        if (g.f16150a.equals(r1) == true) goto L18;
        if (e.f16147a.equals(r1) == false) goto L12;
        return new e(r2);
    L12:
        if (d.f16145a.equals(r1) == true) goto L14;
        return null;
    L14:
        return new d(r2);
    L18:
        return new g(r2);
    }

    public void a(com.tom_roush.pdfbox.a.b r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        com.tom_roush.pdfbox.a.b r0 = p().a(com.tom_roush.pdfbox.a.i.ei);
        if (r0 != null) goto L8;
        p().a(com.tom_roush.pdfbox.a.i.ei, r3);
        return;
    L8:
        if (ZeusTransformUtils.instanceOf(r0, com.tom_roush.pdfbox.a.a.class) == false) goto L10;
        ((com.tom_roush.pdfbox.a.a) ZeusTransformUtils.preCheckCast(r0, com.tom_roush.pdfbox.a.a.class, "com.obric.memorydata.plugin")).a(r3);
        return;
    L10:
        com.tom_roush.pdfbox.a.a r1 = new com.tom_roush.pdfbox.a.a();
        r1.a(r0);
        r1.a(r3);
        p().a(com.tom_roush.pdfbox.a.i.ei, r1);
    }

    public void a(com.tom_roush.pdfbox.a.b r5, Object r6) {
        if (r5 == null) goto L22;
        if (r6 == null) goto L25;
        com.tom_roush.pdfbox.a.b r0 = p().a(com.tom_roush.pdfbox.a.i.ei);
        if (r0 != null) goto L8;
        return;
    L8:
        com.tom_roush.pdfbox.a.b r1 = null;
        if (ZeusTransformUtils.instanceOf(r6, com.tom_roush.pdfbox.pdmodel.common.c.class) == false) goto L12;
        r1 = ((com.tom_roush.pdfbox.pdmodel.common.c) ZeusTransformUtils.preCheckCast(r6, com.tom_roush.pdfbox.pdmodel.common.c.class, "com.obric.memorydata.plugin")).e();
    L12:
        if (ZeusTransformUtils.instanceOf(r0, com.tom_roush.pdfbox.a.a.class) == false) goto L14;
        com.tom_roush.pdfbox.a.a r4 = (com.tom_roush.pdfbox.a.a) ZeusTransformUtils.preCheckCast(r0, com.tom_roush.pdfbox.a.a.class, "com.obric.memorydata.plugin");
        r4.a(r4.d(r1), r5.e());
        return;
    L14:
        boolean r7 = r0.equals(r1);
        if (r7 == false) goto L17;
    L19:
        if (r7 == false) goto L24;
        com.tom_roush.pdfbox.a.a r8 = new com.tom_roush.pdfbox.a.a();
        r8.a(r5);
        r8.a(r1);
        p().a(com.tom_roush.pdfbox.a.i.ei, r8);
        return;
    L24:
        return;
    L17:
        if (ZeusTransformUtils.instanceOf(r0, com.tom_roush.pdfbox.a.l.class) == false) goto L19;
        r7 = ((com.tom_roush.pdfbox.a.l) ZeusTransformUtils.preCheckCast(r0, com.tom_roush.pdfbox.a.l.class, "com.obric.memorydata.plugin")).a().equals(r1);
        goto L19
    L25:
        return;
    }

    public void a(g r1) {
        a(r1);
        r1.a(this);
    }

    public void a(g r1, Object r2) {
        a(r1, r2);
    }

    public void a(com.tom_roush.pdfbox.pdmodel.common.c r3) {
        com.tom_roush.pdfbox.pdmodel.common.c r4 = (com.tom_roush.pdfbox.pdmodel.common.c) ZeusTransformUtils.wrapperContextForParams(r3, com.tom_roush.pdfbox.pdmodel.common.c.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        a(r4.e());
    }

    public void a(com.tom_roush.pdfbox.pdmodel.common.c r3, Object r4) {
        com.tom_roush.pdfbox.pdmodel.common.c r5 = (com.tom_roush.pdfbox.pdmodel.common.c) ZeusTransformUtils.wrapperContextForParams(r3, com.tom_roush.pdfbox.pdmodel.common.c.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        return;
    L5:
        a(r5.e(), r4);
    }

    public void a(List<Object> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        p().a(com.tom_roush.pdfbox.a.i.ei, com.tom_roush.pdfbox.pdmodel.common.a.a(r4));
    }

    public boolean b(com.tom_roush.pdfbox.a.b r7) {
        if (r7 != null) goto L5;
        return false;
    L5:
        com.tom_roush.pdfbox.a.b r1 = p().a(com.tom_roush.pdfbox.a.i.ei);
        if (r1 != null) goto L9;
        return false;
    L9:
        if (ZeusTransformUtils.instanceOf(r1, com.tom_roush.pdfbox.a.a.class) == false) goto L14;
        com.tom_roush.pdfbox.a.a r2 = (com.tom_roush.pdfbox.a.a) ZeusTransformUtils.preCheckCast(r1, com.tom_roush.pdfbox.a.a.class, "com.obric.memorydata.plugin");
        boolean r8 = r2.c(r7);
        if (r2.b() != 1) goto L13;
        p().a(com.tom_roush.pdfbox.a.i.ei, r2.a(0));
    L13:
        return r8;
    L14:
        boolean r3 = r1.equals(r7);
        if (r3 == false) goto L17;
    L19:
        if (r3 == false) goto L22;
        p().a(com.tom_roush.pdfbox.a.i.ei, null);
        return true;
    L22:
        return false;
    L17:
        if (ZeusTransformUtils.instanceOf(r1, com.tom_roush.pdfbox.a.l.class) == false) goto L19;
        r3 = ((com.tom_roush.pdfbox.a.l) ZeusTransformUtils.preCheckCast(r1, com.tom_roush.pdfbox.a.l.class, "com.obric.memorydata.plugin")).a().equals(r7);
        goto L19
    }

    public boolean b(g r2) {
        boolean r1 = b(r2);
        if (r1 == false) goto L5;
        r2.a(null);
    L5:
        return r1;
    }

    public boolean b(com.tom_roush.pdfbox.pdmodel.common.c r3) {
        com.tom_roush.pdfbox.pdmodel.common.c r4 = (com.tom_roush.pdfbox.pdmodel.common.c) ZeusTransformUtils.wrapperContextForParams(r3, com.tom_roush.pdfbox.pdmodel.common.c.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L7;
        return false;
    L7:
        return b(r4.e());
    }

    public Object c(com.tom_roush.pdfbox.a.b r5) {
        if (ZeusTransformUtils.instanceOf(r5, com.tom_roush.pdfbox.a.d.class) == false) goto L7;
        Object r0 = ZeusTransformUtils.preCheckCast(r5, com.tom_roush.pdfbox.a.d.class, "com.obric.memorydata.plugin");
    L5:
        com.tom_roush.pdfbox.a.d r1 = (com.tom_roush.pdfbox.a.d) r0;
    L12:
        if (r1 == null) goto L16;
        return b(r1);
    L16:
        if (ZeusTransformUtils.instanceOf(r5, com.tom_roush.pdfbox.a.h.class) == true) goto L18;
        return null;
    L18:
        return Integer.valueOf(((com.tom_roush.pdfbox.a.h) ZeusTransformUtils.preCheckCast(r5, com.tom_roush.pdfbox.a.h.class, "com.obric.memorydata.plugin")).c());
    L7:
        if (ZeusTransformUtils.instanceOf(r5, com.tom_roush.pdfbox.a.l.class) == false) goto L11;
        com.tom_roush.pdfbox.a.b r2 = ((com.tom_roush.pdfbox.a.l) ZeusTransformUtils.preCheckCast(r5, com.tom_roush.pdfbox.a.l.class, "com.obric.memorydata.plugin")).a();
        if (ZeusTransformUtils.instanceOf(r2, com.tom_roush.pdfbox.a.d.class) == false) goto L11;
        r0 = ZeusTransformUtils.preCheckCast(r2, com.tom_roush.pdfbox.a.d.class, "com.obric.memorydata.plugin");
    L11:
        r1 = null;
        goto L12
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.c
    public /* synthetic */ com.tom_roush.pdfbox.a.b e() {
        return p();
    }

    public String getType() {
        return p().g(com.tom_roush.pdfbox.a.i.iz);
    }

    public com.tom_roush.pdfbox.a.d p() {
        return this.f16151a;
    }

    public List<Object> q() {
        ArrayList r0 = new ArrayList();
        com.tom_roush.pdfbox.a.b r1 = p().a(com.tom_roush.pdfbox.a.i.ei);
        if (ZeusTransformUtils.instanceOf(r1, com.tom_roush.pdfbox.a.a.class) == false) goto L10;
        Iterator<com.tom_roush.pdfbox.a.b> r2 = ((com.tom_roush.pdfbox.a.a) ZeusTransformUtils.preCheckCast(r1, com.tom_roush.pdfbox.a.a.class, "com.obric.memorydata.plugin")).iterator();
    L6:
        if (r2.hasNext() == false) goto L13;
        Object r3 = c((com.tom_roush.pdfbox.a.b) ZeusTransformUtils.preCheckCast(r2.next(), com.tom_roush.pdfbox.a.b.class, "com.obric.memorydata.plugin"));
        if (r3 == null) goto L6;
        r0.add(r3);
    L13:
        return r0;
    L10:
        Object r5 = c(r1);
        if (r5 == null) goto L13;
        r0.add(r5);
        goto L13
    }
}
