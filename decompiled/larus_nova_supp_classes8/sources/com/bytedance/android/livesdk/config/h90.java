package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h90 extends SSettingKey<Boolean> {
    public static final h90 a = null;

    static {
        a = new h90();
    }

    public h90() {
        Boolean r4 = Boolean.TRUE;
        super("live_miniapp_talent_mount_module_show", "小程序直播达人挂载功能-任务推广模块", r4, r4, new String[]{"true:展示", "false:隐藏"});
    }
}
