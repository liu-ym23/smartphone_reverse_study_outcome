package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.search;

import android.widget.TextView;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.MiniAppEntranceCell;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.utils.RecyclerViewScrollReportHelper;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.view.error.OpenPlatformFullScreenErrorView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class k<T> implements Observer {
    public final /* synthetic */ MiniAppChooseSearchFragment a;

    public k(MiniAppChooseSearchFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r6) {
        com.bytedance.android.live.openplatform.impl.base.utils.b r7 = (com.bytedance.android.live.openplatform.impl.base.utils.b) r6;
        if (r7.a == false) goto L5;
        T r8 = (T) null;
    L6:
        p r9 = r8;
        if (r9 != null) goto L10;
        return;
    L10:
        if ((r9 instanceof p.c) == false) goto L13;
        MiniAppChooseSearchFragment r10 = this.a;
        int r0 = MiniAppChooseSearchFragment.j;
        r10.S90(2131379091).setVisibility(0);
        ((OpenPlatformFullScreenErrorView) this.a.S90(2131371779)).R5();
        this.a.S90(2131385498).setVisibility(8);
        ((TextView) this.a.S90(2131366935)).setVisibility(8);
        int r11 = com.bytedance.android.live.openplatform.impl.base.utils.k.a;
        com.bytedance.android.live.openplatform.impl.base.utils.k.a(this.a.getContext(), this.a.S90(2131385411));
        return;
    L13:
        if ((r9 instanceof p.d) == false) goto L18;
        MiniAppChooseSearchFragment r1 = this.a;
        int r2 = MiniAppChooseSearchFragment.j;
        r1.hideLoading();
        this.a.S90(2131385565).setVisibility(0);
        SearchResultAdapter r3 = (SearchResultAdapter) this.a.h.getValue();
        p.d r12 = (p.d) r9;
        List<MiniAppEntranceCell> r4 = r12.a;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r4, "data");
        r3.a = r4;
        r3.notifyDataSetChanged();
        RecyclerViewScrollReportHelper<MiniAppEntranceCell> r5 = this.a.i;
        if (r5 == null) goto L25;
        r5.d(r12.a);
        return;
    L25:
        return;
    L18:
        if ((r9 instanceof p.a) == false) goto L21;
        MiniAppChooseSearchFragment r13 = this.a;
        int r14 = MiniAppChooseSearchFragment.j;
        r13.hideLoading();
        this.a.S90(2131385565).setVisibility(8);
        ((OpenPlatformFullScreenErrorView) this.a.S90(2131371779)).S5(this.a.getString(2131920387));
        return;
    L21:
        if ((r9 instanceof p.b) == false) goto L28;
        MiniAppChooseSearchFragment r15 = this.a;
        int r16 = MiniAppChooseSearchFragment.j;
        r15.hideLoading();
        this.a.S90(2131385565).setVisibility(8);
        ((OpenPlatformFullScreenErrorView) this.a.S90(2131371779)).U5(new j(this));
        return;
    L28:
        return;
    L5:
        r7.a = true;
        r8 = r7.b;
        goto L6
    }
}
