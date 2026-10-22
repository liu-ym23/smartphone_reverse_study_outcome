package com.bytedance.android.live.profit.fansclub.panel;

import android.content.Context;
import com.bytedance.android.live.profit.fansclub.FansClubRepository;
import com.bytedance.android.livesdk.utils.c1;
import com.bytedance.android.livesdk.utils.x1;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.scope.o;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import yz0.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements o {
    public final com.bytedance.android.live.revenue.core.a a;
    public final FansClubPanelService b;
    public final FansClubRepository c;
    public final b d;
    public final com.bytedance.android.live.profit.fansclub.d e;
    public final n01.a f;
    public final k g;

    public final void onStop() {
    }

    private final Context getContext() {
        return this.g.getContext();
    }

    public final void onStart() {
        FansClubPanelService r0 = this.b;
        cu0.a r1 = new cu0.a(getContext());
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "factory");
        if (r0.a == true) goto L6;
        ((ArrayList) r0.b).add(r1);
    L6:
        FansClubPanelService r2 = this.b;
        cu0.b r3 = new cu0.b(getContext());
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "factory");
        if (r2.a == true) goto L10;
        ((ArrayList) r2.b).add(r3);
    L10:
        com.bytedance.android.live.profit.fansclub.d r4 = this.e;
        if (r4.c.Fm() == false) goto L13;
        Episode r5 = r4.c.cl();
    L14:
        com.bytedance.android.live.profit.fansclub.d r6 = this.e;
        r6.getClass();
        LinkedHashMap r7 = new LinkedHashMap();
        if (c1.c(r6.getDataCenter()) == true) goto L21;
        if (c1.b(r6.getDataCenter()) == true) goto L21;
        String r8 = "";
    L25:
        r7.put("live_ad", r8);
        this.b.a(new com.bytedance.android.live.profit.fansclub.panel.filter.a(this.c, this.d));
        this.b.a(new com.bytedance.android.live.profit.fansclub.panel.filter.c(this.a, this.g, this.c, r7));
        this.b.a(new com.bytedance.android.live.profit.fansclub.panel.filter.d(r5, this.g, this.f));
        this.b.a(new com.bytedance.android.live.profit.fansclub.panel.filter.b());
        return;
    L21:
        if (c1.b(r6.getDataCenter()) == false) goto L23;
        Map r9 = c1.e(r6.getDataCenter());
    L24:
        r8 = new JSONObject(r9).toString();
        goto L25
    L23:
        r6.getDataCenter();
        int r10 = x1.a;
        r9 = c1.f(r6.getDataCenter());
        goto L24
    L13:
        r5 = null;
        goto L14
    }

    public c(com.bytedance.android.live.revenue.core.a r2, FansClubPanelService r3, FansClubRepository r4, b r5, com.bytedance.android.live.profit.fansclub.d r6, n01.a r7, k r8) {
        Intrinsics.checkNotNullParameter(r2, "inst");
        Intrinsics.checkNotNullParameter(r3, "service");
        Intrinsics.checkNotNullParameter(r4, "repo");
        Intrinsics.checkNotNullParameter(r5, "lynxConfigService");
        Intrinsics.checkNotNullParameter(r6, "loader");
        Intrinsics.checkNotNullParameter(r7, "vsService");
        Intrinsics.checkNotNullParameter(r8, "roomDataService");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }
}
