package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class mw0 extends SSettingKey<Integer> {
    public static final mw0 a = null;

    static {
        a = new mw0();
    }

    public mw0() {
        super("live_vertical_pre_inflate_count", "多人场景上下滑Nita预加载View数量", 10, 10);
    }
}
