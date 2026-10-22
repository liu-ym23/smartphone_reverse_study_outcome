package com.larus.dora.impl.device.settings.lab.env;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import r49.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class l implements a {
    public /* synthetic */ l() {
    }

    public final void a(long r8, Function0 r10) {
        Intrinsics.checkNotNullParameter(r10, "action");
        BuildersKt.launch$default(DoraEnvObserveManager.d, null, null, new DoraEnvObserveManager$mTemporaryOverrideController$2$2$1(r8, r10, null), 3, null);
    }
}
