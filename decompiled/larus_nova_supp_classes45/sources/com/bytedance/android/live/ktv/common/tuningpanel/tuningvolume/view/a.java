package com.bytedance.android.live.ktv.common.tuningpanel.tuningvolume.view;

import android.view.View;
import com.bytedance.android.live.ktv.common.adjust.view.ToneProcessView;
import com.bytedance.android.live.ktv.common.tuningpanel.model.TuningVolumeType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ c a;
    public final /* synthetic */ gc0.a b;

    public a(c r1, gc0.a r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        if (this.b.d(TuningVolumeType.TONE_VOLUME) == true) goto L5;
        return;
    L5:
        ToneProcessView r4 = this.a.getToneProcess();
        if (r4 == null) goto L14;
        int r0 = r4.j;
        if (r0 <= 1) goto L10;
        r4.j = r0 - 1;
        r4.invalidate();
        boolean r5 = true;
    L11:
        if (r5 != true) goto L15;
        this.b.c();
        return;
    L15:
        return;
    L10:
        r5 = false;
        goto L11
    }
}
