package com.larksuite.framework.utils;

import android.text.TextUtils;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class j0 {
    public static String a(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L7;
        Log.w("UIDUtils", "uid is invalid.");
        return "";
    L7:
        if (TextUtils.equals(r4, "absent_user") == false) goto L10;
        return r4;
    L10:
        if (r4.length() >= 9) goto L14;
        Log.w("UIDUtils", "uid less than limit.");
        return "";
    L14:
        return r4.substring(8);
    }
}
