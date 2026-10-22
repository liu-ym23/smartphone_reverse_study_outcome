package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class qs extends SSettingKey<Boolean> {
    public static final qs a = null;

    static {
        a = new qs();
    }

    public qs() {
        Boolean r1 = Boolean.FALSE;
        super(LiveInitSettingKeys.LIVE_ENABLE_PULL_STREAM_SO_PLUGIN, "是否使用拉流so插件", r1, r1);
    }
}
