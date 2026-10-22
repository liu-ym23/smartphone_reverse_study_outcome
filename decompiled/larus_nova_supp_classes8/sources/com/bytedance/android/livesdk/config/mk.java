package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class mk extends SSettingKey<Boolean> {
    public static final mk a = null;

    static {
        a = new mk();
    }

    public mk() {
        Boolean r1 = Boolean.TRUE;
        super("live_chorus_unload_rts", "合唱场景不加载RTS", r1, r1);
    }
}
