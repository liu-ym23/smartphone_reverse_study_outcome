package com.google.android.material.shape;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import com.google.android.material.internal.ViewUtils;

/* JADX INFO: loaded from: classes2.dex */
public class MaterialShapeUtils {
    private MaterialShapeUtils() {
    }

    @NonNull
    public static CornerTreatment createCornerTreatment(int r5) {
        if (r5 == 0) goto L10;
        if (r5 == 1) goto L8;
        return createDefaultCornerTreatment();
    L8:
        return new CutCornerTreatment();
    L10:
        return new RoundedCornerTreatment();
    }

    @NonNull
    public static CornerTreatment createDefaultCornerTreatment() {
        return new RoundedCornerTreatment();
    }

    @NonNull
    public static EdgeTreatment createDefaultEdgeTreatment() {
        return new EdgeTreatment();
    }

    public static void setElevation(@NonNull View r5, float r10) {
        Drawable r11 = r5.getBackground();
        if ((r11 instanceof MaterialShapeDrawable) == false) goto L6;
        ((MaterialShapeDrawable) r11).setElevation(r10);
        return;
    }

    public static void setParentAbsoluteElevation(@NonNull View r5) {
        Drawable r10 = r5.getBackground();
        if ((r10 instanceof MaterialShapeDrawable) == false) goto L6;
        setParentAbsoluteElevation(r5, (MaterialShapeDrawable) r10);
        return;
    }

    public static void setParentAbsoluteElevation(@NonNull View r5, @NonNull MaterialShapeDrawable r10) {
        if (r10.isElevationOverlayEnabled() == false) goto L6;
        r10.setParentAbsoluteElevation(ViewUtils.getParentAbsoluteElevation(r5));
        return;
    }
}
