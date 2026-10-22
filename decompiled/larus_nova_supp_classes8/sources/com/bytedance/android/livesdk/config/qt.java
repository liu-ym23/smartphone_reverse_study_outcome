package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class qt extends SSettingKey<Boolean> {
    public static final qt a = null;

    static {
        a = new qt();
    }

    public qt() {
        Boolean r1 = Boolean.TRUE;
        super("live_end_follow_optimize", "关播页默认去掉关注按钮", r1, r1);
    }
}
