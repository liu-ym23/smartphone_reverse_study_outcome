package com.larus.dora.impl.onboarding.g.v2.base;

import com.bytedance.dora.device.DoraDevice;
import com.larus.common_ui.dialog.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class j implements u {
    public final /* synthetic */ DoraGOnboardingDialogBaseFragment a;
    public final /* synthetic */ DoraDevice b;

    @Override // com.larus.common_ui.dialog.u
    public final void cancel() {
        this.a.X90().cancelUnbind(this.b);
    }

    public j(DoraGOnboardingDialogBaseFragment r1, DoraDevice r2) {
        this.a = r1;
        this.b = r2;
    }
}
