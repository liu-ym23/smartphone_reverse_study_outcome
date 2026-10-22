package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class cf1 extends SSettingKey<Boolean> {
    public static final cf1 a = null;

    static {
        a = new cf1();
    }

    public cf1() {
        Boolean r1 = Boolean.TRUE;
        super("report_opt_config", "举报优化开关（跳过不喜欢直播间）", r1, r1);
    }
}
