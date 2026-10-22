package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class m60 extends SSettingKey<Boolean> {
    public static final m60 a = null;

    static {
        a = new m60();
    }

    public m60() {
        Boolean r1 = Boolean.TRUE;
        super("live_link_dynamic_audience_show_pk", "开启浮动小窗左下角展示PK按钮优化", r1, r1);
    }
}
