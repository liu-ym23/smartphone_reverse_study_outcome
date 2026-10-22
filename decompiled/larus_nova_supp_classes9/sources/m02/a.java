package m02;

import com.bytedance.android.livesdk.revenue.log.LogCommon;
import cy0.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.m;
import mz0.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public static void a() {
        String r0 = com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).getCurrentUserId();
        HashMap r1 = new HashMap();
        r1.put("user_id", r0);
        n r2 = new n();
        Map r3 = r2.a;
        Intrinsics.checkNotNullParameter(r3, "map");
        Intrinsics.checkNotNullParameter(r1, "map");
        r3.putAll(r1);
        m r4 = new m();
        r4.b(LogCommon.ROOM);
        List r5 = r2.b;
        ArrayList r6 = (ArrayList) r5;
        r6.addAll(r4.a);
        cy0.e.a.getClass();
        j r7 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r8 = com.bytedance.android.scope.m.b(r7).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r8);
        ((f80.a) r8).w3("forbid_self_reward", r2.a, r2.b);
    }

    static {
    }
}
