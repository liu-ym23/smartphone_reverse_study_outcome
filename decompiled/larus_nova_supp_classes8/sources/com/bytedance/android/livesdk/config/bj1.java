package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class bj1 extends SettingKey<Boolean> {
    public static final bj1 a = null;

    static {
        a = new bj1();
    }

    public bj1() {
        Boolean r1 = Boolean.TRUE;
        super("big_party_remember_camera", "是否记住开启摄像头状态", r1, r1);
    }
}
