package com.bytedance.android.annie.bridge.method.calendar;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Activity a(Context r1) {
    L2:
        if (r1 == null) goto L16;
        if ((r1 instanceof Activity) == true) goto L6;
        if ((r1 instanceof ContextWrapper) == false) goto L10;
        r1 = ((ContextWrapper) r1).getBaseContext();
        goto L2
    L10:
        r1.toString();
        return null;
    L6:
        return (Activity) r1;
    L16:
        return null;
    }
}
