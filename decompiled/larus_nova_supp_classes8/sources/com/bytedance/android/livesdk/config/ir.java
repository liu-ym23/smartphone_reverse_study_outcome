package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ir extends SSettingKey<Boolean> {
    public static final ir a = null;

    static {
        a = new ir();
    }

    public ir() {
        Boolean r1 = Boolean.FALSE;
        super(LiveInitSettingKeys.LIVE_ENABLE_DOWNLOAD_BMF_SO_PLUGIN, "是否使用bmf so插件", r1, r1);
    }
}
