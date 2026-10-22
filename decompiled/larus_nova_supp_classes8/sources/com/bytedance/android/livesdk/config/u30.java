package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class u30 extends SettingKey<Boolean> {
    public static final u30 a = null;

    static {
        a = new u30();
    }

    public u30() {
        Boolean r1 = Boolean.TRUE;
        super("live_jsb_follow_failure_callback_fix", "关注主播jsb请求失败走finishWithFailure", r1, r1);
    }
}
