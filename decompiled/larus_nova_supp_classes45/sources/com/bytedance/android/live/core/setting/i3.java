package com.bytedance.android.live.core.setting;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i3 extends SettingKey<Boolean> {
    public static final i3 a = null;

    static {
        a = new i3();
    }

    public i3() {
        Boolean r1 = Boolean.FALSE;
        super("live_offline_gecko_separate", "gecko和下载代码功能分离", r1, r1);
    }
}
