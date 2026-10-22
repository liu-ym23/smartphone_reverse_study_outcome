package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class mt extends SSettingKey<Boolean> {
    public static final mt a = null;

    static {
        a = new mt();
    }

    public mt() {
        Boolean r1 = Boolean.FALSE;
        super("live_enable_visibility_scope_share", "主播是否启用可见范围分享限制", r1, r1);
    }
}
