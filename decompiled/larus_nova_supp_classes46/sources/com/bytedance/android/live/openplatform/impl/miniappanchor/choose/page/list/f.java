package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.list;

import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.MiniAppEntranceCell;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.utils.RecyclerViewScrollReportHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f implements RecyclerViewScrollReportHelper.a<MiniAppEntranceCell> {
    public final /* synthetic */ MiniAppChooseListFragment a;

    public f(MiniAppChooseListFragment r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.choose.utils.RecyclerViewScrollReportHelper.a
    public final void a(MiniAppEntranceCell r4, int r5) {
        MiniAppEntranceCell r6 = r4;
        Intrinsics.checkNotNullParameter(r6, "data");
        if (v.a() == false) goto L6;
        int r0 = qo0.a.a;
        qo0.a.c("choose_list", "do recommend list show report, app name: " + r6.title);
    L6:
        if (lp0.b.a(this.a.g) == null) goto L12;
        String r1 = r6.appId;
        if (r1 != null) goto L10;
        r1 = "";
    L10:
        mp0.a.d(r1, mp0.b.a(r6.groupId), lp0.b.d(this.a.g), r6.a(), Integer.valueOf(r5));
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
