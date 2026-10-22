package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ak0 extends SettingKey<Boolean> {
    public static final ak0 a = null;

    static {
        a = new ak0();
    }

    public ak0() {
        Boolean r1 = Boolean.FALSE;
        super("live_preview_video_core_path_merge_single", "单页面下开播页音画链路合并", r1, r1);
    }
}
