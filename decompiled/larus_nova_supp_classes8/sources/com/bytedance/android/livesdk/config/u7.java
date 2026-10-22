package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class u7 extends SettingKey<Boolean> {
    public static final u7 a = null;

    static {
        a = new u7();
    }

    public u7() {
        Boolean r1 = Boolean.FALSE;
        super("interact_guest_frame_opt", "首帧优化开关", r1, r1);
    }
}
