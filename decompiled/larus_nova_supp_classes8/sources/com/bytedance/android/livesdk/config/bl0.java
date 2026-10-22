package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class bl0 extends SSettingKey<Boolean> {
    public static final bl0 a = null;

    static {
        a = new bl0();
    }

    public bl0() {
        Boolean r1 = Boolean.FALSE;
        super("live_ps_recommend_to_friend_msg_click_enable", "公屏推荐消息是否支持点击打开长按面板", r1, r1);
    }
}
