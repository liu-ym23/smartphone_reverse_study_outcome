package qi0;

import com.bytedance.android.live.api.exceptions.local.ResponseNoDataException;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceBusiness;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceEvent;
import com.bytedance.android.live.liveinteract.utils.n;
import com.bytedance.android.live.network.response.BaseResponse;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d implements n {
    public static final d a = null;

    public d() {
    }

    static {
        a = new d();
    }

    public static String b(Throwable r1) {
        if ((r1 instanceof CustomApiServerException) == false) goto L6;
        return ((CustomApiServerException) r1).getXTtLogId();
    L6:
        if ((r1 instanceof ResponseNoDataException) == false) goto L11;
        BaseResponse r2 = ((ResponseNoDataException) r1).getResponse();
        if (r2 == null) goto L11;
        String r3 = r2.logId;
        if (r3 == null) goto L11;
        return r3;
    L11:
        return "";
    }

    @Override // com.bytedance.android.live.liveinteract.utils.n
    public final void a(boolean r10, String r11, int r12, String r13) {
        Intrinsics.checkNotNullParameter(r11, "event");
        Intrinsics.checkNotNullParameter(r13, "statusMsg");
        ALogger.i("LinkMicGameTraceMonitor", "trace, isAnchor: " + r10 + ", event: " + r11 + ", statusCode: " + r12 + ", statusMsg: " + r13);
        JSONObject r7 = new JSONObject();
        int r0 = rd0.a.a;
        MultiTraceData$TraceBusiness r2 = MultiTraceData$TraceBusiness.MultiRevenue;
        if (r10 == false) goto L5;
        MultiTraceData$TraceEvent r14 = MultiTraceData$TraceEvent.AnchorCloudGame;
    L6:
        rd0.a.b(r2, r14, r11, r12, r13, r7, 64);
        return;
    L5:
        r14 = MultiTraceData$TraceEvent.GuestCloudGame;
        goto L6
    }
}
