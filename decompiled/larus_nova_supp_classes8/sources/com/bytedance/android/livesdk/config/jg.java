package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class jg extends SSettingKey<Boolean> {
    public static final jg a = null;

    static {
        a = new jg();
    }

    public jg() {
        Boolean r1 = Boolean.TRUE;
        super("live_big_event_enable_local", "重保事件本地开关", r1, r1);
    }
}
