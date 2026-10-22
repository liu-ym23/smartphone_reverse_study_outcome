package ec2;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a0 extends SettingKey<Integer> {
    public static final a0 a = null;

    static {
        a = new a0();
    }

    public a0() {
        super("live_force_stop_audio2text_duration", "自动停止语音转文字的时长（单位s）", 300, 300);
    }
}
