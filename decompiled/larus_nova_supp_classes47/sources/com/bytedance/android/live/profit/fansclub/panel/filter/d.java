package com.bytedance.android.live.profit.fansclub.panel.filter;

import com.bytedance.android.live.profit.fansclub.FansClubEntranceParams;
import com.bytedance.android.live.profit.fansclub.panel.f;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisode;
import kotlin.jvm.internal.Intrinsics;
import yz0.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d implements f {
    public final IEpisode a;
    public final k b;
    public final n01.a c;

    /* JADX WARN: Type inference failed for: r2v3, types: [com.bytedance.android.live.profit.fansclub.panel.filter.VSFansClubFilter$process$1] */
    @Override // com.bytedance.android.live.profit.fansclub.panel.f
    public final void a(FansClubEntranceParams r2, com.bytedance.android.live.profit.fansclub.panel.d r3) {
        Intrinsics.checkNotNullParameter(r2, "entranceParams");
        Intrinsics.checkNotNullParameter(r3, "panelParams");
        if (this.a == null) goto L5;
    L7:
        ?? r4 = new VSFansClubFilter$process$1(this);
        if ((r3 instanceof cu0.a.b) == false) goto L11;
        r4.invoke(((cu0.a.b) r3).b);
        return;
    L11:
        return;
    L5:
        if (this.c.i3() == true) goto L7;
    }

    public d(IEpisode r2, k r3, n01.a r4) {
        Intrinsics.checkNotNullParameter(r3, "roomDataService");
        Intrinsics.checkNotNullParameter(r4, "vsService");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
