package h41;

import com.bytedance.android.live.revlink.impl.global.LinkFakeGlobalService;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import cy0.j;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.i;
import mz0.m;
import mz0.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public final com.bytedance.android.live.revlink.impl.global.c a;

    public a(LinkFakeGlobalService r1) {
        this.a = r1;
    }

    public static void a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "status");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("interact_function", "pk");
        r0.put("anchor_status", r3);
        n r4 = new n();
        Map<String, String> r1 = r4.a;
        Intrinsics.checkNotNullParameter(r1, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r1.putAll(r0);
        m r2 = new m();
        r2.b(LogCommon.PAGE_SOURCE_LOG);
        r2.b(LogCommon.ROOM);
        List<Object> r5 = r4.b;
        ArrayList r6 = (ArrayList) r5;
        r6.addAll(r2.a);
        cy0.e.a.getClass();
        j r7 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r8 = com.bytedance.android.scope.m.b(r7).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r8);
        ((i) ((f80.a) r8)).w3("livesdk_anchor_suspend_reminder_show", r4.a, r4.b);
    }
}
