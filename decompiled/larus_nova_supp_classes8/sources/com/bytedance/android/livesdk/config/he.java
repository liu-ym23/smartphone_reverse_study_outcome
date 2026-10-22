package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class he extends SSettingKey<Boolean> {
    public static final he a = null;

    static {
        a = new he();
    }

    public he() {
        Boolean r1 = Boolean.TRUE;
        super("live_append_effect_sdk_version_to_global_props", "effect版本添加至通参", r1, r1);
    }
}
