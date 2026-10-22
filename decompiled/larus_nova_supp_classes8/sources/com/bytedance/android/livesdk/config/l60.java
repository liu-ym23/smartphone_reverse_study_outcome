package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class l60 extends SSettingKey<Boolean> {
    public static final l60 a = null;

    static {
        a = new l60();
    }

    public l60() {
        Boolean r1 = Boolean.TRUE;
        super("live_link_change_nomal_enable", "连线转成普通直播重置清屏behavior", r1, r1);
    }
}
