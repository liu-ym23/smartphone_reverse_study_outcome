package com.tom_roush.pdfbox.pdmodel;

import android.util.Log;
import com.tom_roush.fontbox.f.ah;
import com.tom_roush.pdfbox.pdmodel.font.p;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public class c implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f16177a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.tom_roush.pdfbox.a.e f16178b;
    private d c;
    private com.tom_roush.pdfbox.pdmodel.encryption.e d;
    private final com.tom_roush.pdfbox.io.g e;
    private com.tom_roush.pdfbox.pdmodel.encryption.a f;
    private final Set<p> g;
    private final Set<ah> h;
    private com.tom_roush.pdfbox.pdmodel.interactive.a.a i;
    private k j;
    private boolean k;

    static {
        f16177a = new int[]{0, 1000000000, 1000000000, 1000000000};
        com.tom_roush.pdfbox.pdmodel.graphics.b.e.f16265b.a(new float[]{1.0f, 1.0f, 1.0f, 1.0f});
        com.tom_roush.pdfbox.a.k.a("0");     // Catch: IOException -> L5
        com.tom_roush.pdfbox.a.k.a("1");     // Catch: IOException -> L5
        return;
    }

    public c() {
        this(com.tom_roush.pdfbox.io.b.a());
    }

    public c(com.tom_roush.pdfbox.a.e r3, com.tom_roush.pdfbox.io.g r4, com.tom_roush.pdfbox.pdmodel.encryption.a r5) {
        com.tom_roush.pdfbox.io.g r6 = (com.tom_roush.pdfbox.io.g) ZeusTransformUtils.wrapperContextForParams(r4, com.tom_roush.pdfbox.io.g.class, "com.obric.memorydata.plugin");
        this.g = new HashSet();
        this.h = new HashSet();
        this.j = new a();
        this.k = false;
        this.f16178b = r3;
        this.e = r6;
        this.f = r5;
    }

    public c(com.tom_roush.pdfbox.io.b r4) {
        this.g = new HashSet();
        this.h = new HashSet();
        this.j = new a();
        this.k = false;
        com.tom_roush.pdfbox.io.i r1 = new com.tom_roush.pdfbox.io.i(r4);     // Catch: IOException -> L5
    L10:
        com.tom_roush.pdfbox.a.e r5 = new com.tom_roush.pdfbox.a.e(r1);
        this.f16178b = r5;
        this.e = null;
        com.tom_roush.pdfbox.a.d r3 = new com.tom_roush.pdfbox.a.d();
        r5.b(r3);
        com.tom_roush.pdfbox.a.d r6 = new com.tom_roush.pdfbox.a.d();
        r3.a(com.tom_roush.pdfbox.a.i.gY, r6);
        r6.a(com.tom_roush.pdfbox.a.i.iz, com.tom_roush.pdfbox.a.i.au);
        r6.a(com.tom_roush.pdfbox.a.i.iP, com.tom_roush.pdfbox.a.i.a("1.4"));
        com.tom_roush.pdfbox.a.d r7 = new com.tom_roush.pdfbox.a.d();
        r6.a(com.tom_roush.pdfbox.a.i.ga, r7);
        r7.a(com.tom_roush.pdfbox.a.i.iz, com.tom_roush.pdfbox.a.i.ga);
        r7.a(com.tom_roush.pdfbox.a.i.el, new com.tom_roush.pdfbox.a.a());
        r7.a(com.tom_roush.pdfbox.a.i.bk, com.tom_roush.pdfbox.a.h.f16054a);
        return;
    L5:
        e = move-exception;
        Log.w("PdfBox-Android", "Error initializing scratch file: " + e.getMessage() + ". Fall back to main memory usage only.");
        r1 = new com.tom_roush.pdfbox.io.i(com.tom_roush.pdfbox.io.b.a());     // Catch: IOException -> L9
    L9:
        r1 = null;
        goto L10
    }

    public static c a(InputStream r3) {
        return a(r3, "", null, null, com.tom_roush.pdfbox.io.b.a());
    }

    public static c a(InputStream r7, String r8, InputStream r9, String r10, com.tom_roush.pdfbox.io.b r11) {
        com.tom_roush.pdfbox.io.i r6 = new com.tom_roush.pdfbox.io.i(r11);
        com.tom_roush.pdfbox.pdfparser.f r12 = new com.tom_roush.pdfbox.pdfparser.f(r6.a(r7), r8, r9, r10, r6);     // Catch: IOException -> L5
        r12.C();     // Catch: IOException -> L5
        return r12.A();
    L5:
        e = move-exception;
        com.tom_roush.pdfbox.io.a.a(r6);
        throw e;
    }

    public com.tom_roush.pdfbox.a.e a() {
        return this.f16178b;
    }

    public g a(int r1) {
        return b().b().a(r1);
    }

    public void a(com.tom_roush.pdfbox.pdmodel.encryption.e r1) {
        this.d = r1;
    }

    public d b() {
        if (this.c != null) goto L9;
        com.tom_roush.pdfbox.a.b r0 = this.f16178b.f().a(com.tom_roush.pdfbox.a.i.gY);
        if (ZeusTransformUtils.instanceOf(r0, com.tom_roush.pdfbox.a.d.class) == false) goto L7;
        this.c = new d(this, (com.tom_roush.pdfbox.a.d) ZeusTransformUtils.preCheckCast(r0, com.tom_roush.pdfbox.a.d.class, "com.obric.memorydata.plugin"));
        goto L9
    L7:
        this.c = new d(this);
    L9:
        return this.c;
    }

    public h c() {
        return b().b();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f16178b.h() == true) goto L17;
        IOException r0 = null;
        com.tom_roush.pdfbox.pdmodel.interactive.a.a r1 = this.i;
        if (r1 == null) goto L7;
        r0 = com.tom_roush.pdfbox.io.a.a(r1, "SigningSupport", null);
    L7:
        IOException r2 = com.tom_roush.pdfbox.io.a.a(this.f16178b, "COSDocument", r0);
        com.tom_roush.pdfbox.io.g r3 = this.e;
        if (r3 == null) goto L10;
        r2 = com.tom_roush.pdfbox.io.a.a(r3, "RandomAccessRead pdfSource", r2);
    L10:
        Iterator<ah> r4 = this.h.iterator();
    L12:
        if (r4.hasNext() == false) goto L14;
        r2 = com.tom_roush.pdfbox.io.a.a((ah) ZeusTransformUtils.preCheckCast(r4.next(), ah.class, "com.obric.memorydata.plugin"), "TrueTypeFont", r2);
        goto L12
    L14:
        if (r2 == null) goto L19;
        throw r2;
    L19:
        return;
    }

    public int d() {
        return b().b().a();
    }

    public k e() {
        return this.j;
    }
}
