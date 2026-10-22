package com.larus.dora.impl.device.settings.gesture.options;

import com.larus.common_ui.dialog.p0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class j implements p0 {
    public final /* synthetic */ DoraGOptionsFragment a;
    public final /* synthetic */ p b;

    @Override // com.larus.common_ui.dialog.p0
    public final void confirm() {
        DoraGOptionsFragment r0 = this.a;
        int r1 = DoraGOptionsFragment.i;
        r0.X90().applyQuickControlGuide(this.b.c);
    }

    public j(DoraGOptionsFragment r1, p r2) {
        this.a = r1;
        this.b = r2;
    }
}
