package com.larus.common.mssdk.impl;

import com.larus.common_ui.dialog.p0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class p implements p0 {
    public final /* synthetic */ SecurityServiceImpl a;

    @Override // com.larus.common_ui.dialog.p0
    public final void confirm() {
        this.a.t(false, true);
    }

    public p(SecurityServiceImpl r1) {
        this.a = r1;
    }
}
