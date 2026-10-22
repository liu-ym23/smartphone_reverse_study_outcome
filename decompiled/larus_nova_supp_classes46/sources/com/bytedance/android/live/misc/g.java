package com.bytedance.android.live.misc;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g extends SSettingKey<Boolean> {
    public static final g a = null;

    static {
        a = new g();
    }

    public g() {
        Boolean r1 = Boolean.TRUE;
        super("live_poi_update_fix_enable", "poi动态更新fix", r1, r1);
    }
}
