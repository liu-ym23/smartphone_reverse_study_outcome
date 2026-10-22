package androidx.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
class ViewUtils {
    static final Property<View, Rect> CLIP_BOUNDS = null;
    private static final ViewUtilsBase IMPL = null;
    private static final String TAG = "ViewUtils";
    static final Property<View, Float> TRANSITION_ALPHA = null;

    static {
        int r10 = Build.VERSION.SDK_INT;
        if (r10 < 29) goto L7;
        ViewUtilsBase r11 = new ViewUtilsApi29();
    L5:
        IMPL = r11;
        final Class<Float> r12 = Float.class;
        final String r13 = "translationAlpha";
        TRANSITION_ALPHA = new AnonymousClass1(r12, r13);
        final Class<Rect> r14 = Rect.class;
        final String r15 = "clipBounds";
        CLIP_BOUNDS = new AnonymousClass2(r14, r15);
        return;
    L7:
        if (r10 < 23) goto L10;
        r11 = new ViewUtilsApi23();
        goto L5
    L10:
        if (r10 < 22) goto L13;
        r11 = new ViewUtilsApi22();
        goto L5
    L13:
        if (r10 < 21) goto L16;
        r11 = new ViewUtilsApi21();
        goto L5
    L16:
        if (r10 < 19) goto L18;
        r11 = new ViewUtilsApi19();
        goto L5
    L18:
        r11 = new ViewUtilsBase();
        goto L5
    }

    private ViewUtils() {
    }

    static void clearNonTransitionAlpha(@NonNull View r10) {
        IMPL.clearNonTransitionAlpha(r10);
    }

    static ViewOverlayImpl getOverlay(@NonNull View r10) {
        if (Build.VERSION.SDK_INT < 18) goto L7;
        return new ViewOverlayApi18(r10);
    L7:
        return ViewOverlayApi14.createFrom(r10);
    }

    static float getTransitionAlpha(@NonNull View r10) {
        return IMPL.getTransitionAlpha(r10);
    }

    static WindowIdImpl getWindowId(@NonNull View r10) {
        if (Build.VERSION.SDK_INT < 18) goto L7;
        return new WindowIdApi18(r10);
    L7:
        return new WindowIdApi14(r10.getWindowToken());
    }

    static void saveNonTransitionAlpha(@NonNull View r10) {
        IMPL.saveNonTransitionAlpha(r10);
    }

    static void setAnimationMatrix(@NonNull View r10, @Nullable Matrix r11) {
        IMPL.setAnimationMatrix(r10, r11);
    }

    static void setLeftTopRightBottom(@NonNull View r10, int r11, int r12, int r13, int r14) {
        IMPL.setLeftTopRightBottom(r10, r11, r12, r13, r14);
    }

    static void setTransitionAlpha(@NonNull View r10, float r11) {
        IMPL.setTransitionAlpha(r10, r11);
    }

    static void setTransitionVisibility(@NonNull View r10, int r11) {
        IMPL.setTransitionVisibility(r10, r11);
    }

    static void transformMatrixToGlobal(@NonNull View r10, @NonNull Matrix r11) {
        IMPL.transformMatrixToGlobal(r10, r11);
    }

    static void transformMatrixToLocal(@NonNull View r10, @NonNull Matrix r11) {
        IMPL.transformMatrixToLocal(r10, r11);
    }
}
