package com.bytedance.android.live.ktv.common.search.view;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c<T> implements Observer {
    public final /* synthetic */ CommonSearchContainer a;

    public c(CommonSearchContainer r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        List<String> r3 = (List) r2;
        CommonSearchEnterView r0 = CommonSearchContainer.c(this.a);
        if (r0 == null) goto L6;
        r0.k(r3);
        return;
    }
}
