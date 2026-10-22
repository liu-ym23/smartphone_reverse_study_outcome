package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class xe extends SSettingKey<Boolean> {
    public static final xe a = null;

    static {
        a = new xe();
    }

    public xe() {
        Boolean r1 = Boolean.FALSE;
        super("live_audience_open_panel", "开启双人聊的时候是否展示开启面板", r1, r1);
    }
}
