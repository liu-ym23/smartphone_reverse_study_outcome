package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d80 extends SSettingKey<Boolean> {
    public static final d80 a = null;

    static {
        a = new d80();
    }

    public d80() {
        Boolean r1 = Boolean.TRUE;
        super("live_enable_vs_media_publicscreen", "竖屏媒体节目融合是否UI对齐", r1, r1);
    }
}
