package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class z80 extends SSettingKey<Boolean> {
    public static final z80 a = null;

    static {
        a = new z80();
    }

    public z80() {
        Boolean r1 = Boolean.TRUE;
        super("live_mg_fix_ad_schema", "修复：进房未请求entrance_info接口时，打开小游戏没带广告参数", r1, r1);
    }
}
