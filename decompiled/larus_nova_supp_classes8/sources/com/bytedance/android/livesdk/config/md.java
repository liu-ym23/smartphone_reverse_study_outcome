package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class md extends SSettingKey<Boolean> {
    public static final md a = null;

    static {
        a = new md();
    }

    public md() {
        Boolean r1 = Boolean.TRUE;
        super("live_anchor_virtual_live_pk_enable", "虚拟直播开启pk", r1, r1);
    }
}
