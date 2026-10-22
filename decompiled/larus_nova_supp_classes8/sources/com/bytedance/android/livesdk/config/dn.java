package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class dn extends SSettingKey<Boolean> {
    public static final dn a = null;

    static {
        a = new dn();
    }

    public dn() {
        Boolean r4 = Boolean.FALSE;
        super("live_detail_pre_enter_room", "混滑场景预请求", r4, r4, new String[]{"true:使用预请求", "false:不使用预请求"});
    }
}
