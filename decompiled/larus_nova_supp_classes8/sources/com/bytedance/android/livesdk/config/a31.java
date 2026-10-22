package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a31 extends SSettingKey<Boolean> {
    public static final a31 a = null;

    static {
        a = new a31();
    }

    public a31() {
        Boolean r1 = Boolean.TRUE;
        super("live_fix_fb_show_repeat", "修复问卷展示后滑走滑回重复展示的问题", r1, r1);
    }
}
