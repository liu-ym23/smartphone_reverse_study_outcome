package com.bytedance.android.live.ktv.common.tuningpanel.tuningvolume.view;

import android.view.View;
import com.bytedance.android.live.ktv.common.adjust.view.ToneProcessView;
import com.bytedance.android.live.ktv.common.tuningpanel.model.TuningVolumeType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ c a;
    public final /* synthetic */ gc0.a b;

    public b(c r1, gc0.a r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        if (this.b.d(TuningVolumeType.TONE_VOLUME) == true) goto L5;
        return;
    L5:
        ToneProcessView r5 = this.a.getToneProcess();
        if (r5 == null) goto L14;
        int r0 = r5.j;
        if (r0 >= r5.f) goto L10;
        r5.j = r0 + 1;
        r5.invalidate();
        boolean r6 = true;
    L11:
        if (r6 != true) goto L15;
        this.b.b();
        return;
    L15:
        return;
    L10:
        r6 = false;
        goto L11
    }
}
