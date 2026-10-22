package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class da0 extends SSettingKey<Integer> {
    public static final da0 a = null;

    static {
        a = new da0();
    }

    public da0() {
        super("live_more_panel_audience_style", "更多面板观众端样式配置，0-线上，1-黑底滑动，2-白底滑动", 0, 0, true);
    }
}
