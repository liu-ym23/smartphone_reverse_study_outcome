package com.larus.slides.impl;

import com.larus.office.base.OfficeBaseFragment;
import com.larus.slides.biz.impl.databinding.LarusLayoutSlidesDetailFragmentBinding;
import com.larus.slides.impl.view.SlidesLoadLayout;
import com.larus.slides.impl.viewmodel.SlidesDetailViewModel;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class w implements vm9.c {
    public final /* synthetic */ SlidesFragment a;

    public final Function0<String> getIdGetter() {
        return null;
    }

    public final vm9.b getLoadingView() {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("getLoadingView loadingView=");
        SlidesFragment r2 = this.a;
        int r3 = SlidesFragment.O;
        LarusLayoutSlidesDetailFragmentBinding r4 = (LarusLayoutSlidesDetailFragmentBinding) ((OfficeBaseFragment) r2).e;
        if (r4 == null) goto L5;
        SlidesLoadLayout r5 = r4.g;
    L6:
        r1.append(r5);
        r0.d("SlidesFragment", r1.toString());
        LarusLayoutSlidesDetailFragmentBinding r6 = (LarusLayoutSlidesDetailFragmentBinding) ((OfficeBaseFragment) this.a).e;
        if (r6 != null) goto L9;
        return null;
    L9:
        return r6.g;
    L5:
        r5 = null;
        goto L6
    }

    public final void notifyHasReportLoadResultEvent() {
        FLogger.a.d("SlidesFragment", "notifyHasReportLoadResultEvent");
        if ((this.a.getActivity() instanceof SlidesActivity) == false) goto L8;
        SlidesActivity r0 = this.a.getActivity();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.larus.slides.impl.SlidesActivity");
        SlidesDetailViewModel r1 = r0.c;
        if (r1 == null) goto L9;
        r1.setHasReportLaunchResult(true);
        return;
    L9:
        return;
    }

    public w(SlidesFragment r1) {
        this.a = r1;
    }

    public final void onLoadFailed(int r5) {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("onLoadFailed errorCode=");
        r1.append(r5);
        r1.append(" loadingView=");
        SlidesFragment r2 = this.a;
        int r3 = SlidesFragment.O;
        LarusLayoutSlidesDetailFragmentBinding r4 = (LarusLayoutSlidesDetailFragmentBinding) ((OfficeBaseFragment) r2).e;
        if (r4 == null) goto L5;
        SlidesLoadLayout r6 = r4.g;
    L6:
        r1.append(r6);
        r0.d("SlidesFragment", r1.toString());
        if (r5 != (-55)) goto L10;
        this.a.v = true;
        int r7 = ww9.a.b;
        ww9.a.c("delete", Long.valueOf(System.currentTimeMillis() - ww9.a.a), this.a.t9());
        return;
    L10:
        return;
    L5:
        r6 = null;
        goto L6
    }
}
