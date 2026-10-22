package ec2;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class n1 extends SettingKey<Boolean> {
    public static final n1 a = null;

    static {
        a = new n1();
    }

    public n1() {
        Boolean r1 = Boolean.TRUE;
        super("live_vr_muliti_reopen", "VR多机位重新打开", r1, r1);
    }
}
