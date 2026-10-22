package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class lm extends SSettingKey<Integer> {
    public static final lm a = null;

    static {
        a = new lm();
    }

    public lm() {
        super("live_cover_crop_type", "直播封面裁剪方式", 0, 1, new String[]{"0:调用系统裁剪", "1:调用CropFragment"});
    }
}
