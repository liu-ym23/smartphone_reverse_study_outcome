package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class iu0 extends SSettingKey<ls1.y> {
    public static final iu0 a = null;

    static {
        iu0 r0 = new iu0();
        a = r0;
        r0.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public iu0() {
        super("live_tag_request_method", "直播TAG请求方式", new ls1.y(), new ls1.y());
    }
}
