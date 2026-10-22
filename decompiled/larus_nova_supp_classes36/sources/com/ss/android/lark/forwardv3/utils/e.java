package com.ss.android.lark.forwardv3.utils;

import android.os.SystemClock;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e {
    public long a;

    public static final class a {
    }

    static {
    }

    public e() {
    }

    public final boolean a() {
        long r0 = SystemClock.uptimeMillis();
        long r2 = r0 - this.a;
        this.a = r0;
        if (r2 >= 1000) goto L5;
        Log.i("ForwardClickThrottle", "elapsedTime is short than LENGTH_SHORT");
        return false;
    L5:
        Log.i("ForwardClickThrottle", "click is normal");
        return true;
    }
}
