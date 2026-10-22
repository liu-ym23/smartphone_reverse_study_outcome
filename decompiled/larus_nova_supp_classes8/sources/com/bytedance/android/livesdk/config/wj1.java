package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class wj1 extends SSettingKey<Boolean> {
    public static final wj1 a = null;

    static {
        a = new wj1();
    }

    public wj1() {
        super("web_offline_enabled", Boolean.TRUE, "web 离线化开关", new String[]{"false:不开启", "true:开启"});
    }
}
