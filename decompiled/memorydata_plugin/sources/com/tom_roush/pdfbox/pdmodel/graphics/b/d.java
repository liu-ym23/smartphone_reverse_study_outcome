package com.tom_roush.pdfbox.pdmodel.graphics.b;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.Log;
import com.tom_roush.pdfbox.a.i;

/* JADX INFO: loaded from: classes6.dex */
public final class d extends c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f16264b = null;
    private final a c;

    static {
        f16264b = new d();
    }

    private d() {
        this.c = new a(new float[]{0.0f}, this);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.b.b
    public Bitmap a(Bitmap r15) {
        if (r15.getConfig() == Bitmap.Config.ALPHA_8) goto L5;
        Log.e("PdfBox-Android", "Raster in PDDevicGrey was not ALPHA_8");
    L5:
        int r14 = r15.getWidth();
        int r0 = r15.getHeight();
        int[] r9 = new int[r14];
        Bitmap r10 = Bitmap.createBitmap(r14, r0, Bitmap.Config.ARGB_8888);
        int[] r11 = new int[r14];
        int r13 = 0;
    L6:
        if (r13 >= r0) goto L11;
        r15.getPixels(r9, 0, r14, 0, r13, r14, 1);
        int r1 = 0;
    L8:
        if (r1 >= r14) goto L10;
        int r2 = Color.alpha(r9[r1]);
        r11[r1] = Color.argb(255, r2, r2, r2);
        r1 = r1 + 1;
        goto L8
    L10:
        r10.setPixels(r11, 0, r14, 0, r13, r14, 1);
        r13 = r13 + 1;
        goto L6
    L11:
        return r10;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.b.b
    public String a() {
        return i.bL.a();
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.b.b
    public float[] a(int r1) {
        return new float[]{0.0f, 1.0f};
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.b.b
    public float[] a(float[] r4) {
        return new float[]{r4[0], r4[0], r4[0]};
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.b.b
    public int b() {
        return 1;
    }

    public a c() {
        return this.c;
    }
}
