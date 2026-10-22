package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.RoomFlowOpt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ko0 extends SSettingKey<RoomFlowOpt> {
    public static final ko0 a = null;

    static {
        a = new ko0();
    }

    public ko0() {
        super("live_enter_room_flow_opt", "优化roomflow框架耗时", new RoomFlowOpt(), new RoomFlowOpt(), true);
    }
}
