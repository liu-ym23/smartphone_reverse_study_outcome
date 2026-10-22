package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i extends SSettingKey<Boolean> {
    public static final i a = null;

    static {
        a = new i();
    }

    public i() {
        Boolean r1 = Boolean.FALSE;
        super("link_pull_stream_enable", "连麦期间是否允许拉流", r1, r1);
    }
}
