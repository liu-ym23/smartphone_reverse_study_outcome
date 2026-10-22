package com.bytedance.android.ec.core.gallery2.opt;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ d a;

    public c(d r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        Function0<Unit> r10 = this.a.c;
        if (r10 == null) goto L6;
        Unit r11 = (Unit) r10.invoke();
        return;
    }
}
