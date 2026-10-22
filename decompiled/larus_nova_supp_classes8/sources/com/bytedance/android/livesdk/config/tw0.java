package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class tw0 extends SSettingKey<Boolean> {
    public static final tw0 a = null;

    static {
        a = new tw0();
    }

    public tw0() {
        Boolean r1 = Boolean.TRUE;
        super("live_video_chorus_conflict_multi_chorus_enable", "视频合唱和一起唱互斥开关", r1, r1);
    }
}
