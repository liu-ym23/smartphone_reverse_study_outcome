package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class nb extends SSettingKey<Boolean> {
    public static final nb a = null;

    static {
        a = new nb();
    }

    public nb() {
        Boolean r1 = Boolean.FALSE;
        super("live_anchor_enable_high_light_meta_data", "主播高光锚点新增metadata", r1, r1);
    }
}
