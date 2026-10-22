package com.larus.avlink.env.diary;

import android.os.Bundle;
import android.view.View;
import com.bytedance.router.SmartRouter;
import kotlin.jvm.internal.Intrinsics;
import v19.c6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class q extends c6 {
    public final /* synthetic */ DoraEnvObserveDiaryListFragment c;

    public q(DoraEnvObserveDiaryListFragment r1) {
        this.c = r1;
    }

    public final void a(View r3) {
        Intrinsics.checkNotNullParameter(r3, "v");
        com.bytedance.router.i r4 = SmartRouter.buildRoute(this.c.getContext(), "//flow/dora/env_auth");
        Bundle r0 = this.c.getArguments();
        r4.c.putExtras(r0);
        r4.d();
    }
}
