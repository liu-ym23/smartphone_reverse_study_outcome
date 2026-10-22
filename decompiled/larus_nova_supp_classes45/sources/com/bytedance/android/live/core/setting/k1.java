package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class k1 extends SSettingKey<Boolean> {
    public static final k1 a = null;

    static {
        a = new k1();
    }

    public k1() {
        Boolean r4 = Boolean.FALSE;
        super("live_external_stop_when_new_room_create", "外部直播在新房间创建时停止", r4, r4, true);
    }
}
