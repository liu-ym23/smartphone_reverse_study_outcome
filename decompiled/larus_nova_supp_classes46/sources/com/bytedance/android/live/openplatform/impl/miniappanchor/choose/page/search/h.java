package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.search;

import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.MiniAppEntranceCell;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.utils.RecyclerViewScrollReportHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h implements RecyclerViewScrollReportHelper.a<MiniAppEntranceCell> {
    public final /* synthetic */ MiniAppChooseSearchFragment a;

    public h(MiniAppChooseSearchFragment r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.choose.utils.RecyclerViewScrollReportHelper.a
    public final void a(MiniAppEntranceCell r4, int r5) {
        MiniAppEntranceCell r6 = r4;
        Intrinsics.checkNotNullParameter(r6, "data");
        if (lp0.b.a(this.a.e) == null) goto L9;
        String r0 = r6.appId;
        if (r0 != null) goto L7;
        r0 = "";
    L7:
        mp0.a.d(r0, mp0.b.a(r6.groupId), lp0.b.d(this.a.e), r6.a(), Integer.valueOf(r5));
        return;
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.choose.utils.RecyclerViewScrollReportHelper.a
    public final boolean b(MiniAppEntranceCell r2, MiniAppEntranceCell r3) {
        MiniAppEntranceCell r4 = r2;
        MiniAppEntranceCell r5 = r3;
        Intrinsics.checkNotNullParameter(r4, "newVisibleData");
        Intrinsics.checkNotNullParameter(r5, "oldVisibleData");
        return Intrinsics.areEqual(r4.appId, r5.appId);
    }
}
