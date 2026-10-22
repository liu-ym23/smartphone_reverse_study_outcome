package com.larus.dora.obric.device_management.device_bind;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class t implements com.larus.common_ui.dialog.u {
    public final /* synthetic */ DoraObricSmartDeviceBindFragment a;

    @Override // com.larus.common_ui.dialog.u
    public final void cancel() {
        DoraObricSmartDeviceBindFragment r0 = this.a;
        int r1 = DoraObricSmartDeviceBindFragment.v;
        r0.ca0("location dialog cancelled");
    }

    public t(DoraObricSmartDeviceBindFragment r1) {
        this.a = r1;
    }
}
