package com.bytedance.android.livesdk.config;

import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class dt0 extends SSettingKey<List<? extends String>> {
    public static final dt0 a = null;

    static {
        a = new dt0();
    }

    public dt0() {
        List<String> r1 = d81.b;
        super("live_start_float_window_access_list", "小窗调用方", r1, r1);
    }
}
