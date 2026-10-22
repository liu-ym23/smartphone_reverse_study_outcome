package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.obric.cae.R;

/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f4886a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f4887b = null;

    static {
        f4886a = new int[]{R.attr.colorPrimary};
        f4887b = new int[]{R.attr.colorPrimaryVariant};
    }

    public static void a(Context r8, AttributeSet r10, int r11, int r12) {
        TypedArray r13 = r8.obtainStyledAttributes(r10, g9.a.C, r11, r12);
        boolean r14 = r13.getBoolean(1, false);
        r13.recycle();
        if (r14 == false) goto L11;
        TypedValue r15 = new TypedValue();
        if (r8.getTheme().resolveAttribute(R.attr.isMaterialTheme, r15, true) == true) goto L7;
    L10:
        c(r8, f4887b, "Theme.MaterialComponents");
        goto L11
    L7:
        if (r15.type != 18) goto L11;
        if (r15.data == 0) goto L10;
    L11:
        c(r8, f4886a, "Theme.AppCompat");
    }

    public static void b(Context r8, AttributeSet r10, int[] r11, int r12, int r13, int... r14) {
        TypedArray r15 = r8.obtainStyledAttributes(r10, g9.a.C, r12, r13);
        boolean r16 = false;
        if (r15.getBoolean(2, false) == true) goto L7;
        r15.recycle();
        return;
    L7:
        if (r14.length == 0) goto L9;
        TypedArray r17 = r8.obtainStyledAttributes(r10, r11, r12, r13);
        int r18 = r14.length;
        int r19 = 0;
    L12:
        if (r19 >= r18) goto L17;
        if (r17.getResourceId(r14[r19], -1) == (-1)) goto L15;
        r19 = r19 + 1;
        goto L12
    L15:
        r17.recycle();
    L19:
        r15.recycle();
        if (r16 == false) goto L23;
        return;
    L23:
        throw new IllegalArgumentException("This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant).");
    L17:
        r17.recycle();
    L18:
        r16 = true;
        goto L19
    L9:
        if (r15.getResourceId(0, -1) == (-1)) goto L19;
        goto L19
    }

    public static void c(Context r8, int[] r10, String r11) {
        TypedArray r12 = r8.obtainStyledAttributes(r10);
        boolean r13 = false;
        int r14 = 0;
    L4:
        if (r14 >= r10.length) goto L9;
        if (r12.hasValue(r14) == false) goto L7;
        r14 = r14 + 1;
        goto L4
    L7:
        r12.recycle();
    L10:
        if (r13 == false) goto L13;
        return;
    L13:
        throw new IllegalArgumentException(defpackage.b.d("The style on this component requires your app theme to be ", r11, " (or a descendant)."));
    L9:
        r12.recycle();
        r13 = true;
        goto L10
    }

    public static TypedArray d(Context r8, AttributeSet r10, int[] r11, int r12, int r13, int... r14) {
        a(r8, r10, r12, r13);
        b(r8, r10, r11, r12, r13, r14);
        return r8.obtainStyledAttributes(r10, r11, r12, r13);
    }
}
