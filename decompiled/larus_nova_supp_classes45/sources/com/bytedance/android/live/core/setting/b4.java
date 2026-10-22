package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b4 extends SSettingKey<Boolean> {
    public static final b4 a = null;

    static {
        a = new b4();
    }

    public b4() {
        Boolean r1 = Boolean.FALSE;
        super("live_previre_qualitylist_enable", "预览流检查qualitylist", r1, r1);
    }
}
