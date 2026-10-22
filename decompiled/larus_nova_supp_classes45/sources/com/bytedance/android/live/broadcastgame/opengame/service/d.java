package com.bytedance.android.live.broadcastgame.opengame.service;

import android.view.View;
import com.bytedance.android.live.broadcastgame.opengame.view.u;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ CommercialService a;

    public d(CommercialService r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        Function0<Unit> r2 = this.a.d;
        if (r2 == null) goto L5;
        Unit r3 = (Unit) r2.invoke();
    L5:
        u r4 = this.a.b;
        if (r4 == null) goto L9;
        r4.poll();
        return;
    }
}
