package com.bytedance.android.live.profit.scoreboard;

import android.view.View;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class w implements View.OnClickListener {
    public final /* synthetic */ v a;

    public w(v r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        jy0.b.d("ScoreboardBannerController", "user clicked banner");
        this.a.c.f().onNext(Unit.INSTANCE);
        v r3 = this.a;
        r3.e.showPlugin(r3.b.isAnchor());
    }
}
