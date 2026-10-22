package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g6 extends SSettingKey<Boolean> {
    public static final g6 a = null;

    static {
        a = new g6();
    }

    public g6() {
        Boolean r1 = Boolean.TRUE;
        super("live_stream_auto_adapter_leak_fix", "StreamAutoAdapterService内存泄漏修改", r1, r1);
    }
}
