package com.bytedance.android.live.core.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class ContextUtil {
    private ContextUtil() {
    }

    public static Activity contextToActivity(Context r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        if ((r2 instanceof Activity) == false) goto L10;
        return (Activity) r2;
    L10:
        if ((r2 instanceof ContextWrapper) == true) goto L12;
        return null;
    L12:
        return contextToActivity(((ContextWrapper) r2).getBaseContext());
    }

    public static FragmentActivity contextToFragmentActivity(Context r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        if ((r2 instanceof FragmentActivity) == false) goto L10;
        return (FragmentActivity) r2;
    L10:
        if ((r2 instanceof ContextWrapper) == true) goto L12;
        return null;
    L12:
        return contextToFragmentActivity(((ContextWrapper) r2).getBaseContext());
    }
}
