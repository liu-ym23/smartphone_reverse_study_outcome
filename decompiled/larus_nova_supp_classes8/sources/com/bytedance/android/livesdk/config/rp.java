package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class rp extends SettingKey<Boolean> {
    public static final rp a = null;

    static {
        a = new rp();
    }

    public rp() {
        Boolean r1 = Boolean.FALSE;
        super("live_dylite_linkmic_open", "抖音极速版连线能力开关", r1, r1);
    }
}
