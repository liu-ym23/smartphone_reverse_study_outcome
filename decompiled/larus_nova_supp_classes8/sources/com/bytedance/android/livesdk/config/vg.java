package com.bytedance.android.livesdk.config;

import com.ss.android.ugc.aweme.debug.LocalTestManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class vg extends SSettingKey<Boolean> {
    public static final vg a = null;

    public vg() {
        LocalTestManager.a(new Class[]{wy.a.class});
        Boolean r0 = Boolean.FALSE;
        super("live_broadcast_audio_float_window", "主播端语音直播小窗", r0, r0);
    }

    static {
        a = new vg();
    }
}
