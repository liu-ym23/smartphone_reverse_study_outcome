package com.google.android.material.b;

import android.graphics.Canvas;
import android.os.Build;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static int a(Canvas r7, float r8, float r9, float r10, float r11, int r12) {
        if (Build.VERSION.SDK_INT <= 21) goto L7;
        return r7.saveLayerAlpha(r8, r9, r10, r11, r12);
    L7:
        return r7.saveLayerAlpha(r8, r9, r10, r11, r12, 31);
    }
}
