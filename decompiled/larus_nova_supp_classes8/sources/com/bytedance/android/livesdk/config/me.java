package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class me extends SSettingKey<Boolean> {
    public static final me a = null;

    static {
        a = new me();
    }

    public me() {
        Boolean r1 = Boolean.TRUE;
        super("live_assets_manager_preload_optimize", "AssetsManager预热开关", r1, r1);
    }
}
