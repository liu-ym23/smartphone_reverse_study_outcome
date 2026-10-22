package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class zt0 extends SSettingKey<Integer> {
    public static final zt0 a = null;

    public zt0() {
        super("live_switch_camera_change_surface_scene", "切机位重建SurfaceView的场景。0关闭，1仅VR，2所有类型的机位", 1, 1);
    }

    static {
        a = new zt0();
    }
}
