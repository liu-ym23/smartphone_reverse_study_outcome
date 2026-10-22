package ff0;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceBusiness;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceEvent;
import com.bytedance.android.live.liveinteract.utils.p;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h implements p {
    public static final h a = null;

    public h() {
    }

    static {
        a = new h();
    }

    public final void a(boolean r9, String r10, int r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "event");
        Intrinsics.checkNotNullParameter(r12, "statusMsg");
        ALogger.i("LinkMicXplayBasicTraceMonitor", "trace, isAnchor: " + r9 + ", event: " + r10 + ", statusCode: " + r11 + ", statusMsg: " + r12);
        JSONObject r6 = new JSONObject();
        int r13 = rd0.a.a;
        rd0.a.b(MultiTraceData$TraceBusiness.InteractXplay, MultiTraceData$TraceEvent.InteractXplay, r10, r11, r12, r6, 64);
    }
}
