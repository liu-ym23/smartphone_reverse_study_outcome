package j40;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdkapi.model.LiveShuffleSequenceConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class t2 extends SettingKey<LiveShuffleSequenceConfig> {
    public static final t2 a = null;

    static {
        a = new t2();
    }

    public t2() {
        super("live_shuffle_sequence_config", "混排实时特征序列配置", new LiveShuffleSequenceConfig(), new LiveShuffleSequenceConfig());
    }
}
