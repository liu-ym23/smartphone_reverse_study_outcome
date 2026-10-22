package com.tom_roush.pdfbox.pdmodel.graphics.b;

import android.graphics.Bitmap;
import android.util.Log;
import com.tom_roush.pdfbox.a.i;

/* JADX INFO: loaded from: classes6.dex */
public final class e extends c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f16265b = null;
    private final a c;

    static {
        f16265b = new e();
    }

    private e() {
        this.c = new a(new float[]{0.0f, 0.0f, 0.0f}, this);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.b.b
    public Bitmap a(Bitmap r2) {
        if (r2.getConfig() != Bitmap.Config.ALPHA_8) goto L5;
        Log.e("PdfBox-Android", "Raster in PDDeviceRGB was ALPHA_8");
    L5:
        return r2;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.b.b
    public String a() {
        return i.bN.a();
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.b.b
    public float[] a(int r1) {
        return new float[]{0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f};
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.b.b
    public float[] a(float[] r3) {
        if (r3.length != 3) goto L6;
        return r3;
    L6:
        return this.c.a();
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.b.b
    public int b() {
        return 3;
    }
}
