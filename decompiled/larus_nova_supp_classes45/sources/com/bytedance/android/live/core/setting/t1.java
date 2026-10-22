package com.bytedance.android.live.core.setting;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class t1 extends SettingKey<Boolean> {
    public static final t1 a = null;

    static {
        a = new t1();
    }

    public t1() {
        Boolean r4 = Boolean.FALSE;
        super("live_gecko_dir_update", "gecko目录更新", r4, r4, false);
    }
}
