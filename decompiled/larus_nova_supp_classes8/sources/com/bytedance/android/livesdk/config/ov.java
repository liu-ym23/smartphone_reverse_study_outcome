package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ov extends SSettingKey<Boolean> {
    public static final ov a = null;

    static {
        a = new ov();
    }

    public ov() {
        Boolean r1 = Boolean.FALSE;
        super("live_feedback_public_new_width", "是否开启满意度反馈新宽度比例", r1, r1);
    }
}
