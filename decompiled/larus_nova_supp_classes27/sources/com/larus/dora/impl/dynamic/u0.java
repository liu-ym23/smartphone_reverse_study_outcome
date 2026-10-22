package com.larus.dora.impl.dynamic;

import com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModelV2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class u0 implements com.larus.common_ui.dialog.p0 {
    public final /* synthetic */ DoraDynamicFragment a;
    public final /* synthetic */ d59.b b;

    @Override // com.larus.common_ui.dialog.p0
    public final void confirm() {
        int r0 = j49.a.a;
        j49.a.h();
        DoraDynamicFragment r1 = this.a;
        int r2 = DoraDynamicFragment.C;
        DoraDynamicViewModelV2 r3 = r1.ba0();
        d59.b r4 = this.b;
        if (r4 == null) goto L5;
        z49.b r5 = r4.a;
    L6:
        r3.onlyLocalUnbind(r5);
        return;
    L5:
        r5 = null;
        goto L6
    }

    public u0(DoraDynamicFragment r1, d59.b r2) {
        this.a = r1;
        this.b = r2;
    }
}
