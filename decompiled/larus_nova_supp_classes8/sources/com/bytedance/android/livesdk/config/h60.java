package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h60 extends SSettingKey<Boolean> {
    public static final h60 a = null;

    static {
        a = new h60();
    }

    public h60() {
        Boolean r4 = Boolean.TRUE;
        super("live_link_audio_metric_anchor_disable", "是否禁止主播RTC打分", r4, r4, false);
    }
}
