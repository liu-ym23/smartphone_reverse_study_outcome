package com.larus.dora.obric.device_management.device_bind;

import com.bytedance.dora.device.DoraDevice;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class v implements com.larus.common_ui.dialog.u {
    public final /* synthetic */ DoraObricSmartDeviceBindFragment a;
    public final /* synthetic */ DoraDevice b;

    @Override // com.larus.common_ui.dialog.u
    public final void cancel() {
        DoraObricSmartDeviceBindFragment r0 = this.a;
        int r1 = DoraObricSmartDeviceBindFragment.v;
        r0.ba0().cancelUnbind(this.b);
    }

    public v(DoraObricSmartDeviceBindFragment r1, DoraDevice r2) {
        this.a = r1;
        this.b = r2;
    }
}
