package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ql0 extends SSettingKey<Boolean> {
    public static final ql0 a = null;

    static {
        a = new ql0();
    }

    public ql0() {
        Boolean r1 = Boolean.FALSE;
        super("live_public_screen_history_first_load_use_self_api", "公屏历史评论接口拆分", r1, r1);
    }
}
