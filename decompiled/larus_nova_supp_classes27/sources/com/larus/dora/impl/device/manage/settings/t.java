package com.larus.dora.impl.device.manage.settings;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class t implements Function0<Unit> {
    public final /* synthetic */ DoraDeviceSettingsViewModel.c a;
    public final /* synthetic */ DoraDeviceSettingsFragment b;

    public t(DoraDeviceSettingsViewModel.c r1, DoraDeviceSettingsFragment r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke() {
        String r0 = ((DoraDeviceSettingsViewModel.c.a) this.a).a;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L12;
        DoraDeviceSettingsFragment r2 = this.b;
        int r3 = DoraDeviceSettingsFragment.w;
        r2.Y90().handleConnectRequest(((DoraDeviceSettingsViewModel.c.a) this.a).a);
    L12:
        return Unit.INSTANCE;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }
}
