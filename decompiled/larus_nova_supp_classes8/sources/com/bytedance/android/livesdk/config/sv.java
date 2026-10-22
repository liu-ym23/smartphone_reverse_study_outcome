package com.bytedance.android.livesdk.config;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class sv extends SSettingKey<List<? extends String>> {
    public static final sv a = null;

    static {
        sv r0 = new sv();
        a = r0;
        r0.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public sv() {
        super("live_feed_drawer_unified_config", "feed支持上下滑入口统一配置", Arrays.asList(new String[]{"homepage_hot_video_head", "homepage_hot_live_cell", "homepage_follow_video_head", "homepage_follow_live_cell", "homepage_fresh_live_cell", "homepage_fresh_video_head"}), Arrays.asList(new String[]{"homepage_hot_video_head", "homepage_hot_live_cell", "homepage_follow_video_head", "homepage_follow_live_cell", "homepage_fresh_live_cell", "homepage_fresh_video_head"}));
    }
}
