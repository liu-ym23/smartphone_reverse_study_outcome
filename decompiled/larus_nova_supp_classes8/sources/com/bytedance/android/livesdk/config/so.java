package com.bytedance.android.livesdk.config;

import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class so extends SSettingKey<List<? extends String>> {
    public static final so a = null;

    static {
        a = new so();
    }

    public so() {
        List<String> r1 = d81.a;
        super("live_dispose_room_context_on_end_room_scenes", "在特定场景下endRoom时补充调用disposeDataContext", r1, r1);
    }
}
