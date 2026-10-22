package com.tom_roush.pdfbox.pdmodel;

import com.tom_roush.pdfbox.a.l;
import com.tom_roush.pdfbox.a.n;
import com.tom_roush.pdfbox.pdmodel.font.p;
import com.tom_roush.pdfbox.pdmodel.font.r;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.SoftReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public final class i implements com.tom_roush.pdfbox.pdmodel.common.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.tom_roush.pdfbox.a.d f16286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final k f16287b;
    private final Map<com.tom_roush.pdfbox.a.i, SoftReference<p>> c;

    public i() {
        this.c = new HashMap();
        this.f16286a = new com.tom_roush.pdfbox.a.d();
        this.f16287b = null;
    }

    public i(com.tom_roush.pdfbox.a.d r2) {
        this.c = new HashMap();
        if (r2 == null) goto L7;
        this.f16286a = r2;
        this.f16287b = null;
        return;
    L7:
        throw new IllegalArgumentException("resourceDictionary is null");
    }

    public i(com.tom_roush.pdfbox.a.d r3, k r4) {
        k r5 = (k) ZeusTransformUtils.wrapperContextForParams(r4, k.class, "com.obric.memorydata.plugin");
        this.c = new HashMap();
        if (r3 == null) goto L7;
        this.f16286a = r3;
        this.f16287b = r5;
        return;
    L7:
        throw new IllegalArgumentException("resourceDictionary is null");
    }

    private l a(com.tom_roush.pdfbox.a.i r1, com.tom_roush.pdfbox.a.i r2) {
        com.tom_roush.pdfbox.a.d r0 = this.f16286a.d(r1);
        if (r0 != null) goto L5;
        return null;
    L5:
        com.tom_roush.pdfbox.a.b r3 = r0.l(r2);
        if (ZeusTransformUtils.instanceOf(r3, l.class) == true) goto L8;
        return null;
    L8:
        return (l) ZeusTransformUtils.preCheckCast(r3, l.class, "com.obric.memorydata.plugin");
    }

    private boolean a(com.tom_roush.pdfbox.pdmodel.graphics.d r3) {
        if (ZeusTransformUtils.instanceOf(r3, com.tom_roush.pdfbox.pdmodel.graphics.d.b.class) == false) goto L24;
        com.tom_roush.pdfbox.a.b r4 = r3.k_().a(com.tom_roush.pdfbox.a.i.bd);
        if (ZeusTransformUtils.instanceOf(r4, com.tom_roush.pdfbox.a.i.class) == false) goto L26;
        com.tom_roush.pdfbox.a.i r5 = (com.tom_roush.pdfbox.a.i) ZeusTransformUtils.preCheckCast(r4, com.tom_roush.pdfbox.a.i.class, "com.obric.memorydata.plugin");
        if (r5.equals(com.tom_roush.pdfbox.a.i.bK) == false) goto L12;
        if (c(com.tom_roush.pdfbox.a.i.bA) == false) goto L12;
        return false;
    L12:
        if (r5.equals(com.tom_roush.pdfbox.a.i.bN) == false) goto L17;
        if (c(com.tom_roush.pdfbox.a.i.bD) == false) goto L17;
        return false;
    L17:
        if (r5.equals(com.tom_roush.pdfbox.a.i.bL) == false) goto L22;
        if (c(com.tom_roush.pdfbox.a.i.bC) == false) goto L22;
        return false;
    L22:
        if (c(r5) == false) goto L27;
        return false;
    L27:
        return true;
    L26:
        return true;
    L24:
        return true;
    }

    private com.tom_roush.pdfbox.a.b b(com.tom_roush.pdfbox.a.i r1, com.tom_roush.pdfbox.a.i r2) {
        com.tom_roush.pdfbox.a.d r0 = this.f16286a.d(r1);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a(r2);
    }

    private Iterable<com.tom_roush.pdfbox.a.i> g(com.tom_roush.pdfbox.a.i r1) {
        com.tom_roush.pdfbox.a.d r0 = this.f16286a.d(r1);
        if (r0 != null) goto L7;
        return Collections.emptySet();
    L7:
        return r0.c();
    }

    public com.tom_roush.pdfbox.a.d a() {
        return this.f16286a;
    }

    public p a(com.tom_roush.pdfbox.a.i r6) {
        l r0 = a(com.tom_roush.pdfbox.a.i.dc, r6);
        k r1 = this.f16287b;
        if (r1 == null) goto L8;
        if (r0 == null) goto L8;
        p r2 = r1.a(r0);
        if (r2 == null) goto L14;
        return r2;
    L14:
        p r3 = null;
        com.tom_roush.pdfbox.a.b r4 = b(com.tom_roush.pdfbox.a.i.dc, r6);
        if (ZeusTransformUtils.instanceOf(r4, com.tom_roush.pdfbox.a.d.class) == false) goto L17;
        r3 = r.a((com.tom_roush.pdfbox.a.d) ZeusTransformUtils.preCheckCast(r4, com.tom_roush.pdfbox.a.d.class, "com.obric.memorydata.plugin"), this.f16287b);
    L17:
        k r5 = this.f16287b;
        if (r5 == null) goto L21;
        if (r0 == null) goto L21;
        r5.a(r0, r3);
    L23:
        return r3;
    L21:
        if (r0 != null) goto L23;
        this.c.put(r6, new SoftReference(r3));
    L8:
        if (r0 != null) goto L14;
        SoftReference r7 = (SoftReference) ZeusTransformUtils.preCheckCast(this.c.get(r6), SoftReference.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L14;
        p r8 = (p) ZeusTransformUtils.preCheckCast(r7.get(), p.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L14;
        return r8;
    }

    public com.tom_roush.pdfbox.pdmodel.graphics.b.b a(com.tom_roush.pdfbox.a.i r3, boolean r4) {
        l r0 = a(com.tom_roush.pdfbox.a.i.bd, r3);
        k r1 = this.f16287b;
        if (r1 == null) goto L8;
        if (r0 == null) goto L8;
        com.tom_roush.pdfbox.pdmodel.graphics.b.b r2 = r1.b(r0);
        if (r2 == null) goto L8;
        return r2;
    L8:
        com.tom_roush.pdfbox.a.b r5 = b(com.tom_roush.pdfbox.a.i.bd, r3);
        if (r5 == null) goto L11;
        com.tom_roush.pdfbox.pdmodel.graphics.b.b r6 = com.tom_roush.pdfbox.pdmodel.graphics.b.b.a(r5, this, r4);
    L12:
        k r7 = this.f16287b;
        if (r7 == null) goto L16;
        if (r0 == null) goto L16;
        r7.a(r0, r6);
    L16:
        return r6;
    L11:
        r6 = com.tom_roush.pdfbox.pdmodel.graphics.b.b.a(r3, this, r4);
        goto L12
    }

    public com.tom_roush.pdfbox.pdmodel.graphics.b.b b(com.tom_roush.pdfbox.a.i r2) {
        return a(r2, false);
    }

    public Iterable<com.tom_roush.pdfbox.a.i> b() {
        return g(com.tom_roush.pdfbox.a.i.ji);
    }

    public k c() {
        return this.f16287b;
    }

    public boolean c(com.tom_roush.pdfbox.a.i r2) {
        if (b(com.tom_roush.pdfbox.a.i.bd, r2) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public com.tom_roush.pdfbox.pdmodel.graphics.state.a d(com.tom_roush.pdfbox.a.i r5) {
        l r0 = a(com.tom_roush.pdfbox.a.i.cI, r5);
        k r1 = this.f16287b;
        if (r1 == null) goto L8;
        if (r0 == null) goto L8;
        com.tom_roush.pdfbox.pdmodel.graphics.state.a r2 = r1.c(r0);
        if (r2 == null) goto L8;
        return r2;
    L8:
        com.tom_roush.pdfbox.pdmodel.graphics.state.a r3 = null;
        com.tom_roush.pdfbox.a.b r6 = b(com.tom_roush.pdfbox.a.i.cI, r5);
        if (ZeusTransformUtils.instanceOf(r6, com.tom_roush.pdfbox.a.d.class) == false) goto L11;
        r3 = new com.tom_roush.pdfbox.pdmodel.graphics.state.a((com.tom_roush.pdfbox.a.d) ZeusTransformUtils.preCheckCast(r6, com.tom_roush.pdfbox.a.d.class, "com.obric.memorydata.plugin"));
    L11:
        k r4 = this.f16287b;
        if (r4 == null) goto L15;
        if (r0 == null) goto L15;
        r4.a(r0, r3);
    L15:
        return r3;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.c
    public /* synthetic */ com.tom_roush.pdfbox.a.b e() {
        return a();
    }

    public boolean e(com.tom_roush.pdfbox.a.i r3) {
        com.tom_roush.pdfbox.a.b r2 = b(com.tom_roush.pdfbox.a.i.ji, r3);
        if (r2 != null) goto L6;
        return false;
    L6:
        if (ZeusTransformUtils.instanceOf(r2, l.class) == false) goto L9;
        r2 = ((l) ZeusTransformUtils.preCheckCast(r2, l.class, "com.obric.memorydata.plugin")).a();
    L9:
        if (ZeusTransformUtils.instanceOf(r2, n.class) == true) goto L11;
        return false;
    L11:
        n r4 = (n) ZeusTransformUtils.preCheckCast(r2, n.class, "com.obric.memorydata.plugin");
        return com.tom_roush.pdfbox.a.i.dR.equals(r4.b(com.tom_roush.pdfbox.a.i.hT));
    }

    public com.tom_roush.pdfbox.pdmodel.graphics.d f(com.tom_roush.pdfbox.a.i r4) {
        l r0 = a(com.tom_roush.pdfbox.a.i.ji, r4);
        k r1 = this.f16287b;
        if (r1 == null) goto L8;
        if (r0 == null) goto L8;
        com.tom_roush.pdfbox.pdmodel.graphics.d r2 = r1.d(r0);
        if (r2 == null) goto L8;
        return r2;
    L8:
        com.tom_roush.pdfbox.a.b r5 = b(com.tom_roush.pdfbox.a.i.ji, r4);
        if (r5 != null) goto L12;
        com.tom_roush.pdfbox.pdmodel.graphics.d r6 = null;
    L16:
        if (this.f16287b == null) goto L21;
        if (r0 == null) goto L21;
        if (a(r6) == false) goto L21;
        this.f16287b.a(r0, r6);
    L21:
        return r6;
    L12:
        if (ZeusTransformUtils.instanceOf(r5, l.class) == false) goto L14;
        r5 = ((l) ZeusTransformUtils.preCheckCast(r5, l.class, "com.obric.memorydata.plugin")).a();
    L14:
        r6 = com.tom_roush.pdfbox.pdmodel.graphics.d.a(r5, this);
        goto L16
    }
}
