package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class su0 extends SSettingKey<Boolean> {
    public static final su0 a = null;

    static {
        a = new su0();
    }

    public su0() {
        Boolean r1 = Boolean.TRUE;
        super("live_toolbar_anim_enable_delay", "进房Toolbar动效delay", r1, r1);
    }
}
