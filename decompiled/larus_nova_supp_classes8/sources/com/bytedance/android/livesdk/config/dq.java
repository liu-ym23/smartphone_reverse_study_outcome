package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class dq extends SSettingKey<Boolean> {
    public static final dq a = null;

    static {
        a = new dq();
    }

    public dq() {
        Boolean r4 = Boolean.TRUE;
        super("live_dynamic_toolbar_modify_channel", "聊天频道入口动态化", r4, r4, true);
    }
}
