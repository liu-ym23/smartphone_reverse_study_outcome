package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ff1 extends SSettingKey<Boolean> {
    public static final ff1 a = null;

    static {
        a = new ff1();
    }

    public ff1() {
        Boolean r1 = Boolean.TRUE;
        super("revlink_preload_widget_enable", "是否加载RevLinkPreloadWidget", r1, r1);
    }
}
