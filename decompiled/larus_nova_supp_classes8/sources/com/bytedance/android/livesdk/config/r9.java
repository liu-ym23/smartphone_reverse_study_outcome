package com.bytedance.android.livesdk.config;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class r9 extends SSettingKey<List<? extends String>> {
    public static final r9 a = null;

    static {
        a = new r9();
    }

    public r9() {
        super("ttlive_activity_enter_room_report_access_list", "上报schema进房授权list", new ArrayList(), new ArrayList());
    }
}
