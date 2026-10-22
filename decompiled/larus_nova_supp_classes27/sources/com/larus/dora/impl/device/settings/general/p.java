package com.larus.dora.impl.device.settings.general;

import com.larus.common_ui.dialog.p0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class p implements p0 {
    public final /* synthetic */ GeneralSettingsFragment a;

    @Override // com.larus.common_ui.dialog.p0
    public final void confirm() {
        GeneralSettingsFragment r0 = this.a;
        int r1 = GeneralSettingsFragment.j;
        r0.X90().doReboot();
    }

    public p(GeneralSettingsFragment r1) {
        this.a = r1;
    }
}
