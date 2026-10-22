package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.search;

import android.widget.TextView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.LinkedList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i<T> implements Observer {
    public final /* synthetic */ MiniAppChooseSearchFragment a;

    public i(MiniAppChooseSearchFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        LinkedList r5 = (LinkedList) r4;
        MiniAppChooseSearchFragment r0 = this.a;
        int r1 = MiniAppChooseSearchFragment.j;
        SearchHistoryAdapter r2 = (SearchHistoryAdapter) r0.g.getValue();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r5, "data");
        r2.a = r5;
        r2.notifyDataSetChanged();
        MiniAppChooseSearchViewModel r6 = this.a.f;
        if (r6 == null) goto L5;
        int r7 = r6.getHistoryListSize();
    L7:
        if (this.a.S90(2131385498).getVisibility() == 0) goto L9;
    L11:
        ((TextView) this.a.S90(2131366935)).setVisibility(8);
        return;
    L9:
        if (r7 < 1) goto L11;
        ((TextView) this.a.S90(2131366935)).setVisibility(0);
        return;
    L5:
        r7 = 0;
        goto L7
    }
}
