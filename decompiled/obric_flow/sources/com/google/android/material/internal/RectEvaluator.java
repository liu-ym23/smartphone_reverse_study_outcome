package com.google.android.material.internal;

import android.animation.TypeEvaluator;
import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class RectEvaluator implements TypeEvaluator<Rect> {
    private final Rect rect;

    public RectEvaluator(@NonNull Rect r5) {
        this.rect = r5;
    }

    @Override // android.animation.TypeEvaluator
    public /* bridge */ /* synthetic */ Rect evaluate(float r5, @NonNull Rect r10, @NonNull Rect r11) {
        return evaluate2(r5, r10, r11);
    }

    /* JADX INFO: renamed from: evaluate, reason: avoid collision after fix types in other method */
    public Rect evaluate2(float r5, @NonNull Rect r10, @NonNull Rect r11) {
        int r12 = r10.left;
        int r13 = r12 + ((int) ((r11.left - r12) * r5));
        int r14 = r10.top;
        int r15 = r14 + ((int) ((r11.top - r14) * r5));
        int r16 = r10.right;
        int r17 = r16 + ((int) ((r11.right - r16) * r5));
        int r18 = r10.bottom;
        this.rect.set(r13, r15, r17, r18 + ((int) ((r11.bottom - r18) * r5)));
        return this.rect;
    }
}
