package com.ss.android.lark.inv.export.util;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.suite.lark.emm.design.edittext.SCEditText;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e {
    public static void a(Activity r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        Window r6 = r5.getWindow();
        if (r6 == null) goto L23;
        View r0 = r6.getCurrentFocus();
        if (r0 != null) goto L18;
        View r1 = r6.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L14;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r2 = ThreadMethodProxy.currentThread();
        if (r2 == com.larus.home.impl.utils.c.a) goto L14;
        com.larus.home.impl.utils.c.a(r2, "getDecorView");
    L14:
        View r3 = r1.findViewWithTag("keyboardTagView");
        if (r3 != null) goto L17;
        r3 = new EditText(r6.getContext());
        r3.setTag("keyboardTagView");
        ((ViewGroup) r1).addView(r3, 0, 0);
    L17:
        r0 = r3;
        r0.requestFocus();
    L18:
        InputMethodManager r7 = (InputMethodManager) com.larksuite.framework.utils.b.a.getSystemService("input_method");
        if (r7 == null) goto L24;
        r7.hideSoftInputFromWindow(r0.getWindowToken(), 0);
        return;
    L24:
        return;
    }

    public static void b(SCEditText r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        InputMethodManager r0 = (InputMethodManager) com.larksuite.framework.utils.b.a.getSystemService("input_method");
        if (r0 == null) goto L9;
        r4.setFocusable(true);
        r4.setFocusableInTouchMode(true);
        r4.requestFocus();
        final Handler r3 = new Handler();
        r0.showSoftInput(r4, 0, new InvKeyboardUtils$1(r3));
        r0.toggleSoftInput(2, 1);
        return;
    }
}
