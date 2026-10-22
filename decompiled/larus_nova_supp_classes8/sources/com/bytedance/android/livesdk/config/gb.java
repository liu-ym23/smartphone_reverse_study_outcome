package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class gb extends SSettingKey<Boolean> {
    public static final gb a = null;

    static {
        a = new gb();
    }

    public gb() {
        Boolean r1 = Boolean.TRUE;
        super("live_anchor_continue_live__state", "主播续播恢复演唱状态", r1, r1);
    }
}
