package b12;

import com.bytedance.android.livesdk.gift.platform.core.utils.z;
import com.bytedance.android.livesdk.revenue.monitor.EventModule;
import com.bytedance.android.scope.m;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.live.kmp.core.c;
import cy0.e;
import cy0.j;
import j01.d;
import java.util.Iterator;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void b(String r8, JSONObject r9, int r10) {
        JSONObject r4 = new JSONObject();
        JSONObject r5 = new JSONObject();
        JSONObject r6 = new JSONObject();
        Intrinsics.checkNotNullParameter(r6, "extra");
        Intrinsics.checkNotNullParameter(r5, "metric");
        EventModule r0 = EventModule.LIVE_GIFT;
        Intrinsics.checkNotNullParameter(r0, "eventModule");
        String r2 = r0.getValue();
        r5.put("status", String.valueOf(r10));
        Intrinsics.checkNotNullParameter(r6, "map");
        Iterator<String> r11 = r9.keys();
    L4:
        if (r11.hasNext() == false) goto L6;
        String r1 = r11.next();
        Object r3 = r9.get(r1);
        Intrinsics.checkNotNullParameter(r1, "key");
        Intrinsics.checkNotNullParameter(r3, "value");
        r6.put(r1, r3);
        goto L4
    L6:
        e.a.getClass();
        j r13 = e.a.a;
        m.e.getClass();
        Object r14 = m.b(r13).b(n97.a.class);
        Intrinsics.checkNotNull(r14);
        ((c) r14).g(r8, r2, "bussiness_api_call", r4, r5, r6);
    }

    @JvmStatic
    public static final void a(Long r5, Long r6, Integer r7, String r8) {
        JSONObject r0 = new JSONObject();
        long r1 = 0;
        if (r5 == null) goto L5;
        long r3 = r5.longValue();
    L6:
        d.b(r0, "asset_id", Long.valueOf(r3));
        if (r6 == null) goto L9;
        r1 = r6.longValue();
    L9:
        d.b(r0, "download_assets_from", Long.valueOf(r1));
        if (r7 == null) goto L12;
        int r9 = r7.intValue();
    L13:
        d.b(r0, "error_code", Integer.valueOf(r9));
        if (r8 != null) goto L16;
        r8 = BuildConfig.FLAVOR;
    L16:
        d.b(r0, "error_msg", r8);
        Intrinsics.checkNotNullParameter("ttlive_download_befview_resource_status", "name");
        b(z.a("ttlive_download_befview_resource_status"), r0, 1);
        Intrinsics.checkNotNullParameter("ttlive_download_befview_resource_status", "name");
        b(z.b("ttlive_download_befview_resource_status"), r0, 1);
        return;
    L12:
        r9 = 0;
        goto L13
    L5:
        r3 = 0;
        goto L6
    }
}
