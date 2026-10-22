package com.ss.android.lark.permission;

import android.content.Context;
import androidx.core.content.ContextCompat;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public static boolean a(Context r0, String r1) {
        if (ContextCompat.checkSelfPermission(r0, r1) != 0) goto L6;
        return true;
    L6:
        return false;
    }
}
