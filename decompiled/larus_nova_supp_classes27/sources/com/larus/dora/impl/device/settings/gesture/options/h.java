package com.larus.dora.impl.device.settings.gesture.options;

import com.larus.common_ui.dialog.p0;
import com.larus.dora.impl.device.settings.gesture.DoraGGestureSettings;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class h implements p0 {
    public final /* synthetic */ DoraGOptionsFragment a;
    public final /* synthetic */ DoraGGestureSettings b;

    @Override // com.larus.common_ui.dialog.p0
    public final void confirm() {
        DoraGOptionsFragment r0 = this.a;
        int r1 = DoraGOptionsFragment.i;
        r0.X90().updateGestureFunction(this.b);
    }

    public h(DoraGOptionsFragment r1, DoraGGestureSettings r2) {
        this.a = r1;
        this.b = r2;
    }
}
