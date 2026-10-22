package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ed0 extends SSettingKey<Boolean> {
    public static final ed0 a = null;

    static {
        a = new ed0();
    }

    public ed0() {
        super("live_non_same_stream_back_preview", "直播非同流退房", Boolean.FALSE, Boolean.TRUE);
    }
}
