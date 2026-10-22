package com.bytedance.android.live.core.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import com.bytedance.common.utility.Logger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class s2 {
    public static Activity a(Context r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        if ((r2 instanceof ContextWrapper) == false) goto L12;
        if ((r2 instanceof Activity) == true) goto L10;
        r2 = ((ContextWrapper) r2).getBaseContext();
        goto L6
    L10:
        return (Activity) r2;
    L12:
        return null;
    }

    public static Activity getActivity(Context r3) {
    L3:
        if (r3 == null) goto L12;
        if ((r3 instanceof Activity) == true) goto L7;
        if ((r3 instanceof ContextWrapper) == false) goto L11;
        r3 = ((ContextWrapper) r3).getBaseContext();
        goto L3
    L11:
        Logger.w("ViewUtils", "find non-ContextWrapper in view: " + r3);
        goto L12
    L7:
        return (Activity) r3;
    L12:
        return null;
    }
}
