package com.larus.dora.impl.device.manage.settings;

import com.bytedance.dora.device.DoraDevice;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class s implements Runnable {
    public final /* synthetic */ DoraDeviceSettingsViewModel.e a;
    public final /* synthetic */ DoraDeviceSettingsFragment b;

    public s(DoraDeviceSettingsViewModel.e r1, DoraDeviceSettingsFragment r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        z49.b r0 = ((DoraDeviceSettingsViewModel.e.c) this.a).b;
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.c();
    L6:
        DoraDevice r3 = this.b.p;
        if (r3 == null) goto L9;
        String r4 = r3.mac;
    L11:
        if (Intrinsics.areEqual(r2, r4) == false) goto L17;
        DoraDeviceSettingsViewModel r5 = this.b.Y90();
        z49.b r6 = ((DoraDeviceSettingsViewModel.e.c) this.a).b;
        if (r6 == null) goto L15;
        r1 = r6.c();
    L15:
        r5.updateConnectState(new DoraDeviceSettingsViewModel.b.c(r1));
        return;
    L17:
        return;
    L9:
        r4 = null;
        goto L11
    L5:
        r2 = null;
        goto L6
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
