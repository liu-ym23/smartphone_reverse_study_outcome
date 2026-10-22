package com.bytedance.android.livesdk.config.setting;

import com.bytedance.android.livesdk.config.lt0;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class p {
    public static final /* synthetic */ int a = 0;

    @JvmStatic
    public static final boolean a() {
        Integer r0 = lt0.a.getValue();
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
