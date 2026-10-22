package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class z2 extends SSettingKey<Boolean> {
    public static final z2 a = null;

    static {
        a = new z2();
    }

    public z2() {
        Boolean r1 = Boolean.TRUE;
        super("live_multi_link_preview_interact_song_data_handler_lateinit_opt", "FeedViewInteractSongDataHandler里proxy未初始化修复", r1, r1);
    }
}
