package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ss extends SettingKey<Boolean> {
    public static final ss a = null;

    static {
        a = new ss();
    }

    public ss() {
        Boolean r1 = Boolean.FALSE;
        super("live_enable_record_jsb", "录屏能力的jsb开关", r1, r1);
    }
}
