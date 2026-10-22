package com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web;

import com.ss.android.lark.officewebview.base.OfficeWebView;
import com.ss.android.lark.officewebview.quality.jsbauth.BridgeAuthType;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class u implements xwb.f<String, OfficeWebView> {
    public final /* synthetic */ MmEndWindowWebHelper a;

    @Override // xwb.f
    public final /* synthetic */ boolean shouldRunInUIThread() {
        return true;
    }

    @Override // xwb.f
    public final BridgeAuthType authType() {
        return BridgeAuthType.Public;
    }

    public u(MmEndWindowWebHelper r1) {
        this.a = r1;
    }

    @Override // xwb.f
    public final void a(Object r10, xwb.d r11, String r12, OfficeWebView r13) {
        String r2 = (String) r10;
        Intrinsics.checkNotNullParameter(r11, "callback");
        MmEndWindowWebHelper r1 = this.a;
        BuildersKt.launch$default(r1.c, null, null, new MmEndWindowWebHelper$registerHandlers$8$handle$1(r1, r2, r12, r11, null), 3, null);
    }
}
