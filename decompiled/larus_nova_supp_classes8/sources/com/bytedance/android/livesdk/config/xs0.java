package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.SmoothLeaveOptConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class xs0 extends SSettingKey<SmoothLeaveOptConfig> {
    public static final xs0 a = null;

    static {
        a = new xs0();
    }

    public xs0() {
        super("live_smooth_leave_opt_config", "平滑退房UI优化", new SmoothLeaveOptConfig(), new SmoothLeaveOptConfig());
    }
}
