package com.bytedance.android.accessibilityLib_Core.util;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Checkable;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static boolean a(ViewGroup r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        int r1 = 0;
    L7:
        if (r1 >= r10.getChildCount()) goto L21;
        View r11 = r10.getChildAt(r1);
        if (r11 != null) goto L11;
        boolean r12 = false;
    L13:
        if (r12 == true) goto L14;
        if ((r11 instanceof ViewGroup) == false) goto L20;
        if (a((ViewGroup) r11) == false) goto L20;
        return true;
    L20:
        r1 = r1 + 1;
        goto L7
    L14:
        return true;
    L11:
        r12 = r11.isImportantForAccessibility();
        goto L13
    L21:
        return false;
    }

    public static boolean b(View r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        Object r11 = r10.getParentForAccessibility();
        if ((r11 instanceof View) == true) goto L8;
        return false;
    L8:
        View r12 = (View) r11;
        if (d(r12) == false) goto L13;
        return true;
    L13:
        return b(r12);
    }

    public static boolean c(View r10) {
        if (TextUtils.isEmpty(r10.getContentDescription()) == true) goto L6;
        return true;
    L6:
        if ((r10 instanceof TextView) == false) goto L14;
        TextView r11 = (TextView) r10;
        if (TextUtils.isEmpty(r11.getText()) == true) goto L10;
        return true;
    L10:
        if (TextUtils.isEmpty(r11.getHint()) == false) goto L16;
        return false;
    L16:
        return true;
    L14:
        return false;
    }

    public static boolean d(View r10) {
        if (r10 != null) goto L6;
        return false;
    L6:
        if (r10.getVisibility() == 0) goto L9;
        return false;
    L9:
        if (r10.isImportantForAccessibility() == true) goto L12;
        return false;
    L12:
        if (r10.isClickable() == false) goto L14;
    L19:
        boolean r1 = true;
    L20:
        if (r1 == false) goto L22;
        return true;
    L22:
        Object r11 = r10.getParentForAccessibility();
        if (r11 != null) goto L25;
    L39:
        boolean r12 = false;
    L40:
        if (r12 == true) goto L42;
        return false;
    L42:
        if (e(r10) == false) goto L46;
        return true;
    L46:
        return false;
    L25:
        if ((r11 instanceof View) == false) goto L39;
        View r13 = (View) r11;
        if (r13.isScrollContainer() == false) goto L31;
    L38:
        r12 = true;
        goto L40
    L31:
        if ((r13 instanceof AdapterView) == true) goto L37;
        if ((r13 instanceof ScrollView) == true) goto L37;
        if ((r13 instanceof HorizontalScrollView) == false) goto L39;
    L37:
        if ((r13 instanceof Spinner) == true) goto L39;
    L14:
        if (r10.isLongClickable() == true) goto L19;
        if (r10.isFocusable() == true) goto L19;
        r1 = false;
        goto L20
    }

    public static boolean e(View r10) {
        if (c(r10) == false) goto L6;
        return true;
    L6:
        if ((r10 instanceof Checkable) == false) goto L9;
        return true;
    L9:
        if ((r10 instanceof ViewGroup) == false) goto L27;
        ViewGroup r11 = (ViewGroup) r10;
        int r0 = 0;
    L13:
        if (r0 >= r11.getChildCount()) goto L27;
        View r12 = r11.getChildAt(r0);
        if (r12 == null) goto L26;
        if (r12.getVisibility() != 0) goto L26;
        if (d(r12) == true) goto L26;
        if (r12.isImportantForAccessibility() == false) goto L26;
        if (e(r12) == false) goto L26;
        boolean r13 = true;
    L28:
        if (r13 == false) goto L30;
        return true;
    L30:
        return false;
    L26:
        r0 = r0 + 1;
    L27:
        r13 = false;
        goto L28
    }
}
