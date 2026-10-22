package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class u0 extends SettingKey<Boolean> {
    public static final u0 a = null;

    static {
        a = new u0();
    }

    public u0() {
        Boolean r1 = Boolean.FALSE;
        super("live_input_panel_enable_mention_list", "输入面板是否支持触发mention列表", r1, r1);
    }
}
