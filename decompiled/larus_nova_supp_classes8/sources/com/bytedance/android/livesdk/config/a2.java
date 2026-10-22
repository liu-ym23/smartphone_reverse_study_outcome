package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a2 extends SSettingKey<Boolean> {
    public static final a2 a = null;

    static {
        a = new a2();
    }

    public a2() {
        Boolean r1 = Boolean.FALSE;
        super("debug_info_in_room", "直播间内调试信息(调试用)", r1, r1);
    }
}
