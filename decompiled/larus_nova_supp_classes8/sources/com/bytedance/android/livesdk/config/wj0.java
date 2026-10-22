package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class wj0 extends SSettingKey<Boolean> {
    public static final wj0 a = null;

    static {
        a = new wj0();
    }

    public wj0() {
        Boolean r1 = Boolean.TRUE;
        super("live_preview_smooth_use_bitmap", "抖音预览流平滑进房用bitmap过渡", r1, r1);
    }
}
