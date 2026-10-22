package com.larus.dora.impl.device_v2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.router.SmartRouter;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.onboarding.q0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class e0 implements Runnable {
    public final /* synthetic */ DoraSmartDeviceBindFragment a;
    public final /* synthetic */ q0 b;

    public e0(DoraSmartDeviceBindFragment r1, q0 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        DoraSmartDeviceBindFragment r0 = this.a;
        DoraDevice r1 = ((q0.b) this.b).a;
        int r2 = DoraSmartDeviceBindFragment.B;
        r0.getClass();
        Context r3 = r0.getContext();     // Catch: Throwable -> L26
        if (r3 == null) goto L31;
        Intent r4 = new Intent("action.DEVICE_UPDATE_DYNAMIC");     // Catch: Throwable -> L26
        String r5 = null;
        if (r1 == null) goto L9;
        String r6 = r1.mac;     // Catch: Throwable -> L26
    L10:
        r4.putExtra("mac", r6);     // Catch: Throwable -> L26
        LocalBroadcastManager.getInstance(AppHost.a.getApplication()).sendBroadcast(r4);     // Catch: Throwable -> L26
        com.bytedance.router.i r7 = SmartRouter.buildRoute(r3, "//dora_onboarding_v2");     // Catch: Throwable -> L26
        r7.d = 2130772372;     // Catch: Throwable -> L26
        r7.e = 2130772399;     // Catch: Throwable -> L26
        r7.c.putExtra("key_dora_onboarding_device", com.larus.dora.impl.onboarding.x.c(r1));     // Catch: Throwable -> L26
        r7.c.putExtra("bury_point_source", r0.y);     // Catch: Throwable -> L26
        Bundle r8 = r0.getArguments();     // Catch: Throwable -> L26
        if (r8 == null) goto L14;
        r5 = r8.getString("next_action");     // Catch: Throwable -> L26
    L14:
        if (r5 != null) goto L16;
    L19:
        boolean r9 = true;
    L20:
        if (r9 == true) goto L22;
        r7.j("next_action", r5);     // Catch: Throwable -> L26
    L22:
        r7.d();     // Catch: Throwable -> L26
        FragmentActivity r10 = r0.getActivity();     // Catch: Throwable -> L26
        if (r10 == null) goto L32;
        r10.finish();     // Catch: Throwable -> L26
        return;
    L32:
        return;
    L16:
        if (r5.length() == 0) goto L19;
        r9 = false;
        goto L20
    L9:
        r6 = null;
        goto L10
    L31:
        return;
    L26:
        th = move-exception;
        g49.d.c("DoraDeviceBindFragment", "gotoDeviceGuide: exception", th);
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
