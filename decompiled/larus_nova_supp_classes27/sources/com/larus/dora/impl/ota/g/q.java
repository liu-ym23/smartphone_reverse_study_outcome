package com.larus.dora.impl.ota.g;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.router.SmartRouter;
import com.larus.common_ui.dialog.p0;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class q implements p0 {
    public final /* synthetic */ Context a;
    public final /* synthetic */ DoraGOTAFragment b;

    @Override // com.larus.common_ui.dialog.p0
    public final void confirm() {
        com.bytedance.router.i r0 = SmartRouter.buildRoute(this.a, "//flow/dora/wifi_settings");
        Bundle r1 = com.larus.utils.f.c(new Pair[0]);
        by7.h.k(r1, this.b);
        r0.c.putExtras(r1);
        r0.d();
    }

    public q(Context r1, DoraGOTAFragment r2) {
        this.a = r1;
        this.b = r2;
    }
}
