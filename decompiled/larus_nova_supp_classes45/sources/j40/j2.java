package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class j2 extends SettingKey<Boolean> {
    public static final j2 a = null;

    static {
        a = new j2();
    }

    public j2() {
        Boolean r1 = Boolean.TRUE;
        super("live_replay_clear_back_stack", "跳转回放清除直播套娃返回逻辑", r1, r1);
    }
}
