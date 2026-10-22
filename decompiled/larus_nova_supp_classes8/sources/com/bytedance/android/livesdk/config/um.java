package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class um extends SSettingKey<Boolean> {
    public static final um a = null;

    static {
        a = new um();
    }

    public um() {
        Boolean r1 = Boolean.FALSE;
        super("live_decoration_enable_audio_opt", "游戏直播场景，装饰面板中新增声音入口", r1, r1);
    }
}
