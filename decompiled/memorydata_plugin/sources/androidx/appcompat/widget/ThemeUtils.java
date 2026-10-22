package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import androidx.core.graphics.ColorUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
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

    public static void checkAppCompatTheme(View r3, Context r4) {
        TypedArray r5 = ((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin")).obtainStyledAttributes(com.obric.memorydata.plugin.R.styleable.AppCompatTheme);
    L8:
        th = move-exception;
        r5.recycle();
        throw th;
    L4:
        if (r5.hasValue(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.AppCompatTheme_windowActionBar, "styleable", "AppCompatTheme_windowActionBar")) == true) goto L6;
        Log.e(TAG, "View " + r3.getClass() + " is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");     // Catch: Throwable -> L8
    L6:
        r5.recycle();
    }

    public static ColorStateList createDisabledStateList(int r4, int r5) {
        return new ColorStateList(new int[][]{DISABLED_STATE_SET, EMPTY_STATE_SET}, new int[]{r5, r4});
    }

    public static int getDisabledThemeAttrColor(Context r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        ColorStateList r0 = getThemeAttrColorStateList(r6, r5);
        if (r0 != null) goto L5;
    L8:
        TypedValue r1 = getTypedValue();
        r6.getTheme().resolveAttribute(R.attr.disabledAlpha, r1, true);
        return getThemeAttrColor(r6, r5, r1.getFloat());
    L5:
        if (r0.isStateful() == false) goto L8;
        return r0.getColorForState(DISABLED_STATE_SET, r0.getDefaultColor());
    }

    public static int getThemeAttrColor(Context r2, int r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        int[] r0 = TEMP_ARRAY;
        r0[0] = r3;
        TintTypedArray r5 = TintTypedArray.obtainStyledAttributes(r4, null, r0);
        int r6 = r5.getColor(0, 0);     // Catch: Throwable -> L6
        r5.recycle();
        return r6;
    L6:
        th = move-exception;
        r5.recycle();
        throw th;
    }

    static int getThemeAttrColor(Context r2, int r3, float r4) {
        int r5 = getThemeAttrColor((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3);
        return ColorUtils.setAlphaComponent(r5, Math.round(Color.alpha(r5) * r4));
    }

    public static ColorStateList getThemeAttrColorStateList(Context r2, int r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        int[] r0 = TEMP_ARRAY;
        r0[0] = r3;
        TintTypedArray r5 = TintTypedArray.obtainStyledAttributes(r4, null, r0);
        ColorStateList r6 = r5.getColorStateList(0);     // Catch: Throwable -> L6
        r5.recycle();
        return r6;
    L6:
        th = move-exception;
        r5.recycle();
        throw th;
    }

    private static TypedValue getTypedValue() {
        ThreadLocal<TypedValue> r0 = TL_TYPED_VALUE;
        TypedValue r1 = (TypedValue) ZeusTransformUtils.preCheckCast(r0.get(), TypedValue.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L6;
        TypedValue r2 = new TypedValue();
        r0.set(r2);
        return r2;
    L6:
        return r1;
    }
}
