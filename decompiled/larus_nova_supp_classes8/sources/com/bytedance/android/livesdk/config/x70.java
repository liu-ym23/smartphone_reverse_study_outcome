package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class x70 extends SSettingKey<Boolean> {
    public static final x70 a = null;

    static {
        a = new x70();
    }

    public x70() {
        Boolean r1 = Boolean.FALSE;
        super("live_matrix_support_cur_app", "当前宿主是否支持关联矩阵", r1, r1);
    }
}
