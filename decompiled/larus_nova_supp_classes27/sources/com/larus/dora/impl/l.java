package com.larus.dora.impl;

import g49.d;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class l implements Function1 {
    public /* synthetic */ l() {
    }

    public final Object invoke(Object r7) {
        boolean r8 = ((Boolean) r7).booleanValue();
        d.d("DoraPreWakeUpTask", "userConfirmShare " + r8);
        if (r8 == false) goto L7;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new DoraPreWakeUpTask$Companion$checkToShowDialog$1$1(null), 3, null);
        return Unit.INSTANCE;
    L7:
        return Unit.INSTANCE;
    }
}
