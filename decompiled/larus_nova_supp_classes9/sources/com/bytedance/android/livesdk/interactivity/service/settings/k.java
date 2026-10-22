package com.bytedance.android.livesdk.interactivity.service.settings;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k extends SettingKey<Boolean> {
    public static final k a = null;

    static {
        a = new k();
    }

    public k() {
        Boolean r1 = Boolean.TRUE;
        super("live_uplink_with_bytelink", "直播上行使用ByteLink", r1, r1);
    }
}
