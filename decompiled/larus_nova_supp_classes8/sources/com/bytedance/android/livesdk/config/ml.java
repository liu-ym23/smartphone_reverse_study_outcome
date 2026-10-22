package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ml extends SSettingKey<Boolean> {
    public static final ml a = null;

    static {
        a = new ml();
    }

    public ml() {
        Boolean r1 = Boolean.FALSE;
        super("live_combine_record_entrance_audience", "观众直播录屏入口合并", r1, r1);
    }
}
