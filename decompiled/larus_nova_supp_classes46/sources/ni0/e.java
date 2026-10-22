package ni0;

import com.bytedance.android.livesdk.config.mz;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.GroupLiveGameConfig;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e {
    public static final Map<String, Long> c = null;
    public final long a;
    public long b;

    public static final class a {
    }

    static {
        c = new LinkedHashMap();
    }

    public e() {
        this.a = ((GroupLiveGameConfig) mz.a.getValue()).getInviteInterceptIntervalInMills();
    }
}
