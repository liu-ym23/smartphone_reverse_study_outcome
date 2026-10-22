package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class tx0 extends SSettingKey<Boolean> {
    public static final tx0 a = null;

    static {
        a = new tx0();
    }

    public tx0() {
        Boolean r1 = Boolean.FALSE;
        super("live_vr_use_new_ui", "VR直播间是否启用新UI", r1, r1);
    }
}
