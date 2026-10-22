package ec2;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class u1 extends SettingKey<Integer> {
    public static final u1 a = null;

    static {
        a = new u1();
    }

    public u1() {
        super("vs_message_fetch_switch_diff_time", " VS 首播评论消息 直播和回溯 切换临界值控制；当前时间点和最新时间点 diff 时长", 10, 10);
    }
}
