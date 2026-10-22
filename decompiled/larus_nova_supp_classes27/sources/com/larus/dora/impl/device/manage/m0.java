package com.larus.dora.impl.device.manage;

import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class m0 implements com.larus.common_ui.dialog.p0 {
    public final /* synthetic */ DoraGDeviceManagementFragment a;
    public final /* synthetic */ DoraDevice b;

    @Override // com.larus.common_ui.dialog.p0
    public final void confirm() {
        DoraGDeviceManagementFragment r0 = this.a;
        int r1 = DoraGDeviceManagementFragment.q;
        DoraGDeviceManagementViewModel r2 = r0.Y90();
        if (r2 == null) goto L6;
        r2.replaceBind(this.b);
        return;
    }

    public m0(DoraGDeviceManagementFragment r1, DoraDevice r2) {
        this.a = r1;
        this.b = r2;
    }
}
