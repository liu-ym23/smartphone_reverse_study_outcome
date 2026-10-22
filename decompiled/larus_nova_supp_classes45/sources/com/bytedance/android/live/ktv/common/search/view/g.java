package com.bytedance.android.live.ktv.common.search.view;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g implements View.OnClickListener {
    public final /* synthetic */ CommonSearchContainer a;

    public g(CommonSearchContainer r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        com.bytedance.android.live.ktv.common.search.viewmodel.a r3 = CommonSearchContainer.a(this.a);
        if (r3 == null) goto L10;
        com.bytedance.android.live.ktv.common.ordersong.feedback.a r4 = r3.getCurPredicateContent();
        if (r4 == null) goto L11;
        Function1<? super com.bytedance.android.live.ktv.common.ordersong.feedback.a, Unit> r0 = this.a.g;
        if (r0 == null) goto L12;
        Unit r5 = (Unit) r0.invoke(r4);
        return;
    L12:
        return;
    L11:
        return;
    }
}
