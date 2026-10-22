package ec2;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k1 extends SSettingKey<Boolean> {
    public static final k1 a = null;

    static {
        a = new k1();
    }

    public k1() {
        Boolean r1 = Boolean.FALSE;
        super("live_useless_frame_task_optimize", "无效FrameTask优化", r1, r1);
    }
}
