package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.LiveBackToPreRoomSettingV2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class m0 extends SSettingKey<LiveBackToPreRoomSettingV2> {
    public static final m0 a = null;

    static {
        a = new m0();
    }

    public m0() {
        super("return_back_settings_v2", "返回上一个直播间新样式", new LiveBackToPreRoomSettingV2(), new LiveBackToPreRoomSettingV2(), true);
    }
}
