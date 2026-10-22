package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ah extends SSettingKey<Boolean> {
    public static final ah a = null;

    static {
        a = new ah();
    }

    public ah() {
        Boolean r4 = Boolean.TRUE;
        super("live_broadcast_enable_toolbar_dot_message", "直播黄点支持消息下发", r4, r4, false);
    }
}
