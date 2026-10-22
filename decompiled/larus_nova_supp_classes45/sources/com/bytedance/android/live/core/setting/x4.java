package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class x4 extends SSettingKey<Boolean> {
    public static final x4 a = null;

    static {
        a = new x4();
    }

    public x4() {
        Boolean r4 = Boolean.FALSE;
        super("live_search_no_view_found_fix_single", "fix no view found", r4, r4, true);
    }
}
