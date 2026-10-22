package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class uv0 extends SSettingKey<Integer> {
    public static final uv0 a = null;

    static {
        a = new uv0();
    }

    public uv0() {
        super("live_upload_led_stage_max_cache_file_count", "自定LED舞台礼物裁剪完后临时图片缓存数量", 10, 10);
    }
}
