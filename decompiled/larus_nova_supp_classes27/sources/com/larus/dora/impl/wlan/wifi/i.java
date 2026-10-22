package com.larus.dora.impl.wlan.wifi;

import com.larus.common_ui.dialog.p0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class i implements p0 {
    public final /* synthetic */ DoraWifiSettingsFragment a;
    public final /* synthetic */ DoraWifiEntity b;

    @Override // com.larus.common_ui.dialog.p0
    public final void confirm() {
        DoraWifiSettingsFragment r0 = this.a;
        int r1 = DoraWifiSettingsFragment.j;
        r0.W90().deleteWifi(this.b, true);
    }

    public i(DoraWifiSettingsFragment r1, DoraWifiEntity r2) {
        this.a = r1;
        this.b = r2;
    }
}
