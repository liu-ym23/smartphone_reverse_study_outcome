package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g4 extends SSettingKey<Boolean> {
    public static final g4 a = null;

    static {
        a = new g4();
    }

    public g4() {
        Boolean r1 = Boolean.FALSE;
        super("enable_scene_live_float_window_play", "线上无场景触发 false 场景+线上小窗 true", r1, r1);
    }
}
