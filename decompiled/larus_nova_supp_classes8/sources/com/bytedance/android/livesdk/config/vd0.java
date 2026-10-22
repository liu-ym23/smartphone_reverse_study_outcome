package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class vd0 extends SSettingKey<Boolean> {
    public static final vd0 a = null;

    static {
        a = new vd0();
    }

    public vd0() {
        Boolean r1 = Boolean.TRUE;
        super("live_open_game_scope_switch", "是否打开客户单 scope 校验", r1, r1);
    }
}
