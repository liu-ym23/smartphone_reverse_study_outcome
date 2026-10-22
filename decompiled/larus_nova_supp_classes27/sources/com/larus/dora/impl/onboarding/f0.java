package com.larus.dora.impl.onboarding;

import com.bytedance.dora.device.DoraDevice;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class f0 implements com.larus.common_ui.dialog.p0 {
    public final /* synthetic */ DoraOnboardingDialogBaseFragment a;
    public final /* synthetic */ DoraDevice b;

    @Override // com.larus.common_ui.dialog.p0
    public final void confirm() {
        g49.d.d("DoraOnboardingDialogFragment", "showNeedUnbindDialog: confirm");
        this.a.V90().replaceBindAndConnect(this.b);
    }

    public f0(DoraOnboardingDialogBaseFragment r1, DoraDevice r2) {
        this.a = r1;
        this.b = r2;
    }
}
