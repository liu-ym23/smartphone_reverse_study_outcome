package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class hj extends SSettingKey<Boolean> {
    public static final hj a = null;

    static {
        a = new hj();
    }

    public hj() {
        Boolean r1 = Boolean.TRUE;
        super("live_castscreen_linking_hide_interaction", "投屏播控连接时，隐藏交互层", r1, r1);
    }
}
