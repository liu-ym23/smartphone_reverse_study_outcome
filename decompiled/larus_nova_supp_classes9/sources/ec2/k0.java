package ec2;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k0 extends SettingKey<Long> {
    public static final k0 a = null;

    static {
        a = new k0();
    }

    public k0() {
        super("ttlive_input_word_association_interval", "直播间评论联想延迟触发时间间隔", 300L, 300L);
    }
}
