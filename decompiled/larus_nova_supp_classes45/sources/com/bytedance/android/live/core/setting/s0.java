package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class s0 extends SSettingKey<Boolean> {
    public static final s0 a = null;

    static {
        a = new s0();
    }

    public s0() {
        Boolean r1 = Boolean.TRUE;
        super("live_dynamic_strategy_redpack_term_enable", "是否加载电商红包临态策略", r1, r1);
    }
}
