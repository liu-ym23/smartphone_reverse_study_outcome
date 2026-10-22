package com.larus.dora.impl.nl;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class x0 implements com.larus.common_ui.dialog.p0 {
    public final /* synthetic */ Function0<Unit> a;

    @Override // com.larus.common_ui.dialog.p0
    public final void confirm() {
        g49.d.d("ProactiveSettingsFragment", "showHeadControlDisableDialog: go to settings clicked");
        this.a.invoke();
    }

    public x0(c0 r1) {
        this.a = r1;
    }
}
