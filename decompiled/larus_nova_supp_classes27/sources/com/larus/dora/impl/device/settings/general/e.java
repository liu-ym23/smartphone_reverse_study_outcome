package com.larus.dora.impl.device.settings.general;

import com.larus.common_ui.dialog.p0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class e implements p0 {
    public final /* synthetic */ ExternalSmartGeneralSettingsFragment a;

    @Override // com.larus.common_ui.dialog.p0
    public final void confirm() {
        int r0 = j49.a.a;
        j49.a.h();
        ExternalSmartGeneralSettingsFragment r1 = this.a;
        int r2 = ExternalSmartGeneralSettingsFragment.i;
        r1.W90().unbind();
    }

    public e(ExternalSmartGeneralSettingsFragment r1) {
        this.a = r1;
    }
}
