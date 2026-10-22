package com.bytedance.android.livesdk.config.setting;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.aa1;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class r {
    @JvmStatic
    public static final Boolean a() {
        return aa1.a.getValue();
    }

    static {
    }

    @JvmStatic
    public static final void b(String r1) {
        Intrinsics.checkNotNullParameter(r1, "s");
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L6;
        ALogger.d("MicRoomFollowEnhance", r1);
        return;
    }
}
