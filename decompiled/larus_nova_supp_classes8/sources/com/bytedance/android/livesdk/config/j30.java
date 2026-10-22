package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j30 extends SSettingKey<Boolean> {
    public static final j30 a = null;

    static {
        a = new j30();
    }

    public j30() {
        Boolean r1 = Boolean.TRUE;
        super("live_interact_widget_leak", "直播间widget泄露", r1, r1);
    }
}
