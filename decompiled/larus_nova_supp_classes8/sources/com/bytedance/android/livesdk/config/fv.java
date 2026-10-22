package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class fv extends SSettingKey<Long> {
    public static final fv a = null;

    static {
        a = new fv();
    }

    public fv() {
        super("live_face_sticker_effectively_use_time", 30L, "贴纸使用行为的统计时长");
    }
}
