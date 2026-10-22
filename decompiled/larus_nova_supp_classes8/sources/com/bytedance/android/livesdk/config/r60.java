package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class r60 extends SSettingKey<Boolean> {
    public static final r60 a = null;

    static {
        a = new r60();
    }

    public r60() {
        Boolean r1 = Boolean.FALSE;
        super("live_link_multi_enlarge_relist_enable", "主咖模式下端上是否需要进行重排序", r1, r1);
    }
}
