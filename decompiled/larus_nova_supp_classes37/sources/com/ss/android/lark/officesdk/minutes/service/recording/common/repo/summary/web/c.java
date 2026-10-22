package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.web;

import com.ss.android.lark.officewebview.base.OfficeWebView;
import com.ss.android.lark.officewebview.quality.jsbauth.BridgeAuthType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c implements xwb.f<String, OfficeWebView> {
    public final /* synthetic */ MmSummaryWebHelper a;

    @Override // xwb.f
    public final /* synthetic */ boolean shouldRunInUIThread() {
        return true;
    }

    @Override // xwb.f
    public final BridgeAuthType authType() {
        return BridgeAuthType.Public;
    }

    public c(MmSummaryWebHelper r1) {
        this.a = r1;
    }

    @Override // xwb.f
    public final void a(Object r1, xwb.d r2, String r3, OfficeWebView r4) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        int r5 = com.ss.android.lark.officesdk.minutes.service.recording.common.widget.web.b.a;
        com.ss.android.lark.officesdk.minutes.service.recording.common.widget.web.b.a((String) r1, r2, this.a.b.getFeatureService());
    }
}
