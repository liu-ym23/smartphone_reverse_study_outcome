package com.bytedance.android.livesdk.config.setting;

import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.livesdk.config.j11;
import com.bytedance.android.livesdk.config.pd;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class x {
    public static boolean a() {
        j11 r1 = (j11) pd.a.getValue();     // Catch: Exception -> L9
        if (r1 == null) goto L8;
        if (r1.enable != true) goto L8;
        return true;
    L8:
        return false;
    L9:
        e = move-exception;
        SafetyGuard.a(null, e, "live animation center setting error.");
        return true;
    }

    static {
    }
}
