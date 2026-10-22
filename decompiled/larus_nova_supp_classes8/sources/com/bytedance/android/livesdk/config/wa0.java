package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class wa0 extends SSettingKey<Boolean> {
    public static final wa0 a = null;

    static {
        a = new wa0();
    }

    public wa0() {
        Boolean r1 = Boolean.TRUE;
        super("live_multi_component_instance_lifecycle", "直播多人MultiComponentManager生命周期", r1, r1);
    }
}
