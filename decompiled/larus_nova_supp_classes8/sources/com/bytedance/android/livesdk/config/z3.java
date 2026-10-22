package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class z3 extends SSettingKey<Boolean> {
    public static final z3 a = null;

    static {
        a = new z3();
    }

    public z3() {
        super("enable_notice_associate_with_video", "主播开启直播预告贴纸后置挂载", Boolean.FALSE, Boolean.TRUE);
    }
}
