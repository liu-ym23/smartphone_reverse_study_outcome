package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class cc extends SSettingKey<Boolean> {
    public static final cc a = null;

    static {
        a = new cc();
    }

    public cc() {
        Boolean r1 = Boolean.FALSE;
        super("live_anchor_live_enable_adjust_focus_and_exposure", "主播侧直播间手动调焦&曝光开关", r1, r1);
    }
}
