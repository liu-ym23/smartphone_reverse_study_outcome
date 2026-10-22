package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class oh0 extends SSettingKey<Boolean> {
    public static final oh0 a = null;

    static {
        a = new oh0();
    }

    public oh0() {
        Boolean r1 = Boolean.TRUE;
        super("live_pk_single_view_overlap_check", "PK单View重叠区域检查", r1, r1);
    }
}
