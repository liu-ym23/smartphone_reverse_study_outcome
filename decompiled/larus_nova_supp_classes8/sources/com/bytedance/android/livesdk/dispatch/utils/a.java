package com.bytedance.android.livesdk.dispatch.utils;

import com.bytedance.android.livesdk.config.oo;
import com.bytedance.android.livesdk.config.po;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    public static boolean a() {
        if (oo.a.getValue().booleanValue() == true) goto L5;
    L7:
        return false;
    L5:
        if (po.a.getValue().booleanValue() == false) goto L7;
        return true;
    }

    static {
    }
}
