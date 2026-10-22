package com.bytedance.android.ec.core.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class p {
    public static final p a = null;

    public p() {
    }

    static {
        a = new p();
    }

    public final Activity getActivity(Context r10) {
    L3:
        if (r10 == null) goto L11;
        if ((r10 instanceof Activity) == true) goto L7;
        if ((r10 instanceof ContextWrapper) == false) goto L11;
        r10 = ((ContextWrapper) r10).getBaseContext();
        goto L3
    L7:
        return (Activity) r10;
    L11:
        return null;
    }
}
