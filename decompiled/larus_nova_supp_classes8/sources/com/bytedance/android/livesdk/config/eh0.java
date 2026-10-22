package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class eh0 extends SSettingKey<Boolean> {
    public static final eh0 a = null;

    static {
        a = new eh0();
    }

    public eh0() {
        Boolean r1 = Boolean.TRUE;
        super("live_pk_guest_stop_forward_opt_enable", "是否支持PK嘉宾侧停止转推逻辑兜底", r1, r1);
    }
}
