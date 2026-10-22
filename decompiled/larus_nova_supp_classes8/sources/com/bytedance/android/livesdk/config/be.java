package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class be extends SSettingKey<Boolean> {
    public static final be a = null;

    static {
        a = new be();
    }

    public be() {
        Boolean r1 = Boolean.FALSE;
        super("live_audience_pre_announcement_sticker_should_fade", "直播间内预告贴片是否自动消失", r1, r1);
    }
}
