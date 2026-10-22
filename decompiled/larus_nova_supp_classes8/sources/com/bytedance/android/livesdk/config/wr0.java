package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class wr0 extends SettingKey<Boolean> {
    public static final wr0 a = null;

    static {
        a = new wr0();
    }

    public wr0() {
        Boolean r1 = Boolean.TRUE;
        super("live_share_schema_fallback_top_activity_enable", "分享schema当context无效时fallback到topActivity", r1, r1);
    }
}
