package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ej extends SSettingKey<Boolean> {
    public static final ej a = null;

    static {
        a = new ej();
    }

    public ej() {
        Boolean r1 = Boolean.TRUE;
        super("live_camera_permission_fix", "相机权限问题处理", r1, r1);
    }
}
