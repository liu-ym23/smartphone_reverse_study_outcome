package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i9 extends SSettingKey<Boolean> {
    public static final i9 a = null;

    static {
        a = new i9();
    }

    public i9() {
        Boolean r1 = Boolean.TRUE;
        super("link_interact_stream_background_opt_enable", "连麦触发停止和恢复拉流逻辑是否不区分前后台", r1, r1);
    }
}
