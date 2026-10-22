package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class vw extends SSettingKey<Boolean> {
    public static final vw a = null;

    static {
        a = new vw();
    }

    public vw() {
        Boolean r1 = Boolean.TRUE;
        super("live_fix_single_page_resume_start_audio_error_v2", "修复单页面开播resume时打开音频采集的异常2", r1, r1);
    }
}
