package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class qm extends SSettingKey<com.bytedance.android.livesdk.chatroom.model.m0> {
    public static final qm a = null;

    static {
        a = new qm();
    }

    public qm() {
        com.bytedance.android.livesdk.chatroom.model.m0 r0 = new com.bytedance.android.livesdk.chatroom.model.m0();
        r0.name = "";
        r0.font = null;
        super("live_custom_font_config", r0, "字体下载信息");
    }
}
