package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class r8 extends SSettingKey<Boolean> {
    public static final r8 a = null;

    static {
        a = new r8();
    }

    public r8() {
        Boolean r1 = Boolean.FALSE;
        super("jsb_disable_all_permission_check", "屏蔽JSB 鉴权", r1, r1);
    }
}
