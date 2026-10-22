package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class xh0 extends SSettingKey<Boolean> {
    public static final xh0 a = null;

    static {
        a = new xh0();
    }

    public xh0() {
        Boolean r1 = Boolean.TRUE;
        super("live_player_fix_nearby_jump_mix_audio", "修复同城更多直播跳转串音问题", r1, r1);
    }
}
