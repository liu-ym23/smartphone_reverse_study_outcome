package com.ttnet.org.chromium.base;

import android.content.SharedPreferences;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class ContextUtils$Holder {
    private static SharedPreferences sSharedPreferences;

    private ContextUtils$Holder() {
    }

    static {
        sSharedPreferences = ContextUtils.access$000();
    }

    public static /* synthetic */ SharedPreferences access$100() {
        return sSharedPreferences;
    }

    public static /* synthetic */ SharedPreferences access$102(SharedPreferences r0) {
        sSharedPreferences = r0;
        return r0;
    }
}
