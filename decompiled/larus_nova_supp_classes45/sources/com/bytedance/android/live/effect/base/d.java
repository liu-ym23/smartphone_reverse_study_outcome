package com.bytedance.android.live.effect.base;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ BeautifyAdjustPercentBar a;

    public d(BeautifyAdjustPercentBar r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        AdjustPercentBar r3 = BeautifyAdjustPercentBar.R5(this.a);
        if (r3 == null) goto L8;
        int r4 = r3.getPercent();
        AdjustPercentBar r0 = BeautifyAdjustPercentBar.R5(this.a);
        if (r0 == null) goto L9;
        r0.setCurrentProgress(r4 + 1);
        return;
    L9:
        return;
    }
}
