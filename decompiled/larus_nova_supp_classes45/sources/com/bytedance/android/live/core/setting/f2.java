package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f2 extends SSettingKey<Boolean> {
    public static final f2 a = null;

    static {
        a = new f2();
    }

    public f2() {
        Boolean r1 = Boolean.TRUE;
        super("live_linkmic_online_float_window_shopping_enter_room_bugfix", "修复商城店铺讲解卡进房多人连线小窗关闭但是麦克风权限未释放问题", r1, r1);
    }
}
