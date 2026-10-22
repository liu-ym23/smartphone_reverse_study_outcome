package com.bytedance.android.live.ktv.common.search.view;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f<T> implements Observer {
    public final /* synthetic */ CommonSearchContainer a;

    public f(CommonSearchContainer r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        CommonSearchContainer r0 = this.a;
        CommonSearchContainer.e(r0, (List) r2);
    }
}
