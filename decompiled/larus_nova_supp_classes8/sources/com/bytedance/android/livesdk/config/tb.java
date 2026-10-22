package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class tb extends SSettingKey<Boolean> {
    public static final tb a = null;

    static {
        a = new tb();
    }

    public tb() {
        Boolean r1 = Boolean.TRUE;
        super("live_anchor_fix_announcement_highlight_audience_fail_to_close", "修复预告贴片偶现观众侧无法关闭的问题", r1, r1);
    }
}
