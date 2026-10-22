package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j9 extends SSettingKey<Boolean> {
    public static final j9 a = null;

    static {
        a = new j9();
    }

    public j9() {
        Boolean r1 = Boolean.TRUE;
        super("link_intercept_disposed_rooms", "拦截已停止的房间的连麦初始化过程（风险控制用）", r1, r1);
    }
}
