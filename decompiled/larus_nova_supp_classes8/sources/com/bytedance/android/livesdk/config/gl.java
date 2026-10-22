package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class gl extends SSettingKey<Integer> {
    public static final gl a = null;

    public gl() {
        super("live_close_largestream_superreso_type", "竖屏关闭超分配置：0关闭，1只VS，2全部直播间", 0, 0);
    }

    static {
        a = new gl();
    }
}
