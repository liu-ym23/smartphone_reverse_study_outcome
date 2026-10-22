package com.larus.dora.impl.device;

import com.bytedance.dora.device.DoraDevice;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class w implements com.larus.common_ui.dialog.p0 {
    public final /* synthetic */ DoraDeviceFragment a;
    public final /* synthetic */ DoraDevice b;

    @Override // com.larus.common_ui.dialog.p0
    public final void confirm() {
        DoraDeviceFragment r0 = this.a;
        int r1 = DoraDeviceFragment.z;
        r0.ea0().replaceBind(this.b);
    }

    public w(DoraDeviceFragment r1, DoraDevice r2) {
        this.a = r1;
        this.b = r2;
    }
}
