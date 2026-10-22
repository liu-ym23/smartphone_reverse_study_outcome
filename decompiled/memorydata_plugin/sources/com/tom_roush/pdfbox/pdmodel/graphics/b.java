package com.tom_roush.pdfbox.pdmodel.graphics;

import com.tom_roush.pdfbox.a.h;
import java.util.Arrays;

/* JADX INFO: loaded from: classes6.dex */
public final class b implements com.tom_roush.pdfbox.pdmodel.common.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f16259a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float[] f16260b;

    public b() {
        this.f16260b = new float[0];
        this.f16259a = 0;
    }

    public b(com.tom_roush.pdfbox.a.a r1, int r2) {
        this.f16260b = r1.c();
        this.f16259a = r2;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.c
    public com.tom_roush.pdfbox.a.b e() {
        com.tom_roush.pdfbox.a.a r0 = new com.tom_roush.pdfbox.a.a();
        com.tom_roush.pdfbox.a.a r1 = new com.tom_roush.pdfbox.a.a();
        r1.a(this.f16260b);
        r0.a(r1);
        r0.a(h.a(this.f16259a));
        return r0;
    }

    public String toString() {
        return "PDLineDashPattern{array=" + Arrays.toString(this.f16260b) + ", phase=" + this.f16259a + "}";
    }
}
