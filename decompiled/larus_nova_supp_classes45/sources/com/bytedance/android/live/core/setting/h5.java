package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h5 extends SSettingKey<Boolean> {
    public static final h5 a = null;

    static {
        a = new h5();
    }

    public h5() {
        Boolean r1 = Boolean.FALSE;
        super("live_smart_observer_config", "直播smartSDK清理Observer优化", r1, r1);
    }
}
