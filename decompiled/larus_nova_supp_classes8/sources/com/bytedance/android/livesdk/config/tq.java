package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class tq extends SSettingKey<Boolean> {
    public static final tq a = null;

    static {
        a = new tq();
    }

    public tq() {
        Boolean r1 = Boolean.TRUE;
        super("live_enable_annie_fragment_proxy_anniex", "AnnieFragmentProxy生成schema时是否处理AnnieX参数", r1, r1);
    }
}
