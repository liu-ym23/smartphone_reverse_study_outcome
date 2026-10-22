package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class kb extends SSettingKey<Boolean> {
    public static final kb a = null;

    static {
        a = new kb();
    }

    public kb() {
        super("live_anchor_enable_announcement_highlight", "主播开启直播预告推送能力", Boolean.FALSE, Boolean.TRUE);
    }
}
