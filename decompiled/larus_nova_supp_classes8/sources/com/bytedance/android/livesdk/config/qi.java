package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class qi extends SSettingKey<Boolean> {
    public static final qi a = null;

    static {
        a = new qi();
    }

    public qi() {
        Boolean r4 = Boolean.FALSE;
        super("live_broadcast_use_self_effect", "effect上移", r4, r4, true);
    }
}
