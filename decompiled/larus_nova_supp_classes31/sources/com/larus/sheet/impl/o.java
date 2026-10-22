package com.larus.sheet.impl;

import com.larus.office.base.OfficeBaseFragment;
import com.larus.sheet.biz.impl.databinding.LarusLayoutSheetDetailFragmentBinding;
import com.larus.sheet.impl.view.SheetLoadLayout;
import com.larus.sheet.impl.viewmodel.SheetDetailViewModel;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class o implements vm9.c {
    public final /* synthetic */ SheetFragment a;

    public final Function0<String> getIdGetter() {
        return null;
    }

    public final vm9.b getLoadingView() {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("getLoadingView loadingView=");
        SheetFragment r2 = this.a;
        int r3 = SheetFragment.R;
        LarusLayoutSheetDetailFragmentBinding r4 = (LarusLayoutSheetDetailFragmentBinding) ((OfficeBaseFragment) r2).e;
        if (r4 == null) goto L5;
        SheetLoadLayout r5 = r4.g;
    L6:
        r1.append(r5);
        r0.d("SheetFragment", r1.toString());
        LarusLayoutSheetDetailFragmentBinding r6 = (LarusLayoutSheetDetailFragmentBinding) ((OfficeBaseFragment) this.a).e;
        if (r6 != null) goto L9;
        return null;
    L9:
        return r6.g;
    L5:
        r5 = null;
        goto L6
    }

    public final void notifyHasReportLoadResultEvent() {
        FLogger.a.d("SheetFragment", "notifyHasReportLoadResultEvent");
        if ((this.a.getActivity() instanceof SheetActivity) == false) goto L8;
        SheetActivity r0 = this.a.getActivity();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.larus.sheet.impl.SheetActivity");
        SheetDetailViewModel r1 = r0.c;
        if (r1 == null) goto L9;
        r1.setHasReportLaunchResult(true);
        return;
    L9:
        return;
    }

    public o(SheetFragment r1) {
        this.a = r1;
    }

    public final void onLoadFailed(int r5) {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("onLoadFailed errorCode=");
        r1.append(r5);
        r1.append(" loadingView=");
        SheetFragment r2 = this.a;
        int r3 = SheetFragment.R;
        LarusLayoutSheetDetailFragmentBinding r4 = (LarusLayoutSheetDetailFragmentBinding) ((OfficeBaseFragment) r2).e;
        if (r4 == null) goto L5;
        SheetLoadLayout r6 = r4.g;
    L6:
        r1.append(r6);
        r0.d("SheetFragment", r1.toString());
        if (r5 != (-55)) goto L10;
        this.a.s = true;
        int r7 = nw9.a.b;
        nw9.a.c("delete", Long.valueOf(System.currentTimeMillis() - nw9.a.a), this.a.t9());
        return;
    L10:
        return;
    L5:
        r6 = null;
        goto L6
    }
}
