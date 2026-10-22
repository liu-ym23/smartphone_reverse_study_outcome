package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class s40 extends SSettingKey<Long> {
    public static final s40 a = null;

    static {
        a = new s40();
    }

    public s40() {
        super("live_ktv_music_progress_update_interval", "歌曲进度同步间隔，单位ms", 3000L, 3000L);
    }
}
