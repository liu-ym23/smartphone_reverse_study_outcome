package com.tom_roush.pdfbox.pdmodel.font;

import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class ac implements com.tom_roush.pdfbox.contentstream.a, com.tom_roush.pdfbox.pdmodel.common.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ad f16219a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.tom_roush.pdfbox.a.n f16220b;

    public ac(ad r1, com.tom_roush.pdfbox.a.n r2) {
        this.f16219a = r1;
        this.f16220b = r2;
    }

    private float a(com.tom_roush.pdfbox.contentstream.operator.b r3, List<com.tom_roush.pdfbox.a.b> r4) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if (r3.a().equals("d0") == false) goto L5;
    L9:
        com.tom_roush.pdfbox.a.b r5 = (com.tom_roush.pdfbox.a.b) ZeusTransformUtils.preCheckCast(r2.get(0), com.tom_roush.pdfbox.a.b.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, com.tom_roush.pdfbox.a.k.class) == false) goto L14;
        return ((com.tom_roush.pdfbox.a.k) ZeusTransformUtils.preCheckCast(r5, com.tom_roush.pdfbox.a.k.class, "com.obric.memorydata.plugin")).a();
    L14:
        throw new IOException("Unexpected argument type: " + r5.getClass().getName());
    L5:
        if (r3.a().equals("d1") == true) goto L9;
        throw new IOException("First operator must be d0 or d1");
    }

    @Override // com.tom_roush.pdfbox.contentstream.a
    public InputStream a() {
        return this.f16220b.h();
    }

    @Override // com.tom_roush.pdfbox.contentstream.a
    public com.tom_roush.pdfbox.pdmodel.common.h b() {
        return this.f16219a.u();
    }

    @Override // com.tom_roush.pdfbox.contentstream.a
    public com.tom_roush.pdfbox.util.c c() {
        return this.f16219a.i();
    }

    public com.tom_roush.pdfbox.a.n d() {
        return this.f16220b;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.c
    public /* synthetic */ com.tom_roush.pdfbox.a.b e() {
        return d();
    }

    public com.tom_roush.pdfbox.pdmodel.common.i f() {
        return new com.tom_roush.pdfbox.pdmodel.common.i(this.f16220b);
    }

    public com.tom_roush.pdfbox.pdmodel.common.h g() {
        ArrayList r0 = new ArrayList();
        com.tom_roush.pdfbox.pdfparser.g r1 = new com.tom_roush.pdfbox.pdfparser.g(this);
    L3:
        Object r6 = r1.r();
        if (r6 == null) goto L20;
        if (ZeusTransformUtils.instanceOf(r6, com.tom_roush.pdfbox.contentstream.operator.b.class) == true) goto L8;
        r0.add((com.tom_roush.pdfbox.a.b) ZeusTransformUtils.preCheckCast(r6, com.tom_roush.pdfbox.a.b.class, "com.obric.memorydata.plugin"));
        goto L3
    L8:
        if (((com.tom_roush.pdfbox.contentstream.operator.b) ZeusTransformUtils.preCheckCast(r6, com.tom_roush.pdfbox.contentstream.operator.b.class, "com.obric.memorydata.plugin")).a().equals("d1") == true) goto L10;
        return null;
    L10:
        if (r0.size() != 6) goto L26;
        int r7 = 0;
    L12:
        if (r7 >= 6) goto L17;
        if (ZeusTransformUtils.instanceOf(r0.get(r7), com.tom_roush.pdfbox.a.k.class) == false) goto L15;
        r7 = r7 + 1;
        goto L12
    L15:
        return null;
    L17:
        float r8 = ((com.tom_roush.pdfbox.a.k) ZeusTransformUtils.preCheckCast(r0.get(2), com.tom_roush.pdfbox.a.k.class, "com.obric.memorydata.plugin")).a();
        float r2 = ((com.tom_roush.pdfbox.a.k) ZeusTransformUtils.preCheckCast(r0.get(3), com.tom_roush.pdfbox.a.k.class, "com.obric.memorydata.plugin")).a();
        return new com.tom_roush.pdfbox.pdmodel.common.h(r8, r2, ((com.tom_roush.pdfbox.a.k) ZeusTransformUtils.preCheckCast(r0.get(4), com.tom_roush.pdfbox.a.k.class, "com.obric.memorydata.plugin")).a() - r8, ((com.tom_roush.pdfbox.a.k) ZeusTransformUtils.preCheckCast(r0.get(5), com.tom_roush.pdfbox.a.k.class, "com.obric.memorydata.plugin")).a() - r2);
    L26:
        return null;
    L20:
        return null;
    }

    @Override // com.tom_roush.pdfbox.contentstream.a
    public com.tom_roush.pdfbox.pdmodel.i getResources() {
        if (this.f16220b.m(com.tom_roush.pdfbox.a.i.gU) == false) goto L7;
        Log.w("PdfBox-Android", "Using resources dictionary found in charproc entry");
        Log.w("PdfBox-Android", "This should have been in the font or in the page dictionary");
        return new com.tom_roush.pdfbox.pdmodel.i((com.tom_roush.pdfbox.a.d) ZeusTransformUtils.preCheckCast(this.f16220b.a(com.tom_roush.pdfbox.a.i.gU), com.tom_roush.pdfbox.a.d.class, "com.obric.memorydata.plugin"));
    L7:
        return this.f16219a.getResources();
    }

    public float h() {
        ArrayList r0 = new ArrayList();
        com.tom_roush.pdfbox.pdfparser.g r1 = new com.tom_roush.pdfbox.pdfparser.g(this);
    L3:
        Object r2 = r1.r();
        if (r2 == null) goto L11;
        if (ZeusTransformUtils.instanceOf(r2, com.tom_roush.pdfbox.contentstream.operator.b.class) == true) goto L8;
        r0.add((com.tom_roush.pdfbox.a.b) ZeusTransformUtils.preCheckCast(r2, com.tom_roush.pdfbox.a.b.class, "com.obric.memorydata.plugin"));
        goto L3
    L8:
        return a((com.tom_roush.pdfbox.contentstream.operator.b) ZeusTransformUtils.preCheckCast(r2, com.tom_roush.pdfbox.contentstream.operator.b.class, "com.obric.memorydata.plugin"), r0);
    L11:
        throw new IOException("Unexpected end of stream");
    }
}
