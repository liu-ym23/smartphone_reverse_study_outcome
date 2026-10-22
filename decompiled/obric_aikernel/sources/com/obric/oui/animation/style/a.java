package com.obric.oui.animation.style;

import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static final List<EditText> a(View r10) {
        Intrinsics.checkNotNullParameter(r10, "view");
        ArrayList r11 = new ArrayList();
        if ((r10 instanceof ViewGroup) == false) goto L8;
        int r12 = 0;
        ViewGroup r13 = (ViewGroup) r10;
        int r14 = r13.getChildCount();
    L5:
        if (r12 >= r14) goto L10;
        View r15 = r13.getChildAt(r12);
        Intrinsics.checkNotNullExpressionValue(r15, "child");
        r11.addAll(a(r15));
        r12 = r12 + 1;
    L10:
        return r11;
    L8:
        if ((r10 instanceof EditText) == false) goto L10;
        r11.add(r10);
        goto L10
    }

    public static final void b(View r10) {
        Intrinsics.checkNotNullParameter(r10, "rootView");
        List<EditText> r11 = a(r10);
        Object r12 = r10.getContext().getSystemService("input_method");
        Objects.requireNonNull(r12, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager r13 = (InputMethodManager) r12;
        Iterator<EditText> r14 = r11.iterator();
    L4:
        if (r14.hasNext() == false) goto L8;
        EditText r15 = r14.next();
        if (r13.isActive(r15) == false) goto L4;
        r13.hideSoftInputFromWindow(r15.getWindowToken(), 0);
        goto L4
    }
}
