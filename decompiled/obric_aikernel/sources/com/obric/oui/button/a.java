package com.obric.oui.button;

import androidx.annotation.ColorInt;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6287a = null;

    static {
        f6287a = new a();
    }

    private a() {
    }

    @ColorInt
    public final int a(float r10, @ColorInt int r11, @ColorInt int r12) {
        int r13 = (r11 >> 24) & 255;
        int r14 = (r11 >> 16) & 255;
        int r15 = (r11 >> 8) & 255;
        int r16 = r11 & 255;
        int r17 = (int) (r13 + ((((r12 >> 24) & 255) - r13) * r10));
        int r18 = (int) (r14 + ((((r12 >> 16) & 255) - r14) * r10));
        int r19 = (int) (r15 + ((((r12 >> 8) & 255) - r15) * r10));
        return (((r17 << 24) | (r18 << 16)) | (r19 << 8)) | ((int) (r16 + (r10 * ((r12 & 255) - r16))));
    }

    public final float b(float r10, float r11, float r12) {
        return r10 + ((r11 - r10) * r12);
    }
}
