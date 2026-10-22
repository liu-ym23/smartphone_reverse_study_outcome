package com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class l implements View.OnClickListener {
    public final /* synthetic */ MmAINotePanelAnimator a;

    public l(MmAINotePanelAnimator r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        MmAINotePanelAnimator r3 = this.a;
        if (r3.u <= 0) goto L6;
        r3.u(r3.f);
        return;
    }
}
