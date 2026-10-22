package b21;

import com.bytedance.android.live.core.monitor.LiveTracingMonitorKt;
import com.bytedance.android.live.revenuelink.f;
import com.bytedance.android.live.revlink.impl.global.LinkFakeGlobalService;
import com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d {
    public final com.bytedance.android.live.revlink.impl.global.c a;

    public static final class a {
    }

    static {
    }

    public d(LinkFakeGlobalService r1) {
        this.a = r1;
    }

    public final void b(String r8) {
        Intrinsics.checkNotNullParameter(r8, "tag");
        LinkedHashMap r3 = new LinkedHashMap();
        r3.put("tag", r8);
        e(this, "lynx_init_when_destroyed", r3, r8, null, 20);
    }

    public static void a(com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r2, Map r3) {
        IBaseBattleSetting r4 = r2.a;
        if (r4 == null) goto L6;
        r3.put("start_time_ms", Long.valueOf(r4.getStartTimeMs()));
        r3.put("pk_duration", Long.valueOf(r4.getDuration()));
        r3.put("punish_start_time_ms", Long.valueOf(r4.getPunishStartTimeMs()));
        r3.put("punish_duration", Long.valueOf(r4.getPunishDuration()));
        r3.put("punish_optimize_on", Boolean.valueOf(r4.getPunishOptimizeOn()));
        r3.put("cur_server_time", Long.valueOf(com.bytedance.live.kmp.util.e.b()));
        return;
    }

    public final void c(int r7, boolean r8) {
        LinkedHashMap r2 = new LinkedHashMap();
        if (r8 == false) goto L5;
        int r3 = 1;
    L6:
        if (r8 == false) goto L8;
        String r9 = "pk_stuck";
    L9:
        d("pk_time_stuck", r2, r3, r9, Integer.valueOf(r7));
        return;
    L8:
        r9 = "penal_stuck";
        goto L9
    L5:
        r3 = 2;
        goto L6
    }

    public final void d(String r10, Map<String, Object> r12, int r13, String r14, Integer r15) {
        JSONObject r6 = new JSONObject(new HashMap(r12));
        HashMap r5 = new HashMap();
        r5.put("android_event_key", r10);
        com.bytedance.android.live.revlink.impl.global.c r16 = this.a;
        if (r16 == null) goto L5;
        f r17 = r16.getRevenueLinkTraceMonitor();
    L6:
        f r0 = r17;
        if (r0 == null) goto L16;
        if (r15 != null) goto L11;
    L13:
        LiveTracingMonitorKt.EventModule r18 = LiveTracingMonitorKt.EventModule.MULTI_LINKER;
    L14:
        r0.Y(r10, r18, r13, r14, r5, r6, null, null);
        return;
    L11:
        if (r15.intValue() != 1) goto L13;
        r18 = LiveTracingMonitorKt.EventModule.PK;
        goto L14
    L16:
        return;
    L5:
        r17 = null;
        goto L6
    }

    public static /* synthetic */ void e(d r6, String r7, Map r8, String r9, Integer r10, int r12) {
        if ((r12 & 8) == 0) goto L5;
        r9 = null;
    L5:
        String r4 = r9;
        if ((r12 & 16) == 0) goto L8;
        r10 = 1;
    L8:
        r6.d(r7, r8, 0, r4, r10);
    }
}
