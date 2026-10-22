package com.google.android.material.resources;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class b {
    @Nullable
    public static TypedValue a(@NonNull Context r10, @AttrRes int r11) {
        TypedValue r12 = new TypedValue();
        if (r10.getTheme().resolveAttribute(r11, r12, true) == false) goto L5;
        return r12;
    L5:
        return null;
    }

    public static boolean b(@NonNull Context r10, @AttrRes int r11, boolean r12) {
        TypedValue r13 = a(r10, r11);
        if (r13 != null) goto L5;
        return r12;
    L5:
        if (r13.type == 18) goto L7;
        return r12;
    L7:
        if (r13.data == 0) goto L9;
        return true;
    L9:
        return false;
    }

    public static int c(@NonNull Context r10, @AttrRes int r11, int r12) {
        TypedValue r13 = a(r10, r11);
        if (r13 != null) goto L5;
        return r12;
    L5:
        if (r13.type == 16) goto L7;
        return r12;
    L7:
        return r13.data;
    }

    public static int d(@NonNull Context r10, @AttrRes int r11, @NonNull String r12) {
        TypedValue r13 = a(r10, r11);
        if (r13 == null) goto L7;
        return r13.data;
    L7:
        throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", new Object[]{r12, r10.getResources().getResourceName(r11)}));
    }

    public static int e(@NonNull View r10, @AttrRes int r11) {
        return d(r10.getContext(), r11, r10.getClass().getCanonicalName());
    }
}
