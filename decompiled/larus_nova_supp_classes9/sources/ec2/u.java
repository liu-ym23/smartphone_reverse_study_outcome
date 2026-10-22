package ec2;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class u extends SettingKey<Boolean> {
    public static final u a = null;

    static {
        a = new u();
    }

    public u() {
        Boolean r1 = Boolean.TRUE;
        super("live_danmaku_use_outer_frame_task", "弹幕使用独立的FrameTask", r1, r1);
    }
}
