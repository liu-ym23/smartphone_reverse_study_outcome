package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ec extends SSettingKey<Boolean> {
    public static final ec a = null;

    static {
        a = new ec();
    }

    public ec() {
        Boolean r1 = Boolean.TRUE;
        super("live_anchor_more_dialog_fix_scroll_click_error", "主播更多面板滑动后第一次点击失效修复", r1, r1);
    }
}
