package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class nt0 extends SSettingKey<Boolean> {
    public static final nt0 a = null;

    static {
        a = new nt0();
    }

    public nt0() {
        Boolean r1 = Boolean.TRUE;
        super("live_streamer_end_page_preload", "关播页使用新链接启用preload", r1, r1);
    }
}
