package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.MultiLinkMatchScreenConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ra1 extends SSettingKey<MultiLinkMatchScreenConfig> {
    public static final ra1 a = null;

    static {
        a = new ra1();
    }

    public ra1() {
        super("multi_link_match_screen_right_margin_opt", "多人场景通用布局公屏RightMargin改造", new MultiLinkMatchScreenConfig(), new MultiLinkMatchScreenConfig());
    }
}
