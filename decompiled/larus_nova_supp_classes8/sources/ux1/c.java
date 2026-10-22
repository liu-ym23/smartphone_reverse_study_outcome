package ux1;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.business.IHostGameCP;
import com.bytedance.android.livehostapi.business.depend.gamecp.IGameCPTrackService;
import com.bytedance.android.livesdk.gamecp.business.GPAccessGeckoResultType;
import java.util.Iterator;
import java.util.List;
import jc1.k;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    public c() {
    }

    static {
    }

    public static final void a(uy5.c r5, List r6) {
        if (r6 != null) goto L5;
        return;
    L5:
        if ((!r6.isEmpty()) == true) goto L8;
        r6 = null;
    L8:
        if (r6 == null) goto L27;
        Iterator r7 = r6.iterator();
    L11:
        if (r7.hasNext() == false) goto L28;
        String r1 = (String) r7.next();
        r5.a(r1);     // Catch: Throwable -> L15
        b(GPAccessGeckoResultType.SUCCESS, r1);     // Catch: Throwable -> L15
        ALogger.i("GPGeckoHelper", "succeed to find GameCP gecko Resource, relative path: " + r1);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        b(GPAccessGeckoResultType.FAIL, r1);
        StringBuilder r3 = new StringBuilder("fail to find GameCP gecko Resource, resource, relative path: ");
        r3.append(r1);
        r3.append(", error msg: ");
        String r2 = th.getMessage();
        if (r2 != null) goto L19;
        r2 = "";
    L19:
        r3.append(r2);
        ALogger.e("GPGeckoHelper", r3.toString());
        goto L11
    L28:
        return;
    }

    public static void b(GPAccessGeckoResultType r3, String r4) {
        IHostGameCP r0 = k.f(IHostGameCP.class);
        if (r0 == null) goto L8;
        IGameCPTrackService r1 = r0.getTrackService();
        if (r1 == null) goto L9;
        r1.sendLog("dygame_tech_gecko_access_result", MapsKt.mapOf(new Pair[]{TuplesKt.to("gecko_access_result", r3.getValue()), TuplesKt.to("gecko_resource_path", r4)}));
        return;
    L9:
        return;
    }
}
