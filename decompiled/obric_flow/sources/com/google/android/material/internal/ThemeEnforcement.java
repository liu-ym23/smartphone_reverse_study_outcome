package com.google.android.material.internal;

import ai.j0;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.StyleableRes;
import androidx.appcompat.widget.TintTypedArray;
import com.google.android.material.R;
import com.google.android.material.resources.MaterialAttributes;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class ThemeEnforcement {
    private static final int[] APPCOMPAT_CHECK_ATTRS = null;
    private static final String APPCOMPAT_THEME_NAME = "Theme.AppCompat";
    private static final int[] MATERIAL_CHECK_ATTRS = null;
    private static final String MATERIAL_THEME_NAME = "Theme.MaterialComponents";

    static {
        APPCOMPAT_CHECK_ATTRS = new int[]{R.attr.colorPrimary};
        MATERIAL_CHECK_ATTRS = new int[]{R.attr.colorPrimaryVariant};
    }

    private ThemeEnforcement() {
    }

    public static void checkAppCompatTheme(@NonNull Context r5) {
        checkTheme(r5, APPCOMPAT_CHECK_ATTRS, APPCOMPAT_THEME_NAME);
    }

    private static void checkCompatibleTheme(@NonNull Context r5, AttributeSet r10, @AttrRes int r11, @StyleRes int r12) {
        TypedArray r13 = r5.obtainStyledAttributes(r10, R.styleable.ThemeEnforcement, r11, r12);
        boolean r14 = r13.getBoolean(R.styleable.ThemeEnforcement_enforceMaterialTheme, false);
        r13.recycle();
        if (r14 == false) goto L11;
        TypedValue r15 = new TypedValue();
        if (r5.getTheme().resolveAttribute(R.attr.isMaterialTheme, r15, true) == true) goto L7;
    L10:
        checkMaterialTheme(r5);
        goto L11
    L7:
        if (r15.type != 18) goto L11;
        if (r15.data == 0) goto L10;
    L11:
        checkAppCompatTheme(r5);
    }

    public static void checkMaterialTheme(@NonNull Context r5) {
        checkTheme(r5, MATERIAL_CHECK_ATTRS, MATERIAL_THEME_NAME);
    }

    private static void checkTextAppearance(@NonNull Context r5, AttributeSet r10, @NonNull @StyleableRes int[] r11, @AttrRes int r12, @StyleRes int r13, @Nullable @StyleableRes int... r14) {
        TypedArray r15 = r5.obtainStyledAttributes(r10, R.styleable.ThemeEnforcement, r12, r13);
        boolean r16 = false;
        if (r15.getBoolean(R.styleable.ThemeEnforcement_enforceTextAppearance, false) == true) goto L6;
        r15.recycle();
        return;
    L6:
        if (r14 == null) goto L12;
        if (r14.length == 0) goto L12;
        boolean r17 = isCustomTextAppearanceValid(r5, r10, r11, r12, r13, r14);
    L15:
        r15.recycle();
        if (r17 == false) goto L19;
        return;
    L19:
        throw new IllegalArgumentException("This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant).");
    L12:
        if (r15.getResourceId(R.styleable.ThemeEnforcement_android_textAppearance, -1) == (-1)) goto L14;
        r16 = true;
    L14:
        r17 = r16;
        goto L15
    }

    private static void checkTheme(@NonNull Context r5, @NonNull int[] r10, String r11) {
        if (isTheme(r5, r10) == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException(j0.k("The style on this component requires your app theme to be ", r11, " (or a descendant)."));
    }

    public static boolean isAppCompatTheme(@NonNull Context r5) {
        return isTheme(r5, APPCOMPAT_CHECK_ATTRS);
    }

    private static boolean isCustomTextAppearanceValid(@NonNull Context r5, AttributeSet r10, @NonNull @StyleableRes int[] r11, @AttrRes int r12, @StyleRes int r13, @NonNull @StyleableRes int... r14) {
        TypedArray r15 = r5.obtainStyledAttributes(r10, r11, r12, r13);
        int r16 = r14.length;
        int r17 = 0;
    L3:
        if (r17 >= r16) goto L9;
        if (r15.getResourceId(r14[r17], -1) == (-1)) goto L6;
        r17 = r17 + 1;
        goto L3
    L6:
        r15.recycle();
        return false;
    L9:
        r15.recycle();
        return true;
    }

    public static boolean isMaterial3Theme(@NonNull Context r5) {
        return MaterialAttributes.resolveBoolean(r5, R.attr.isMaterial3Theme, false);
    }

    public static boolean isMaterialTheme(@NonNull Context r5) {
        return isTheme(r5, MATERIAL_CHECK_ATTRS);
    }

    private static boolean isTheme(@NonNull Context r5, @NonNull int[] r10) {
        TypedArray r11 = r5.obtainStyledAttributes(r10);
        int r12 = 0;
    L4:
        if (r12 >= r10.length) goto L10;
        if (r11.hasValue(r12) == false) goto L7;
        r12 = r12 + 1;
        goto L4
    L7:
        r11.recycle();
        return false;
    L10:
        r11.recycle();
        return true;
    }

    @NonNull
    public static TypedArray obtainStyledAttributes(@NonNull Context r5, AttributeSet r10, @NonNull @StyleableRes int[] r11, @AttrRes int r12, @StyleRes int r13, @StyleableRes int... r14) {
        checkCompatibleTheme(r5, r10, r12, r13);
        checkTextAppearance(r5, r10, r11, r12, r13, r14);
        return r5.obtainStyledAttributes(r10, r11, r12, r13);
    }

    public static TintTypedArray obtainTintedStyledAttributes(@NonNull Context r5, AttributeSet r10, @NonNull @StyleableRes int[] r11, @AttrRes int r12, @StyleRes int r13, @StyleableRes int... r14) {
        checkCompatibleTheme(r5, r10, r12, r13);
        checkTextAppearance(r5, r10, r11, r12, r13, r14);
        return TintTypedArray.obtainStyledAttributes(r5, r10, r11, r12, r13);
    }
}
