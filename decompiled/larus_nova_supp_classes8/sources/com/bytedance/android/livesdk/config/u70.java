package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class u70 extends SSettingKey<Boolean> {
    public static final u70 a = null;

    static {
        a = new u70();
    }

    public u70() {
        Boolean r1 = Boolean.TRUE;
        super("live_lyric_recognize_create_not_douyin_opt", "歌词识别Recognizer初始化非抖音优化", r1, r1);
    }
}
