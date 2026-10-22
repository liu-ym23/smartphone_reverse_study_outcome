package com.bytedance.android.live.incentive.et;

import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.incentive.exchange.e;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.livesdk.log.filter.v;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import yz0.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d implements v {
    public static final d a = null;

    public d() {
    }

    public final void Rd() {
    }

    public final void onRemove() {
    }

    static {
        a = new d();
    }

    public static void a(String r4, Map r5) {
        Intrinsics.checkNotNullParameter(r4, "eventName");
        Intrinsics.checkNotNullParameter(r5, "eventProperties");
        String r2 = (String) r5.get("_exchange_session_id");
        if (r2 != null) goto L5;
        return;
    L5:
        Map<String, WeakReference<e>> r3 = e.a;
        Intrinsics.checkNotNullParameter(r2, "sessionId");
        WeakReference r6 = (WeakReference) ((LinkedHashMap) e.a).get(r2);
        if (r6 == null) goto L8;
        e r7 = (e) r6.get();
    L9:
        if (r7 != null) goto L11;
        return;
    L11:
        r5.remove("_exchange_session_id");
        Intrinsics.checkNotNullParameter(r4, "eventName");
        Intrinsics.checkNotNullParameter(r7, "context");
        LinkedHashMap r8 = new LinkedHashMap();
        r8.put("request_page", "diamond_not_enough");
        k r9 = f.d(j.C0.a(), k.class);
        if (r9 == null) goto L14;
        Boolean r11 = Boolean.valueOf(r9.isAnchor());
    L15:
        if (r11 == null) goto L17;
        boolean r12 = r11.booleanValue();
    L18:
        if (r12 == false) goto L20;
        String r13 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L21:
        r8.put("is_anchor", r13);
        int r14 = com.bytedance.android.live.incentive.balance.b.c.a;
        throw null;
    L20:
        r13 = "0";
        goto L21
    L17:
        r12 = false;
        goto L18
    L14:
        r11 = null;
        goto L15
    L8:
        r7 = null;
        goto L9
    }

    public final void L9(String r2, Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        Intrinsics.checkNotNullParameter(r3, "params");
        a(r2, r3);
    }
}
