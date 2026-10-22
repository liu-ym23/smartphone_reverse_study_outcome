package com.bytedance.ttnet;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    public static String a() {
        String r0 = TTNetInit.getTTNetDepend().c();
        if (r0 == null) goto L8;
        if (TextUtils.isEmpty(r0) == true) goto L8;
        return r0;
    L8:
        throw new IllegalArgumentException("hostSuffix is not init !!!");
    }

    public static String b() {
        String r0 = TTNetInit.getTTNetDepend().d();
        if (r0 == null) goto L8;
        if (TextUtils.isEmpty(r0) == true) goto L8;
        return r0;
    L8:
        throw new IllegalArgumentException("cdnHostSuffix is not init !!!");
    }
}
