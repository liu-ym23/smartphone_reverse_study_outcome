package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class o10 extends SettingKey<h41> {
    public static final o10 a = null;

    static {
        a = new o10();
    }

    public o10() {
        super("live_inner_feed_loading_slide_config", "直播间上滑加载更多自动翻页", new h41(), new h41(), true);
    }
}
