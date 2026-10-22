package com.bytedance.android.livesdk.config;

import com.bytedance.bmmt.base.DeviceInfoAndroid;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class xv0 extends SSettingKey<Integer> {
    public static final xv0 a = null;

    static {
        a = new xv0();
    }

    public xv0() {
        Integer r0 = Integer.valueOf(DeviceInfoAndroid.BUFFER_SIZE);
        super("live_get_picture_max_size", "Get Picture JSB 图片最大尺寸(KB)", r0, r0);
    }
}
