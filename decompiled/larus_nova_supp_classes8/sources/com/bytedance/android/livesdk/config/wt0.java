package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class wt0 extends SSettingKey<Boolean> {
    public static final wt0 a = null;

    static {
        a = new wt0();
    }

    public wt0() {
        Boolean r1 = Boolean.TRUE;
        super("live_support_only_secuid_jump_host_profile", "是否只支持secUid打开宿主个人主页", r1, r1);
    }
}
