package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class rx0 extends SSettingKey<Boolean> {
    public static final rx0 a = null;

    static {
        a = new rx0();
    }

    public rx0() {
        Boolean r1 = Boolean.FALSE;
        super("live_vr_use_new_gesture", "VR直播间是否开启清屏模式支持手势拖拽 && 非清屏模式（VR模式除外）关闭手势拖拽", r1, r1);
    }
}
