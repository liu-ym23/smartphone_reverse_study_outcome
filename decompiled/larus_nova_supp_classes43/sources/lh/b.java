package lh;

import com.bytedance.ai.event.MessageIndication;
import com.bytedance.android.ec.core.monitor.process.ProcessDomain;
import com.bytedance.android.ec.sdk.ECSdk;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    public b() {
    }

    static {
    }

    public static void a(ProcessDomain r1) {
        if (a.a[r1.ordinal()] != 1) goto L6;
        return;
    L6:
        throw new NoWhenBranchMatchedException();
    }

    public static void b(ProcessDomain r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "processDomain");
        Intrinsics.checkNotNullParameter("开播页", "pageName");
        Intrinsics.checkNotNullParameter(r11, "actionName");
        int r0 = ECSdk.a;
        pi.b r1 = (pi.b) ECSdk.a(pi.b.class);
        if (r1 == null) goto L6;
        a(r10);
        JSONObject r13 = new JSONObject();
        r13.put("event_type", "rate");
        r13.put(com.bytedance.android.ec.core.event.a.KEY_PAGE_NAME, "开播页");
        r13.put("action_name", r11);
        r13.put("action_code", null);
        r13.put(com.bytedance.android.ec.core.event.a.KEY_MSG, r12);
        r13.put("rate_type", MessageIndication.STATUS_FAILED);
        Unit r14 = Unit.INSTANCE;
        r1.monitorEvent("ec_full_live_process_monitor", r13, null, null);
        return;
    }

    public static void c(ProcessDomain r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "processDomain");
        Intrinsics.checkNotNullParameter(r11, "pageName");
        Intrinsics.checkNotNullParameter(r12, "actionName");
        int r0 = ECSdk.a;
        pi.b r1 = (pi.b) ECSdk.a(pi.b.class);
        if (r1 == null) goto L6;
        a(r10);
        JSONObject r13 = new JSONObject();
        r13.put("event_type", "rate");
        r13.put(com.bytedance.android.ec.core.event.a.KEY_PAGE_NAME, r11);
        r13.put("action_name", r12);
        r13.put("rate_type", "start");
        Unit r14 = Unit.INSTANCE;
        r1.monitorEvent("ec_full_live_process_monitor", r13, null, null);
        return;
    }

    public static void d(ProcessDomain r10, String r11, long r12, JSONObject r13, int r14) {
        if ((r14 & 32) == 0) goto L5;
        r13 = null;
    L5:
        Intrinsics.checkNotNullParameter(r10, "processDomain");
        Intrinsics.checkNotNullParameter("开播页", "pageName");
        Intrinsics.checkNotNullParameter(r11, "actionName");
        int r15 = ECSdk.a;
        pi.b r16 = (pi.b) ECSdk.a(pi.b.class);
        if (r16 == null) goto L9;
        a(r10);
        JSONObject r17 = new JSONObject();
        r17.put("event_type", "rate");
        r17.put(com.bytedance.android.ec.core.event.a.KEY_PAGE_NAME, "开播页");
        r17.put("action_name", r11);
        r17.put("rate_type", "success");
        Unit r18 = Unit.INSTANCE;
        JSONObject r19 = new JSONObject();
        r19.put(com.bytedance.android.ec.core.event.a.KEY_DURATION, r12);
        r16.monitorEvent("ec_full_live_process_monitor", r17, r19, r13);
        return;
    }
}
