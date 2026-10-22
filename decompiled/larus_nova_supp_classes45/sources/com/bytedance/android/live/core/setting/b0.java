package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b0 extends SSettingKey<Boolean> {
    public static final b0 a = null;

    static {
        a = new b0();
    }

    public b0() {
        Boolean r1 = Boolean.TRUE;
        super("live_clear_resolution_memory_when_set", "用户选中清晰度时，清除旧版本清晰度的本地记忆", r1, r1);
    }
}
