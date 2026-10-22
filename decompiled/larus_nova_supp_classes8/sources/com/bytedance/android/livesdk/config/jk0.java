package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class jk0 extends SSettingKey<Boolean> {
    public static final jk0 a = null;

    static {
        a = new jk0();
    }

    public jk0() {
        Boolean r4 = Boolean.TRUE;
        super("live_pre_enter_room_logic_opt", "预进房逻辑优化", r4, r4, new String[]{"true:支持逻辑优化", "false:不支持逻辑优化"});
    }
}
