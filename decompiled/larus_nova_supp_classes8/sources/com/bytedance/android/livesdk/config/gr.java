package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class gr extends SSettingKey<Boolean> {
    public static final gr a = null;

    static {
        a = new gr();
    }

    public gr() {
        Boolean r1 = Boolean.FALSE;
        super("live_enable_chat_auto_join_tips", "金刚位进入连线提示的策略", r1, r1);
    }
}
