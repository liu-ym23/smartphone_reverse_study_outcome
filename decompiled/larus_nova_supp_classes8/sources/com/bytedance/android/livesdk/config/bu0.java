package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class bu0 extends SSettingKey<Boolean> {
    public static final bu0 a = null;

    static {
        a = new bu0();
    }

    public bu0() {
        Boolean r1 = Boolean.FALSE;
        super("live_switch_mark_unread_to_remote", "切换不使用消重回收的判断方式", r1, r1);
    }
}
