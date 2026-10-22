package com.bytedance.ttnet;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static String a() {
        String r10 = TTNetInit.getTTNetDepend().l();
        if (r10 == null) goto L8;
        if (TextUtils.isEmpty(r10) == true) goto L8;
        return r10;
    L8:
        throw new IllegalArgumentException("hostSuffix is not init !!!");
    }
}
