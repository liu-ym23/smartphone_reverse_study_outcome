package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class zq extends SSettingKey<Boolean> {
    public static final zq a = null;

    static {
        a = new zq();
    }

    public zq() {
        Boolean r1 = Boolean.FALSE;
        super("live_enable_auto_page_change", "进房失败后是否自动切换到下一页", r1, r1);
    }
}
