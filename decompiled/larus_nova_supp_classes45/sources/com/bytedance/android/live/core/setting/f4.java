package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f4 extends SSettingKey<Boolean> {
    public static final f4 a = null;

    static {
        a = new f4();
    }

    public f4() {
        Boolean r1 = Boolean.TRUE;
        super("live_request_song_anim_task_executor_opt", "你点我唱动画任务内存泄漏优化", r1, r1);
    }
}
