package com.google.android.material.internal;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ContextUtils {
    public ContextUtils() {
    }

    @Nullable
    public static Activity getActivity(Context r5) {
    L3:
        if ((r5 instanceof ContextWrapper) == false) goto L9;
        if ((r5 instanceof Activity) == true) goto L7;
        r5 = ((ContextWrapper) r5).getBaseContext();
        goto L3
    L7:
        return (Activity) r5;
    L9:
        return null;
    }
}
