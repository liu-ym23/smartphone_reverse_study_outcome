package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b31 extends SSettingKey<Boolean> {
    public static final b31 a = null;

    static {
        a = new b31();
    }

    public b31() {
        Boolean r1 = Boolean.TRUE;
        super("live_fix_short_touch_forbidden", "修复短触区管控能力开关", r1, r1);
    }
}
