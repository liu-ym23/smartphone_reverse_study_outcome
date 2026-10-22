package com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web;

import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officewebview.base.OfficeWebView;
import com.ss.android.lark.officewebview.bridge.Status;
import com.ss.android.lark.officewebview.quality.jsbauth.BridgeAuthType;
import com.ss.android.lark.utils.e0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class e implements xwb.f<String, OfficeWebView> {
    public final /* synthetic */ MmEndWindowWebHelper a;

    @Override // xwb.f
    public final /* synthetic */ boolean shouldRunInUIThread() {
        return true;
    }

    @Override // xwb.f
    public final BridgeAuthType authType() {
        return BridgeAuthType.Public;
    }

    public e(MmEndWindowWebHelper r1) {
        this.a = r1;
    }

    @Override // xwb.f
    public final void a(Object r4, xwb.d r5, String r6, OfficeWebView r7) {
        String r8 = (String) r4;
        Intrinsics.checkNotNullParameter(r5, "callback");
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.c r9 = this.a.e.i();
        String r10 = e0.c(new MmSummaryShareInfo(r9.d, r9.e, r9.j, new MmEndWindowConfig(false)));
        int r11 = bwb.b.a;
        bwb.b.g(MmUiLogScene.WEB, "getMinutesInfo", "", null, 8);
        r5.a(Status.SUCCESS, r10);
    }
}
