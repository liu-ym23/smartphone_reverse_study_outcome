package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class gp0 extends SSettingKey<Integer> {
    public static final gp0 a = null;

    static {
        a = new gp0();
    }

    public gp0() {
        super("live_room_tag_request_numbers", "房间三级标签请求数量限制", 20, 20);
    }
}
