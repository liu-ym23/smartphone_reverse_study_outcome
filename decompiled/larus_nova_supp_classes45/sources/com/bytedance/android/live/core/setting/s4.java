package com.bytedance.android.live.core.setting;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class s4 extends SettingKey<Boolean> {
    public static final s4 a = null;

    static {
        a = new s4();
    }

    public s4() {
        Boolean r1 = Boolean.TRUE;
        super("live_room_avatar_width_use_vm", "左上角通过VM控制宽度", r1, r1);
    }
}
