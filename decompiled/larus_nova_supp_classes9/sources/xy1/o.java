package xy1;

import com.bytedance.android.livesdk.revenue.log.LogCommon;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class o {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final void a(long r4, int r6, String r7) {
        Intrinsics.checkNotNullParameter("money_change", "alertType");
        Intrinsics.checkNotNullParameter("guide", "pageFrom");
        Intrinsics.checkNotNullParameter(r7, "clickType");
        HashMap r0 = new HashMap();
        r0.put("gift_id", String.valueOf(r4));
        r0.put("money", String.valueOf(r6));
        r0.put("alert_click", "money_change");
        r0.put("page_from", "guide");
        r0.put("click_type", r7);
        mz0.n r5 = new mz0.n();
        Map r8 = r5.a;
        Intrinsics.checkNotNullParameter(r8, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r8.putAll(r0);
        mz0.m r9 = new mz0.m();
        r9.b(LogCommon.ROOM);
        r9.b(LogCommon.PAGE_SOURCE_LOG);
        List r10 = r5.b;
        ArrayList r11 = (ArrayList) r10;
        r11.addAll(r9.a);
        cy0.e.a.getClass();
        cy0.j r13 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r14 = com.bytedance.android.scope.m.b(r13).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r14);
        ((f80.a) r14).w3("livesdk_gift_send_alert_click", r5.a, r5.b);
    }
}
