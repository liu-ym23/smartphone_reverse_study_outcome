package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e50 extends SettingKey<Integer> {
    public static final e50 a = null;

    static {
        a = new e50();
    }

    public e50() {
        super("live_ktv_sing_fps", "ktv演唱频率", 55, 55);
    }
}
