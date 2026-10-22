package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class oq0 extends SSettingKey<Boolean> {
    public static final oq0 a = null;

    static {
        a = new oq0();
    }

    public oq0() {
        Boolean r4 = Boolean.TRUE;
        super("live_screen_cast_load_opt", "正在投屏时，提高投屏组件加载优先级", r4, r4, true);
    }
}
