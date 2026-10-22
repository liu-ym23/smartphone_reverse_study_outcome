package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class mn extends SSettingKey<Boolean> {
    public static final mn a = null;

    static {
        a = new mn();
    }

    public mn() {
        Boolean r1 = Boolean.TRUE;
        super("live_digg_bind_transform_components", "点赞换肤批量绑定转换组件兜底开关", r1, r1);
    }
}
