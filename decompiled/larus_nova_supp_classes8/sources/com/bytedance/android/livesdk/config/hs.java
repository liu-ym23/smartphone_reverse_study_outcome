package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class hs extends SSettingKey<Boolean> {
    public static final hs a = null;

    static {
        a = new hs();
    }

    public hs() {
        Boolean r1 = Boolean.FALSE;
        super("live_enable_merge_anchorinfo", "主播信息区融合test", r1, r1);
    }
}
