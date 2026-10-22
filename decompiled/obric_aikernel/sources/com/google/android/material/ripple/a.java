package com.google.android.material.ripple;

import android.R;
import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;
import android.util.StateSet;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.graphics.ColorUtils;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f3599a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f3600b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f3601c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[] f3602d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int[] f3603e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int[] f3604f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int[] f3605g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int[] f3606h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int[] f3607i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int[] f3608j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int[] f3609k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @VisibleForTesting
    static final String f3610l = null;

    static {
        if (Build.VERSION.SDK_INT < 21) goto L5;
        boolean r10 = true;
    L6:
        f3599a = r10;
        f3600b = new int[]{R.attr.state_pressed};
        f3601c = new int[]{R.attr.state_hovered, R.attr.state_focused};
        f3602d = new int[]{R.attr.state_focused};
        f3603e = new int[]{R.attr.state_hovered};
        f3604f = new int[]{R.attr.state_selected, R.attr.state_pressed};
        f3605g = new int[]{R.attr.state_selected, R.attr.state_hovered, R.attr.state_focused};
        f3606h = new int[]{R.attr.state_selected, R.attr.state_focused};
        f3607i = new int[]{R.attr.state_selected, R.attr.state_hovered};
        f3608j = new int[]{R.attr.state_selected};
        f3609k = new int[]{R.attr.state_enabled, R.attr.state_pressed};
        f3610l = a.class.getSimpleName();
        return;
    L5:
        r10 = false;
        goto L6
    }

    private a() {
    }

    @NonNull
    public static ColorStateList a(@Nullable ColorStateList r10) {
        if (f3599a == true) goto L5;
        int[] r11 = f3604f;
        int[] r12 = f3605g;
        int[] r13 = f3606h;
        int[] r14 = f3607i;
        int[] r15 = f3600b;
        int[] r16 = f3601c;
        int[] r17 = f3602d;
        int[] r18 = f3603e;
        return new ColorStateList(new int[][]{r11, r12, r13, r14, f3608j, r15, r16, r17, r18, StateSet.NOTHING}, new int[]{c(r10, r11), c(r10, r12), c(r10, r13), c(r10, r14), 0, c(r10, r15), c(r10, r16), c(r10, r17), c(r10, r18), 0});
    L5:
        return new ColorStateList(new int[][]{f3608j, StateSet.NOTHING}, new int[]{c(r10, f3604f), c(r10, f3600b)});
    }

    @ColorInt
    @TargetApi(21)
    private static int b(@ColorInt int r10) {
        return ColorUtils.setAlphaComponent(r10, Math.min(Color.alpha(r10) * 2, 255));
    }

    @ColorInt
    private static int c(@Nullable ColorStateList r10, int[] r11) {
        if (r10 == null) goto L4;
        int r12 = r10.getColorForState(r11, r10.getDefaultColor());
    L6:
        if (f3599a == true) goto L8;
        return r12;
    L8:
        return b(r12);
    L4:
        r12 = 0;
        goto L6
    }

    @NonNull
    public static ColorStateList d(@Nullable ColorStateList r10) {
        if (r10 == null) goto L15;
        int r11 = Build.VERSION.SDK_INT;
        if (r11 >= 22) goto L7;
    L13:
        return r10;
    L7:
        if (r11 > 27) goto L13;
        if (Color.alpha(r10.getDefaultColor()) != 0) goto L13;
        if (Color.alpha(r10.getColorForState(f3609k, 0)) == 0) goto L13;
        Log.w(f3610l, "Use a non-transparent color for the default color as it will be used to finish ripple animations.");
        goto L13
    L15:
        return ColorStateList.valueOf(0);
    }

    public static boolean e(@NonNull int[] r10) {
        int r11 = r10.length;
        int r12 = 0;
        boolean r13 = false;
        boolean r14 = false;
    L4:
        if (r12 >= r11) goto L18;
        int r15 = r10[r12];
        if (r15 != 16842910) goto L9;
        r13 = true;
    L17:
        r12 = r12 + 1;
        goto L4
    L9:
        if (r15 != 16842908) goto L12;
    L10:
        r14 = true;
        goto L17
    L12:
        if (r15 == 16842919) goto L10;
        if (r15 != 16843623) goto L17;
    L18:
        if (r13 == false) goto L26;
        if (r14 == true) goto L21;
        return false;
    L21:
        return true;
    L26:
        return false;
    }
}
