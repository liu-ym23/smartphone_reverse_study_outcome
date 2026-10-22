package com.bytedance.android.livesdk.config.setting;

import com.bytedance.android.livesdk.config.rc;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a {
    @JvmStatic
    public static final boolean a() {
        if (rc.a.getValue().intValue() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    static {
    }
}
