package com.bytedance.android.live.livepkaudience.list;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ Function1 a;

    public b() {
        this.a = null;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        Function1 r0 = this.a;
        if (r0 == null) goto L6;
        Unit r3 = (Unit) r0.invoke(r2);
        return;
    }
}
