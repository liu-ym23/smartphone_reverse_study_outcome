package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class px0 extends SSettingKey<Boolean> {
    public static final px0 a = null;

    static {
        a = new px0();
    }

    public px0() {
        Boolean r1 = Boolean.TRUE;
        super("live_vr_substream_default_resolution", "VR副机位是否使用副流的启播清晰度", r1, r1);
    }
}
