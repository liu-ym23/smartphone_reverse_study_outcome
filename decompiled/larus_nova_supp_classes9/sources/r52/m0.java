package r52;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m0 extends SSettingKey<Boolean> {
    public static final m0 a = null;

    static {
        a = new m0();
    }

    public m0() {
        Boolean r1 = Boolean.TRUE;
        super("live_first_show_backtrack_traceable", "首播回溯消息使用/webcast/im/fetch/traceable/", r1, r1);
    }
}
