package com.larus.dora.impl.device.settings.media;

import com.larus.platform.api.g1;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class q implements g1.c {
    public final /* synthetic */ MediaSettingsFragment a;

    public final void onGoSettingsDialogDismiss(boolean r1) {
    }

    public final void onGoSettingsDialogShow() {
    }

    public final void onSettingPageReturn() {
    }

    public q(MediaSettingsFragment r1) {
        this.a = r1;
    }

    public final void onResult(boolean r1, List<String> r2, List<String> r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "grantedList");
        Intrinsics.checkNotNullParameter(r3, "deniedList");
        MediaSettingsFragment r5 = this.a;
        int r6 = MediaSettingsFragment.h;
        r5.Z90().onLocalPermissionResult(r1);
    }
}
