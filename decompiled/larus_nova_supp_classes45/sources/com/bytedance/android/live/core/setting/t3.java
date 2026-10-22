package com.bytedance.android.live.core.setting;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class t3 extends SettingKey<Boolean> {
    public static final t3 a = null;

    static {
        a = new t3();
    }

    public t3() {
        Boolean r4 = Boolean.FALSE;
        super("live_player_enable_stream_type_fix", "直播间内流修复传入播放器的streamtype不准的问题", r4, r4, false);
    }
}
