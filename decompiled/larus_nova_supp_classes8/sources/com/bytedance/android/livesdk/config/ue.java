package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ue extends SSettingKey<Boolean> {
    public static final ue a = null;

    static {
        a = new ue();
    }

    public ue() {
        Boolean r1 = Boolean.TRUE;
        super("live_audience_entrance_lab_backup", "观众连线开启双人聊强制对照组的开关", r1, r1);
    }
}
