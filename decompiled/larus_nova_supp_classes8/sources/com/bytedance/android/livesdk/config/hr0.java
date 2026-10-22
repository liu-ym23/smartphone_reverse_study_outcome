package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class hr0 extends SSettingKey<Boolean> {
    public static final hr0 a = null;

    static {
        a = new hr0();
    }

    public hr0() {
        Boolean r1 = Boolean.TRUE;
        super("live_seek_gesture_for_play_back_only", "只有实时回放直播打开手势seek", r1, r1);
    }
}
