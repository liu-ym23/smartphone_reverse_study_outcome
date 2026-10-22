package hv0;

import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import cy0.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import l01.d;
import mz0.i;
import mz0.m;
import mz0.n;
import yz0.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    public static HashMap a() {
        HashMap r0 = new HashMap();
        k r1 = (k) f.d(j.C0.a(), k.class);
        r0.put("user_id", ((d) f.a(d.class)).getCurrentUserId());
        if (r1 == null) goto L8;
        IRoom r2 = r1.getRoom();
        if (r2 == null) goto L8;
        String r3 = String.valueOf(r2.getId());
        if (r3 == null) goto L8;
    L9:
        r0.put("room_id", r3);
        return r0;
    L8:
        r3 = DataType.FALSE;
        goto L9
    }

    static {
    }

    public static void b(int r2, String r3, int r4) {
        HashMap r0 = a();
        r0.put("path", r3);
        r0.put("load_state", String.valueOf(r2));
        r0.put("queue_size", String.valueOf(r4));
        n r5 = new n();
        Map<String, String> r6 = r5.a;
        Intrinsics.checkNotNullParameter(r6, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r6.putAll(r0);
        m r7 = new m();
        r7.b(LogCommon.ROOM);
        r7.b(LogCommon.PAGE_SOURCE_LOG);
        List<Object> r8 = r5.b;
        ArrayList r9 = (ArrayList) r8;
        r9.addAll(r7.a);
        e.a.getClass();
        cy0.j r10 = e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r12 = com.bytedance.android.scope.m.b(r10).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r12);
        ((i) ((f80.a) r12)).w3("livesdk_task_panel_load_state", r5.a, r5.b);
    }
}
