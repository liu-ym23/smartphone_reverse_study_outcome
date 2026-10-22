package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class vc0 extends SSettingKey<Boolean> {
    public static final vc0 a = null;

    static {
        a = new vc0();
    }

    public vc0() {
        Boolean r1 = Boolean.TRUE;
        super("live_new_inroom_share_schema_enable", "是否使用迁移后的分享schema处理", r1, r1);
    }
}
