package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class bk0 extends SSettingKey<Boolean> {
    public static final bk0 a = null;

    static {
        a = new bk0();
    }

    public bk0() {
        Boolean r1 = Boolean.TRUE;
        super("live_pre_danmaku_default_open_use_new_list", "直播预览流弹幕默认开启逻辑使用新字段判断", r1, r1);
    }
}
