package com.bytedance.android.livesdk.config;

import com.bytedance.bmmt.base.DeviceInfoAndroid;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class lg0 extends SSettingKey<Integer> {
    public static final lg0 a = null;

    static {
        a = new lg0();
    }

    public lg0() {
        Integer r0 = Integer.valueOf(DeviceInfoAndroid.BUFFER_SIZE);
        super("live_picked_emoji_photo_max_size", "订阅会员自定义表情选择用于裁剪的图片最大大小(KB)，超过则重新选择", r0, r0);
    }
}
