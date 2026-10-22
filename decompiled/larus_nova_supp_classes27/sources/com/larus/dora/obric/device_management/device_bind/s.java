package com.larus.dora.obric.device_management.device_bind;

import android.content.Intent;
import com.larus.common_ui.dialog.p0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class s implements p0 {
    public final /* synthetic */ DoraObricSmartDeviceBindFragment a;

    @Override // com.larus.common_ui.dialog.p0
    public final void confirm() {
        DoraObricSmartDeviceBindFragment r0 = this.a;
        Intent r1 = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
        r1.addFlags(268435456);
        r0.startActivity(r1);
    }

    public s(DoraObricSmartDeviceBindFragment r1) {
        this.a = r1;
    }
}
