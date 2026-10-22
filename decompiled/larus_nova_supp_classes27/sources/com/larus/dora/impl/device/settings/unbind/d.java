package com.larus.dora.impl.device.settings.unbind;

import com.larus.common_ui.dialog.p0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class d implements p0 {
    public final /* synthetic */ DoraUnbindFragment a;

    @Override // com.larus.common_ui.dialog.p0
    public final void confirm() {
        int r0 = j49.a.a;
        j49.a.h();
        ((DoraUnbindViewModel) this.a.h.getValue()).unbind();
    }

    public d(DoraUnbindFragment r1) {
        this.a = r1;
    }
}
