package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.LiveBackToPreRoomSetting;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class l0 extends SSettingKey<LiveBackToPreRoomSetting> {
    public static final l0 a = null;

    static {
        a = new l0();
    }

    public l0() {
        super("return_back_settings", "返回上一个直播间", new LiveBackToPreRoomSetting(), new LiveBackToPreRoomSetting());
    }
}
