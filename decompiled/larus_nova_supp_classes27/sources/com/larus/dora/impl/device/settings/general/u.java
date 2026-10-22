package com.larus.dora.impl.device.settings.general;

import com.larus.common_ui.dialog.p0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class u implements p0 {
    public final /* synthetic */ GeneralSettingsFragment a;

    @Override // com.larus.common_ui.dialog.p0
    public final void confirm() {
        int r0 = j49.a.a;
        j49.a.h();
        GeneralSettingsFragment r1 = this.a;
        int r2 = GeneralSettingsFragment.j;
        r1.X90().onlyLocalUnbind();
    }

    public u(GeneralSettingsFragment r1) {
        this.a = r1;
    }
}
