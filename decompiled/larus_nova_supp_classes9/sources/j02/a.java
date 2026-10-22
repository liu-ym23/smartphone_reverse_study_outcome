package j02;

import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.scope.m;
import cy0.e;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.i;
import mz0.n;
import yz0.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(long r4, int r6, int r7, long r8, boolean r10, long r11, int r13, boolean r14, boolean r15, boolean r16, long r17, int r19) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("effect_id", String.valueOf(r4));
        r0.put("effect_type", String.valueOf(r6));
        r0.put("error_code", String.valueOf(r7));
        r0.put("download_time", String.valueOf(r8));
        r0.put("msg_id", String.valueOf(r11));
        r0.put("is_gift_effect_play", String.valueOf(r10));
        r0.put("asset_pre_download", String.valueOf(r13));
        if (r10 == false) goto L5;
        r0.put("is_gift_sender", String.valueOf(r15));
        r0.put("is_gift_receiver", String.valueOf(r14));
        r0.put("is_series_send", String.valueOf(r16));
        r0.put("gift_id", String.valueOf(r17));
        r0.put("gift_type", String.valueOf(r19));
    L5:
        k r1 = f.d(j.C0.a(), k.class);
        if (r1 != null) goto L8;
    L10:
        String r2 = "0";
    L11:
        r0.put("is_anchor", r2);
        n r3 = new n();
        Map r5 = r3.a;
        Intrinsics.checkNotNullParameter(r5, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r5.putAll(r0);
        e.a.getClass();
        cy0.j r9 = e.a.a;
        m.e.getClass();
        Object r18 = m.b(r9).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r18);
        ((f80.a) r18).w3("livesdk_gift_effect_show_failed", r3.a, r3.b);
        return;
    L8:
        if (r1.isAnchor() != true) goto L10;
        r2 = "1";
        goto L11
    }
}
