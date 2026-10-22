package com.larus.dora.impl.dynamic;

import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModelV2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class s0 implements com.larus.common_ui.dialog.p0 {
    public final /* synthetic */ DoraDynamicFragment a;
    public final /* synthetic */ DoraDevice b;

    @Override // com.larus.common_ui.dialog.p0
    public final void confirm() {
        DoraDynamicFragment r0 = this.a;
        int r1 = DoraDynamicFragment.C;
        DoraDynamicViewModelV2 r2 = r0.ba0();
        if (r2 == null) goto L6;
        r2.replaceBind(this.b);
        return;
    }

    public s0(DoraDynamicFragment r1, DoraDevice r2) {
        this.a = r1;
        this.b = r2;
    }
}
