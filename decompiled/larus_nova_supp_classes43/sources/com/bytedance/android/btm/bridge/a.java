package com.bytedance.android.btm.bridge;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final Activity getActivity(View r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        if (Intrinsics.areEqual(r10.getClass().getName(), "com.android.internal.policy.DecorView") == true) goto L8;
        Context r11 = r10.getContext();
    L10:
        if (r11 == null) goto L18;
        if ((r11 instanceof Activity) == true) goto L14;
        if ((r11 instanceof ContextWrapper) == false) goto L18;
        r11 = ((ContextWrapper) r11).getBaseContext();
        goto L10
    L14:
        return (Activity) r11;
    L18:
        return null;
    L8:
        return getActivity(r10.findViewById(R.id.content));
    }
}
