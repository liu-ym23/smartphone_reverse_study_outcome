package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class r3 extends SSettingKey<Boolean> {
    public static final r3 a = null;

    static {
        a = new r3();
    }

    public r3() {
        Boolean r1 = Boolean.TRUE;
        super("enable_live_player_framelayout_exception_margin_fallback", "是否开启播放器流画面高度异常兜底复原逻辑", r1, r1);
    }
}
