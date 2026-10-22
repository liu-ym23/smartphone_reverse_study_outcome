package mu0;

import android.os.Handler;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.monitor.trace.TraceMonitor;
import com.bytedance.android.live.core.monitor.trace.e;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.profit.format.voicechat.trace.VoiceChatTraceStep;
import com.bytedance.android.live.revenue.core.util.f;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import l01.d;
import nu0.l;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c {
    public static String a;
    public static final Map<String, String> b = null;

    public c() {
    }

    static {
        a = "";
        b = new LinkedHashMap();
    }

    public static void a(JSONObject r2, Map r3) {
        Iterator r4 = ((LinkedHashMap) r3).entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        Map.Entry r0 = (Map.Entry) r4.next();
        r2.put((String) r0.getKey(), r0.getValue());
        goto L4
    }

    public static void b(VoiceChatTraceStep r4, JSONObject r5, JSONObject r6, int r7) {
        Intrinsics.checkNotNullParameter(r4, "step");
        Intrinsics.checkNotNullParameter(r5, "category");
        Intrinsics.checkNotNullParameter(r6, "extra");
        if (((Boolean) l.g.getValue(null, l.a[5])).booleanValue() == true) goto L5;
        return;
    L5:
        Map<String, String> r0 = b;
        a(r5, r0);
        a(r6, r0);
        if (r7 == (-1)) goto L14;
        if (r7 != 0) goto L9;
        String r8 = r4.getStep();
    L15:
        String r9 = a;
        int r1 = e.m;
        e.a r2 = e.b.a("ttlive_format_voice_chat", LiveTracingMonitor.EventModule.VOICE_CHAT.getName());
        r2.a = r9;
        r2.c = "webcast_client_revenue_format";
        r2.g = ((d) f.a(d.class)).getCurrentUserId();
        r2.f = (String) ((LinkedHashMap) r0).get("format_owner_id");
        r2.d = r8;
        TraceMonitor.i(r2.a(), r5, null, r6);
        return;
    L9:
        if (r7 != 1) goto L12;
        r8 = r4.getStep() + "_success";
        goto L15
    L12:
        throw new Error("status: " + r7 + " not supported!");
    L14:
        r8 = r4.getStep() + "_failed";
        goto L15
    }

    public static void c(VoiceChatTraceStep r1, JSONObject r2, JSONObject r3, int r4, int r5) {
        if ((r5 & 2) == 0) goto L6;
        Handler r6 = UtilityKotlinExtentionsKt.a;
        r2 = new JSONObject();
    L6:
        if ((r5 & 4) == 0) goto L9;
        Handler r7 = UtilityKotlinExtentionsKt.a;
        r3 = new JSONObject();
    L9:
        if ((r5 & 8) == 0) goto L11;
        r4 = 0;
    L11:
        b(r1, r2, r3, r4);
    }
}
