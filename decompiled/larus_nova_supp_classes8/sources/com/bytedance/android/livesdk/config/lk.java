package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class lk extends SSettingKey<Boolean> {
    public static final lk a = null;

    static {
        a = new lk();
    }

    public lk() {
        Boolean r1 = Boolean.TRUE;
        super("live_chorus_pause_and_play", "合唱暂停播放IM消息修复", r1, r1);
    }
}
