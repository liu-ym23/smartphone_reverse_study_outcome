package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d3 extends SSettingKey<Boolean> {
    public static final d3 a = null;

    static {
        a = new d3();
    }

    public d3() {
        Boolean r1 = Boolean.TRUE;
        super("live_multi_link_report_page_audio_capture_release_bugfix", "举报页面拉起相册释放音频权限", r1, r1);
    }
}
