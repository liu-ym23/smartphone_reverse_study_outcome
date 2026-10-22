package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i3 extends SSettingKey<Boolean> {
    public static final i3 a = null;

    static {
        a = new i3();
    }

    public i3() {
        Boolean r1 = Boolean.TRUE;
        super("enable_guest_link_auto_silence_setting", "聊天室设置面板是否展示观众连线默认静音设置项", r1, r1);
    }
}
