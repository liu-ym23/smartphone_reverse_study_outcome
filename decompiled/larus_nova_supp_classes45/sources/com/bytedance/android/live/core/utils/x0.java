package com.bytedance.android.live.core.utils;

import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.bytedance.android.livesdkapi.util.JavaCalls;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class x0 {
    public static void a(EditText r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        InputMethodManager r0 = (InputMethodManager) s1.getContext().getSystemService("input_method");
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.hideSoftInputFromWindow(r3.getWindowToken(), 0) == true) goto L18;
        Integer r4 = (Integer) JavaCalls.callMethod(r0, "getInputMethodWindowVisibleHeight", new Object[0]);
        if (r4 != null) goto L11;
    L13:
        boolean r5 = false;
    L14:
        if (r5 == false) goto L19;
        r0.toggleSoftInput(0, 2);
        return;
    L19:
        return;
    L11:
        if (r4.intValue() <= 0) goto L13;
        r5 = true;
        goto L14
    }

    public static void b(final EditText r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        r3.postDelayed(new w0(r3), 100);
    }
}
