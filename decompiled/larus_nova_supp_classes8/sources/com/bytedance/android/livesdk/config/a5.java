package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a5 extends SSettingKey<Boolean> {
    public static final a5 a = null;

    static {
        a = new a5();
    }

    public a5() {
        Boolean r1 = Boolean.TRUE;
        super("fix_live_fix_user_profile_scheme", "上面兜底导致了一个合规问题，这个setting用于取消上面的兜底", r1, r1);
    }
}
