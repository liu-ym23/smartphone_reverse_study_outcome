package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class vc extends SSettingKey<Boolean> {
    public static final vc a = null;

    static {
        a = new vc();
    }

    public vc() {
        Boolean r1 = Boolean.FALSE;
        super("live_anchor_share_panel_use_recommand_data", "主播侧分享面板IM填充推荐数据", r1, r1);
    }
}
