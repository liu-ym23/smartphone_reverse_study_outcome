package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class kb0 extends SSettingKey<Boolean> {
    public static final kb0 a = null;

    static {
        a = new kb0();
    }

    public kb0() {
        Boolean r1 = Boolean.TRUE;
        super("live_multi_link_lynx_seat_preview_opt_prefetch", "lynx麦位预览流加载优化(wormhole预拉流)", r1, r1);
    }
}
