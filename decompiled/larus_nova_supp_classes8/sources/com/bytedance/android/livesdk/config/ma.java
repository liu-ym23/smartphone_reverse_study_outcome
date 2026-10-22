package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ma extends SSettingKey<Boolean> {
    public static final ma a = null;

    static {
        a = new ma();
    }

    public ma() {
        Boolean r1 = Boolean.FALSE;
        super("live_allow_download_gecko_resource_v2", "是否主动触发gecko资源下载", r1, r1);
    }
}
