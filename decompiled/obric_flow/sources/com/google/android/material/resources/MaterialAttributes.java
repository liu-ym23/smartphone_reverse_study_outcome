package com.google.android.material.resources;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import com.google.android.material.R;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class MaterialAttributes {
    public MaterialAttributes() {
    }

    @Nullable
    public static TypedValue resolve(@NonNull Context r5, @AttrRes int r10) {
        TypedValue r11 = new TypedValue();
        if (r5.getTheme().resolveAttribute(r10, r11, true) == false) goto L5;
        return r11;
    L5:
        return null;
    }

    public static boolean resolveBoolean(@NonNull Context r5, @AttrRes int r10, boolean r11) {
        TypedValue r12 = resolve(r5, r10);
        if (r12 != null) goto L5;
        return r11;
    L5:
        if (r12.type == 18) goto L7;
        return r11;
    L7:
        if (r12.data == 0) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean resolveBooleanOrThrow(@NonNull Context r5, @AttrRes int r10, @NonNull String r11) {
        if (resolveOrThrow(r5, r10, r11) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Px
    public static int resolveDimension(@NonNull Context r5, @AttrRes int r10, @DimenRes int r11) {
        TypedValue r12 = resolve(r5, r10);
        if (r12 != null) goto L5;
    L10:
        float r13 = r5.getResources().getDimension(r11);
    L9:
        return (int) r13;
    L5:
        if (r12.type != 5) goto L10;
        r13 = r12.getDimension(r5.getResources().getDisplayMetrics());
        goto L9
    }

    public static int resolveInteger(@NonNull Context r5, @AttrRes int r10, int r11) {
        TypedValue r12 = resolve(r5, r10);
        if (r12 != null) goto L5;
        return r11;
    L5:
        if (r12.type == 16) goto L7;
        return r11;
    L7:
        return r12.data;
    }

    @Px
    public static int resolveMinimumAccessibleTouchTarget(@NonNull Context r5) {
        return resolveDimension(r5, R.attr.minTouchTargetSize, R.dimen.mtrl_min_touch_target_size);
    }

    public static int resolveOrThrow(@NonNull Context r5, @AttrRes int r10, @NonNull String r11) {
        return resolveTypedValueOrThrow(r5, r10, r11).data;
    }

    @NonNull
    public static TypedValue resolveTypedValueOrThrow(@NonNull View r5, @AttrRes int r10) {
        return resolveTypedValueOrThrow(r5.getContext(), r10, r5.getClass().getCanonicalName());
    }

    public static int resolveOrThrow(@NonNull View r5, @AttrRes int r10) {
        return resolveTypedValueOrThrow(r5, r10).data;
    }

    @NonNull
    public static TypedValue resolveTypedValueOrThrow(@NonNull Context r5, @AttrRes int r10, @NonNull String r11) {
        TypedValue r12 = resolve(r5, r10);
        if (r12 == null) goto L6;
        return r12;
    L6:
        throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", new Object[]{r11, r5.getResources().getResourceName(r10)}));
    }
}
