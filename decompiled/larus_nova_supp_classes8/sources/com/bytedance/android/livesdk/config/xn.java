package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class xn extends SSettingKey<Boolean> {
    public static final xn a = null;

    static {
        a = new xn();
    }

    public xn() {
        Boolean r1 = Boolean.FALSE;
        super("live_disable_guest_face_gift", "直播聊天室关闭嘉宾人脸礼物", r1, r1);
    }
}
