package com.larus.dora.obric.device_management.device_bind;

import com.larus.dora.impl.onboarding.p0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class w implements p0 {
    public final /* synthetic */ DoraObricSmartDeviceBindFragment a;

    @Override // com.larus.dora.impl.onboarding.p0
    public final void onCloseButtonClick() {
    }

    public w(DoraObricSmartDeviceBindFragment r1) {
        this.a = r1;
    }

    @Override // com.larus.dora.impl.onboarding.p0
    public final void a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "promptType");
        DoraObricSmartDeviceBindFragment r4 = this.a;
        int r0 = DoraObricSmartDeviceBindFragment.v;
        r4.getClass();
        r4.aa0("check_from_main", new n(r4));
    }
}
