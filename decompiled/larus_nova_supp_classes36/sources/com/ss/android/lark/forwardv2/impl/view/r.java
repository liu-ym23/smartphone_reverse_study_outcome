package com.ss.android.lark.forwardv2.impl.view;

import com.ss.android.lark.forwardv3.recentforward.RecentForwardAdapterV3;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class r implements RecentForwardAdapterV3.b {
    public final /* synthetic */ d0 a;

    public r(d0 r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.forwardv3.recentforward.RecentForwardAdapterV3.b
    public final void a(SearchBaseInfo r4, int r5, boolean r6) {
        d0 r0 = this.a;
        int r1 = r0.f;
        if (r1 == 0) goto L7;
        if (r1 != 1) goto L10;
        r0.d.n1(r4, r6);
        this.a.o.notifyItemChanged(r5, "view_checkbox");
        boolean r7 = zib.b.d;
        zib.b.a(false, true);
        return;
    L10:
        return;
    L7:
        r0.d.i7(r4);
        boolean r8 = zib.b.d;
        zib.b.a(true, true);
    }
}
