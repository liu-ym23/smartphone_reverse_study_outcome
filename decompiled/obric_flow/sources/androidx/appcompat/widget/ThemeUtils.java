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

    public static void checkAppCompatTheme(@NonNull View r5, @NonNull Context r10) {
        TypedArray r11 = r10.obtainStyledAttributes(androidx.appcompat.R.styleable.AppCompatTheme);
    L7:
        th = move-exception;
        r11.recycle();
        throw th;
    L4:
        if (r11.hasValue(androidx.appcompat.R.styleable.AppCompatTheme_windowActionBar) == true) goto L9;
        Log.e(TAG, "View " + r5.getClass() + " is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");     // Catch: Throwable -> L7
    L9:
        r11.recycle();
    }

    @NonNull
    public static ColorStateList createDisabledStateList(int r5, int r10) {
        return new ColorStateList(new int[][]{DISABLED_STATE_SET, EMPTY_STATE_SET}, new int[]{r10, r5});
    }

    public static int getDisabledThemeAttrColor(@NonNull Context r5, int r10) {
        ColorStateList r11 = getThemeAttrColorStateList(r5, r10);
        if (r11 != null) goto L5;
    L8:
        TypedValue r12 = getTypedValue();
        r5.getTheme().resolveAttribute(R.attr.disabledAlpha, r12, true);
        return getThemeAttrColor(r5, r10, r12.getFloat());
    L5:
        if (r11.isStateful() == false) goto L8;
        return r11.getColorForState(DISABLED_STATE_SET, r11.getDefaultColor());
    }

    public static int getThemeAttrColor(@NonNull Context r5, int r10) {
        int[] r11 = TEMP_ARRAY;
        r11[0] = r10;
        TintTypedArray r12 = TintTypedArray.obtainStyledAttributes(r5, null, r11);
        int r13 = r12.getColor(0, 0);     // Catch: Throwable -> L6
        r12.recycle();
        return r13;
    L6:
        th = move-exception;
        r12.recycle();
        throw th;
    }

    @Nullable
    public static ColorStateList getThemeAttrColorStateList(@NonNull Context r5, int r10) {
        int[] r11 = TEMP_ARRAY;
        r11[0] = r10;
        TintTypedArray r12 = TintTypedArray.obtainStyledAttributes(r5, null, r11);
        ColorStateList r13 = r12.getColorStateList(0);     // Catch: Throwable -> L6
        r12.recycle();
        return r13;
    L6:
        th = move-exception;
        r12.recycle();
        throw th;
    }

    private static TypedValue getTypedValue() {
        ThreadLocal<TypedValue> r5 = TL_TYPED_VALUE;
        TypedValue r10 = r5.get();
        if (r10 != null) goto L6;
        TypedValue r11 = new TypedValue();
        r5.set(r11);
        return r11;
    L6:
        return r10;
    }

    public static int getThemeAttrColor(@NonNull Context r5, int r10, float r11) {
        int r12 = getThemeAttrColor(r5, r10);
        return ColorUtils.setAlphaComponent(r12, Math.round(Color.alpha(r12) * r11));
    }
}
