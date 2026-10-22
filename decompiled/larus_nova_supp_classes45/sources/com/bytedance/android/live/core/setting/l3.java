package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class l3 extends SSettingKey<Boolean> {
    public static final l3 a = null;

    static {
        a = new l3();
    }

    public l3() {
        super("live_off_webcast_tab_api", "下线webcast/tab接口", Boolean.FALSE, Boolean.TRUE);
    }
}
