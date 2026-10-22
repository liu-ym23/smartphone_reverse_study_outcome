package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class rs0 extends SSettingKey<Boolean> {
    public static final rs0 a = null;

    static {
        a = new rs0();
    }

    public rs0() {
        Boolean r1 = Boolean.FALSE;
        super("live_slide_right_close_room", "点击清屏实验组可以右滑退出直播间", r1, r1);
    }
}
