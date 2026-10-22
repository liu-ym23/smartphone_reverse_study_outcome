package com.bytedance.android.live.ktv.common.search.view;

import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ CommonSearchContainer a;
    public final /* synthetic */ List b;

    public i(CommonSearchContainer r1, List r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r2) {
        Unit r3 = (Unit) r2;
        com.bytedance.android.live.ktv.common.search.viewmodel.a r4 = CommonSearchContainer.a(this.a);
        if (r4 == null) goto L6;
        r4.updateCurSearchKeyword(null);
        return;
    }
}
