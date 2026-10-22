package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ki extends SSettingKey<Boolean> {
    public static final ki a = null;

    static {
        a = new ki();
    }

    public ki() {
        Boolean r1 = Boolean.FALSE;
        super("live_broadcast_rebuild_opt", "开播Activity重建时恢复直播", r1, r1);
    }
}
