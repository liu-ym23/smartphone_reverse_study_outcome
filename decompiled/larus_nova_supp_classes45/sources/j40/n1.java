package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class n1 extends SettingKey<Boolean> {
    public static final n1 a = null;

    static {
        a = new n1();
    }

    public n1() {
        Boolean r1 = Boolean.TRUE;
        super("live_multi_fan_ticket_optimize", "多人麦位计值Icon统一实验", r1, r1);
    }
}
