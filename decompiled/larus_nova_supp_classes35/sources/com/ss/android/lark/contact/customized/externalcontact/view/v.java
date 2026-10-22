package com.ss.android.lark.contact.customized.externalcontact.view;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class v implements View.OnClickListener {
    public final /* synthetic */ l9b.a a;

    public v(l9b.a r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        Function0<Unit> r2 = this.a.j;
        if (r2 == null) goto L6;
        r2.invoke();
        return;
    }
}
