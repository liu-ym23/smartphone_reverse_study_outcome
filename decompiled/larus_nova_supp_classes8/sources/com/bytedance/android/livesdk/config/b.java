package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b extends SSettingKey<Boolean> {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
        boolean r0 = tb1.c.a;
        super("anchor_bluetooth_permission", "主播开播申请蓝牙权限适配target33", Boolean.valueOf(r0), Boolean.valueOf(r0));
    }
}
