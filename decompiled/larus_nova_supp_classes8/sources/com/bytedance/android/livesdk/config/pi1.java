package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class pi1 extends SSettingKey<Boolean> {
    public static final pi1 a = null;

    static {
        a = new pi1();
    }

    public pi1() {
        Boolean r1 = Boolean.TRUE;
        super("use_new_fetch_jsb_method", "使用新版 Fetch JSB 实现", r1, r1);
    }
}
