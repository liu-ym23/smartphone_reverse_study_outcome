package com.tom_roush.pdfbox.pdmodel;

import android.util.Log;
import com.tom_roush.pdfbox.a.n;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class g implements com.tom_roush.pdfbox.contentstream.a, com.tom_roush.pdfbox.pdmodel.common.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.tom_roush.pdfbox.a.d f16254a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private i f16255b;
    private k c;
    private com.tom_roush.pdfbox.pdmodel.common.h d;

    public g() {
        this(com.tom_roush.pdfbox.pdmodel.common.h.f16189a);
    }

    public g(com.tom_roush.pdfbox.a.d r1) {
        this.f16254a = r1;
    }

    g(com.tom_roush.pdfbox.a.d r3, k r4) {
        k r5 = (k) ZeusTransformUtils.wrapperContextForParams(r4, k.class, "com.obric.memorydata.plugin");
        this.f16254a = r3;
        this.c = r5;
    }

    public g(com.tom_roush.pdfbox.pdmodel.common.h r3) {
        com.tom_roush.pdfbox.a.d r0 = new com.tom_roush.pdfbox.a.d();
        this.f16254a = r0;
        r0.a(com.tom_roush.pdfbox.a.i.iz, com.tom_roush.pdfbox.a.i.fW);
        r0.a(com.tom_roush.pdfbox.a.i.eW, r3);
    }

    private com.tom_roush.pdfbox.pdmodel.common.h a(com.tom_roush.pdfbox.pdmodel.common.h r4) {
        com.tom_roush.pdfbox.pdmodel.common.h r3 = g();
        com.tom_roush.pdfbox.pdmodel.common.h r0 = new com.tom_roush.pdfbox.pdmodel.common.h();
        r0.a(Math.max(r3.b(), r4.b()));
        r0.b(Math.max(r3.c(), r4.c()));
        r0.c(Math.min(r3.d(), r4.d()));
        r0.d(Math.min(r3.f(), r4.f()));
        return r0;
    }

    @Override // com.tom_roush.pdfbox.contentstream.a
    public InputStream a() {
        com.tom_roush.pdfbox.a.b r6 = this.f16254a.a(com.tom_roush.pdfbox.a.i.bi);
        if (ZeusTransformUtils.instanceOf(r6, n.class) == true) goto L5;
        int r2 = 0;
        if (ZeusTransformUtils.instanceOf(r6, com.tom_roush.pdfbox.a.a.class) == false) goto L20;
        if (((com.tom_roush.pdfbox.a.a) ZeusTransformUtils.preCheckCast(r6, com.tom_roush.pdfbox.a.a.class, "com.obric.memorydata.plugin")).b() <= 0) goto L20;
        com.tom_roush.pdfbox.a.a r7 = (com.tom_roush.pdfbox.a.a) ZeusTransformUtils.preCheckCast(r6, com.tom_roush.pdfbox.a.a.class, "com.obric.memorydata.plugin");
        byte[] r0 = {10};
        ArrayList r3 = new ArrayList();
    L12:
        if (r2 >= r7.b()) goto L18;
        com.tom_roush.pdfbox.a.b r4 = r7.a(r2);
        if (ZeusTransformUtils.instanceOf(r4, n.class) == false) goto L16;
        r3.add(((n) ZeusTransformUtils.preCheckCast(r4, n.class, "com.obric.memorydata.plugin")).h());
        r3.add(new ByteArrayInputStream(r0));
    L16:
        r2 = r2 + 1;
        goto L12
    L18:
        return new SequenceInputStream(Collections.enumeration(r3));
    L20:
        return new ByteArrayInputStream(new byte[0]);
    L5:
        return ((n) ZeusTransformUtils.preCheckCast(r6, n.class, "com.obric.memorydata.plugin")).h();
    }

    @Override // com.tom_roush.pdfbox.contentstream.a
    public com.tom_roush.pdfbox.pdmodel.common.h b() {
        return h();
    }

    @Override // com.tom_roush.pdfbox.contentstream.a
    public com.tom_roush.pdfbox.util.c c() {
        return new com.tom_roush.pdfbox.util.c();
    }

    public com.tom_roush.pdfbox.a.d d() {
        return this.f16254a;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.c
    public /* synthetic */ com.tom_roush.pdfbox.a.b e() {
        return d();
    }

    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, g.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (((g) ZeusTransformUtils.preCheckCast(r3, g.class, "com.obric.memorydata.plugin")).d() != d()) goto L7;
        return true;
    }

    public boolean f() {
        com.tom_roush.pdfbox.a.b r4 = this.f16254a.a(com.tom_roush.pdfbox.a.i.bi);
        if (ZeusTransformUtils.instanceOf(r4, n.class) == false) goto L10;
        if (((n) ZeusTransformUtils.preCheckCast(r4, n.class, "com.obric.memorydata.plugin")).a() <= 0) goto L8;
        return true;
    L8:
        return false;
    L10:
        if (ZeusTransformUtils.instanceOf(r4, com.tom_roush.pdfbox.a.a.class) == true) goto L12;
        return false;
    L12:
        if (((com.tom_roush.pdfbox.a.a) ZeusTransformUtils.preCheckCast(r4, com.tom_roush.pdfbox.a.a.class, "com.obric.memorydata.plugin")).b() <= 0) goto L15;
        return true;
    L15:
        return false;
    }

    public com.tom_roush.pdfbox.pdmodel.common.h g() {
        if (this.d != null) goto L9;
        com.tom_roush.pdfbox.a.b r0 = h.a(this.f16254a, com.tom_roush.pdfbox.a.i.eW);
        if (ZeusTransformUtils.instanceOf(r0, com.tom_roush.pdfbox.a.a.class) == false) goto L7;
        this.d = new com.tom_roush.pdfbox.pdmodel.common.h((com.tom_roush.pdfbox.a.a) ZeusTransformUtils.preCheckCast(r0, com.tom_roush.pdfbox.a.a.class, "com.obric.memorydata.plugin"));
        goto L9
    L7:
        Log.d("PdfBox-Android", "Can't find MediaBox, will use U.S. Letter");
        this.d = com.tom_roush.pdfbox.pdmodel.common.h.f16189a;
    L9:
        return this.d;
    }

    @Override // com.tom_roush.pdfbox.contentstream.a
    public i getResources() {
        if (this.f16255b != null) goto L8;
        com.tom_roush.pdfbox.a.b r0 = h.a(this.f16254a, com.tom_roush.pdfbox.a.i.gU);
        if (ZeusTransformUtils.instanceOf(r0, com.tom_roush.pdfbox.a.d.class) == false) goto L8;
        this.f16255b = new i((com.tom_roush.pdfbox.a.d) ZeusTransformUtils.preCheckCast(r0, com.tom_roush.pdfbox.a.d.class, "com.obric.memorydata.plugin"), this.c);
    L8:
        return this.f16255b;
    }

    public com.tom_roush.pdfbox.pdmodel.common.h h() {
        com.tom_roush.pdfbox.a.b r0 = h.a(this.f16254a, com.tom_roush.pdfbox.a.i.bo);
        if (ZeusTransformUtils.instanceOf(r0, com.tom_roush.pdfbox.a.a.class) == false) goto L7;
        return a(new com.tom_roush.pdfbox.pdmodel.common.h((com.tom_roush.pdfbox.a.a) ZeusTransformUtils.preCheckCast(r0, com.tom_roush.pdfbox.a.a.class, "com.obric.memorydata.plugin")));
    L7:
        return g();
    }

    public int hashCode() {
        return this.f16254a.hashCode();
    }

    public int i() {
        com.tom_roush.pdfbox.a.b r2 = h.a(this.f16254a, com.tom_roush.pdfbox.a.i.gZ);
        if (ZeusTransformUtils.instanceOf(r2, com.tom_roush.pdfbox.a.k.class) == false) goto L8;
        int r3 = ((com.tom_roush.pdfbox.a.k) ZeusTransformUtils.preCheckCast(r2, com.tom_roush.pdfbox.a.k.class, "com.obric.memorydata.plugin")).c();
        if ((r3 % 90) == 0) goto L7;
        return 0;
    L7:
        return ((r3 % 360) + 360) % 360;
    L8:
        return 0;
    }

    public List<com.tom_roush.pdfbox.pdmodel.interactive.pagenavigation.a> j() {
        com.tom_roush.pdfbox.a.a r6 = (com.tom_roush.pdfbox.a.a) ZeusTransformUtils.preCheckCast(this.f16254a.a(com.tom_roush.pdfbox.a.i.N), com.tom_roush.pdfbox.a.a.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
        r6 = new com.tom_roush.pdfbox.a.a();
    L5:
        ArrayList r0 = new ArrayList(r6.b());
        int r2 = 0;
    L7:
        if (r2 >= r6.b()) goto L13;
        com.tom_roush.pdfbox.a.b r3 = r6.a(r2);
        com.tom_roush.pdfbox.pdmodel.interactive.pagenavigation.a r4 = null;
        if (ZeusTransformUtils.instanceOf(r3, com.tom_roush.pdfbox.a.d.class) == false) goto L11;
        r4 = new com.tom_roush.pdfbox.pdmodel.interactive.pagenavigation.a((com.tom_roush.pdfbox.a.d) ZeusTransformUtils.preCheckCast(r3, com.tom_roush.pdfbox.a.d.class, "com.obric.memorydata.plugin"));
    L11:
        r0.add(r4);
        r2 = r2 + 1;
        goto L7
    L13:
        return new com.tom_roush.pdfbox.pdmodel.common.a(r0, r6);
    }
}
