package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class w00 extends SSettingKey<Boolean> {
    public static final w00 a = null;

    static {
        a = new w00();
    }

    public w00() {
        Boolean r1 = Boolean.TRUE;
        super("live_image_picker_permission_check_enable", "系统图片资源权限申请配置", r1, r1);
    }
}
