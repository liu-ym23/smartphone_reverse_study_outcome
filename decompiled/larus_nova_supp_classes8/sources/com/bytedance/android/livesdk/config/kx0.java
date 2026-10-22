package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class kx0 extends SSettingKey<Boolean> {
    public static final kx0 a = null;

    static {
        a = new kx0();
    }

    public kx0() {
        Boolean r1 = Boolean.TRUE;
        super("live_vr_camera_replace", "VR直播间副机位是否直接替换ContentType", r1, r1);
    }
}
