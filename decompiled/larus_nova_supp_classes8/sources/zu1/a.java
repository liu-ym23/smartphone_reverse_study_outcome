package zu1;

import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.livesdkapi.enterparam.ILiveCommonMonitorService;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements ILiveCommonMonitorService {
    public static final a a = null;

    public a() {
    }

    static {
        a = new a();
    }

    public final void monitorEvent(String r2, JSONObject r3, JSONObject r4, JSONObject r5) {
        Intrinsics.checkNotNullParameter(r2, "serviceName");
        LiveTracingMonitor.i(r2, r3, r4, r5);
    }
}
