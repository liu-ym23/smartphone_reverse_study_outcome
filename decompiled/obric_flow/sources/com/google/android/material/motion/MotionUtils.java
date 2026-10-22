package com.google.android.material.motion;

import ai.j0;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.TypedValue;
import android.view.animation.AnimationUtils;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.core.graphics.PathParser;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.google.android.material.resources.MaterialAttributes;

/* JADX INFO: loaded from: classes2.dex */
public class MotionUtils {
    private static final String EASING_TYPE_CUBIC_BEZIER = "cubic-bezier";
    private static final String EASING_TYPE_FORMAT_END = ")";
    private static final String EASING_TYPE_FORMAT_START = "(";
    private static final String EASING_TYPE_PATH = "path";

    private MotionUtils() {
    }

    private static float getLegacyControlPoint(String[] r5, int r10) {
        float r11 = Float.parseFloat(r5[r10]);
        if (r11 < 0.0f) goto L8;
        if (r11 > 1.0f) goto L8;
        return r11;
    L8:
        throw new IllegalArgumentException("Motion easing control point value must be between 0 and 1; instead got: " + r11);
    }

    private static String getLegacyEasingContent(String r5, String r10) {
        return androidx.constraintlayout.motion.widget.a.n(r5, 1, r10.length() + 1);
    }

    private static TimeInterpolator getLegacyThemeInterpolator(String r5) {
        if (isLegacyEasingType(r5, EASING_TYPE_CUBIC_BEZIER) == false) goto L11;
        String[] r10 = getLegacyEasingContent(r5, EASING_TYPE_CUBIC_BEZIER).split(",");
        if (r10.length != 4) goto L9;
        return PathInterpolatorCompat.create(getLegacyControlPoint(r10, 0), getLegacyControlPoint(r10, 1), getLegacyControlPoint(r10, 2), getLegacyControlPoint(r10, 3));
    L9:
        throw new IllegalArgumentException("Motion easing theme attribute must have 4 control points if using bezier curve format; instead got: " + r10.length);
    L11:
        if (isLegacyEasingType(r5, "path") == false) goto L15;
        return PathInterpolatorCompat.create(PathParser.createPathFromPathData(getLegacyEasingContent(r5, "path")));
    L15:
        throw new IllegalArgumentException(j0.C("Invalid motion easing type: ", r5));
    }

    private static boolean isLegacyEasingAttribute(String r5) {
        if (isLegacyEasingType(r5, EASING_TYPE_CUBIC_BEZIER) == false) goto L5;
    L8:
        return true;
    L5:
        if (isLegacyEasingType(r5, "path") == true) goto L8;
        return false;
    }

    private static boolean isLegacyEasingType(String r5, String r10) {
        if (r5.startsWith(r10 + EASING_TYPE_FORMAT_START) == true) goto L5;
    L7:
        return false;
    L5:
        if (r5.endsWith(EASING_TYPE_FORMAT_END) == false) goto L7;
        return true;
    }

    public static int resolveThemeDuration(@NonNull Context r5, @AttrRes int r10, int r11) {
        return MaterialAttributes.resolveInteger(r5, r10, r11);
    }

    @NonNull
    public static TimeInterpolator resolveThemeInterpolator(@NonNull Context r5, @AttrRes int r10, @NonNull TimeInterpolator r11) {
        TypedValue r12 = new TypedValue();
        if (r5.getTheme().resolveAttribute(r10, r12, true) == true) goto L6;
        return r11;
    L6:
        if (r12.type != 3) goto L14;
        String r13 = String.valueOf(r12.string);
        if (isLegacyEasingAttribute(r13) == false) goto L12;
        return getLegacyThemeInterpolator(r13);
    L12:
        return AnimationUtils.loadInterpolator(r5, r12.resourceId);
    L14:
        throw new IllegalArgumentException("Motion easing theme attribute must be an @interpolator resource for ?attr/motionEasing*Interpolator attributes or a string for ?attr/motionEasing* attributes.");
    }
}
