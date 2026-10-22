package rs0;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class p0 extends SettingKey<Boolean> {
    public static final p0 a = null;

    static {
        a = new p0();
    }

    public p0() {
        Boolean r1 = Boolean.TRUE;
        super("live_profile_text_desc_com_call_ptb_after_update", "ProfileTextDescComponent组件更新后是否调用processTalkBack", r1, r1);
    }
}
