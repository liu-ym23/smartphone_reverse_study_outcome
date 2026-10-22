package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class s00 extends SSettingKey<Boolean> {
    public static final s00 a = null;

    static {
        a = new s00();
    }

    public s00() {
        Boolean r1 = Boolean.TRUE;
        super("live_hybrid_jsb_multi_link_support", "jsb是否支持PK判断(多人开关)", r1, r1);
    }
}
