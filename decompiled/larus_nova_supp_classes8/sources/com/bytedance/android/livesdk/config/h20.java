package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h20 extends SSettingKey<Boolean> {
    public static final h20 a = null;

    static {
        a = new h20();
    }

    public h20() {
        Boolean r4 = Boolean.FALSE;
        super("live_interaction_fragment_hide_event_bind_fix", "解决直播退房时，因为声明周期问题，交互层隐藏不执行问题", r4, r4, true);
    }
}
