package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class cb0 extends SSettingKey<Boolean> {
    public static final cb0 a = null;

    static {
        a = new cb0();
    }

    public cb0() {
        Boolean r1 = Boolean.TRUE;
        super("live_multi_link_comsume_self_room_sei_only_new", "多人通用布局观众端只消费本房间sei", r1, r1);
    }
}
