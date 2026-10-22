package com.larus.dora.impl.device_v2;

import com.bytedance.dora.device.DoraDevice;
import com.larus.common_ui.dialog.p0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class i0 implements p0 {
    public final /* synthetic */ DoraSmartDeviceBindFragment a;
    public final /* synthetic */ DoraDevice b;

    @Override // com.larus.common_ui.dialog.p0
    public final void confirm() {
        DoraSmartDeviceBindFragment r0 = this.a;
        int r1 = DoraSmartDeviceBindFragment.B;
        r0.Y90().replaceBindAndConnect(this.b);
    }

    public i0(DoraSmartDeviceBindFragment r1, DoraDevice r2) {
        this.a = r1;
        this.b = r2;
    }
}
