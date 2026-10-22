package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ps extends SSettingKey<Boolean> {
    public static final ps a = null;

    static {
        a = new ps();
    }

    public ps() {
        Boolean r1 = Boolean.TRUE;
        super("live_enable_pause_live_when_nocapture_error_end", "主播视频连线使用Avatar异常断开暂停直播兜底提示", r1, r1);
    }
}
