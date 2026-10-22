package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class k4 extends SSettingKey<Boolean> {
    public static final k4 a = null;

    static {
        a = new k4();
    }

    public k4() {
        Boolean r4 = Boolean.TRUE;
        super("enable_upload_jsb_video_compress", "上传JSB是否开启视频压缩能力", r4, r4, true);
    }
}
