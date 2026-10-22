package com.ss.android.lark.conditional.access.nopermission.ui;

import android.content.DialogInterface;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements DialogInterface.OnClickListener {
    public final /* synthetic */ DeviceAuthenticationNoPermissionFragment a;

    public b(DeviceAuthenticationNoPermissionFragment r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r2, int r3) {
        ScsLogger.d("SecurityPolicy_DeviceAuthenticationNoPermissionFragment", "deviceAuthentication fail, retry button click.");
        DeviceAuthenticationNoPermissionFragment r4 = this.a;
        int r5 = DeviceAuthenticationNoPermissionFragment.o;
        r4.Z90();
        DeviceAuthenticationNoPermissionFragment r6 = this.a;
        qqb.a.h("DeviceAuthenticationNoPermissionFragment retry device authentication");     // Catch: Throwable -> L6
        r6.n = r6.T90().startDeviceAuthentication(qqb.a.d());     // Catch: Throwable -> L6
        qqb.a.a();
        return;
    L6:
        th = move-exception;
        qqb.a.a();
        throw th;
    }
}
