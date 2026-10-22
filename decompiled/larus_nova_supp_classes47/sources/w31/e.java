package w31;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.monitor.LiveTracingMonitorKt;
import com.bytedance.android.live.revenue.common.v;
import com.bytedance.android.live.revenuelink.f;
import com.bytedance.android.live.revlink.impl.global.LinkFakeGlobalService;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e {
    public static final /* synthetic */ int b = 0;
    public final com.bytedance.android.live.revlink.impl.global.c a;

    public static final class a {
    }

    static {
    }

    public e(LinkFakeGlobalService r1) {
        this.a = r1;
    }

    public final void b(String r12, Map<String, Object> r13, int r14, String r15) {
        int r0 = v.a;
        v.e("PrecisionMatchMonitor", "event: " + r12 + " params=" + r13);
        JSONObject r8 = new JSONObject(new HashMap(r13));
        HashMap r7 = new HashMap();
        r7.put("android_event_key", r12);
        com.bytedance.android.live.revlink.impl.global.c r16 = this.a;
        if (r16 == null) goto L5;
        f r17 = r16.getRevenueLinkTraceMonitor();
    L6:
        f r2 = r17;
        if (r2 == null) goto L10;
        r2.Y(r12, LiveTracingMonitorKt.EventModule.PK, r14, r15, r7, r8, null, null);
        return;
    L10:
        return;
    L5:
        r17 = null;
        goto L6
    }

    public final void a(int r3, long r4, int r6, String r7, long r8, Throwable r10, String r12) {
        Intrinsics.checkNotNullParameter(r7, "flexActivityId");
        Intrinsics.checkNotNullParameter(r12, "reqSrc");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("response_type", Integer.valueOf(r3));
        r0.put("precision_match_id", Long.valueOf(r4));
        r0.put("source", Integer.valueOf(r6));
        r0.put("flex_activity_id", r7);
        r0.put("not_disturb", Long.valueOf(r8));
        r0.put("request_source", r12);
        boolean r5 = r10 instanceof ApiServerException;
        if (r5 == true) goto L5;
        Throwable r9 = null;
    L6:
        ApiServerException r13 = (ApiServerException) r9;
        if (r13 == null) goto L9;
        int r14 = r13.getErrorCode();
    L10:
        if (r5 == true) goto L12;
        r10 = null;
    L12:
        ApiServerException r15 = (ApiServerException) r10;
        if (r15 == null) goto L16;
        String r16 = r15.getErrorMsg();
        if (r16 == null) goto L16;
    L17:
        b("precision_match_reply", r0, r14, r16);
        return;
    L16:
        r16 = "";
        goto L17
    L9:
        r14 = 0;
        goto L10
    L5:
        r9 = r10;
        goto L6
    }
}
