package rs0;

import com.bytedance.android.live.core.setting.SettingKey;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class u extends SettingKey<Map<String, ? extends String>> {
    public static final u a = null;

    static {
        a = new u();
    }

    public u() {
        super("live_ktv_sing_record_lynx", "ktv演唱沉淀lynx配置", new LinkedHashMap(), new LinkedHashMap());
    }
}
