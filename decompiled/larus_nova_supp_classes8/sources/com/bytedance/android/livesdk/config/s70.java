package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class s70 extends SSettingKey<Boolean> {
    public static final s70 a = null;

    static {
        a = new s70();
    }

    public s70() {
        Boolean r1 = Boolean.TRUE;
        super("live_lynx_x_text_emoji_enable", "开启 Lynx x-text 的 emoji 支持", r1, r1);
    }
}
