package com.tom_roush.pdfbox.pdmodel.font;

import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes6.dex */
public abstract class p implements com.tom_roush.pdfbox.pdmodel.common.c, s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final com.tom_roush.pdfbox.util.c f16247a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final com.tom_roush.pdfbox.a.d f16248b;
    private final com.tom_roush.fontbox.c.b c;
    private final com.tom_roush.fontbox.a.e d;
    private q e;
    private List<Float> f;
    private float g;
    private float h;
    private final Map<Integer, Float> i;

    static {
        f16247a = new com.tom_roush.pdfbox.util.c(0.001f, 0.0f, 0.0f, 0.001f, 0.0f, 0.0f);
    }

    p() {
        this.h = -1.0f;
        com.tom_roush.pdfbox.a.d r0 = new com.tom_roush.pdfbox.a.d();
        this.f16248b = r0;
        r0.a(com.tom_roush.pdfbox.a.i.iz, com.tom_roush.pdfbox.a.i.dc);
        this.c = null;
        this.e = null;
        this.d = null;
        this.i = new HashMap();
    }

    public p(com.tom_roush.pdfbox.a.d r2) {
        this.h = -1.0f;
        this.f16248b = r2;
        this.i = new HashMap();
        this.d = ae.a(c());
        this.e = n();
        this.c = o();
    }

    p(String r4) {
        this.h = -1.0f;
        com.tom_roush.pdfbox.a.d r0 = new com.tom_roush.pdfbox.a.d();
        this.f16248b = r0;
        r0.a(com.tom_roush.pdfbox.a.i.iz, com.tom_roush.pdfbox.a.i.dc);
        this.c = null;
        com.tom_roush.fontbox.a.e r1 = ae.a(r4);
        this.d = r1;
        if (r1 == null) goto L7;
        this.e = ab.a(r1);
        this.i = new ConcurrentHashMap();
        return;
    L7:
        throw new IllegalArgumentException("No AFM for font " + r4);
    }

    private q n() {
        com.tom_roush.pdfbox.a.d r0 = this.f16248b.d(com.tom_roush.pdfbox.a.i.de);
        if (r0 != null) goto L5;
        com.tom_roush.fontbox.a.e r2 = this.d;
        if (r2 != null) goto L9;
        return null;
    L9:
        return ab.a(r2);
    L5:
        return new q(r0);
    }

    private com.tom_roush.fontbox.c.b o() {
        com.tom_roush.pdfbox.a.b r2 = this.f16248b.a(com.tom_roush.pdfbox.a.i.il);
        com.tom_roush.fontbox.c.b r3 = null;
        if (r2 != null) goto L30;
        return null;
    L30:
        com.tom_roush.fontbox.c.b r4 = a(r2);     // Catch: IOException -> L27
        if (r4 != null) goto L8;
        return r4;
    L8:
        if (r4.b() == true) goto L33;
        Log.w("PdfBox-Android", "Invalid ToUnicode CMap in font " + c());     // Catch: IOException -> L27
        String r5 = "";
        if (r4.d() == null) goto L13;
        String r6 = r4.d();     // Catch: IOException -> L27
    L15:
        if (r4.f() == null) goto L17;
        r5 = r4.f();     // Catch: IOException -> L27
    L17:
        com.tom_roush.pdfbox.a.b r7 = this.f16248b.a(com.tom_roush.pdfbox.a.i.cy);     // Catch: IOException -> L27
        if (r6.contains("Identity") == false) goto L20;
    L25:
        r3 = c.a(com.tom_roush.pdfbox.a.i.dM.a());     // Catch: IOException -> L27
        Log.w("PdfBox-Android", "Using predefined identity CMap instead");     // Catch: IOException -> L27
        return r3;
    L20:
        if (r5.contains("Identity") == true) goto L25;
        if (com.tom_roush.pdfbox.a.i.dM.equals(r7) == true) goto L25;
        if (com.tom_roush.pdfbox.a.i.dN.equals(r7) == true) goto L25;
        return r4;
    L13:
        r6 = "";
        goto L15
    L33:
        return r4;
    L27:
        e = move-exception;
        Log.e("PdfBox-Android", "Could not read ToUnicode CMap in font " + c(), e);
        return r3;
    }

    public abstract int a(InputStream r1);

    public final com.tom_roush.fontbox.a.e a() {
        return this.d;
    }

    public final com.tom_roush.fontbox.c.b a(com.tom_roush.pdfbox.a.b r3) {
        if (ZeusTransformUtils.instanceOf(r3, com.tom_roush.pdfbox.a.i.class) == false) goto L7;
        return c.a(((com.tom_roush.pdfbox.a.i) ZeusTransformUtils.preCheckCast(r3, com.tom_roush.pdfbox.a.i.class, "com.obric.memorydata.plugin")).a());
    L7:
        if (ZeusTransformUtils.instanceOf(r3, com.tom_roush.pdfbox.a.n.class) == false) goto L16;
        com.tom_roush.pdfbox.a.g r2 = null;
        r2 = ((com.tom_roush.pdfbox.a.n) ZeusTransformUtils.preCheckCast(r3, com.tom_roush.pdfbox.a.n.class, "com.obric.memorydata.plugin")).h();     // Catch: Throwable -> L12
        com.tom_roush.fontbox.c.b r4 = c.a(r2);     // Catch: Throwable -> L12
        com.tom_roush.pdfbox.io.a.a(r2);
        return r4;
    L12:
        th = move-exception;
        com.tom_roush.pdfbox.io.a.a(r2);
        throw th;
    L16:
        throw new IOException("Expected Name or Stream");
    }

    public com.tom_roush.pdfbox.util.e a(int r1) {
        throw new UnsupportedOperationException("Horizontal fonts have no position vector");
    }

    public String a(int r1, com.tom_roush.pdfbox.pdmodel.font.a.d r2) {
        return e(r1);
    }

    public q b() {
        return this.e;
    }

    public com.tom_roush.pdfbox.util.e b(int r2) {
        return new com.tom_roush.pdfbox.util.e(c(r2) / 1000.0f, 0.0f);
    }

    public float c(int r6) {
        Float r0 = (Float) ZeusTransformUtils.preCheckCast(this.i.get(Integer.valueOf(r6)), Float.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L7;
        return r0.floatValue();
    L7:
        if (this.f16248b.a(com.tom_roush.pdfbox.a.i.jd) == null) goto L9;
    L10:
        int r1 = this.f16248b.b(com.tom_roush.pdfbox.a.i.cV, -1);
        int r2 = this.f16248b.b(com.tom_roush.pdfbox.a.i.eq, -1);
        int r3 = g().size();
        int r4 = r6 - r1;
        if (r3 <= 0) goto L20;
        if (r6 < r1) goto L20;
        if (r6 > r2) goto L20;
        if (r4 >= r3) goto L20;
        Float r5 = (Float) ZeusTransformUtils.preCheckCast(g().get(r4), Float.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L18;
        float r7 = 0.0f;
    L23:
        r5 = Float.valueOf(r7);
    L18:
        this.i.put(Integer.valueOf(r6), r5);
        return r5.floatValue();
    L20:
        q r8 = b();
        if (r8 == null) goto L25;
        r7 = r8.o();
    L25:
        if (m() == false) goto L27;
        r7 = d(r6);
        goto L23
    L27:
        r7 = g(r6);
        goto L23
    L9:
        if (this.f16248b.m(com.tom_roush.pdfbox.a.i.eZ) == false) goto L25;
        goto L10
    }

    public abstract float d(int r1);

    public com.tom_roush.pdfbox.a.d d() {
        return this.f16248b;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.c
    public /* synthetic */ com.tom_roush.pdfbox.a.b e() {
        return d();
    }

    public String e(int r3) {
        com.tom_roush.fontbox.c.b r0 = this.c;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.d() == null) goto L15;
        if (this.c.d().startsWith("Identity-") == false) goto L15;
        if (ZeusTransformUtils.instanceOf(this.f16248b.a(com.tom_roush.pdfbox.a.i.il), com.tom_roush.pdfbox.a.i.class) == true) goto L13;
        if (this.c.b() == true) goto L15;
    L13:
        return new String(new char[]{(char) r3});
    L15:
        return this.c.a(r3);
    }

    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, p.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (((p) ZeusTransformUtils.preCheckCast(r3, p.class, "com.obric.memorydata.plugin")).d() != d()) goto L7;
        return true;
    }

    public float f() {
        float r0 = this.g;
        if (r0 != 0.0f) goto L22;
        com.tom_roush.pdfbox.a.a r1 = this.f16248b.f(com.tom_roush.pdfbox.a.i.jd);
        if (r1 == null) goto L16;
        int r2 = 0;
        float r3 = 0.0f;
        float r4 = 0.0f;
    L9:
        if (r2 >= r1.b()) goto L18;
        com.tom_roush.pdfbox.a.b r5 = r1.a(r2);
        if (ZeusTransformUtils.instanceOf(r5, com.tom_roush.pdfbox.a.k.class) == false) goto L15;
        float r6 = ((com.tom_roush.pdfbox.a.k) ZeusTransformUtils.preCheckCast(r5, com.tom_roush.pdfbox.a.k.class, "com.obric.memorydata.plugin")).a();
        if (r6 <= 0.0f) goto L15;
        r3 = r3 + r6;
        r4 = r4 + 1.0f;
    L15:
        r2 = r2 + 1;
    L18:
        if (r3 <= 0.0f) goto L20;
        r0 = r3 / r4;
    L21:
        this.g = r0;
        goto L22
    L20:
        r0 = 0.0f;
        goto L21
    L16:
        r3 = 0.0f;
        r4 = 0.0f;
    L22:
        return r0;
    }

    public final List<Float> g() {
        if (this.f != null) goto L10;
        com.tom_roush.pdfbox.a.a r0 = this.f16248b.f(com.tom_roush.pdfbox.a.i.jd);
        if (r0 == null) goto L7;
        List<Float> r1 = com.tom_roush.pdfbox.pdmodel.common.a.a(r0);
    L8:
        this.f = r1;
        goto L10
    L7:
        r1 = Collections.emptyList();
    L10:
        return this.f;
    }

    public String getType() {
        return this.f16248b.g(com.tom_roush.pdfbox.a.i.iz);
    }

    public float h() {
        if (this.h != (-1.0f)) goto L22;
    L19:
        e = move-exception;
        Log.e("PdfBox-Android", "Can't determine the width of the space character, assuming 250", e);
        this.h = 250.0f;
        goto L22
    L5:
        if (this.c != null) goto L7;
    L12:
        float r0 = c(32);     // Catch: Exception -> L19
    L11:
        this.h = r0;     // Catch: Exception -> L19
    L14:
        if (this.h > 0.0f) goto L22;
        float r1 = g(32);     // Catch: Exception -> L19
        this.h = r1;     // Catch: Exception -> L19
        if (r1 > 0.0f) goto L22;
        this.h = f();     // Catch: Exception -> L19
        goto L22
    L7:
        if (this.f16248b.m(com.tom_roush.pdfbox.a.i.il) == false) goto L12;
        int r2 = this.c.g();     // Catch: Exception -> L19
        if (r2 <= (-1)) goto L14;
        r0 = c(r2);     // Catch: Exception -> L19
    L22:
        return this.h;
    }

    public int hashCode() {
        return d().hashCode();
    }

    public com.tom_roush.pdfbox.util.c i() {
        return f16247a;
    }

    public abstract boolean l();

    public boolean m() {
        if (k() == false) goto L7;
        return false;
    L7:
        return ae.b(c());
    }

    public String toString() {
        return getClass().getSimpleName() + " " + c();
    }
}
