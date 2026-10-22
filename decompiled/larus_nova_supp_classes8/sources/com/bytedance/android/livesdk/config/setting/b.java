package com.bytedance.android.livesdk.config.setting;

import com.bytedance.android.livesdk.config.rc0;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b {
    @JvmStatic
    public static final boolean a() {
        Integer r0 = rc0.a.getValue();
        if (r0 != null) goto L6;
    L8:
        return false;
    L6:
        if (r0.intValue() != 2) goto L8;
        return true;
    }

    static {
    }
}
