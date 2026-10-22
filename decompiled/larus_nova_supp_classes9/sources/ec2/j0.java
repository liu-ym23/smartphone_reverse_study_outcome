package ec2;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j0 extends SettingKey<Boolean> {
    public static final j0 a = null;

    static {
        a = new j0();
    }

    public j0() {
        Boolean r1 = Boolean.TRUE;
        super("live_input_panel_remove_repeat_live_event", "输入面板移除多余的liveEvent回调", r1, r1);
    }
}
