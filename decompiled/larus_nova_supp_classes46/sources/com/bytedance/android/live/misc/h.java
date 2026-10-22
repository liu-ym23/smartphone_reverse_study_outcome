package com.bytedance.android.live.misc;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h extends SSettingKey<Boolean> {
    public static final h a = null;

    static {
        a = new h();
    }

    public h() {
        Boolean r1 = Boolean.TRUE;
        super("live_template_mic_anchor_fix", "模板化麦序房主播组件修复", r1, r1);
    }
}
