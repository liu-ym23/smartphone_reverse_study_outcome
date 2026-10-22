package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.list;

import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.MiniAppEntranceCell;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.list.adapter.RecommendListAdapter;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.utils.RecyclerViewScrollReportHelper;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.view.error.OpenPlatformFullScreenErrorView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class l<T> implements Observer {
    public final /* synthetic */ MiniAppChooseListFragment a;

    public l(MiniAppChooseListFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r10) {
        b r11 = (b) r10;
        if ((r11 instanceof b.c) == false) goto L7;
        ((OpenPlatformFullScreenErrorView) this.a.T90(2131371779)).R5();
        MiniAppChooseListFragment.U90(this.a, true);
        ((TextView) this.a.T90(2131383944)).setVisibility(0);
        this.a.T90(2131383948).setVisibility(0);
        b.c r12 = (b.c) r11;
        ((TextView) this.a.T90(2131383944)).setText(r12.b.name);
        RecommendListAdapter r0 = (RecommendListAdapter) this.a.k.getValue();
        List<MiniAppEntranceCell> r2 = r12.a;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r2, "data");
        r0.a = r2;
        r0.notifyDataSetChanged();
        RecyclerViewScrollReportHelper<MiniAppEntranceCell> r1 = this.a.l;
        if (r1 == null) goto L15;
        r1.d(r12.a);
        return;
    L15:
        return;
    L7:
        boolean r3 = r11 instanceof b.a;
        if (r3 == false) goto L10;
    L11:
        MiniAppChooseListFragment.U90(this.a, false);
        ((TextView) this.a.T90(2131383944)).setText("");
        RecommendListAdapter r13 = (RecommendListAdapter) this.a.k.getValue();
        List<MiniAppEntranceCell> r4 = CollectionsKt.emptyList();
        r13.getClass();
        Intrinsics.checkNotNullParameter(r4, "data");
        r13.a = r4;
        r13.notifyDataSetChanged();
        if (r3 == false) goto L18;
        OpenPlatformFullScreenErrorView r14 = (OpenPlatformFullScreenErrorView) this.a.T90(2131371779);
        String r5 = s1.B(2131920372);
        r14.getClass();
        Intrinsics.checkNotNullParameter(r5, "errorTips");
        Intrinsics.checkNotNullParameter(r5, "errorTips");
        r14.T5(new op0.a(false, 0, true, r5, false, "", null));
        return;
    L18:
        return;
    L10:
        if (Intrinsics.areEqual(r11, b.C0144b.a) == true) goto L11;
    }
}
