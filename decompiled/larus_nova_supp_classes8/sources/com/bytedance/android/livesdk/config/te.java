package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class te extends SSettingKey<Boolean> {
    public static final te a = null;

    static {
        a = new te();
    }

    public te() {
        Boolean r1 = Boolean.TRUE;
        super("live_audience_enable_announcement_highlight", "观众显示直播预告贴片", r1, r1);
    }
}
