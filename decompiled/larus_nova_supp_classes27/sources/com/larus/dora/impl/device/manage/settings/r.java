package com.larus.dora.impl.device.manage.settings;

import android.content.Intent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.common.apphost.AppHost;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class r implements Runnable {
    public final /* synthetic */ DoraDeviceSettingsViewModel.e a;
    public final /* synthetic */ DoraDeviceSettingsFragment b;

    public r(DoraDeviceSettingsViewModel.e r1, DoraDeviceSettingsFragment r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        Intent r0 = new Intent("action.DEVICE_UPDATE_DYNAMIC");
        r0.putExtra("mac", ((DoraDeviceSettingsViewModel.e.a) this.a).b.mac);
        LocalBroadcastManager.getInstance(AppHost.a.getApplication()).sendBroadcast(r0);
        DoraDeviceSettingsFragment r1 = this.b;
        int r2 = DoraDeviceSettingsFragment.w;
        r1.aa0();
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
