package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class v80 extends SSettingKey<Boolean> {
    public static final v80 a = null;

    static {
        a = new v80();
    }

    public v80() {
        Boolean r1 = Boolean.FALSE;
        super("live_mg_alone_stack_launch_enable", "看播端独立栈启动小游戏", r1, r1);
    }
}
