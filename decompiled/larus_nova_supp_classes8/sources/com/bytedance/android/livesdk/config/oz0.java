package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class oz0 extends SSettingKey<Boolean> {
    public static final oz0 a = null;

    static {
        a = new oz0();
    }

    public oz0() {
        Boolean r1 = Boolean.TRUE;
        super("live_xplay_component_preload", "直播间多实例toolbar预加载小玩法", r1, r1);
    }
}
