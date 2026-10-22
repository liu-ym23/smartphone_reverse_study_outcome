package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdkapi.model.MultiLinkFirstFrameOptConfigV2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class u2 extends SSettingKey<MultiLinkFirstFrameOptConfigV2> {
    public static final u2 a = null;

    static {
        a = new u2();
    }

    public u2() {
        super("multi_link_first_frame_opt_config_v2", "多人场景进房首帧耗时优化Config", new MultiLinkFirstFrameOptConfigV2(), new MultiLinkFirstFrameOptConfigV2());
    }
}
