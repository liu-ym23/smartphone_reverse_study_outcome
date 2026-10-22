package b21;

import c21.h;
import c21.i;
import c21.j;
import c21.k;
import com.bytedance.android.live.core.monitor.LiveTracingMonitorKt;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenuelink.f;
import com.bytedance.android.live.revlink.impl.global.LinkFakeGlobalService;
import com.bytedance.android.live.revlink.impl.monitor.LiveFullLinkPKMonitor;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b {
    public final com.bytedance.android.live.revlink.impl.global.c a;

    public static final class a {
    }

    static {
    }

    public final LiveFullLinkPKMonitor d() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getLiveFullLinkPKMonitor();
    }

    public b(LinkFakeGlobalService r1) {
        this.a = r1;
    }

    public static void a(HashMap r3, i r4) {
        h r0 = r4.a;
        r3.put("invite_type", String.valueOf(r0.a));
        r3.put("game_app_id", r0.c);
        r3.put("biz_type", r0.b.toString());
        r3.put("invite_isOnceMore", String.valueOf(r0.f));
        if (r0.e == false) goto L5;
        String r1 = DataType.TRUE;
    L6:
        r3.put("limited_by_stream_mixtype", r1);
        r3.put("end_reason", r4.b);
        return;
    L5:
        r1 = DataType.FALSE;
        goto L6
    }

    public static void b(HashMap r3, j r4) {
        h r0 = r4.a;
        r3.put("invite_type", String.valueOf(r0.a));
        r3.put("game_app_id", r0.c);
        r3.put("biz_type", r0.b.toString());
        r3.put("invite_isOnceMore", String.valueOf(r0.f));
        if (r0.e == false) goto L5;
        String r1 = DataType.TRUE;
    L6:
        r3.put("limited_by_stream_mixtype", r1);
        r3.put("name", r4.b);
        return;
    L5:
        r1 = DataType.FALSE;
        goto L6
    }

    public static void c(HashMap r3, k r4) {
        h r0 = r4.a;
        r3.put("invite_type", String.valueOf(r0.a));
        r3.put("game_app_id", r0.c);
        r3.put("biz_type", r0.b.toString());
        r3.put("invite_isOnceMore", String.valueOf(r0.f));
        if (r0.e == false) goto L5;
        String r1 = DataType.TRUE;
    L6:
        r3.put("limited_by_stream_mixtype", r1);
        r3.put("name", r4.b);
        return;
    L5:
        r1 = DataType.FALSE;
        goto L6
    }

    public static void e(b r9, String r10, Map r12) {
        Integer r1 = 1;
        JSONObject r6 = new JSONObject(new HashMap(r12));
        HashMap r5 = new HashMap();
        r5.put("android_event_key", r10);
        com.bytedance.android.live.revlink.impl.global.c r13 = r9.a;
        if (r13 == null) goto L5;
        f r14 = r13.getRevenueLinkTraceMonitor();
    L6:
        if (r14 == null) goto L15;
        if (r1 != null) goto L10;
    L12:
        LiveTracingMonitorKt.EventModule r15 = LiveTracingMonitorKt.EventModule.MULTI_LINKER;
    L13:
        f r0 = r14;
        r0.Y(r10, r15, 0, null, r5, r6, null, null);
        return;
    L10:
        if (r1.intValue() != 1) goto L12;
        r15 = LiveTracingMonitorKt.EventModule.PK;
        goto L13
    L15:
        return;
    L5:
        r14 = null;
        goto L6
    }
}
