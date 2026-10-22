package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ne extends SSettingKey<Boolean> {
    public static final ne a = null;

    static {
        a = new ne();
    }

    public ne() {
        Boolean r1 = Boolean.FALSE;
        super("live_asynclayoutinflater_fix_leakmode", "fix AsyncLayoutInflater leak", r1, r1);
    }
}
