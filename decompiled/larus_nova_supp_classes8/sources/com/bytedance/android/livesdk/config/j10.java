package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j10 extends SettingKey<Boolean> {
    public static final j10 a = null;

    static {
        a = new j10();
    }

    public j10() {
        Boolean r1 = Boolean.FALSE;
        super("live_inner_end_preview_backup", "刷空使用预览流直播间兜底", r1, r1);
    }
}
