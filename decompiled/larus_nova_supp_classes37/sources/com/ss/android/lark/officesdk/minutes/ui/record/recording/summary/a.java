package com.ss.android.lark.officesdk.minutes.ui.record.recording.summary;

import android.view.View;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a implements View.OnScrollChangeListener {
    public final /* synthetic */ MmSummaryFragment a;

    public a(MmSummaryFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnScrollChangeListener
    public final void onScrollChange(View r1, int r2, int r3, int r4, int r5) {
        MmSummaryFragment r6 = this.a;
        if (r6.m != null) goto L7;
        int r7 = bwb.b.a;
        bwb.b.d(MmUiLogScene.SUMMARY, "initListener", "onScrollChange: summaryView is null, skip", r6.U90());
        return;
    L7:
        if (MmSummaryFragment.ea0(r6) == false) goto L9;
        this.a.r.a(r3, r5);
    L9:
        boolean r8 = MmSummaryFragment.da0(this.a);
        if (this.a.o == r8) goto L15;
        int r9 = bwb.b.a;
        bwb.b.f(MmUiLogScene.SUMMARY, "initListener", "scroll changed, isAtBottom=" + r8, this.a.U90());
        MmSummaryFragment r10 = this.a;
        r10.o = r8;
        if (r8 == false) goto L16;
        r10.la0(false, "scroll");
        this.a.ha0().dispatchEvent(new b.i("scroll_to_bottom"));
        return;
    L16:
        return;
    }
}
