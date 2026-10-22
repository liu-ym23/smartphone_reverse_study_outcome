package com.tom_roush.pdfbox.pdmodel.graphics.d;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.Log;
import androidx.core.view.ViewCompat;
import com.tom_roush.pdfbox.a.g;
import com.tom_roush.pdfbox.a.l;
import com.tom_roush.pdfbox.a.n;
import com.tom_roush.pdfbox.filter.h;
import com.tom_roush.pdfbox.pdmodel.graphics.d;
import com.tom_roush.pdfbox.pdmodel.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class b extends d implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SoftReference<Bitmap> f16270a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.tom_roush.pdfbox.pdmodel.graphics.b.b f16271b;
    private int c;
    private final i d;

    public b(com.tom_roush.pdfbox.pdmodel.common.i r7, i r8) {
        super(r7, com.tom_roush.pdfbox.a.i.dR);
        this.c = Integer.MAX_VALUE;
        this.d = r8;
        List<com.tom_roush.pdfbox.a.i> r9 = r7.d();
        if (r9 != null) goto L5;
        return;
    L5:
        if (r9.isEmpty() == true) goto L29;
        boolean r2 = true;
        if (com.tom_roush.pdfbox.a.i.eg.equals(r9.get(r9.size() - 1)) == false) goto L30;
        List r10 = Arrays.asList(new com.tom_roush.pdfbox.a.i[]{com.tom_roush.pdfbox.a.i.jc, com.tom_roush.pdfbox.a.i.dA, com.tom_roush.pdfbox.a.i.bd});
        n r0 = r7.a();
        Iterator r11 = r10.iterator();
    L10:
        if (r11.hasNext() == false) goto L14;
        if (r0.m((com.tom_roush.pdfbox.a.i) ZeusTransformUtils.preCheckCast(r11.next(), com.tom_roush.pdfbox.a.i.class, "com.obric.memorydata.plugin")) == true) goto L10;
    L15:
        if (r2 == true) goto L17;
        return;
    L17:
        g r12 = null;
        r12 = r7.b();     // Catch: Throwable -> L20
        com.tom_roush.pdfbox.filter.i r1 = r12.a();     // Catch: Throwable -> L20
        r7.a().a(r1.a());     // Catch: Throwable -> L20
        this.f16271b = r1.b();     // Catch: Throwable -> L20
        com.tom_roush.pdfbox.io.a.a(r12);
        return;
    L20:
        th = move-exception;
        com.tom_roush.pdfbox.io.a.a(r12);
        throw th;
    L14:
        r2 = false;
        goto L15
    L30:
        return;
    }

    private static int a(int r1) {
        if (r1 >= 0) goto L5;
        return 0;
    L5:
        if (r1 > 255) goto L7;
        return r1;
    L7:
        return 255;
    }

    private Bitmap a(Bitmap r1, int r2, int r3, boolean r4) {
        return Bitmap.createScaledBitmap(r1, r2, r3, !r4);
    }

    private Bitmap a(Bitmap r25, Bitmap r26, boolean r27, boolean r28, float[] r29) {
        Bitmap r2 = r26;
        if (r2 != null) goto L5;
        return r25;
    L5:
        int r3 = Math.max(r25.getWidth(), r26.getWidth());
        int r4 = Math.max(r25.getHeight(), r26.getHeight());
        if (r26.getWidth() >= r3) goto L8;
    L9:
        r2 = a(r2, r3, r4, r27);
    L11:
        if (r2.getConfig() == Bitmap.Config.ALPHA_8) goto L13;
    L14:
        r2 = r2.copy(Bitmap.Config.ALPHA_8, true);
    L16:
        if (r25.getWidth() >= r3) goto L18;
    L21:
        Bitmap r0 = a(r25, r3, r4, p());
    L23:
        if (r0.getConfig() == Bitmap.Config.ARGB_8888) goto L25;
    L26:
        r0 = r0.copy(Bitmap.Config.ARGB_8888, true);
    L27:
        int[] r1 = new int[r3];
        int[] r14 = new int[r3];
        if (r28 == false) goto L30;
    L37:
        if (r29 != null) goto L46;
        int r13 = 0;
    L39:
        if (r13 >= r4) goto L56;
        int r10 = r13;
        r0.getPixels(r1, 0, r3, 0, r10, r3, 1);
        r2.getPixels(r14, 0, r3, 0, r10, r3, 1);
        int r5 = 0;
    L41:
        if (r5 >= r3) goto L45;
        if (r28 == true) goto L44;
        r14[r5] = ~r14[r5];
    L44:
        r1[r5] = (r1[r5] & ViewCompat.MEASURED_SIZE_MASK) | (r14[r5] & ViewCompat.MEASURED_STATE_MASK);
        r5 = r5 + 1;
        goto L41
    L45:
        r0.setPixels(r1, 0, r3, 0, r13, r3, 1);
        r13 = r13 + 1;
    L56:
        return r0;
    L46:
        int r15 = Math.round(r29[0] * 8355840.0f) * 255;
        int r16 = Math.round(r29[1] * 8355840.0f) * 255;
        int r12 = Math.round(r29[2] * 8355840.0f) * 255;
        int r11 = (r15 / 255) + 16384;
        int r17 = (r16 / 255) + 16384;
        int r9 = (r12 / 255) + 16384;
        int r8 = 0;
    L47:
        if (r8 >= r4) goto L56;
        int r20 = r8;
        int r21 = r9;
        int r18 = r17;
        int r22 = r11;
        int r23 = r12;
        r0.getPixels(r1, 0, r3, 0, r20, r3, 1);
        r2.getPixels(r14, 0, r3, 0, r20, r3, 1);
        int r6 = 0;
    L49:
        if (r6 >= r3) goto L55;
        int r7 = Color.alpha(r14[r6]);
        if (r7 != 0) goto L53;
        r1[r6] = r1[r6] & ViewCompat.MEASURED_SIZE_MASK;
    L54:
        r6 = r6 + 1;
        goto L49
    L53:
        int r19 = r1[r6];
        r1[r6] = Color.argb(r7, a(((((Color.red(r19) * 8355840) - r15) / r7) + r22) >> 15), a(((((Color.green(r19) * 8355840) - r16) / r7) + r18) >> 15), a(((((Color.blue(r19) * 8355840) - r23) / r7) + r21) >> 15));
        goto L54
    L55:
        r0.setPixels(r1, 0, r3, 0, r20, r3, 1);
        r8 = r20 + 1;
        r17 = r18;
        r9 = r21;
        r11 = r22;
        r12 = r23;
        goto L47
    L30:
        if (r0.getByteCount() != r2.getByteCount()) goto L37;
        int r110 = 0;
    L32:
        if (r110 >= r4) goto L56;
        int r111 = r110;
        r0.getPixels(r1, 0, r3, 0, r110, r3, 1);
        r2.getPixels(r14, 0, r3, 0, r111, r3, 1);
        int r24 = r3;
        int r30 = 0;
    L34:
        if (r24 <= 0) goto L36;
        r1[r30] = (r1[r30] & ViewCompat.MEASURED_SIZE_MASK) | ((~r14[r30]) & ViewCompat.MEASURED_STATE_MASK);
        r30 = r30 + 1;
        r24 = r24 - 1;
        goto L34
    L36:
        r0.setPixels(r1, 0, r3, 0, r111, r3, 1);
        r110 = r111 + 1;
        goto L32
    L25:
        if (r0.isMutable() == true) goto L27;
    L18:
        if (r25.getHeight() < r4) goto L21;
        r0 = r25;
        goto L23
    L13:
        if (r25.isMutable() == true) goto L16;
    L8:
        if (r26.getHeight() >= r4) goto L11;
        goto L9
    }

    private float[] a(b r4) {
        com.tom_roush.pdfbox.a.b r5 = r4.k_().l(com.tom_roush.pdfbox.a.i.eR);
        if (ZeusTransformUtils.instanceOf(r5, com.tom_roush.pdfbox.a.a.class) == false) goto L10;
        float[] r6 = ((com.tom_roush.pdfbox.a.a) ZeusTransformUtils.preCheckCast(r5, com.tom_roush.pdfbox.a.a.class, "com.obric.memorydata.plugin")).c();
        if (r6.length >= f().b()) goto L9;
        Log.e("PdfBox-Android", "Image /Matte entry not long enough for colorspace, skipped");
        return null;
    L9:
        return f().a(r6);
    L10:
        return null;
    }

    public Bitmap a(Rect r9, int r10) {
        if (r9 == null) goto L4;
    L10:
        b r0 = o();
        b r1 = m();
        if (r0 == null) goto L13;
        Bitmap r2 = a(c.a(this, r9, r10, n()), r0.l(), r0.p(), true, a(r0));
    L18:
        if (r9 == null) goto L20;
    L22:
        return r2;
    L20:
        if (r10 > this.c) goto L22;
        this.c = r10;
        this.f16270a = new SoftReference(r2);
        goto L22
    L13:
        if (r1 != null) goto L15;
    L17:
        r2 = c.a(this, r9, r10, n());
        goto L18
    L15:
        if (r1.c() == false) goto L17;
        r2 = a(c.a(this, r9, r10, n()), r1.l(), r1.p(), false, null);
        goto L18
    L4:
        if (r10 != this.c) goto L10;
        SoftReference<Bitmap> r3 = this.f16270a;
        if (r3 == null) goto L10;
        Bitmap r4 = (Bitmap) ZeusTransformUtils.preCheckCast(r3.get(), Bitmap.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L10;
        return r4;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.d.a
    public InputStream a() {
        return l_().b();
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.d.a
    public InputStream a(h r1) {
        return l_().a(r1);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.d.a
    public boolean b() {
        if (l_().a().j() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.d.a
    public boolean c() {
        return k_().b(com.tom_roush.pdfbox.a.i.dS, false);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.d.a
    public int d() {
        if (c() == false) goto L7;
        return 1;
    L7:
        return k_().c(com.tom_roush.pdfbox.a.i.X, com.tom_roush.pdfbox.a.i.ah);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.d.a
    public com.tom_roush.pdfbox.pdmodel.graphics.b.b f() {
        if (this.f16271b != null) goto L25;
        com.tom_roush.pdfbox.a.b r0 = k_().d(com.tom_roush.pdfbox.a.i.bd, com.tom_roush.pdfbox.a.i.bq);
        if (r0 == null) goto L19;
        l r1 = null;
        if (ZeusTransformUtils.instanceOf(r0, l.class) == false) goto L15;
        i r2 = this.d;
        if (r2 == null) goto L15;
        if (r2.c() == null) goto L15;
        r1 = (l) ZeusTransformUtils.preCheckCast(r0, l.class, "com.obric.memorydata.plugin");
        com.tom_roush.pdfbox.pdmodel.graphics.b.b r3 = this.d.c().b(r1);
        this.f16271b = r3;
        if (r3 == null) goto L15;
        return r3;
    L15:
        this.f16271b = com.tom_roush.pdfbox.pdmodel.graphics.b.b.a(r0, this.d);
        if (r1 == null) goto L25;
        this.d.c().a(r1, this.f16271b);
        goto L25
    L19:
        if (c() == false) goto L23;
        return com.tom_roush.pdfbox.pdmodel.graphics.b.d.f16264b;
    L23:
        throw new IOException("could not determine color space");
    L25:
        return this.f16271b;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.d.a
    public int g() {
        return k_().i(com.tom_roush.pdfbox.a.i.dA);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.d.a
    public int h() {
        return k_().i(com.tom_roush.pdfbox.a.i.jc);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.d.a
    public com.tom_roush.pdfbox.a.a i() {
        com.tom_roush.pdfbox.a.b r2 = k_().a(com.tom_roush.pdfbox.a.i.bx);
        if (ZeusTransformUtils.instanceOf(r2, com.tom_roush.pdfbox.a.a.class) == true) goto L5;
        return null;
    L5:
        return (com.tom_roush.pdfbox.a.a) ZeusTransformUtils.preCheckCast(r2, com.tom_roush.pdfbox.a.a.class, "com.obric.memorydata.plugin");
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.d.a
    public String j() {
        List<com.tom_roush.pdfbox.a.i> r2 = l_().d();
        if (r2 != null) goto L6;
        return "png";
    L6:
        if (r2.contains(com.tom_roush.pdfbox.a.i.bv) == false) goto L10;
        return "jpg";
    L10:
        if (r2.contains(com.tom_roush.pdfbox.a.i.eg) == false) goto L14;
        return "jpx";
    L14:
        if (r2.contains(com.tom_roush.pdfbox.a.i.av) == false) goto L18;
        return "tiff";
    L18:
        if (r2.contains(com.tom_roush.pdfbox.a.i.cZ) == false) goto L20;
    L30:
        return "png";
    L20:
        if (r2.contains(com.tom_roush.pdfbox.a.i.eI) == true) goto L30;
        if (r2.contains(com.tom_roush.pdfbox.a.i.hb) == true) goto L30;
        if (r2.contains(com.tom_roush.pdfbox.a.i.ee) == false) goto L28;
        return "jb2";
    L28:
        Log.w("PdfBox-Android", "getSuffix() returns null, filters: " + r2);
        return null;
    }

    public Bitmap k() {
        return a(null, 1);
    }

    public Bitmap l() {
        return c.a(this, null);
    }

    public b m() {
        if (ZeusTransformUtils.instanceOf(k_().a(com.tom_roush.pdfbox.a.i.eP), com.tom_roush.pdfbox.a.a.class) == false) goto L5;
        return null;
    L5:
        n r3 = k_().e(com.tom_roush.pdfbox.a.i.eP);
        if (r3 != null) goto L8;
        return null;
    L8:
        return new b(new com.tom_roush.pdfbox.pdmodel.common.i(r3), null);
    }

    public com.tom_roush.pdfbox.a.a n() {
        com.tom_roush.pdfbox.a.b r2 = k_().a(com.tom_roush.pdfbox.a.i.eP);
        if (ZeusTransformUtils.instanceOf(r2, com.tom_roush.pdfbox.a.a.class) == true) goto L5;
        return null;
    L5:
        return (com.tom_roush.pdfbox.a.a) ZeusTransformUtils.preCheckCast(r2, com.tom_roush.pdfbox.a.a.class, "com.obric.memorydata.plugin");
    }

    public b o() {
        n r3 = k_().e(com.tom_roush.pdfbox.a.i.hu);
        if (r3 != null) goto L5;
        return null;
    L5:
        return new b(new com.tom_roush.pdfbox.pdmodel.common.i(r3), null);
    }

    public boolean p() {
        return k_().b(com.tom_roush.pdfbox.a.i.dY, false);
    }
}
