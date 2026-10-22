package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class rm extends SSettingKey<Boolean> {
    public static final rm a = null;

    static {
        a = new rm();
    }

    public rm() {
        Boolean r1 = Boolean.FALSE;
        super("live_danmaku_widget_async_enabled", "直播预览弹幕组件异步配置开关", r1, r1);
    }
}
