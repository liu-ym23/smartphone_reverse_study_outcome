package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class pd0 extends SSettingKey<Boolean> {
    public static final pd0 a = null;

    static {
        a = new pd0();
    }

    public pd0() {
        Boolean r1 = Boolean.TRUE;
        super("live_old_long_press_panel_stream_adapt", "旧版长按面板唤醒后流画面自适应", r1, r1);
    }
}
