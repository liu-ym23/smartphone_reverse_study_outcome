package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class wt extends SettingKey<Boolean> {
    public static final wt a = null;

    static {
        a = new wt();
    }

    public wt() {
        Boolean r1 = Boolean.FALSE;
        super("live_end_page_rts", "直播结束页使用RTS版本", r1, r1);
    }
}
