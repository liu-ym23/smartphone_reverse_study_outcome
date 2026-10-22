package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d60 extends SettingKey<Boolean> {
    public static final d60 a = null;

    static {
        a = new d60();
    }

    public d60() {
        Boolean r1 = Boolean.TRUE;
        super("live_linkmic_leave_page_v3_enable", "多人连线结束页-连线复盘页", r1, r1);
    }
}
