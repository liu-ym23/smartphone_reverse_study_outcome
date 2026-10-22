package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f4 extends SSettingKey<Boolean> {
    public static final f4 a = null;

    static {
        a = new f4();
    }

    public f4() {
        Boolean r4 = Boolean.FALSE;
        super("enable_room_schema_optimize", "抖音room schema进房体验优化", r4, r4, true);
    }
}
