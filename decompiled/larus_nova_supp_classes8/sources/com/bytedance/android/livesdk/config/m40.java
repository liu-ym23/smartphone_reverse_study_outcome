package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class m40 extends SSettingKey<Boolean> {
    public static final m40 a = null;

    static {
        a = new m40();
    }

    public m40() {
        Boolean r1 = Boolean.TRUE;
        super("live_ktv_live_widget_remove", "ktv场景下，不检查renderView", r1, r1);
    }
}
