package com.bytedance.android.livesdk.config;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class vo0 extends SSettingKey<List<? extends String>> {
    public static final vo0 a = null;

    static {
        a = new vo0();
    }

    public vo0() {
        super("live_notification_fix_list", "直播间后台通知优化适配机型", new ArrayList(), new ArrayList());
    }
}
