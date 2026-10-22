package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e20 extends SSettingKey<Boolean> {
    public static final e20 a = null;

    static {
        a = new e20();
    }

    public e20() {
        Boolean r1 = Boolean.TRUE;
        super("live_inner_wrds_preload_load_more_opt", "直播间内流wrds预加载loadmore更新直播间id", r1, r1);
    }
}
