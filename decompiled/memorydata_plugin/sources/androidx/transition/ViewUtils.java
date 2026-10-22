package androidx.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class ViewUtils {
    static final Property<View, Rect> CLIP_BOUNDS = null;
    private static final ViewUtilsBase IMPL = null;
    private static final String TAG = "ViewUtils";
    static final Property<View, Float> TRANSITION_ALPHA = null;

    static {
        if (Build.VERSION.SDK_INT < 29) goto L7;
        ViewUtilsBase r0 = new ViewUtilsApi29();
    L5:
        IMPL = r0;
        final Class<Float> r1 = Float.class;
        final String r2 = "translationAlpha";
        TRANSITION_ALPHA = new AnonymousClass1(r1, r2);
        final Class<Rect> r3 = Rect.class;
        final String r4 = "clipBounds";
        CLIP_BOUNDS = new AnonymousClass2(r3, r4);
        return;
    L7:
        if (Build.VERSION.SDK_INT < 23) goto L10;
        r0 = new ViewUtilsApi23();
        goto L5
    L10:
        if (Build.VERSION.SDK_INT < 22) goto L13;
        r0 = new ViewUtilsApi22();
        goto L5
    L13:
        if (Build.VERSION.SDK_INT < 21) goto L16;
        r0 = new ViewUtilsApi21();
        goto L5
    L16:
        if (Build.VERSION.SDK_INT < 19) goto L18;
        r0 = new ViewUtilsApi19();
        goto L5
    L18:
        r0 = new ViewUtilsBase();
        goto L5
    }

    private ViewUtils() {
    }

    static void clearNonTransitionAlpha(View r1) {
        IMPL.clearNonTransitionAlpha(r1);
    }

    static ViewOverlayImpl getOverlay(View r2) {
        if (Build.VERSION.SDK_INT < 18) goto L7;
        return new ViewOverlayApi18(r2);
    L7:
        return ViewOverlayApi14.createFrom(r2);
    }

    static float getTransitionAlpha(View r1) {
        return IMPL.getTransitionAlpha(r1);
    }

    static WindowIdImpl getWindowId(View r2) {
        if (Build.VERSION.SDK_INT < 18) goto L7;
        return new WindowIdApi18(r2);
    L7:
        return new WindowIdApi14(r2.getWindowToken());
    }

    static void saveNonTransitionAlpha(View r1) {
        IMPL.saveNonTransitionAlpha(r1);
    }

    static void setAnimationMatrix(View r1, Matrix r2) {
        IMPL.setAnimationMatrix(r1, r2);
    }

    static void setLeftTopRightBottom(View r6, int r7, int r8, int r9, int r10) {
        IMPL.setLeftTopRightBottom(r6, r7, r8, r9, r10);
    }

    static void setTransitionAlpha(View r1, float r2) {
        IMPL.setTransitionAlpha(r1, r2);
    }

    static void setTransitionVisibility(View r1, int r2) {
        IMPL.setTransitionVisibility(r1, r2);
    }

    static void transformMatrixToGlobal(View r1, Matrix r2) {
        IMPL.transformMatrixToGlobal(r1, r2);
    }

    static void transformMatrixToLocal(View r1, Matrix r2) {
        IMPL.transformMatrixToLocal(r1, r2);
    }
}
