package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ev extends SSettingKey<Boolean> {
    public static final ev a = null;

    static {
        a = new ev();
    }

    public ev() {
        super("live_f2_popup_enable", "F2红包雨弹窗开关", Boolean.TRUE, Boolean.FALSE);
    }
}
