package com.bytedance.android.live.profit.fansclub.panel.filter;

import com.bytedance.android.live.profit.fansclub.FansClubEntranceParams;
import com.bytedance.android.live.profit.fansclub.FansClubRepository;
import com.bytedance.android.live.profit.fansclub.panel.f;
import com.bytedance.android.live.profit.fansclub.q;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import yz0.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements f {
    public static final /* synthetic */ int e = 0;
    public final com.bytedance.android.live.revenue.core.a a;
    public final k b;
    public final q c;
    public final Map<String, String> d;

    public static final class a {
        public static final String a() {
            int r0 = c.e;
            com.bytedance.android.live.revenue.platform.log.impl.filterimpl.a r1 = ((mz0.c) com.bytedance.android.live.revenue.core.util.f.a(mz0.c.class)).W2(LogCommon.PAGE_SOURCE_LOG);
            if (r1 == null) goto L8;
            Map<String, String> r2 = r1.getMap();
            if (r2 == null) goto L8;
            String r3 = r2.get("enter_method");
            if (r3 == null) goto L8;
            return r3;
        L8:
            return "";
        }

        public a() {
        }
    }

    static {
        new a();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.live.profit.fansclub.panel.filter.HybridQueryFilter$process$1] */
    @Override // com.bytedance.android.live.profit.fansclub.panel.f
    public final void a(final FansClubEntranceParams r4, com.bytedance.android.live.profit.fansclub.panel.d r5) {
        Intrinsics.checkNotNullParameter(r4, "entranceParams");
        Intrinsics.checkNotNullParameter(r5, "panelParams");
        ?? r0 = new HybridQueryFilter$process$1(this, r4);
        if ((r5 instanceof cu0.a.b) == false) goto L6;
        cu0.a.b r6 = (cu0.a.b) r5;
        r0.invoke(r6.a.d("url"));
        r0.invoke(r6.a.d("fallback_url").d("url"));
        r0.invoke(r6.b);
        return;
    }

    public c(com.bytedance.android.live.revenue.core.a r2, k r3, FansClubRepository r4, Map r5) {
        Intrinsics.checkNotNullParameter(r2, "inst");
        Intrinsics.checkNotNullParameter(r3, "roomDataService");
        Intrinsics.checkNotNullParameter(r4, "repo");
        Intrinsics.checkNotNullParameter(r5, "liveAdParams");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
