package com.bytedance.android.live.ktv.common.search.view;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ CommonHotWordHistoryView a;

    public b(CommonHotWordHistoryView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        if (r2 == null) goto L4;
        Object r0 = r2.getTag();
    L6:
        if ((r0 instanceof String) == false) goto L12;
        Object r3 = r2.getTag();
        if (r3 == null) goto L11;
        String r4 = (String) r3;
    L13:
        Function1<? super String, Unit> r1 = this.a.d;
        if (r1 == null) goto L17;
        Unit r5 = (Unit) r1.invoke(r4);
        return;
    L17:
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L12:
        r4 = "";
        goto L13
    L4:
        r0 = null;
        goto L6
    }
}
