package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a3 extends SSettingKey<Boolean> {
    public static final a3 a = null;

    static {
        a = new a3();
    }

    public a3() {
        Boolean r1 = Boolean.FALSE;
        super("live_multi_link_preview_last_sei_app_data_opt", "预览流多人场景LastSeiAppData优化", r1, r1);
    }
}
