package com.bytedance.android.live.ktv.common.search.view;

import com.bytedance.android.live.ktv.common.model.api.u;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d<T> implements Observer {
    public final /* synthetic */ CommonSearchContainer a;

    public d(CommonSearchContainer r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        List<u> r3 = (List) r2;
        CommonSearchEnterView r0 = CommonSearchContainer.c(this.a);
        if (r0 == null) goto L6;
        r0.l(r3);
        return;
    }
}
