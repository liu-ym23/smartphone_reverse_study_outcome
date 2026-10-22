package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.ResizeOptions;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ThumbnailSizeChecker {
    public static boolean a(int r5, int r10, ResizeOptions r11) {
        int r12 = (int) (r5 * 1.3333334f);
        if (r11 != null) goto L11;
        if (r12 >= 2048.0f) goto L7;
    L9:
        return false;
    L7:
        if (((int) (r10 * 1.3333334f)) < 2048) goto L9;
        return true;
    L11:
        if (r12 >= r11.f8051a) goto L13;
    L15:
        return false;
    L13:
        if (((int) (r10 * 1.3333334f)) < r11.f8052b) goto L15;
        return true;
    }
}
