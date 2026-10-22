package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class hg extends SSettingKey<Boolean> {
    public static final hg a = null;

    static {
        a = new hg();
    }

    public hg() {
        Boolean r1 = Boolean.TRUE;
        super("live_bg_notify_download_bitmap_resize", "切后台通知图片resize", r1, r1);
    }
}
