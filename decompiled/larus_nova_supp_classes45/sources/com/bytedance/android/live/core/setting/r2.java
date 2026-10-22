package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class r2 extends SSettingKey<Boolean> {
    public static final r2 a = null;

    static {
        a = new r2();
    }

    public r2() {
        Boolean r1 = Boolean.FALSE;
        super("live_multi_link_anchor_skip_sync_when_attach", "SaaS主播续播跳过syncRoomStats", r1, r1);
    }
}
