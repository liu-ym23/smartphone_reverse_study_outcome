package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b90 extends SSettingKey<Boolean> {
    public static final b90 a = null;

    static {
        a = new b90();
    }

    public b90() {
        super("ieslive_lgame_multi_enable", "小游戏支持多人场景", Boolean.FALSE, Boolean.TRUE);
    }
}
