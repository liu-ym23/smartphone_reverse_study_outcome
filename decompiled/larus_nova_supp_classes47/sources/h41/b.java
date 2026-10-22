package h41;

import com.bytedance.android.live.core.network.CustomApiServerException;
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
public final class b {

    public static final class a {
    }

    static {
    }

    public static void a(Throwable r4) {
        if ((r4 instanceof CustomApiServerException) == false) goto L25;
        int r5 = ((CustomApiServerException) r4).getErrorCode();
        if (r5 != 4017139) goto L7;
    L13:
        LinkedHashMap r0 = new LinkedHashMap();
        String r1 = "";
        switch(r5) {
            case 4017139: goto L17;
            case 4017140: goto L16;
            case 4017141: goto L16;
            case 4017142: goto L17;
            default: goto L15;
        };
    L15:
        String r2 = "";
    L18:
        r0.put("pk_type", r2);
        switch(r5) {
            case 4017139: goto L22;
            case 4017140: goto L21;
            case 4017141: goto L22;
            case 4017142: goto L21;
            default: goto L23;
        };
    L21:
        r1 = "recipient_limit";
        goto L23
    L22:
        r1 = "promoter_limit";
    L23:
        r0.put("block_reason", r1);
        n r6 = new n();
        Map<String, String> r3 = r6.a;
        Intrinsics.checkNotNullParameter(r3, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r3.putAll(r0);
        m r7 = new m();
        r7.b(LogCommon.ROOM);
        r7.b(LogCommon.PAGE_SOURCE_LOG);
        List<Object> r8 = r6.b;
        ArrayList r9 = (ArrayList) r8;
        r9.addAll(r7.a);
        cy0.e.a.getClass();
        j r10 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r12 = com.bytedance.android.scope.m.b(r10).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r12);
        ((i) ((f80.a) r12)).w3("livesdk_pk_promote_fail_show", r6.a, r6.b);
        return;
    L16:
        r2 = "multi";
        goto L18
    L17:
        r2 = "pair";
        goto L18
    L7:
        if (r5 == 4017142) goto L13;
        if (r5 == 4017141) goto L13;
        if (r5 == 4017140) goto L13;
        return;
    }
}
