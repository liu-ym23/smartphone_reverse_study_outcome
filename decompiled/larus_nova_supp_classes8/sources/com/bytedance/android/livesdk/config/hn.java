package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class hn extends SSettingKey<Integer> {
    public static final hn a = null;

    static {
        a = new hn();
    }

    public hn() {
        super("live_detect_rts_room_max_retry_count", "探测RTS房间最大重试次数", 0, 0, new String[]{""});
    }
}
