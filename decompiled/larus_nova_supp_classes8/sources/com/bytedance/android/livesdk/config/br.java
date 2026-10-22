package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class br extends SettingKey<Boolean> {
    public static final br a = null;

    static {
        a = new br();
    }

    public br() {
        Boolean r1 = Boolean.TRUE;
        super("live_enable_banner_a11y_fix", "banner无障碍焦点bugfix", r1, r1);
    }
}
