package com.bytedance.android.live.profit.fansclub.panel.filter;

import android.net.Uri;
import com.bytedance.android.live.profit.fansclub.FansClubEntranceParams;
import com.bytedance.android.live.profit.fansclub.FansClubRepository;
import com.bytedance.android.live.profit.fansclub.i;
import com.bytedance.android.live.profit.fansclub.panel.f;
import com.bytedance.android.live.profit.fansclub.q;
import com.bytedance.android.live.revenue.common.x0;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements f {
    public final q a;
    public final com.bytedance.android.live.profit.fansclub.panel.b b;

    public a(FansClubRepository r2, com.bytedance.android.live.profit.fansclub.panel.b r3) {
        Intrinsics.checkNotNullParameter(r2, "repo");
        Intrinsics.checkNotNullParameter(r3, "lynxConfigService");
        this.a = r2;
        this.b = r3;
    }

    @Override // com.bytedance.android.live.profit.fansclub.panel.f
    public final void a(FansClubEntranceParams r3, com.bytedance.android.live.profit.fansclub.panel.d r4) {
        Intrinsics.checkNotNullParameter(r3, "entranceParams");
        Intrinsics.checkNotNullParameter(r4, "panelParams");
        FansClubEntranceParams.Page r0 = r3.a;
        Intrinsics.checkNotNullParameter(r0, "page");
        if (i.a() == false) goto L12;
        if (r0 != FansClubEntranceParams.Page.Default) goto L7;
    L13:
        boolean r1 = true;
    L15:
        if (r1 == true) goto L18;
        return;
    L18:
        if ((r4 instanceof cu0.a.b) == false) goto L23;
        cu0.a.b r5 = (cu0.a.b) r4;
        x0 r2 = new x0(UriProtector.parse((String) this.a.h().a));
        r5.getClass();
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r5.b = r2;
        Uri r6 = this.b.a(r3.a);
        if (r6 == null) goto L24;
        x0 r7 = new x0(r6);
        Intrinsics.checkNotNullParameter(r7, "<set-?>");
        r5.a = r7;
        return;
    L24:
        return;
    L23:
        return;
    L7:
        if (r0 == FansClubEntranceParams.Page.VIP) goto L13;
        if (r0 == FansClubEntranceParams.Page.FansClub) goto L13;
    L14:
        r1 = false;
        goto L15
    L12:
        if (r0 != FansClubEntranceParams.Page.Default) goto L14;
        goto L13
    }
}
