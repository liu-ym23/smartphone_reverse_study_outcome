package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class qi0 extends SSettingKey<Boolean> {
    public static final qi0 a = null;

    static {
        a = new qi0();
    }

    public qi0() {
        Boolean r1 = Boolean.FALSE;
        super("live_playmode_entrance_optimize_enable", "是否开启多人场景玩法路径优化", r1, r1);
    }
}
