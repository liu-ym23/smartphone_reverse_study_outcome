package com.bytedance.android.live.core.setting;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f1 extends SettingKey<Boolean> {
    public static final f1 a = null;

    static {
        a = new f1();
    }

    public f1() {
        Boolean r1 = Boolean.FALSE;
        super("live_enable_x_resource", "开启x-resource离线加载", r1, r1);
    }
}
