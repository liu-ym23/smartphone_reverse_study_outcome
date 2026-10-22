package com.tom_roush.pdfbox.pdmodel.a.a;

import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class i extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f16152a = "StructTreeRoot";

    public i() {
        super(f16152a);
    }

    public i(com.tom_roush.pdfbox.a.d r1) {
        super(r1);
    }

    @Deprecated
    public com.tom_roush.pdfbox.a.a a() {
        com.tom_roush.pdfbox.a.b r2 = p().a(com.tom_roush.pdfbox.a.i.ei);
        if (ZeusTransformUtils.instanceOf(r2, com.tom_roush.pdfbox.a.d.class) == false) goto L9;
        r2 = ((com.tom_roush.pdfbox.a.d) ZeusTransformUtils.preCheckCast(r2, com.tom_roush.pdfbox.a.d.class, "com.obric.memorydata.plugin")).a(com.tom_roush.pdfbox.a.i.ei);
        if (ZeusTransformUtils.instanceOf(r2, com.tom_roush.pdfbox.a.a.class) == true) goto L7;
        return null;
    L7:
        return (com.tom_roush.pdfbox.a.a) ZeusTransformUtils.preCheckCast(r2, com.tom_roush.pdfbox.a.a.class, "com.obric.memorydata.plugin");
    L9:
        if (ZeusTransformUtils.instanceOf(r2, com.tom_roush.pdfbox.a.a.class) == true) goto L7;
        return null;
    }

    public void a(int r2) {
        p().a(com.tom_roush.pdfbox.a.i.gg, r2);
    }

    public void a(com.tom_roush.pdfbox.pdmodel.common.f<g> r2) {
        p().a(com.tom_roush.pdfbox.a.i.dK, r2);
    }

    public void a(com.tom_roush.pdfbox.pdmodel.common.g r2) {
        p().a(com.tom_roush.pdfbox.a.i.gf, r2);
    }

    public void a(Map<String, String> r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        com.tom_roush.pdfbox.a.d r0 = new com.tom_roush.pdfbox.a.d();
        Iterator r8 = r7.entrySet().iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r0.a((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r2.getValue(), String.class, "com.obric.memorydata.plugin"));
        goto L4
    L6:
        p().a(com.tom_roush.pdfbox.a.i.gX, r0);
    }

    public com.tom_roush.pdfbox.a.b b() {
        return p().a(com.tom_roush.pdfbox.a.i.ei);
    }

    public com.tom_roush.pdfbox.pdmodel.common.f<g> c() {
        com.tom_roush.pdfbox.a.b r3 = p().a(com.tom_roush.pdfbox.a.i.dK);
        if (ZeusTransformUtils.instanceOf(r3, com.tom_roush.pdfbox.a.d.class) == true) goto L5;
        return null;
    L5:
        return new com.tom_roush.pdfbox.pdmodel.j((com.tom_roush.pdfbox.a.d) ZeusTransformUtils.preCheckCast(r3, com.tom_roush.pdfbox.a.d.class, "com.obric.memorydata.plugin"));
    }

    public com.tom_roush.pdfbox.pdmodel.common.g d() {
        com.tom_roush.pdfbox.a.b r3 = p().a(com.tom_roush.pdfbox.a.i.gf);
        if (ZeusTransformUtils.instanceOf(r3, com.tom_roush.pdfbox.a.d.class) == true) goto L5;
        return null;
    L5:
        return new com.tom_roush.pdfbox.pdmodel.common.g((com.tom_roush.pdfbox.a.d) ZeusTransformUtils.preCheckCast(r3, com.tom_roush.pdfbox.a.d.class, "com.obric.memorydata.plugin"), f.class);
    }

    public void d(com.tom_roush.pdfbox.a.b r2) {
        p().a(com.tom_roush.pdfbox.a.i.ei, r2);
    }

    public int f() {
        return p().i(com.tom_roush.pdfbox.a.i.gg);
    }

    public Map<String, Object> g() {
        com.tom_roush.pdfbox.a.b r2 = p().a(com.tom_roush.pdfbox.a.i.gX);
        if (ZeusTransformUtils.instanceOf(r2, com.tom_roush.pdfbox.a.d.class) == false) goto L9;
        return com.tom_roush.pdfbox.pdmodel.common.b.a((com.tom_roush.pdfbox.a.d) ZeusTransformUtils.preCheckCast(r2, com.tom_roush.pdfbox.a.d.class, "com.obric.memorydata.plugin"));
    L6:
        e = move-exception;
        Log.e("PdfBox-Android", e.getMessage(), e);
    L9:
        return new HashMap();
    }
}
