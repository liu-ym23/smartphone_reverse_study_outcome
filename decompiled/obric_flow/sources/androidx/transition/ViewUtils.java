package androidx.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Property;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
class ViewUtils {
    static final Property<View, Rect> CLIP_BOUNDS = null;
    private static final ViewUtilsApi19 IMPL = null;
    private static final String TAG = "ViewUtils";
    static final Property<View, Float> TRANSITION_ALPHA = null;

    static {
        IMPL = new ViewUtilsApi29();
        final Class<Float> r5 = Float.class;
        final String r10 = "translationAlpha";
        TRANSITION_ALPHA = new AnonymousClass1(r5, r10);
        final Class<Rect> r11 = Rect.class;
        final String r12 = "clipBounds";
        CLIP_BOUNDS = new AnonymousClass2(r11, r12);
    }

    private ViewUtils() {
    }

    public static void clearNonTransitionAlpha(@NonNull View r5) {
        IMPL.clearNonTransitionAlpha(r5);
    }

    public static float getTransitionAlpha(@NonNull View r5) {
        return IMPL.getTransitionAlpha(r5);
    }

    public static void saveNonTransitionAlpha(@NonNull View r5) {
        IMPL.saveNonTransitionAlpha(r5);
    }

    public static void setAnimationMatrix(@NonNull View r5, @Nullable Matrix r10) {
        IMPL.setAnimationMatrix(r5, r10);
    }

    public static void setLeftTopRightBottom(@NonNull View r10, int r11, int r12, int r13, int r14) {
        IMPL.setLeftTopRightBottom(r10, r11, r12, r13, r14);
    }

    public static void setTransitionAlpha(@NonNull View r5, float r10) {
        IMPL.setTransitionAlpha(r5, r10);
    }

    public static void setTransitionVisibility(@NonNull View r5, int r10) {
        IMPL.setTransitionVisibility(r5, r10);
    }

    public static void transformMatrixToGlobal(@NonNull View r5, @NonNull Matrix r10) {
        IMPL.transformMatrixToGlobal(r5, r10);
    }

    public static void transformMatrixToLocal(@NonNull View r5, @NonNull Matrix r10) {
        IMPL.transformMatrixToLocal(r5, r10);
    }
}
