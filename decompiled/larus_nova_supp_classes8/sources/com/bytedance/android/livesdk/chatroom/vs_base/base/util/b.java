package com.bytedance.android.livesdk.chatroom.vs_base.base.util;

import android.os.SystemClock;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b {
    public static long a;

    public static boolean a() {
        long r0 = SystemClock.uptimeMillis();
        long r2 = r0 - a;
        a = r0;
        if (r2 <= 500) goto L5;
        return true;
    L5:
        return false;
    }
}
