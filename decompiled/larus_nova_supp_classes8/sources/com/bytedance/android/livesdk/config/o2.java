package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class o2 extends SSettingKey<Integer> {
    public static final o2 a = null;

    public o2() {
        super("drawer_feed_view_model_update_ab", "0 线上 url不变就不刷新数据 1 每次打开抽屉都刷新数据 2 端智能", 0, 0);
    }

    static {
        a = new o2();
    }
}
