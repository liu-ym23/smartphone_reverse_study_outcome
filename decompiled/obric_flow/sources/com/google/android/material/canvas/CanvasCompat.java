package com.google.android.material.canvas;

import android.graphics.Canvas;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class CanvasCompat {

    public interface CanvasOperation {
        void run(@NonNull Canvas r5);
    }

    private CanvasCompat() {
    }

    public static int saveLayerAlpha(@NonNull Canvas r5, @Nullable RectF r10, int r11) {
        return r5.saveLayerAlpha(r10, r11);
    }

    public static int saveLayerAlpha(@NonNull Canvas r5, float r10, float r11, float r12, float r13, int r14) {
        return r5.saveLayerAlpha(r10, r11, r12, r13, r14);
    }
}
