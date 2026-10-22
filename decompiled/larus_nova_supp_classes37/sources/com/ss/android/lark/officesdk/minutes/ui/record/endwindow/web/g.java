package com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web;

import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officewebview.base.OfficeWebView;
import com.ss.android.lark.officewebview.bridge.Status;
import com.ss.android.lark.officewebview.quality.jsbauth.BridgeAuthType;
import com.ss.android.lark.utils.e0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class g implements xwb.f<String, OfficeWebView> {
    public final /* synthetic */ MmEndWindowWebHelper a;

    @Override // xwb.f
    public final /* synthetic */ boolean shouldRunInUIThread() {
        return true;
    }

    @Override // xwb.f
    public final BridgeAuthType authType() {
        return BridgeAuthType.Public;
    }

    public g(MmEndWindowWebHelper r1) {
        this.a = r1;
    }

    @Override // xwb.f
    public final void a(Object r4, xwb.d r5, String r6, OfficeWebView r7) {
        String r8 = (String) r4;
        Intrinsics.checkNotNullParameter(r5, "callback");
        MmEndWindowWebHelper r9 = this.a;
        r9.getClass();
        String r10 = e0.c(new MmDomainInfo(r9.e.d(), r9.e.k()));
        int r11 = bwb.b.a;
        bwb.b.g(MmUiLogScene.WEB, "getDomain", "result=" + r10, null, 8);
        r5.a(Status.SUCCESS, r10);
    }
}
