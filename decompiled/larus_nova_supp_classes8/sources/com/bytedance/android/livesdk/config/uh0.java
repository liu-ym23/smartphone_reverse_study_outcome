package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class uh0 extends SSettingKey<Boolean> {
    public static final uh0 a = null;

    static {
        a = new uh0();
    }

    public uh0() {
        Boolean r1 = Boolean.TRUE;
        super("live_pk_update_list_enable", "是否允许兜底更新用户列表", r1, r1);
    }
}
