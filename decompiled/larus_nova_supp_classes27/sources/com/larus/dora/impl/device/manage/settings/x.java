package com.larus.dora.impl.device.manage.settings;

import com.bytedance.dora.device.DoraDevice;
import com.larus.common_ui.dialog.p0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class x implements p0 {
    public final /* synthetic */ DoraDeviceSettingsFragment a;
    public final /* synthetic */ DoraDevice b;

    @Override // com.larus.common_ui.dialog.p0
    public final void confirm() {
        DoraDeviceSettingsFragment r0 = this.a;
        int r1 = DoraDeviceSettingsFragment.w;
        r0.Y90().replaceBind(this.b);
    }

    public x(DoraDeviceSettingsFragment r1, DoraDevice r2) {
        this.a = r1;
        this.b = r2;
    }
}
