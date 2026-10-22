package com.bytedance.android.live.openplatform.impl.base.utils;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class k {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(Context r2, View r3) throws Exception {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r3 != null) goto L16;
        return;
    L16:
        Object r4 = r2.getSystemService("input_method");     // Catch: Exception -> L9
        if (r4 == null) goto L12;
        ((InputMethodManager) r4).hideSoftInputFromWindow(r3.getWindowToken(), 0);     // Catch: Exception -> L9
    L14:
        r3.clearFocus();
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");     // Catch: Exception -> L9
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L14
    }
}
