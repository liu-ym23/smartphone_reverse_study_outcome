package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class gt extends SSettingKey<Boolean> {
    public static final gt a = null;

    static {
        a = new gt();
    }

    public gt() {
        Boolean r1 = Boolean.FALSE;
        super("live_enable_sticker_cancel_by_audience_in_limit_time", "直播贴纸优化实验，当该值为true时，贴纸展示初始时会主动展示关闭按钮", r1, r1);
    }
}
