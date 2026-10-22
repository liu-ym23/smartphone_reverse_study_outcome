package com.lynx.tasm.utils;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f11177a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SizeValue$Type f11178b;

    public i(SizeValue$Type r5, float r10) {
        this.f11178b = r5;
        this.f11177a = r10;
    }

    public static i b(String r10) {
        if (r10 != null) goto L4;
        int r5 = 0;
    L6:
        if (r5 <= 1) goto L12;
        if (r10.endsWith("%") == false) goto L12;
        float r11 = k.c(r10, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, DisplayMetricsHolder.a());
        return new i(SizeValue$Type.f11158a, r11);
    L12:
        if (r5 > 2) goto L14;
        return null;
    L14:
        if (r10.endsWith("px") == false) goto L19;
        float r12 = k.c(r10, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, DisplayMetricsHolder.a());
        return new i(SizeValue$Type.f11159b, r12);
    L19:
        return null;
    L4:
        r5 = r10.length();
        goto L6
    }

    public final float a(float r5) {
        SizeValue$Type r10 = SizeValue$Type.f11158a;
        float r11 = this.f11177a;
        SizeValue$Type r12 = this.f11178b;
        if (r12 != r10) goto L7;
        return r11 * r5;
    L7:
        if (r12 != SizeValue$Type.f11159b) goto L9;
        return r11;
    L9:
        return 0.0f;
    }
}
