package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class nb0 extends SSettingKey<Boolean> {
    public static final nb0 a = null;

    static {
        a = new nb0();
    }

    public nb0() {
        Boolean r1 = Boolean.TRUE;
        super("live_multi_link_preview_dynamic_service_multi", "多人场景预览流动态化服务多实例读写", r1, r1);
    }
}
