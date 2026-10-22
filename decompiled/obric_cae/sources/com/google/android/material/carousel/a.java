package com.google.android.material.carousel;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static float a(float r8, float r10, int r11) {
        return (Math.max(0, r11 - 1) * r10) + r8;
    }

    public static float b(float r8, float r10, int r11) {
        if (r11 > 0) goto L4;
        return r8;
    L4:
        return (r10 / 2.0f) + r8;
    }

    public static float c(float r8, float r10, float r11, int r12) {
        if (r12 > 0) goto L4;
        return r8;
    L4:
        return (r11 / 2.0f) + r10;
    }
}
