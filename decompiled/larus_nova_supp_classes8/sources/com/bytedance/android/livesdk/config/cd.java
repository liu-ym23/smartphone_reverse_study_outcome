package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class cd extends SSettingKey<Boolean> {
    public static final cd a = null;

    static {
        a = new cd();
    }

    public cd() {
        Boolean r1 = Boolean.TRUE;
        super("live_anchor_support_broadcast_scope_in_interaction", "主播侧scope在交互层使用", r1, r1);
    }
}
