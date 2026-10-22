package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class od extends SSettingKey<Boolean> {
    public static final od a = null;

    static {
        a = new od();
    }

    public od() {
        Boolean r1 = Boolean.TRUE;
        super("live_anchor_xiaoan_bugfix", "小安面板请求成功后bugfix的端上兜底开关", r1, r1);
    }
}
