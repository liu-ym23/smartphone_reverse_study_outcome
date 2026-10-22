package com.bytedance.android.live.search.impl.search.helper;

import android.view.View;
import android.view.inputmethod.InputMethodManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(View r2) {
        if (r2 == null) goto L10;
        Object r0 = jc1.a.b().getSystemService("input_method");
        if ((r0 instanceof InputMethodManager) == true) goto L6;
        r0 = null;
    L6:
        InputMethodManager r1 = (InputMethodManager) r0;
        if (r1 == null) goto L11;
        r1.hideSoftInputFromWindow(r2.getWindowToken(), 0);
        return;
    L11:
        return;
    }

    public static void b(View r2) {
        if (r2 == null) goto L10;
        Object r0 = jc1.a.b().getSystemService("input_method");
        if ((r0 instanceof InputMethodManager) == true) goto L6;
        r0 = null;
    L6:
        InputMethodManager r1 = (InputMethodManager) r0;
        if (r1 == null) goto L11;
        r1.showSoftInput(r2, 1);
        return;
    L11:
        return;
    }
}
