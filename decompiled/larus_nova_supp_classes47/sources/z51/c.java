package z51;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.room.api.record.LiveScreenRecordGuideConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c extends SettingKey<LiveScreenRecordGuideConfig> {
    public static final c a = null;

    static {
        a = new c();
    }

    public c() {
        super("live_audience_screen_record_guide_config", "观众侧录屏引导发布", new LiveScreenRecordGuideConfig(), new LiveScreenRecordGuideConfig());
    }
}
