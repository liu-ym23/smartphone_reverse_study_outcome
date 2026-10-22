package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class nm0 extends SSettingKey<Boolean> {
    public static final nm0 a = null;

    static {
        a = new nm0();
    }

    public nm0() {
        Boolean r1 = Boolean.FALSE;
        super("live_recommend_to_friend_v2_enable", "推荐给朋友v2总开关", r1, r1);
    }
}
