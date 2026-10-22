package com.google.android.material.internal;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class DescendantOffsetUtils {
    private static final ThreadLocal<Matrix> matrix = null;
    private static final ThreadLocal<RectF> rectF = null;

    static {
        matrix = new ThreadLocal();
        rectF = new ThreadLocal();
    }

    public DescendantOffsetUtils() {
    }

    public static void getDescendantRect(@NonNull ViewGroup r5, @NonNull View r10, @NonNull Rect r11) {
        r11.set(0, 0, r10.getWidth(), r10.getHeight());
        offsetDescendantRect(r5, r10, r11);
    }

    private static void offsetDescendantMatrix(ViewParent r5, @NonNull View r10, @NonNull Matrix r11) {
        Object r12 = r10.getParent();
        if ((r12 instanceof View) == false) goto L6;
        if (r12 == r5) goto L6;
        View r13 = (View) r12;
        offsetDescendantMatrix(r5, r13, r11);
        r11.preTranslate(-r13.getScrollX(), -r13.getScrollY());
    L6:
        r11.preTranslate(r10.getLeft(), r10.getTop());
        if (r10.getMatrix().isIdentity() == true) goto L10;
        r11.preConcat(r10.getMatrix());
        return;
    }

    public static void offsetDescendantRect(@NonNull ViewGroup r5, @NonNull View r10, @NonNull Rect r11) {
        ThreadLocal<Matrix> r12 = matrix;
        Matrix r13 = r12.get();
        if (r13 != null) goto L5;
        r13 = new Matrix();
        r12.set(r13);
    L6:
        offsetDescendantMatrix(r5, r10, r13);
        ThreadLocal<RectF> r14 = rectF;
        RectF r15 = r14.get();
        if (r15 != null) goto L9;
        r15 = new RectF();
        r14.set(r15);
    L9:
        r15.set(r11);
        r13.mapRect(r15);
        r11.set((int) (r15.left + 0.5f), (int) (r15.top + 0.5f), (int) (r15.right + 0.5f), (int) (r15.bottom + 0.5f));
        return;
    L5:
        r13.reset();
        goto L6
    }
}
