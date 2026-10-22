package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ur0 extends SSettingKey<Boolean> {
    public static final ur0 a = null;

    static {
        a = new ur0();
    }

    public ur0() {
        super("live_share_enter_room_fallback", Boolean.TRUE, "分享外置进房数据为空，兜底处理");
    }
}
