package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f90 extends SSettingKey<Boolean> {
    public static final f90 a = null;

    static {
        a = new f90();
    }

    public f90() {
        Boolean r1 = Boolean.TRUE;
        super("live_mic_room_enable_link_guest_opt", "麦序房是否开启连线嘉宾重新进入过滤", r1, r1);
    }
}
