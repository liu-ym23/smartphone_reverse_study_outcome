package com.bytedance.android.live.network.impl.utils;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d {
    public static long a(String r2) {
        return CastLongProtector.parseLong(r2);
    L4:
        e = move-exception;
        ALogger.e("LiveNtpUtils", e);
        return 0;
    }
}
