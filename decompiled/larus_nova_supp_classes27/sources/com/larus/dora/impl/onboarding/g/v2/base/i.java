package com.larus.dora.impl.onboarding.g.v2.base;

import com.bytedance.dora.device.DoraDevice;
import com.larus.common_ui.dialog.p0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class i implements p0 {
    public final /* synthetic */ DoraGOnboardingDialogBaseFragment a;
    public final /* synthetic */ DoraDevice b;

    @Override // com.larus.common_ui.dialog.p0
    public final void confirm() {
        g49.d.d("DoraOnboardingDialogFragment", "showNeedUnbindDialog: confirm");
        this.a.X90().replaceBindAndConnect(this.b, this.a.W90());
    }

    public i(DoraGOnboardingDialogBaseFragment r1, DoraDevice r2) {
        this.a = r1;
        this.b = r2;
    }
}
