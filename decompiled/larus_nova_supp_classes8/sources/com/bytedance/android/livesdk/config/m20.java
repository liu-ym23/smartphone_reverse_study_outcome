package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class m20 extends SSettingKey<Boolean> {
    public static final m20 a = null;

    static {
        a = new m20();
    }

    public m20() {
        Boolean r1 = Boolean.TRUE;
        super("live_interact_customize_stream_ui_features_enable", "自定义素材流开启ui_feature", r1, r1);
    }
}
