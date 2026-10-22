package com.larus.dora.impl.device_v2;

import com.bytedance.dora.device.DoraDevice;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class j0 implements com.larus.common_ui.dialog.u {
    public final /* synthetic */ DoraSmartDeviceBindFragment a;
    public final /* synthetic */ DoraDevice b;

    @Override // com.larus.common_ui.dialog.u
    public final void cancel() {
        DoraSmartDeviceBindFragment r0 = this.a;
        int r1 = DoraSmartDeviceBindFragment.B;
        r0.Y90().cancelUnbind(this.b);
    }

    public j0(DoraSmartDeviceBindFragment r1, DoraDevice r2) {
        this.a = r1;
        this.b = r2;
    }
}
