package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class wd extends SSettingKey<Boolean> {
    public static final wd a = null;

    static {
        a = new wd();
    }

    public wd() {
        Boolean r4 = Boolean.FALSE;
        super("live_announcement_end_page_audience_opt", "观众侧关播页预告优化", r4, r4, true);
    }
}
