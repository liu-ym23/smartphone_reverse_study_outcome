package com.bytedance.android.live.effect.beauty.newtemp;

import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ LiveOneTapBeautyAdapter a;
    public final /* synthetic */ int b;

    public b(LiveOneTapBeautyAdapter r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        int r4 = this.b;
        LiveOneTapBeautyAdapter r0 = this.a;
        if (r4 != r0.e) goto L5;
        return;
    L5:
        LiveOneTapBeautyAdapter.y2(false, (o90.a) ListProtector.get(r0.c, r4), this.b);
        LiveOneTapBeautyAdapter r5 = this.a;
        LiveOneTapBeautyAdapter.b r1 = r5.f;
        if (r1 != null) goto L8;
        return;
    L8:
        if (r5.g == false) goto L12;
        r1.onItemClick(this.b);
        return;
    }
}
