package com.larus.dora.impl.device.manage.settings;

import com.larus.common_ui.dialog.p0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class z implements p0 {
    public final /* synthetic */ DoraDeviceSettingsFragment a;
    public final /* synthetic */ d59.b b;

    @Override // com.larus.common_ui.dialog.p0
    public final void confirm() {
        int r0 = j49.a.a;
        j49.a.h();
        DoraDeviceSettingsFragment r1 = this.a;
        int r2 = DoraDeviceSettingsFragment.w;
        DoraDeviceSettingsViewModel r3 = r1.Y90();
        d59.b r4 = this.b;
        if (r4 == null) goto L5;
        z49.b r5 = r4.a;
    L6:
        r3.onlyLocalUnbind(r5);
        return;
    L5:
        r5 = null;
        goto L6
    }

    public z(DoraDeviceSettingsFragment r1, d59.b r2) {
        this.a = r1;
        this.b = r2;
    }
}
