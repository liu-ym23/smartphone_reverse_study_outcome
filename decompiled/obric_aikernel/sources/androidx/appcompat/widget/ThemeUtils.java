package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.ColorUtils;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class ThemeUtils {
    static final int[] ACTIVATED_STATE_SET = null;
    static final int[] CHECKED_STATE_SET = null;
    static final int[] DISABLED_STATE_SET = null;
    static final int[] EMPTY_STATE_SET = null;
    static final int[] FOCUSED_STATE_SET = null;
    static final int[] NOT_PRESSED_OR_FOCUSED_STATE_SET = null;
    static final int[] PRESSED_STATE_SET = null;
    static final int[] SELECTED_STATE_SET = null;
    private static final String TAG = "ThemeUtils";
    private static final int[] TEMP_ARRAY = null;
    private static final ThreadLocal<TypedValue> TL_TYPED_VALUE = null;

    static {
        TL_TYPED_VALUE = new ThreadLocal();
        DISABLED_STATE_SET = new int[]{-16842910};
        FOCUSED_STATE_SET = new int[]{R.attr.state_focused};
        ACTIVATED_STATE_SET = new int[]{R.attr.state_activated};
        PRESSED_STATE_SET = new int[]{R.attr.state_pressed};
        CHECKED_STATE_SET = new int[]{R.attr.state_checked};
        SELECTED_STATE_SET = new int[]{R.attr.state_selected};
        NOT_PRESSED_OR_FOCUSED_STATE_SET = new int[]{-16842919, -16842908};
        EMPTY_STATE_SET = new int[0];
        TEMP_ARRAY = new int[1];
    }

    private ThemeUtils() {
    }

    public static void checkAppCompatTheme(@NonNull View r10, @NonNull Context r11) {
        TypedArray r12 = r11.obtainStyledAttributes(androidx.appcompat.R.styleable.AppCompatTheme);
    L8:
        th = move-exception;
        r12.recycle();
        throw th;
    L4:
        if (r12.hasValue(androidx.appcompat.R.styleable.AppCompatTheme_windowActionBar) == true) goto L6;
        Log.e(TAG, "View " + r10.getClass() + " is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");     // Catch: Throwable -> L8
    L6:
        r12.recycle();
    }

    @NonNull
    public static ColorStateList createDisabledStateList(int r10, int r11) {
        return new ColorStateList(new int[][]{DISABLED_STATE_SET, EMPTY_STATE_SET}, new int[]{r11, r10});
    }

    public static int getDisabledThemeAttrColor(@NonNull Context r10, int r11) {
        ColorStateList r12 = getThemeAttrColorStateList(r10, r11);
        if (r12 != null) goto L5;
    L8:
        TypedValue r13 = getTypedValue();
        r10.getTheme().resolveAttribute(R.attr.disabledAlpha, r13, true);
        return getThemeAttrColor(r10, r11, r13.getFloat());
    L5:
        if (r12.isStateful() == false) goto L8;
        return r12.getColorForState(DISABLED_STATE_SET, r12.getDefaultColor());
    }

    public static int getThemeAttrColor(@NonNull Context r10, int r11) {
        int[] r12 = TEMP_ARRAY;
        r12[0] = r11;
        TintTypedArray r13 = TintTypedArray.obtainStyledAttributes(r10, null, r12);
        int r14 = r13.getColor(0, 0);     // Catch: Throwable -> L6
        r13.recycle();
        return r14;
    L6:
        th = move-exception;
        r13.recycle();
        throw th;
    }

    static int getThemeAttrColor(@NonNull Context r10, int r11, float r12) {
        int r13 = getThemeAttrColor(r10, r11);
        return ColorUtils.setAlphaComponent(r13, Math.round(Color.alpha(r13) * r12));
    }

    @Nullable
    public static ColorStateList getThemeAttrColorStateList(@NonNull Context r10, int r11) {
        int[] r12 = TEMP_ARRAY;
        r12[0] = r11;
        TintTypedArray r13 = TintTypedArray.obtainStyledAttributes(r10, null, r12);
        ColorStateList r14 = r13.getColorStateList(0);     // Catch: Throwable -> L6
        r13.recycle();
        return r14;
    L6:
        th = move-exception;
        r13.recycle();
        throw th;
    }

    private static TypedValue getTypedValue() {
        ThreadLocal<TypedValue> r10 = TL_TYPED_VALUE;
        TypedValue r11 = r10.get();
        if (r11 != null) goto L6;
        TypedValue r12 = new TypedValue();
        r10.set(r12);
        return r12;
    L6:
        return r11;
    }
}
