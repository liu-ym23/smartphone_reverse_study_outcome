package com.google.android.material.internal;

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

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f3449a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f3450b = null;

    static {
        f3449a = new int[]{q5.b.colorPrimary};
        f3450b = new int[]{q5.b.colorPrimaryVariant};
    }

    public static void a(@NonNull Context r10) {
        e(r10, f3449a, "Theme.AppCompat");
    }

    private static void b(@NonNull Context r10, AttributeSet r11, @AttrRes int r12, @StyleRes int r13) {
        TypedArray r14 = r10.obtainStyledAttributes(r11, q5.l.ThemeEnforcement, r12, r13);
        boolean r15 = r14.getBoolean(q5.l.ThemeEnforcement_enforceMaterialTheme, false);
        r14.recycle();
        if (r15 == false) goto L11;
        TypedValue r16 = new TypedValue();
        if (r10.getTheme().resolveAttribute(q5.b.isMaterialTheme, r16, true) == true) goto L7;
    L10:
        c(r10);
        goto L11
    L7:
        if (r16.type != 18) goto L11;
        if (r16.data == 0) goto L10;
    L11:
        a(r10);
    }

    public static void c(@NonNull Context r10) {
        e(r10, f3450b, "Theme.MaterialComponents");
    }

    private static void d(@NonNull Context r10, AttributeSet r11, @NonNull @StyleableRes int[] r12, @AttrRes int r13, @StyleRes int r14, @Nullable @StyleableRes int... r15) {
        TypedArray r16 = r10.obtainStyledAttributes(r11, q5.l.ThemeEnforcement, r13, r14);
        boolean r17 = false;
        if (r16.getBoolean(q5.l.ThemeEnforcement_enforceTextAppearance, false) == true) goto L6;
        r16.recycle();
        return;
    L6:
        if (r15 == null) goto L12;
        if (r15.length == 0) goto L12;
        boolean r18 = f(r10, r11, r12, r13, r14, r15);
    L15:
        r16.recycle();
        if (r18 == false) goto L19;
        return;
    L19:
        throw new IllegalArgumentException("This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant).");
    L12:
        if (r16.getResourceId(q5.l.ThemeEnforcement_android_textAppearance, -1) == (-1)) goto L14;
        r17 = true;
    L14:
        r18 = r17;
        goto L15
    }

    private static void e(@NonNull Context r10, @NonNull int[] r11, String r12) {
        if (g(r10, r11) == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("The style on this component requires your app theme to be " + r12 + " (or a descendant).");
    }

    private static boolean f(@NonNull Context r10, AttributeSet r11, @NonNull @StyleableRes int[] r12, @AttrRes int r13, @StyleRes int r14, @NonNull @StyleableRes int... r15) {
        TypedArray r16 = r10.obtainStyledAttributes(r11, r12, r13, r14);
        int r17 = r15.length;
        int r18 = 0;
    L3:
        if (r18 >= r17) goto L9;
        if (r16.getResourceId(r15[r18], -1) == (-1)) goto L6;
        r18 = r18 + 1;
        goto L3
    L6:
        r16.recycle();
        return false;
    L9:
        r16.recycle();
        return true;
    }

    private static boolean g(@NonNull Context r10, @NonNull int[] r11) {
        TypedArray r12 = r10.obtainStyledAttributes(r11);
        int r13 = 0;
    L4:
        if (r13 >= r11.length) goto L10;
        if (r12.hasValue(r13) == false) goto L7;
        r13 = r13 + 1;
        goto L4
    L7:
        r12.recycle();
        return false;
    L10:
        r12.recycle();
        return true;
    }

    @NonNull
    public static TypedArray h(@NonNull Context r10, AttributeSet r11, @NonNull @StyleableRes int[] r12, @AttrRes int r13, @StyleRes int r14, @StyleableRes int... r15) {
        b(r10, r11, r13, r14);
        d(r10, r11, r12, r13, r14, r15);
        return r10.obtainStyledAttributes(r11, r12, r13, r14);
    }

    public static TintTypedArray i(@NonNull Context r10, AttributeSet r11, @NonNull @StyleableRes int[] r12, @AttrRes int r13, @StyleRes int r14, @StyleableRes int... r15) {
        b(r10, r11, r13, r14);
        d(r10, r11, r12, r13, r14, r15);
        return TintTypedArray.obtainStyledAttributes(r10, r11, r12, r13, r14);
    }
}
