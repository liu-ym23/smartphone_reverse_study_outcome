package ec2;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m extends SettingKey<Boolean> {
    public static final m a = null;

    static {
        a = new m();
    }

    public m() {
        Boolean r1 = Boolean.FALSE;
        super("live_carnival_message_mock_support", "收到CarnivalMessage时不校验seqId", r1, r1);
    }
}
