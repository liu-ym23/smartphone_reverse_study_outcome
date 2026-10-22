package com.bytedance.android.live.ktv.common.search.view;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ CommonHotWordHistoryView a;
    public final /* synthetic */ boolean b;

    public a(CommonHotWordHistoryView r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        if (r3 == null) goto L4;
        Object r0 = r3.getTag();
    L6:
        if ((r0 instanceof String) == false) goto L12;
        Object r4 = r3.getTag();
        if (r4 == null) goto L11;
        String r5 = (String) r4;
    L13:
        Function2<? super String, ? super Boolean, Unit> r1 = this.a.c;
        if (r1 == null) goto L17;
        Unit r6 = (Unit) r1.invoke(r5, Boolean.valueOf(this.b));
        return;
    L17:
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L12:
        r5 = "";
        goto L13
    L4:
        r0 = null;
        goto L6
    }
}
