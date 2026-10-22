package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class wo extends SSettingKey<Integer> {
    public static final wo a = null;

    public wo() {
        super("live_feed_inner_style", 0, "直播Feed内外双流, 0: 关闭内流, 1: 内流回插2: 内流不回插");
    }

    static {
        a = new wo();
    }
}
