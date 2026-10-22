package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f40 extends SSettingKey<Boolean> {
    public static final f40 a = null;

    static {
        a = new f40();
    }

    public f40() {
        Boolean r1 = Boolean.TRUE;
        super("live_ktv_chorus_entry_enable", "控制特定 app 是否支持显示加入合唱入口", r1, r1);
    }
}
