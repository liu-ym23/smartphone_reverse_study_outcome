package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class kd extends SSettingKey<Boolean> {
    public static final kd a = null;

    static {
        a = new kd();
    }

    public kd() {
        Boolean r1 = Boolean.TRUE;
        super("live_anchor_virtual_live_ktv_enable", "虚拟直播开启k歌", r1, r1);
    }
}
