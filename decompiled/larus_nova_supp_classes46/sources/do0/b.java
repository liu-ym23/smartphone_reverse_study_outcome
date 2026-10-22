package do0;

import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(int r2, Object r3) {
        HashMap r0 = new HashMap();
        r0.put("code", String.valueOf(r2));
        r0.put("data", String.valueOf(r3));
        LiveSlardarMonitor.monitorStatus("ttlive_service_ds_limit", 0, r0);
    }
}
