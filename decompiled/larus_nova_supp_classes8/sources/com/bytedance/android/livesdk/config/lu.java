package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class lu extends SSettingKey<Integer> {
    public static final lu a = null;

    public lu() {
        super("live_enter_room_jit_gc_inhibition", "首次进房 jit GC抑制时间", 0, 0);
    }

    static {
        a = new lu();
    }
}
