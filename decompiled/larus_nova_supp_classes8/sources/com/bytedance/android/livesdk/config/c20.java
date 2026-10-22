package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveInnerViewPagerConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c20 extends SSettingKey<LiveInnerViewPagerConfig> {
    public static final c20 a = null;

    static {
        a = new c20();
    }

    public c20() {
        super("live_inner_viewpager_opt_config", "内流LiveVerticalViewPager优化", new LiveInnerViewPagerConfig(), new LiveInnerViewPagerConfig());
    }
}
