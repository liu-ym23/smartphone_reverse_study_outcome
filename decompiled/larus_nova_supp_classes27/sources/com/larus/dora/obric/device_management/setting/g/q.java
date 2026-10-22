package com.larus.dora.obric.device_management.setting.g;

import com.larus.platform.api.g1;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class q implements g1.c {
    public final /* synthetic */ DoraObricGSettingsFragment a;
    public final /* synthetic */ String b;

    public final void onSettingPageReturn() {
    }

    public final void onGoSettingsDialogShow() {
        g49.d.d("DoraObricGSettingsFragment", "permission onGoSettingsDialogShow");
    }

    public final void onGoSettingsDialogDismiss(boolean r3) {
        g49.d.d("DoraObricGSettingsFragment", "permission onGoSettingsDialogDismiss isConfirmed=" + r3);
        if (r3 == true) goto L6;
        DoraObricGSettingsFragment r4 = this.a;
        int r0 = DoraObricGSettingsFragment.m;
        r4.aa0().stopReconnect();
        return;
    }

    public q(DoraObricGSettingsFragment r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onResult(boolean r1, List<String> r2, List<String> r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "grantedList");
        Intrinsics.checkNotNullParameter(r3, "deniedList");
        g49.d.d("DoraObricGSettingsFragment", "permission onResult allGranted=" + r1);
        if (r1 == false) goto L5;
        DoraObricGSettingsFragment r5 = this.a;
        String r6 = this.b;
        int r7 = DoraObricGSettingsFragment.m;
        r5.X90(r6);
        return;
    L5:
        DoraObricGSettingsFragment r8 = this.a;
        int r9 = DoraObricGSettingsFragment.m;
        r8.aa0().stopReconnect();
    }
}
