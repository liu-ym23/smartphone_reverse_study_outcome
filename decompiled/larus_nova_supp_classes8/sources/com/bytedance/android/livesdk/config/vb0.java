package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class vb0 extends SSettingKey<Boolean> {
    public static final vb0 a = null;

    static {
        a = new vb0();
    }

    public vb0() {
        Boolean r1 = Boolean.FALSE;
        super("live_multi_link_sei_update_thread_optimize", "多人直播 SEI 更新线程优化", r1, r1);
    }
}
