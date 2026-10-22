package com.bytedance.android.livesdk.config;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class gj0 extends SSettingKey<List<? extends String>> {
    public static final gj0 a = null;

    static {
        a = new gj0();
    }

    public gj0() {
        super("live_prefetch_channels", new ArrayList());
    }
}
