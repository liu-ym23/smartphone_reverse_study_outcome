package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class y80 extends SSettingKey<Boolean> {
    public static final y80 a = null;

    static {
        a = new y80();
    }

    public y80() {
        Boolean r1 = Boolean.TRUE;
        super("live_mg_component_preload", "直播间多实例toolbar预加载小游戏", r1, r1);
    }
}
