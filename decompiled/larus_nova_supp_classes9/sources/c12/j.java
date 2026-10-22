package c12;

import com.bytedance.android.livesdk.gift.platform.core.d0;
import com.bytedance.android.livesdk.revenue.host.RevHostPluginType;
import com.bytedance.android.livesdk.revenue.monitor.EventModule;
import com.bytedance.android.livesdk.revenue.monitor.EventType;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j {
    public static boolean b() {
        return com.bytedance.android.live.revenue.core.util.e.a(dr2.h.class).r8(RevHostPluginType.LivePcdnDouyin).b();
    }

    public static void a(String r10, boolean r11) {
        boolean r0 = d0.a;
        Intrinsics.checkNotNullParameter(r10, "name");
        JSONObject r5 = new JSONObject();
        JSONObject r6 = new JSONObject();
        JSONObject r7 = new JSONObject();
        Intrinsics.checkNotNullParameter(r7, "extra");
        Intrinsics.checkNotNullParameter(r6, "metric");
        EventModule r1 = EventModule.PCDN;
        Intrinsics.checkNotNullParameter(r1, "eventModule");
        String r3 = r1.getValue();
        EventType r2 = EventType.BUSSINESS_API_CALL;
        Intrinsics.checkNotNullParameter(r2, "eventType");
        String r4 = r2.getValue();
        Intrinsics.checkNotNullParameter(r5, "map");
        Intrinsics.checkNotNullParameter("name", "key");
        Intrinsics.checkNotNullParameter(r10, "value");
        r5.put("name", r10);
        Intrinsics.checkNotNullParameter(r6, "map");
        Boolean r13 = Boolean.valueOf(r11);
        Intrinsics.checkNotNullParameter("result", "key");
        Intrinsics.checkNotNullParameter(r13, "value");
        r6.put("result", r13);
        cy0.e.a.getClass();
        cy0.j r14 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r15 = com.bytedance.android.scope.m.b(r14).b(n97.a.class);
        Intrinsics.checkNotNull(r15);
        ((com.bytedance.live.kmp.core.c) r15).g("ttlive_pcdn_load", r3, r4, r5, r6, r7);
    }
}
