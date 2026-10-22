package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class cg extends SSettingKey<Long> {
    public static final cg a = null;

    static {
        a = new cg();
    }

    public cg() {
        super("live_back_record_play_seconds", "回溯录屏录制时长", 30L, 30L);
    }
}
