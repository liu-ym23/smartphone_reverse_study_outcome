package com.larus.dora.obric.device_management.device_bind;

import com.bytedance.dora.device.DoraDevice;
import com.larus.common_ui.dialog.p0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class u implements p0 {
    public final /* synthetic */ DoraObricSmartDeviceBindFragment a;
    public final /* synthetic */ DoraDevice b;

    @Override // com.larus.common_ui.dialog.p0
    public final void confirm() {
        DoraObricSmartDeviceBindFragment r0 = this.a;
        int r1 = DoraObricSmartDeviceBindFragment.v;
        r0.ba0().replaceBindAndConnect(this.b);
    }

    public u(DoraObricSmartDeviceBindFragment r1, DoraDevice r2) {
        this.a = r1;
        this.b = r2;
    }
}
