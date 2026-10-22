package com.obric.assistant.view;

import android.view.View;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class h implements View.OnClickListener {
    public final /* synthetic */ Function0 a;

    public /* synthetic */ h(sba.f r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        Function0 r2 = this.a;
        if (r2 == null) goto L5;
        r2.invoke();
    L5:
        j.a();
    }
}
