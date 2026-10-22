package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class wr extends SSettingKey<Boolean> {
    public static final wr a = null;

    static {
        a = new wr();
    }

    public wr() {
        Boolean r4 = Boolean.TRUE;
        super("live_enable_guide_view_only_for_qa", "端上是否支持引导页展示，该开关不会关闭，只有在QA自动化测试时临时关闭", r4, r4, true);
    }
}
