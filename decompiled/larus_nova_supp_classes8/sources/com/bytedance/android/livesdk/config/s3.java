package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class s3 extends SSettingKey<Boolean> {
    public static final s3 a = null;

    static {
        a = new s3();
    }

    public s3() {
        Boolean r1 = Boolean.TRUE;
        super("enable_live_vr_gesture_drag_view_new", "是否使用新的VR直播间手势拖动视角版本", r1, r1);
    }
}
