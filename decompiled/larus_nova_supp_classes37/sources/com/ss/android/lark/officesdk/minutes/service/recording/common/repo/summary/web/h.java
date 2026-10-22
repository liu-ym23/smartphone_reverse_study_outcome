package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.web;

import com.ss.android.lark.officewebview.base.OfficeWebView;
import com.ss.android.lark.officewebview.bridge.Status;
import com.ss.android.lark.officewebview.quality.jsbauth.BridgeAuthType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class h implements xwb.f<String, OfficeWebView> {
    public final /* synthetic */ MmSummaryWebHelper a;

    @Override // xwb.f
    public final /* synthetic */ boolean shouldRunInUIThread() {
        return true;
    }

    @Override // xwb.f
    public final BridgeAuthType authType() {
        return BridgeAuthType.Public;
    }

    public h(MmSummaryWebHelper r1) {
        this.a = r1;
    }

    @Override // xwb.f
    public final void a(Object r1, xwb.d r2, String r3, OfficeWebView r4) {
        String r5 = (String) r1;
        Intrinsics.checkNotNullParameter(r2, "callback");
        lvb.a.e(this.a.d, "[common_vibrate]");
        this.a.b.c();
        r2.a(Status.SUCCESS, "");
    }
}
