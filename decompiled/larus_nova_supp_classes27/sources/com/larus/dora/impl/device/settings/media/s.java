package com.larus.dora.impl.device.settings.media;

import com.larus.common_ui.dialog.p0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class s implements p0 {
    public final /* synthetic */ p0 a;

    @Override // com.larus.common_ui.dialog.p0
    public final void confirm() {
        p0 r0 = this.a;
        if (r0 == null) goto L6;
        r0.confirm();
        return;
    }

    public s(p0 r1) {
        this.a = r1;
    }
}
