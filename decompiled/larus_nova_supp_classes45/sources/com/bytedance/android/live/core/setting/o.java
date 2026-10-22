package com.bytedance.android.live.core.setting;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class o extends SettingKey<Boolean> {
    public static final o a = null;

    static {
        a = new o();
    }

    public o() {
        super("live_apk_size_resource_opt", "直播包体积优化-webp自动走Gecko", Boolean.FALSE, Boolean.TRUE);
    }
}
