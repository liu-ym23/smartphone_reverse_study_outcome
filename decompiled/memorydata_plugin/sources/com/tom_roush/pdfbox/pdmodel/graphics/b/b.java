package com.tom_roush.pdfbox.pdmodel.graphics.b;

import android.graphics.Bitmap;
import android.util.Log;
import com.tom_roush.pdfbox.a.l;
import com.tom_roush.pdfbox.pdmodel.MissingResourceException;
import com.tom_roush.pdfbox.pdmodel.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;

/* JADX INFO: loaded from: classes6.dex */
public abstract class b implements com.tom_roush.pdfbox.pdmodel.common.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected com.tom_roush.pdfbox.a.a f16263a;

    public b() {
    }

    public static b a(com.tom_roush.pdfbox.a.b r1, i r2) {
        return a(r1, r2, false);
    }

    public static b a(com.tom_roush.pdfbox.a.b r6, i r7, boolean r8) {
        if (ZeusTransformUtils.instanceOf(r6, l.class) == false) goto L7;
        return a((l) ZeusTransformUtils.preCheckCast(r6, l.class, "com.obric.memorydata.plugin"), r7);
    L7:
        if (ZeusTransformUtils.instanceOf(r6, com.tom_roush.pdfbox.a.i.class) == false) goto L56;
        com.tom_roush.pdfbox.a.i r9 = (com.tom_roush.pdfbox.a.i) ZeusTransformUtils.preCheckCast(r6, com.tom_roush.pdfbox.a.i.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L31;
        com.tom_roush.pdfbox.a.i r0 = null;
        if (r9.equals(com.tom_roush.pdfbox.a.i.bK) == false) goto L16;
        if (r7.c(com.tom_roush.pdfbox.a.i.bA) == false) goto L16;
        r0 = com.tom_roush.pdfbox.a.i.bA;
    L26:
        if (r7.c(r0) == false) goto L31;
        if (r8 == true) goto L31;
        return r7.a(r0, true);
    L16:
        if (r9.equals(com.tom_roush.pdfbox.a.i.bN) == false) goto L21;
        if (r7.c(com.tom_roush.pdfbox.a.i.bD) == false) goto L21;
        r0 = com.tom_roush.pdfbox.a.i.bD;
    L21:
        if (r9.equals(com.tom_roush.pdfbox.a.i.bL) == false) goto L26;
        if (r7.c(com.tom_roush.pdfbox.a.i.bC) == false) goto L26;
        r0 = com.tom_roush.pdfbox.a.i.bC;
    L31:
        if (r9 != com.tom_roush.pdfbox.a.i.bK) goto L35;
        Log.e("PdfBox-Android", "Unsupported color space kind: " + r9 + ". Will try DeviceRGB instead");
        return e.f16265b;
    L35:
        if (r9 != com.tom_roush.pdfbox.a.i.bN) goto L39;
        return e.f16265b;
    L39:
        if (r9 != com.tom_roush.pdfbox.a.i.bL) goto L43;
        return d.f16264b;
    L43:
        if (r9 != com.tom_roush.pdfbox.a.i.gj) goto L46;
        Log.e("PdfBox-Android", "Unsupported color space kind: " + r9 + ". Will try DeviceRGB instead");
        return e.f16265b;
    L46:
        if (r7 == null) goto L54;
        if (r7.c(r9) == false) goto L52;
        return r7.b(r9);
    L52:
        throw new MissingResourceException("Missing color space: " + r9.a());
    L54:
        throw new MissingResourceException("Unknown color space: " + r9.a());
    L56:
        if (ZeusTransformUtils.instanceOf(r6, com.tom_roush.pdfbox.a.a.class) == false) goto L109;
        com.tom_roush.pdfbox.a.a r10 = (com.tom_roush.pdfbox.a.a) ZeusTransformUtils.preCheckCast(r6, com.tom_roush.pdfbox.a.a.class, "com.obric.memorydata.plugin");
        if (r10.b() == 0) goto L107;
        com.tom_roush.pdfbox.a.b r1 = r10.a(0);
        if (ZeusTransformUtils.instanceOf(r1, com.tom_roush.pdfbox.a.i.class) == false) goto L105;
        com.tom_roush.pdfbox.a.i r2 = (com.tom_roush.pdfbox.a.i) ZeusTransformUtils.preCheckCast(r1, com.tom_roush.pdfbox.a.i.class, "com.obric.memorydata.plugin");
        if (r2 != com.tom_roush.pdfbox.a.i.aq) goto L66;
        Log.e("PdfBox-Android", "Unsupported color space kind: " + r2 + ". Will try DeviceRGB instead");
        return e.f16265b;
    L66:
        if (r2 != com.tom_roush.pdfbox.a.i.ar) goto L70;
        Log.e("PdfBox-Android", "Unsupported color space kind: " + r2 + ". Will try DeviceRGB instead");
        return e.f16265b;
    L70:
        if (r2 != com.tom_roush.pdfbox.a.i.bM) goto L74;
        Log.e("PdfBox-Android", "Unsupported color space kind: " + r2 + ". Will try DeviceRGB instead");
        return e.f16265b;
    L74:
        if (r2 != com.tom_roush.pdfbox.a.i.dU) goto L78;
        Log.e("PdfBox-Android", "Unsupported color space kind: " + r2 + ". Will try DeviceRGB instead");
        return e.f16265b;
    L78:
        if (r2 != com.tom_roush.pdfbox.a.i.hk) goto L82;
        Log.e("PdfBox-Android", "Unsupported color space kind: " + r2 + ". Will try DeviceRGB instead");
        return e.f16265b;
    L82:
        if (r2 != com.tom_roush.pdfbox.a.i.dI) goto L86;
        Log.e("PdfBox-Android", "Unsupported color space kind: " + r2 + ". Will try DeviceRGB instead");
        return e.f16265b;
    L86:
        if (r2 != com.tom_roush.pdfbox.a.i.en) goto L90;
        Log.e("PdfBox-Android", "Unsupported color space kind: " + r2 + ". Will try DeviceRGB instead");
        return e.f16265b;
    L90:
        if (r2 != com.tom_roush.pdfbox.a.i.gj) goto L94;
        r10.b();
        Log.e("PdfBox-Android", "Unsupported color space kind: " + r2 + ". Will try DeviceRGB instead");
        return e.f16265b;
    L94:
        if (r2 == com.tom_roush.pdfbox.a.i.bK) goto L103;
        if (r2 == com.tom_roush.pdfbox.a.i.bN) goto L103;
        if (r2 == com.tom_roush.pdfbox.a.i.bL) goto L103;
        throw new IOException("Invalid color space kind: " + r2);
    L103:
        return a(r2, r7, r8);
    L105:
        throw new IOException("First element in colorspace array must be a name");
    L107:
        throw new IOException("Colorspace array is empty");
    L109:
        if (ZeusTransformUtils.instanceOf(r6, com.tom_roush.pdfbox.a.d.class) == false) goto L119;
        if (((com.tom_roush.pdfbox.a.d) ZeusTransformUtils.preCheckCast(r6, com.tom_roush.pdfbox.a.d.class, "com.obric.memorydata.plugin")).m(com.tom_roush.pdfbox.a.i.bd) == false) goto L119;
        com.tom_roush.pdfbox.a.b r3 = ((com.tom_roush.pdfbox.a.d) ZeusTransformUtils.preCheckCast(r6, com.tom_roush.pdfbox.a.d.class, "com.obric.memorydata.plugin")).a(com.tom_roush.pdfbox.a.i.bd);
        if (r3 == r6) goto L117;
        return a(r3, r7, r8);
    L117:
        throw new IOException("Recursion in colorspace: " + ((com.tom_roush.pdfbox.a.d) ZeusTransformUtils.preCheckCast(r6, com.tom_roush.pdfbox.a.d.class, "com.obric.memorydata.plugin")).l(com.tom_roush.pdfbox.a.i.bd) + " points to itself");
    L119:
        throw new IOException("Expected a name or array but got: " + r6);
    }

    private static b a(l r2, i r3) {
        if (r3 != null) goto L4;
    L8:
        b r0 = a(r2.a(), r3);
        if (r3 != null) goto L11;
    L14:
        return r0;
    L11:
        if (r3.c() == null) goto L14;
        if (r0 == null) goto L14;
        r3.c().a(r2, r0);
        goto L14
    L4:
        if (r3.c() == null) goto L8;
        b r1 = r3.c().b(r2);
        if (r1 == null) goto L8;
        return r1;
    }

    public abstract Bitmap a(Bitmap r1);

    public abstract String a();

    public abstract float[] a(int r1);

    public abstract float[] a(float[] r1);

    public abstract int b();

    @Override // com.tom_roush.pdfbox.pdmodel.common.c
    public com.tom_roush.pdfbox.a.b e() {
        return this.f16263a;
    }
}
