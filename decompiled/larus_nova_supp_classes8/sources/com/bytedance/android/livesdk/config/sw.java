package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class sw extends SSettingKey<Boolean> {
    public static final sw a = null;

    static {
        a = new sw();
    }

    public sw() {
        Boolean r1 = Boolean.TRUE;
        super("live_fix_pre_stream_danmaku_view_residual", "直播预流弹幕修复view残留", r1, r1);
    }
}
