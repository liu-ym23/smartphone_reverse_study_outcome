package com.bytedance.android.live.profit.fansclub.panel.filter;

import com.bytedance.android.live.profit.fansclub.FansClubEntranceParams;
import com.bytedance.android.live.profit.fansclub.i;
import com.bytedance.android.live.profit.fansclub.panel.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements f {
    public b() {
    }

    @Override // com.bytedance.android.live.profit.fansclub.panel.f
    public final void a(FansClubEntranceParams r3, com.bytedance.android.live.profit.fansclub.panel.d r4) {
        Intrinsics.checkNotNullParameter(r3, "entranceParams");
        Intrinsics.checkNotNullParameter(r4, "panelParams");
        FansClubEntranceParams.Page r5 = r3.a;
        Intrinsics.checkNotNullParameter(r5, "page");
        if (r5 != FansClubEntranceParams.Page.FansGroup) goto L5;
        boolean r6 = true;
    L6:
        if (r6 == true) goto L9;
        return;
    L9:
        if ((r4 instanceof cu0.b.C0229b) == false) goto L12;
        cu0.b.C0229b r7 = (cu0.b.C0229b) r4;
        String r8 = (String) i.q.getValue(null, i.a[14]);
        r7.getClass();
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        r7.a = r8;
        return;
    L12:
        return;
    L5:
        r6 = false;
        goto L6
    }
}
