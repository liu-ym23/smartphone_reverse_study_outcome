package com.larus.dora.impl.device_v2;

import com.larus.dora.impl.onboarding.p0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class d0 implements p0 {
    public final /* synthetic */ DoraSmartDeviceBindFragment a;

    @Override // com.larus.dora.impl.onboarding.p0
    public final void onCloseButtonClick() {
    }

    public d0(DoraSmartDeviceBindFragment r1) {
        this.a = r1;
    }

    @Override // com.larus.dora.impl.onboarding.p0
    public final void a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "promptType");
        DoraSmartDeviceBindFragment r4 = this.a;
        if (r4.g == null) goto L6;
        r4.X90("check_from_MAIN", new c0(r4));
        return;
    }
}
