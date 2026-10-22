package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class sv0 extends SSettingKey<Boolean> {
    public static final sv0 a = null;

    static {
        a = new sv0();
    }

    public sv0() {
        Boolean r1 = Boolean.TRUE;
        super("ktv_update_singer_on_song_change", "歌曲变化是否更新isSinger标记", r1, r1);
    }
}
