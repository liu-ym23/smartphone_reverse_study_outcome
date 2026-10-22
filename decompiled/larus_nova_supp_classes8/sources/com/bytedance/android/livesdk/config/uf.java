package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class uf extends SSettingKey<Boolean> {
    public static final uf a = null;

    static {
        a = new uf();
    }

    public uf() {
        Boolean r1 = Boolean.TRUE;
        super("live_backend_change_room_id_observe", "换房场景下backend接口用原来的roomid监听", r1, r1);
    }
}
