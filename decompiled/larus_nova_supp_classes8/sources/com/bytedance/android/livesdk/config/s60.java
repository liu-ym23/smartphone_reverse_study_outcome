package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class s60 extends SSettingKey<Boolean> {
    public static final s60 a = null;

    static {
        a = new s60();
    }

    public s60() {
        Boolean r1 = Boolean.TRUE;
        super("live_link_sami_array_object_opt", "音质打分数组频繁创建优化", r1, r1);
    }
}
