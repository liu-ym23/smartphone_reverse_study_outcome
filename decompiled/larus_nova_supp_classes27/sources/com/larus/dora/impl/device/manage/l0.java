package com.larus.dora.impl.device.manage;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class l0 implements z0 {
    public final /* synthetic */ DoraGDeviceManagementFragment a;

    @Override // com.larus.dora.impl.device.manage.z0
    public final void a() {
        g49.d.d("DoraGDeviceManagementFragment", "onConnectRequestFailed");
        DoraGDeviceManagementFragment r0 = this.a;
        r0.l = false;
        DoraGDeviceManagementAdapter r1 = r0.j;
        if (r1 == null) goto L6;
        r1.z2();
        return;
    }

    public l0(DoraGDeviceManagementFragment r1) {
        this.a = r1;
    }
}
