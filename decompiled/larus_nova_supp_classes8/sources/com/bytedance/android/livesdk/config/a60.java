package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a60 extends SSettingKey<Boolean> {
    public static final a60 a = null;

    static {
        a = new a60();
    }

    public a60() {
        Boolean r1 = Boolean.TRUE;
        super("live_linkmic_fast_match_more_shake_enable", "是否显示直播间右下角...中的摇一摇连线入口", r1, r1);
    }
}
