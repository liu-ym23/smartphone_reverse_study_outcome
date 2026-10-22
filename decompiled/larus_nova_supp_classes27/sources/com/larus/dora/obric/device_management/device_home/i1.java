package com.larus.dora.obric.device_management.device_home;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class i1 implements com.larus.platform.api.g1.c {
    public final /* synthetic */ DoraObricDeviceHomeFragment a;

    public final void onSettingPageReturn() {
    }

    public final void onGoSettingsDialogShow() {
        g49.d.d("DoraObricDeviceHomeFragment", "permission onGoSettingsDialogShow");
    }

    public i1(DoraObricDeviceHomeFragment r1) {
        this.a = r1;
    }

    public final void onGoSettingsDialogDismiss(boolean r3) {
        g49.d.d("DoraObricDeviceHomeFragment", "permission onGoSettingsDialogDismiss isConfirmed=" + r3);
        if (r3 == true) goto L6;
        DoraObricDeviceHomeFragment r4 = this.a;
        int r0 = DoraObricDeviceHomeFragment.R;
        r4.Y90();
        this.a.ia0().onReconnectFailed();
        return;
    }

    public final void onResult(boolean r1, List<String> r2, List<String> r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "grantedList");
        Intrinsics.checkNotNullParameter(r3, "deniedList");
        g49.d.d("DoraObricDeviceHomeFragment", "permission onResult allGranted=" + r1);
        if (r1 == false) goto L8;
        DoraObricDeviceHomeFragment r5 = this.a;
        String r6 = r5.G;
        if (r6 != null) goto L7;
        r6 = "";
    L7:
        r5.Z90(r6);
        return;
    L8:
        DoraObricDeviceHomeFragment r7 = this.a;
        int r8 = DoraObricDeviceHomeFragment.R;
        r7.Y90();
        this.a.ia0().onReconnectFailed();
    }
}
