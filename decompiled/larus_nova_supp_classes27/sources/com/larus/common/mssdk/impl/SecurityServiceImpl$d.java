package com.larus.common.mssdk.impl;

import com.larus.common_ui.dialog.p0;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class SecurityServiceImpl$d implements p0 {
    public final /* synthetic */ SecurityServiceImpl a;
    public final /* synthetic */ Function0<Unit> b;

    @Override // com.larus.common_ui.dialog.p0
    public final void confirm() {
        this.a.h = true;
        this.b.invoke();
    }

    public SecurityServiceImpl$d(SecurityServiceImpl r1, Function0<Unit> r2) {
        this.a = r1;
        this.b = r2;
    }
}
