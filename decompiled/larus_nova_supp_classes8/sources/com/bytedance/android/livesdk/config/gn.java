package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class gn extends SSettingKey<Integer> {
    public static final gn a = null;

    static {
        a = new gn();
    }

    public gn() {
        super("live_detect_rts_room_delayed_time", "探测RTS房间延迟时间", 0, 0, new String[]{"0:0s"});
    }
}
