package com.google.android.material.ripple;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.util.StateSet;
import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.annotation.ColorInt;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class RippleUtils {
    private static final int[] ENABLED_PRESSED_STATE_SET = null;
    private static final int[] FOCUSED_STATE_SET = null;
    private static final int[] HOVERED_FOCUSED_STATE_SET = null;
    private static final int[] HOVERED_STATE_SET = null;

    @VisibleForTesting
    static final String LOG_TAG = null;
    private static final int[] PRESSED_STATE_SET = null;
    private static final int[] SELECTED_FOCUSED_STATE_SET = null;
    private static final int[] SELECTED_HOVERED_FOCUSED_STATE_SET = null;
    private static final int[] SELECTED_HOVERED_STATE_SET = null;
    private static final int[] SELECTED_PRESSED_STATE_SET = null;
    private static final int[] SELECTED_STATE_SET = null;

    @VisibleForTesting
    static final String TRANSPARENT_DEFAULT_COLOR_WARNING = "Use a non-transparent color for the default color as it will be used to finish ripple animations.";

    @ChecksSdkIntAtLeast(api = 21)
    public static final boolean USE_FRAMEWORK_RIPPLE = false;

    @RequiresApi(21)
    public static class RippleUtilsLollipop {
        private RippleUtilsLollipop() {
        }

        public static /* synthetic */ Drawable access$000(Context r5, int r10) {
            return createOvalRipple(r5, r10);
        }

        @DoNotInline
        private static Drawable createOvalRipple(@NonNull Context r10, @Px int r11) {
            GradientDrawable r5 = new GradientDrawable();
            r5.setColor(-1);
            r5.setShape(1);
            InsetDrawable r12 = new InsetDrawable(r5, r11, r11, r11, r11);
            return new RippleDrawable(MaterialColors.getColorStateList(r10, R.attr.colorControlHighlight, ColorStateList.valueOf(0)), null, r12);
        }
    }

    static {
        USE_FRAMEWORK_RIPPLE = true;
        PRESSED_STATE_SET = new int[]{android.R.attr.state_pressed};
        HOVERED_FOCUSED_STATE_SET = new int[]{android.R.attr.state_hovered, android.R.attr.state_focused};
        FOCUSED_STATE_SET = new int[]{android.R.attr.state_focused};
        HOVERED_STATE_SET = new int[]{android.R.attr.state_hovered};
        SELECTED_PRESSED_STATE_SET = new int[]{android.R.attr.state_selected, android.R.attr.state_pressed};
        SELECTED_HOVERED_FOCUSED_STATE_SET = new int[]{android.R.attr.state_selected, android.R.attr.state_hovered, android.R.attr.state_focused};
        SELECTED_FOCUSED_STATE_SET = new int[]{android.R.attr.state_selected, android.R.attr.state_focused};
        SELECTED_HOVERED_STATE_SET = new int[]{android.R.attr.state_selected, android.R.attr.state_hovered};
        SELECTED_STATE_SET = new int[]{android.R.attr.state_selected};
        ENABLED_PRESSED_STATE_SET = new int[]{android.R.attr.state_enabled, android.R.attr.state_pressed};
        LOG_TAG = "RippleUtils";
    }

    private RippleUtils() {
    }

    @NonNull
    public static ColorStateList convertToRippleDrawableColor(@Nullable ColorStateList r10) {
        if (USE_FRAMEWORK_RIPPLE == false) goto L6;
        int[] r5 = FOCUSED_STATE_SET;
        return new ColorStateList(new int[][]{SELECTED_STATE_SET, r5, StateSet.NOTHING}, new int[]{getColorForState(r10, SELECTED_PRESSED_STATE_SET), getColorForState(r10, r5), getColorForState(r10, PRESSED_STATE_SET)});
    L6:
        int[] r11 = SELECTED_PRESSED_STATE_SET;
        int[] r12 = SELECTED_HOVERED_FOCUSED_STATE_SET;
        int[] r13 = SELECTED_FOCUSED_STATE_SET;
        int[] r14 = SELECTED_HOVERED_STATE_SET;
        int[] r15 = PRESSED_STATE_SET;
        int[] r16 = HOVERED_FOCUSED_STATE_SET;
        int[] r17 = FOCUSED_STATE_SET;
        int[] r18 = HOVERED_STATE_SET;
        return new ColorStateList(new int[][]{r11, r12, r13, r14, SELECTED_STATE_SET, r15, r16, r17, r18, StateSet.NOTHING}, new int[]{getColorForState(r10, r11), getColorForState(r10, r12), getColorForState(r10, r13), getColorForState(r10, r14), 0, getColorForState(r10, r15), getColorForState(r10, r16), getColorForState(r10, r17), getColorForState(r10, r18), 0});
    }

    @NonNull
    @RequiresApi(21)
    public static Drawable createOvalRippleLollipop(@NonNull Context r5, @Px int r10) {
        return RippleUtilsLollipop.access$000(r5, r10);
    }

    @ColorInt
    @TargetApi(21)
    private static int doubleAlpha(@ColorInt int r5) {
        return ColorUtils.setAlphaComponent(r5, Math.min(Color.alpha(r5) * 2, 255));
    }

    @ColorInt
    private static int getColorForState(@Nullable ColorStateList r5, int[] r10) {
        if (r5 == null) goto L4;
        int r11 = r5.getColorForState(r10, r5.getDefaultColor());
    L6:
        if (USE_FRAMEWORK_RIPPLE == true) goto L8;
        return r11;
    L8:
        return doubleAlpha(r11);
    L4:
        r11 = 0;
        goto L6
    }

    @NonNull
    public static ColorStateList sanitizeRippleDrawableColor(@Nullable ColorStateList r5) {
        if (r5 == null) goto L5;
        return r5;
    L5:
        return ColorStateList.valueOf(0);
    }

    public static boolean shouldDrawRippleCompat(@NonNull int[] r10) {
        int r5 = r10.length;
        int r11 = 0;
        boolean r12 = false;
        boolean r13 = false;
    L4:
        if (r11 >= r5) goto L18;
        int r14 = r10[r11];
        if (r14 != 16842910) goto L9;
        r12 = true;
    L17:
        r11 = r11 + 1;
        goto L4
    L9:
        if (r14 != 16842908) goto L12;
    L10:
        r13 = true;
        goto L17
    L12:
        if (r14 == 16842919) goto L10;
        if (r14 != 16843623) goto L17;
    L18:
        if (r12 == false) goto L26;
        if (r13 == true) goto L21;
        return false;
    L21:
        return true;
    L26:
        return false;
    }
}
