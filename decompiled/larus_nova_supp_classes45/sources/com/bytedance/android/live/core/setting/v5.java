package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class v5 extends SSettingKey<Boolean> {
    public static final v5 a = null;

    static {
        a = new v5();
    }

    public v5() {
        Boolean r1 = Boolean.FALSE;
        super("live_vr_handle_crop_and_move_enable", "VR直播间是否处理PK CROP和移动播放器", r1, r1);
    }
}
