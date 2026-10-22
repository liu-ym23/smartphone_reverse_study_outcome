package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class x00 extends SSettingKey<Boolean> {
    public static final x00 a = null;

    static {
        a = new x00();
    }

    public x00() {
        Boolean r1 = Boolean.TRUE;
        super("live_image_picker_permission_fix", "图片选择权限问题处理", r1, r1);
    }
}
