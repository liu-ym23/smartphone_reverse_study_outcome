package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class iz extends SSettingKey<Boolean> {
    public static final iz a = null;

    static {
        a = new iz();
    }

    public iz() {
        Boolean r1 = Boolean.TRUE;
        super("live_group_cloud_collaborare_enable", "云导播开启甩房能力", r1, r1);
    }
}
