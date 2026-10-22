package com.tom_roush.pdfbox.pdmodel.graphics.b;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.os.Build;

/* JADX INFO: loaded from: classes6.dex */
public final class g extends b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ColorSpace f16267b;

    public g(ColorSpace r1) {
        this.f16267b = r1;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.b.b
    public Bitmap a(Bitmap r5) {
        if (Build.VERSION.SDK_INT <= 26) goto L6;
        Bitmap r4 = Bitmap.createBitmap(r5.getWidth(), r5.getHeight(), Bitmap.Config.RGB_565, false, this.f16267b);
        new Canvas(r4).drawBitmap(r5, 0.0f, 0.0f, null);
        return r4;
    L6:
        return r5;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.b.b
    public String a() {
        return "JPX";
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.b.b
    public float[] a(int r5) {
        int r0 = 0;
        if (Build.VERSION.SDK_INT <= 26) goto L9;
        int r6 = b();
        float[] r1 = new float[r6 * 2];
    L5:
        if (r0 >= r6) goto L7;
        int r2 = r0 * 2;
        r1[r2] = this.f16267b.getMinValue(r0);
        r1[r2 + 1] = this.f16267b.getMaxValue(r0);
        r0 = r0 + 1;
        goto L5
    L7:
        return r1;
    L9:
        return new float[0];
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.b.b
    public float[] a(float[] r1) {
        throw new UnsupportedOperationException("JPX color spaces don't support drawing");
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.b.b
    public int b() {
        if (Build.VERSION.SDK_INT > 26) goto L5;
        return 0;
    L5:
        return this.f16267b.getComponentCount();
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.b.b, com.tom_roush.pdfbox.pdmodel.common.c
    public com.tom_roush.pdfbox.a.b e() {
        throw new UnsupportedOperationException("JPX color spaces don't have COS objects");
    }
}
