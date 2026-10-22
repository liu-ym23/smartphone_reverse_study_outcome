package com.bytedance.android.live.broadcastgame.xplay.floatwindow;

import android.view.View;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h implements View.OnClickListener {
    public final /* synthetic */ Function1 a;

    public h(Function1 r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final /* synthetic */ void onClick(View r2) {
        this.a.invoke(r2);
    }
}
