package com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web;

import com.ss.android.lark.officewebview.base.OfficeWebView;
import com.ss.android.lark.officewebview.quality.jsbauth.BridgeAuthType;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class k implements xwb.f<String, OfficeWebView> {
    public final /* synthetic */ MmEndWindowWebHelper a;

    @Override // xwb.f
    public final /* synthetic */ boolean shouldRunInUIThread() {
        return true;
    }

    @Override // xwb.f
    public final BridgeAuthType authType() {
        return BridgeAuthType.Public;
    }

    public k(MmEndWindowWebHelper r1) {
        this.a = r1;
    }

    @Override // xwb.f
    public final void a(Object r1, xwb.d r2, String r3, OfficeWebView r4) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        MmEndWindowWebHelper r5 = this.a;
        r5.getClass();
        int r6 = com.ss.android.lark.officesdk.minutes.service.recording.common.widget.web.c.a;
        CoroutineScope r7 = r5.c;
        com.ss.android.lark.officesdk.minutes.service.recording.common.widget.web.c.a(r7, (String) r1, r2, r5.e.a());
    }
}
