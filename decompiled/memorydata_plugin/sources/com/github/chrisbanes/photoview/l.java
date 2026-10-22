package com.github.chrisbanes.photoview;

import android.widget.ImageView;
import androidx.core.view.MotionEventCompat;

/* JADX INFO: loaded from: classes2.dex */
class l {

    /* JADX INFO: renamed from: com.github.chrisbanes.photoview.l$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3740a = null;

        static {
            int[] r0 = new int[ImageView.ScaleType.values().length];
            f3740a = r0;
            r0[ImageView.ScaleType.MATRIX.ordinal()] = 1;     // Catch: NoSuchFieldError -> L5
            return;
        }
    }

    static int a(int r1) {
        return (r1 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
    }

    static void a(float r0, float r1, float r2) {
        if (r0 >= r1) goto L10;
        if (r1 >= r2) goto L8;
        return;
    L8:
        throw new IllegalArgumentException("Medium zoom has to be less than Maximum zoom. Call setMaximumZoom() with a more appropriate value");
    L10:
        throw new IllegalArgumentException("Minimum zoom has to be less than Medium zoom. Call setMinimumZoom() with a more appropriate value");
    }

    static boolean a(ImageView.ScaleType r1) {
        if (r1 != null) goto L6;
        return false;
    L6:
        if (AnonymousClass1.f3740a[r1.ordinal()] == 1) goto L9;
        return true;
    L9:
        throw new IllegalStateException("Matrix scale type is not supported");
    }

    static boolean a(ImageView r0) {
        if (r0.getDrawable() == null) goto L5;
        return true;
    L5:
        return false;
    }
}
