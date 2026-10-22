package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c80 extends SSettingKey<Boolean> {
    public static final c80 a = null;

    static {
        a = new c80();
    }

    public c80() {
        Boolean r1 = Boolean.TRUE;
        super("live_media_anchor_enable_digg", "媒体主播侧是否支持点赞", r1, r1);
    }
}
