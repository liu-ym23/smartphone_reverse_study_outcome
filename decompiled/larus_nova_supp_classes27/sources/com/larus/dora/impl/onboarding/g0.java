package com.larus.dora.impl.onboarding;

import com.bytedance.dora.device.DoraDevice;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class g0 implements com.larus.common_ui.dialog.u {
    public final /* synthetic */ DoraOnboardingDialogBaseFragment a;
    public final /* synthetic */ DoraDevice b;

    @Override // com.larus.common_ui.dialog.u
    public final void cancel() {
        this.a.V90().cancelUnbind(this.b);
    }

    public g0(DoraOnboardingDialogBaseFragment r1, DoraDevice r2) {
        this.a = r1;
        this.b = r2;
    }
}
