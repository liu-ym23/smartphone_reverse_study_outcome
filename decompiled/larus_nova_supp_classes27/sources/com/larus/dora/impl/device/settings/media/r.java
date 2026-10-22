package com.larus.dora.impl.device.settings.media;

import com.larus.platform.api.g1;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class r implements g1.c {
    public final /* synthetic */ MediaSettingsFragment a;

    public final void onGoSettingsDialogDismiss(boolean r1) {
    }

    public final void onGoSettingsDialogShow() {
    }

    public final void onSettingPageReturn() {
    }

    public r(MediaSettingsFragment r1) {
        this.a = r1;
    }

    public final void onResult(boolean r2, List<String> r3, List<String> r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "grantedList");
        Intrinsics.checkNotNullParameter(r4, "deniedList");
        g49.d.d("MediaSettingsFragment", "permissionRecordLocation result allGranted=" + r2 + " deniedSize=" + r4.size() + " goSettingsShown=" + r5);
        MediaSettingsFragment r6 = this.a;
        int r7 = MediaSettingsFragment.h;
        r6.Z90().onRecordLocationPermissionResult(r2);
    }
}
