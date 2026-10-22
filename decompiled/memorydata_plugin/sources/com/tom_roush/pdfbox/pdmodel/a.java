package com.tom_roush.pdfbox.pdmodel;

import com.tom_roush.pdfbox.a.l;
import com.tom_roush.pdfbox.pdmodel.font.p;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class a implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<l, SoftReference<p>> f16141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<l, SoftReference<com.tom_roush.pdfbox.pdmodel.graphics.b.b>> f16142b;
    private final Map<l, SoftReference<com.tom_roush.pdfbox.pdmodel.graphics.d>> c;
    private final Map<l, SoftReference<com.tom_roush.pdfbox.pdmodel.graphics.state.a>> d;
    private final Map<l, SoftReference<Object>> e;
    private final Map<l, SoftReference<Object>> f;
    private final Map<l, SoftReference<com.tom_roush.pdfbox.pdmodel.a.b.b>> g;

    public a() {
        this.f16141a = new HashMap();
        this.f16142b = new HashMap();
        this.c = new HashMap();
        this.d = new HashMap();
        this.e = new HashMap();
        this.f = new HashMap();
        this.g = new HashMap();
    }

    @Override // com.tom_roush.pdfbox.pdmodel.k
    public p a(l r2) {
        SoftReference r1 = (SoftReference) ZeusTransformUtils.preCheckCast(this.f16141a.get(r2), SoftReference.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L5;
        return null;
    L5:
        return (p) ZeusTransformUtils.preCheckCast(r1.get(), p.class, "com.obric.memorydata.plugin");
    }

    @Override // com.tom_roush.pdfbox.pdmodel.k
    public void a(l r2, p r3) {
        this.f16141a.put(r2, new SoftReference(r3));
    }

    @Override // com.tom_roush.pdfbox.pdmodel.k
    public void a(l r2, com.tom_roush.pdfbox.pdmodel.graphics.b.b r3) {
        this.f16142b.put(r2, new SoftReference(r3));
    }

    @Override // com.tom_roush.pdfbox.pdmodel.k
    public void a(l r2, com.tom_roush.pdfbox.pdmodel.graphics.d r3) {
        this.c.put(r2, new SoftReference(r3));
    }

    @Override // com.tom_roush.pdfbox.pdmodel.k
    public void a(l r2, com.tom_roush.pdfbox.pdmodel.graphics.state.a r3) {
        this.d.put(r2, new SoftReference(r3));
    }

    @Override // com.tom_roush.pdfbox.pdmodel.k
    public com.tom_roush.pdfbox.pdmodel.graphics.b.b b(l r2) {
        SoftReference r1 = (SoftReference) ZeusTransformUtils.preCheckCast(this.f16142b.get(r2), SoftReference.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L5;
        return null;
    L5:
        return (com.tom_roush.pdfbox.pdmodel.graphics.b.b) ZeusTransformUtils.preCheckCast(r1.get(), com.tom_roush.pdfbox.pdmodel.graphics.b.b.class, "com.obric.memorydata.plugin");
    }

    @Override // com.tom_roush.pdfbox.pdmodel.k
    public com.tom_roush.pdfbox.pdmodel.graphics.state.a c(l r2) {
        SoftReference r1 = (SoftReference) ZeusTransformUtils.preCheckCast(this.d.get(r2), SoftReference.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L5;
        return null;
    L5:
        return (com.tom_roush.pdfbox.pdmodel.graphics.state.a) ZeusTransformUtils.preCheckCast(r1.get(), com.tom_roush.pdfbox.pdmodel.graphics.state.a.class, "com.obric.memorydata.plugin");
    }

    @Override // com.tom_roush.pdfbox.pdmodel.k
    public com.tom_roush.pdfbox.pdmodel.graphics.d d(l r2) {
        SoftReference r1 = (SoftReference) ZeusTransformUtils.preCheckCast(this.c.get(r2), SoftReference.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L5;
        return null;
    L5:
        return (com.tom_roush.pdfbox.pdmodel.graphics.d) ZeusTransformUtils.preCheckCast(r1.get(), com.tom_roush.pdfbox.pdmodel.graphics.d.class, "com.obric.memorydata.plugin");
    }
}
