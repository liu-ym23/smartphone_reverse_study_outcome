package com.obric.aikernel.runtime;

import android.os.Bundle;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
final class VmEngine$vmExecuteRaw$2 extends Lambda implements Function1<Bundle, Unit> {
    public static final VmEngine$vmExecuteRaw$2 INSTANCE = null;

    static {
        INSTANCE = new VmEngine$vmExecuteRaw$2();
    }

    VmEngine$vmExecuteRaw$2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Bundle r10) {
        invoke2(r10);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Bundle r10) {
        Intrinsics.checkNotNullParameter(r10, "it");
    }
}
