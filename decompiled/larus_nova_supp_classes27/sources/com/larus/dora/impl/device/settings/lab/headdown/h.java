package com.larus.dora.impl.device.settings.lab.headdown;

import com.larus.common_ui.dialog.p0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class h implements p0 {
    public final /* synthetic */ HeadDownDetectionFragment a;

    @Override // com.larus.common_ui.dialog.p0
    public final void confirm() {
        HeadDownDetectionFragment r0 = this.a;
        int r1 = HeadDownDetectionFragment.i;
        r0.X90().onNeedWearDialogConfirmed();
    }

    public h(HeadDownDetectionFragment r1) {
        this.a = r1;
    }
}
