package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class xg extends SSettingKey<String> {
    public static final xg a = null;

    static {
        a = new xg();
    }

    public xg() {
        super("live_broadcast_cancel_silent_notify", "开播多次点击", "点击我的麦位，在麦位设置面板中点击取消静音即可解除", "点击我的麦位，在麦位设置面板中点击取消静音即可解除", false);
    }
}
