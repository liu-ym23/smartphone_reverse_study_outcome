package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class w extends SettingKey<Boolean> {
    public static final w a = null;

    static {
        a = new w();
    }

    public w() {
        Boolean r1 = Boolean.FALSE;
        super("live_mark_highlight_enable", "是否可以标记高光", r1, r1);
    }
}
