package com.obric.assistant.view;

import android.widget.PopupWindow;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class j {
    public static PopupWindow a;
    public static int b;
    public static int c;
    public static int d;
    public static int e;

    static {
    }

    public static void a() {
        PopupWindow r0 = a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isShowing() == false) goto L7;
        PopupWindowLancet.handleDismissBeforeOrigin(r0);
        r0.dismiss();
    L7:
        a = null;
    }

    public static boolean b() {
        PopupWindow r0 = a;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isShowing();
    }
}
