package com.bytedance.android.livesdk.config;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class qp0 extends SSettingKey<List<? extends String>> {
    public static final qp0 a = null;

    static {
        a = new qp0();
    }

    public qp0() {
        super("live_safe_dispatch_messages", "消息分发安全开关", new ArrayList(), new ArrayList());
    }
}
